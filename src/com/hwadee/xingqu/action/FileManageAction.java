package com.hwadee.xingqu.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.usc.utils.UploadConfigurationRead;

import com.hwadee.xingqu.dao.LogerDAO;
import com.hwadee.xingqu.dao.PagingDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.dao.WorksDAO;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.User;
import com.hwadee.xingqu.model.Works;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileManageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String redirect;
	private Integer wid;
	private User user;
	private String wbrief;
	private String wcontent;
	private String wname;
	
	private Double wsize;
	private Integer wgood;
	private Integer wbad;
	private Timestamp wtime;
	private String wtype;
	private PagingDAO pagingDAO=new PagingDAO();
	private int rowsPerPage = 30;  // ÿҳ��ʾ����  
	private int page = 1;         // Ĭ�ϵ�ǰҳ  
	private int totalPage;        // �ܹ�����ҳ  
	private int planNum;          // �ܹ������  

	private List<Works> worksList;
	private Set<Loger> logers = new HashSet<Loger>(0);
	private WorksDAO worksDAO=new WorksDAO();
	LogerDAO logerDAO=new LogerDAO();
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
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
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Double getWsize() {
		return wsize;
	}
	public void setWsize(Double wsize) {
		this.wsize = wsize;
	}
	public Integer getWgood() {
		return wgood;
	}
	public void setWgood(Integer wgood) {
		this.wgood = wgood;
	}
	public Integer getWbad() {
		return wbad;
	}
	public void setWbad(Integer wbad) {
		this.wbad = wbad;
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
	public static String getExt(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("."));
	}

	public Set<Loger> getLogers() {
		return logers;
	}
	public void setLogers(Set<Loger> logers) {
		this.logers = logers;
	}

	public List<Works> getWorksList() {
		return worksList;
	}
	public void setWorksList(List<Works> worksList) {
		this.worksList = worksList;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPlanNum() {
		return planNum;
	}
	public void setPlanNum(int planNum) {
		this.planNum = planNum;
	}
	
	public String uploadFile() throws Exception
	{
		try
		{
			String targetDirectory = UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim();// ���·��

			String fileName = myFileFileName;// �ϴ����ļ���
			System.out.println("myFileFileName:"+myFileFileName);
			String realName=UUID.randomUUID().toString();
			String realPath = realName+ getExt(fileName);// ������ļ���ƣ�ʹ��UUID+��׺���б���

			File target = new File(targetDirectory, realPath);
			FileUtils.copyFile(myFile, target);// �ϴ�����������Ŀ¼
			String unick=(String) ActionContext.getContext().getSession().get("unick");
			UserDAO userDAO=new UserDAO();
			User u=userDAO.findByUnick(unick);
			Works works= new Works();
			works.setUser(u);
			works.setWname(fileName);
			//System.out.println("fileName:"+fileName);
			works.setWcontent(target.getName());
			works.setWgood(0);
			works.setWbad(0);
			works.setWloadNum(0);
			works.setWbrief(wbrief);
			works.setWsize((float)myFile.length()/(1024*1024));
			String suffix=getExt(fileName);
			if(suffix.equals(".docx")||suffix.equals(".doc")||suffix.equals(".ppt")||suffix.equals(".pptx")||suffix.equals(".wps")||suffix.equals(".txt")||suffix.equals(".xls")||suffix.equals(".xlsx"))
			{
				works.setWtype("0");
			}
			else if(suffix.equals(".mp4")||suffix.equals(".avi")||suffix.equals(".mkv")||suffix.equals(".rmvb")||suffix.equals(".flv")||suffix.equals(".mov")||suffix.equals(".rm")||suffix.equals(".TS"))
			{
				works.setWtype("1");
			}
			else if(suffix.equals(".bmp")||suffix.equals(".gif")||suffix.equals(".jpeg")||suffix.equals(".png")||suffix.equals(".swf")||suffix.equals(".svg"))
			{
				works.setWtype("2");
			}
			else
			{
				works.setWtype("3");
			}
			works.setWtime(new Timestamp(new Date().getTime()));
			worksDAO.save(works);
			
			Loger uploger=new Loger();//将上传文件信息保存到loger，7号表示上传作品
			uploger.setUser(u);
			uploger.setLtype(7);
			uploger.setWorks(works);
			uploger.setLcontent(fileName);
			uploger.setLtime(works.getWtime());
			uploger.setFlag(0);
			logerDAO.save(uploger);
			
		} catch (Exception e)
		{
			//System.out.print("dasdfasfasdf"+e);
			addActionError(e.getMessage());

			return INPUT;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @return success 
	 * @throws Exception
	 * @author yongzhang
	 * @since 2013-07-07
	 * �˷��������ļ�չʾ
	 */
	@SuppressWarnings("unchecked")
	public String showWorksList()
	{

		worksList =pagingDAO.findPlantByPage(page, rowsPerPage, "Works", "wtime");
		System.out.println(worksList);
		planNum=pagingDAO.getPlanNum("Works");
		totalPage = pagingDAO.getPlanTotalPage(rowsPerPage, "Works");  
		return SUCCESS;
	}
	/**
	 * 
	 * @return success 
	 * @author yongzhang
	 * @since 2013-07-07
	 * �˷��������û��������Ͳ鿴�ļ�
	 */
	@SuppressWarnings("unchecked")
	public String sortByType()
	{
		List<Works> list=pagingDAO.findPlantByPage(page, rowsPerPage, "Works", "wtime");
		for(int i = 0;i<list.size();++i)
		{
			if(list.get(i).getWtype().endsWith(wtype))
			{
				worksList.add(list.get(i));
			}
		}
		planNum=pagingDAO.getPlanNum("Works");
		totalPage = pagingDAO.getPlanTotalPage(rowsPerPage, "Works");  
		return SUCCESS;
	}
	/**
	 * 
	 * @return success 
	 * @throws Exception
	 * @author yongzhang
	 * @since 2013-07-07
	 * �˷��������û�ɾ���Լ��ϴ����ļ�
	 */
	public String deleteWorks()
	{
		Works w=worksDAO.findById(wid);

		File f=new File(UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim()+"/" +w.getWcontent());
		//System.out.println(f.getAbsolutePath());
		if(f.delete())
		{
			worksDAO.delete(w);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}
