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
<title>无标题文档</title>
<base href="<%=basePath%>">
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
</head>

<body>
<div id="main">
  <div class="main_title">删除主题</div>
<div id="container">
<form action="subject_edit.html" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="244">主题</th>
    <th width="489">描述</th>
    <th width="65">操作</th>
  </tr>
  <tr>
    <td align="left"><span id="subject">数学</span></td>
    <td id="group_des"><span id="subject_describe">描述描述描述</span></td>
    <td><input type="button" value="删除" id="delete"/><a href="subject_edit.html"><input type="button" value="修改"/></a></td>
    
  </tr>
</table>
</form>
<script>
var del=document.getElementById("delete");
del.onclick=function(){

     confirm("真的要删除此小组吗？");
	}	
</script>
</div><!--container-->
</div><!--main-->
</body>
</html>
