<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link rel="stylesheet" href="../css/css1.css" type="text/css" />
		<link rel="stylesheet" href="../css/all.css" type="text/css" />
	</head>
	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<!--home_header-->
		<div id="main">
			<div id="home_message_detail">
				<div class="home_title">
					<h2>
						<a href="3">留言板</a>
					</h2>
				</div>
				<div id="message">
					<s:form action="User/leavemessage">
						<textarea cols="100" rows="10" name="lcontent"></textarea>

						<input type="submit" value="留言" id="leave_word" />
					</s:form>
					<ul>
						<s:iterator value="myMessageList" var="loger">
							<li>
								<div id="user_images">
									<span id="user_image"><img src="images/i8.png" /> </span>
									<br />
									<span id="user_name"> <a href="#"></a> </span>
								</div>
								<p>
									<s:property value="#loger.lcontent" />
								</p>
								<span><s:property
										value="#loger.ltime.toString().substring(0,16)" /> </span>
							</li>
						</s:iterator>
						<div class="clear"
							style="padding: 0; border: 0; margin: 0; clear: both;"></div>
					</ul>
				</div>
				<!--message-->
			</div>
		</div>
		<s:debug></s:debug>
		<!--main-->
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
