package com.shaluy.mybatis.bank.service.impl;

import com.shaluy.mybatis.bank.dao.AccountDao;
import com.shaluy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.shaluy.mybatis.bank.exceptions.TransferException;
import com.shaluy.mybatis.bank.pojo.Account;
import com.shaluy.mybatis.bank.service.AccountService;
import com.shaluy.mybatis.bank.utils.GenerateDaoProxy;
import com.shaluy.mybatis.bank.utils.SqlSessionUtil;

public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();

    // 这是咱们自己封装的。
    private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), com.shaluy.mybatis.bank.dao.AccountDao.class);

    @Override
    public void tansfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferException {
        // 1. 判断转出账户的余额是否充足(select)
        Account fromAccount = accountDao.selectAccountByActno(fromActno);
        if (fromAccount.getBalance() < money) {
            // 2. 如果转出账户余额不足，提示用户
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        // 3. 如果转出账户余额充足，更新转出账户余额
        // 先更新内存中java对象account的余额
        Account toAccount = accountDao.selectAccountByActno(toActno);
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);
        // 4. 更新转入账户余额(update)
        int count = accountDao.updateAccountByActno(fromAccount);
        count += accountDao.updateAccountByActno(toAccount);
        if (count != 2){
            throw new TransferException("转账异常，未知原因");
        }
    }

}
