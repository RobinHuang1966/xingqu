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
		<title>My JSP 'page.jsp' starting page</title>

	</head>

	<body>
		<center>
			<ul>

				<li>
					当前第
					<s:property value="page" />
					页,共
					<s:property value="planNum" />
					条记录, 共分
					<s:property value="totalPage" />
					页
				</li>
				<li>
					<a href="Works/workslist?page=<s:property value="1"/> ">第一页</a>

				</li>
				<li>
					<s:if test="page<=1">
					</s:if>
					<s:else>
						<a href="Works/workslist?page=<s:property value="page-1"/> ">上一页</a>
					</s:else>
				</li>
				<li>

					<s:form action="Works/workslist">
						<s:submit value="跳转到" style="border:none;">
							<input type="text" name="page" size="1">页</s:submit>

					</s:form>
				</li>
				<li>
					<s:if test="page>=totalPage">
					</s:if>
					<s:else>
						<a href="Works/workslist?page=<s:property value="page+1"/> ">下一页</a>
					</s:else>
				</li>
				<li>
					<a href="Works/workslist?page=<s:property value="totalPage"/> ">最后一页</a>
				</li>
			</ul>
		</center>
	</body>
</html>
