window.onload=function(){
	var imgs=document.getElementById("pic_pro");
	var list=document.getElementById("pic_list");
	var imgbox=list.getElementsByTagName("li");
	var numList=document.getElementById("pic_num");
	var num=numList.getElementsByTagName("li");
	var timer=play=null;
	var i=index=0;
	for(i=0;i<num.length;i++){
		num[i].index=i;
		num[i].onmouseover=function(){
			show(this.index);
			}
		}
	//鼠标划过关闭定时器
	pic_pro.onmouseover=function(){
		clearInterval(play);
		};
	//鼠标离开启动自动播放
	pic_pro.onmouseout=function(){
		autoplay();
		};
	function autoplay(){
		play=setInterval(function(){
								 index++;
								 index >= imgbox.length && (index=0);
								 show(index);
								  },4000);
		}
		autoplay();
	function show(a){
		index = a;
		var alpha = 0;
		for (i = 0; i < num.length; i++)
		num[i].className = "";
		num[index].className = "current";
		clearInterval(timer);			
		
		for (i = 0; i < imgbox.length; i++)
		{
			imgbox[i].style.opacity = 0;
			imgbox[i].style.filter = "alpha(opacity=0)";	
		}
		
		timer = setInterval(function () {
			alpha += 2;
			alpha > 100 && (alpha =100);
			imgbox[index].style.opacity = alpha / 100;
			imgbox[index].style.filter = "alpha(opacity = " + alpha + ")";
			alpha == 100 && clearInterval(timer)
		},20);
	}
		
	}