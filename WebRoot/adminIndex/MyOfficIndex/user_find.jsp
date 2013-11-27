<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<base href="<%=basePath%>">
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
<title>无标题文档</title>
</head>

<body>
<div id="main">
<div class="main_title">查找用户</div>
<div id="container" >
<s:form action="ShowUserInfo" method="post">
	<s:textfield name="unick" />
	<s:submit value="查找" />
</s:form>
<div id="result">
<table width="775" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="36">昵称</th>
    <th width="62">姓名</th>
    <th width="59">密码</th>
    <th width="40">性别</th>
    <th width="59">邮箱</th>
    <th width="82">兴趣</th>
    <th width="76">注册时间</th>
    <th width="71">最后登录时间</th>
    <th width="45">状态</th>
    <th width="48">操作</th>
  </tr>
   	
   	<s:iterator value="userlist">
	<tr>
		<td> <s:property value="unick"/> </td>
		<td> <s:property value="uname"/> </td>
		<td> <s:property value="upassword"/> </td>
		<td> <s:property value="usex"/> </td>
		<td> <s:property value="uemail"/> </td>
	    <td> <s:property value="uinterest"/> </td>
		<td> <s:property value="uregTime"/> </td>			
		<td> <s:property value="ulastLoginTime"/> </td>
		<td> <s:property value="ustate"/> </td>		    				
		<td> <a href='<s:url action="DelUser"><s:param name="uid" value="uid" /></s:url>'>删除</a> </td>
		
	</tr>		
	</s:iterator>
</table>
</div>

</div><!--contanier-->
</div><!--main-->
</body>
</html>
