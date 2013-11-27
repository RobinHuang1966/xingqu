package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.classic.Session;

import com.hwadee.xingqu.dao.*;
import com.hwadee.xingqu.model.*;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5613297193053282218L;
	private Integer uid;
	private String unick;
	private String uname;
	private String upassword;
	private Timestamp uregTime;
	private String usex;
	private Integer ustate;
	private String utype;
	private Timestamp ubirthady;
	private String uemail;
	private String ugrade;
	private String uhead;
	private String uinterest;
	private Timestamp ulastLoginTime;
	private String uschool;

	private User user;
	private UserDAO userdao;
	private List<User> userlist;

	private int totalUser=0;
	private int onlineUser=0;

	/**
	 * ��ʾ�û��б�
	 * @author Administrator
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String userlist(){

		userdao=new UserDAO();	
		userlist=userdao.findAll();
		return "list";
	}

	/**
	 * ����û�
	 * @return String
	 */

	public String add(){

		userdao=new UserDAO();
		user=new User();

		user.setUnick(unick);
		user.setUname(uname);
		user.setUpassword(upassword);
		user.setUregTime(uregTime);
		user.setUsex(usex);
		user.setUstate(ustate);
		user.setUtype(utype);
		user.setUbirthady(ubirthady);
		user.setUemail(uemail);
		user.setUgrade(ugrade);
		user.setUinterest(uinterest);
		user.setUlastLoginTime(ulastLoginTime);
		user.setUschool(uschool);

		userdao.save(user);
		userdao.getSession().flush();

		return "ok";
	}

	/**
	 * ɾ���û�
	 * @return String
	 */
	public String del(){

		userdao=new UserDAO();
		user=userdao.findById(uid);
		userdao.delete(user);
		return "ok";
	}

	/**
	 * �����û�
	 * @return String
	 */

	public String find(){
		userdao=new UserDAO();
		user=userdao.findByUnick(unick);
		return "ok";
	}

	/**
	 * ģ�����
	 */

	public String dimFind(){

		userdao=new UserDAO();						
		String sql="from User  as u where u.unick like '%"+unick+"%' ";		
		userlist=userdao.getSession().createQuery(sql).list();		
		return "ok";
	}


	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Timestamp getUregTime() {
		return uregTime;
	}

	public void setUregTime(Timestamp uregTime) {
		this.uregTime = uregTime;
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

	public Timestamp getUbirthady() {
		return ubirthady;
	}

	public void setUbirthady(Timestamp ubirthady) {
		this.ubirthady = ubirthady;
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

	public String getUschool() {
		return uschool;
	}

	public void setUschool(String uschool) {
		this.uschool = uschool;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public int getTotalUser() {

		userdao=new UserDAO();
		totalUser=userdao.findAll().size();		
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}

	public int getOnlineUser() {

		userdao=new UserDAO();
		Iterator<User> it=userdao.findAll().iterator();
		while(it.hasNext()){
			user=it.next();
			if(user.getUstate()==1){
				onlineUser++;
			}
		}

		return onlineUser;
	}

	public void setOnlineUser(int onlineUser) {
		this.onlineUser = onlineUser;
	}



}
