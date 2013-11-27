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
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />s
<title>无标题文档</title>
</head>

<body>
<div id="main">
<div class="main_title">公告列表</div>
<div id="container">
<div class="for_name">小组列表</div>

<s:form action="GroupList" method="post">
	<s:submit value="显示所有小组" />
</s:form>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="10%">小组ID</th>
	<th width="10%">小组名称</th>
	<th width="10%">创建者</th>
	<th width="20%">小组简介</th>
	<th width="20%">创建时间</th>
	<th width="5%">话题数</th>
	<th width="10%">是否通过审核</th>
	<th width="5%">操作</th>
  </tr>
  <s:iterator value="grouplist">
	  <tr>
	    	<td><s:property value="gid"/></td>
	    	<td><s:property value="gtitle"/></td>
	    	<td><s:property value="user.unick"/></td>
	    	<td><s:property value="gbrief"/></td>
	    	<td><s:property value="gcreateTime"/></td>
	    	<td><s:property value="tnum" /></td>
	    	<td><s:property value="gisVerify"/></td>
	    	<td> <a href='<s:url action="DelGroup"><s:param name="gid" value="gid" /></s:url>'>删除</a> </td>
	  </tr>
  </s:iterator>
</table>

<script>
var del=document.getElementById("delete");
del.onclick=function(){

     confirm("真的要删除此小组吗？");
	}	
</script>
</div><!--contanier-->
</div><!--main-->
</body>
</html>
