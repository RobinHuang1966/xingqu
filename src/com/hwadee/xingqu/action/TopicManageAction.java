package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TopicManageAction extends ActionSupport {
	/**
	 * @author ����
	 * @since 2013-07-08
	 * �������ڻ������ɾ�Ĳ�
	 */
	private static final long serialVersionUID = -6290307917240854825L;
	private Integer tid;
	private Group group;
	private User user;
	private String ttitle;
	private String gtitle;
	private String tcontent;
	private Timestamp tcreatTime;
	private Topic topic;
	private int shareNum;
	private int attentionNum;
	private int treplynum;
	
	private List<Topic> topiclist;
	private List<Group> grouplist;
	private List<String> groupNames=new ArrayList<String>();
	private List<Loger> logerList=new ArrayList<Loger>();
	TopicDAO topicDAO = new TopicDAO();
	GroupDAO groupDAO = new GroupDAO();
	LogerDAO logerDAO=new LogerDAO();
	private ActionContext ctx=ActionContext.getContext();
	private int gid;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public Timestamp getTcreatTime() {
		return tcreatTime;
	}
	public void setTcreatTime(Timestamp tcreatTime) {
		this.tcreatTime = tcreatTime;
	}
	public void setTreplynum(int treplynum) {
		this.treplynum = treplynum;
	}
	public int getTreplynum() {
		return treplynum;
	}
	public List<Topic> getTopiclist() {
		return topiclist;
	}
	public void setTopiclist(List<Topic> topiclist) {
		this.topiclist = topiclist;
	}
	public List<Loger> getLogerList() {
		return logerList;
	}
	public void setLogerList(List<Loger> logerList) {
		this.logerList = logerList;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getShareNum() {
		return shareNum;
	}
	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}
	public int getAttentionNum() {
		return attentionNum;
	}
	public void setAttentionNum(int attentionNum) {
		this.attentionNum = attentionNum;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public String getGtitle() {
		return gtitle;
	}
	/**
	 * ��ӻ���
	 */
	@SuppressWarnings("static-access")
	public String  addTopic()
	{
		Topic topic = new Topic();
		topic.setTcontent(tcontent);
		topic.setTcreatTime(new Timestamp(new Date().getTime()));
		topic.setTtitle(ttitle);
		//Group group=(Group) ActionContext.getContext().getSession().get("group");
		//gid=group.getGid();
		Group group=groupDAO.findById(65);//65是巴黎
		topic.setGroup(group);
		topic.setTreplynum(0);
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		UserDAO userDAO=new UserDAO();
		User u=userDAO.findByUnick(unick);
		topic.setUser(u);
		TopicDAO topicDAO= new TopicDAO();
		topicDAO.save(topic);
		
		Loger loger= new Loger();//将创建话题保存到loger中
		loger.setLtype(5);  //5号创建话题                         
		//loger.setUid(u.getUid()); 
		loger.setUser(u);
		loger.setTopic(topic);
		loger.setLtime(topic.getTcreatTime());
		loger.setFlag(0);
		loger.setLcontent(tcontent);
		logerDAO.save(loger);
		return SUCCESS;
	}
	
	public String topicList()
	{
		TopicDAO topicDAO = new TopicDAO();
		this.topiclist=topicDAO.findAll();
		return SUCCESS;
	}

	public String deleteTopic()
	{
		Topic topic=new Topic();//存在级联删除问题，如何解决？？？？？
		topic=topicDAO.findById(tid);
		//List<Loger> logerlist=logerDAO.findByTwoproperty1("ltype",5,"topic",topic);
		//logerDAO.delete(logerlist.get(0));//5号是创建话题
//		List<Loger> logerlist=logerDAO.findByTid(tid);
//		Iterator<Loger> it = logerlist.iterator();
//		while (it.hasNext()) {
//		    it.next();
//		    logerDAO.delete((Loger) it.next());
//		}
//		
		Group group=topicDAO.findById(tid).getGroup();
		group.setTnum(group.getTnum()-1);
		groupDAO.attachDirty(group);
		
		topic.setUser(null);
		topic.setGroup(null);
		topicDAO.merge(topic);
		topicDAO.delete(topic.getTid());
		return SUCCESS;	
	}
	
	public String updateTopic() throws Exception
	{
		if(tid > 0){
			Topic TP= new Topic();
			TP=topicDAO.findById(tid);
			TP.setTcontent(tcontent);
			TP.setTtitle(ttitle);
			TP.setTid(tid);
	
			Group g=new Group();
			g=groupDAO.findByGtitle(gtitle).get(0);
			TP.setGroup(g);
			//topicDAO.merge(TP);
			topicDAO.attachDirty(TP);
			//topicDAO.updateTopic(TP);
		}
		else{
			Topic topic = new Topic();
			topic.setTcontent(tcontent);
			topic.setTcreatTime(new Timestamp(new Date().getTime()));
			topic.setTtitle(ttitle);
			Group group=groupDAO.findByGtitle(gtitle).get(0);
			topic.setGroup(group);
			topic.setTreplynum(0);
			String unick=(String) ActionContext.getContext().getSession().get("unick");
			UserDAO userDAO=new UserDAO();
			User u=userDAO.findByUnick(unick);
			topic.setUser(u);
			TopicDAO topicDAO= new TopicDAO();
			topicDAO.save(topic);
			
			Loger loger= new Loger();//将创建话题保存到loger中
			loger.setLtype(5);  //5号创建话题                         
			//loger.setUid(u.getUid());
			loger.setUser(u);
			loger.setTopic(topic);
			loger.setLtime(topic.getTcreatTime());
			loger.setFlag(0);
			loger.setLcontent(tcontent);
			logerDAO.save(loger);
		}
		return SUCCESS;
	}
	/**
	 * ��ʾ��������
	 */
	@SuppressWarnings("unchecked")
	public String showTopicsimple()
	{	
		if( tid!=0)
		{
			Topic TP=topicDAO.findById(tid);
			this.setTid(TP.getTid());
			this.setUser(TP.getUser());
			this.setTcontent(TP.getTcontent());
			this.setTtitle(TP.getTtitle());
			this.setTcreatTime(TP.getTcreatTime());
		}
		
		grouplist=groupDAO.findAll();
		for(int i=0;i<grouplist.size();++i)
		{
			groupNames.add(grouplist.get(i).getGtitle());
		}
		return SUCCESS;
	}
	
	public String showTopic()
	{
		topic=topicDAO.findById(tid);
		logerList = logerDAO.findByTid(tid,1);//1号表示回复话题
		ActionContext.getContext().getSession().put("topic", topic);
		return SUCCESS;
	}
	
	public String findTopics()
	{
		TopicDAO topicDAO= new TopicDAO();
		this.topiclist=topicDAO.findFuzzy(tcontent);
		return SUCCESS;
	}
	public void setGroupNames(List<String> groupNames) {
		this.groupNames = groupNames;
	}
	public List<String> getGroupNames() {
		return groupNames;
	}
	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}
	public List<Group> getGrouplist() {
		return grouplist;
	}
}
