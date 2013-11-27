<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<link rel="stylesheet" type="text/css" href="css/all.css" />
		<style type="text/css">
a.abtn {
	display: block;
	height: 120px;
	width: 15px;
	overflow: hidden;
	background: url(images/arrow3.png) no-repeat 0px 50%;
}

a.aleft {
	float: left;
}

a.agrayleft {
	cursor: default;
	background-position: -34px 50%;
}

a.aright {
	float: right;
	background-position: -17px 50%;
}

a.agrayright {
	cursor: default;
	background-position: -51px 50%;
}
</style>
		<title>青羊教育平台兴趣小组</title>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="main">
			<div class="position">
				<a href="forward.jsp"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<span id="totalUser">用户总数：<s:property value="unum" /> </span>&nbsp;&nbsp;&nbsp;&nbsp;

			</div>
			<!--position-->
			<div id="container">


				<s:iterator value="themelist" var="theme">
					<div class="theme">
						<h2 class="scrolltitle">
							<s:property value="#theme.thName" />
						</h2>

						<div class="theme_detail">
							<div class="scrolllist" id="s1">
								<h2>
									小组
								</h2>
								<a class="abtn aleft" href="#left" title="左移"></a>
								<div class="imglist_w">
									<ul class="imglist">
										<s:iterator value="#theme.groups" var="group">
											<s:if test="#group.gisVerify==1">
												<li>
													<a
														href="Group/showgroupdetail?gid=<s:property value="#group.gid"/>"><img
															src="images/i4.png" /> </a>
													<p>
														<a target="_blank" href=""> </a>
														<s:property value="#group.gtitle" />
													</p>
												</li>
											</s:if>
										</s:iterator>


									</ul>
									<!--imglist end-->
								</div>
								<a class="abtn aright" href="#right" title="右移"></a>
							</div>
							<!--scrolllist end-->

							<!--topic_list-->
						</div>
						<!--theme_detail-->
					</div>
				</s:iterator>
				<!--theme-->
				<script type="text/javascript" src="js/jquery-1.4.2.min.js">
	
</script>
				<script type="text/javascript" src="js/indexSider.js">
	
</script>
				<script type="text/javascript">
	$(function() {
		//默认状态下左右滚动
		$(".scrolllist").xslider( {
			unitdisplayed : 5,
			movelength : 1,
			unitlen : 129,
			autoscroll : 8000
		});

	})
