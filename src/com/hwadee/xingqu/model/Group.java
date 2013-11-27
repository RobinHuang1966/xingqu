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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_group")
public class Group implements java.io.Serializable {

	// Fields

	private Integer gid;
	private User user;
	private Theme theme;
	private String gbrief;
	private Timestamp gcreateTime;
	private Integer gisVerify;
	private String gtitle;
	private int tnum;
	private int unum;
	
	private Set<Loger> logers = new HashSet<Loger>(0);
	private Set<Topic> topics = new HashSet<Topic>(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(User user, Theme theme, Timestamp gcreateTime, String gtitle) {
		this.user = user;
		this.theme = theme;
		this.gcreateTime = gcreateTime;
		this.gtitle = gtitle;
	}

	/** full constructor */
	public Group(User user, Theme theme, String gbrief, Timestamp gcreateTime,
			Integer gisVerify, String gtitle, Set<Loger> logers,
			Set<Topic> topics) {
		this.user = user;
		this.theme = theme;
		this.gbrief = gbrief;
		this.gcreateTime = gcreateTime;
		this.gisVerify = gisVerify;
		this.gtitle = gtitle;
		this.logers = logers;
		this.topics = topics;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GID", unique = true, nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ThID", nullable = false)
	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Column(name = "GBrief")
	public String getGbrief() {
		return this.gbrief;
	}

	public void setGbrief(String gbrief) {
		this.gbrief = gbrief;
	}

	@Column(name = "GCreateTime", nullable = false, length = 19)
	public Timestamp getGcreateTime() {
		return this.gcreateTime;
	}

	public void setGcreateTime(Timestamp gcreateTime) {
		this.gcreateTime = gcreateTime;
	}

	@Column(name = "GIsVerify")
	public Integer getGisVerify() {
		return this.gisVerify;
	}

	public void setGisVerify(Integer gisVerify) {
		this.gisVerify = gisVerify;
	}

	@Column(name = "GTitle", nullable = false, length = 100)
	public String getGtitle() {
		return this.gtitle;
	}

	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public Set<Loger> getLogers() {
		return this.logers;
	}

	public void setLogers(Set<Loger> logers) {
		this.logers = logers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	@Column(name = "TNum", nullable = true)
	public int getTnum() {
		return tnum;
	}

	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	@Column(name = "UNum", nullable = true)
	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}
	

	
}