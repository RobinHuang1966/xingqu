package com.hwadee.xingqu.action;

import java.util.*;

import com.hwadee.xingqu.dao.*;
import com.hwadee.xingqu.model.*;
import com.opensymphony.xwork2.ActionSupport;

public class ThemeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376959053035549600L;
	private Integer thId;
	private String thName;
	private String thBrief;
	private int gnum;
	private Theme mytheme;
	
	private ThemeDAO themedao;
	private List<Theme> themelist;
	//private Set<Group> groups = new HashSet<Group>(0);
	
	/**
	 * ��ʾ�����б�
	 * @author wlh
	 * @param null
	 * @return String
	 */
	
	@SuppressWarnings("unchecked")
	public String list(){
		
		themedao=new ThemeDAO();
		//theme=new Theme();
		themelist=themedao.findAll();
		return "list";
	}
	
	/**
	 * �������
	 * @author wlh
	 * @param null
	 * @return String
	 */
	
	public String addTheme(){
		
		themedao=new ThemeDAO();
		mytheme=new Theme();
		mytheme.setThName(thName);
		mytheme.setThBrief(thBrief);
		mytheme.setGnum(0);
		themedao.save(mytheme);
		themedao.getSession().flush();
		
		return "ok";
	}
	
	/**
	 * ɾ������
	 * @author wlh
	 * @return String
	 */
	public String del(){
		
		themedao=new ThemeDAO();
		mytheme=themedao.findById(thId);
		themedao.delete(mytheme);
		themedao.getSession().flush();		
		return "ok";
	}
	
	/**
	 * update�����б���Ϣ 
	 * @return String
	 */
	public String update(){
		
		themedao=new ThemeDAO();
		mytheme=themedao.findById(thId);
		mytheme.setThName(thName);
		mytheme.setThBrief(thBrief);
		themedao.attachDirty(mytheme);
		return "ok";
	}
	
	/**
	 * ����ָ��thId����Ϣ
	 * @return String
	 */
	
	public String showThemeInfo(){
		themedao=new ThemeDAO();
		Iterator<Theme> it=themedao.findByThName(thName).iterator();
		while(it.hasNext()){
			mytheme=it.next();
		}
		return "ok";
	}
	
	/**
	 * ģ�����
	 */
	
	public String dimFind(){
		
		themedao=new ThemeDAO();					
		String sql="from Theme  as t where t.thName like '%"+thName+"%' ";		
		themelist=themedao.getSession().createQuery(sql).list();		
		return "ok";
	}
	
	public ThemeDAO getThemedao() {
		return themedao;
	}

	public void setThemedao(ThemeDAO themedao) {
		this.themedao = themedao;
	}

	public Integer getThId() {
		return thId;
	}
	public void setThId(Integer thId) {
		this.thId = thId;
	}
	public String getThName() {
		return thName;
	}
	public void setThName(String thName) {
		this.thName = thName;
	}
	public String getThBrief() {
		return thBrief;
	}
	public void setThBrief(String thBrief) {
		this.thBrief = thBrief;
	}public Theme getMytheme() {
		return mytheme;
	}

	public void setMytheme(Theme mytheme) {
		this.mytheme = mytheme;
	}

	public List<Theme> getThemelist() {
		return themelist;
	}

	public void setThemelist(List<Theme> themelist) {
		this.themelist = themelist;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	
	

}
