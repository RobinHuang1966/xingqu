<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>My JSP 'testLogin.jsp' starting page</title>

	</head>
	<body>
		<s:form action="" method="get">
			<table>
				<tr>
					<td align="right" width="40%">
						登录名：
					</td>
					<td style="text-indent: 5">
						<s:textfield name="unick" size="20" />
					</td>
				</tr>
				<tr>
					<td align="right">
						密&nbsp;&nbsp;码：
					</td>
					<td>
						<s:password name="upassword" size="20" />
						<br>
					</td>
				</tr>
				<tr>
					<td align="right">
						类&nbsp;&nbsp;型：
					</td>
					<td style="text-indent: 5">
						<s:select name="utype" label=""
							list="#{'0':'学生','1':'教务处','2':'管理员'}" listKey="key"
							listValue="value" headerKey="0" headerValue="请选择类型">
						</s:select>
					</td>
				</tr>
				<s:submit value="登录" />
				<s:reset value="重置" />
			</table>

			<s:select label="Type" name="usex" list="#{'0':'男生','1':'女生'}" listKey="key" 	listValue="value"  
				headerKey="-1" headerValue="Select Sex" required="true">
			</s:select>
			<br />

			<s:select label="Months" name="uname"
				list="#{'01':'Jan', '02':'Feb'}" headerKey="-1"
				headerValue="Select Month" value="selectedMonth" required="true">
			</s:select>
		</s:form>



	</body>
</html>
