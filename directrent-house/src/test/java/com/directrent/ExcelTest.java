package com.directrent;

import com.directrent.common.exception.ExcelException;
import com.directrent.common.utils.WorkerUtil;
import com.directrent.common.utils.excel.ExcelUtil;
import com.directrent.house.dao.HouseBaseInfoDao;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.dto.HouseBaseInfoDTO;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/02 20:59
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ExcelTest {

    @Autowired
    private HouseBaseInfoDao houseBaseInfoDao;

    @Test
    public void importExcelTest() throws IOException, ExcelException {

        //构建MultipartFile对象
        File file = new File("C:\\Users\\Administrator\\Desktop\\111.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        List<HouseBaseInfoDTO> houseBaseInfoDTOS = ExcelUtil.readFirstSheetExcel(multipartFile, HouseBaseInfoDTO.class);
        System.out.println("从excel读出"+houseBaseInfoDTOS.size()+"条数据");

        List<HouseBaseInfo> houses = new ArrayList<>();
        for (int i = 0; i < houseBaseInfoDTOS.size() ; i++) {
            HouseBaseInfoDTO dto = houseBaseInfoDTOS.get(i);
            HouseBaseInfo house = new HouseBaseInfo();
            house.setId(WorkerUtil.nextId());//id
            house.setName(dto.getName());//名字
            house.setArea(areaConvert(dto.getArea()));//面积
            house.setTowards(dto.getTowards());//朝向
            house.setUnitType(dto.getUnitType());//户型
            house.setPosition(dto.getPosition());//位置
            house.setFloor(dto.getFloor());//楼层
            house.setElevator(elevatorConvert(dto.getElevator()));//有无电梯
            house.setBuildYear(BuileYearConvert(dto.getBuildYear()));//建造年份
            house.setDoorLockType(dto.getDoorLockType());//门锁类型
            house.setGreeningRate(greeningRateConvert(dto.getGreeningRate()));//绿化率
            house.setDescription(dto.getDescription());//描述
            house.setPrice(priceConvert(dto.getPrice()));//价格
            house.setCreateUser("excel_import");//创建人
            System.out.println("===============第"+i+"条数据组装完成");
            houses.add(house);
        }
        int i = houseBaseInfoDao.batchInsert(houses);
        System.out.println("成功导入"+i+"条数据");
    }

    /**
     * 面积转换器
     */
    public BigDecimal areaConvert(String area){
        area = area.replace("㎡", "").trim();
        return new BigDecimal(area);
    }

    /**
     * 有无电梯转换器
     */
    public Byte elevatorConvert(String elevator){
        if (elevator.equals("有")){
            return 1;
        }
        return 0;
    }

    /**
     * 建造年份转换器
     */
    public Integer BuileYearConvert(String buildYear){
        if ("暂无数据".equals(buildYear)){
            return null;
        }
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(buildYear);
        return Integer.valueOf(m.replaceAll("").trim());
    }

    /**
     * 绿化率转换器
     */
    public Integer greeningRateConvert(String greeningRate){
        if ("暂无数据".equals(greeningRate)){
            return null;
        }
        greeningRate = greeningRate.replace("%", "").trim();
        return Integer.valueOf(greeningRate);
    }

    /**
     * 价格转换器
     */
    public BigDecimal priceConvert(String price){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(price);
        String s = m.replaceAll("").trim();
        return new BigDecimal(s);
    }

}