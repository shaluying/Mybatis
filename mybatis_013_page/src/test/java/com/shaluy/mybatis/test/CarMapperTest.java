package com.shaluy.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectByPage(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //获取每页显示的记录条数
        int pageSize = 3;
        //获取显示的页码（第几页）
        int pageNum = 1;
        //计算开始下标
        int startIndex = (pageNum-1) * pageSize;

        List<Car> cars = mapper.selectByPage(startIndex, pageSize);
        cars.forEach(car -> System.out.println(car));

        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 一定一定一定要注意：在执行DQL语句之前。开启分页功能。
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum,pageSize);//开启插件分页功能

        List<Car> cars = mapper.selectAll();
//        cars.forEach(car -> System.out.println(car));

        // 封装分页信息对象new PageInfo()
        // PageInfo对象是PageHelper插件提供的，用来封装分页相关的信息的对象。
        //PageInfo对象将来会存储到request域当中。在⻚⾯上展示
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);//参数一：查询结果 参数二；导航数量
        System.out.println(carPageInfo);

        /*
        PageInfo{pageNum=2, pageSize=3, size=2, startRow=4, endRow=5, total=5, pages=2,
        list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=5, pages=2, reasonable=false, pageSizeZero=false}
        [Car{id=88, carNum='1201', brand='帕萨特2', guidePrice=30.0, produceTime='2020-11-11', carType='燃油车'},
        Car{id=89, carNum='1202', brand='帕萨特3', guidePrice=30.0, produceTime='2020-11-11', carType='燃油车'}],
        prePage=1, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true, hasNextPage=false, navigatePages=3, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}
        */


        SqlSessionUtil.close(sqlSession);
    }
}
