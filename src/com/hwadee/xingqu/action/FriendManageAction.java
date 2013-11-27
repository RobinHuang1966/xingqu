package com.hwadee.xingqu.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hwadee.xingqu.dao.FriendDAO;
import com.hwadee.xingqu.dao.UserDAO;
import com.hwadee.xingqu.model.Friend;
import com.hwadee.xingqu.model.Loger;
import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author ��͢��
 * ���������û�����Ӻ��Ѻ�ɾ�����
 *
 */
public class FriendManageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Integer fid;
	private int uid;
	private int fuid;
	private User userByFuid;
	private User userByUid;
	private Timestamp ftime;
	private Friend friend;
	private List<Friend> friendlist=new ArrayList<Friend>();
	private List<Loger> logerlist=new ArrayList<Loger>();
	private UserDAO userDAO=new UserDAO();
	private FriendDAO friendDAO=new FriendDAO();
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}
	public int getFuid() {
		return fuid;
	}
	public int getUid() {
		return uid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public User getUserByFuid() {
		return userByFuid;
	}
	public void setUserByFuid(User userByFuid) {
		this.userByFuid = userByFuid;
	}
	public User getUserByUid() {
		return userByUid;
	}
	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}
	public Timestamp getFtime() {
		return ftime;
	}
	public void setFtime(Timestamp ftime) {
		this.ftime = ftime;
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<Friend> getFriendlist() {
		return friendlist;
	}
	public void setFriendlist(List<Friend> friendlist) {
		this.friendlist = friendlist;
	}
	public List<Loger> getLogerlist() {
		return logerlist;
	}
	public void setLogerlist(List<Loger> logerlist) {
		this.logerlist = logerlist;
	}
	public String addFriend()
	{
		Friend f=new Friend();
		f.setFtime(new Timestamp(new Date().getTime()));
		User user=(User) ActionContext.getContext().getSession().get("user");	
		f.setUserByUid(user);
		User u2=userDAO.findById(fuid);
		f.setUserByFuid(u2);
		if(friendDAO.findByTwoproperty(u2,user).size()>0)
		{
			return ERROR;
		}
		else
		{
			friendDAO.save(f);
			return SUCCESS;

		}
	}
	public String deleteFriend()
	{
		Friend f=new Friend();
		f=friendDAO.findById(fid);
		if(f != null)
		{
			friendDAO.delete(f);	
		}
		return SUCCESS;
	}
}
