<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style>
table th{
background:#39c;}
</style>
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
			<div class="main_title">
				用户列表
			</div>
			<div id="container">
				<div class="for_name">
					用户列表
				</div>

				<s:form action="UserList" method="post">
					<s:submit value="显示所有用户" />
				</s:form>

				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<th>
							昵称
						</th>
						<th>
							真实姓名
						</th>
						<th>
							注册时间
						</th>
						<th>
							性别
						</th>
						<th>
							状态
						</th>
						<th>
							身份
						</th>
						<th>
							电子邮件
						</th>
						<th>
							年级
						</th>
						<th>
							学校
						</th>
						<th>
							兴趣
						</th>
						<th>
							最后登录时间
						</th>
						<th>
							删除
						</th>
					</tr>

					<s:iterator value="userlist">
						<tr>
							<td>
								<s:property value="unick" />
							</td>
							<td>
								<s:property value="uname" />
							</td>
							<td>
								<s:property value="uregTime" />
							</td>
							<td>
								<s:property value="usex" />
							</td>
							<td>
								<s:property value="ustate" />
							</td>
							<td>
								<s:property value="utype" />
							</td>
							<td>
								<s:property value="uemail" />
							</td>
							<td>
								<s:property value="ugrade" />
							</td>
							<td>
								<s:property value="uschool" />
							</td>
							<td>
								<s:property value="uinterest" />
							</td>
							<td>
								<s:property value="ulastLoginTime" />
							</td>

							<td>
								<a
									href='<s:url action="DelUser"><s:param name="uid" value="uid" /></s:url>'>删除</a>
							</td>

						</tr>

					</s:iterator>
				</table>

				<script>
var del=document.getElementById("delete");
del.onclick=function(){

     confirm("真的要删除此用户吗？");
	}	
</script>
			</div>
			<!--contanier-->
		</div>
		<!--main-->
	</body>
</html>
