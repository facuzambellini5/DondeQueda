package com.example.dondeQueda.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {

    Map<?,?> uploadImage(MultipartFile multipartFile, String folder) throws IOException;
    boolean deleteImage(String url) throws IOException;

}
