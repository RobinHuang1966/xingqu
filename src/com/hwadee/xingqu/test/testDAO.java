package com.hwadee.xingqu.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.hwadee.xingqu.sessionfactory.HibernateSessionFactory;

import com.hwadee.xingqu.dao.FriendDAO;
import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.PagingDAO;
import com.hwadee.xingqu.dao.ThemeDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Friend;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Theme;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;


public class testDAO {

//	//	@Test
//	//	public void testDelete() {
//	//
//	//		Session session=HibernateSessionFactory.getSession();
//	//		TopicDAO topicdao= new TopicDAO();
//	//
//	//		topicdao.delete(115);
//	//
//	//
//	//	}
//	//		@Test
//	//		public void testAdd()
//	//		{
//	//			Topic topic = new Topic();
//	//			topic.setTcontent("dasda");
//	//			topic.setUid(12);
//	//			topic.setTcreateTime(new Date());
//	//			topic.setTtitle("dadas");
//	//			TopicDAO topicDAO= new TopicDAO();
//	//			topicDAO.save(topic);
//	//			System.out.println(topicDAO.findAll().size());
//	//	
//	//		}
//	//	@Test
//	//	public void testUpdate() throws Exception
//	//	{
//	//		TopicDAO topic = new TopicDAO();
//	//		topic.updateTopic(117,23, "����", "�����������˵�");
//	//	}
//	//	@Test
//	//	public void testFindById(){
//	//		UserDAO userDAO= new UserDAO();
//	//		User u= new User();
//	////		User user= userDAO.findById(2);
//	////		User u= new User();
//	////		u.setUname("����");
//	////		u.setUnick("�Ǻ�");
//	////		u.setUpassword("123");
//	////		u.setUregTime(new Timestamp(new Date().getTime()));
//	////		u.setUsex("0");
//	////		u.setUtype("0");
//	////		u.setUstate(0);
//	////		userDAO.save(u);
//	//		u.setUnick("�Ǻ�");
//	//		u.setUpassword("123");
//	//		System.out.print(userDAO.validator(u));
//	//	}
//
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}
//	//@Test
//	//	public void testFindBy()
//	//	{
//	//		UserDAO userDAO= new UserDAO();
//	//		User u=new User();
//	//		u.setUnick("zhangyong");
//	//		u.setUpassword("123");
//	//	
//	//		System.out.println(userDAO.validator(u));
//	//		
//	//	}
//
//	//	@Test
//	//	public void testFindfuzzy()
//	//	{
//	//		TopicDAO userDAO= new TopicDAO();
//	//		System.out.println(userDAO.findFuzzy("1").get(0).getTcontent());
//	//		
//	//	}
//	//	@Test
//	//	public void testTopic()
//	//	{
//	//		TopicDAO topicDAO= new TopicDAO();
//	//		System.out.println(topicDAO.findById(2).getUser().getUnick());
//	//	}
//	//	@Test
//	//	public void testwork()
//	//	{
//	//		WorksDAO topicDAO= new WorksDAO();
//	//		System.out.println(topicDAO.findAll().size());
//	//	}
//	//	@Test
//	//	public void testwordk()
//	//	{
//	//		WorksDAO topicDAO= new WorksDAO();
//	//		System.out.println(topicDAO.findById(1).getWname());
//	//	}
//	//	@Test
//	//	public void testwordd()
//	//	{
//	//		PagingDAO pagingDAO= new PagingDAO();
//	//		System.out.println("������Ϊ��"+pagingDAO.getPlanNum("Works"));
//	//	}
//	//
//	//	@Test
//	//	public void testfriend()
//	//	{
//	//		UserDAO pagingDAO= new UserDAO();
//	//		User user=pagingDAO.findByUnick("x");
//	//		System.out.println("uname:"+user.getLogers());
//	////	}
//	//	@Test
//	//	public void testthree()
//	//	{       UserDAO userDAO=new UserDAO();
//	//		LogerDAO logerDAO=new LogerDAO();
//	//		TopicDAO  topicDAO=new TopicDAO();
//	//		List list=logerDAO.findByThreeproperty("topic",0,userDAO.findById(11),topicDAO.findById(19));
//	//		System.out.print(list.size());
//	//	}
//
//	@Test
//	public void testdeleteWork()
//	{
//		WorksDAO worksDAO= new WorksDAO();
//		Works works= worksDAO.findById(36);
//		LogerDAO logdao=new LogerDAO();
//		works.setUser(null);
//		List<Loger> list=new ArrayList<Loger>();
//		for(int i=0;i<list.size();++i)
//		{
//	             logdao.delete(list.get(i));
//		}
//		worksDAO.attachDirty(works);	    
//		worksDAO.delete(works);
////		UserDAO userDAO= new UserDAO();
////		userDAO.delete(userDAO.findById(9));
//	}
//	@Test
//	public void saveGroup()
//	{
//		Group g=new Group();
//		User  u=new User();
//		Theme th=new Theme(); 
//		UserDAO udao = new UserDAO();//Ĭ��Ϊ0����ʾû��ͨ����֤
//		ThemeDAO thd= new ThemeDAO();
// 		u=udao.findByUnick("aaa");
//		th=thd.findById(3);
//		
//	    g.setUser(u);
//		g.setGtitle("dasdasd");
//		g.setGbrief("dasfdasfasdfasdf");
//		g.setGcreateTime(new Timestamp(new Date().getTime()));
//		g.setGisVerify(0);   
//		g.setTheme(th);
//		System.out.println(th);
//		GroupDAO groupDAO= new GroupDAO();
//		groupDAO.save(g);
//		
//		
//	}
//	@Test
//	public void testFriend()
//	{
//		FriendDAO friendDAO= new FriendDAO();
//		UserDAO userDAO= new UserDAO();
//		User user=userDAO.findById(20);
//		System.out.println(friendDAO.findByFuid(user));
//		
//	}
//	@Test
//	public void testLogerFind()
//	{
//		UserDAO userDAO= new UserDAO();
//		GroupDAO groupDAO= new GroupDAO();
//		Loger loger=new Loger();
//		loger.setLtype(3);            //6�ż���С��
//		loger.setUid(userDAO.findByUnick("aaa").getUid());
//	    
//        LogerDAO logerDAO=new LogerDAO();
//		System.out.println(logerDAO.findByExample(loger).size());
//	
//	}
//	@Test
//	public void testPagingDAO()
//	{
//		PagingDAO pagingDAO=new PagingDAO();
//		System.out.println(pagingDAO.findPlantByPage("Works","wloadNum","desc"));
//	}
//	@Test
//	public void testGroupDAO()
//	{
//		ThemeDAO groupDAO=new ThemeDAO();
//		System.out.println("ǰ̨���������thname��"+groupDAO.findByThName("�ﻯ֮��").size());
//	}
	@Test
	public void testByExample()
	{
		GroupDAO groupDAO=new GroupDAO();
		UserDAO userDAO=new UserDAO();
		Group gg=groupDAO.findById(2);
		Loger loger=new Loger();
		//loger.setGroup(gg);
		loger.setLtype(6);
		User user=new User();
		user=userDAO.findById(5);//5号是aaa
		loger.setUser(user);
		LogerDAO logerDAO=new LogerDAO();
		System.out.println(logerDAO.findByThreeproperty("group", 6, user, gg));
	}
	@Test
	public void testAddFriend()
	{
		UserDAO userDAO=new UserDAO();
		FriendDAO friendDAO =new FriendDAO();
		System.out.println(friendDAO.findByTwoproperty(userDAO.findById(5),userDAO.findById(30)).size());
	}
	
	@Test
	public void testAdd()
	{
		TopicDAO topicDAO=new TopicDAO();
		UserDAO userDAO=new UserDAO();
		System.out.println(topicDAO.findByUid(userDAO.findById(1)));
	}
	@Test
	public void testFuzzy()
	{
		PagingDAO pagDAO= new PagingDAO();
		//pagDAO.findFuzzy("Group", "ttitle","����");
		System.out.println(pagDAO.findFuzzy("Group", "gtitle","����").size());
	}

}
