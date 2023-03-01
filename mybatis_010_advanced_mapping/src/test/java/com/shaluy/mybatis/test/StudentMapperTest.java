package com.shaluy.mybatis.test;

import com.shaluy.mybatis.mapper.StudentMapper;
import com.shaluy.mybatis.pojo.Student;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(2);
        System.out.println(student);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdWithAssociation(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdWithAssociation(1);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByIdWithStep(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdWithStep1(5);

//        System.out.println(student);

        System.out.println(student.getSname());

        System.out.println(student.getClazz().getCname());

        SqlSessionUtil.close(sqlSession);
    }
}
