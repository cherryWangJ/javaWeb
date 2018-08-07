package com.pg.service;

import java.sql.*;

import com.DB.conn.DataBaseUtil;
public class userManageImpl implements userManage {

	public boolean checkLogin(String userName,String userPassword) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select * from user_message where userName='"+userName+"'";
		conn = DataBaseUtil.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		while (rs.next()) {
			if(rs.getString("userPassword").equals(userPassword)) {
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
