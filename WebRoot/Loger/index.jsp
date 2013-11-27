<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<!-- 客户端跳转，重新发请求   --> 
  <%response.setCharacterEncoding("GBK");
	 request.setCharacterEncoding("GBK");
	 String path = request.getContextPath();
	 response.sendRedirect(path+"/Loger/listLoger");  
  %>