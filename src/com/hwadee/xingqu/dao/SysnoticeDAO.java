package com.hwadee.xingqu.dao;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

import com.hwadee.xingqu.model.Sysnotice;
import com.hwadee.xingqu.model.Sysnotice;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sysnotice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Sysnotice
 * @author MyEclipse Persistence Tools
 */

public class SysnoticeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SysnoticeDAO.class);
	// property constants
	public static final String SYS_TITLE = "sysTitle";
	public static final String SYS_CONTENT = "sysContent";

	public void save(Sysnotice transientInstance) {
		log.debug("saving Sysnotice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sysnotice persistentInstance) {
		log.debug("deleting Sysnotice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sysnotice findById(java.lang.Integer id) {
		log.debug("getting Sysnotice instance with id: " + id);
		try {
			Sysnotice instance = (Sysnotice) getSession().get(
					"com.hwadee.xingqu.model.Sysnotice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sysnotice> findByExample(Sysnotice instance) {
		log.debug("finding Sysnotice instance by example");
		try {
			List<Sysnotice> results = (List<Sysnotice>) getSession()
					.createCriteria("com.hwadee.xingqu.model.Sysnotice").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sysnotice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sysnotice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Sysnotice> findBySysTitle(Object sysTitle) {
		return findByProperty(SYS_TITLE, sysTitle);
	}

	public List<Sysnotice> findBySysContent(Object sysContent) {
		return findByProperty(SYS_CONTENT, sysContent);
	}

	public List findAll() {
		log.debug("finding all Sysnotice instances");
		try {
			String queryString = "from Sysnotice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sysnotice merge(Sysnotice detachedInstance) {
		log.debug("merging Sysnotice instance");
		try {
			Sysnotice result = (Sysnotice) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sysnotice instance) {
		log.debug("attaching dirty Sysnotice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sysnotice instance) {
		log.debug("attaching clean Sysnotice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}