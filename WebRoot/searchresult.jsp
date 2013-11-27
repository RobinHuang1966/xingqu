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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/css1.css" type="text/css" />
		<link rel="stylesheet" href="css/all.css" type="text/css" />
		<title>无标题文档</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="main">
			<div id="searchCon">
				<div id="search">
					<form method="post" action="serach" id="search_form">
						<div class="search_input">
							<input type="text" name="like" id="keyword2" value="站内搜索"
								style="height: 32px; width: 740px;" />
						</div>
						<div class="search_button">
							<input type="image" src="images/find.png" id="search_submit"
								style="height: 30px; width: 30px; background: #ccc" />
						</div>
					</form>
					<script>
	var keyword = document.getElementById("keyword2");
	keyword.onclick = function() {
		keyword.value = "";
	};
</script>
				</div>
				<!--search end-->
				<ul id="searchContent">

					<s:iterator value="themelist">
						<li class="searchLi">
							<ul>
								<li>
									<span class="percent">主题</span>
									<div class="searchTitle">
										<a href="#"><s:property value="ttitle" /> </a>
									</div>
								</li>
								<li>
									<div class="searchArticle">
										<p>
											<s:property value="thBrief" />
										</p>
									</div>
								</li>
								<li>
									<span class="searchAuther">作者</span><span class="searchTime">2012.2.12</span>
								</li>
							</ul>
						</li>
					</s:iterator>

					<s:iterator value="topiclist">
						<li class="searchLi">
							<ul>
								<li>
									<span class="percent">话题</span>
									<div class="searchTitle">
										<a href="#"><s:property value="ttitle" /> </a>
									</div>
								</li>
								<li>
									<div class="searchArticle">
										<p>
											<s:property value="tcontent" />
										</p>
									</div>
								</li>
								<li>
									<span class="searchAuther">某某某老师</span><span class="searchTime">2012.2.12</span>
								</li>
							</ul>
						</li>
					</s:iterator>
					<s:iterator value="workslist">
						<li class="searchLi">
							<ul>
								<li>
									<span class="percent">作品</span>
									<div class="searchTitle">
										<a href="#"><s:property value="wname" /> </a>
									</div>
								</li>
								<li>
									<div class="searchArticle">
										<p>
											<s:property value="wbrief" />
										</p>
									</div>
								</li>
								<li>
									<span class="searchAuther">某某某老师</span><span class="searchTime">2012.2.12</span>
								</li>
							</ul>
						</li>
					</s:iterator>
				</ul>
				<script>
	$(".searchArticle").each(
			function(i) {
				var divH = $(this).height();
				var $p = $("p", $(this)).eq(0);
				while ($p.outerHeight() > divH) {
					$p.text($p.text().replace(
							/(\S)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
					//alert("dddddd");
				}
			});
</script>
				<center>
					共 6 页 当前第
					<span id="number">1</span> 页
					<span id="theFirstPage"><a href="javascript:firstPage()">第一页</a>
					</span>
					<span id="thePrePage"><a href="javascript:prePage()">上一页</a>
					</span>
					<span id="theNextPage"><a href="javascript:nextPage()">下一页</a>
					</span>
					<span id="theLastPage"><a href="javascript:lastPage()">最后一页</a>
					</span> 转到第
					<select onChange="gotoPage(this.value)" id="goto">
						<option value=1>
							1
						</option>
						<option value=2>
							2
						</option>
						<option value=3>
							3
						</option>
						<option value=4>
							4
						</option>
						<option value=5>
							5
						</option>
						<option value=6>
							6
						</option>
					</select>
					页
				</center>
				<div class="clear">
				</div>
			</div>
			<!--searchCon end-->
			<div class="clear" style="padding: 0; margin: 0; clear: both;"></div>
		</div>
		<!--main-->
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
