String.prototype.trim=function(){
		return this.replace(/^\s+|\s+$/g, "");	
};
function $(idOrName){
	if(idOrName.charAt(0)=='#'){	
		return document.getElementById(idOrName.substring(1));
	}else{
		return document.getElementsByName(idOrName);
	}
}