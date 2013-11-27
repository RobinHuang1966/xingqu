package com.hwadee.xingqu.action;

import java.util.List;

import org.hibernate.classic.Session;

import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.model.User;

public class Test {
	public static void main(String[] args) {
		
		String sql="from User  as u where u.unick like '%y%' ";
		
		UserDAO userdao=new UserDAO();
		Session session=(Session) userdao.getSession();
		List<User> list=session.createQuery(sql).list();
		
		for(User u:list){
			System.out.println(u.getUnick()+"--"+u.getUname());
		}
	}

}
