package com.hwadee.xingqu.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Theme;
import com.hwadee.xingqu.model.User;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for Group
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Group
 * @author MyEclipse Persistence Tools
 */

public class GroupDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GroupDAO.class);
	// property constants	
	public static final String TH_ID = "theme";
	public static final String UID = "user";
	public static final String GTITLE = "gtitle";
	public static final String GIS_VERIFY = "gisVerify";
	public static final String GBRIEF = "gbrief";
 
	
	public void save(Group transientInstance) {
		log.debug("saving Group instance");
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

	public void delete(Group persistentInstance) {
		log.debug("deleting Group instance");
		try {
			Session s=(Session) getSession();
			s.delete(persistentInstance);
			s.beginTransaction().commit();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Group findById(java.lang.Integer id) {
		log.debug("getting Group instance with id: " + id);
		try {
			Group instance = (Group) getSession().get(
					"com.hwadee.xingqu.model.Group", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Group> findByExample(Group instance) {
		log.debug("finding Group instance by example");
		try {
			List<Group> results = (List<Group>) getSession().createCriteria(
					"com.hwadee.xingqu.model.Group").add(create(instance))
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
		log.debug("finding Group instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Group as model where model."
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
	public List<Group> findByThId(Object thId) {
		return findByProperty(TH_ID, thId);
	}

	@SuppressWarnings("unchecked")
	public List<Group> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	@SuppressWarnings("unchecked")
	public List<Group> findByGtitle(Object gtitle) {
		return findByProperty(GTITLE, gtitle);
	}

	@SuppressWarnings("unchecked")
	public List<Group> findByGisVerify(Object gisVerify) {
		return findByProperty(GIS_VERIFY, gisVerify);
	}

	@SuppressWarnings("unchecked")
	public List<Group> findByGbrief(Object gbrief) {
		return findByProperty(GBRIEF, gbrief);
	}

	public List findAll() {
		log.debug("finding all Group instances");
		try {
			String queryString = "from Group";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Group merge(Group detachedInstance) {
		log.debug("merging Group instance");
		try {
			Group result = (Group) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Group instance) {
		try {
			Session s=(Session) getSession();
			s.beginTransaction();
			s.saveOrUpdate(instance);
			s.getTransaction().commit();
			s.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public void attachClean(Group instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}