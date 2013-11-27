<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<script src="../SpryAssets_group/SpryTabbedPanels.js"
			type="text/javascript">
	
</script>
		<link href="../SpryAssets_group/SpryTabbedPanels.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<title>My JSP 'topiclist.jsp' starting page</title>
	</head>
	<body>
		<div id="header">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>
<!--  
		<table border="1px">
			<tr align="center">
				<td>
					序号
				</td>
				<td>
					小组名
				</td>
				<td>
					用户名
				</td>
				<td>
					所属主题
				</td>
				<td>
					话题数量
				</td>
				<td>
					组员数量
				</td>
				<td>
					创建时间
				</td>
				<td>
					操作
				</td>


				<s:iterator value="grouplist" var="g">
					<tr>
						<td>

							<s:property value="#g.gid" />
						</td>
						<td>
							<s:property value="#g.gtitle" />

						</td>
						<td>
							<s:property value="#g.user.unick" />

						</td>

						<td>
							<s:property value="#g.theme.thName" />

						</td>
						<td>
							<s:property value="#g.tnum" />

						</td>
						<td>
							<br>
						</td>
						<td>
							<s:property value="#g.gcreateTime" />
							<br>
						</td>
						<td>
							<a href='Group/deletegroup?gid=<s:property value="#g.gid" />'>删除</a>
							<a href='Group/joingroup?gid=<s:property value="#g.gid" />'>加入小组</a>
						</td>
					</tr>
				</s:iterator>
		</table>
