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
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Theme;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionSupport;

public class IndexShowAction extends ActionSupport{
	/**
	 * @author ����
	 * @since 2013-07-08
	 * �����û�ȡ����ݿ��е����Ȼ������ҳ����ʾ����
	 */
	private static final long serialVersionUID = -4570375737307159021L;
	private List<Works> workslist;
	private List<Topic> topiclist;
	private List<Group> grouplist=new ArrayList<Group>();
	private List<List> themegroup;
	private List<Theme> themelist;
	private List<User> userlist;
	private List<Loger> logerlist;
	private String like;
	private UserDAO userDAO=new UserDAO();
	private PagingDAO pagingDAO=new PagingDAO();
	private int unum;
	public List<Works> getWorkslist() {
		return workslist;
	}
	public void setWorkslist(List<Works> workslist) {
		this.workslist = workslist;
	}
	public List<Topic> getTopiclist() {
		return topiclist;
	}
	public void setTopiclist(List<Topic> topiclist) {
		this.topiclist = topiclist;
	}
	public List<Group> getGrouplist() {
		return grouplist;
	}
	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}
	public List<Theme> getThemelist() {
		return themelist;
	}
	public void setThemelist(List<Theme> themelist) {
		this.themelist = themelist;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public List<Loger> getLogerlist() {
		return logerlist;
	}
	public void setLogerlist(List<Loger> logerlist) {
		this.logerlist = logerlist;
	}

	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}

	public int getUnum() {
		return unum;
	}

	public List<List> getThemegroup() {
		return themegroup;
	}
	public void setThemegroup(List<List> themegroup) {
		this.themegroup = themegroup;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	/**
	 * 
	 * @return suuceess
	 * չʾ��ҳ
	 */
	@SuppressWarnings("unchecked")
	public String showIndex()
	{
		unum=userDAO.findAll().size();
		workslist=pagingDAO.findPlantByPage("Works","wloadNum","desc");
		themelist=pagingDAO.findPlantByPage("Theme","gnum","desc");

		List<Group>  LL=pagingDAO.findPlantByPage("Group","unum","desc");
		for(Group group:LL)
		{
			if(group.getGisVerify()==1)
			{
				System.out.println("oooooooooooooooooooo");
				grouplist.add(group);
			}
		}
		topiclist=pagingDAO.findPlantByPage("Topic", "treplynum", "desc");
		userlist=pagingDAO.findPlantByPage("User", "uregTime", "desc");
		System.out.println(userlist);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String multipleSearch()
	{	
		System.out.println(like);
		themelist=pagingDAO.findFuzzy("Theme", "thBrief", like);
		grouplist=pagingDAO.findFuzzy("Group","gbrief",like);
		topiclist=pagingDAO.findFuzzy("Topic", "tcontent", like);
		workslist=pagingDAO.findFuzzy("Works", "wname", like);
		return SUCCESS;

	}
}
