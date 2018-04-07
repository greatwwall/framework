<%@page contentType="text/html; charset=utf-8" %>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  <base href="<%=basePath%>">
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet"  href="assets/css/leftCss.css" />
	<link rel="stylesheet" href="assets/css/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="assets/js/jquery-1.4.4.js"></script>
    <script type="text/javascript" src="assets/js/jquery.ztree.all-3.5.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			var zTreeObj;
  			var setting = {
  				view: {
  					selectedMulti: false
  				},
  				data: {
  					key:{
  						name:"menuName",
  						title:"prompt",
  						url:"menuUrl"
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
  					type:'GET',
  					url:'power/menuAction!findAllInRoleToJson.action',
  					dataType:'json',
  					success:function(data){
  						for(var i=0;i<data.length;i++){
  							if(data[i]['menuUrl']){
  								data[i]['target']='rightFrame';
  							}
  						}
  						zTreeObj = $.fn.zTree.init($("#tree"), setting, data);
  						zTreeObj.expandAll(true);
  					}
  				});
  				
  			});
  		});
  	</script>
  </head>
	<body>
		<div  style="height:100%;">
  			<ul class="ztree" id="tree"></ul>
		</div>
	</body>
</html>


