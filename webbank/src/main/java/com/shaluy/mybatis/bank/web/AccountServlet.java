package com.shaluy.mybatis.bank.web;

import com.shaluy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.shaluy.mybatis.bank.exceptions.TransferException;
import com.shaluy.mybatis.bank.service.AccountService;
import com.shaluy.mybatis.bank.service.impl.AccountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountServlet",value = "/tansfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求参数（// 获取表单数据）
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            // 调用service的转账方法完成转账。（调业务层）
            accountService.tansfer(fromActno,toActno,money);
            // 程序能够走到这里，表示转账一定成功了。
            // 调用View完成展示结果。
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/error1.html");
        } catch (TransferException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }


    }
}
