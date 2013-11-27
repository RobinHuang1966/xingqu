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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_topic")
public class Topic implements java.io.Serializable {
	// Fields
	private Integer tid;
	private Group group;
	private User user;

	private String tcontent;
	private Timestamp tcreatTime;
	private String ttitle;
	private int treplynum;
	private Set<Loger> logers = new HashSet<Loger>(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(Group group, User user, String tcontent, Timestamp tcreatTime,
			String ttitle) {
		this.group = group;
		this.user = user;
		this.tcontent = tcontent;
		this.tcreatTime = tcreatTime;
		this.ttitle = ttitle;
	}

	/** full constructor */
	public Topic(Group group, User user, String tcontent, Timestamp tcreatTime,
			String ttitle, Set<Loger> logers) {
		this.group = group;
		this.user = user;
		this.tcontent = tcontent;
		this.tcreatTime = tcreatTime;
		this.ttitle = ttitle;
		this.logers = logers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TID", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GID", nullable = true)
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID", nullable = true)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "TContent", nullable = false)
	public String getTcontent() {
		return this.tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	@Column(name = "TCreatTime", nullable = false, length = 19)
	public Timestamp getTcreatTime() {
		return this.tcreatTime;
	}

	public void setTcreatTime(Timestamp tcreatTime) {
		this.tcreatTime = tcreatTime;
	}

	@Column(name = "TTitle", nullable = false)
	public String getTtitle() {
		return this.ttitle;
	}

	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "topic")
	public Set<Loger> getLogers() {
		return this.logers;
	}

	public void setLogers(Set<Loger> logers) {
		this.logers = logers;
	}
	@Column(name = "TReplyNum", nullable = false)
	public int getTreplynum() {
		return treplynum;
	}

	public void setTreplynum(int treplynum) {
		this.treplynum = treplynum;
	}

}