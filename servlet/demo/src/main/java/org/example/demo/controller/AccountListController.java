package org.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.dao.AccountDAO;
import org.example.demo.domain.Account;

import java.io.IOException;
import java.util.List;


public class AccountListController implements Controller{

    public AccountDAO accountDAO;

    public AccountListController() {
        this.accountDAO = new AccountDAO();
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        System.out.println("################################################################");
        List<Account> data = accountDAO.findAll();

        request.setAttribute("accountList", data);

        String url = "/account.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
    }
}