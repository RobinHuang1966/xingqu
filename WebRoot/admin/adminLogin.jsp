<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK href="images/public.css" type=text/css rel=stylesheet>
	<LINK href="images/login.css" type=text/css rel=stylesheet>
	

  </head>
  
  <body>
    <div id="login">   
  
      
         <div id="main">
        
           <div id="login_detail">
            <s:form action="AdminLogin" method="post">
             <s:textfield name="unick" cssClass="textbox"  label="用户名"/>
             <s:password name="upassword" cssClass="textbox" label="密　码"/>	
             <s:submit value="登录"/>
              </s:form> 
           </div>
          
         </div><!-- main -->
         <div id="root">
         </div>
         <div class="clear" style="padding:0;margin:0;clear:both"></div>
  </div><!-- login -->
  </body>
</html>
