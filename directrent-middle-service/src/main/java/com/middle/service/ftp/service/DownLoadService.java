package com.middle.service.ftp.service;

import com.middle.service.ftp.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 文件下载
 * @author: YX
 * @date: 2020/10/13 14:58
 */
@Service
public class DownLoadService {

    @Autowired
    private FtpUtil ftpUtil;

    /**
     * 下载单个文件
     *
     * @param: filename
     * @param: localPath
     * @return: java.util.Map<java.lang.String, java.lang.String>
     * @author: YX
     * @date: 2020/10/13 14:59
     */
    public Map<String, String> downFile(String filename, String localPath) throws IOException {
        Map<String, String> map = new HashMap<>(3);
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