<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>管理平台</title>
	</head>

	<frameset rows="61,*,24" cols="*" framespacing="0" frameborder="no"
		border="0">
		<frame src="main/top.jsp" name="topFrame" scrolling="no"
			noresize="noresize" id="topFrame" />
		<frame src="main/center.jsp" name="centerFrame" id="mainFrame" />
		<frame src="main/down.jsp" name="bottomFrame" scrolling="no"
			noresize="noresize" id="bottomFrame" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
