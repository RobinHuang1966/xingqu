package com.hwadee.xingqu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hwadee.xingqu.model.Topic;

public class PagingDAO  extends BaseHibernateDAO{

	/**
	 * ���Ҳ��������мƻ�
	 */

	@SuppressWarnings("unchecked")
	public List findPlantByPage(int page, int rowsPerPage,String Entityname,String propertyName) {
		Session session = getSession();
		Query query = session.createQuery("from "+Entityname+" order by "+propertyName+" desc");
		query.setMaxResults(rowsPerPage); // ÿҳ�����ʾ����
		query.setFirstResult((page - 1) * rowsPerPage); // ÿҳ�ӵڼ�����¼��ʼ
		List list = query.list();
		session.close();
		return list;
	}
	/**
	 * ������ҳ�ƻ�����
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
	 * ������ѯ�󷵻ص�������
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
	 * ������ѯ�󷵻صļƻ���ҳ��
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
	 * ������ѯ�󷵻صļƻ���������
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
