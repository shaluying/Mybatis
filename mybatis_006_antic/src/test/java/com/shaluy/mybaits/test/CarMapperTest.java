package com.shaluy.mybaits.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectAllByAscOrDesc(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByAscOrDesc("desc");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mapper实际上就是daoImpl对象.
        // 底层不但为CarMapper接口生成了字节码，并且还new实现类对象了。
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("新能源");
        // 遍历
        cars.forEach(car -> System.out.println(car));

        sqlSession.close();
    }

    @Test
    public void testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("76,78");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("奔驰");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testInsertCarUsrGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"9991", "凯美瑞", 30.0, "2020-11-11", "燃油车");
        mapper.insertCarUsrGeneratedKeys(car);
        System.out.println("car = " + car);
        sqlSession.commit();
        sqlSession.close();
    }
}
