package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.userInfoDao;

import bean.UserMessage;
import utils.AjaxMsgUtil;
import utils.PageData;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userInfoDao dao =  new userInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
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
		String ajaxId = request.getParameter("ajaxId");
		String userName = request.getParameter("userName");
		PageData pd = new PageData(request);
		System.out.println(pd);
		switch (ajaxId) {
		case "get":
			ArrayList<UserMessage> list = dao.findAll();
			//response.setCharacterEncoding("UTF-8");
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;
			
		case "post":
			UserMessage obj = new UserMessage();
			obj.setUserName(pd.getString("userName"));
			obj.setUserPassword(pd.getString("userPassword"));
			obj.setAge(pd.getString("Age"));
			obj.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			obj.setRoomNo(pd.getString("roomNo"));
			obj.setTelPhone(pd.getString("telPhone"));
			obj.setUserOrAdmin(pd.getString("userOrAdmin"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("userId")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "find":
			ArrayList<UserMessage> list1 = dao.findByName(userName);
			//response.setCharacterEncoding("UTF-8");
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list1));
			break;
			
		case "update":
		    UserMessage pg = new UserMessage();
		    pg.setUserName(pd.getString("userName"));
		    pg.setUserPassword(pd.getString("userPassword"));
		    pg.setAge(pd.getString("Age"));
		    pg.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
		    pg.setRoomNo(pd.getString("roomNo"));
		    pg.setTelPhone(pd.getString("telPhone"));
		    pg.setUserOrAdmin(pd.getString("userOrAdmin"));
		    pg.setUser_Id(Integer.parseInt(pd.getString("userId")));
		    dao.update(pg);
		    response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
		    break;
		    		
		default:
			break;
		}
	}

}
