package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.hwadee.xingqu.dao.SysnoticeDAO;
import com.hwadee.xingqu.dao.ThemeDAO;
import com.hwadee.xingqu.model.Sysnotice;
import com.hwadee.xingqu.model.Theme;
import com.opensymphony.xwork2.ActionSupport;

public class SysNoticeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7668825916207075650L;
	private Integer sysId;
	private String sysContent;
	private Timestamp sysPublTime;
	private String sysTitle;
	
	private Sysnotice sysnotice;
	private SysnoticeDAO sysnoticedao;
	private List<Sysnotice> sysnoticelist;
	
	/**
	 * ��ʾ�����б�
	 * @author wlh
	 * @param null
	 * @return String
	 */
	
	@SuppressWarnings("unchecked")
	public String list(){
		
		sysnoticedao=new SysnoticeDAO();
		sysnoticelist=sysnoticedao.findAll();
		return "list";
	}
	
	/**
	 * ��ӹ���
	 * @author wlh
	 * @param null
	 * @return String
	 */
	
	public String add(){
		
		sysnoticedao=new SysnoticeDAO();
		sysnotice=new Sysnotice();
		sysnotice.setSysContent(sysContent);
		sysnotice.setSysPublTime(new Timestamp(new Date().getTime()));
		sysnotice.setSysTitle(sysTitle);
		sysnoticedao.save(sysnotice);
		sysnoticedao.getSession().flush();
		
		return "ok";
	}
	
	/**
	 * ɾ���
	 * @author wlh
	 * @return String
	 */
	public String del(){
		
		sysnoticedao=new SysnoticeDAO();
		sysnotice=sysnoticedao.findById(sysId);
		sysnoticedao.delete(sysnotice);
		sysnoticedao.getSession().flush();		
		return "ok";
	}
	
	
	/**
	 * ����ָ��thId����Ϣ
	 * @return String
	 */
	
	public String showSysnoticeInfo(){
		sysnoticedao=new SysnoticeDAO();
		sysnotice=sysnoticedao.findById(sysId);
		return "ok";
	}
		
	public Integer getSysId() {
		return sysId;
	}
	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}
	public String getSysContent() {
		return sysContent;
	}
	public void setSysContent(String sysContent) {
		this.sysContent = sysContent;
	}
	public Timestamp getSysPublTime() {
		return sysPublTime;
	}
	public void setSysPublTime(Timestamp sysPublTime) {
		this.sysPublTime = sysPublTime;
	}
	public String getSysTitle() {
		return sysTitle;
	}
	public void setSysTitle(String sysTitle) {
		this.sysTitle = sysTitle;
	}
	public Sysnotice getSysnotice() {
		return sysnotice;
	}
	public void setSysnotice(Sysnotice sysnotice) {
		this.sysnotice = sysnotice;
	}
	public List<Sysnotice> getSysnoticelist() {
		return sysnoticelist;
	}
	public void setSysnoticelist(List<Sysnotice> sysnoticelist) {
		this.sysnoticelist = sysnoticelist;
	}
	
}
