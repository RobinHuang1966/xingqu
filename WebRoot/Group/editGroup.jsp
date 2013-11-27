<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'MyJsp.jsp' starting page</title>
	</head>
	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<div id="main">
			<div class="position">
				<a href="index.html"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="group.html">小组</a>&nbsp;>&nbsp;
				<a href="apply.html">申请创建小组</a>
			</div>
			<form action="Group/addGroup" method="post" id="apply2">
				<div id="apply_title">
					申请创建小组
				</div>
				
				&nbsp;&nbsp;小组名称：
				<input type="text" name="gtitle" size="30"/>
				<br />
				请选择主题：
				<s:select list="themeNames" style="width:180px; height:30px; margin-bottom:10px;"
					name="thName">
				</s:select><br/>
				
				&nbsp;&nbsp;小组描述：
				<textarea cols="28" rows="5" name="gbrief"></textarea>
				<br />

				<input type="submit" value="提交申请"
					style="background: #9cf; height: 30px; margin-top: 10px" />
			</form>
		</div>
		<s:debug></s:debug>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
