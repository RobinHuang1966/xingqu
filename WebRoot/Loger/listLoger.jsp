<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>My JSP 'topiclist.jsp' starting page</title>
	</head>
	<body>	
		<h2>显示个人动态</h2>
		<table border="1px" >
		<tr align="center">
		<td>用  户  名</td>
		<td>操作类型</td>
		<td>具体对象</td>
		<td>时间</td>
		<td>操作</td>


		  <c:forEach items="${logerList}" var="loger">
			<tr>
				<td> ${loger.user.uid}</td>	
			<td>
				<c:choose>
					<c:when test="${loger.ltype==0}">${loger.ltype}</c:when>
					<c:when test="${loger.ltype==1}">回复话题</c:when>
					<c:when test="${loger.ltype==2}">分享话题</c:when>
					<c:when test="${loger.ltype==3}">关注话题</c:when>
					<c:when test="${loger.ltype==4}">取消关注话题</c:when>
					<c:when test="${loger.ltype==5}">新建话题</c:when>
					<c:when test="${loger.ltype==6}">修改话题</c:when>
					<c:when test="${loger.ltype==7}">上传作品</c:when>
					<c:when test="${loger.ltype==8}">下载作品</c:when>
					<c:when test="${loger.ltype==9}">收藏作品</c:when>
					<c:when test="${loger.ltype==10}">分享作品</c:when>			
					<c:when test="${loger.ltype==11}">赞作品</c:when>
					<c:when test="${loger.ltype==12}">踩作品</c:when>
					<c:when test="${loger.ltype==13}">关注好友</c:when>
					<c:when test="${loger.ltype==14}">取消关注好友</c:when>
					<c:when test="${loger.ltype==15}">留言</c:when>
					<c:when test="${loger.ltype==16}">访问空间</c:when>
					<c:when test="${loger.ltype==17}">加入小组</c:when>
					<c:when test="${loger.ltype==18}">退出小组</c:when>
					<c:otherwise>其他操作</c:otherwise>
				</c:choose>
			</td>
				<td>${loger.topic.ttitle}${loger.works.wname}${loger.group.gtitle}${loger.puid}</td>
				<td>${loger.ltime}</td>
				<td>
					<a href='deleteLoger?lid=${loger.lid}'>删除</a>
				</td>
			</tr>
		</c:forEach> 
		</table>
		
	 	<table border="0">
		<tr ><td width="900px" >个人动态</td></tr>
		<c:forEach items="${logerList}" var="loger">
			
			<tr> <td><a href="#">
				<c:choose>
					<c:when test="${loger.ltype==1}">
						${loger.loger.user.unick}在${loger.ltime}，回复了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==2}">
						${loger.user.unick}在${loger.ltime}，分享了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==3}">
						${loger.user.unick}在${loger.ltime}，关注了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==4}">
						${loger.user.unick}在${loger.ltime}，取消关注了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==5}">
						${loger.user.unick}在${loger.ltime}，新建了话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==6}">
						${loger.user.unick}在${loger.ltime}，修改了话题：${loger.topic.ttitle}；</c:when>
					<c:when test="${loger.ltype==7}">
						${loger.user.unick}在${loger.ltime}，上传了作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==8}">
						${loger.user.unick}在${loger.ltime}，下载了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==9}">
						${loger.user.unick}在${loger.ltime}，收藏了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==10}">
						${loger.user.unick}在${loger.ltime}，分享了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==11}">
						${loger.user.unick}在${loger.ltime}，赞了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==12}">
						${loger.user.unick}在${loger.ltime}，踩了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
					<c:when test="${loger.ltype==13}">
						${loger.user.unick}在${loger.ltime}，关注了好友：${loger.puid}；</c:when>
					<c:when test="${loger.ltype==14}">
						${loger.user.unick}在${loger.ltime}，取消关注好友：${loger.puid}；</c:when>
					<c:when test="${loger.ltype==15}">
						${loger.user.unick}在${loger.ltime}，给${loger.puid}留言了；</c:when>
					<c:when test="${loger.ltype==16}">
						${loger.user.unick}在${loger.ltime}，访问了${loger.puid}的空间；</c:when>
					<c:when test="${loger.ltype==17}">
						${loger.user.unick}在${loger.ltime}，加入了${loger.group.user.unick }创建的小组：${loger.group.gtitle}；</c:when>
					<c:when test="${loger.ltype==18}">
						${loger.user.unick}在${loger.ltime}，退出了${loger.group.user.unick }创建的小组：${loger.group.gtitle}；</c:when>
					<c:otherwise>
						${loger.user.unick}在${loger.ltime}，在青羊教育兴趣小组做了其他操作;</c:otherwise>
				</c:choose>
			</a></td></tr>
		</c:forEach>
		</table>  
		<p> <a href='../index.jsp'>首页</a>  </p>
		<s:debug></s:debug>
	</body>
</html>
