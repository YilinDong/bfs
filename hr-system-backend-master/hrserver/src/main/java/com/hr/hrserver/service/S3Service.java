package com.hr.hrserver.service;

import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.*;

public class S3Service {

    String region = "US_EAST_2";
    String bucket_name = "bfsteamproject";
    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(region).build();


    public ByteArrayOutputStream getFromS3(String key_name) {
        System.out.format("Downloading %s from S3 bucket %s...\n", key_name, bucket_name);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            S3Object o = s3.getObject(bucket_name, key_name);
            S3ObjectInputStream s3is = o.getObjectContent();
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                outputStream.write(read_buf, 0, read_len);
            }
            s3is.close();
            outputStream.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return outputStream;
    }

    public void putToS3(int uid, File file, String key){
        try {
            s3.putObject(bucket_name, uid + "/" + key, file);
        }
        catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }


}
