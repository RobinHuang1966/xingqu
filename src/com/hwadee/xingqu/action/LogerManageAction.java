package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogerManageAction extends ActionSupport {

	/**
	 * @author 张勇 黄廷鹏
	 * @since 2013-07-06
	 * 此类用于loger表的增删改查
	 */
	private static final long serialVersionUID = 5090925270474841787L;
	private Integer lid;
	private Topic topic;
	private Loger loger;
	private Works works;
	private User user;
	private Integer puid;
	private Integer flag;
	private String lcontent;
	private Timestamp ltime;
	private Integer ltype;
	private int tid;
	private int wid;
	private int uid;
	private LogerDAO logDAO= new LogerDAO();
	private UserDAO userDAO= new UserDAO();
	private WorksDAO worksDAO=new WorksDAO();
	private GroupDAO groupDAO=new GroupDAO();
	private LogerDAO logerDAO =new LogerDAO();
	private TopicDAO topicDAO=new TopicDAO();
	private List<Loger> myDynamicList;
	private  int URL;
	private int gid;
	private int fid;
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Loger getLoger() {
		return loger;
	}
	public void setLoger(Loger loger) {
		this.loger = loger;
	}
	public Works getWorks() {
		return works;
	}
	public void setWorks(Works works) {
		this.works = works;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPuid() {
		return puid;
	}
	public void setPuid(Integer puid) {
		this.puid = puid;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getLcontent() {
		return lcontent;
	}
	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}
	public Timestamp getLtime() {
		return ltime;
	}
	public void setLtime(Timestamp ltime) {
		this.ltime = ltime;
	}
	public Integer getLtype() {
		return ltype;
	}
	public void setLtype(Integer ltype) {
		this.ltype = ltype;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getURL() {
		return URL;
	}
	public void setURL(int uRL) {
		URL = uRL;
	}

	public LogerDAO getLogDAO() {
		return logDAO;
	}
	public void setLogDAO(LogerDAO logDAO) {
		this.logDAO = logDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public WorksDAO getWorksDAO() {
		return worksDAO;
	}
	public void setWorksDAO(WorksDAO worksDAO) {
		this.worksDAO = worksDAO;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public void setMyDynamicList(List<Loger> myDynamicList) {
		this.myDynamicList = myDynamicList;
	}
	public List<Loger> getMyDynamicList() {
		return myDynamicList;
	}
	@SuppressWarnings("static-access")
	/*
	 * 回复话题Ltype=1,flag=0
	 * 
	 */
	public String replyTopic()
	{		
		Loger loger= new Loger();
		User user=(User) ActionContext.getContext().getContext().getSession().get("user");
		loger.setLtype(1);  //1号回复话题                         
		//loger.setUid(user.getUid()); 
		loger.setUser(user);
		Topic TT=(Topic) ActionContext.getContext().getContext().getSession().get("topic");
		TT.setTreplynum(TT.getTreplynum()+1);
		topicDAO.attachDirty(TT);
		URL=TT.getTid();
		loger.setTopic(TT);
		loger.setLtime(new Timestamp(new Date().getTime()));
		loger.setFlag(0);
		loger.setPuser(TT.getUser());
		//loger.setUser(user);
		loger.setLcontent(lcontent);

		System.out.println(lcontent);
		logDAO.save(loger);
		return SUCCESS;
	}
	/*
	 * 分享话题Ltype=2标志位flag=0
	 * 
	 */
	public String shareTopic()
	{
		Loger loger= new Loger();
		User user=(User) ActionContext.getContext().getSession().get("user");
		loger.setLtype(2);     
		//loger.setUid(user.getUid());
		loger.setUser(user);
		Topic TT=topicDAO.findById(tid);
		loger.setTopic(TT);
		if(logerDAO.findByThreeproperty("topic", 2, user, TT).size()>0)
		{
			return ERROR;
		}
		else
		{
			loger.setLtime(new Timestamp(new Date().getTime()));
			loger.setFlag(0);
			loger.setLcontent(TT.getTtitle());		
			loger.setPuser(TT.getUser());
			logDAO.save(loger);
			return SUCCESS;
		}
	}
	@SuppressWarnings("unchecked")
	public String deleteShareTopic()
	{
		User user=(User) ActionContext.getContext().getSession().get("user");
		Topic topic=topicDAO.findById(tid);
		//List<Loger> logerlist=logerDAO.findByTwoproperty1("ltype",2,"topic",topic);
		List<Loger> logerlist=logerDAO.findByThreeproperty("topic", 2, user, topic);
		logerlist.get(0).setTopic(null);
		logerDAO.merge(logerlist.get(0));
		logerDAO.delete(logerlist.get(0));//2号是分享话题
//		Iterator<Loger> it = logerlist.iterator();
//		while (it.hasNext()) {
//		    it.next();
//		    logerDAO.delete((Loger)it.next());
//		}
		
		return SUCCESS;
	}
	/*
	 * 关注话题 Ltype=3标志位flag=0
	 * 
	 */
	@SuppressWarnings("static-access")
	public String attentionTopic()
	{
		Loger loger= new Loger();
		User user=(User) ActionContext.getContext().getContext().getSession().get("user");	
		loger.setLtype(3);		              
		//loger.setUid(user.getUid()); 	
		loger.setUser(user);
		Topic TT=topicDAO.findById(tid);
		loger.setTopic(TT);

		if(logerDAO.findByThreeproperty("topic", 3, user, TT).size()>0)
		{
			return ERROR;
		}
		else
		{  System.out.println();
			loger.setLtime(new Timestamp(new Date().getTime()));
			loger.setFlag(0);
			loger.setLcontent(TT.getTtitle());
			loger.setPuser(TT.getUser());
			logDAO.save(loger);
			return SUCCESS;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String deleteAttentionTopic()
	{
		User user=(User) ActionContext.getContext().getSession().get("user");
		Topic topic=topicDAO.findById(tid);
		List<Loger> logerlist=logerDAO.findByThreeproperty("topic", 3, user, topic);
		logerlist.get(0).setTopic(null);
		logerDAO.merge(logerlist.get(0));
		logerDAO.delete(logerlist.get(0));//3号是关注话题
		
		return SUCCESS;
	}
	@SuppressWarnings("static-access")
	/*
	 * 赞作品Ltype=11标志位flag=1
	 * 
	 */
	public String  goodWorks()
	{
		Loger loger= new Loger();
		User user=(User) ActionContext.getContext().getContext().getSession().get("user");
		loger.setLtype(11);                     
		//loger.setUid(user.getUid());	
		loger.setUser(user);
		Works W=worksDAO.findById(wid);
		loger.setWorks(works);
		W.setWgood(W.getWgood()+1);
		worksDAO.attachDirty(W);
		loger.setLtime(new Timestamp(new Date().getTime()));
		loger.setFlag(1);
		loger.setLcontent(lcontent);
		logDAO.save(loger);
		return SUCCESS;
	}
	/*
	 *踩作品Ltype=12标志位flag=1
	 * 
	 */
	@SuppressWarnings("static-access")
	public String  badWorks()
	{

		Loger loger= new Loger();
		User user=(User) ActionContext.getContext().getContext().getSession().get("user");
		loger.setLtype(12);                     //4�号表示踩作品
		//loger.setUid(user.getUid());	
		loger.setUser(user);
		Works W=worksDAO.findById(wid);
		loger.setWorks(works);
		W.setWbad(W.getWbad()+1);
		worksDAO.attachDirty(W);
		loger.setLtime(new Timestamp(new Date().getTime()));
		loger.setFlag(1);
		loger.setLcontent(lcontent);
		logDAO.save(loger);
		return SUCCESS;
	}
	/*
	 * 分享作品Ltype=10标志位flag=0
	 * 
	 */
	@SuppressWarnings("static-access")
	public String shareWorks()
	{
		Loger loger= new Loger();

		User user=(User) ActionContext.getContext().getContext().getSession().get("user");
		loger.setLtype(10);
		//loger.setUid(user.getUid());
		loger.setUser(user);
		Works W=worksDAO.findById(wid);
		loger.setWorks(W);
		if(logerDAO.findByThreeproperty("works", 10, user, W).size()>0)
		{
			return ERROR;
		}
		else
		{
			loger.setLtime(new Timestamp(new Date().getTime()));
			loger.setFlag(0);
			loger.setLcontent(lcontent);	
			logDAO.save(loger);
			return SUCCESS;
		}	
	}
	/*
	 * 加入小组 Ltype=17标志位flag=0
	 * 
	 */
	public String joinGroup()
	{
		Loger loger= new Loger();
		Group G=groupDAO.findById(gid);
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(logerDAO.findByThreeproperty("group", 17, user, G).size()>0)
		{
			return ERROR;
		}
		else
		{
			loger.setLtype(17);    //17号表示加入小组       
			//loger.setUid(user.getUid());
			loger.setUser(user);
			loger.setGroup(G);
			G.setUnum(G.getUnum()+1);
			groupDAO.attachDirty(G);
			loger.setLtime(new Timestamp(new Date().getTime()));
			loger.setFlag(0);
			loger.setLcontent(lcontent);
			logDAO.save(loger);
			return SUCCESS;
		}
	}
	/*
	 * 退出小组 Ltype=9标志位flag=0
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public String exitGroup()
	{   
		Group G=new Group();
		G=groupDAO.findById(gid);
		G.setUnum(G.getUnum()-1);//小组内成员数自减
		groupDAO.attachDirty(G);
		User user=(User) ActionContext.getContext().getSession().get("user");
//		Loger loger1= new Loger();
//		loger1.setLtype(17);      //17号表示加入小组。               
//		//loger1.setUid(user.getUid());
//		loger1.setUser(user);
		if(logerDAO.findByThreeproperty("group", 17, user, G).size()>0)	
		{
//			loger.setGroup(G); 
//			logerDAO.delete(logerDAO.findByExample(loger).get(0));
//			logDAO.delete(loger);
			List<Loger> logerlist=logerDAO.findByThreeproperty("group", 17, user, G);
			logerlist.get(0).setGroup(null);
			logerDAO.merge(logerlist.get(0));
			logerDAO.delete(logerlist.get(0));
			
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	/**
	 * 
	 * @return success
	 * 删除loger日志̬
	 */
	public String deleteLoger()
	{
		Loger loger= new Loger();
		loger=logDAO.findById(lid);
		logDAO.delete(loger);
		return ERROR;
	}

	/**
	 * 
	 * @return success
	 * 留言操作标志位ltype=15
	 */
	@SuppressWarnings("static-access")
	public String leaveMessage()
	{
		System.out.println("lcontent"+lcontent);
		user=(User) ActionContext.getContext().getSession().get("user");
		Loger loger=new Loger();
		User friend=(User) ActionContext.getContext().getContext().getSession().get("friend");
		if(friend==null)
		{
			return ERROR;
		}
		System.out.println(friend.getUemail());
		loger.setPuser(friend);
		loger.setLcontent(lcontent);
	//	loger.setUid(user.getUid());
		loger.setUser(user);
		loger.setLtype(15);
		loger.setFlag(0);
		loger.setLtime(new Timestamp(new Date().getTime()));
		logDAO.save(loger);
		return SUCCESS ;
	}
}
