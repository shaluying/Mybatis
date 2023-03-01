package com.shaluy.mybatis.bank.dao.impl;

import com.shaluy.mybatis.bank.dao.AccountDao;
import com.shaluy.mybatis.bank.pojo.Account;
import com.shaluy.mybatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectAccountByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = sqlSession.selectOne("account.selectAccountByActno", actno);
        return account;
    }

    @Override
    public int updateAccountByActno(Account account) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateAccountByActno", account);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
