package org.springframework.samples.petclinic.util;

import java.io.FileWriter;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class FileUtility {

    void generateReport(String content) throws Exception {
        FileWriter fwriter = new FileWriter("~/Downloads/report.csv");
        fwriter.write(content);
        fwriter.close();
    }

    public AmazonS3 getS3Client() {
        AmazonS3 s3client;
        AWSCredentials creds = new BasicAWSCredentials(System.getenv("AWS_S3_ACCESS_KEY"), System.getenv("AWS_S3_SECRET_KEY"));
        s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).withRegion(System.getenv("AWS_S3_CLIENT_REGION")).build();
        return s3client;
    }

    public URL uploadS3ObjectAndGetUrl(String bktName, String uploadContentPath, String keyName) {
        AmazonS3 s3client = getS3Client();
        s3client.putObject(new PutObjectRequest(bktName, keyName, new File(uploadContentPath)));
        return s3client.getUrl(bktName, keyName);
    }
}
