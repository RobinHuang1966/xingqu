<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<base href="<%=basePath%>">
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
<title>�ޱ����ĵ�</title>
</head>

<body>
<div id="main">
<div class="main_title">�����û�</div>
<div id="container" >
<s:form action="ShowUserInfo" method="post">
	<s:textfield name="unick" />
	<s:submit value="����" />
</s:form>
<div id="result">
<table width="775" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="36">�ǳ�</th>
    <th width="62">����</th>
    <th width="59">����</th>
    <th width="40">�Ա�</th>
    <th width="59">����</th>
    <th width="82">��Ȥ</th>
    <th width="76">ע��ʱ��</th>
    <th width="71">����¼ʱ��</th>
    <th width="45">״̬</th>
    <th width="48">����</th>
  </tr>
   	
   	<s:iterator value="userlist">
	<tr>
		<td> <s:property value="unick"/> </td>
		<td> <s:property value="uname"/> </td>
		<td> <s:property value="upassword"/> </td>
		<td> <s:property value="usex"/> </td>
		<td> <s:property value="uemail"/> </td>
	    <td> <s:property value="uinterest"/> </td>
		<td> <s:property value="uregTime"/> </td>			
		<td> <s:property value="ulastLoginTime"/> </td>
		<td> <s:property value="ustate"/> </td>		    				
		<td> <a href='<s:url action="DelUser"><s:param name="uid" value="uid" /></s:url>'>ɾ��</a> </td>
		
	</tr>		
	</s:iterator>
</table>
</div>

</div><!--contanier-->
</div><!--main-->
</body>
</html>
