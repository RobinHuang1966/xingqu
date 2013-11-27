package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.ThemeDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Theme;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GroupManageAction extends ActionSupport{

	private static final long serialVersionUID = 7313981260184699986L;
	private Integer gid;
	private User user;
	private Theme theme;
	private String gtitle;
	private Timestamp gcreateTime;
	private Integer gisVerify;
	private String gbrief;
	private List<Group> glist=new ArrayList<Group>();
	private List<Loger> logerList=new ArrayList<Loger>();
	private Set<Topic> topics = new HashSet<Topic>(0);
	private GroupDAO groupDAO=new GroupDAO();
	private UserDAO userDAO=new UserDAO();
	private ThemeDAO themeDAO=new ThemeDAO();
	private LogerDAO logerDAO= new LogerDAO();
	private List<String> themeNames=new ArrayList<String>();
	private List<Theme> themelist=new ArrayList<Theme>();
	private List<Topic> topiclist=new ArrayList<Topic>();
	private List<Group> grouplist=new ArrayList<Group>();
	private TopicDAO topicDAO=new TopicDAO();
	private String thName;
	private Group group;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public Timestamp getGcreateTime() {
		return gcreateTime;
	}
	public void setGcreateTime(Timestamp gcreateTime) {
		this.gcreateTime = gcreateTime;
	}
	public Integer getGisVerify() {
		return gisVerify;
	}
	public void setGisVerify(Integer gisVerify) {
		this.gisVerify = gisVerify;
	}
	public String getGbrief() {
		return gbrief;
	}
	public void setGbrief(String gbrief) {
		this.gbrief = gbrief;
	}
	public List<Group> getGlist() {
		return glist;
	}
	public void setGlist(List<Group> glist) {
		this.glist = glist;
	}
	public List<Loger> getLogerList() {
		return logerList;
	}
	public void setLogerList(List<Loger> logerList) {
		this.logerList = logerList;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public String getThName() {
		return thName;
	}
	public void setThName(String thName) {
		this.thName = thName;
	}
	public List<String> getThemeNames() {
		return themeNames;
	}
	public void setThemeNames(List<String> themeNames) {
		this.themeNames = themeNames;
	}

	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Group> getGrouplist() {
		return grouplist;
	}
	public void setGrouplist(List<Group> grouplist) {
		this.grouplist = grouplist;
	}
	public List<Topic> getTopiclist() {
		return topiclist;
	}
	public void setTopiclist(List<Topic> topiclist) {
		this.topiclist = topiclist;
	}
	@SuppressWarnings("unchecked")
	public String listGroup()
	{
		this.glist=groupDAO.findAll();
		return "ok";
	}
	public String addGroup()
	{
		Group g=new Group();
		Theme th=new Theme(); 
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);		
		th.setThName(thName);		
		th=themeDAO.findByThName(thName).get(0);	
		th.setGnum(th.getGnum()+1);
		g.setUser(user);
		g.setGtitle(gtitle);
		g.setGbrief(gbrief);
		g.setUnum(0);
		g.setGcreateTime(new Timestamp(new Date().getTime()));
		g.setGisVerify(0);                   //Ĭ��Ϊ0����ʾû��ͨ����֤
		g.setTheme(th);
		g.setTnum(0);
		GroupDAO groupDAO= new GroupDAO();
		groupDAO.save(g);
		return "ok";
	}
	public String updateGroup()
	{
		Group g=new Group();
		User  u=new User();
		Theme th=new Theme();
		g.setGtitle(gtitle);
		g.setGbrief(gbrief);
		g.setGcreateTime(new Timestamp(new Date().getTime()));
		g.setGisVerify(0);
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		u=userDAO.findByUnick(unick);
		g.setUser(u);
		Object thName = null;
		themeDAO.findByThName(thName);
		th=themeDAO.findById(43);
		g.setTheme(th);
		groupDAO.save(g);
		return "ok";
	}
	public String deleteGroup()
	{	System.out.println("GID��ֵΪ��"+gid);
	Group g=new Group();
	g=groupDAO.findById(gid);

	Theme theme=g.getTheme();
	theme.setGnum(theme.getGnum()-1);
	themeDAO.attachDirty(theme);

	groupDAO.delete(g);

	return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String editGroup(){
		themelist=themeDAO.findAll();
		for(int i=0;i<themelist.size();++i)
		{
			themeNames.add(themelist.get(i).getThName());
		}
		return SUCCESS;
	}
	public String showGroupDetail(){
		group=groupDAO.findById(gid);		
		topiclist=topicDAO.findByProperty("group", group);
		ActionContext.getContext().getSession().put("group",group);     
		return SUCCESS;
	}
	

	/**
	 * 小组列表
	 * @return String
	 */
	public String list(){
		
		grouplist=groupDAO.findAll();
		return "list";
	}
	
	/**
	 * 根据小组名称查找
	 * @return String
	 */
	public String findByGTitle(){
		
		Iterator<Group> it=groupDAO.findByGtitle(gtitle).iterator();
		while(it.hasNext()){
			group=it.next();
		}		
		return "ok";
	}
	
	/**
	 * 模糊查找
	 */
	
	public String dimFind(){				
		String sql="from Group  as g where g.gtitle like '%"+gtitle+"%' ";		
		grouplist=groupDAO.getSession().createQuery(sql).list();		
		return "ok";
	}
	
	
	/**
	 * 删除小组
	 * @return String
	 */
	
	public String del(){
		group=groupDAO.findById(gid);
		groupDAO.delete(group);
		return "ok";
	}
	
	/**
	 * 查找待审核的小组
	 * @return String
	 */
	
	public String findByGisVerify(){
		groupDAO=new GroupDAO();
		grouplist=groupDAO.findByGisVerify(0);
		//System.out.println(grouplist.size());
		return "ok";
	}
	
	/**
	 * 修改审核状态
	 * 同意后并发同意的消息
	 * @return
	 */
	
	@SuppressWarnings("static-access")
	public String changeVerify(){
		group=groupDAO.findById(gid);
		
		group.setGisVerify(1);
		groupDAO.attachDirty(group);
		
		//下面是同意了将数据存入数据库
		
		logerDAO=new LogerDAO();
		Loger loger=new Loger();
		loger.setLtype(19);
		loger.setLcontent(group.getGtitle()+"小组审核通过");
		loger.setLtime(new Timestamp(new Date().getTime() ));
		loger.setFlag(0);
		
		User admin=(User) ActionContext.getContext().getContext().getSession().get("user");
		//loger.setUid(-1);
		loger.setUser(admin);
		
		user=group.getUser();
		loger.setPuser(user);
		loger.setGroup(groupDAO.findById(gid));
		logerDAO.save(loger);
		
		return "ok";
	}
	
	/**
	 * 不同意&&发不同意的消息
	 * @return String
	 */
	
	public String disAgree(){
		groupDAO=new GroupDAO();
		group=groupDAO.findById(gid);
		groupDAO.delete(group);
		
		//下面是不同意将不同意的信息存入数据库
		
		logerDAO=new LogerDAO();
		Loger loger=new Loger();
		loger.setLtype(19);
		loger.setLcontent(group.getGtitle()+"小组审核不通过");
		loger.setLtime(new Timestamp(new Date().getTime() ));
		loger.setFlag(0);
		
		user=group.getUser();
		loger.setUser(user);
		//loger.setUid(user.getUid());
		
		loger.setGroup(groupDAO.findById(gid));
		
		logerDAO.save(loger);
		
		return "ok";
	}
}
