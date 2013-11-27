<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  %>
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
		<center>
			<!--  <a href="Topic/addtopic.jsp">添加话题</a> -->
			<a href="Topic/findTopicsimple?&tid=<s:property value="0"/>" >添加话题</a>
			<s:form action="Topic/find_topic">
				<s:textfield name="tcontent" label="搜索话题"></s:textfield>
				<s:submit value="查询"></s:submit>
			</s:form>
			<h3>
				话题列表
			</h3>
			<table border="1">
				<tr>
					<td>
						话题名称
					</td>
					<td>
						话题简介
					</td>
					<td>
						所属小组
					</td>
					<td>
						回复数
					</td>
				<!--  <td>
						分享数
					</td>
					<td>
						关注数
   			        </td>   -->	
					<td>
						话题创建时间
					</td>
					<td>
						操作
					</td>
				</tr>
				<s:iterator value="topiclist" var="topic">
					<tr>
						<td>
							<a href="Topic/showtopic?tid=<s:property value="#topic.tid" />"><s:property
									value="#topic.ttitle" /> </a>
						</td>
						<td>
							<s:property value="#topic.tcontent" />
						</td>
						<td>
							<s:property value="#topic.group.gtitle" />
						</td>
						<td>
							<s:property value="#topic.treplynum" />
					<!--  	</td>
							<s:property value="#topic.shareNum" />
						</td>
						<td>
							<s:property value="#topic.attentionNum" />
						</td>   -->
					
						<td>
							<s:property value="#topic.tcreatTime.toString().substring(0,19)" />
						</td>
						<td>
							<a href="Topic/deletetopic?tid=<s:property value="#topic.tid" />">删除</a>
						    <a href="Topic/findTopicsimple?&tid=<s:property value="#topic.tid" />
								&gtitle=<s:property value="#topic.group.gtitle"/>" >修改</a>	
							<a href="Topic/sharetopic?tid=<s:property value="#topic.tid" />">分享</a>
							<a href="Topic/deleteShareTopic?tid=<s:property value="#topic.tid" />">取消分享</a>
							<a href="Topic/attentiontopic?tid=<s:property value="#topic.tid" />">关注</a>
							<a href="Topic/deleteAttentionTopic?tid=<s:property value="#topic.tid" />">取消关注</a>
						</td>
					</tr>
					
				</s:iterator>
			</table>
			<s:debug></s:debug>
		</center>
	</body>
</html>
