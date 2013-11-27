<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<link rel="stylesheet" href="../css/all.css" type="text/css" />
	</head>

	<body>
		<jsp:include page="../header.jsp"></jsp:include>
		<div id="main">
			<div class="position">
				<a href="../forward.jsp"><img src="images/home.png"
						style="width: 30px; height: 30px; position: relative; top: 10px;" />
				</a>&nbsp;>&nbsp;
				<a href="Works/workslist">作品</a>&nbsp;>&nbsp; 作品详情
			</div>
			<div id="pro_area">
				<div id="pro_name">
					<h2>
						<s:property value="works.wname" />
					</h2>
				</div>
				<div id="pro_info">
					<span id="user_name"><a href="">作者：<s:property
								value="works.user.unick" /> </a> </span><span id="pro_time">上传时间：<s:property
							value="works.wtime.toString().substring(0,19)" /> </span>
					<span id="pro_kind"> 作品类型：<s:if test="works.wtype==3">
					图片
					</s:if> <s:elseif test="works.wtype==0">
					文档
					</s:elseif> <s:elseif test="works.wtype==1">
					视屏
					</s:elseif> </span>

					<span id="pro_comment_good"> <a
						href="Works/goodworks?wid=<s:property
							value="works.wid" />">
							<input type="image" src="images/001_18.png" /> </a> </span>

					<span id="pro_comment_bad"><a
						href="Works/badworks?wid=<s:property
							value="works.wid" />"><input
								type="image" src="images/001_19.png" /> </a> </span>
					<span id="pro_share"> <a
						href="Works/shareworks?wid=<s:property
							value="works.wid" />">
							<input type="image" src="images/share.png" title="分享" /> </a> </span>
					<a href="Works/downloadworks?wid=<s:property value="works.wid"/>"><input
							type="image" src="images/down.png" /> </a>

				</div>
				<div id="pro_content">
					<p>
						<s:property value="works.wbrief" />
					</p>
				</div>
			</div>
			<!--pro_area-->

			<div id="sider_right">
				<div id="upload">
					<jsp:include page="upload.jsp"></jsp:include>
				</div>

			</div>
			<!--upload-->

			<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<!--sider_right-->
		<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>

		<!--main-->


		<jsp:include page="../footer.jsp"></jsp:include>

		<script type="text/javascript">
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
</script>
	</body>
</html>
