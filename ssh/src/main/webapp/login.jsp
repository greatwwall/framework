<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理平台</title>
	<style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			overflow:hidden;
		}
		.STYLE3 {color: #528311; font-size: 12px;display: block;width: 48px; }
		.STYLE4 {
			color: #42870a;
			font-size: 12px;
			
		}
		a:HOVER,
		#valicode:hover {
			cursor: pointer;
		}
		.login{
			margin:0;
		}

	</style>
	
	<script src="assets/js/jquery.js"></script>
	<script type="text/javascript">
		function changeValicode(_img){
			$(_img).attr("src","common/image.jsp?d="+new Date().getTime());
		}
		$(function(){
			setInterval(function(){
				changeValicode($("#valicode"));
			},60*30*1000);
			
			$.ajax({
				type:"GET",
				url:"power/roleAction!findAllOfLoginToJson.action",
				dataType:"json",
				success:function(data){
					for(var i=0;i<data.length;i++){
						$("<option/>").attr("value",data[i].roleId).html(data[i].roleName).appendTo("select[name=roleId]");
					}
				}
				
			});
		});
		function submit(){
			$("form.login").submit();
		}
		function reset(){
			console.log($("form.login"));
			$("form.login")[0].reset();
			changeValicode($("#valicode"));
			$("#error").html("");
		}
				
	</script>
  </head>
  
  <body>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="#e5f6cf">&nbsp;</td>
		</tr>
		<tr>
			<td height="608" background="assets/images/login_03.gif">
				<table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td height="266" background="assets/images/login_04.gif">
							<table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="236">&nbsp;</td>
								</tr>
								<tr>
									<td height="30">
									<div style="position:relative; width: 250px;height: 30px;left: 49%;top:3px; background-image: url(assets/images/login_07_01.gif);">
									<span id="error" style="position: relative;display:block;width: 250px;text-align:center; top:10px; font-size: 13px;color:red;">${error }</span>
									</div></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td  height="95">
							<form action="power/loginAction.action" method="post" id="f1" name="login" class="login">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="424" height="95" background="assets/images/login_06.gif">&nbsp;</td>
										
										<td width="246" background="assets/images/login_07.gif">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="21%" height="30"><div align="center"><span class="STYLE3">用户名</span></div></td>
									                <td width="58%" height="30">
									                	<input type="text" name="username" value="${username }" style="height:24px; width:110px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;">
									                </td >
									                <td width="19%" height="30">
									                <select name="roleId" style="height:24px;width: 86px;margin-left:2px;">
															<option value="" >-请选择-</option>
														</select>
									                </td>
												</tr>
												<tr>
													<td width="21%" height="30"><div align="center"><span class="STYLE3">密&nbsp;码</span></div></td>
													<td colspan="2" height="30"><input type="password" name="password" value="${password }" style="height:24px; width:99%; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
												</tr>
												<tr>
									                <td width="22%" height="30"><div align="center"><span class="STYLE3">验证码</span></div></td>
													<td width="58%" height="30"><input type="text" name="valicode" style="height:24px; width:110px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></td>
													<td width="20%">
														<img id="valicode" onclick="changeValicode(this);" title="看不清?楚换一张!" alt="看不清楚换一张" src="common/image.jsp" width="86px" height="24px;" style="margin:0 2px;">
													</td>
												</tr>
											</table>
										</td>
										<td width="190" background="assets/images/login_08_02.gif">&nbsp;</td>
									</tr>
								</table>
							</form>
							
						</td>
					</tr>
					<tr>
						<td height="247" valign="top" background="assets/images/login_09.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
						            <td width="22%" height="40">&nbsp;</td>
						            <td width="56%" height="40" style="background-image: url(assets/images/login_07_03.gif);">
						            	<div style="width: 250;height: 30px;position: relative;left: 48%;background-image: url(assets/images/login_07_02.gif);">
						            		<img src="assets/images/dl.gif" width="81" height="22" border="0" style="position: relative;left: 20%;" usemap="#Map">
						            	</div>
						            </td>
						            <td width="22%" height="40">&nbsp;</td>
	         					</tr>
	          					<tr>
	            					<td>&nbsp;</td>
	            					<td height="30">
	            						<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              							<tr>
								                <td width="44%" height="30">&nbsp;</td>
								                <td width="56%" class="STYLE4"><span style="display: block;position: relative;top:-10px;;">版本 CD-SXT.com 2013V1.0 </span></td>
	             							</tr>
	            						</table>
	            					</td>
	            					<td>&nbsp;</td>
	          					</tr>
	        				</table>
	        			</td>
	      			</tr>
	    		</table>
	    	</td>
	  	</tr>
	  	<tr>
	    	<td bgcolor="#a2d962">&nbsp;</td>
	  	</tr>
	</table>
	<map name="Map">
		<area shape="rect" coords="3,3,36,19" id="submit" href="javascript:submit();"/>
		<area shape="rect" coords="40,3,78,18" id="reset" href="javascript:reset();"/>
	</map>
  </body>
</html>
