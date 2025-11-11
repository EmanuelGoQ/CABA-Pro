package com.basketball.referee.config;

import com.basketball.referee.interfaces.ImageUpload;
import com.basketball.referee.util.ImageLocalUpload;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceProvider {
    @Bean
    public ImageUpload imageUpload() {
        return new ImageLocalUpload();
    }
}
