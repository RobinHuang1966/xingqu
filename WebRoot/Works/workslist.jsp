<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>My JSP 'topiclist.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<script src="SpryAssets_pro/SpryTabbedPanels.js"
			type="text/javascript"></script>
		<link href="SpryAssets_pro/SpryTabbedPanels.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript" src="js/jquery1.4.js"></script>
	</head>

	<body>
		<div id="header">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>
		<div id="main">
			<div class="position">
				<a href="forward.jsp"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp; 作品
			</div>

			
			<div id="TabbedPanels1" class="TabbedPanels">
				
				<div class="TabbedPanelsContentGroup">
	            	<div class="TabbedPanelsContent">
	            	    
						<jsp:include page="page.jsp"></jsp:include>
						<table width="960px" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th width="459" align="left">
									标题
								</th>
								<th width="90">
									作者
								</th>
								<th width="190">
									时间
								</th>
								<th width="50">
									赞
								</th>
								<th width="50">
									踩
								</th>
								<th width="40">
									分享
								</th>
								<th width="121">
									大小
								</th>
								<th width="40">
									下载
								</th>
							</tr>
							<s:iterator value="worksList" var="works">
								<tr>

									<td class="tltle_s">
										<a href="Works/showworksdetail?wid=<s:property value="#works.wid" />"><s:property value="#works.wname" /></a>
									</td>
									<td align="center">
										<s:property value="#works.user.unick" />
									</td>

									<td align="center">
										<s:property value="#works.wtime.toString().substring(0,19)" />

									</td>
									<td align="center">
										<s:property value="#works.wgood" />
										<a href="Works/goodworks?wid=<s:property value="#works.wid"/>"><input
												type="image" src="images/001_18.png" /> </a>

									</td>
									<td align="center">
										<s:property value="#works.wbad" />
										<a href="Works/badworks?wid=<s:property value="#works.wid"/>"><input
												type="image" src="images/001_19.png" /> </a>

									</td>
									<td align="center">
										<a
											href="Works/shareworks?wid=<s:property value="#works.wid"/>"><input
												type="image" src="images/share.png" /> </a>


									</td>
									<td align="center">
										<s:property value="#works.wsize.toString().substring(0,4)" />
										MB

									</td>
									<td align="center">
										<s:property value="#works.wloadnum" />
										<a
											href="Works/downloadworks?wid=<s:property value="#works.wid"/>"><input
												type="image" src="images/down.png" /> </a>

										<!--  <a
								href="Works/deleteworks?wid=<s:property value="#works.wid"/>">删除</a>-->
									</td>
								</tr>
							</s:iterator>
						</table>
						<jsp:include page="page.jsp"></jsp:include>
					</div>
					<!--4-->
				</div>
			</div>
			<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<!-- main -->

		<jsp:include page="../footer.jsp"></jsp:include>

		<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
		<script language="javascript" type="text/javascript">
$(function(){
		   $(".TabbedPanelsContent table tr:even").css("background-color","#eef");});
</script>
	</body>
</html>
