package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {


    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"6666","丰田霸道",32.0,"2020-11-11","燃油车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(90L);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(89L,"6666","丰田霸道",32.0,"2020-11-11","燃油车");
        int count = mapper.update(car);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(87L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

}
