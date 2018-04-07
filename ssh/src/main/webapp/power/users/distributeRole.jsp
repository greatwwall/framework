<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="assets/css/tabCss.css" />
    <script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript">
    
    	$(function(){
    		$.ajax({
    			
    			url:'power/usersAction!findAllRoleInUserToJson.action',
    			data:{"user.userId":"${userId}"},
    			dataType:'json',
    			success:function(data){
    				for(var i=0;i<data.length;i++){
    					$("input[name=roleIds]").each(function(){
    						if($(this).val()==data[i]['roleId']){
    							$(this).attr('checked',true);
    						}
    					});
    				}
    			}
    			
    		});
    		
    	});
    </script>
    <style type="text/css">
    	form{
    		margin: 0;
    	}
    </style>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="15" height="30"><img src="assets/images/tab_03.gif" width="15" height="30" /></td>
                <td width="1101" background="assets/images/tab_05.gif"><img src="assets/images/311.gif" width="16" height="16" /> <span class="STYLE4">角色分配</span></td>
                <td width="281" background="assets/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="60">&nbsp;</td>
                        <td width="60">&nbsp;</td>
                        <td width="60">&nbsp;</td>
                        <td width="52">&nbsp;</td>
                    </tr>
                </table></td>
                <td width="14"><img src="assets/images/tab_07.gif" width="14" height="30" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
    	<td>
    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
    			<tr>
	    			<td width="9" background="assets/images/tab_12.gif">&nbsp;</td>
			        <td bgcolor="#f3ffe3">
			            <form action="power/usersAction!distributeRole.action" method="post" style="width: 100px;padding-left:100px;">
			            	<div style="text-align: left;margin-bottom: 20px;">
				            	<input type="hidden" name="users.userId" value="${userId }">
				            	<c:forEach items="${roles }" var="role">
				            		<input type="checkbox" name="roleIds" value="${role.roleId }">${role.roleName }<br />
				            	</c:forEach>
			            	</div>
			            	<input type="submit" value="提交">
			            	<input type="reset" value="重置">
			            </form>
			        </td>
			        <td width="9" background="assets/images/tab_16.gif">&nbsp;</td>
    			</tr>
    		</table>
    	</td>
    </tr>
    <tr>
        <td height="29">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="15" height="29"><img src="assets/images/tab_20.gif" width="15" height="29" /></td>
                    <td background="assets/images/tab_21.gif">&nbsp;</td>
                    <td width="14"><img src="assets/images/tab_22.gif" width="14" height="29" /></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
