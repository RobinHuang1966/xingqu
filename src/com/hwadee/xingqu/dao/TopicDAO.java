package com.hwadee.xingqu.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for Topic
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.Topic
 * @author MyEclipse Persistence Tools
 */

public class TopicDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TopicDAO.class);
	// property constants
	public static final String UID = "user";
	public static final String TTITLE = "ttitle";
	public static final String TCONTENT = "tcontent";

	public void save(Topic transientInstance) {
		log.debug("saving Topic instance");
		try {
			Session s=getSession();
			s.save(transientInstance);
			s.flush();
			s.beginTransaction().commit();
			s.close();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(int id) {
		Query query=getSession().createQuery("from Topic where id=?");
		query.setInteger(0,id);
		List<Topic> list=query.list();
		if(list.size()>0){
			Topic topic=(Topic)list.get(0);
			//ɾ�����
			getSession().delete(topic);
			getSession().beginTransaction().commit();
			getSession().close();
		}

	}
	@SuppressWarnings("unchecked")
	public List<Topic> findFuzzy (String S) {
		String hql="from Topic where tcontent like ? or ttitle like ?";
		Query query = getSession().createQuery(hql);  
		query.setString(0,"%"+S+"%");
		query.setString(1,"%"+S+"%");
		getSession().beginTransaction().commit();  
		return query.list();  

	}
	public Topic findById(java.lang.Integer id) {		
		Topic result = (Topic) getSession().get(Topic.class, id);
		getSession().close();
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<Topic> findByExample(Topic instance) {
		log.debug("finding Topic instance by example");
		try {
			List<Topic> results = (List<Topic>) getSession().createCriteria(
			"com.hwadee.xingqu.model.Topic").add(create(instance))
			.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Topic> findByProperty(String propertyName, Object value) {
		log.debug("finding Topic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topic as model where model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Topic> findByUid(User uid) {
		return findByProperty(UID, uid);
	}

	public List<Topic> findByTtitle(Object ttitle) {
		return findByProperty(TTITLE, ttitle);
	}

	public List<Topic> findByTcontent(Object tcontent) {
		return findByProperty(TCONTENT, tcontent);
	}

	@SuppressWarnings("unchecked")
	public List<Topic> findAll() {
		log.debug("finding all Topic instances");
		try {
			String queryString = "from Topic";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Topic merge(Topic detachedInstance) {
		log.debug("merging Topic instance");
		try {
			getSession().beginTransaction();
			Topic result = (Topic) getSession().merge(detachedInstance);
			//getSession().beginTransaction().commit()
			getSession().getTransaction().commit();
			getSession().close();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

//	public void attachDirty(Topic instance) {
//		log.debug("attaching dirty Topic instance");
//		try {
//			getSession().beginTransaction();
//			getSession().saveOrUpdate(instance);
//			getSession().getTransaction().commit();
//			getSession().close();
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
	
	public void attachDirty(Topic instance) {
		log.debug("merging Topic instance");
		try {
			getSession().beginTransaction();
			getSession().clear();
			getSession().saveOrUpdate(instance);
			getSession().getTransaction().commit();
			getSession().close();
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public void attachClean(Topic instance) {
		log.debug("attaching clean Topic instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void updateTopic(Topic topic) throws Exception
	{
		Session s=getSession();
		s.update(topic);
		s.flush();
		s.beginTransaction().commit();
		s.close();
		Topic t=findById(topic.getTid());
	}

}
