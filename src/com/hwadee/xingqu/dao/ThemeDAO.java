package com.hwadee.xingqu.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import com.hwadee.xingqu.model.Theme;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for Theme
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Theme
 * @author MyEclipse Persistence Tools
 */

public class ThemeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ThemeDAO.class);
	// property constants
	public static final String TH_NAME = "thName";
	public static final String TH_BRIEF = "thBrief";

	public void save(Theme transientInstance) {
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Theme persistentInstance) {
		log.debug("deleting Theme instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Theme findById(java.lang.Integer id) {
		log.debug("getting Theme instance with id: " + id);
		try {
			Theme instance = (Theme) getSession().get(
					"com.hwadee.xingqu.model.Theme", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Theme> findByExample(Theme instance) {
		log.debug("finding Theme instance by example");
		try {
			List<Theme> results = (List<Theme>) getSession().createCriteria(
					"com.hwadee.xingqu.model.Theme").add(create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Theme instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Theme as model where model."
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
	public List<Theme> findByThName(Object thName) {
		return findByProperty(TH_NAME, thName);
	}

	@SuppressWarnings("unchecked")
	public List<Theme> findByThBrief(Object thBrief) {
		return findByProperty(TH_BRIEF, thBrief);
	}

	public List findAll() {
		log.debug("finding all Theme instances");
		try {
			String queryString = "from Theme";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Theme merge(Theme detachedInstance) {
		log.debug("merging Theme instance");
		try {
			Theme result = (Theme) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Theme instance) {
		log.debug("attaching dirty Theme instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Theme instance) {
		log.debug("attaching clean Theme instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}