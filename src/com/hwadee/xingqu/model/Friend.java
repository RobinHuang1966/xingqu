package com.hwadee.xingqu.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "_friend")
public class Friend implements java.io.Serializable {

	// Fields

	private Integer fid;
	private User userByFuid;
	private User userByUid;
	private Timestamp ftime;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** full constructor */
	public Friend(User userByFuid, User userByUid, Timestamp ftime) {
		this.userByFuid = userByFuid;
		this.userByUid = userByUid;
		this.ftime = ftime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FID", unique = true, nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUID", nullable = false)
	public User getUserByFuid() {
		return this.userByFuid;
	}

	public void setUserByFuid(User userByFuid) {
		this.userByFuid = userByFuid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UID", nullable = false)
	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	@Column(name = "FTime", nullable = false, length = 19)
	public Timestamp getFtime() {
		return this.ftime;
	}

	public void setFtime(Timestamp ftime) {
		this.ftime = ftime;
	}

}