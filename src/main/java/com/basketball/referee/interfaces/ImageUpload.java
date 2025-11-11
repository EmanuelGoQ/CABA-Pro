package com.basketball.referee.interfaces;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ImageUpload {
    String uploadPhoto(MultipartFile file) throws IOException;
}