</script>
			</div>
			<!--contanier-->
			<div id="sider_right">
				<ul id="hot_list">
					<li id="hot_pro">
						<div class="hot_name">
							<h4>
								热门作品
							</h4>
							<span><a href="Works/workslist"><img src="images/more.png" /></a> </span>
						</div>
						<table width="260px" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="b_s" id="pro_name" width="40%" id="pro_n" style="width:110px; margin-right:10px;height:25px; overflow:hidden; line-height:25px;">
									作品名
								</td>
								<td class="b_s" id="user_name" width="30%">
									作者
								</td>
								<td class="b_s" id="suject" width="20%">
									下载次数
								</td>
								<td class="b_s" id="suject" width="10%">
									操作
								</td>
							</tr>

							<s:iterator value="workslist" var="works">
								<tr>
									<td class="b_s">
										<div id="pro_name">
											<a
												href="Works/showworksdetail?wid=<s:property value="#works.wid"/>"><s:property
													value="#works.wname" /> </a>
										</div>
									</td>
									<td class="b_s">
										<span id="user_name"><a
											href="User/visitfriendspace?unick=<s:property
													value="#works.user.unick" />"><s:property
													value="#works.user.unick" /> </a> </span>
									</td>
									<td class="b_s">
										<span id="suject"><s:property value="#works.wloadNum" />
										</span>
									</td>
									<td class="b_s">
										<span id="suject"><a
											href="Works/downloadworks?wid=<s:property value="#works.wid"/>"><img
													src="images/down.png" /> </a> </span>
									</td>

								</tr>
							</s:iterator>
						</table>

					</li>
					<!--hot_pro-->
					<li id="hot_topic">
						<div class="hot_name">
							<h4>
								热门话题
							</h4>
							<span><a href="Group/showgroup"><img src="images/more.png" /></a> </span>
						</div>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="52%" class="b_s">
									<span id="topic_name">话题名</span>
								</td>
								<td width="18%" class="b_s">
									<span id="user_name">作者</span>
								</td>
								<td width="30%" class="b_s">
									<span id="group_name">小组</span>
								</td>
							</tr>
							<s:iterator value="topiclist" var="topic">
								<tr>
									<td class="b_s">
										<div id="topic_name">
											<a
												href="Topic/showtopic?tid=<s:property value="#topic.tid" />"><s:property
													value="#topic.ttitle" /> </a>
										</div>
									</td>
									<td class="b_s">
										<span id="user_name"> <a
											href="User/visitfriendspace?unick=<s:property value="#topic.user.unick"/>"><s:property
													value="#topic.user.unick" /> </a> </span>
									</td>
									<td class="b_s">
										<span id="group_name"><a
											href='Group/showgroupdetail?gid=<s:property value="#topic.group.gid" />'><s:property
													value="#topic.group.gtitle" /> </a> </span>
									</td>
								</tr>
							</s:iterator>
						</table>

					</li>
					<!--hot_topic-->
					<li id="hot_group">
						<div class="hot_name">
							<h4>
								人气小组
							</h4>

							<span><a href="Group/showgroup"><img src="images/more.png" /></a> </span>
						</div>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="b_s">
									<span id="group_name">小组名</span>
								</td>
								<td class="b_s">
									<span id="user_name">组长</span>
								</td>
								<td class="b_s">
									<span id="member_num">人数</span>
								</td>
							</tr>

							<s:iterator value="grouplist" var="group">
								<tr>
									<td class="b_s">
										<span id="group_name"><a
											href='Group/showgroupdetail?gid=<s:property value="#group.gid" />'><s:property
													value="#group.gtitle" /> </a> </span>
									</td>
									<td class="b_s">
										<span id="user_name"><a
											href="User/visitfriendspace?unick=<s:property
													value="#group.user.unick" />"><s:property
													value="#group.user.unick" /> </a> </span>
									</td>
									<td class="b_s">
										<span id="member_num"><s:property value="#group.unum" />
										</span>
									</td>
								</tr>
							</s:iterator>
						</table>
					</li>


					<li id="hot_group">
						<div class="hot_name">
							<h4>
								活跃用户
							</h4>
							<span><a href="Group/showgroup"><img src="images/more.png" /></a> </span>
						</div>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td class="b_s">
									<span id="user_name">用户名</span>
								</td>
								<td class="b_s">
									<span id="pro_num">最后登录时间</span>
								</td>
								<td class="b_s">
									<span id="add_friend">加好友</span>
								</td>
							</tr>

							<s:iterator value="userlist" var="user">
								<tr>
									<td class="b_s">
										<span id="user_name"> <a
											href="User/visitfriendspace?unick=<s:property value="#user.unick" />"><s:property
													value="#user.unick" /> </a> </span>
									</td>
									<td class="b_s">
										<span id="pro_num"><s:property
												value="#user.ulastLoginTime.toString().substring(0,19)" />
										</span>
									</td>
									<td class="b_s">
										<span id="add_friend"><a
											href="User/addfriend?fuid=<s:property value="#user.uid"/>">
												<img src="images/plus.png" /> </a> </span>
									</td>
								</tr>

							</s:iterator>
						</table>
					</li>

					<!--hot_group-->
				</ul>
				<!--hot_list-->
			</div>
			<!--sider-->
			<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<!--main-->
		<jsp:include page="footer.jsp"></jsp:include>

	</body>
</html>
