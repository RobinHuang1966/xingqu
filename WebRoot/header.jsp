<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<script language="javascript" src="js/jquery1.4.js"></script>

	</head>

	<body>
		<div id="header">
			<div id="nav">
				<div id="logo"></div>
				<!--logo-->
				<s:if test="#session.unick!=null">
					<div id="enter2">
						<a href="Space/home.jsp">欢迎您，<s:property
								value="#session.unick" /> </a><a href="xingqu/userexit"><input
								type="button" value="退出" style="border: none;" /> </a>
					</div>
				</s:if>
				<s:else>
					<!--enter2-->
					<div id="enter">
						<a href="login.jsp">登录<s:property value="#session.unick" /> </a><a
							href="register.jsp">注册</a>
					</div>
				</s:else>

				<div id="search">
					<form action="serach" method="post">
						<input type="text" size="30" value="搜索小组、作品、话题、好友"  name="like" id="keyword"/>
						<input type="image" src="images/find.png"
							style="background: #ccc; height: 20px; width: 20px;" />
					</form>
				</div>
<script>
	var keyword = document.getElementById("keyword");
	keyword.onclick = function() {
		keyword.value = "";
	};
</script>
				<!--search-->
				<ul id="nav_ul">
					<li>
						<a href="index">首页</a>
					</li>
					
					<li>
						<a href="Group/showgroup">小组</a>
					</li>
					<li>
						<a href="Works/workslist">作品</a>
					</li>
					<li>
						<a href="User/showmyhome">家园</a>
					</li>
				</ul>
			</div>
			
			<div id="banner">
			</div>
			<!--banner-->
		</div>
		<!--header-->
	</body>
</html>
