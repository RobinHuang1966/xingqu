function changepro(n)
{
	var i=document.getElementById("pro_kind").childNodes.length;
	for(var i=1;i<=4;i++)
	{
		document.getElementById('list_detail'+i).style.display='none';
		document.getElementById('pro_kind'+i).className='none';
	}
	document.getElementById('list_detail'+n).style.display='block';
	document.getElementById('pro_kind'+n).className='cur';
	
}