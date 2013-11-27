<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<title>无标题文档</title>
</head>

<body>
<div id="main">
  <div class="main_title">修改密码</div>
<div id="container">
<form action="?" method="post">
  &nbsp;&nbsp;管理员：<input type="text" value="admin" size="20" style="height:25px; margin-bottom:10px;"/><br/>
  &nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" value="" size="20" style="height:25px; margin-bottom:10px;"/><br/>
  确认密码：<input type="password" value="" size="20" style="height:25px; margin-bottom:10px;"/><br/>
  <input type="submit" value="确定"/>
</form>
</div><!--container-->
</div><!--main-->
</body>
</html>