<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<!-- �ͻ�����ת�����·�����   --> 
  <%response.setCharacterEncoding("GBK");
	 request.setCharacterEncoding("GBK");
	 String path = request.getContextPath();
	 response.sendRedirect(path+"/Loger/listLoger");  
  %>