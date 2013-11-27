<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>My JSP 'topiclist.jsp' starting page</title>
	</head>
	<body>	
		<h2>好友显示表</h2>
		<a href='addFriend.jsp'>手动关注好友</a><br/>
		<a href='add'>自动关注好友</a>
		<table border="1px" >
		<tr align="center">
		<td>序号</td>
		<td>用户名</td>
		<td>好友名</td>
		<td>加友时间</td>
		<td>操作</td>


		<c:forEach items="${friendlist}" var="friend">
			<tr>
				<td>${friend.fid}</td>
				<td>${friend.userByUid.unick}</td>
				<td>${friend.userByFuid.unick}</td>
				<td>${friend.ftime}</td>
				<td>
					<a href='deleteFriend?fid=${friend.fid}'>取消关注</a>
				</td>
			</tr>
		</c:forEach>
		
		</table>

		<s:debug></s:debug>
	</body>
</html>
