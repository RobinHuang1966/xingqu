<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
	</head>

	<body>
		<div id="main">
			<div class="main_title">
				添加主题
			</div>
			<div id="container">
				<s:form action="Add" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="244">
								主题名称
							</td>
							<td width="489">
								主题简介
							</td>
						</tr>

						<tr>
							<td>
								<s:textfield name="thName" theme="simple" />
							</td>
							<td>
								<s:textfield name="thBrief" theme="simple" />
							</td>
							<s:submit value="保存" />
						</tr>

					</table>
				</s:form>
			</div>
			<!--container-->
		</div>
		<!--main-->
	</body>
</html>
