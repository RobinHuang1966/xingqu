package com.hwadee.xingqu.action;

import java.util.ArrayList;
import java.util.List;

import com.hwadee.xingqu.dao.PagingDAO;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class GroupListAction extends ActionSupport {
	/**
	 * @author ����
	 * ������ʾС�����ϸ��Ϣ
	 */
	private static final long serialVersionUID = 3811471171471203906L;
	private List<Group> grouplist=new ArrayList<Group>();
	private List<User> userlist;
	private List<Topic> topiclist;
	private PagingDAO pagingDAO=new PagingDAO();
	private int grouppage=1;
	private int userpage=1;
	private int topicpage=1;
	private int grouprowsPerPage=16;
	private int userrowsPerPage=15;
	private int topicrowsPerPage=15;
	private int grouptotalPage;
	private int usertotalPage;
	private int topictotalPage;

	private int grouptotal;
	private int usertotal;
	private int topictotal;
	public int getGrouprowsPerPage() {
		return grouprowsPerPage;
	}
	public void setGrouprowsPerPage(int grouprowsPerPage) {
		this.grouprowsPerPage = grouprowsPerPage;
	}
	public int getUserrowsPerPage() {
		return userrowsPerPage;
	}
	public void setUserrowsPerPage(int userrowsPerPage) {
		this.userrowsPerPage = userrowsPerPage;
	}
	public int getTopicrowsPerPage() {
		return topicrowsPerPage;
	}
	public void setTopicrowsPerPage(int topicrowsPerPage) {
		this.topicrowsPerPage = topicrowsPerPage;
	}
	public int getGrouptotalPage() {
		return grouptotalPage;
	}
	public void setGrouptotalPage(int grouptotalPage) {
		this.grouptotalPage = grouptotalPage;
	}
	public int getUsertotalPage() {
		return usertotalPage;
	}
	public void setUsertotalPage(int usertotalPage) {
		this.usertotalPage = usertotalPage;
	}
	public int getTopictotalPage() {
		return topictotalPage;
	}
	public void setTopictotalPage(int topictotalPage) {
		this.topictotalPage = topictotalPage;
	}
	public int getGrouptotal() {
		return grouptotal;
	}
	public void setGrouptotal(int grouptotal) {
		this.grouptotal = grouptotal;
	}
	public int getUsertotal() {
		return usertotal;
	}
	public void setUsertotal(int usertotal) {
		this.usertotal = usertotal;
	}
	public int getTopictotal() {
		return topictotal;
	}
	public void setTopictotal(int topictotal) {
		this.topictotal = topictotal;
	}
	public List<Group> getGrouplist() {
		return grouplist;
	}
	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public List<Topic> getTopiclist() {
		return topiclist;
	}

	public void setTopiclist(List<Topic> topiclist) {
		this.topiclist = topiclist;
	}

	public int getGrouppage() {
		return grouppage;
	}
	public void setGrouppage(int grouppage) {
		this.grouppage = grouppage;
	}
	public int getUserpage() {
		return userpage;
	}
	public void setUserpage(int userpage) {
		this.userpage = userpage;
	}
	public int getTopicpage() {
		return topicpage;
	}
	public void setTopicpage(int topicpage) {
		this.topicpage = topicpage;
	}

	@SuppressWarnings("unchecked")
	public String showGroup()
	{
		
		
		List<Group> LL=pagingDAO.findPlantByPage(grouppage, grouprowsPerPage, "Group", "unum");
		for(Group group:LL)
		{
			if(group.getGisVerify()==1)
			{
				grouplist.add(group);
			}
		}
		userlist=pagingDAO.findPlantByPage(userpage, userrowsPerPage, "User", "unick");;
		topiclist=pagingDAO.findPlantByPage(topicpage, topicrowsPerPage, "Topic", "treplynum");
		grouptotalPage = pagingDAO.getPlanTotalPage(grouprowsPerPage, "Group"); 
		usertotalPage = pagingDAO.getPlanTotalPage(userrowsPerPage, "Works"); 
		topictotalPage = pagingDAO.getPlanTotalPage(topicrowsPerPage, "Works"); 
		grouptotal = pagingDAO.getPlanNum("Group");
		usertotal=  pagingDAO.getPlanNum("User");
		topictotal= pagingDAO.getPlanNum("Topic");
		return SUCCESS;
	}

}
