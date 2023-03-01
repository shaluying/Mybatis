package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testSelectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> car = mapper.selectByIdRetMap(79L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        /*
         * 根据品牌进行模糊查询。
         * 模糊查询的结果可能有多个，但是我采用一个Map对象来接收会有问题吗？
         *
         * 会！！！
         *
         */
        Map<String, Object> car = mapper.selectByBrandLike("奔驰");
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetListMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllRetListMap();
        maps.forEach(map -> System.out.println(map));
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> map = mapper.selectAllRetMap();
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testselectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total = mapper.selectTotal();
        System.out.println("total = " + total);
        sqlSession.close();
    }
}
