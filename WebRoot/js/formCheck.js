function getSpan(obj){
	while(obj.nextSibling.nodeName!="SPAN"){
		obj=obj.nextSibling;}
		return obj.nextSibling;
	
}
function check(obj,info,fun,cclick){  
	var span=getSpan(obj);
	obj.onfocus=function(){
		span.innerHTML=info;
		span.className="state2";
		}
	obj.onblur=function(){
		if(fun(this.value)){
			span.innerHTML="正确";
			span.className="state4";
			}
		else{
			span.innerHTML=info;
		    span.className="state3";
			}
		}
	if(cclick=="click"){//这里是为了强制调用失去焦点的方法，即使是没有焦点也会强制检查；
		obj.onblur();}
	}
//onload=register;//只把函数名给它，表示这个函数；
window.onload=function register(click){ //页面加载完执行它，里面的click是和提交用的点击事件相同，只要提交有点击事件就会触发此函数
    var flag=true;//flag是register方法的返回值，onsubmit函数必须是看返回真假来判断是否执行，可以不用onload；
	var userName=document.frm.user_name;
	var userNic=document.frm.user_nic
	var passWord=document.forms["frm"].user_password;
	var rePasswd=document.frm.confirm_password;
	var interest=document.frm.interest;
	var school=document.frm.school;
		check(userNic,"昵称的长度在3到10之间",function(val){
					if(val.match(/^\S+$/) && val.length>=3 && val.length<10){
						return true;}else{
							flag=false;
							return false;}															   
					},click);
		check(userName,"请填入真实姓名，长度在3到10之间",function(val){
					if(val.match(/^\S+$/) && val.length>=3 && val.length<10){
						return true;}else{
							flag=false;
							return false;}															   
					},click);
	    check(passWord,"密码的长度在6到20之间",function(val){
					if(val.match(/^\S+$/) && val.length>=6 && val.length<20){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		check(rePasswd,"请保持密码和确认密码相同",function(val){
					if(val==passWord.value && val.match(/^\S+$/) && val.length>=6 && val.length<20){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		
		check(interest,"兴趣不能为数字",function(val){
					if(val.match(/^[0-9]/)){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		check(interest,"学校不能为数字",function(val){
					if(val.match(/^[0-9]/)){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		return flag;
	
}
