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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/css1.css" type="text/css" />
	</head>
	<body>
		<div id="home_header">
			<div id="home_name">
				<a href="#"> <s:if test="#request.friend.unick!=null">
						<s:property value="#request.friend.unick" />
					</s:if> <s:else>
						<s:property value="#session.user.unick" />
					</s:else>�ļ�԰</a>
			</div>
			<ul id="home_nav">
				<li>
					<a href="User/showmyhome">��԰��ҳ</a>
				</li>
				<li>
					<a href="User/persondynamic">��̬</a>
				</li>
				<li>
					<a href="User/showmyshare">����</a>
				</li>
				<li>
					<a href="User/showmygroup">С��</a>
				</li>
				<li>
					<a href="User/showmytopic">����</a>
				</li>
				<li>
					<a href="User/showmyfriend">����</a>
				</li>
				<li>
					<a href="User/listmymessage">���԰�</a>
				</li>
				<li>
					<a href="User/showmyworks">������Ʒ��</a>
				</li>
				<li>
					<a href="Space/home_userinfo.jsp">��������</a>
				</li>
				<li>
					<a href="index">��ҳ</a>
				</li>
			</ul>
		</div>
	</body>
</html>
