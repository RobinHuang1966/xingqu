<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>My JSP 'topiclist.jsp' starting page</title>
	</head>
	<body>	
		<h2>��ʾ���˶�̬</h2>
		<table border="1px" >
		<tr align="center">
		<td>��  ��  ��</td>
		<td>��������</td>
		<td>�������</td>
		<td>ʱ��</td>
		<td>����</td>


		  <c:forEach items="${logerList}" var="loger">
			<tr>
				<td> ${loger.user.uid}</td>	
			<td>
				<c:choose>
					<c:when test="${loger.ltype==0}">${loger.ltype}</c:when>
					<c:when test="${loger.ltype==1}">�ظ�����</c:when>
					<c:when test="${loger.ltype==2}">������</c:when>
					<c:when test="${loger.ltype==3}">��ע����</c:when>
					<c:when test="${loger.ltype==4}">ȡ����ע����</c:when>
					<c:when test="${loger.ltype==5}">�½�����</c:when>
					<c:when test="${loger.ltype==6}">�޸Ļ���</c:when>
					<c:when test="${loger.ltype==7}">�ϴ���Ʒ</c:when>
					<c:when test="${loger.ltype==8}">������Ʒ</c:when>
					<c:when test="${loger.ltype==9}">�ղ���Ʒ</c:when>
					<c:when test="${loger.ltype==10}">������Ʒ</c:when>			
					<c:when test="${loger.ltype==11}">����Ʒ</c:when>
					<c:when test="${loger.ltype==12}">����Ʒ</c:when>
					<c:when test="${loger.ltype==13}">��ע����</c:when>
					<c:when test="${loger.ltype==14}">ȡ����ע����</c:when>
					<c:when test="${loger.ltype==15}">����</c:when>
					<c:when test="${loger.ltype==16}">���ʿռ�</c:when>
					<c:when test="${loger.ltype==17}">����С��</c:when>
					<c:when test="${loger.ltype==18}">�˳�С��</c:when>
					<c:otherwise>��������</c:otherwise>
				</c:choose>
			</td>
				<td>${loger.topic.ttitle}${loger.works.wname}${loger.group.gtitle}${loger.puid}</td>
				<td>${loger.ltime}</td>
				<td>
					<a href='deleteLoger?lid=${loger.lid}'>ɾ��</a>
				</td>
			</tr>
		</c:forEach> 
		</table>
		
	 	<table border="0">
		<tr ><td width="900px" >���˶�̬</td></tr>
		<c:forEach items="${logerList}" var="loger">
			
			<tr> <td><a href="#">
				<c:choose>
					<c:when test="${loger.ltype==1}">
						${loger.loger.user.unick}��${loger.ltime}���ظ���${loger.topic.user.unick }�Ļ��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==2}">
						${loger.user.unick}��${loger.ltime}��������${loger.topic.user.unick }�Ļ��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==3}">
						${loger.user.unick}��${loger.ltime}����ע��${loger.topic.user.unick }�Ļ��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==4}">
						${loger.user.unick}��${loger.ltime}��ȡ����ע��${loger.topic.user.unick }�Ļ��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==5}">
						${loger.user.unick}��${loger.ltime}���½��˻��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==6}">
						${loger.user.unick}��${loger.ltime}���޸��˻��⣺${loger.topic.ttitle}��</c:when>
					<c:when test="${loger.ltype==7}">
						${loger.user.unick}��${loger.ltime}���ϴ�����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==8}">
						${loger.user.unick}��${loger.ltime}��������${loger.works.user.unick }����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==9}">
						${loger.user.unick}��${loger.ltime}���ղ���${loger.works.user.unick }����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==10}">
						${loger.user.unick}��${loger.ltime}��������${loger.works.user.unick }����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==11}">
						${loger.user.unick}��${loger.ltime}������${loger.works.user.unick }����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==12}">
						${loger.user.unick}��${loger.ltime}������${loger.works.user.unick }����Ʒ��${loger.works.wname}��</c:when>
					<c:when test="${loger.ltype==13}">
						${loger.user.unick}��${loger.ltime}����ע�˺��ѣ�${loger.puid}��</c:when>
					<c:when test="${loger.ltype==14}">
						${loger.user.unick}��${loger.ltime}��ȡ����ע���ѣ�${loger.puid}��</c:when>
					<c:when test="${loger.ltype==15}">
						${loger.user.unick}��${loger.ltime}����${loger.puid}�����ˣ�</c:when>
					<c:when test="${loger.ltype==16}">
						${loger.user.unick}��${loger.ltime}��������${loger.puid}�Ŀռ䣻</c:when>
					<c:when test="${loger.ltype==17}">
						${loger.user.unick}��${loger.ltime}��������${loger.group.user.unick }������С�飺${loger.group.gtitle}��</c:when>
					<c:when test="${loger.ltype==18}">
						${loger.user.unick}��${loger.ltime}���˳���${loger.group.user.unick }������С�飺${loger.group.gtitle}��</c:when>
					<c:otherwise>
						${loger.user.unick}��${loger.ltime}�������������ȤС��������������;</c:otherwise>
				</c:choose>
			</a></td></tr>
		</c:forEach>
		</table>  
		<p> <a href='../index.jsp'>��ҳ</a>  </p>
		<s:debug></s:debug>
	</body>
</html>
