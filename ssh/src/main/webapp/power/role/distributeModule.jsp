<%@page contentType="text/html; charset=utf-8" %>
<%@taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title></title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="assets/css/tabCss.css">
	<script src="assets/js/tabjs.js"></script>
	<script src="assets/js/jquery-1.4.4.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$('input.power').bind('click',function(){
				var powerCode = $(this).val();
				var moduleId =$(this).attr('moduleId');
				$.ajax({
					url:'power/roleAction!distributeModule.action',
					type:'post',
					data:{"role.roleId":"${roleId}","moduleId":moduleId,"powerCode":powerCode}
				});
			});
			
		});
	</script>
	</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="assets/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="assets/images/tab_05.gif"><img src="assets/images/311.gif" width="16" height="16" /> <span class="STYLE4">模块分配</span></td>
        <td width="281" background="assets/images/tab_05.gif"></td>
        <td width="14"><img src="assets/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="assets/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
          <tr>
            <td width="5%" height="26" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="10%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">模块编码</div></td>
            <td width="25%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">模块名</div></td>
          	<td width="15%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">查询</div></td>
          	<td width="15%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">新增</div></td>
          	<td width="15%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">更新</div></td>
          	<td width="15%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">删除</div></td>
          </tr>
          <s:iterator  value="modules"  var="m">
	          	<tr>
		            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
		              <input name="userCb" type="checkbox" class="STYLE2" value='<s:property value="#m.moduleId"/>' />
		            </div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><s:property value="#m.moduleId"/></div></td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1"><s:property value="#m.moduleName"/></div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1">
            			<input type="checkbox" class="power" <s:if test="(permission.get(#m.moduleId)&1)==1">checked="checked"</s:if> moduleId='<s:property value="#m.moduleId"/>' value="1">
	            	</div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1">
            			<input type="checkbox" class="power" <s:if test="(permission.get(#m.moduleId)&2)==2">checked="checked"</s:if> moduleId='<s:property value="#m.moduleId"/>' value="2">
	            	</div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1">
            			<input type="checkbox" class="power" <s:if test="(permission.get(#m.moduleId)&4)==4">checked="checked"</s:if> moduleId='<s:property value="#m.moduleId"/>' value="4">
	            	</div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1">
            			<input type="checkbox" class="power" <s:if test="(permission.get(#m.moduleId)&8)==8">checked="checked"</s:if> moduleId='<s:property value="#m.moduleId"/>' value="8">
	            	</div>
	            </td>
	          </tr>
          </s:iterator>
        </table></td>
        <td width="9" background="assets/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="29"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="assets/images/tab_20.gif" width="15" height="29" /></td>
        <td background="assets/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <!-- 导出Excel表 -->
            <td align="center" width="100%" height="29" nowrap="nowrap"><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
          </tr>
        </table></td>
        <td width="14"><img src="assets/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
