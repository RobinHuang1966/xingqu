<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<base href="<%=basePath%>">
		<title>My JSP 'testLogin.jsp' starting page</title>

	</head>
	<body>
	<%
	     Integer month = 9;
	     request.setAttribute("month",month);
	     
	%>
<P>这里测试Stru2中嵌套java代码</P>
<s:textfield value="%{#request.month}"></s:textfield><br/>
<s:textfield value="%{#session.unick}"></s:textfield><br/>
<s:textfield value="<s:property value="#session.unick"/>"></s:textfield><br/>

${unick}<br/>
<s:textfield value="%{#session.topic.group.gtitle}"></s:textfield><br/>
<s:textfield value="%{#session.topic.group.user.unick}"></s:textfield><br/>
<s:set name="age" value="%{25}"/>
<s:textfield value="%{age}"></s:textfield><br/>
<s:textfield value="%{#age+10}"></s:textfield><br/>

<P></P>
<s:set name="myMap" value="#{'key1':'value1','key2':'value2'}"/>     
 <s:textfield value="#myMap['key1']"></s:textfield><br/>
<div> <s:property value="#myMap['key1']"/>   </div>
<s:url value="#myMap['key1']" />    
<s:set name="myMap" value="#{'key1':'value1','key2':'value2'}"/>    
<s:property value="#myMap['key1']"/>    
<s:url value="#myMap['key1']"/> 

<s:url value="%{#myMap['key1']}"/>      
<s:url value="%{#myMap['key1']}"/> 
<s:debug></s:debug>
	</body>
</html>
