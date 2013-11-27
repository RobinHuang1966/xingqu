<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<title>My JSP 'addtopic.jsp' starting page</title>

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
		<jsp:include page="../header.jsp"></jsp:include>
		<div id="main">
			<div class="position">
				<a href="index"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="Group/showgroup">话题</a>&nbsp;>&nbsp;
				<a href="#">编辑话题</a>
			</div>
			
			<s:form action="Topic/updatetopic" id="new_topic">
				
				<s:if test="%{tid} == 0 ">
					<s:textfield label="话题编号" name="tid"  value="%{tid}" readonly="false" id="topic_name" size="50" ></s:textfield>
					<br />
					<s:textfield label="话题名称" name="ttitle" id="topic_name" size="50"></s:textfield>
					<br />
					<s:select  label="所属小组" style="width:290px;" id="topic_name" name="gtitle" list="groupNames" 
						  headerKey="0" headerValue="请选择">
					</s:select>
					<br />
					<span id="user_info"><img src="images/i9.png" />
						<br />
						<a href="User/showmyhome"> <s:property value="%{#session.unick}" default="Huang"/></a>
					</span>
					<s:textarea label="话题简介" name="tcontent"   cols="50" rows="5"></s:textarea>
					<br />
				</s:if>
				<s:else>
					<s:textfield label="话题编号" name="tid"  value="%{tid}" readonly="false" id="topic_name" size="50" ></s:textfield>
					<br />
					<s:textfield label="话题名称" name="ttitle" value="%{ttitle}" id="topic_name" size="50"></s:textfield>
					<br />
					<s:select  label="所属小组" style="width:290px;" id="topic_name" name="gtitle" list="groupNames" 
						  headerKey="0" headerValue="%{gtitle}">
					</s:select>
					<br />
					<span id="user_info"><img src="images/i9.png" />
						<br />
						<a href="User/showmyhome"> <s:property value="%{#session.unick}" default="Huang"/></a>
					</span>
					<s:textarea label="话题简介" name="tcontent"  value="%{tcontent}" cols="50" rows="5" ></s:textarea>
					<br />
				</s:else>
				<s:submit value="提交" align="center"></s:submit>
				<s:reset value="重写" align="center"></s:reset>
			</s:form>
		</div>
		<!--main-->
		<s:debug></s:debug>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
