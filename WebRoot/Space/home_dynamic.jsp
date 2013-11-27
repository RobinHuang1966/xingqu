<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>My JSP 'topiclist.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="../css/all.css">
	<link rel="stylesheet" href="css/css1.css" type="text/css" />
	</head>
	<body >	
	
<jsp:include page="head.jsp"></jsp:include>
					<div id="home_trend" style="margin-left:40px">
					<div  class="home_title" style="width: 990px;">
						<h2>
							<a href="User/persondynamic">我的动态</a>
						</h2>
					</div>
					<ul style="margin-left:60px;width: 800px;">
						<c:forEach items="${myDynamicList}" var="loger">
							<li>
								<a href="#"> <c:choose>
										<c:when test="${loger.ltype==1}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，回复了${loger.topic.user.unick}的话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==2}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，分享了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==3}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，关注了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==4}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，取消关注了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==5}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，新建了话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==6}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，修改了话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==7}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，上传了作品：${loger.works.wname}；</c:when>
										<c:when test="${loger.ltype==8}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，下载了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
										<c:when test="${loger.ltype==9}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，退出了${loger.group.user.unick }的小组：${loger.group.gtitle}；</c:when>
										<c:when test="${loger.ltype==10}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，分享了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
										<c:when test="${loger.ltype==11}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，赞了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
										<c:when test="${loger.ltype==12}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，踩了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
										<c:when test="${loger.ltype==13}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，关注了好友：${loger.puser.unick}；</c:when>
										<c:when test="${loger.ltype==14}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，取消关注好友：${loger.puser.unick}；</c:when>
										<c:when test="${loger.ltype==15}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，给${loger.puser.unick}留言了:${loger.lcontent}；</c:when>
										<c:when test="${loger.ltype==16}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，访问了${loger.puser.unick}的空间；</c:when>
										<c:when test="${loger.ltype==17}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，加入了${loger.group.user.unick }创建的小组：${loger.group.gtitle}；</c:when>
										<c:when test="${loger.ltype==18}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，创建了小组：${loger.group.gtitle}；</c:when>
										<c:otherwise>
										${${loger.user.unick}}在${fn:substring(loger.ltime,2,16)}，在青羊教育兴趣小组做了其他操作;</c:otherwise>
									</c:choose> </a>
							</li>
						</c:forEach>

					</ul>
				</div>
				<!--main-->
				<s:debug></s:debug>
				<jsp:include page="../footer.jsp"></jsp:include>
			</body>
</html>
