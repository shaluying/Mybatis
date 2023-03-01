package com.shaluy.mybatis.bank.service;

import com.shaluy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.shaluy.mybatis.bank.exceptions.TransferException;

public interface AccountService {
    /**
     * 转账功能
     * @param fromActno 转出账户
     * @param toActno   转入账户
     * @param money     转账金额
     */
    void tansfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferException;

}
