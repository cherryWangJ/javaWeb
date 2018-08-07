package com.pg.test;

import java.sql.Connection;

import com.DB.conn.DataBaseUtil;

public class test {
		
		public static void main(String[] args) {
			Connection conn = DataBaseUtil.getConnection();
			if (conn != null) {
				System.out.println("ok");
			}
			else {
				System.out.println("sorry");
			}
		}
		
	}
