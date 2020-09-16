package com.kitchen.osstest.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AliyunOssUtil {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketVideo}")
    private String bucketVideo;

    @Value("${aliyun.oss.bucketImg}")
    private String bucketImg;

//    @Value("${aliyun.oss.flag}")
    private String flag;

    private OSS ossClient;

    private OSS getInstance() {
        if(ossClient==null){
            synchronized(AliyunOssUtil.class){
                if(ossClient==null){
                    ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                }
            }
        }
        return ossClient;
    }

    /**
     * 上传
     */
    public PutObjectResult upload(InputStream file, String fileName, String type){
        if(type.equals("img")){
            return getInstance().putObject(bucketImg,fileName,file);
        }else if(type.equals("video")) {
            return getInstance().putObject(bucketVideo,fileName,file);
        }
        return null;
    }

    /**
     * 下载
     */
   public void downLoad(String objectName) throws IOException {
       OSS client = getInstance();

       // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
       client.getObject(new GetObjectRequest(bucketImg, objectName), new File("1.jpeg"));
        // 关闭OSSClient。
       client.shutdown();
   }

    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null){ break;}

            System.out.println("\t" + line);
        }
        System.out.println();

        reader.close();
    }



}