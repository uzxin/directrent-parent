package com.directrent;

import com.directrent.house.dao.HouseBaseInfoDao;
import com.directrent.house.domain.HouseBaseInfo;
import com.directrent.house.service.HouseBaseInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/03 22:14
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HouseBaseInfoTest {

    @Autowired
    private HouseBaseInfoDao houseBaseInfoDao;
    @Autowired
    private HouseBaseInfoService houseBaseInfoService;

    @Test
    public void test1(){
        List<HouseBaseInfo> datas = houseBaseInfoDao.getAll();
        System.out.println(datas.size());
    }

    @Test
    public void test2(){
        List<HouseBaseInfo> datas = houseBaseInfoService.list();
        System.out.println(datas.size());
    }

    @Test
    public void test3(){
        HouseBaseInfo houseBaseInfo = houseBaseInfoDao.selectById(751197077976727552L);
        System.out.println(houseBaseInfo);
    }

    @Test
    public void test4(){
    }
}