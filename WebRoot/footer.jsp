<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'footer.jsp' starting page</title>

	</head>

	<body>
		<div id="footer">
			<p>
				青阳教育平台——
				<a href="forward.jsp">兴趣小组</a>
			</p>
			<p>
				版权所有：西北农林科技大学J2EE第七小组
			</p>
			<a href="admin/adminLogin.jsp">管理入口</a>
		</div>
		<!--footer-->
	</body>
</html>
