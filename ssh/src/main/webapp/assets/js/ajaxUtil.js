	//创建 XMLHttpRequest ajax引擎对象
    	function createXMLHttpReq(){
    		var req;
    		if(window.XMLHttpRequest){
    			req = new XMLHttpRequest();
    		}else{
    			req = new ActiveXObject("Msxml2.XMLHTTP");
    		}
    		return req;
    	}
    	/*
    		method:请求方式   get  或者 post
    		url：请求的url
    		async:  同步或者异步     值为 true 或者false
    		param:请求参数   多个参数&隔开   
    	*/
    	function sendAjax(method,url,param,async,handle200,handleLoad,handle404,handle500){
    		var req = createXMLHttpReq();
    		//定义监听代码
    		req.onreadystatechange=function(){
    			if(req.readyState==4){
    				if(req.status==200){
    					if(handle200){
    						handle200(req);
    					}
    				}else if(req.status==404){
    					if(handle404){
    						handle404();
    					}
    				}else if(req.status==500){
    					if(handle500){
    						handle500();
    					}
    				}
    			}else{
    				if(handleLoad){
    					handleLoad();
    				}
    			}
    		}
    		//调用open 方法
    		if(method.toLowerCase()=="get"){
    			req.open(method,url+"?date="+new Date().getTime()+((param==null||param.trim=="")?"":"&"+param.trim()),async);
    			//发送请求
    			req.send(null);
    		}else if(method.toLowerCase()=="post"){
    			req.open(method,url+"?date="+new Date().getTime(),async);
    			req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    			//发送请求
    			req.send(param);
    		}    		
    	}