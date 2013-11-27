package com.hwadee.xingqu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.chainsaw.Main;
import org.usc.utils.UploadConfigurationRead;
/**
 * 
 * @author ����
 * @since2013-07-06
 *���������ļ�����
 */
public class DownloadAction extends ActionSupport
{
	private static final long serialVersionUID = 6329383258366253255L;
	private User user;
	private Integer wid;
	private String wcontent;
	private String wname;
	private WorksDAO worksDAO= new WorksDAO();
	LogerDAO logerDAO=new LogerDAO();
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getWname() throws UnsupportedEncodingException {
		wname = new String(wname.getBytes("GBK"), "UTF-8");
		
		return wname;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getWcontent() {
		return wcontent;
	}

	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}

	public void setWname() {
		String fname = null;
		String frealname = null;
		Works works= new Works();
		works=worksDAO.findById(wid);
		wname=works.getWname();
		wcontent=works.getWcontent();

		try
		{

			fname = new String(wname.getBytes(), "utf-8");
			frealname= new String(wcontent.getBytes(), "UTF-8");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		this.wname=fname;
		this.wcontent = frealname;
	}

	/*
	 * @getDownloadFile �˷�����Ӧ����struts.xml�ļ��еģ� <param
	 * name="inputName">downloadFile</param> ���������ļ�����
	 */
	public InputStream getDownloadFile() throws FileNotFoundException
	{
		this.setWname();
		File FF= new File(UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim()+"/" +wcontent);
		InputStream is=new FileInputStream(FF);
		return is;

	}

	public String downLoadWorks() throws Exception
	{
		Works works=worksDAO.findById(wid);
		works.setWloadNum((works.getWloadNum()+1));
		worksDAO.attachDirty(works);
		
		User user=(User) ActionContext.getContext().getSession().get("user");
		Loger loger=new Loger();//将上传文件信息保存到loger，8号表示下载作品
		loger.setUser(user);
		loger.setLtype(8);
		loger.setWorks(works);
		loger.setLcontent(works.getWname());
		loger.setLtime(new Timestamp(new Date().getTime()));
		loger.setPuser(works.getUser());
		loger.setFlag(0);
		logerDAO.save(loger);
		return SUCCESS;
	}

}