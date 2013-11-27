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
</head>

<body>
<div id="main">
<div class="main_title">查找小组</div>
<div id="container">
<s:form action="FindGroupByGTitle" method="post">
	<s:textfield name="gtitle" />
	<s:submit value="查找" />
</s:form>
<div id="result">
<table width="775" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="10%">小组ID</th>
	<th width="10%">小组名称</th>
	<th width="10%">创建者</th>
	<th width="25%">小组简介</th>
	<th width="15%">创建时间</th>
	<th width="10%">话题数</th>
	<th width="15%">是否通过审核</th>
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
</div>

</div><!--contanier-->
</div><!--main-->
</body>
</html>
