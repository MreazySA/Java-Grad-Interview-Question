package com.eviro.assessment.grad001.ReasonSithole.controller;

import com.eviro.assessment.grad001.ReasonSithole.model.AccountProfile;
import com.eviro.assessment.grad001.ReasonSithole.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.ReasonSithole.service.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.URI;


@RestController
@RequestMapping("v1/api/image")//end points for testing
public class ImageController {

    private final FileParser fileParser;
    private final AccountProfileRepository accountProfileRepository;


    //Constructor
    public ImageController(FileParser fileParser, AccountProfileRepository accountProfileRepository) {
        this.fileParser = fileParser;
        this.accountProfileRepository = accountProfileRepository;
    }

    @GetMapping("/{name}/{surname}/{imageName:.+}")////end points for testing for gethttpImageLink
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname,
                                               @PathVariable String imageName) {
        // Fetch the AccountProfile from the database based on the name and surname.
        AccountProfile accountProfile = accountProfileRepository.findBynameAndSurname(name, surname);
        if (accountProfile != null) {
            File imageFile = new File("/images");
            URI imageLink = fileParser.createImageLink(imageFile);
            return new FileSystemResource(imageFile);
        } else {
            return null;
        }
    }
}