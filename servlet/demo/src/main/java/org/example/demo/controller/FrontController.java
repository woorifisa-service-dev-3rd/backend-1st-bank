package org.example.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/*")
public class FrontController extends HttpServlet {

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
    	controllerMap.put("/bankList", new ShowBankController());
    	controllerMap.put("/bank", new SelectBankController());
    	controllerMap.put("/accountList", new SelectAccountController());
    	controllerMap.put("/account", new AccountListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 대부분의 컨트롤러에서 수행되는 공통 처리 수행
        request.setCharacterEncoding("UTF-8");

        // 사용자의 요청 URI값을 확인
        String path = request.getPathInfo();
        System.out.println(path);

        // URI별 특정 요청을 수행할 개별 컨트롤러 불러오기
        Controller controller = controllerMap.get(path);

        // 실제 개별 컨트롤러에게 요청을 처리하도록 호출
        try {
			controller.process(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
