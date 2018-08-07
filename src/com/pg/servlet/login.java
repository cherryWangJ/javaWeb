package com.pg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.service.studentManage;
import com.pg.service.studentManageImpl;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 设置字符*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 转换字符*/
		String _adminName = request.getParameter("adminName1");
		String _passWord = request.getParameter("passWord1");
		System.out.println(_adminName);
		System.out.println(_passWord);
		
		studentManage sm = new studentManageImpl();
		
		boolean flag = sm.checkLogin(_adminName, _passWord);
		
		if (flag) {
			response.getWriter().write("ok");
		}
		else {
			response.getWriter().write("sorry");
		}
	}

}
