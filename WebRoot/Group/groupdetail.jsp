<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="../SpryAssets_group/SpryTabbedPanels.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<base href="<%=basePath%>">

		<title>My JSP 'groupdetail.jsp' starting page</title>

	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>

		<div id="main">
			<div class="position">
				<a href="index.html"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="Group/showgroup">小组</a>&nbsp;>&nbsp; 小组详情
			</div>

			<div id="container">
				<div id="g_short">
					<div id="g_title">
						<img src="images/i2.png" id="group_image" />
						<h4 id="group_name">
							<s:property value="group.gtitle" />
						</h4>
						<span><a href="Group/joingroup?gid=<s:property value="group.gid" />"><input type="image" src="images/add_user.png">加入小组</a></span>
					</div>
					<span id="member_num">组员数：<s:property value="group.unum" />
					</span>
					<span id="apply_time">创建时间：<s:property
							value="group.gcreateTime.toString().substring(0,19)" /> </span>
					<span id="group_manager">组长：<s:property
							value="group.user.unick" /> </span>
					<p id="group_short">
						<s:property value="group.gbrief" />
					</p>
				</div>
				<!--g_short-->

				<div id="g_topic">
					<div class="temp">
						<span id="h_t">最热话题</span>
						<span id="reback_t"><a href="Topic/addtopic.jsp">发言</a> </span>
					</div>
					<div id="topic_list">
						<table width="660" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th width="240px" class="b_s">
									<span class="topic_title">话题</span>
								</th>
								<th width="80px" class="b_s">
									<span class="user_name">作者</span>
								</th>
								<th class="b_s">
									<span class="topic_reback">回复</span>
								</th>
								<th width="120px" class="b_s">
									<span class="topic_time">最后回复ID</span>
								</th>
							</tr>

							<s:iterator value="topiclist" var="topic">
								<tr>
									<td class="b_s">
										<span class="topic_title"><a
											href="Topic/showtopic?tid=<s:property value="#topic.tid" />"><s:property
													value="#topic.ttitle" /> </a> </span>
									</td>
									<td class="b_s">
										<span class="user_name"><a
											href="User/visitfriendspace?unick=<s:property
													value="#topic.user.unick" />"><s:property
													value="#topic.user.unick" /> </a> </span>
									</td>
									<td class="b_s">
										<span class="topic_reback"><s:property
												value="#topic.treplynum" /> </span>
									</td>
									<td class="b_s">
										<span class="topic_time"><s:property
												value="#topic.user.unick" /> </span>
									</td>
								</tr>

							</s:iterator>




						</table>

					</div>
					<!--topic_list-->
				</div>
				<!--g_topic-->
			</div>
			<!--container-->
			<div id="sider">


				<div id="apply">
					<a href="Group/editgroup"><h2>
							申请创建小组
						</h2> </a>
				</div>
			</div>
			<!--sider-->
			<div class="clear" style="padding: 0; margin: 0; clear: both"></div>
		</div>
		<!--main-->

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
