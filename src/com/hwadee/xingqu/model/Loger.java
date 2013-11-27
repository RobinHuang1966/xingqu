package com.hwadee.xingqu.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Loger entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_loger", schema = "dbo", catalog = "xingqu")
public class Loger implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2651071946028132879L;
	private Integer lid;
	private Topic topic;
	private Group group;
	private User puser;
	private Works works;
	private User user;
	private Integer ltype;
	private Timestamp ltime;
	private String lcontent;
	private Integer flag;

	// Constructors

	/** default constructor */
	public Loger() {
	}

	/** minimal constructor */
	public Loger(User user, Integer ltype, Timestamp ltime, Integer flag) {
		this.user = user;
		this.ltype = ltype;
		this.ltime = ltime;
		this.flag = flag;
	}

	/** full constructor */
	public Loger(Topic topic, Group group, User puser, Works works,
			User user, Integer ltype, Timestamp ltime, String lcontent,
			Integer flag) {
		this.topic = topic;
		this.group = group;
		this.puser = puser;//被动者
		this.works = works;
		this.user = user;//操作的主动者
		this.ltype = ltype;
		this.ltime = ltime;
		this.lcontent = lcontent;
		this.flag = flag;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "LID", unique = true, nullable = false)
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TID")
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GID")
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PUID")
	public User getPuser() {
		return this.puser;
	}

	public void setPuser(User puser) {
		this.puser = puser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WID")
	public Works getWorks() {
		return this.works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "LType", nullable = false)
	public Integer getLtype() {
		return this.ltype;
	}

	public void setLtype(Integer ltype) {
		this.ltype = ltype;
	}

	@Column(name = "LTime", nullable = false, length = 23)
	public Timestamp getLtime() {
		return this.ltime;
	}

	public void setLtime(Timestamp ltime) {
		this.ltime = ltime;
	}

	@Column(name = "LContent", length = 1024)
	public String getLcontent() {
		return this.lcontent;
	}

	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	@Column(name = "Flag", nullable = false)
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}