﻿function getSpan(obj){
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
			span.innerHTML="";
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
	
	function register(click){ //页面加载完执行它，里面的click是和提交用的点击事件相同，只要提交有点击事件就会触发此函数
    var flag=true;//flag是register方法的返回值，onsubmit函数必须是看返回真假来判断是否执行，可以不用onload；
	var userName=document.frm.uname;
	var userNic=document.frm.unick;
	var passWord=document.forms["frm"].upassword;
	var rePasswd=document.frm.upassword1;
	var interest=document.frm.uinterest;
	var umail=document.frm.uemail;
	var school=document.frm.uschool;
		check(userNic,"昵称的长度在3到10之间",function(val){
					if(val.match(/^\S+$/) && val.length>=3 && val.length<10){
						return true;}else{
							flag=false;
							return false;}															   
					},click);
		check(userName,"请填入真实姓名，长度在1到10之间",function(val){
					if(val.match(/^\S+$/) && val.length>=1 && val.length<10){
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
					if(!val.match(/^[0-9]/)){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		check(school,"学校不能为数字",function(val){
					if(!val.match(/^[0-9]/)){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		check(umail,"邮箱必填",function(val){
					if(val.match(/^\S+$/)){
						return true;}
					else{
						flag=false;
						return false;}
					},click);
		return flag;
	
}
function InputSuggest(opt){ 
this.win = null; 
this.doc = null; 
this.container = null; 
this.items = null; 
this.input = opt.input || null; 
this.containerCls = opt.containerCls || 'suggest-container'; 
this.itemCls = opt.itemCls || 'suggest-item'; 
this.activeCls = opt.activeCls || 'suggest-active'; 
this.width = opt.width; 
this.opacity = opt.opacity; 
this.data = opt.data || []; 
this.active = null; 
this.visible = false; 
this.init(); 
} 
InputSuggest.prototype = { 
init: function(){ 
this.win = window; 
this.doc = window.document; 
this.container = this.$C('div'); 
this.attr(this.container, 'class', this.containerCls); 
this.doc.body.appendChild(this.container); 
this.setPos(); 
var _this = this, input = this.input; 
this.on(input,'keyup',function(e){ 
if(input.value==''){ 
_this.hide(); 
}else{ 
_this.onKeyup(e); 
} 
}); 
// blur会在click前发生，这里使用mousedown 
this.on(input,'blur',function(e){ 
_this.hide(); 
}); 
this.onMouseover(); 
this.onMousedown(); 
}, 
$C: function(tag){ 
return this.doc.createElement(tag); 
}, 
getPos: function (el){ 
var pos=[0,0], a=el; 
if(el.getBoundingClientRect){ 
var box = el.getBoundingClientRect(); 
pos=[box.left,box.top]; 
}else{ 
while(a && a.offsetParent){ 
pos[0] += a.offsetLeft; 
pos[1] += a.offsetTop; 
a = a.offsetParent 
} 
} 
return pos; 
}, 
setPos: function(){ 
var input = this.input, 
pos = this.getPos(input), 
brow = this.brow, 
width = this.width, 
opacity = this.opacity, 
container = this.container; 
container.style.cssText = 
'position:absolute;overflow:hidden;left:' 
+ pos[0] + 'px;top:' 
+ (pos[1]+input.offsetHeight) + 'px;width:' 
// IE6/7/8/9/Chrome/Safari input[type=text] border默认为2，Firefox为1，因此取offsetWidth-2保证与FF一致 
+ (brow.firefox ? input.clientWidth : input.offsetWidth-2) + 'px;'; 
if(width){ 
container.style.width = width + 'px'; 
} 
if(opacity){ 
if(this.brow.ie){ 
container.style.filter = 'Alpha(Opacity=' + opacity * 100 + ');'; 
}else{ 
container.style.opacity = (opacity == 1 ? '' : '' + opacity); 
} 
} 
}, 
show: function(){ 
this.container.style.visibility = 'visible'; 
this.visible = true; 
}, 
hide: function(){ 
this.container.style.visibility = 'hidden'; 
this.visible = false; 
}, 
attr: function(el, name, val){ 
if(val === undefined){ 
return el.getAttribute(name); 
}else{ 
el.setAttribute(name,val); 
name=='class' && (el.className = val); 
} 
}, 
on: function(el, type, fn){ 
el.addEventListener ? el.addEventListener(type, fn, false) : el.attachEvent('on' + type, fn); 
}, 
un: function(el, type, fn){ 
el.removeEventListener ? el.removeEventListener(type, fn, false) : el.detachEvent('on' + type, fn); 
}, 
brow: function(ua){ 
return { 
ie: /msie/.test(ua) && !/opera/.test(ua), 
opera: /opera/.test(ua), 
firefox: /firefox/.test(ua) 
}; 
}(navigator.userAgent.toLowerCase()), 
onKeyup: function(e){ 
var container = this.container, input = this.input, iCls = this.itemCls, aCls = this.activeCls; 
if(this.visible){ 
switch(e.keyCode){ 
case 13: // Enter 
if(this.active){ 
input.value = this.active.firstChild.data; 
this.hide(); 
} 
return; 
case 38: // 方向键上 
if(this.active==null){ 
this.active = container.lastChild; 
this.attr(this.active, 'class', aCls); 
input.value = this.active.firstChild.data; 
}else{ 
if(this.active.previousSibling!=null){ 
this.attr(this.active, 'class', iCls); 
this.active = this.active.previousSibling; 
this.attr(this.active, 'class', aCls); 
input.value = this.active.firstChild.data; 
}else{ 
this.attr(this.active, 'class', iCls); 
this.active = null; 
input.focus(); 
input.value = input.getAttribute("curr_val"); 
} 
} 
return; 
case 40: // 方向键下 
if(this.active==null){ 
this.active = container.firstChild; 
this.attr(this.active, 'class', aCls); 
input.value = this.active.firstChild.data; 
}else{ 
if(this.active.nextSibling!=null){ 
this.attr(this.active, 'class', iCls); 
this.active = this.active.nextSibling; 
this.attr(this.active, 'class', aCls); 
input.value = this.active.firstChild.data; 
}else{ 
this.attr(this.active, 'class', iCls); 
this.active = null; 
input.focus(); 
input.value = input.getAttribute("curr_val"); 
} 
} 
return; 
} 
// 烈火網 liehｕｏ．ｎｅt 欢迎复制,拒绝恶意采集 ｖｅｒｙｈｕｏ．ＣＯｍ 
} 
if(e.keyCode==27){ // ESC键 
this.hide(); 
input.value = this.attr(input,'curr_val'); 
return; 
} 
if(input.value.indexOf('@')!=-1){return;} 
this.items = []; 
if(this.attr(input,'curr_val')!=input.value){ 
this.container.innerHTML = ''; 
for(var i=0,len=this.data.length;i<len;i++){ 
var item = this.$C('div'); 
this.attr(item, 'class', this.itemCls); 
item.innerHTML = input.value + '@' + this.data[i]; 
this.items[i] = item; 
this.container.appendChild(item); 
} 
this.attr(input,'curr_val',input.value); 
} 
this.show(); 
}, 
onMouseover: function(){ 
var _this = this, icls = this.itemCls, acls = this.activeCls; 
this.on(this.container,'mouseover',function(e){ 
var target = e.target || e.srcElement; 
if(target.className == icls){ 
if(_this.active){ 
_this.active.className = icls; 
} 
target.className = acls; 
_this.active = target; 
} 
}); 
}, 
onMousedown: function(){ 
var _this = this; 
this.on(this.container,'mousedown',function(e){ 
var target = e.target || e.srcElement; 
_this.input.value = target.innerHTML; 
_this.hide(); 
}); 
} 
} 
//onload=register;//只把函数名给它，表示这个函数；
window.onload=function(){
register();
var sinaSuggest = new InputSuggest({ 
input: document.getElementById('sina'), 
data: ['sina.cn','sina.com','qq.com','sina.com','126.com','163.com'] 
}); 
}