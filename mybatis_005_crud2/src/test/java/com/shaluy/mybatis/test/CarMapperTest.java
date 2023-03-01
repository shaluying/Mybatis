package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "4444", "a宝马", 32.0, "2000-10-10", "新能源");
        int count = mapper.insert(car);
        System.out.println("count = " + count);
        sqlSession.commit();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(77L);
        System.out.println("count = " + count);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(76L, "2222", "凯美瑞222", 3.0, "2000-10-10", "新能源");
        int count = mapper.update(car);
        System.out.println("count = " + count);
        sqlSession.commit();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(76L);
        System.out.println("car = " + car);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println("car = " + car));
    }

}
