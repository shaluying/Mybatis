package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.ClazzMapper;
import com.shaluy.mybatis.pojo.Clazz;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClazzMapperTest {

    @Test
    public void testSelectByIdWithCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByIdWithCollection(1000);
        System.out.println(clazz);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdWithStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByIdWithStep1(1001);

//        System.out.println(clazz);

        System.out.println(clazz.getCname());

        SqlSessionUtil.close(sqlSession);
    }
}
