package com.pg.service;

import java.sql.*;

import com.DB.conn.DataBaseUtil;

import bean.User;

public class studentManageImpl implements studentManage {
	
	public boolean add(User s) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		conn = DataBaseUtil.getConnection();
		String sql = "insert into admin_table(adminName,passWord) value(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,s.getAdminName());
			pst.setString(2,s.getPassWord());
			int row = pst.executeUpdate();
			if (row > 0) {
				flag = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			DataBaseUtil.close(pst, conn);
		}
		return flag;
	}
	
	public boolean checkLogin(String adminName,String passWord) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select * from admin_table where adminName='"+adminName+"'";
		conn = DataBaseUtil.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		while (rs.next()) {
			if(rs.getString("passWord").equals(passWord)) {
				flag = true;
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			DataBaseUtil.close(rs, st, conn);
		}
		return flag;
	}
	
}
