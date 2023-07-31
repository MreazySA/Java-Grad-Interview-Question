package com.eviro.assessment.grad001.ReasonSithole.service;

import com.eviro.assessment.grad001.ReasonSithole.model.AccountProfile;
import com.eviro.assessment.grad001.ReasonSithole.repository.AccountProfileRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.util.Base64;

@Service
public class FileParserImp implements FileParser {

    private AccountProfileRepository accountProfileRepository;

    public FileParserImp(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @Override
    public void parseCSV(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                String surname = fields[1];
                String imageFormat = fields[2];
                String base64ImageData = fields[3];

                // Convert base64ImageData to binary image data
                byte[] imageData = Base64.getDecoder().decode(base64ImageData);

                // Create an AccountProfile object with the retrieved data
                AccountProfile accountProfile = new AccountProfile();
                accountProfile.setName(name);
                accountProfile.setSurname(surname);
                accountProfile.setImageFormat(imageFormat);
                accountProfile.setImageData(imageData);

                // Store the records into the database
                accountProfileRepository.save(accountProfile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public File convertCSVDataToImage(String base64ImageData) throws IOException {
        byte[] imageData = Base64.getDecoder().decode(base64ImageData);
        String imageFileName = "output_image.png";
        // Placing images in resources/images folder
        File imageFile = new File("src/main/resources/images/" + imageFileName);
        FileOutputStream outputStream = new FileOutputStream(imageFile);
        outputStream.write(imageData);
        outputStream.close();
        return imageFile;
    }
    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }
}

