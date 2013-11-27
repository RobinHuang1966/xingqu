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
		<script src="SpryAssets_pro/SpryTabbedPanels.js"
			type="text/javascript"></script>
		<link href="SpryAssets_pro/SpryTabbedPanels.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript" src="js/jquery1.4.js"></script>
		<title>My JSP 'upload.jsp' starting page</title>

	</head>
	<body>
		<s:form action="Works/uploadmyfile" theme="simple" method="post"
			enctype="multipart/form-data">
			<img src="images/go_up_blue.png"
				style="width: 20px; height: 20px; float: left;" />
			<s:file name="myFile" label="上传作品" />
			<s:submit value=" 确认 "></s:submit>
			<s:reset value=" 重置 "></s:reset>
		</s:form>
	</body>
</html>
