package com.shaluy.mybatis.bank.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {

    @Test
    public void testEnvironment() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取SqlSessionFactory对象（采用默认的方式获取）
        // 这种方式就是获取的默认环境
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL语句
        sqlSession.insert("car.insertCar");
        sqlSession.commit();
        sqlSession.close();

        // 这种方式就是通过环境id来使用指定的环境
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"), "ssmDB");
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        sqlSession1.insert("car.insertCar");
        sqlSession1.commit();
        sqlSession1.close();
    }

    @Test
    public void testDataSource() throws Exception{
        // sqlSessionFactory对象：一个数据库（环境）一个。不要频繁创建该对象。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

        // 通过sqlSessionFactory对象可以开启多个会话。
//        //会话1
//        SqlSession sqlSession1 = sqlSessionFactory.openSession();
//        //会话2
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//
//        sqlSession1.insert("car.insertCar");
//        sqlSession1.commit();
//        sqlSession1.close();// 因为要测试连接池的效果，关闭是需要的。别忘了，要不然测不出来。
//
//        sqlSession2.insert("car.insertCar");
//        sqlSession2.commit();
//        sqlSession2.close();


        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("car.insertCar");
            sqlSession.commit();
            // 不要关闭。使其处于占用状态
        }

    }

}
