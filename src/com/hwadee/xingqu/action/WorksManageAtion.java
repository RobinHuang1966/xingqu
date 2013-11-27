package com.hwadee.xingqu.action;

import java.sql.Timestamp;

import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class WorksManageAtion extends ActionSupport {
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
	private WorksDAO worksDAO=new WorksDAO();
	private Works works;

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getWbad() {
		return wbad;
	}

	public void setWbad(Integer wbad) {
		this.wbad = wbad;
	}

	public String getWbrief() {
		return wbrief;
	}

	public void setWbrief(String wbrief) {
		this.wbrief = wbrief;
	}

	public String getWcontent() {
		return wcontent;
	}

	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}

	public Integer getWgood() {
		return wgood;
	}

	public void setWgood(Integer wgood) {
		this.wgood = wgood;
	}

	public Integer getWloadNum() {
		return wloadNum;
	}

	public void setWloadNum(Integer wloadNum) {
		this.wloadNum = wloadNum;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public Float getWsize() {
		return wsize;
	}

	public void setWsize(Float wsize) {
		this.wsize = wsize;
	}

	public Timestamp getWtime() {
		return wtime;
	}

	public void setWtime(Timestamp wtime) {
		this.wtime = wtime;
	}

	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	public WorksDAO getWorksDAO() {
		return worksDAO;
	}

	public void setWorksDAO(WorksDAO worksDAO) {
		this.worksDAO = worksDAO;
	}

	public Works getWorks() {
		return works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	public String showWorksDetail()
	{
		works=worksDAO.findById(wid);
		System.out.println(works.getWname());
		return SUCCESS;

	}
}
