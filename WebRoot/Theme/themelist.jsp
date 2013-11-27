<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'topiclist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table>
			<s:iterator value="list" var="theme">

				<tr>
					<td>
						主题名称：
						<s:a href="www.baidu.com">
							<s:property value="#theme.thName" />
						</s:a>
					</td>
				</tr>
				<tr>
					<td>
						主题简介：
						<s:property value="#theme.thBrief" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<s:debug></s:debug>
	</body>
</html>
