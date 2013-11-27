package com.hwadee.xingqu.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.hwadee.xingqu.dao.ThemeDAO;
import com.hwadee.xingqu.model.Group;
import com.hwadee.xingqu.model.Theme;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author 何俐珺
 * @since 2013-07-06
 * 此类用于主题的增删改查
 *
 */
public class ThemeManageAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int thId;
	private String thName;
	private String thBrief;
	private String Type;
	private Theme mytheme;
	private List<Theme> list= new ArrayList<Theme>();
	private Set<Group> groups = new HashSet<Group>(0);
	private ThemeDAO themedao= new ThemeDAO();

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
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public List<Theme> getList() {
		return list;
	}
	public void setList(List<Theme> list) {
		this.list = list;
	}

	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	/**
	 * @return 娣诲姞Theme
	 */
	public String addTheme()
	{
		Theme mytheme= new Theme();
		for(int i=1;i<=5;i++)
		{
			mytheme.setThBrief("This is a good theme!");
			mytheme.setThName("AddTheme"+i);
			themedao.save(mytheme);
		}
		//themedao.getSession().flush();
		return "success";
	}
	@SuppressWarnings("unchecked")
	public String themeList()
	{
		this.list=themedao.findAll();
		return SUCCESS;
	}
	public String deleteTheme()
	{	
		Theme mytheme= new Theme();
		mytheme=themedao.findById(thId);
		if(mytheme != null)
		{
			themedao.delete(mytheme);
		}
		return "success";
	}
	public String load()
	{
		//mytheme=themedao.findById(thId);
		this.setMytheme(themedao.findById(thId));
		return "success";
	}
	public String editTheme()
	{	
		Theme mytheme=new Theme();
		mytheme.setThId(thId);
		mytheme.setThName(thName);
		mytheme.setThBrief(thBrief);

		//themedao.merge(mytheme);
		if(mytheme.getThId() != null)
			themedao.merge(mytheme);
		else
			themedao.save(mytheme);
		themedao.getSession().flush();
		return "success";
	}

	public String clearAll()
	{
		Theme theme=new Theme();
		for(int i=1101;i<2000;i++)
		{
			theme=themedao.findById(i);
			if(theme != null)
			{
				themedao.delete(theme);
			}
		}
		return "success";
	}
	public int getThId() {
		return thId;
	}
	public void setThId(int thId) {
		this.thId = thId;
	}
	public Theme getMytheme() {
		return mytheme;
	}
	public void setMytheme(Theme mytheme) {
		this.mytheme = mytheme;
	}


}
