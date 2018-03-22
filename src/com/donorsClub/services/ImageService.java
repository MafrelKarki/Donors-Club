package com.donorsClub.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.Part;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
/**
 * @since 3/21/2018
 * @author Mafrel
 * uploading image into aws s3 bucket
 */
public class ImageService {

  public String imageUploader(String name, Part profilePicturePart) throws IOException {
    String resultStr = null;
    try {
      String[] filExt = getFileName(profilePicturePart).split("\\.");
     // String filename = name + "." + filExt[1];
      String contentType = profilePicturePart.getContentType();
      AWSCredentials credentials = new BasicAWSCredentials("AKIAI2KD64INO6344H4Q",
          "X0/m6czY0pfRQ4HWD8GbMQjnsua+xHm8EWWLHS5O");

      AmazonS3 s3client = AmazonS3ClientBuilder.standard()
          .withCredentials(new AWSStaticCredentialsProvider(credentials))
          .withRegion(Regions.US_EAST_2).build();

      List<Bucket> buckets = s3client.listBuckets();

      ObjectMetadata meta = new ObjectMetadata();

      byte[] bytes = IOUtils.toByteArray(profilePicturePart.getInputStream());
      meta.setContentLength(bytes.length);
      meta.setContentType(contentType);
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

      PutObjectRequest objectPutRequest =
          new PutObjectRequest(buckets.get(0).getName(), getFileName(profilePicturePart), byteArrayInputStream, meta);
      objectPutRequest.setCannedAcl(CannedAccessControlList.PublicRead);
      s3client.putObject(objectPutRequest);

      resultStr = String.valueOf(s3client.getUrl(buckets.get(0).getName(), getFileName(profilePicturePart)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return resultStr;
  }

  public String getFileName(Part part) {
    for (String content : part.getHeader("content-disposition").split(";")) {
      if (content.trim().startsWith("filename")) {
        return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
      }
    }
    return null;
  }
}
