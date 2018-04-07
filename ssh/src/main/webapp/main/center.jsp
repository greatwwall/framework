<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="assets/css/centerCss.css" />
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed">
  <tr>
    <td background="assets/images/main_40.gif" style="width:3px;">&nbsp;</td>
    <td width="200"  style="border-right:solid 1px #9ad452;"><iframe name="leftFrame" height="100%" width="200" border="0" frameborder="0" src="main/left.jsp">
		浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
    <td><iframe name="rightFrame" src="main/welcome.jsp" height="100%" width="100%" border="0" frameborder="0">
		浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
    <td background="assets/images/main_42.gif" style="width:3px;">&nbsp;</td>
  </tr>
</table>
</body>
</html>