-->
	
		<div id="main">
			<div class="position">
				<a href="index"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="Group/showgroup">小组</a>
			</div>
			<div id="container">
				<div id="TabbedPanels1" class="TabbedPanels">
					<ul class="TabbedPanelsTabGroup">
						<li class="TabbedPanelsTab" tabindex="0">
							发现小组
						</li>
						<li class="TabbedPanelsTab" tabindex="0">
							发现话题
						</li>
						<li class="TabbedPanelsTab" tabindex="0">
							发现好友
						</li>
					</ul>
					<div class="TabbedPanelsContentGroup">
						<div class="TabbedPanelsContent">
							<ul id="group_list">
								<s:iterator value="grouplist" var="g">
									<li id="group1">
										<span id="group_image"><img src="images/i1.png" /> </span>
										<span class="group_id">序号</span>
										<span id="group_name"><a
											href="Group/showgroupdetail?gid=<s:property value="#g.gid"/>"><s:property
													value="#g.gtitle" /> </a> </span>
										<br />
										<span id="user_name">组长：<a
											href="User/visitfriendspace?unick=<s:property
													value="#g.user.unick" />"><s:property
													value="#g.user.unick" /> </a> </span>
										<br />
										<span id="member_num">成员数：<s:property value="#g.unum" />
										</span>
										<span id="topic_num">话题数：<s:property value="#g.tnum" />
										</span>
										<br />
										<span id="subject_name">所属主题：<a href=""></><s:property
													value="#g.theme.thName" /> </a> </span>
										<br />
										<span id="group_time">创建时间：<s:property
												value="#g.gcreateTime.toString().substring(0,16)" /> </span>
										<br />
										<span><input type="image" src="images/add_user.png" /><a
											href='Group/joingroup?gid=<s:property value="#g.gid" />'>加入小组</a>
										</span>
										<br />
									</li>
									<!--group1-->

								</s:iterator>
							</ul>
							<div class="page">
								<ul>

									<li>
										当前第
										<s:property value="grouppage" />
										页,共
										<s:property value="grouptotal" />
										条记录, 共分
										<s:property value="grouptotalPage" />
										页
									</li>
									<li>
										<a href="Group/showgroup?grouppage=<s:property value="1"/> ">第一页</a>

									</li>
									<li>
										<s:if test="page<=1">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?grouppage=<s:property value="grouppage-1"/> ">上一页</a>
										</s:else>
									</li>
									<li>

										<s:form action="Group/showgroup">
											<s:submit value="跳转到" style="border:none;">
												<input type="text" name="grouppage" size="1">页</s:submit>
										</s:form>
									</li>
									<li>
										<s:if test="grouppage>=grouptotalPage">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?grouppage=<s:property value="grouppage+1"/> ">下一页</a>
										</s:else>
									</li>
									<li>
										<a
											href="Group/showgroup?grouppage=<s:property value="totalPage"/> ">最后一页</a>
									</li>
								</ul>
							</div>
							<!-- page -->
						</div>

						<!--发现小组-->
						<div class="TabbedPanelsContent">

							<ul id="topic_list">
								<s:iterator value="topiclist" var="topic">
									<li>
										<h3 class="topic_title">
											<a
												href="Topic/showtopic?tid=<s:property value="#topic.tid" />"><s:property
													value="#topic.ttitle" /> </a>	
											<span class="right" id="createTime"><s:property
												value="#topic.tcreatTime.toString().substring(0,16)" /> </span>
										</h3>
										
								
										<p class="topic_short">
											<s:property value="#topic.tcontent" />
										</p>
										<span class="group_name">来自：&nbsp;<a
											href="group_detail.html"><s:property
													value="#topic.group.gtitle" /> </a> </span>&nbsp;小组
										<span class="right"><span class="topic_share"><s:property
													value="#topic.shareNum" /> </span> <span class="topic_like"><s:property
													value="#topic.attentionNum" /> </span>
										回复数：
										<span class="topic_back"><s:property
												value="#topic.treplynum" /> </span>
										</span>
									</li>
								</s:iterator>

							</ul>
							<s:debug></s:debug>
							<!--topic_list-->
							<div class="page">
								<ul>
									<li>
										当前第
										<s:property value="topicpage" />
										页,共
										<s:property value="topictotal" />
										条记录, 共分
										<s:property value="topictotalPage" />
										页
									</li>
									<li>
										<a href="Group/showgroup?topicpage=<s:property value="1"/> ">第一页</a>

									</li>
									<li>
										<s:if test="topicpage<=1">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?topicpage=<s:property value="topicpage-1"/> ">上一页</a>
										</s:else>
									</li>
									<li>

										<s:form action="Group/showgroup">
											<s:submit value="跳转到" style="border:none;">
												<input type="text" name="topicpage" size="1">页</s:submit>
										</s:form>
									</li>
									<li>
										<s:if test="topicpage>=topictotalPage">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?topicpage=<s:property value="topicpage+1"/> ">下一页</a>
										</s:else>
									</li>
									<li>
										<a
											href="Group/showgroup?userpage=<s:property value="totalPage"/> ">最后一页</a>
									</li>
								</ul>
							</div>
						</div>
						<!--发现话题-->
						<div class="TabbedPanelsContent">
							<ul id="friend_list">
								<s:iterator value="userlist" var="g">
									<li>
										<span class="user_image"><a href="home.html"><img
													src="images/i7.png" /> </a> </span>
										<span class="user_name"><a href="home.html"><s:property
													value="#g.unick" /> </a> </span>
										<br />
										<span class="user_interest">兴趣：<a
											href="group_detail.html"><s:property value="#g.uinterest" />
										</a> </span>
										<br />
										<span class="user_type">类型： <s:if test="#g.utype==0">
										老师

											</s:if> <s:elseif test="#g.utype==1">学生
											</s:elseif> <s:elseif test="#g.utype==2">
											家长
											</s:elseif> <s:elseif test="#g.utype==3">
											管理员
											</s:elseif> </span>
										<br />
										<span class="user_add"> <a
											href="User/addfriend?fuid=<s:property value="#g.uid"/>">
												<input type="image" src="images/plus.png" />关注好友 </a> </span>
									</li>
								</s:iterator>
							</ul>
							<!--friend_list-->
							<div class="page">
								<ul>

									<li>
										当前第
										<s:property value="userpage" />
										页,共
										<s:property value="usertotal" />
										条记录, 共分
										<s:property value="usertotalPage" />
										页
									</li>
									<li>
										<a href="Group/showgroup?userpage=<s:property value="1"/> ">第一页</a>

									</li>
									<li>
										<s:if test="page<=1">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?userpage=<s:property value="userpage-1"/> ">上一页</a>
										</s:else>
									</li>
									<li>

										<s:form action="Group/showgroup">
											<s:submit value="跳转到" style="border:none;">
												<input type="text" name="userpage" size="1">页</s:submit>
										</s:form>
									</li>
									<li>
										<s:if test="grouppage>=grouptotalPage">
										</s:if>
										<s:else>
											<a
												href="Group/showgroup?userpage=<s:property value="userpage+1"/> ">下一页</a>
										</s:else>
									</li>
									<li>
										<a
											href="Group/showgroup?userpage=<s:property value="totalPage"/> ">最后一页</a>
									</li>
								</ul>
							</div>
						</div>
						<!--发现好友-->
					</div>
				</div>
			</div>
			<!--container-->
			<div id="sider">
				<div id="apply">
					<a href="Group/editgroup"><h2>
							申请创建小组
						</h2> </a>
				</div>
				<div id="apply">
					<a href="Topic/findTopicsimple?&tid=<s:property value="0"/>" ><h2>
							申请创建话题
						</h2> </a>
				</div>

			</div>
			<!--sider-->
			<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<!--main-->
		<script type="text/javascript">
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
</script>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
