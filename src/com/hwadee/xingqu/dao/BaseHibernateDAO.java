package com.hwadee.xingqu.dao;

import org.hibernate.Session;

import com.hwadee.xingqu.sessionfactory.HibernateSessionFactory;

public class BaseHibernateDAO {
	public Session getSession()
	{
		return HibernateSessionFactory.getSession();
	}

}
