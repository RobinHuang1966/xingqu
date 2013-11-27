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
						�Ҽ����С��
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<!-- <td width="433">
							С��ID
						</td> -->
						<td width="129">
							С������
						</td>
						<td width="50">
							�鳤
						</td>
						<td width="70">
							��������
						</td>
						<td width="300">
							С����
						</td>
						<td width="90">
							������
						</td>
						<td width="90">
							С������
						</td>
						<td width="51">
							����
						</td>
					</tr>
					<s:iterator value="joinGroupList" var="loger">
						<tr>
							
							<td>
								<span id="user_name"><s:property value="#loger.group.gtitle"/>
								</span>
							</td>
							<td>
								<span id="user_name"><s:property value="#loger.group.user.unick"/>
								</span>
							</td>
							<td>
								<span ><s:property value="#loger.group.theme.thName"/>
								</span>
							</td>
							<td>
								<span ><s:property value="#loger.group.gbrief"/>
								</span>
							</td>
							<td>
								<span id="topic_time"><s:property value="#loger.group.tnum"/></span>
							</td>
							<td>
								<span id="pro_comment_good"><s:property value="#loger.group.unum"/></span>
							</td>
							<td>
								<span id="pro_comment_ban"><a href="User/exitgroup?gid=<s:property value="#loger.group.gid"/>">�˳�С��</a></span>
							</td>
						</tr>
					</s:iterator>
				</table>
				
				<div class="home_pro_title">
					<h2>
						�Ҵ�����С��
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="129">
							С������
						</td>
						<td width="100">
							��������
						</td>
						<td width="340">
							С����
						</td>
						<td width="90">
							������
						</td>
						<td width="90">
							С������
						</td>
						<td width="51">
							����
						</td>
					</tr>
					<s:iterator value="groups" var="group">
						<tr>
							<td>
								<span id="pro_name"><a href="production_detail.html"><s:property value="#group.gtitle"/></a>
								</span>
							</td>
							<td>
								<span ><s:property value="#group.theme.thName"/>
								</span>
							</td>
							<td>
								<span id="user_name"><s:property value="#group.gbrief"/>
								</span>
							</td>
							<td>
								<span id="topic_time"><s:property value="#group.tnum"/></span>
							</td>
							<td>
								<span id="pro_comment_good"><s:property value="#group.unum"/></span>
							</td>
							<td>
								<span id="pro_comment_ban"><a href="#">��ɢС�� </a></span>
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
