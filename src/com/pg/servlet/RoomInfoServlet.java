package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.roomInfoDao;

import bean.RoomMessage;
import utils.AjaxMsgUtil;
import utils.PageData;

/**
 * Servlet implementation class RoomInfoServlet
 */
@WebServlet("/RoomInfoServlet")
public class RoomInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       roomInfoDao dao = new roomInfoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoServlet() {
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
		PageData pd = new PageData(request);
		System.out.println(pd);
		switch (ajaxId) {
		case "get":
			ArrayList<RoomMessage> list = dao.findAll();
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list));
			break;

		case "post":
			RoomMessage obj = new RoomMessage();
			obj.setRoomNo(pd.getString("roomNo"));
			obj.setUserName(pd.getString("userName"));
			obj.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			obj.setRoomArea(pd.getString("roomArea"));
			obj.setRoomType(pd.getString("roomType"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(pd.getString("roomNo"));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "update":
			RoomMessage pg =new RoomMessage();
			pg.setUserName(pd.getString("userName"));
			pg.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			pg.setRoomArea(pd.getString("roomArea"));
			pg.setRoomType(pd.getString("roomType"));
			pg.setRoomNo(pd.getString("roomNo"));
			dao.update(pg);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		default:
			break;
		}
	}

}
