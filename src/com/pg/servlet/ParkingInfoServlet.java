package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.parkingInfoDao;

import bean.ParkingMessage;
import utils.AjaxMsgUtil;
import utils.PageData;

/**
 * Servlet implementation class ParkingInfoServlet
 */
@WebServlet("/ParkingInfoServlet")
public class ParkingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	parkingInfoDao dao = new parkingInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingInfoServlet() {
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
			ArrayList<ParkingMessage> list = dao.findAll();
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;

		case "post":
			ParkingMessage obj = new ParkingMessage();
			obj.setParkingNo(Integer.parseInt(pd.getString("parkingNo")));
			System.out.println(Integer.parseInt(pd.getString("parkingNo")));
			obj.setParkingArea(pd.getString("parkingArea"));
			obj.setUserName(pd.getString("userName"));
			obj.setCarType(pd.getString("carType"));
			obj.setCarNumber(pd.getString("carNumber"));
			obj.setTelPhone(pd.getString("telPhone"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("parkingNo")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;

		case "update":
			ParkingMessage pg = new ParkingMessage();
			pg.setParkingArea(pd.getString("parkingArea"));
			pg.setUserName(pd.getString("userName"));
			pg.setCarType(pd.getString("carType"));
			pg.setCarNumber(pd.getString("carNumber"));
			pg.setTelPhone(pd.getString("telPhone"));
			pg.setParkingNo(Integer.parseInt(pd.getString("parkingNo")));
			dao.update(pg);
		    response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
		    break;
		    
		default:
			break;
		}
	}

}
