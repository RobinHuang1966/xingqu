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
 * Works entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_works")
public class Works implements java.io.Serializable {

	// Fields

	private Integer wid;
	private User user;
	private Integer wbad;
	private String wbrief;
	private String wcontent;
	private Integer wgood;
	private Integer wloadNum;
	private String wname;
	private Float wsize;
	private Timestamp wtime;
	private String wtype;
	private Set<Loger> logers = new HashSet<Loger>(0);

	// Constructors

	/** default constructor */
	public Works() {
	}

	/** minimal constructor */
	public Works(String wcontent, String wname, Timestamp wtime) {
		this.wcontent = wcontent;
		this.wname = wname;
		this.wtime = wtime;
	}

	/** full constructor */
	public Works(User user, Integer wbad, String wbrief, String wcontent,
			Integer wgood, Integer wloadNum, String wname, Float wsize,
			Timestamp wtime, String wtype, Set<Loger> logers) {
		this.user = user;
		this.wbad = wbad;
		this.wbrief = wbrief;
		this.wcontent = wcontent;
		this.wgood = wgood;
		this.wloadNum = wloadNum;
		this.wname = wname;
		this.wsize = wsize;
		this.wtime = wtime;
		this.wtype = wtype;
		this.logers = logers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "WID", unique = true, nullable = false)
	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID")
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "WBad")
	public Integer getWbad() {
		return this.wbad;
	}

	public void setWbad(Integer wbad) {
		this.wbad = wbad;
	}

	@Column(name = "WBrief")
	public String getWbrief() {
		return this.wbrief;
	}

	public void setWbrief(String wbrief) {
		this.wbrief = wbrief;
	}

	@Column(name = "WContent", nullable = false)
	public String getWcontent() {
		return this.wcontent;
	}

	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}

	@Column(name = "WGood")
	public Integer getWgood() {
		return this.wgood;
	}

	public void setWgood(Integer wgood) {
		this.wgood = wgood;
	}

	@Column(name = "WLoadNum")
	public Integer getWloadNum() {
		return this.wloadNum;
	}

	public void setWloadNum(Integer wloadNum) {
		this.wloadNum = wloadNum;
	}

	@Column(name = "WName", nullable = false, length = 30)
	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	@Column(name = "WSize", precision = 12, scale = 0)
	public Float getWsize() {
		return this.wsize;
	}

	public void setWsize(Float wsize) {
		this.wsize = wsize;
	}

	@Column(name = "WTime", nullable = false, length = 13)
	public Timestamp getWtime() {
		return this.wtime;
	}

	public void setWtime(Timestamp wtime) {
		this.wtime = wtime;
	}

	@Column(name = "WType", length = 50)
	public String getWtype() {
		return this.wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "works")
	public Set<Loger> getLogers() {
		return this.logers;
	}

	public void setLogers(Set<Loger> logers) {
		this.logers = logers;
	}

}