package com.shaluy.mybatis.bank.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 采用正规的方式，写一个完整版的MyBatis程序。
 *
 * @author 动力节点
 * @version 1.0
 * @since 1.0
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
            //开启回话（底层会开启事务）
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句，处理相关业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count);

            //......
            //......
            //......
            //......

            //执行到这里，没有发生任何异常，提交事务。终止事务。
            sqlSession.commit();
        } catch (IOException e) { //发生异常
            //回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            //关闭回话，释放资源
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }

    }
}
