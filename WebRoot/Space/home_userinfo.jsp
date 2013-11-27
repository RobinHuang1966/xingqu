<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>无标题文档</title>
		<link rel="stylesheet" type="text/css" href="../css/all.css" />
		<link rel="stylesheet" href="css/css1.css" type="text/css" />

	</head>

	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<!--home_header-->
		<div id="main">
			<div id="user_info">
				<div class="user_info_title">
					<h2>
						我的信息
					</h2>
					<span><a href="Space/home_update_userinfo.jsp">修改</a> </span>
				</div>
				<div id="user_info_list">
					<table width="700px" border="1" cellspacing="0" cellpadding="0"
						collapse="collapse" bordercolor="#ccc">
						<tr>
							<td align="right">
								用户名:
							</td>
							<td>
								<span id="user_name"><a href="user_information.html" />
										<s:property value="#session.user.unick" /> </a> </span>
							</td>
						</tr>
						<tr>
							<td align="right">
								头像：
							</td>
							<td>
								<span id="user_image"><img src="images/i2.png" /> </span>
							</td>
						</tr>
						<tr>


							<td align="right">
								性别：
							</td>
							<td>
								<span id="user_sex"> <s:if test="#session.user.usex==0">男</s:if>
									<s:elseif test="#session.user.usex==1">女</s:elseif> </span>
							</td>
						</tr>


						<tr>
							<td align="right">
								生日：
							</td>
							<td>
								<span id="user_birth"><s:property
										value="#session.user.ubirthady.toString().substring(0,10)" />
								</span>
							</td>
						</tr>
						<tr>
							<td align="right">
								邮箱:
							</td>
							<td>
								<span id="user_mail"><s:property
										value="#session.user.uemail" /> </a> </span>
							</td>
						</tr>
						<tr>
							<td align="right">
								兴趣：
							</td>
							<td>
								<s:property value="#session.user.uinterest" />

							</td>
							<!--这里有空的话加一个省市选择的-->
						</tr>
						<tr>
							<td align="right">
								所在年级：
							</td>
							<td>
								<s:property value="#session.user.ugrade" />

							</td>
						</tr>
						<tr>
							<td align="right">
								所在学校：
							</td>
							<td>

								<s:property value="#session.user.uschool" />

							</td>

						</tr>
						<tr>
							<td align="right">
								注册时间：
							</td>
							<td>
								<span id="user_time"><s:property
										value="#session.user.uregTime.toString().substring(0,19)" />
								</span>
							</td>
						</tr>

					</table>
				</div>
			</div>
			<!--user_info-->
			<div class="clear"
				style="padding: 0; border: 0; margin: 0; clear: both;"></div>
		</div>
		</div>
		<!--main-->
		<div class="clear"
			style="padding: 0; border: 0; margin: 0; clear: both;"></div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
