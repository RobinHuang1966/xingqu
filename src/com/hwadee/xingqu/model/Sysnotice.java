package com.hwadee.xingqu.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysnotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_sysnotice")
public class Sysnotice implements java.io.Serializable {

	// Fields

	private Integer sysId;
	private String sysContent;
	private Timestamp sysPublTime;
	private String sysTitle;

	// Constructors

	/** default constructor */
	public Sysnotice() {
	}

	/** full constructor */
	public Sysnotice(String sysContent, Timestamp sysPublTime, String sysTitle) {
		this.sysContent = sysContent;
		this.sysPublTime = sysPublTime;
		this.sysTitle = sysTitle;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SysID", unique = true, nullable = false)
	public Integer getSysId() {
		return this.sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	@Column(name = "SysContent", nullable = false)
	public String getSysContent() {
		return this.sysContent;
	}

	public void setSysContent(String sysContent) {
		this.sysContent = sysContent;
	}

	@Column(name = "SysPublTime", nullable = false, length = 19)
	public Timestamp getSysPublTime() {
		return this.sysPublTime;
	}

	public void setSysPublTime(Timestamp sysPublTime) {
		this.sysPublTime = sysPublTime;
	}

	@Column(name = "SysTitle", nullable = false, length = 60)
	public String getSysTitle() {
		return this.sysTitle;
	}

	public void setSysTitle(String sysTitle) {
		this.sysTitle = sysTitle;
	}

}