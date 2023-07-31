package com.eviro.assessment.grad001.ReasonSithole.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public interface FileParser {

    void parseCSV(File csvFile);
    File convertCSVDataToImage(String base64ImageData)  throws IOException;
    URI createImageLink(File fileImage);
}
