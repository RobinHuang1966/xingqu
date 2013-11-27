package com.hwadee.xingqu.model;

import cmo.hwadee.xingqu.sessionfactory.HibernateSessionFactory;
import org.hibernate.Session;

import com.hwadee.xingqu.dao.IBaseHibernateDAO;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}