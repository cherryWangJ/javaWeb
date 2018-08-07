package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.chargeInfoDao;

import utils.*;
import bean.Chargemessage;

/**
 * Servlet implementation class ChargeInfoServlet
 */
@WebServlet("/ChargeInfoServlet")
public class ChargeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	chargeInfoDao dao = new chargeInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeInfoServlet() {
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
			ArrayList<Chargemessage> list = dao.findAll();
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;
		
		case "post":
			Chargemessage obj = new Chargemessage();
			obj.setChargeNo(Integer.parseInt(pd.getString("chargeNo")));
			obj.setChargeName(pd.getString("chargeName"));
			obj.setChargeNumber(pd.getString("chargeNumber"));
			obj.setChargeUser(pd.getString("chargeUser"));
			obj.setChargeTime(pd.getString("chargeTime"));
			obj.setChargeContent(pd.getString("chargeContent"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("chargeNo")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "update":
			Chargemessage pg = new Chargemessage();
			pg.setChargeName(pd.getString("chargeName"));
			pg.setChargeNumber(pd.getString("chargeNumber"));
			pg.setChargeUser(pd.getString("chargeUser"));
			pg.setChargeTime(pd.getString("chargeTime"));
			pg.setChargeContent(pd.getString("chargeContent"));
			pg.setChargeNo(Integer.parseInt(pd.getString("chargeNo")));
			dao.update(pg);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
		default:
			break;
		}
	}

}
