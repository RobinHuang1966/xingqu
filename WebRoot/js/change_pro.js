function change_pro(n)
{
	var i=document.getElementById("list_kind").childNodes.length;
	for(var i=1;i<=3;i++)
	{
		document.getElementById('pro_detail'+i).style.display='none';
		document.getElementById('kind'+i).className='none';
	}
	document.getElementById('pro_detail'+n).style.display='block';
	document.getElementById('kind'+n).className='cur';
	
}// JavaScript Document