package com.vinteg.vinteg_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileValidationService {

    public boolean isImageFile(MultipartFile file) {
        String mimeType = file.getContentType();
        return mimeType != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/jpg"));
    }
}
