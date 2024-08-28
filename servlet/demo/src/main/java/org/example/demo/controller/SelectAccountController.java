package org.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.dao.AccountDAO;

public class SelectAccountController implements Controller{
	
	private AccountDAO accountDAO;
	
	public SelectAccountController() {
		this.accountDAO = new AccountDAO();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
        
        request.setCharacterEncoding("UTF-8");
        response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
        
        int myAccountIndex = Integer.parseInt(request.getParameter("acountIndex"));
        PrintWriter out = response.getWriter();
        out.write("오~~ 너 " + myAccountIndex + "번 계좌를 선택했구나~ 굿굿");
        
	}
}
