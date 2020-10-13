package com.middle.service.ftp.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @description: FTP工具类
 * @author: YX
 * @date: 2020/10/12 14:44
 */
@Component
@Slf4j
public class FtpUtil {
    //ftp服务器ip地址
    @Value("${ftp.host}")
    private String FTP_ADDRESS;
    //端口号
    @Value("${ftp.port}")
    private int FTP_PORT;
    //用户名
    @Value("${ftp.username}")
    private String FTP_USERNAME;
    //密码
    @Value("${ftp.password}")
    private String FTP_PASSWORD;
    //路径
    @Value("${ftp.base-path}")
    public String FTP_BASEPATH;

    /**
     * 上传文件
     *
     * @param: path 上传路径
     * @param: originFileName 文件名
     * @param: input 输入流
     * @return: boolean
     * @author: YX
     * @date: 2020/10/12 17:44
     */
    public boolean uploadFile(String path, String originFileName, InputStream input) {
        boolean success = true;
        FTPClient ftp = new FTPClient();
        try {
            // 连接FTP服务器
            ftp.connect(FTP_ADDRESS, FTP_PORT);
            // 登录
            boolean login_flag = ftp.login(FTP_USERNAME, FTP_PASSWORD);
            if (!login_flag){
                log.error("FTP登录失败,服务器{},端口{},用户名{},密码{}",FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_PASSWORD);
            }
            //连接成功会的到一个返回状态码
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                log.error("FTP服务器拒绝连接,返回状态码{},服务器{},端口{},用户名{},密码{}",reply,FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_PASSWORD);
                success = false;
            }
            //启动被动模式
            ftp.enterLocalPassiveMode();
            //设置编码
            ftp.setControlEncoding("utf-8");
            // 设置文件类型为二进制
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 修改操作空间
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            // 传输文件为流的形式
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            //检查上传路径是否存在
            if(path.startsWith("/")){
                path = path.substring(1);
            }
            if(!ftp.changeWorkingDirectory(FTP_BASEPATH+path)) {
                //throw new RuntimeException("上传目录不存在："+FTP_BASEPATH+path);
                log.error("上传目录不存在，开始创建目录：{}", FTP_BASEPATH+path);
                String[] dirs = path.split("/");
                //创建目录
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    //判断是否存在目录
                    if (!ftp.changeWorkingDirectory(dir)) {
                        //不存在则创建
                        if (!ftp.makeDirectory(dir)) {
                            log.error("子目录创建失败,目录名称：{}", dir);
                            throw new RuntimeException("子目录创建失败");
                        }
                        //进入新创建的目录
                        ftp.changeWorkingDirectory(dir);
                    }
                }
            }
            String workingDirectory = ftp.printWorkingDirectory();
            log.info("FTP开始上传文件====上传路径：{},文件名:{}", workingDirectory,originFileName);
            boolean upload_flag = ftp.storeFile(originFileName, input);
            if (!upload_flag){
                log.error("FTP上传文件失败====上传路径：{}，文件：{}", workingDirectory,originFileName);
                success = false;
            }else {
                log.info("上传成功=====上传路径：{},文件名:{}", workingDirectory,originFileName);
            }
            input.close();
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * 下载文件
     *
     * @param: filename 文件名
     * @param: localPath 要下载的路径
     * @return: boolean
     * @author: YX
     * @date: 2020/10/12 17:45
     */
    public boolean downloadFile(String filename,String localPath) {
        FTPClient ftp=new FTPClient();
        try {
            ftp.connect(FTP_ADDRESS, FTP_PORT);
            ftp.login(FTP_USERNAME, FTP_PASSWORD);
            //设置文件编码格式
            ftp.setControlEncoding("UTF-8");
            //ftp通信有两种模式
            //PORT(主动模式)客户端开通一个新端口(>1024)并通过这个端口发送命令或传输数据,期间服务端只使用他开通的一个端口，例如21
            //PASV(被动模式)客户端向服务端发送一个PASV命令，服务端开启一个新端口(>1024),并使用这个端口与客户端的21端口传输数据
            //由于客户端不可控，防火墙等原因，所以需要由服务端开启端口，需要设置被动模式
            ftp.enterLocalPassiveMode();
            //设置传输方式为流方式
            ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            //获取状态码，判断是否连接成功
            if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                throw new RuntimeException("FTP服务器拒绝连接");
            }
            //获取文件的路径
            String path = "";
            int index=filename.lastIndexOf("/");
            if (-1 != index){
                path=filename.substring(0, index);
            }
            //获取文件名
            String name=filename.substring(index+1);
            //判断是否存在目录
            if(!ftp.changeWorkingDirectory(FTP_BASEPATH+path)) {
                throw new RuntimeException("文件路径不存在："+FTP_BASEPATH+path);
            }
            //获取该目录所有文件
            FTPFile[] files=ftp.listFiles();
            if (null == files || files.length == 0){
                throw new RuntimeException("该目录下没有任何文件："+FTP_BASEPATH+path);
            }
            Boolean flag = false;
            for (FTPFile file : files) {
                if(file.getName().equals(name)) {
                    //如果找到，将目标文件复制到本地
                    File localFile =new File(localPath+"/"+file.getName());
                    log.info("文件下载成功，服务器路径：{}，目标路径：{}",FTP_BASEPATH+path+"/"+file.getName(),localPath+"/"+file.getName());
                    OutputStream out=new FileOutputStream(localFile);
                    ftp.retrieveFile(file.getName(), out);
                    out.close();
                    flag = true;
                }
            }
            ftp.logout();
            if (!flag){
                log.error("没有找到该文件,服务器路径：{}",FTP_BASEPATH+path+"/"+name);
            }
            return flag;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
