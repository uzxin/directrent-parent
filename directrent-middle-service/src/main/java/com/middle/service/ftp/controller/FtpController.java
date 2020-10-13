package com.middle.service.ftp.controller;

import com.middle.service.ftp.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.middle.service.ftp.service.DownLoadService;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @description:
 * @author: YX
 * @date: 2020/10/12 14:58
 */
@RestController
@RequestMapping("test")
public class FtpController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private DownLoadService downLoadService;

    @PostMapping("/upload")
    public Map<String, String> uploadfile(String path,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        return uploadService.upfile(path, file, request);
    }

    @GetMapping("/down")
    public Map<String, String> downFile(String filename, String localPath) throws IOException {
        localPath = "C:\\Users\\游鑫\\Desktop";
        return downLoadService.downFile(filename, localPath);
    }

}