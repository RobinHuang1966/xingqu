<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>更新个人信息</title>
		<link rel="stylesheet" type="text/css" href="../css/all.css" />
		<link rel="stylesheet" href="css/css1.css" type="text/css" />
		<script language="javascript" type="text/javascript"
			src="js/WdatePicker.js">
	
</script>
		<script language="javascript" type="text/javascript">
	
</script>
		<script language="javascript" src="js/jquery1.4.js">
	
</script>
		<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

.suggest-container {
	border: 1px solid #C1C1C1;
	visibility: hidden;
	background: #fff;
}

.suggest-item {
	padding: 3px 2px;
}

.suggest-active {
	color: #c00;
	padding: 3px 2px;
}

.state1 {
	color: #ccc;
}

.state2 {
	color: #333;
}

.state3 {
	color: #c00;
}

.state4 {
	color: #09C;
}
</style>
	</head>
	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<!--home_header-->
		<div id="main">
			<div id="user_info">
				<div class="user_info_title">
					<h2>
						修改我的信息
					</h2>
				</div>
				<div id="user_info_list">
					<form action="User/userupadte" method="post" name="frm">
						<table width="700px" border="1" cellspacing="0" cellpadding="0"
							collapse="collapse" bordercolor="#ccc">
							<tr>
								<td align="right">
									昵称:
								</td>
								<td>
									<s:property value="#session.user.unick" />
								</td>
							</tr>
							<tr>
								<td>
									<s:textfield size="40" name="uname" label="用户名"
										value="%{#session.user.uname}"></s:textfield>


								</td>
							</tr>
							<tr>
								<td align="right">
									头像：
								</td>
								<td>
									<input type="file" name="user_image" />
								</td>
							</tr>
							<tr>



								<td align="right">
									性别：
								</td>
								<td>
									<input type="radio" name="usex" value="0" checked="checked"/>
									男
									<input type="radio" name="usex" value="1" />
									女
								</td>


							</tr>
							<tr>
								<td align="right">
									生日：
								</td>
								<td>
									<s:textfield size="40" name="ubirthady" label="生日"
										value="%{#session.user.ubirthady}"></s:textfield>
									<!--<s:property value="%{#session.user.ubirthady}"/>-->
								</td>
							</tr>
							<tr>

								<td>
									<s:textfield size="40" name="uemail" label="邮箱"
										value="%{#session.user.uemail}"></s:textfield>

								</td>
							</tr>
							<tr>

								<td>
									<s:textfield size="40" name="uinterest" label="兴趣"
										value="%{#session.user.uinterest}"></s:textfield>

								</td>
								<!--这里有空的话加一个省市选择的-->
							</tr>
							<tr>
								<td align="right">
									所在年级：
								</td>
								<td>
									<select id="grade"
										style="width: 252px; margin-bottom: 10px; height: 30px; line-height: 30px;"
										name="ugrade">
										<option value="一年级">
											一年级
										</option>
										<option value="二年级">
											二年级
										</option>
										<option value="三年级">
											三年级
										</option>
										<option value="四年级">
											四年级
										</option>
										<option value="五年级">
											五年级
										</option>
										<option value="六年级">
											六年级
										</option>
										<option value="七年级">
											七年级
										</option>
										<option value="八年级">
											八年级
										</option>
										<option value="九年级">
											九年级
										</option>
										<option value="高一">
											高一
										</option>
										<option value="高二">
											高二
										</option>
										<option value="高三">
											高三
										</option>
										<option value="其他">
											其他
										</option>
									</select>
								</td>
							</tr>
							<tr>

								<td>
									<s:textfield size="40" name="uschool" label="学校"
										value="%{#session.user.uschool}"></s:textfield>

								</td>

							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit" value="提交信息" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<!--user_info-->
		</div>
		<!--main-->
		<div class="clear"
			style="padding: 0; border: 0; margin: 0; clear: both;"></div>

		<div id="footer">
			<p>
				版权所有：西北农林科技大学信息工程学院华迪实习第七小组
			</p>
			<p>
				<a href="#">版主入口</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="#">管理入口</a>
			</p>
		</div>
	</body>
</html>
