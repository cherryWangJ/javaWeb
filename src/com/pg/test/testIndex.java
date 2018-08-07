package com.pg.test;
import bean.*;
import com.pg.service.*;

public class testIndex {

	public static void main(String[] args) {
		studentManage sm = new studentManageImpl();
		User s = new User();
		s.setAdminName("李四");
		s.setPassWord("123");
		boolean flag = sm.add(s);
		if(flag) {
			System.out.println("ok");
		}
		else {
			System.out.println("sorry");
		}
	}
}
