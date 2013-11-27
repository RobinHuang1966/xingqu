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
					主题列表
				</div>

				<s:form action="ThemeList" method="post">
					<s:submit value="显示所有主题" />
				</s:form>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th width="50">
							主题ID
						</th>
						<th width="117">
							主题名称
						</th>
						<th width="50">
							主题简介
						</th>
						<th width="117">
							小组数
						</th>
						<th width="50">
							操作
						</th>
					</tr>
					<s:iterator value="themelist">
						<tr>
							<td>
								<s:property value="thId" />
							</td>
							<td>
								<s:property value="thName" />
							</td>
							<td>
								<s:property value="thBrief" />
							</td>
							<td>
								<s:property value="gnum" />
							</td>
							<td>
								<a
									href='<s:url action="Del"><s:param name="thId" value="thId" /></s:url>'>删除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<script>
var del=document.getElementById("delete");
del.onclick=function(){

     confirm("真的要删除此主题吗？");
	}	
</script>
			</div>
			<!--contanier-->
		</div>
		<!--main-->
	</body>
</html>
