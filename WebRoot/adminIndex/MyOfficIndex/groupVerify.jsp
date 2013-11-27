<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>">
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
<title>无标题文档</title>
<style>
#group_name{
	width:100px;
	overflow:hidden;}
#group_des{
	width:150px;
	line-height:20px;
	overflow:hidden;
	}
</style>
</head>

<body>
<div id="main">
  <div class="main_title">审核小组</div>
<div id="container">

<s:form action="FindByGisVerify" method="post">
	<s:submit value="开始审核" />
</s:form>

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tr>
    <th width="55">小组ID</th>
	<th width="55">小组名称</th>
	<th width="55">创建者</th>
	<th width="55">小组简介</th>
	<th width="55">小组创建时间</th>
	<th width="55">操作</th>
  </tr>
  <s:iterator value="grouplist">
	  <tr>
	    	<td><s:property value="gid"/></td>
	    	<td><s:property value="gtitle"/></td>
	    	<td><s:property value="user.unick"/></td>
	    	<td><s:property value="gbrief"/></td>
	    	<td><s:property value="gcreateTime"/></td>
	    	<td> 
	    		<a href='<s:url action="ChangeVerify"><s:param name="gid" value="gid" /></s:url>'>同意</a>
	    		<a href='<s:url action="DisAgree"><s:param name="gid" value="gid" /></s:url>'>不同意</a>
	    	</td>
	  </tr>
  </s:iterator>
</table>
</div><!--container-->
</div><!--main-->
</body>
</html>
 