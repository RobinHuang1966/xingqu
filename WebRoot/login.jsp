<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'login.jsp' starting page</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/all.css" type="text/css" />
	</head>
	<body>
		<div id="login_bg"
			style="background: url(images/login_bg.png) no-repeat; margin: 0 auto; width: 1000px; height: 620px">
			<div id="nav">
				<div id="logo"></div>
				<!--logo-->
				<div id="enter">
					<a href="login.jsp">登录</a><a href="register.jsp">注册</a>
				</div>
				<!--login-->
				<div id="search">
					<form action="./?" method="get">
						<input type="text" size="30" value="搜索小组、作品、话题、好友" />
						<input type="image" src="images/find.png"
							style="background: #ccc; height: 20px; width: 20px;" />
					</form>
				</div>
				<!--search-->
				<ul>
					<li>
						<a href="forward.jsp">首页</a>
					</li>

					<li>
						<a href="Group/grouplist">小组</a>
					</li>
					<li>
						<a href="Works/workslist">作品</a>
					</li>
					<li>
						<a href="User/persondynamic">家园</a>
					</li>
				</ul>

			</div>
			<!--nav-->
			<div id="main" style="height: 540px; background: none;">
				<div id="login">
					<form action="User/login" method="post">
						用户名：
						<s:textfield name="unick" label="用户名" theme="simple"></s:textfield>

						<br />
						&nbsp;&nbsp;&nbsp;
						<s:password name="upassword" label="密码"></s:password>
						<br />
						<input type="submit" value="登录"
							style="margin-left: 100px; width: 50px; border: none" />
						<a href="register.jsp">注册</a>
						<s:fielderror value="unick"></s:fielderror>
					</form>


				</div>
				<!--login-->
			</div>
			<!--main-->
			<div id="footer">
				<p>
					青阳教育平台——
					<a href="index">兴趣小组</a>
				</p>
				<p>
					版权所有：西北农林科技大学J2EE第七小组
				</p>
				<a href="admin/adminLogin.jsp">管理入口</a>
			</div>
			<!--footer-->
		</div>
		<!--login_bg-->
	</body>
</html>
