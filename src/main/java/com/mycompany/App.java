package com.mycompany;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.*;

public class App {

    private static final String SUFFIX = "/";

    public static void main(String[] args) throws IOException {

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

        //createFolder("fttx-files", "folder1", s3client);


        S3Object fullObject = s3client.getObject(new GetObjectRequest("fttx-files/folder1", "newFile"));

        System.out.println(fullObject.getObjectMetadata().getContentType());



        InputStream is = fullObject.getObjectContent();



        File targetFile = new File("newFile.png");
        OutputStream outStream = new FileOutputStream(targetFile);

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        outStream.close();
        is.close();

    }


    public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                folderName + SUFFIX, emptyContent, metadata);
        client.putObject(putObjectRequest);
    }


}



