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
        log.info("FTP开始上传文件，文件名:{}", originFileName);
        boolean success = true;
        FTPClient ftp = new FTPClient();
        //设置编码
        ftp.setControlEncoding("utf-8");
        //启动被动模式
        ftp.enterLocalPassiveMode();
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
            //转到上传文件的根目录
            if(!ftp.changeWorkingDirectory(FTP_BASEPATH)) {
                throw new RuntimeException("根目录不存在，需要创建");
            }
            // 设置文件类型为二进制
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 修改操作空间
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            // 传输文件为流的形式
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            //判断是否存在目录,不存在则创建（但是目前的ftp账号好像没有权限创建目录）
            /*if(!ftp.changeWorkingDirectory(path)) {
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
            }*/
            // 开始上传文件
            boolean upload_flag = ftp.storeFile(originFileName, input);
            if (!upload_flag){
                log.error("FTP上传文件失败");
                success = false;
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

            int index=filename.lastIndexOf("/");
            //获取文件的路径
            String path=filename.substring(0, index);
            System.out.println("path:"+path);
            //获取文件名
            String name=filename.substring(index+1);
            System.out.println("name:"+name);
            //判断是否存在目录
            if(!ftp.changeWorkingDirectory(FTP_BASEPATH+path)) {
                throw new RuntimeException("文件路径不存在："+FTP_BASEPATH+path);
            }
            //获取该目录所有文件
            FTPFile[] files=ftp.listFiles();
            for (FTPFile file : files) {
                //判断是否有目标文件
                //System.out.println("文件名"+file.getName()+"---"+name);
                if(file.getName().equals(name)) {
                    //如果找到，将目标文件复制到本地
                    File localFile =new File(localPath+"/"+file.getName());
                    OutputStream out=new FileOutputStream(localFile);
                    ftp.retrieveFile(file.getName(), out);
                    out.close();
                }
            }
            ftp.logout();
            return true;
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
