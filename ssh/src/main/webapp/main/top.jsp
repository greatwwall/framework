<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<base href="<%=basePath %>"/>
		<title></title>
		<link rel="stylesheet" href="assets/css/topCss.css" />
		
		<script src="assets/js/jquery.js"></script>
		<script src="assets/js/Clock.js"></script>
		<script type="text/javascript">
			$(function(){
				var date = new Clock();
				date.display($("#dateSpan").get(0));
			});
			
			function flushRightJsp(){
				window.parent.frames["centerFrame"].frames["rightFrame"].location.reload();
			}
		</script>
	</head>

<body>
<table   width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td height="9" style="line-height:9px; background-image:url(assets/images/main_04.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="97" height="9" background="assets/images/main_01.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="47" background="assets/images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38" height="47" background="assets/images/main_06.gif">&nbsp;</td>
        <td width="59"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="29" background="assets/images/main_07.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="18" background="assets/images/main_14.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
              <tr>
                <td  style="width:1px;">&nbsp;</td>
                <td ><span class="STYLE1">${admin.uname }</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="155" background="assets/images/main_08.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" valign="bottom"><img src="assets/images/main_12.gif" width="367" height="23" border="0" usemap="#Map" /></td>
          </tr>
        </table></td>
        <td width="200" background="assets/images/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11%" height="23">&nbsp;</td>
            <td width="89%" valign="bottom"><span class="STYLE1" id="dateSpan"></span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="5" style="line-height:5px; background-image:url(assets/images/main_18.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" background="assets/images/main_16.gif"  style="line-height:5px;">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

	<map name="Map" id="Map">
		<area shape="rect" coords="3,1,49,22" href="main/welcome.jsp" target="rightFrame"/>
		<area shape="rect" coords="52,2,95,21" href="javascript:void(0)" target="rightFrame" onclick="history.go(-1);"/>
		<area shape="rect" coords="102,2,144,21" href="javascript:void(0)" target="rightFrame" onclick="history.go(1);" />
		<area shape="rect" coords="150,1,197,22" href="javascript:void(0)" target="rightFrame" onclick="flushRightJsp();" />
		<area shape="rect" coords="210,2,304,20"  />
		<area shape="rect" coords="314,1,361,23" href="power/loginAction!logout.action" target="_parent"/>
	</map>
</body>
</html>
