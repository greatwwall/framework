<%@page contentType="text/html; charset=utf-8" %>
<%@taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
	</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="assets/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="assets/images/tab_05.gif"><img src="assets/images/311.gif" width="16" height="16" /> <span class="STYLE4">用户信息列表</span></td>
        <td width="281" background="assets/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                        <input type="checkbox" name="checkbox62" value="checkbox" onclick="allselected(this);"/>
                    </div></td>
                    <td class="STYLE1"><div align="center" >全选</div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="assets/images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a  href="jsp/rightmanager/addUser.jsp">新增</a></div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="assets/images/114.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="javascript:void(0);" id="updateA" onclick="update();">修改</a></div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="assets/images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="javascript:void(0);" id="aDel" onclick="delArr();">删除</a></div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
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
            <td width="9%" height="26" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="10%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户编码</div></td>
            <td width="25%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户名</div></td>
          	<td width="30%" height="18" background="assets/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">编辑</div></td>
          </tr>
          <c:forEach  items="${users}"  var="u">
	          	<tr>
		            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
		              <input name="userCb" type="checkbox" class="STYLE2" value="${u.userId}" />
		            </div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${u.userId }</div></td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center" class="STYLE2 STYLE1">${u.uname }</div>
	            </td>
	            <td height="18" bgcolor="#FFFFFF">
	            	<div align="center">
            			<span class="STYLE1">[</span>
	            			<img src="assets/images/037.gif" width="9" height="9" />
            				<a  href="power/roleAction!findAllOfDistribute?userId=${u.userId}" >分配角色</a>
            			<span class="STYLE1">]</span>
	            		<span class="STYLE1">[</span>
	            			<img src="assets/images/010.gif" width="9" height="9" /> 
	            			<a href="power/usersAction!deleteByUserId.action">删除</a>
	            		<span class="STYLE1">]</span>
	            		<span class="STYLE1">[</span>
	            			<img src="assets/images/010.gif" width="9" height="9" /> 
	            			<a href="javascript:void(0);" onclick="delArr();">删除</a>
	            		<span class="STYLE1">]</span>
	            	</div>
	            </td>
	          </tr>
          </c:forEach>
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
