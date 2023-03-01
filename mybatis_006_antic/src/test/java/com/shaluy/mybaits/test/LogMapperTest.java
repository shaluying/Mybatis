package com.shaluy.mybaits.test;

import com.shaluy.mybatis.mapper.LogMapper;
import com.shaluy.mybatis.pojo.Log;
import com.shaluy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class LogMapperTest {

    @Test
    public void testselectAllByTable(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = mapper.selectAllByTable("20220902");
        logs.forEach(log -> System.out.println("log = " + log));
        sqlSession.close();
    }
}
