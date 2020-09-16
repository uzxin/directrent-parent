package com.middle.service.qiniu.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/15 22:06
 */
public class Upload {

    public static void main(String[] args) throws InterruptedException {
        File[] files = getFile("C:\\Users\\Administrator\\Desktop\\upload");
        for (int i = 0; i < files.length; i++) {
            upload(files[i].getPath(), " /house/"+files[i].getName());
            Thread.sleep(100);
        }
    }


    public static void upload(String filePath, String key){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "PABTek4Oh6ybAdGmw3fEtz4s3JeELRsYECtKTxY9";
        String secretKey = "aA67coLF_prIOd4eZ0jZyd_mSSClt24OXhljwl_H";
        String bucket = "directrent";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //String key = "/house/2e9504572ad04de4ae64959f0a94c3a6.png";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("上传成功,key:"+putRet.key+",hash:"+putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    public static File[] getFile(String path) {
        File file = new File(path);
        //获取路径下的所有文件
        File[] files = file.listFiles();
        return files;
    }
}