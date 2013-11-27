package com.hwadee.xingqu.dao;

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.User;

/**
 * A data access object (DAO) providing persistence and search support for Loger
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Loger
 * @author MyEclipse Persistence Tools
 */

public class LogerDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(LogerDAO.class);
	// property constants
	public static final String UID = "user.uid";
	public static final String WID = "wid";
	public static final String GID = "gid";
	public static final String TID = "topic.tid";
	public static final String PUID = "puser.puid";
	public static final String LTYPE = "ltype";
	public static final String LCONTENT = "lcontent";
	public static final String FLAG = "flag";

	public void save(Loger transientInstance) {
		log.debug("saving Loger instance");
		try {
			getSession().save(transientInstance);
			getSession().flush();
			getSession().beginTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Loger persistentInstance) {
		log.debug("deleting Loger instance");
		try {
			org.hibernate.Session s = getSession();
			s.delete(persistentInstance);
			s.beginTransaction().commit();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	public Loger findById(java.lang.Integer id) {
		log.debug("getting Loger instance with id: " + id);
		try {
			Loger instance = (Loger) getSession().get(
					"com.hwadee.xingqu.model.Loger", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Loger as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByWid(Object wid) {
		return findByProperty(WID, wid);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByGid(Object gid) {
		return findByProperty(GID, gid);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByTid(Object tid) {
		return findByProperty(TID, tid);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByPuid(Object puid) {
		return findByProperty(PUID, puid);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByLtype(Object ltype) {
		return findByProperty(LTYPE, ltype);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByLcontent(Object lcontent) {
		return findByProperty(LCONTENT, lcontent);
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		log.debug("finding all Loger instances");
		try {
			String queryString = "from Loger";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Loger merge(Loger detachedInstance) {
		try {
			getSession().beginTransaction();
			Loger result = (Loger) getSession().merge(detachedInstance);
			getSession().getTransaction().commit();
			getSession().close();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Loger instance) {
		log.debug("attaching dirty Loger instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Loger instance) {
		log.debug("attaching clean Loger instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByThreeproperty(String fruit, int ltype, User user,
			Object object) {
		try {
			getSession().beginTransaction();
			String queryString = "from Loger as model where model." + fruit
					+ "= ?" + "and model.user= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, object);
			queryObject.setParameter(1, user);
			List list = queryObject.list();
			List list1 = new ArrayList();
			for (int i = 0; i < list.size(); ++i) {
				if (((Loger) list.get(i)).getLtype() == ltype) {
					list1.add(list.get(i));
				}
			}
			getSession().getTransaction().commit();
			getSession().close();
			return list1;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByTwoproperty(String fruit, User user, Object obiect) {
		try {
			String queryString = "from Loger as model where model." + fruit
					+ "= ?" + "and model.user= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, obiect);
			queryObject.setParameter(1, user);
			List<Loger> list = queryObject.list();
			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByExample(Loger instance) {
		log.debug("finding Group instance by example");
		try {
			List<Loger> results = (List<Loger>) getSession().createCriteria(
					"com.hwadee.xingqu.model.Loger").add(create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findMyShareByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Loger as model where model."
					+ propertyName + "= ? " + " and model.ltype in(2,10)";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loger> findByTid(Integer tid2, Integer i) {//函数重载
		try {
			String queryString = "from Loger as model where model.topic.tid = ? and model.ltype=?";//1号表示回复话题
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, tid2);
			queryObject.setParameter(1, i);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Loger> findByTwoproperty1(String propertyName1,  Object object1,String propertyName2,  Object object2) {
		try {
			String queryString = "from Loger as model where model." + propertyName1
					+ "= ?" + " and model."+propertyName2+"= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, object1);
			queryObject.setParameter(1, object2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
}