package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hwadee.xingqu.dao.FriendDAO;
import com.hwadee.xingqu.dao.GroupDAO;
import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.TopicDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Friend;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.Topic;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.client.RequestContext;

public class UserManageAction extends ActionSupport{
	/**
	 * @author ���ַ�and���պ�
	 * ���������û�����ɾ�Ĳ飬�͵�½��֤
	 */
	private static final long serialVersionUID = 4895364701279412134L;
	private Integer uid;
	private String unick;
	private String uemail;
	private String ugrade;
	private String uhead;
	private String uinterest;
	private Timestamp ulastLoginTime;
	private String uname;
	private Timestamp uregTime;
	private String upassword;
	private Timestamp ubirthady;
	private String uschool;
	private String usex;
	private Integer ustate;
	private String utype;
	private User user;
	private List<Works> workses = new ArrayList<Works>(0);
	private List<Topic> topics = new ArrayList<Topic>(0);
	private List<Friend> friendsForFuid = new ArrayList<Friend>(0);
	private Set<Loger> logers = new HashSet<Loger>(0);
	private Set<Friend> friendsForUid = new HashSet<Friend>(0);
	private List<Group> groups = new ArrayList<Group>(0);
	private List<Loger> joinGroupList=new ArrayList<Loger>(0);
	private List<Loger> myShareList=new ArrayList<Loger>(0);
	private List<Loger> myMessageList=new ArrayList<Loger>();
	private List<Loger> leaveMessageList=new ArrayList<Loger>();
	private List<Loger> myDynamicList=new ArrayList<Loger>();
	private List<Loger> attentionTopicList=new ArrayList<Loger>();
	private List<Loger> downWorksList=new ArrayList<Loger>();
	private UserDAO userDAO=new UserDAO();
	private LogerDAO logerDAO= new LogerDAO();
	private FriendDAO friendDAO=new FriendDAO();
	private GroupDAO groupDAO= new GroupDAO();
	private WorksDAO worksDAO= new WorksDAO();
	private TopicDAO topicDAO=new TopicDAO();
	/**
	 * 
	 * @return success
	 * �û���¼
	 */
	public String login()
	{
		UserDAO userDAO= new UserDAO();
		User user= new User();
		user.setUnick(unick);
		user.setUpassword(upassword);
		if(userDAO.validator(user))
		{
			User u= userDAO.findByUnick(unick);;
			u.setUlastLoginTime(new Timestamp(new Date().getTime()));
			userDAO.attachDirty(u);
			ActionContext.getContext().getSession().put("unick",unick);
			ActionContext.getContext().getSession().put("utype",utype);
			ActionContext.getContext().getSession().put("upassword",upassword);
			ActionContext.getContext().getSession().put("user",u);
			return SUCCESS;
		}
		else
		{
			this.addFieldError("unick", "用户名或密码错误！");
			return ERROR;
		}

	}
	/**
	 * 
	 * @return success
	 * ����û�
	 */
	public String userUpdate() {		
		User user =	(User) ActionContext.getContext().getSession().get("user");
		user.setUname(uname);
		user.setUsex(usex);
		user.setUbirthady(ubirthady);
		user.setUinterest(uinterest);
		user.setUgrade(ugrade);
		user.setUschool(uschool);
		user.setUemail(uemail);
		userDAO.merge(user);
		userDAO.attachDirty(user);
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}
	public String userAdd() {

		if(unick!=null)
		{
			if(userDAO.findByUnick(unick)==null)
			{
				User user = new User();
				user.setUnick(unick);
				user.setUpassword(upassword);
				user.setUname(uname);
				user.setUtype(utype);
				user.setUemail(uemail);
				user.setUbirthady(ubirthady);
				user.setUgrade(ugrade);
				System.out.println(ugrade);
				user.setUsex(usex);
				user.setUhead(uhead);
				user.setUinterest(uinterest);
				user.setUschool(uschool);
				user.setUstate(0);
				user.setUregTime(new Timestamp(new Date().getTime()));
				user.setUlastLoginTime(new Timestamp(new Date().getTime()));
				ActionContext.getContext().getSession().put("unick",unick);
				ActionContext.getContext().getSession().put("utype",utype);
				ActionContext.getContext().getSession().put("upassword",upassword);

				ActionContext.getContext().getSession().put("user",user);
				userDAO.save(user);
				return SUCCESS;
			}
			this.addFieldError("unick", "用户名已存在！");
		}
		else{
			this.addFieldError("unick", "用户名不能为空");
			return ERROR;
		}
		return ERROR;
	}
	/**
	 * 
	 * @return success
	 * �û��˳�
	 */
	public String userExit()
	{
		ActionContext.getContext().getSession().clear();  
		return SUCCESS;  	
	}
	//	public void validate() {
	//		// TODO Auto-generated method stub
	//		if(null==unick)
	//		{
	//			System.out.println("�û�����Ϊ�գ�");
	//			this.addFieldError("unick", "�û�����Ϊ�գ�");
	//		}
	//		else if(null==upassword)
	//		{
	//			this.addFieldError("upassword", "���벻��Ϊ�գ�");
	//		}
	//
	//	}
	/**
	 * 
	 * @return success
	 *�����û��Լ��Ŀռ�
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public String showMyHome()
	{
		user=(User) ActionContext.getContext().getSession().get("user");
		Loger loger=new Loger();
		//loger.setUid(user.getUid());
//		loger.setUser(user);
//		loger.setLtype(17);//17号表示加入小组
//		joinGroupList=logerDAO.findByExample(loger);
		this.joinGroupList=logerDAO.findByTwoproperty("ltype", user, 17);
		friendsForFuid=friendDAO.findByUid(user);//某人关注的好友列表
		groups=groupDAO.findByUid(user);
		topics=topicDAO.findByUid(user);
		workses=worksDAO.findByUid(user);
		myShareList=logerDAO.findMyShareByProperty("user", user);//包括分享的作品和话题。
				
//		Loger loger1=new Loger();
//		loger1.setPuser(user);//别人给我的留言。
//		loger1.setLtype(15);//15表示留言
//		myMessageList=logerDAO.findByExample(loger1);//这里包括别人给我的留言和我给别人的留言。
		this.myMessageList=logerDAO.findByTwoproperty1("puser",user,"ltype",15);
		this.myDynamicList=logerDAO.findByUid(user.getUid());
		//this.attentionTopicList=logerDAO.findByTwoproperty1("user",user,"ltype",3);//3号表示关注话题。
		//this.downWorksList=logerDAO.findByTwoproperty1("user",user,"ltype",8);//8号表示下载作品。
		//this.leaveMessageList=logerDAO.findByTwoproperty1("user",user,"ltype",15);//15号表示给别人留言。
	
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return success
	 * �û����ʺ��ѿռ�
	 */
	@SuppressWarnings({ "unchecked" })
	public String visitFriendSpace()
	{
		user=userDAO.findByUnick(unick);
		//ActionContext.getContext().getSession().put("friend",user);
//		HttpServletRequest request = null;
//		request.setAttribute("friend",user);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("friend",user);
		this.joinGroupList=logerDAO.findByTwoproperty("ltype", user, 17);
		friendsForFuid=friendDAO.findByUid(user);//某人关注的好友列表
		groups=groupDAO.findByUid(user);
		topics=topicDAO.findByUid(user);
		workses=worksDAO.findByUid(user);
		myShareList=logerDAO.findMyShareByProperty("user", user);//包括分享的作品和话题。

		this.myMessageList=logerDAO.findByTwoproperty1("puser",user,"ltype",15);
		this.myDynamicList=logerDAO.findByUid(user.getUid());
		return SUCCESS;
	}
	public  String personDynamic()
	{
		user=(User) ActionContext.getContext().getSession().get("user");
		this.myDynamicList=logerDAO.findByUid(user.getUid());
		return SUCCESS ;
	}
	
