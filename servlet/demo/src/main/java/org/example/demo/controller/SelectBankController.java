package org.example.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.demo.dao.AccountDAO;
import org.example.demo.domain.Account;


public class SelectBankController implements Controller {
	
	private AccountDAO accountDAO;
	
	public SelectBankController() {
		this.accountDAO = new AccountDAO();
	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int bankId = Integer.parseInt(request.getParameter("bankId"));
		int memberId = 2;
		List<Account> accounts = accountDAO.findByMemberIdAndBankId(memberId, bankId);
		
		// 요청 객체에 accountList라는 이름의 키값으로 account 목록 리스트를 저장
		request.setAttribute("accountList", accounts);
		
		// JSP 페이지로 포워드
		String url = "/accountList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");		
	}

}
