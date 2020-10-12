package com.middle.service.ftp.service;

import com.middle.service.ftp.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/12 15:06
 */
@Service
public class UploadService {

    @Autowired
    private FtpUtil ftpUtil;

    public Map<String, String> upfile(String path, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "上传文件失败");
        String fileName = file.getOriginalFilename();//获取文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
        //文件重命名

        InputStream inputStream = file.getInputStream();
        String filePath = null;
        //关于ftp处理文件上传下载这里单独写了一个工具类ftpUtil，下面会写这个类
        //@Autowired  private FtpUtil ftpUtil;service层上面引入了这个方法。
        Boolean flag = ftpUtil.uploadFile(path, fileName, inputStream);//主要就是这里实现了ftp的文件上传
        if (flag) {
            //log.info("上传文件成功!");
            filePath = ftpUtil.FTP_BASEPATH + fileName;
            map.put("code", "1");
            map.put("msg", "上传文件成功");
        }
        map.put("path", filePath);
        System.out.println(map);
        return map;
    }

    public Map<String, String> downFile(String filename, String localPath) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "下载文件失败");
        Boolean flag = ftpUtil.downloadFile(filename, localPath);
        if (flag) {
            map.put("code", "1");
            map.put("msg", "下载文件成功");
        }
        System.out.println(map);
        return map;
    }
}