package com.hwadee.xingqu.action;

import java.util.List;

import com.hwadee.xingqu.dao.*;
import com.hwadee.xingqu.model.*;
import com.opensymphony.xwork2.ActionSupport;

public class TotalAction extends ActionSupport {

	private int onlineUser=0;
	private int regUser=0;
	private int allGroup=0;
	private int groupcount=0;
	private int topicCount=0;
	private int topicReply=0;
	
	private User user;
	private UserDAO userdao;
	private List<User> userlist;
	
	private ThemeDAO themedao;
	private Theme mytheme;
	private int ThId;
	
	private GroupDAO groupdao;
	private Group group;
	private int gid;
	
	private TopicDAO topicdao;
	private Topic topic;
	private int tid;
	
	/**
	 * ͳ�������û���
	 * @return String
	 */
	public String totalOnlineUser(){
		
		userdao=new UserDAO();
		
		userlist=userdao.findAll();
		
		for(User u:userlist){
			if(u.getUstate().equals(1));
				onlineUser++;	
		}
		return "ok";
	}

	/**
	 * ͳ��ע���û���
	 * @return String
	 */
	public String totalRegUser(){
		
		userdao=new UserDAO();
		
		regUser=userdao.findAll().size();
		
		return "ok";
	}

	/**
	 * ͳ������С������
	 * @return String
	 */
	public String totalAllGroup(){
		
		groupdao=new GroupDAO();
		allGroup=groupdao.findAll().size();
		
		return "ok";
	}

	/**
	 * ͳ��ĳ�������С������
	 * @return String
	 */
	public String totalGroup(){
		
		themedao=new ThemeDAO();
		mytheme=themedao.findById(ThId);
		groupcount=mytheme.getGroups().size();
		
		return "ok";
	}
	
	/**
	 * ͳ��С���ڻ�������
	 * @return String
	 */
	public String totalTopic(){
		
		groupdao=new GroupDAO();
		group=groupdao.findById(gid);
		topicCount=group.getTopics().size();
		//topicCount=group.getTopicNum();
		return "ok";
	}
	
	/**
	 * ͳ��ĳ������Ļظ���
	 * @return String
	 */
	public String totalTopicReply(){
		
		topicdao=new TopicDAO();
		topic=topicdao.findById(tid);
		//topicReply=topic.getReplyNum();
		
		return "ok";
	}
	
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(int onlineUser) {
		this.onlineUser = onlineUser;
	}

	public int getRegUser() {
		return regUser;
	}

	public void setRegUser(int regUser) {
		this.regUser = regUser;
	}

	public int getAllGroup() {
		return allGroup;
	}

	public void setAllGroup(int allGroup) {
		this.allGroup = allGroup;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public GroupDAO getGroupdao() {
		return groupdao;
	}

	public void setGroupdao(GroupDAO groupdao) {
		this.groupdao = groupdao;
	}

	public ThemeDAO getThemedao() {
		return themedao;
	}

	public void setThemedao(ThemeDAO themedao) {
		this.themedao = themedao;
	}

	public Theme getMytheme() {
		return mytheme;
	}

	public void setMytheme(Theme mytheme) {
		this.mytheme = mytheme;
	}

	public int getThId() {
		return ThId;
	}

	public void setThId(int thId) {
		ThId = thId;
	}
	public int getGroupcount() {
		return groupcount;
	}

	public void setGroupcount(int groupcount) {
		this.groupcount = groupcount;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	
}
