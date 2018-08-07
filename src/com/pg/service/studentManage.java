package com.pg.service;

import bean.*;

public interface studentManage {

	public boolean add(User s);
	public boolean checkLogin(String userName,String passWord);
		
}
