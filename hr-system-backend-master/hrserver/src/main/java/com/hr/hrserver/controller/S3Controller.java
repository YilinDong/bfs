package com.hr.hrserver.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;

import com.hr.hrserver.service.S3Service;
import org.springframework.http.ResponseEntity;

public class S3Controller {

    S3Service s3Service = new S3Service();

    //path : uid/key
    public ResponseEntity downloadFromS3(String path){
        String key = path.split("/")[1];
        ByteArrayOutputStream byteArrayOutputStream = s3Service.getFromS3(path);
        return ResponseEntity.ok()
                .header("filename=\""+key+"\"")
                .body(byteArrayOutputStream.toByteArray());
    }

    public void uploadToS3(int uid, File file){
        String key = file.getName();
        s3Service.putToS3(uid, file, key);
    }

}
