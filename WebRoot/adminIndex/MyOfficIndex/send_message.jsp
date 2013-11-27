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
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<title>无标题文档</title>
</head>

<body>
<div id="main">
  <div class="main_title">发送消息</div>
<div id="container">
<form action="?" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="75">编号</th>
    <th width="126">时间</th>
    <th width="102">被动用户</th>
    <th width="82">标志位</th>
    <th width="202">具体消息描述</th>
    <th width="121">操作</th>
  </tr>
  <tr>
    <td><span id="oper_num">1</span></td>
    <td><span id="oper_time">2012.3.3 12:12:12</span></td>
    <td><span id="user_name">张晓宁</span></td>
    <td><span id="oper_sign">0(消息未读)</span></td>
    <td><span id="oper_describe"><textarea cols="40" rows="3">用户申请创建小组，已经同意</textarea></span></td>
    <td>
        <input type="submit" value="确定" id="update"/></td>
  </tr>
</table>
</form>
</div><!--container-->
</div><!--main-->
</body>
</html>
