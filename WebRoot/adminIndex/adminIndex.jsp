<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>My JSP 'adminIndex.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<FRAMESET id=index border=0 frameSpacing=0 rows=120,* frameBorder=no>
		<FRAME id=topFrame name=topFrame src="adminIndex/MyOfficIndex/top.jsp"
			noResize scrolling=no>
		<FRAMESET border=0 frameSpacing=0 frameBorder=no cols=20%,*>
			<FRAME id=leftFrame name=leftFrame
				src="adminIndex/MyOfficIndex/left.jsp" noResize scrolling=no>
			<FRAME id=mainFrame name=mainFrame
				src="adminIndex/MyOfficIndex/welcome.jsp" noResize scrolling="auto">
			<FRAME id=mainFrame name=mainFrame
				src="adminIndex/MyOfficIndex/bottom.jsp" noResize scrolling="no">
		</FRAMESET>
	</FRAMESET>

	<body></body>
</html>
