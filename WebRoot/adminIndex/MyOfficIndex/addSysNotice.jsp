<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<script language="javascript" type="text/javascript" src="js/jquery.js"></script>
<script>
$(function(){
		  var numId=$("tbody td");
		  numId.click(function(){
							   //alert("dddd");创建一个文本框，加入到表格的格子中
							   var inputObj=$("<input type='text'>");
							   var tdObj=$(this);
							   //当表格中有文本框的时候才不牵连。表示不太明白这一句。。。。。。
							   if(tdObj.children("input").length>0){
								   return false;}
							   /*
							   //把当前td中的内容放入到文本框中，并且清空格子中的内容
							   inputObj.val(tdObj.html());
							   tdObj.html("");
							   //去掉文本框的边框
							   inputObj.css("border","none");
							   //文本框的长度与表格一样
							   inputObj.width(tdObj.width());
							   inputObj.height(tdObj.height());
							   //字体与背景与表格一样
							   inputObj.css("font-size","16px");
							   inputObj.css("background-color",tdObj.css("background-color"));
							   inputObj.appendTo(tdObj);*/
							   
							   //上面这一大段内容都可以精简，因为Jquery可以进行链式操作，每次操作结束返回值都是一个Jquery对象
							   var text=tdObj.html();
							   tdObj.html("");
							   inputObj.val(text).css("border","none").width(tdObj.width()).css("font-size","12px")                                     .css("background-color",tdObj.css("background-color")).appendTo(tdObj);
							   
							   //文本框加入之后就被选中，要先触发焦点，再选中
							   inputObj.trigger("focus").trigger("select");
							   //点击文本框的时候，表格也会受到牵连，为了不牵连表格，要执行以下代码；
							   inputObj.click(function(){
													   return false});
							   //处理文本框上的回车键和esc键的操作，回车保存，esc还原
							   inputObj.keyup(function(event){
													   var keyCode=event.which;
													   if(keyCode==13){
														   var inputText=$(this).val();
														   tdObj.html(inputText);
														   }
													   else if(keyCode==27){
														   tdObj.html(text);
														   }
													   });
							   });
		                       
		   });
</script>
</head>

<body>
<div id="main">
  <div class="main_title">添加公告</div>
<div id="container">
  <s:form action="AddSysNotice" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="244">公告标题</td>
    <td width="489">公告内容</td>
  </tr> 
  <tr>
    <td> <s:textfield name="sysTitle"  theme="simple" /> </td>
    <td> <s:textfield name="sysContent" theme="simple" /> </td>    
  </tr>
</table>
<s:submit value="保存" />
</s:form>
</div><!--container-->
</div><!--main-->
</body>
</html>
