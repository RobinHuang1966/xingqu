<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'top.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<STYLE type=text/css>
* {
	FONT-SIZE: 12px;
	COLOR: white
}

body {
	background-image: url(images/bg_login.png) repeat-x
}

#logo {
	COLOR: white
}

#logo A {
	COLOR: white
}

FORM {
	MARGIN: 0px
}
</STYLE>


		<SCRIPT src="adminIndex/MyOfficIndex/Top.files/Clock.js"
			type=text/javascript></SCRIPT>

	</head>

	<body
		style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
		<DIV id=logo
			style="BACKGROUND-IMAGE: url(images/logo.jpg); BACKGROUND-REPEAT: repeat; border-style: none">
			<DIV
				style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right; border-style: none">
				<A id=HyperLink2 href="index" target="_top">返回首页</A>
			</DIV>
			<DIV style="DISPLAY: block; HEIGHT: 54px; border-style: none;"></DIV>
			<DIV
				style="BACKGROUND-IMAGE: url(images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px; border-style: none">
				<TABLE cellSpacing=0 cellPadding=0 width="1000px"
					style="border-style: none;">

					<TR style="border-style: none;">
						<TD style="border-style: none;">
							<IMG style="border-style: none;"
								src="adminIndex/MyOfficIndex/Top.files/nav_pre.gif"
								align=absMiddle />
							欢迎[系统管理员 ] 光临
						</TD>

						<TD align="right" style="border-style: none" width="60%">
							<A href="javascript:history.go(-1);" style="border-style: none">
								<IMG src="adminIndex/MyOfficIndex/Top.files/nav_back.gif"
									align=absMiddle border=0 style="border-style: none">后退</A>
							<A href="javascript:history.go(1);" style="border-style: none">
								<IMG src="adminIndex/MyOfficIndex/Top.files/nav_forward.gif"
									align=absMiddle border=0 style="border-style: none">前进</A>
							<A href="admin/adminLogin.jsp" target=_top
								style="border-style: none"> <IMG
									src="adminIndex/MyOfficIndex/Top.files/nav_changePassword.gif"
									align=absMiddle border=0 style="border-style: none">退出系统</A>
							<IMG src="adminIndex/MyOfficIndex/Top.files/menu_seprator.gif"
								align=absMiddle style="border-style: none">
							<SPAN id=clock style="border-style: none"></SPAN>
						</TD>

					</TR>

				</TABLE>
			</DIV>
		</DIV>
		<SCRIPT type=text/javascript>
		var clock = new Clock();
		
        clock.display(document.getElementById("clock"));

	</SCRIPT>
	</body>
</html>
