<%@ page language="java" import="java.util.*;import com.hwadee.xingqu.model.User; import com.hwadee.xingqu.dao.UserDAO;
								 import com.hwadee.xingqu.model.Loger; " 
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>家园</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="css/all.css">
		<link rel="stylesheet" href="css/css1.css" type="text/css" />

	</head>
	<body>&nbsp; 
		<jsp:include page="head.jsp"></jsp:include>
		<div id="main">
			<div id="home_left">
				<div id="home_image">
					<div class="home_title">
						<h2>
							头像
						</h2>
					</div>
					<div id="user_images">
						<span id="user_image"><img src="images/i7.png" /> </span><span
							id="user_name"><a href="#"><s:property
									value="user.unick" /> </a> </span>
					</div>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						collapse="collapse">
						<tr>

							<td>
								<a href="#">更新资料</a>
							</td>

							<td>
								<a href="Space/home_update_userinfo.jsp">更换头像</a>
							</td>

						</tr>
					</table>

				</div>
				<!--home_imade-->
				<div id="home_pro">
					<div class="home_title">
						<h2>
							<a href="User/showmyworks">我的作品</a>
						</h2>
						<span><a href="User/showmyworks"><img src="images/more.png" /> </a> </span>
					</div>
					<ul>
						<s:iterator value="workses" var="works">
							<li id="pro1">
								<img src="images/bullet_yellow_alt.png" />
								<a href="#"><s:property value="#works.wname" /> </a><span>下载量：<s:property
										value="#works.wloadNum" /> </span>
							</li>
						</s:iterator>
					</ul>
					<jsp:include page="../Works/upload.jsp"></jsp:include>
				</div>
				<!--home_pro-->
				<div id="home_topic">
					<div class="home_title">
						<h2>
							<a href="User/showmytopic"> 我的话题</a>
						</h2>
						<span><a href="User/showmytopic"><img src="images/more.png" /> </a> </span>
					</div>
					<ul>
						<s:iterator value="topics" var="topic">
							<li id="pro1">
								<img src="images/bullet_yellow_alt.png" />
								<a href="Topic/showtopic?tid=<s:property value="#topic.tid" />"><s:property
										value="#topic.ttitle" /> </a>		
								<span style="position:relative; right:1px;"><s:property
										value="#topic.tcreatTime.toString().substring(2,16)" /> </span>
							</li>
						</s:iterator>
					</ul>

				</div>
				<!--home_pro-->
			</div>
			<!--home_left-->
			<div id="home_mid">

				<!--detail-->
				<div id="home_trend">
					<div class="home_title">
						<h2>
							<a href="User/persondynamic">动态</a>
						</h2>
						<span><a href="User/persondynamic"><img src="images/more.png" /> </a> </span>
					</div>
					<ul>
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
				<!--home_trend-->



				<div id="home_share">
					<div class="home_title">
						<h2>
							<a href="User/showmyshare">分享</a>
						</h2>
						<span><a href="User/showmyshare"><img src="images/more.png" /> </a> </span>
					</div>
					<ul>
						<c:forEach items="${myShareList}" var="loger">
							<li>
								<a href="#"> <c:choose>
										<c:when test="${loger.ltype==2}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，分享了${loger.topic.user.unick }的话题：${loger.topic.ttitle}；</c:when>
										<c:when test="${loger.ltype==10}">
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，分享了${loger.works.user.unick }的作品：${loger.works.wname}；</c:when>
										<c:otherwise>
										${loger.user.unick}在${fn:substring(loger.ltime,2,16)}，在青羊教育兴趣小组做了其他操作;</c:otherwise>
									</c:choose> </a>
							</li>
						</c:forEach>

					</ul>
				</div>



				<!--home_share-->
				<div id="home_message">
					<div class="home_title">
						<h2>
							<a href="User/listmymessage">留言板</a>
						</h2>
						<span><a href="User/listmymessage"><img src="images/more.png" /> </a> </span>
					</div>
					<s:form action="User/leavemessage">
						<textarea cols="70" rows="7" name="lcontent"></textarea>
						<input type="submit" value="留言" id="leave_word" />
					</s:form>
					<ul>
						<s:iterator value="myMessageList" var="loger">
						<li>
							<div id="user_images">
								<span id="user_image"><img src="images/i8.png" /> </span>
								<br />
								<span id="user_name"><a href="#"><s:property
											value="#loger.user.unick" /> </a> </span>
							</div>
							<p>
								<s:property value="#loger.lcontent" />
							</p>
							<span>
								<s:property value="#loger.ltime.toString().substring(2,16)"  />
							</span>
						</li>
						</s:iterator>
					</ul>
				</div>
				<!--home_message-->
			</div>
			<!--home_mid-->

			<div id="home_right">
				<ul id="home_friend">
					<div class="home_title">
						<h2>
							<a href="User/showmyfriend">我关注的好友</a>
						</h2>
						<span><a href="User/showmyfriend"><img src="images/more.png" /> </a> </span>
					</div>
					<s:iterator value="friendsForFuid" var="friend">
						<li id="user_images">
							<span id="user_image"><img src="images/i8.png" /> </span>
							<br />
							<span id="user_name"><a href="User/visitfriendspace?unick=<s:property value="#friend.userByUid.unick"/>">
								<s:property value="#friend.userByUid.unick" /> </a> </span>
						</li>
					</s:iterator>
					
				</ul>
				<!--home_friend-->
				<ul id="home_group">

					<div class="home_title">
						<h2>
							<a href="User/showmygroup">我创建的小组</a>
						</h2>
						<span><a href="User/showmygroup"><img src="images/more.png" /> </a> </span>
					</div>

					<s:iterator value="groups" var="group">
						<li id="group">
							<span><img src="images/i4.png" /> </span>
							<br />
							<span id="group_name"><a href="Group/showgroupdetail?gid=<s:property value="#group.gid" /> ">
							<s:property value="#group.gtitle" /> </a> </span>
						</li>
					</s:iterator>
				</ul>
				<!--home_group-->
				<ul id="home_group">

					<div class="home_title">
						<h2>
							<a href="User/showmygroup">我加入的小组</a>
						</h2>
						<span><a href="User/showmygroup"><img src="images/more.png" /> </a> </span>
					</div>
					<s:iterator value="joinGroupList" var="loger">
						<li id="group">
							<span><img src="images/i4.png" /> </span>
							<br />
							<span id="group_name"><a href="Group/showgroupdetail?gid=<s:property value="#loger.group.gid" /> " ><s:property
										value="#loger.group.gtitle" /> </a> </span>
						</li>
					</s:iterator>
				</ul>
				<!--home_group-->
				<div id="home_collect"></div>
				<!--home_collect-->
			</div>
			<!--home_right-->
			<div class="clear"
				style="padding: 0; border: 0; margin: 0; clear: both;"></div>
		</div>
		<!--main-->
		<s:debug></s:debug>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
