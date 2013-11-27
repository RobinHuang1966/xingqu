<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 客户端跳转，重新发请求   --> 
  <%response.setCharacterEncoding("utf-8");
	 request.setCharacterEncoding("utf-8");
	 String path = request.getContextPath();
	 response.sendRedirect(path+"/Friend/listFriend");  
  %>