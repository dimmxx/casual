package com.mycompany;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class App {

    private static String SUFFIX = "/";

    public static void main(String[] args) {

//        AWSCredentials credentials = new BasicAWSCredentials("WT3J3H6V2Y4UJ7X2CGUG", "AQnnaF1OwIB87Gu1kXhX99i4jnWUAPlVkw5KHOZhCtA");
//        AmazonS3 s3client = new AmazonS3Client(credentials);
//        s3client.setEndpoint("fra1.digitaloceanspaces.com");
//
//        String bucketName = "fttx-files";
//        s3client.createBucket(bucketName);
//
//        for (Bucket bucket : s3client.listBuckets()) {
//            System.out.println(" - " + bucket.getName());
//        }

        AWSCredentials credentials = new BasicAWSCredentials("WT3J3H6V2Y4UJ7X2CGUG", "AQnnaF1OwIB87Gu1kXhX99i4jnWUAPlVkw5KHOZhCtA");

        AmazonS3 s3client = new AmazonS3Client(credentials);
        s3client.setEndpoint("fra1.digitaloceanspaces.com");

        //String bucketName = "fttx-files1";
        //s3client.createBucket(bucketName);

        //for (Bucket bucket : s3client.listBuckets()) {
            //System.out.println(" - " + bucket.getName());
        //}

        System.out.println(s3client.listBuckets());
        s3client.putObject(new PutObjectRequest("fttx-files/folder1", "newFile",
                new File("/Users/mint/Documents/inner-classes.png"))
                .withCannedAcl(CannedAccessControlList.Private));

        createFolder("fttx-files", "folder1", s3client);


    }

    public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                folderName + SUFFIX, emptyContent, metadata);
        client.putObject(putObjectRequest);
    }

    //    public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
//        List fileList =
//                client.listObjects(bucketName, folderName).getObjectSummaries();
//        for (S3ObjectSummary file : fileList) {
//            client.deleteObject(bucketName, file.getKey());
//        }
//        client.deleteObject(bucketName, folderName);
//    }



}



