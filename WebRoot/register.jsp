<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<script language="javascript" type="text/javascript"
			src="js/WdatePicker.js">
	
</script>
		<script language="javascript" type="text/javascript">
	
</script>
		<script language="javascript" src="js/jquery1.4.js">
	
</script>
		<script type="text/javascript" src="js/formAndMainCheck.js"
			charset="utf-8">
	
</script>
		<title>无标题文档</title>
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
		<div id="login_bg"
			style="background: url(images/login_bg.png) no-repeat; margin: 0 auto; width: 1000px; height: 620px">
			<div id="nav">
				<div id="logo"></div>
				<!--logo-->
				<div id="enter">
					<a href="login.jsp">登录</a><a href="register.jsp">注册</a>
				</div>
				<!--login-->
				<div id="search">
					<form action="./?" method="get">
						<input type="text" size="30" value="搜索小组、作品、话题、好友" />
						<input type="image" src="images/find.png"
							style="background: #ccc; height: 20px; width: 20px;" />
					</form>
				</div>
				<!--search-->
				<ul>
					<li style="background: url(images/nav_li.png)">
						<a href="forward.jsp">首页</a>
					</li>
					<li>
						<a href="Group/showgroup">小组</a>
					</li>
					<li>
						<a href="Works/workslist">作品</a>
					</li>
					
					<li>
						<a href="User/showmyhome">家园</a>
					</li>
				</ul>

			</div>
			<!--nav-->
			<div id="main" style="height: 540px; background: none;">

				<!--register_head-->
				<div id="register">

					<form action="User/useradd" method="post" name="frm"
						onsubmit="return register('click')">
						<div id="register_head">
							<h2>
								请选择你的身份
							</h2>
							<s:radio name="utype" onchange="Change()"
								list="%{#{'0':'老师','1':'学生','2':'家长'}}"></s:radio>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:textfield size="40" name="unick" label="昵称" />
						<span class="state1">请输入昵称</span>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:textfield size="40" name="uname" label="姓名" />
						<span class="state1">请输入用户名</span>
						<br />

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:password size="40" name="upassword" label="密码" />
						<span class="state1">请输入密码</span>
						<br />

						<s:password size="40" name="upassword1" label="确认密码" />
						<span class="state1">请输入确认密码</span>
						<br />

						

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:radio name="usex" list="%{#{'0':'男','1':'女'}}" label="性别"></s:radio>
						<br />



						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:textfield name="ubirthady" class="Wdate" value=""
							id="publish_time" onFocus="WdatePicker()" size="40" label="生日" />
						<br />
						<div style="width: 400px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:textfield label="邮箱" id="sina" size="40" name="uemail" />
							<span class="state1">邮箱必填</span>
						</div>
						<div id="subject">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:textfield label="兴趣" value="" size="40" name="uinterest" />
							<span class="state1"></span>
							<br />
						</div>

						<div id="gradebar">
							所在年级:
							<select id="grade"
								style="width: 252px; margin-bottom: 10px; height: 30px; line-height: 30px;"
								name="ugrade">
								<option value="一年级" name="ugrade">
									一年级
								</option>
								<option value="二年级" name="ugrade">
									二年级
								</option>
								<option value="三年级" name="ugrade">
									三年级
								</option>
								<option value="四年级" name="ugrade">
									四年级
								</option>
								<option value="五年级" name="ugrade">
									五年级
								</option>
								<option value="六年级" name="ugrade">
									六年级
								</option>
								<option value="七年级" name="ugrade">
									七年级
								</option>
								<option value="八年级" name="ugrade">
									八年级
								</option>
								<option value="九年级" name="ugrade">
									九年级
								</option>
								<option value="高一" name="ugrade">
									高一
								</option>
								<option value="高二" name="ugrade">
									高二
								</option>
								<option value="高三" name="ugrade">
									高三
								</option>
								<option value="其他" name="ugrade">
									其他
								</option>
							</select>
							<br />
						</div>
						<div id="schoolbar">
							<s:textfield label="所在学校" id="uschool" size="40" name="uschool" />
							<span class="state1"></span>
							<br />
						</div>
						<input type="submit" value="提交信息" name="subm" />
					</form>
				</div>
				<!--register-->
				<script>
	var subject = document.getElementById("subject");
	var school = document.getElementById("schoolbar");
	var grade = document.getElementById("gradebar");
	var re_head = document.getElementById("register_head");
	function Change() {
		var identity = re_head.getElementsByTagName("input");
		var result = "";
		for ( var i = 0; i < identity.length; i++) {
			if (identity[i].checked == true) {
				result = identity[i].value;
				if (result == "2") {
					school.style.display = "none";
					subject.style.display = "none";
					grade.style.display = "none";
				} else if (result == "0") {
					school.style.display = "none";
					grade.style.display = "none";
				} else {
					school.style.display = "block";
					subject.style.display = "block";
					grade.style.display = "block";
				}
			}
		}
	}
</script>

			</div>
			<!--main-->
			
			
			<!--footer-->
		</div>
		<!-- login_bg -->
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
