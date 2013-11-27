<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
		<link rel="stylesheet" href="../css/css1.css" type="text/css" />
		<link rel="stylesheet" href="../css/all.css" type="text/css" />
	</head>

	<body>
		<jsp:include page="head.jsp"></jsp:include>
		<!--home_header-->
		<div id="main">
			<div id="home_pro_area">
				<div class="home_pro_title">
					<h2>
						我的作品集
					</h2>
				</div>
				<table width="998" border="0" cellspacing="10" cellpadding="0">
					<tr height="30px">
						<td width="400px">
							作品名
						</td>
						<td width="100px">
							时间
						</td>
						<td width="100px">
							赞数目
						</td>
						<td width="100px">
							踩数目
						</td>
						<td width="100px">
							下载数
						</td>
						<td width="100px">
							操作
						</td>
					</tr>
					<s:iterator value="workses" var="works">
						<tr>
							<td>
								<span id="pro_name"><a href="production_detail.html"><s:property
											value="#works.wname" /> </a> </span>
							</td>
							<td>
								<span id="pro_time"><s:property
										value="#works.wtime.toString().substring(0,19)
								" />
								</span>
							</td>
							<td>
								<span id="pro_comment_good"><s:property
										value="#works.wgood" /> </span>
							</td>
							<td>
								<span id="pro_comment_ban"><s:property
										value="#works.wbad" /> </span>
							</td>
							<td>
								<span id="download_num"><s:property
										value="#works.wloadNum" /> </span>
							</td>
							<td>
								<span><a
									href="Works/deleteworks?wid=<s:property
										value="#works.wid" />">删除作品</a>
								</span>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<div class="clear"
			style="padding: 0; border: 0; margin: 0; clear: both;"></div>
		<!--mian-->


		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
