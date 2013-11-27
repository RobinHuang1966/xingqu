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

		<title>My JSP 'edittopic.jsp' starting page</title>

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
		
		<s:form action="Topic/updatetopic">
		<s:if test="%{tid} == 0 ">
			<s:textfield label="话题编号" name="tid" value=""></s:textfield>  
			<s:textfield label="话题名称" name="ttitle" value=""></s:textfield>
			<s:select  label="所属小组" style="width:165px;" name="gtitle" list="groupNames" 
					value="请选择" headerKey="-1" headerValue="请选择">
			</s:select>
			<s:textarea  label="话题简介" name="tcontent" value=""></s:textarea>
		</s:if>
		<s:else>
			
			<<s:textfield label="话题编号" name="tid" value="%{tid}"></s:textfield>
			<s:textfield label="话题名称" name="ttitle" value="%{ttitle}"></s:textfield>
			
			<s:select  label="所属小组" style="width:165px;" name="gtitle" list="groupNames" 
					  headerKey="0" headerValue="%{gtitle}">
			</s:select>
			<s:textarea  label="话题简介" name="tcontent" value="%{tcontent}"></s:textarea>
		</s:else>
			<s:submit></s:submit>
		</s:form>
		<s:debug />
	</body>
</html>
