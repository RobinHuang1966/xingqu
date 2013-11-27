package com.hwadee.xingqu.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.hwadee.xingqu.model.Friend;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.User;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Friend entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Friend
 * @author MyEclipse Persistence Tools
 */

public class FriendDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(FriendDAO.class);
	// property constants
	public static final String UID = "userByUid";
	public static final String FUID = "userByFuid";

	public void save(Friend transientInstance) {
		log.debug("saving Friend instance");
		try {
			Session s=(Session) getSession();
			s.save(transientInstance);
			s.beginTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Friend persistentInstance) {

		try {
			Session s=(Session) getSession();
			s.delete(persistentInstance);
			s.beginTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Friend findById(java.lang.Integer id) {
		log.debug("getting Friend instance with id: " + id);
		try {
			Friend instance = (Friend) getSession().get(
					"com.hwadee.xingqu.model.Friend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Friend> findByExample(Friend instance) {
		log.debug("finding Friend instance by example");
		try {
			List<Friend> results = (List<Friend>) getSession().createCriteria(
			"com.hwadee.xingqu.model.Friend").add(create(instance))
			.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from Friend as model where model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Friend> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	@SuppressWarnings("unchecked")
	public List<Friend> findByFuid(Object fuid) {
		return findByProperty(FUID, fuid);
	}

	public List findAll() {
		log.debug("finding all Friend instances");
		try {
			String queryString = "from Friend";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Friend merge(Friend detachedInstance) {
		log.debug("merging Friend instance");
		try {
			Friend result = (Friend) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Friend instance) {
		log.debug("attaching dirty Friend instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Friend instance) {
		log.debug("attaching clean Friend instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}	
	@SuppressWarnings("unchecked")
	public List<Friend> findByTwoproperty(User user1,User user2)
	{
		try {
			String queryString = "from Friend as model where model.userByFuid =? and model.userByUid= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user1);
			queryObject.setParameter(1, user2);
			List<Friend>  list= queryObject.list();
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}