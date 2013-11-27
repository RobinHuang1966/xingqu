package com.hwadee.xingqu.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for Works
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Works
 * @author MyEclipse Persistence Tools
 */

public class WorksDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(WorksDAO.class);
	// property constants
	
	public static final String UID = "user";
	public static final String WNAME = "wname";
	public static final String WTYPE = "wtype";
	public static final String WCONTENT = "wcontent";
	public static final String WBRIEF = "wbrief";
	public static final String WSIZE = "wsize";
	public static final String WGOOD = "wgood";
	public static final String WBAD = "wbad";
	private static final String WLOADNUM="wloadNum";
	public void save(Works transientInstance) {

		try {
			Session s=getSession();
			s.save(transientInstance);
			s.beginTransaction().commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Works persistentInstance) {

		try {
			Session s=getSession();
			s.delete(persistentInstance);
			s.flush();
			s.beginTransaction().commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Works findById(java.lang.Integer id) {

		try {
			Works instance = (Works) getSession().get(
					"com.hwadee.xingqu.model.Works", id);
			return instance;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Works> findByExample(Works instance) {
		log.debug("finding Works instance by example");
		try {
			List<Works> results = (List<Works>) getSession().createCriteria(
			"com.hwadee.xingqu.model.Works").add(create(instance))
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
		log.debug("finding Works instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Works as model where model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Works> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Works> findByWname(Object wname) {
		return findByProperty(WNAME, wname);
	}

	public List<Works> findByWtype(Object wtype) {
		return findByProperty(WTYPE, wtype);
	}

	public List<Works> findByWcontent(Object wcontent) {
		return findByProperty(WCONTENT, wcontent);
	}

	public List<Works> findByWbrief(Object wbrief) {
		return findByProperty(WBRIEF, wbrief);
	}

	public List<Works> findByWsize(Object wsize) {
		return findByProperty(WSIZE, wsize);
	}

	public List<Works> findByWgood(Object wgood) {
		return findByProperty(WGOOD, wgood);
	}

	public List<Works> findByWbad(Object wbad) {
		return findByProperty(WBAD, wbad);
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		log.debug("finding all Works instances");
		try {
			String queryString = "from Works";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Works merge(Works detachedInstance) {
		log.debug("merging Works instance");
		try {
			Works result = (Works) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Works instance) {

		try {
			Session s=getSession();
			s.saveOrUpdate(instance);
			s.beginTransaction().commit();

		} catch (RuntimeException re) {

			throw re;
		}
	}
	public void attachClean(Works instance) {

		try {
			getSession().lock(instance, LockMode.NONE);

		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}