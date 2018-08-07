package com.pg.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.Dao.buildInfoDao;

import bean.BuildMessage;

import utils.AjaxMsgUtil;

import utils.PageData;

/**
 * Servlet implementation class BuildInfoServlet
 */
@WebServlet("/BuildInfoServlet")
public class BuildInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	buildInfoDao dao =  new buildInfoDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildInfoServlet() {
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
			ArrayList<BuildMessage> list = dao.findAll();
			//response.setCharacterEncoding("UTF-8");
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess(list)); //执行成功
			break;
			
		case "post":
			BuildMessage obj = new BuildMessage();
			obj.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			obj.setBuildHeight(pd.getString("buildHeight"));
			obj.setBuildArea(pd.getString("buildArea"));
			obj.setBuildTime(pd.getString("buildTime"));
			obj.setBuildType(pd.getString("buildType"));
			dao.save(obj);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "remove":
			dao.remove(Integer.parseInt(pd.getString("buildNo")));
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;
			
		case "update":
			BuildMessage pg = new BuildMessage();			
			pg.setBuildHeight(pd.getString("buildHeight"));
			pg.setBuildArea(pd.getString("buildArea"));
			pg.setBuildTime(pd.getString("buildTime"));
			pg.setBuildType(pd.getString("buildType"));
			pg.setBuildNo(Integer.parseInt(pd.getString("buildNo")));
			dao.update(pg);
			response.getWriter().write(AjaxMsgUtil.ajaxSuccess("ok"));
			break;

		default:
			break;
	}
		}
}
