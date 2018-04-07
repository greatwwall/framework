<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
    <title></title>
  </head>
  <body >
  <div style="position: absolute;top: 200px; left: 40%">
    <div align="center">
    	<span><font size="20px" color="red">Welcome</font></span>
    </div>
    </div>
  </body>
</html>
