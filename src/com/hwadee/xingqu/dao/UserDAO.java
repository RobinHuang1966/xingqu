package com.hwadee.xingqu.dao;

import java.sql.Timestamp;
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
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hwadee.xingqu.model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UserDAO.class);
	// property constants
	public static final String UNICE = "unice";
	public static final String UNAME = "uname";
	public static final String UPASSWORD = "upassword";
	public static final String UTYPE = "utype";
	public static final String UEMAIL = "uemail";
	public static final String USEX = "usex";
	public static final String UHEAD = "uhead";
	public static final String UINTEREST = "uinterest";
	public static final String USCHOOL = "uschool";
	public static final String UGRADE = "ugrade";
	public static final String USTATE = "ustate";

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			Session s=getSession();
			s.save(transientInstance);
			s.beginTransaction().commit();
			s.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			Session s=getSession();
			s.delete(persistentInstance);
			s.beginTransaction().commit();

			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public User findById(java.lang.Integer id) {
		Query query=getSession().createQuery("from User where id=?");
		query.setInteger(0,id);
		List<User> list=query.list();
		if(list.size()>0){
			User user=(User)list.get(0);
			getSession().close();
			return user;
		}
		getSession().close();
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getSession().createCriteria(
			"com.hwadee.xingqu.model.User").add(create(instance))
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
			String queryString = "from User as model where model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByUname(Object uname) {
		return findByProperty(UNAME, uname);
	}

	public List<User> findByUpassword(Object upassword) {
		return findByProperty(UPASSWORD, upassword);
	}

	public List<User> findByUtype(Object utype) {
		return findByProperty(UTYPE, utype);
	}

	public List<User> findByUemail(Object uemail) {
		return findByProperty(UEMAIL, uemail);
	}

	public List<User> findByUsex(Object usex) {
		return findByProperty(USEX, usex);
	}

	public List<User> findByUhead(Object uhead) {
		return findByProperty(UHEAD, uhead);
	}

	public List<User> findByUinterest(Object uinterest) {
		return findByProperty(UINTEREST, uinterest);
	}

	public List<User> findByUschool(Object uschool) {
		return findByProperty(USCHOOL, uschool);
	}

	public List<User> findByUgrade(Object ugrade) {
		return findByProperty(UGRADE, ugrade);
	}

	public List<User> findByUstate(Object ustate) {
		return findByProperty(USTATE, ustate);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			getSession().beginTransaction().commit();
			getSession().close();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			Session s=getSession();
			s.saveOrUpdate(instance);
			s.beginTransaction().commit();
			s.close();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);

		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public boolean validator(User user)
	{

		List<User> userlist=findByProperty("unick", user.getUnick());
		if(userlist.size()!=0)
		{
			for(User u:userlist)
			{ 
				System.out.println("dfasfasdfa"+u.getUpassword()+"     "+user.getUpassword());
				if(user.getUpassword().equals(u.getUpassword()))
				{
					System.out.println(u.getUnick());
					return true;
				}
				else
				{
					return false;
				}

			}
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public User findByUnick( String nick) {
		try {
			String queryString = "from User as model where model.unick= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, nick);
			List<User> user=queryObject.list();
			if(user.size()!=0)
			{				
				User u=(User)user.get(0);
				getSession().close();
				return u;   			
			}
		} catch (RuntimeException re) {
			throw re;
		}
		return null;
	}
}