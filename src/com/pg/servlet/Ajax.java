package com.pg.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.conn.DataBaseUtil;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String adminName = request.getParameter("adminName");
		
		try {
			Connection conn = DataBaseUtil.getConnection();
			String sql = "select * from admin_table where adminName=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,adminName);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				response.getWriter().println("您的用户名已注册");
			}
			else {
				response.getWriter().println("验证成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
