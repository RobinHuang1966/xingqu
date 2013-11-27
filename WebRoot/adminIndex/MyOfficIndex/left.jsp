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
		<link rel="stylesheet" href="adminIndex/MyOfficIndex/css/common.css" type="text/css" />
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<STYLE type=text/css> 
	{
		FONT-SIZE: 12px
	}
	#menuTree A {
		COLOR: #566984; TEXT-DECORATION: none
	}
	</STYLE>

	<SCRIPT src="adminIndex/MyOfficIndex/Left.files/TreeNode.js" type=text/javascript></SCRIPT>
	<SCRIPT src="adminIndex/MyOfficIndex/Left.files/Tree.js" type=text/javascript></SCRIPT>	

 </head>
  
  <body style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" align="left">
	  <TBODY>
	    <TR align="left">
	      <TD  width=10 height=29><IMG src="adminIndex/MyOfficIndex/Left.files/bg_left_tl.gif"></TD>
	      <TD 
	    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">Main 
	        Menu</TD>
	      <TD width=10><IMG src="adminIndex/MyOfficIndex/Left.files/bg_left_tr.gif"></TD>
	    </TR>
	    <TR>
	      <TD style="BACKGROUND-IMAGE: url(images/bg_left_ls.gif)"></TD>
	      <TD id=menuTree 
	    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" 
	    vAlign=top></TD>
	      <TD style="BACKGROUND-IMAGE: url(images/bg_left_rs.gif)"></TD>
	    </TR>
	    <TR>
	      <TD width=10><IMG src="adminIndex/MyOfficIndex/Left.files/bg_left_bl.gif"></TD>
	      <TD style="BACKGROUND-IMAGE: url(images/bg_left_bc.gif)"></TD>
	      <TD width=10><IMG 
	src="adminIndex/MyOfficIndex/Left.files/bg_left_br.gif"></TD>
	    </TR>
	  </TBODY>
	</TABLE>
	<SCRIPT type=text/javascript>
	var tree = null;
	var root = new TreeNode('系统菜单');
	
	

			  
	var fun5 = new TreeNode('小组管理');
	var fun6 = new TreeNode('小组列表', 'adminIndex/MyOfficIndex/groupList.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  
			  fun5.add(fun6);
			  
	var fun43 = new TreeNode('查找小组', 'adminIndex/MyOfficIndex/findGroup.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  
			  fun5.add(fun43);
			  
	var fun7 = new TreeNode('审核小组', 'adminIndex/MyOfficIndex/groupVerify.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  
			  fun5.add(fun7);
			  
			  root.add(fun5);
	
	var fun13 = new TreeNode('用户管理');
	var fun14 = new TreeNode('查询用户', 'adminIndex/MyOfficIndex/user_find.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  fun13.add(fun14);
	var fun15 = new TreeNode('用户列表', 'adminIndex/MyOfficIndex/userList.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  fun13.add(fun15);

			  root.add(fun13);
	var fun16 = new TreeNode('主题管理');
	var fun19 = new TreeNode('主题列表', 'adminIndex/MyOfficIndex/themeList.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  fun16.add(fun19);
	var fun20 = new TreeNode('添加主题', 'adminIndex/MyOfficIndex/addTheme.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  fun16.add(fun20);
	var fun21 = new TreeNode('查询主题', 'adminIndex/MyOfficIndex/findTheme.jsp', 'tree_node.gif', null,'tree_node.gif', null);
			  fun16.add(fun21);
			  root.add(fun16);	
			  tree = new Tree(root);
			  tree.show('menuTree')
	</SCRIPT>
  </body>
</html>
