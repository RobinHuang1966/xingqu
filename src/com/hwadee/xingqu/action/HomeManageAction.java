package com.hwadee.xingqu.action;

import java.util.ArrayList;
import java.util.List;

import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.PagingDAO;
import com.hwadee.xingqu.dao.ThemeDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Friend;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeManageAction extends ActionSupport{
	/**
	 * @author ��͢��
	 * @since 2013-07-09
	 * ��ʾ�û���԰��Ϣ
	 */
	private static final long serialVersionUID = 7631711725405165669L;
	private Topic topic;
	private Works works;
	private User user;
	private Friend friend;
	private Loger loger;
	private int uid;
	private int puid;
	private int lid;
	private int wid;
	private int fid;
	private List<Loger> myShareList=new ArrayList<Loger>();
	private List<Friend> myFriendList=new ArrayList<Friend>();
	private List<Loger> myGroupList=new ArrayList<Loger>();
	private List<Loger> joinGroupList=new ArrayList<Loger>();
	private List<Topic> myTopicList=new ArrayList<Topic>();
	private List<Works> myWorksList=new ArrayList<Works>();
	private List<Loger> myMessageList=new ArrayList<Loger>();
	private List<User> myInforList=new ArrayList<User>();
	private List<Loger> myDynamicList=new ArrayList<Loger>();

	WorksDAO worksDAO=new WorksDAO();
	TopicDAO topicDAO=new TopicDAO();
	GroupDAO groupDAO=new GroupDAO();
	ThemeDAO ThemeDAO=new ThemeDAO();
	UserDAO userDAO=new UserDAO();
	LogerDAO logerDAO=new LogerDAO();
	PagingDAO pagingDAO=new PagingDAO();
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
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
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public Loger getLoger() {
		return loger;
	}
	public void setLoger(Loger loger) {
		this.loger = loger;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPuid() {
		return puid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public void setPuid(int puid) {
		this.puid = puid;
	}
	public List<Loger> getMyShareList() {
		return myShareList;
	}
	public void setMyShareList(List<Loger> myShareList) {
		this.myShareList = myShareList;
	}
	public List<Friend> getMyFriendList() {
		return myFriendList;
	}
	public void setMyFriendList(List<Friend> myFriendList) {
		this.myFriendList = myFriendList;
	}
	public List<Loger> getMyGroupList() {
		return myGroupList;
	}
	public void setMyGroupList(List<Loger> myGroupList) {
		this.myGroupList = myGroupList;
	}
	public List<Loger> getJoinGroupList() {
		return joinGroupList;
	}
	public void setJoinGroupList(List<Loger> joinGroupList) {
		this.joinGroupList = joinGroupList;
	}
	public List<Topic> getMyTopicList() {
		return myTopicList;
	}
	public void setMyTopicList(List<Topic> myTopicList) {
		this.myTopicList = myTopicList;
	}
	
	public List<Works> getMyWorksList() {
		return myWorksList;
	}
	public void setMyWorksList(List<Works> myWorksList) {
		this.myWorksList = myWorksList;
	}
	public List<Loger> getMyMessageList() {
		return myMessageList;
	}
	public void setMyMessageList(List<Loger> myMessageList) {
		this.myMessageList = myMessageList;
	}
	public List<User> getMyInforList() {
		return myInforList;
	}
	public void setMyInforList(List<User> myInforList) {
		this.myInforList = myInforList;
	}
	public List<Loger> getMyDynamicList() {
		return myDynamicList;
	}
	public void setMyDynamicList(List<Loger> myDynamicList) {
		this.myDynamicList = myDynamicList;
	}
	
	
	public String listMyDynamic()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		this.myDynamicList=logerDAO.findByUid(user.getUid());
		return SUCCESS ;
	}
	
	public String listMyGroup()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		Loger loger=new Loger();
		//loger.setUid(user.getUid());
		loger.setUser(user);
		loger.setLtype(18);//表示创建小组
		this.myGroupList=logerDAO.findByExample(loger);
		//this.myGroupList=logerDAO.findByUid(user.getUid());
		return SUCCESS ;
	}
	
	public String deleteMyGroup()
	{
		Loger loger=new Loger();
		loger=logerDAO.findById(lid);
		logerDAO.delete(loger);
		return SUCCESS ;
	}
	
	public String listJoinGroup()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		Loger loger=new Loger();
		//loger.setUid(user.getUid());
		loger.setUser(user);
		loger.setLtype(17);//表示加入小组
		this.joinGroupList=logerDAO.findByExample(loger);
		//this.myGroupList=logerDAO.findByUid(user.getUid());
		return SUCCESS ;
	}
	public String deleteJoinGroup()
	{
		Loger loger=new Loger();
		loger=logerDAO.findById(lid);
		logerDAO.delete(loger);
		return SUCCESS ;
	}
	
	@SuppressWarnings("unchecked")
	public String listMyShare()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		this.myShareList=logerDAO.findMyShareByProperty("uid", user.getUid());
		return SUCCESS ;
	}
	public String deleteMyShare()
	{
		Loger loger=new Loger();
		loger=logerDAO.findById(lid);
		logerDAO.delete(loger);
		return SUCCESS ;
	}
	@SuppressWarnings("unchecked")
	public String listMyWorks()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		this.myWorksList=worksDAO.findByProperty("user", user);
		return "success";
	}
	public String deleteMyWorks()
	{
		Works works=new Works();
		works=worksDAO.findById(wid);
		worksDAO.delete(works);
		return "success";
	}
	
	public String listHome()
	{
		this.listJoinGroup();
		this.listMyGroup();
		return "success";
	}
	public String listMyMessage()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		Loger loger=new Loger();
		loger.setPuser(user);
		loger.setLtype(15);//表示留言
		this.myMessageList=logerDAO.findByExample(loger);
		return "success";
	}
	public String listMyInfor()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		this.myInforList=userDAO.findByExample(user);
		return "success";
	}
}
