package com.directrent;

import com.directrent.common.exception.ExcelException;
import com.directrent.common.utils.UUIDUtil;
import com.directrent.common.utils.WorkerUtil;
import com.directrent.common.utils.excel.ExcelUtil;
import com.directrent.excelData.dao.mapper.ExcelMapper;
import com.directrent.excelData.domain.Excel;
import com.directrent.excelData.dto.ExcelDataDTO;
import com.directrent.house.dao.HouseBaseInfoDao;
import com.directrent.house.dao.extmapper.ExtHouseBaseInfoMapper;
import com.directrent.house.dao.mapper.HouseImageMapper;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.domain.HouseImage;
import com.directrent.house.service.HouseBaseInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 房源图片导入
 * @author: YX
 * @date: 2020/09/10 21:22
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HouseImageImport {

    @Autowired
    private HouseBaseInfoService houseBaseInfoService;
    @Autowired
    private ExcelMapper excelMapper;
    @Autowired
    private HouseImageMapper houseImageMapper;
    @Autowired
    private HouseBaseInfoDao houseBaseInfoDao;

    @Test
    public void image() throws IOException {
        String filePath = "C:\\Users\\Administrator\\Desktop\\house_pics";
        //String filePath = "C:\\Users\\Administrator\\Desktop\\images";
        String imagePath = "http://qgai41r93.hn-bkt.clouddn.com/house/";

        File file = new File(filePath);
        //获取一级目录下的所有二级目录
        File[] folders = file.listFiles();
        //遍历每个文件夹的图片
        for (int i = 0; i < folders.length; i++) {
            String folderName = folders[i].getName();
            //根据文件夹名字去查询
            Excel resExcel = excelMapper.getByFolder(folderName);
            if (null == resExcel){
                continue;
            }
            Long houseId = resExcel.getHouseId();
            //获取文件夹下的所有图片
            File[] images = folders[i].listFiles();
            if (null == images){
                continue;
            }
            for (int j = 0; j < images.length; j++){
                //将图片重命名
                String newName = UUIDUtil.get()+".png";
                String newPath= "C:\\Users\\Administrator\\Desktop\\house_pics\\"+folderName+"\\"+newName;
                reName(images[j].getPath(), newPath);
                //插入house_image表
                String imageUrl = imagePath + newName;
                HouseImage houseImage = new HouseImage();
                houseImage.setId(WorkerUtil.nextId());
                houseImage.setHouseId(houseId);
                houseImage.setImageUrl(imageUrl);
                houseImage.setCreateUser("system");
                houseImage.setSort(j+1);
                houseImageMapper.insertSelective(houseImage);
                //将图片复制到另外一个文件夹
                File source = new File(newPath);
                File dest = new File("C:\\Users\\Administrator\\Desktop\\upload\\"+newName);
                FileUtils.copyFile(source, dest);
            }
        }
    }


    public static void getFiles(String path) {
        File file = new File(path);
        //如果这个路径是文件夹
        if (file.isDirectory()) {
            //获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                //如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    System.out.println("目录：" + files[i].getName());
                    getFiles(files[i].getPath());
                } else {
                    System.out.println("文件：" + files[i].getName());
                }
            }
        }else {
            System.out.println("文件：" + file.getName());
        }
    }

    /**
     * 重命名
     *
     * @param: oldName 旧名字，必须包含路径
     * @param: newName 新名字，必须包含路径
     * @return: void
     * @author: YX
     * @date: 2020/9/10 0010 21:46
     */
    public static void reName(String oldName, String newName) {
        new File(oldName).renameTo(new File(newName));
    }


    /**
     * 将excel全部导入数据库
     */
    @Test
    public void test2() throws Exception {
        //读取房源id
        List<HouseBaseInfo> houseBaseInfos = houseBaseInfoDao.getAll();
        Long[] houseIds = new Long[2000];
        for (int i = 0; i < houseBaseInfos.size(); i++) {
            houseIds[i] = houseBaseInfos.get(i).getId();
        }
        //构建MultipartFile对象
        File file = new File("C:\\Users\\Administrator\\Desktop\\house_datas.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        List<ExcelDataDTO> excelDataDTOS = ExcelUtil.readFirstSheetExcel(multipartFile, ExcelDataDTO.class);
        for (int i = 0; i < excelDataDTOS.size(); i++) {
            if (null == houseIds[i]){
                throw new Exception();
            }
            excelDataDTOS.get(i).setHouseId(houseIds[i]);
        }
        int i = excelMapper.batchInsert(excelDataDTOS);
        System.out.println("插入"+i+"条数据");
    }

}