	public String  showMyGroup()
	{

		user=(User) ActionContext.getContext().getSession().get("user");
		groups=groupDAO.findByUid(user);
		//	loger.setUid(user.getUid());//17号表示加入小组
		this.joinGroupList=logerDAO.findByTwoproperty("ltype", user, 17);
		return SUCCESS ;
	}
	
	public String  showMyTopic()
	{
		user=(User) ActionContext.getContext().getSession().get("user");
		topics=topicDAO.findByUid(user);
		this.attentionTopicList=logerDAO.findByTwoproperty1("user",user,"ltype",3);//3号表示关注话题。
		return SUCCESS ;
	}
	@SuppressWarnings("unchecked")
	public String showMyShare()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		this.myShareList=logerDAO.findMyShareByProperty("user", user);
		return SUCCESS ;
	}
	
	public String listMyMessage()
	{
		String unick=(String) ActionContext.getContext().getSession().get("unick");
		User user=userDAO.findByUnick(unick);
		Loger loger=new Loger();
		loger.setPuser(user);
		loger.setLtype(15);//留言
		this.myMessageList=logerDAO.findByTwoproperty1("puser",loger.getPuser(), "ltype",loger.getLtype());
		return SUCCESS;
	}
	public String showUserInfo()
	{
		user=userDAO.findByUnick(unick);
		return SUCCESS;
	}
	public List<Loger> getJoinGroupList() {
		return joinGroupList;
	}
	public void setJoinGroupList(List<Loger> joinGroupList) {
		this.joinGroupList = joinGroupList;
	}
	public List<Works> getWorkses() {
		return workses;
	}
	public void setWorkses(List<Works> workses) {
		this.workses = workses;
	}
	public List<Topic> getTopics() {
		return topics;
	}

	public List<Loger> getMyDynamicList() {
		return myDynamicList;
	}
	public void setMyDynamicList(List<Loger> myDynamicList) {
		this.myDynamicList = myDynamicList;
	}
	public List<Loger> getMyMessageList() {
		return myMessageList;
	}
	public void setMyMessageList(List<Loger> myMessageList) {
		this.myMessageList = myMessageList;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<Friend> getFriendsForFuid() {
		return friendsForFuid;
	}
	public void setFriendsForFuid(List<Friend> friendsForFuid) {
		this.friendsForFuid = friendsForFuid;
	}
	public Set<Loger> getLogers(){
		return logers;
	}
	public void setLogers(Set<Loger> logers) {
		this.logers = logers;
	}
	public Set<Friend> getFriendsForUid() {
		return friendsForUid;
	}
	public void setFriendsForUid(Set<Friend> friendsForUid) {
		this.friendsForUid = friendsForUid;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUgrade() {
		return ugrade;
	}

	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}

	public String getUhead() {
		return uhead;
	}

	public void setUhead(String uhead) {
		this.uhead = uhead;
	}

	public String getUinterest() {
		return uinterest;
	}

	public void setUinterest(String uinterest) {
		this.uinterest = uinterest;
	}

	public Timestamp getUlastLoginTime() {
		return ulastLoginTime;
	}

	public void setUlastLoginTime(Timestamp ulastLoginTime) {
		this.ulastLoginTime = ulastLoginTime;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Timestamp getUregTime() {
		return uregTime;
	}

	public void setUregTime(Timestamp uregTime) {
		this.uregTime = uregTime;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Timestamp getUbirthady() {
		return ubirthady;
	}

	public void setUbirthady(Timestamp ubirthady) {
		this.ubirthady = ubirthady;
	}

	public String getUschool() {
		return uschool;
	}

	public void setUschool(String uschool) {
		this.uschool = uschool;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public Integer getUstate() {
		return ustate;
	}

	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}
	public List<Loger> getMyShareList() {
		return myShareList;
	}
	public void setMyShareList(List<Loger> myShareList) {
		this.myShareList = myShareList;
	}
	public void setLeaveMessageList(List<Loger> leaveMessageList) {
		this.leaveMessageList = leaveMessageList;
	}
	public List<Loger> getLeaveMessageList() {
		return leaveMessageList;
	}
	public void setAttentionTopicList(List<Loger> attentionTopicList) {
		this.attentionTopicList = attentionTopicList;
	}
	public List<Loger> getAttentionTopicList() {
		return attentionTopicList;
	}
	public void setDownWorksList(List<Loger> downWorksList) {
		this.downWorksList = downWorksList;
	}
	public List<Loger> getDownWorksList() {
		return downWorksList;
	}
}
