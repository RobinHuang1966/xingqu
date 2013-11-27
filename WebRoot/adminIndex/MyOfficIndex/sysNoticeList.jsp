<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<title>无标题文档</title>
</head>

<body>
<div id="main">
<div class="main_title">公告列表</div>
<div id="container">
<div class="for_name">公告列表</div>

<s:form action="SysNoticeList" method="post">
	<s:submit value="显示所有公告" />
</s:form>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="10%">公告编号</th>
	<th width="20%">公告标题</th>
    <th width="45%">公告内容</th>
    <th width="15%">公告发布时间</th>
    <th width="10%">操作</th>
  </tr>
  <s:iterator value="sysnoticelist">
	<tr>
		<td> <span> <s:property value="sysId"/> </span> </td>
		<td> <span> <s:property value="sysTitle"/> </span> </td>
		<td> <span> <s:property value="sysContent"/> </span> </td>
		<td> <span> <s:property value="sysPublTime"/> </span> </td>		
		<td>
		  <span id=del>
			<a href='<s:url action="DelSysNotice"> 
			<s:param name="sysId" value="sysId" /></s:url>'>删除</a> 
		  </span>
		</td>
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
