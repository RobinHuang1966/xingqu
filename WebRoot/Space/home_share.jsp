<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'home_share.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="css/all.css">
		<link rel="stylesheet" href="css/css1.css" type="text/css" />
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
		<jsp:include page="head.jsp"></jsp:include>
		<div id="main">
			<div id="home_pro_area">
				<div class="home_pro_title">
					<h2>
						�ҷ���Ļ���
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="433">
							������
						</td>
						<td width="129">
							����
						</td>
						<td width="121">
							����ʱ��
						</td>
						<td width="57">
							�ظ���
						</td>
						<td width="91">
							����
						</td>
					</tr>
					<c:forEach items="${myShareList}" var="loger">
							<tr>
							
							<c:choose>
									<c:when test="${loger.ltype==2}">
			
									<td><span id="pro_name"><a href="Topic/showtopic?tid=${loger.topic.tid }"> ${loger.topic.ttitle}</a></span></td>
									<td><span id="user_name">${loger.topic.user.unick}</span></td>
									<td><span>${loger.topic.tcreatTime}</span></td>
									<td><span>${loger.topic.treplynum}</span></td>
									<td><span> <a href="Topic/deleteShareTopic?tid=${loger.topic.tid}">ȡ������</a></span></td>
									</c:when>
							</c:choose> 
								</tr>
						</c:forEach>
				</table>
			</div>
			
			<div id="home_pro_area">
				<div class="home_pro_title">
					<h2>
						�ҷ������Ʒ
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="433">
							 ��Ʒ��
						</td>
						<td width="129">
							�ϴ���
						</td>
						<td width="121">
							�ϴ�ʱ��
						</td>
						<td width="57">
							������
						</td>
						<td width="91">
							����
						</td>
					</tr>
					<c:forEach items="${myShareList}" var="loger">
							<tr>
							
							<c:choose>
									<c:when test="${loger.ltype==10}">
			
									<td><span id="pro_name"><a href="Works/showworksdetail?wid=${loger.works.wid}"> ${loger.works.wname}</a></span></td>
									<td><span id="user_name">${loger.works.user.unick}</span></td>
									<td><span>${loger.works.wtime}</span></td>
									<td><span>${loger.topic.wloadNum}</span></td>
									<td><span> <a href="Topic/deleteShareWorks?wid=${loger.works.wid }">ȡ������</a></span></td>
									</c:when>
							</c:choose> 
								</tr>
						</c:forEach>
				</table>
			</div>
		</div><!-- main -->
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
