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
						�ҵĺ���
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<!-- <td width="433">
							ID
						</td> -->
						<td width="80">
							�ǳ�
						</td>
						<td width="80">
							����
						</td>
						<td width="80">
							�Ա�
						</td>
						<td width="120">
							��Ȥ
						</td>
						<td width="100">
							�꼶
						</td>
						<td width="300">
							ѧУ
						</td>
						<td width="51">
							����
						</td>
					</tr>
					<s:iterator value="friendsForFuid" var="friend">
						<tr>
							<!-- <td>
								<span id="pro_name"><a href="production_detail.html"><s:property value="#friend.userByFuid.uid"/></a>
								</span>
							</td> -->
							<td>
								<span id="user_name"><s:property
										value="#friend.userByFuid.unick" /> </span>
							</td>
							<td>
								<span id="topic_time"><s:property
										value="#friend.userByFuid.uname" />
								</span>
							</td>
							<td>
								<span ><s:property
										value="#friend.userByFuid.usex" /> </span>
							</td>
							<td>
								<span ><s:property
										value="#friend.userByFuid.uinterest" /> </span>
							</td>
							<td>
								<span><s:property value="#friend.userByFuid.ugrade" />
								</span>
							</td>
							<td>
								<span><s:property value="#friend.userByFuid.uschool" />
								</span>
							</td>
							<td>
								<a
									href="User/deletefriend?fid=<s:property value="#friend.fid"/>">ȡ����ע</a>
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
	</body>
</html>
