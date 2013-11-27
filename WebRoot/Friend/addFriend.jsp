<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'MyJsp.jsp' starting page</title>
</head>

<body>
	<h2>编辑好友信息</h2>
	<form action="addFriend" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="75">用户号:</td>
				<td align="left">
				<input type="text"  name="uid" style="height:25px; width:240px;" /> 	
				</td>
			</tr>
			<tr>
				<td width="65">所加好友:</td>
				<td align="left"><input type="text" name="fuid" 	
				style="height:25px; width:240px;"  />
				</td>
			</tr>
			<tr>
				<td width="65">操作:</td>
				<td><input type="submit" value="保存" />
			</tr>
		</table>
	</form>
	<s:debug></s:debug>
</body>
</html>
