package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.repairInfoDao;

import bean.RepairMessage;
import utils.AjaxMsgUtil;
import utils.PageData;

/**
 * Servlet implementation class RepairInfoServlet
 */
@WebServlet("/RepairInfoServlet")
public class RepairInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	repairInfoDao dao = new repairInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairInfoServlet() {
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
			ArrayList<RepairMessage> list = dao.findAll();
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;

		case "post":
			RepairMessage obj = new RepairMessage();
			obj.setRepairNo(Integer.parseInt(pd.getString("repairNo")));
			obj.setRepairName(pd.getString("repairName"));
			obj.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			obj.setRoomNo(pd.getString("roomNo"));
			obj.setRepairTime(pd.getString("repairTime"));
			obj.setRepairContent(pd.getString("repairContent"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("repairNo")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "update":
			RepairMessage pg = new RepairMessage();
			pg.setRepairName(pd.getString("repairName"));
			pg.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			pg.setRoomNo(pd.getString("roomNo"));
			pg.setRepairTime(pd.getString("repairTime"));
			pg.setRepairContent(pd.getString("repairContent"));
			pg.setRepairNo(Integer.parseInt(pd.getString("repairNo")));
			dao.update(pg);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		default:
			break;
		}
	}

}
