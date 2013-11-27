package com.hwadee.xingqu.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_user",uniqueConstraints = @UniqueConstraint(columnNames = "UNick"))
public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Timestamp ubirthady;
	private String uemail;
	private String ugrade;
	private String uhead;
	private String uinterest;
	private Timestamp ulastLoginTime;
	private String uname;
	private String unick;
	private String upassword;
	private Timestamp uregTime;
	private String uschool;
	private String usex;
	private Integer ustate;
	private String utype;
	private Set<Friend> friendsForFuid = new HashSet<Friend>(0);
	private Set<Works> workses = new HashSet<Works>(0);
	private Set<Topic> topics = new HashSet<Topic>(0);
	private Set<Group> groups = new HashSet<Group>(0);
	private Set<Friend> friendsForUid = new HashSet<Friend>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uname, String unick, String upassword,
			Timestamp uregTime, String usex, Integer ustate, String utype) {
		this.uname = uname;
		this.unick = unick;
		this.upassword = upassword;
		this.uregTime = uregTime;
		this.usex = usex;
		this.ustate = ustate;
		this.utype = utype;
	}

	/** full constructor */
	public User(Timestamp ubirthady, String uemail, String ugrade,
			String uhead, String uinterest, Timestamp ulastLoginTime,
			String uname, String unick, String upassword, Timestamp uregTime,
			String uschool, String usex, Integer ustate, String utype,
			Set<Friend> friendsForFuid, Set<Works> workses, Set<Topic> topics,
			Set<Group> groups, Set<Friend> friendsForUid) {
		this.ubirthady = ubirthady;
		this.uemail = uemail;
		this.ugrade = ugrade;
		this.uhead = uhead;
		this.uinterest = uinterest;
		this.ulastLoginTime = ulastLoginTime;
		this.uname = uname;
		this.unick = unick;
		this.upassword = upassword;
		this.uregTime = uregTime;
		this.uschool = uschool;
		this.usex = usex;
		this.ustate = ustate;
		this.utype = utype;
		this.friendsForFuid = friendsForFuid;
		this.workses = workses;
		this.topics = topics;
		this.groups = groups;
		this.friendsForUid = friendsForUid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UID", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "UBirthady", length = 19)
	public Timestamp getUbirthady() {
		return this.ubirthady;
	}

	public void setUbirthady(Timestamp ubirthady) {
		this.ubirthady = ubirthady;
	}

	@Column(name = "UEmail", length = 30)
	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	@Column(name = "UGrade", length = 20)
	public String getUgrade() {
		return this.ugrade;
	}

	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}

	@Column(name = "UHead")
	public String getUhead() {
		return this.uhead;
	}

	public void setUhead(String uhead) {
		this.uhead = uhead;
	}

	@Column(name = "UInterest", length = 30)
	public String getUinterest() {
		return this.uinterest;
	}

	public void setUinterest(String uinterest) {
		this.uinterest = uinterest;
	}

	@Column(name = "ULastLoginTime", length = 19)
	public Timestamp getUlastLoginTime() {
		return this.ulastLoginTime;
	}

	public void setUlastLoginTime(Timestamp ulastLoginTime) {
		this.ulastLoginTime = ulastLoginTime;
	}

	@Column(name = "UName", nullable = false, length = 20)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "UNick", unique = true, nullable = false, length = 20)
	public String getUnick() {
		return this.unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}

	@Column(name = "UPassword", nullable = false, length = 20)
	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	@Column(name = "URegTime", nullable = false, length = 19)
	public Timestamp getUregTime() {
		return this.uregTime;
	}

	public void setUregTime(Timestamp uregTime) {
		this.uregTime = uregTime;
	}

	@Column(name = "USchool", length = 30)
	public String getUschool() {
		return this.uschool;
	}

	public void setUschool(String uschool) {
		this.uschool = uschool;
	}

	@Column(name = "USex", nullable = false, length = 10)
	public String getUsex() {
		return this.usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	@Column(name = "UState", nullable = false)
	public Integer getUstate() {
		return this.ustate;
	}

	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}

	@Column(name = "UType", nullable = false, length = 10)
	public String getUtype() {
		return this.utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByFuid")
	public Set<Friend> getFriendsForFuid() {
		return this.friendsForFuid;
	}

	public void setFriendsForFuid(Set<Friend> friendsForFuid) {
		this.friendsForFuid = friendsForFuid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Works> getWorkses() {
		return this.workses;
	}

	public void setWorkses(Set<Works> workses) {
		this.workses = workses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUid")
	public Set<Friend> getFriendsForUid() {
		return this.friendsForUid;
	}

	public void setFriendsForUid(Set<Friend> friendsForUid) {
		this.friendsForUid = friendsForUid;
	}

}