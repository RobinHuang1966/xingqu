package com.hwadee.xingqu.model;

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

/**
 * Theme entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_theme")
public class Theme implements java.io.Serializable {

	// Fields
	private Integer thId;
	private String thBrief;
	private String thName;
	private int gnum;
	private Set<Group> groups = new HashSet<Group>(0);

	// Constructors

	/** default constructor */
	public Theme() {
	}

	/** minimal constructor */
	public Theme(String thName) {
		this.thName = thName;
	}

	/** full constructor */
	public Theme(String thBrief, String thName, Set<Group> groups) {
		this.thBrief = thBrief;
		this.thName = thName;
		this.groups = groups;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ThID", unique = true, nullable = false)
	public Integer getThId() {
		return this.thId;
	}

	public void setThId(Integer thId) {
		this.thId = thId;
	}

	@Column(name = "ThBrief")
	public String getThBrief() {
		return this.thBrief;
	}

	public void setThBrief(String thBrief) {
		this.thBrief = thBrief;
	}

	@Column(name = "ThName", nullable = false, length = 100)
	public String getThName() {
		return this.thName;
	}

	public void setThName(String thName) {
		this.thName = thName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "theme")
	public Set<Group> getGroups() {
		return this.groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	@Column(name = "GNum")
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
}