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
    <link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="assets/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="assets/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript">
	    var zTreeObj;
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType: { "Y": "p", "N": "s" }
			},
			data: {
				key:{
					name:"menuName"
				},
				simpleData: {
					enable: true,
					idKey: "menuId",
					pIdKey: "parentId",
					rootPId: 0
				}
			}
		};
	
		$(function(){
			$.ajax({
				url:'power/menuAction!findAllOfDistributeToJson.action',
				data:{"roleId":"${param.roleId}"},
				dataType:'json',
				success:function(data){
					zTreeObj = $.fn.zTree.init($("#tree"), setting, data);
					zTreeObj.expandAll(true);
				}
			});
			
		});
		
		function getNodes(_form){
			//得到选中的节点
			var nodes = zTreeObj.getCheckedNodes(true);
			for(var i=0;i<nodes.length;i++){
				var input = document.createElement("input");
				input.type="hidden";
				input.name="menuIds";
				input.value=nodes[i]['menuId'];
				_form.appendChild(input);
			}
			return true;
		}

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
                <td width="1101" background="assets/images/tab_05.gif"><img src="assets/images/311.gif" width="16" height="16" /> <span class="STYLE4">菜单分配</span></td>
                <td width="281" background="assets/images/tab_05.gif"></td>
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
			            <div style="width: 200px">
			            	<ul id="tree" class="ztree"></ul>
			            </div>
			            <div>
				        	<form action="power/roleAction!distributeMenu.action" method="post" onsubmit="return getNodes(this)">
				        		<input type="hidden" name="role.roleId" value="${param.roleId }">
				        		<input type="submit" value="提交">
				        	</form>
				        </div>
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
