function changeorder(n)
{
	var i=document.getElementById("order_list").childNodes.length;
	for(var i=1;i<=4;i++)
	{
		document.getElementById('order'+i).style.display='none';
		document.getElementById('order_list'+i).className='none';
	}
	document.getElementById('order'+n).style.display='block';
	document.getElementById('order_list'+n).className='cur';
	
}