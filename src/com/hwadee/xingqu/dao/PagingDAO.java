package com.hwadee.xingqu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hwadee.xingqu.model.Topic;

public class PagingDAO  extends BaseHibernateDAO{

	/**
	 * 查找并返回所有计划
	 */

	@SuppressWarnings("unchecked")
	public List findPlantByPage(int page, int rowsPerPage,String Entityname,String propertyName) {
		Session session = getSession();
		Query query = session.createQuery("from "+Entityname+" order by "+propertyName+" desc");
		query.setMaxResults(rowsPerPage); // 每页最多显示几条
		query.setFirstResult((page - 1) * rowsPerPage); // 每页从第几条记录开始
		List list = query.list();
		session.close();
		return list;
	}
	/**
	 * 共多少页计划数据
	 */
	public int getPlanTotalPage(int rowsPerPage,String Entityname) {
		// System.out.println("rowsPerPage:" + rowsPerPage);
		int rows = 0;
		String hql = "from "+Entityname;
		Session session = getSession();
		Query query = session.createQuery(hql);

		rows = query.list().size();
		session.close();
		if (rows % rowsPerPage == 0) {
			return rows / rowsPerPage;
		} else {
			return rows / rowsPerPage + 1;
		}
	}
	/**
	 * 条件查询后返回的总行数
	 */
	public int getPlanNum(String Entityname) {
		String hql = "from "+Entityname;
		int rows = 0;
		Session session = getSession();
		Query query = session.createQuery(hql);
		rows=query.list().size();
		session.close();
		return rows;
	}
	/**
	 * 条件查询后返回的计划总页数
	 */
	public int getPlanTotalPage(int rowsPerPage, String Entityname,String type, String search) {
		int rows = 0;
		Session session =getSession();
		String hql = "from "+Entityname+" entity where entity." + type
		+ " like :type";
		Query query = session.createQuery(hql);
		query.setString("type", "%" + search + "%");

		rows =query.list().size();
		session.close();
		if (rows % rowsPerPage == 0) {
			return rows / rowsPerPage;
		} else {
			return rows / rowsPerPage + 1;
		}
	}
	/**
	 * 条件查询后返回的计划数据总数
	 */
	public int getPlanNum(String EntityName,String type, String search) {
		int rows = 0;
		Session session =getSession();
		String hql = "from "+EntityName+" p where p." + type
		+ " like :type";
		Query query = session.createQuery(hql);
		query.setString("type", "%" + search + "%");
		rows = query.list().size();
		// System.out.println("rows:" + rows);
		session.close();
		return rows;
	}
	@SuppressWarnings("unchecked")
	public List findPlantByPage(String Entityname,String propertyName ,String Type) {
		Session session = getSession();
		Query query = session.createQuery("from "+Entityname+" order by "+propertyName+" "+Type);
		List list = query.list();
		session.close();
		return list;
	}
	public List findFuzzy (String EntityName,String propertyName ,Object like) {
		String hql="from "+" "+EntityName+" "+" where "+" "+propertyName+" "+"like ? ";
		Query query = getSession().createQuery(hql);  
		query.setString(0,"%"+like+"%");
		getSession().beginTransaction().commit();  
		return query.list();  
	}
}
