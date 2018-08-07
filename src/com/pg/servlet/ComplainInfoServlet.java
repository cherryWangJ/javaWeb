package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.complainInfoDao;

import bean.ComplainMessage;

import utils.AjaxMsgUtil;

import utils.PageData;
/**
 * Servlet implementation class ComplainInfoServlet
 */
@WebServlet("/ComplainInfoServlet")
public class ComplainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	complainInfoDao dao = new complainInfoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainInfoServlet() {
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
			ArrayList<ComplainMessage> list = dao.findAll();
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;

		case "post":
			ComplainMessage obj = new ComplainMessage();
			obj.setComplainNo(Integer.parseInt(pd.getString("complainNo")));
			obj.setComplainName(pd.getString("complainName"));
			obj.setComplainTime(pd.getString("complainTime"));
			obj.setComplainContent(pd.getString("complainContent"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("complainNo")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "update":
			ComplainMessage pg = new ComplainMessage();
			pg.setComplainName(pd.getString("complainName"));
			pg.setComplainTime(pd.getString("complainTime"));
			pg.setComplainContent(pd.getString("complainContent"));
			pg.setComplainNo(Integer.parseInt(pd.getString("complainNo")));
			dao.update(pg);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		default:
			break;
		}
	}

}
