<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link rel="stylesheet" href="css/css1.css" type="text/css" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
	</head>

	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<!--home_header-->
		<div id="main">
			<div id="home_pro_area">
				
				
				<div class="home_pro_title">
					<h2>
						我创建的话题
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="129">
							小组名称
						</td>
						<td width="100">
							所属小组
						</td>
						<td width="300">
							话题简介
						</td>
						<td width="130">
							创建时间
						</td>
						<td width="90">
							回复数
						</td>
						<td width="51">
							操作
						</td>
					</tr>
					<s:iterator value="topics" var="topic">
						<tr>
							<td>
								<span id="pro_name"><a href="production_detail.html"><s:property value="#topic.ttitle"/></a>
								</span>
							</td>
							<td>
								<span ><s:property value="#topic.group.gtitle"/>
								</span>
							</td>
							<td>
								<span id="user_name"><s:property value="#topic.tcontent"/>
								</span>
							</td>
							<td>
								<span id="topic_time"><s:property value="#topic.tcreatTime.toString().substring(2,16)"/></span>
							</td>
							<td>
								<span id="pro_comment_good"><s:property value="#topic.treplynum"/></span>
							</td>
							<td>
								<span id="pro_comment_ban"><a href="deletetopic?tid= <s:property value="#topic.tid"/> ">
								删除话题 </a></span>
							</td>
						</tr>
					</s:iterator>
				</table>
				
				<div class="home_pro_title">
					<h2>
						我关注的话题
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<!-- <td width="433">
							话题ID
						</td> -->
						<td width="129">
							话题名称
						</td>
						<td width="90">
							作者
						</td>
						<td width="70">
							所属小组
						</td>
						<td width="240">
							话题简介
						</td>
						<td width="130">
							创建时间
						</td>
						<td width="90">
							回复数
						</td>
						<td width="51">
							操作
						</td>
					</tr>
					<s:iterator value="attentionTopicList" var="loger">
						<tr>
							
							<td>
								<span id="user_name"><s:property value="#loger.topic.ttitle"/>
								</span>
							</td>
							<td>
								<span id="user_name"><s:property value="#loger.topic.user.unick"/>
								</span>
							</td>
							<td>
								<span ><s:property value="#loger.topic.group.gtitle"/>
								</span>
							</td>
							<td>
								<span ><s:property value="#loger.topic.tcontent"/>
								</span>
							</td>
							<td>
								<span id="topic_time"><s:property value="#topic.tcreatTime.toString().substring(2,16)"/></span>
							</td>
							<td>
								<span id="pro_comment_good"><s:property value="#loger.topic.treplynum"/></span>
							</td>
							<td>
								<span id="pro_comment_ban"><a href="User/deleteAttentionTopic?tid=<s:property value="#loger.topic.tid"/>">取消关注</a></span>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<!--mian-->
		<div class="clear"
			style="padding: 0; border: 0; margin: 0; clear: both;"></div>

		<div id="footer">
			<p>
				版权所有：西北农林科技大学信息工程学院华迪实习第七小组
			</p>
			<p>
				<a href="#">管理入口</a>
			</p>
		</div>
		<s:debug></s:debug>
	</body>
</html>
