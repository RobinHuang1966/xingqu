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
		<title>�ޱ����ĵ�</title>
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
						�Ҵ����Ļ���
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="129">
							С������
						</td>
						<td width="100">
							����С��
						</td>
						<td width="300">
							������
						</td>
						<td width="130">
							����ʱ��
						</td>
						<td width="90">
							�ظ���
						</td>
						<td width="51">
							����
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
								ɾ������ </a></span>
							</td>
						</tr>
					</s:iterator>
				</table>
				
				<div class="home_pro_title">
					<h2>
						�ҹ�ע�Ļ���
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<!-- <td width="433">
							����ID
						</td> -->
						<td width="129">
							��������
						</td>
						<td width="90">
							����
						</td>
						<td width="70">
							����С��
						</td>
						<td width="240">
							������
						</td>
						<td width="130">
							����ʱ��
						</td>
						<td width="90">
							�ظ���
						</td>
						<td width="51">
							����
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
								<span id="pro_comment_ban"><a href="User/deleteAttentionTopic?tid=<s:property value="#loger.topic.tid"/>">ȡ����ע</a></span>
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
				��Ȩ���У�����ũ�ֿƼ���ѧ��Ϣ����ѧԺ����ʵϰ����С��
			</p>
			<p>
				<a href="#">�������</a>
			</p>
		</div>
		<s:debug></s:debug>
	</body>
</html>
