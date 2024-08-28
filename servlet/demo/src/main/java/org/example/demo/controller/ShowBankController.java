package org.example.demo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBankController implements Controller {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bankList.jsp");
		dispatcher.forward(request, response);
	}
}
