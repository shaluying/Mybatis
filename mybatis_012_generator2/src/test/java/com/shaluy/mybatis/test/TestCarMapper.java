package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.pojo.CarExample;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class TestCarMapper {

    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 执行查询
        // 查询一个
        Car car = mapper.selectByPrimaryKey(89L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByExample(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 2. 查询所有（selectByExample，根据条件查询，如果条件是null表示没有条件。）
        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car -> System.out.println(car));
        System.out.println("=========================================");

        // 3. 按照条件进行查询
        // QBC 风格：Query By Criteria 一种查询方式，比较面向对象，看不到sql语句。
        // 封装条件，通过CarExample对象来封装查询条件
        CarExample carExample = new CarExample();
        carExample.createCriteria()
                .andBrandLike("帕萨特")
                .andGuidePriceGreaterThan(new BigDecimal(20.0));
        // 添加or
        carExample.or().andCarTypeEqualTo("燃油车");
        // 执行查询
        List<Car> cars1 = mapper.selectByExample(carExample);
        cars1.forEach(car -> System.out.println(car));

        SqlSessionUtil.close(sqlSession);

    }
}
