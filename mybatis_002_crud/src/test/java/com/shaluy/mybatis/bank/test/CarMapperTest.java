package com.shaluy.mybatis.bank.test;

import com.shaluy.mybatis.bank.pojo.Car;
import com.shaluy.mybatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {


    @Test
    public void testInsertCar() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 前端传过来数据了。
        // 这个对象我们先使用Map集合进行数据的封装。
        Map<String, Object> map = new HashMap<>();
//        map.put("k1","1111");
//        map.put("k2","比亚迪汉");
//        map.put("k3","10.0");
//        map.put("k4","2020-11-11");
//        map.put("k5","电车");

        //一般map集合的key起名的时候要见名知意。
        map.put("carNum", "1111");
        map.put("brand", "比亚迪汉2");
        map.put("guidePrice", 10.0);
        map.put("produceTime", "2020-11-11");
        map.put("carType", "电车");

        // 执行SQL语句
        // insert方法的参数：
        // 第一个参数：sqlId，从CarMapper.xml文件中复制。
        // 第二个参数：封装数据的对象。
        int count = sqlSession.insert("insertCar", map);
        System.out.println("count = " + count);

        //提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPOJO() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 前端传过来数据了。
        // Car对象进行数据的封装。
        Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2020-11-11", "新能源");

        // 执行SQL
        int count = sqlSession.insert("insertCar", car);
        System.out.println("count = " + count);

        //提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 执行SQL
        int count = sqlSession.insert("deleteById", 36);
        System.out.println("count = " + count);

        //提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 准备数据
        Car car = new Car(35L, "9999", "凯美瑞", 30.3, "1999-11-10", "燃油车");

        // 执行SQL
        int count = sqlSession.update("updateById", car);
        System.out.println("count = " + count);

        //提交事务，释放资源
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 执行DQL语句。查询。根据id查询。返回结果一定是一条。
        // mybatis底层执行了select语句之后，一定会返回一个结果集对象：ResultSet
        // JDBC中叫做ResultSet，接下来就是mybatis应该从ResultSet中取出数据，封装java对象。
        Object car = sqlSession.selectOne("selectByID", 1);
        System.out.println("car = " + car);

        //释放资源（查询语句无需修改数据库数据，没有事务一说不用提交）
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 执行SQL语句（没有占位符，不用传值）
//        List<Object> cars = sqlSession.selectList("selectAll");
        List<Object> cars = sqlSession.selectList("aaaaaaa.selectAll");

        // 遍历输出
        cars.forEach(car -> System.out.println(car));

        //释放资源（查询语句无需修改数据库数据，没有事务一说不用提交）
        sqlSession.close();
    }


}
