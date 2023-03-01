package com.shalu.mybaits.test;

import com.shaluy.mybatis.mapper.CarMapper;
import com.shaluy.mybatis.pojo.Car;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 假设三个条件都不是空
//        List<Car> cars = mapper.selectByMultiCondition("奔驰", 2.0, "新能源");

        // 假设三个条件都是空
//        List<Car> cars = mapper.selectByMultiCondition("", null, "");

        // 假设后两个条件不为空，第一个条件为空
//        List<Car> cars = mapper.selectByMultiCondition("", 2.0, "新能源");

        // 假设第一个条件不是空，后两个条件是空
        List<Car> cars = mapper.selectByMultiCondition("奔驰", null, "");

        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 三个条件都不是空
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 2.0, "新能源");
        // 三个条件都是空
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        // 如果第一个条件是空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 2.0, "新能源");
        // 后面两个条件是空
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("奔驰", null, "");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 三个条件都不是空
//        List<Car> cars = mapper.selectByMultiConditionWithTrim("奔驰", 2.0, "新能源");
        // 三个条件都是空
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        // 如果第一个条件是空
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 2.0, "新能源");
        // 后面两个条件是空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("奔驰", null, "");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testUpdateByIdWithSet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(83L,null,"五菱宏光",100.6,null,null);
        mapper.updateByIdWithSet(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 三个条件都不为空
//        List<Car> cars = mapper.selectByChoose("奔驰",1.0,"新能源");
        // 第一个条件是空
        List<Car> cars = mapper.selectByChoose(null,1.0,"新能源");
        // 前两个条件都是空
        //List<Car> cars = mapper.selectByChoose(null,null,"新能源");
        // 全部都是空
//        List<Car> cars = mapper.selectByChoose(null,null,null);

        cars.forEach(car -> System.out.println(car));

        sqlSession.close();
    }

    @Test
    public void testDeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {81L,82L,83L};
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {84L,85L,86L};
        int count = mapper.deleteByIds2(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null,"1200", "帕萨特1", 30.0, "2020-11-11", "燃油车");
        Car car2 = new Car(null,"1201", "帕萨特2", 30.0, "2020-11-11", "燃油车");
        Car car3 = new Car(null,"1202", "帕萨特3", 30.0, "2020-11-11", "燃油车");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        mapper.insertBatch(cars);
        sqlSession.commit();
        sqlSession.close();
    }

}
