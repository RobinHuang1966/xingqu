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

		<script src="../SpryAssets_group/SpryTabbedPanels.js"
			type="text/javascript">
	
</script>
		<link href="../SpryAssets_group/SpryTabbedPanels.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<title>My JSP 'showtopic.jsp' starting page</title>

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
		<div id="header">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>
		<div id="main">
			<div class="position">
				<a href="index"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="Group/showgroup">话题</a>&nbsp;>&nbsp; 话题讨论
			</div>
			<div id="container">
				<div id="t_detail">
					<div id="topic_title">
						<s:property value="topic.ttitle" />
					</div>
					<span id="user_name">作者：
						<a href="User/visitfriendspace?unick=<s:property value="%{topic.user.unick}"/>">
						<s:property value="%{topic.user.unick}" /> </a>  </span>
					<span id="topic_time"><s:property
							value="topic.tcreatTime.toString().substring(0,16)" /> </span>
					<span id="topic_share"><a href="Topic/sharetopic?tid=<s:property value="%{topic.tid}" />">分享</a>&nbsp; </span>
					<span id="topic_collect"><a href="Topic/attentiontopic?tid=<s:property value="%{topic.tid}" />">关注</a>&nbsp; </span>
					<p id="topic_con">
						<b>讨　论：</b><s:property value="topic.tcontent" />
					</p>
				</div>
				<!--t_detail-->

				<br>
				<ul id="reback_list">

					<s:iterator value="logerList" var="loger"><!--logerList表示对该话题的所有回复 -->
						<%
							int i = 0;
						%>
						<li>
							<span class="user_image"><img src="images/i4.png" /> </span>
							<span class="user_name">用户名：
								<a href="User/visitfriendspace?unick=<s:property value="#loger.user.unick"/>">
								<s:property value="#loger.user.unick" /> </a>  	</span>			
							<span class="reback_time"><s:property
									value="#loger.ltime.toString().substring(0,16)" /> </span>
							<p class="reback_con">
								回　复： <s:property  value="#loger.lcontent" />
							</p>
							
							<div id="clear" style="padding: 0; margin: 0; clear: both;"></div>
						</li>
					</s:iterator>
				</ul>

				<!--reback_list-->
				<s:form action="Topic/replytopic" id="replayArea">
					<s:textfield name="tid" value="%{topic.tid}" id="topicid"></s:textfield>
					<s:textarea name="lcontent"></s:textarea>
					<s:submit value="回复"></s:submit>
				</s:form>
			</div>
			<!--container-->

			<div id="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<s:debug></s:debug>
		<!--mian-->
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
