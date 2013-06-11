<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="js/jquery-1.6.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/menu/jquery.ztree.core-3.2.min.js"></script>
<script type="text/javascript">
	var tNode;
	$(document).ready(function() {
	$.ajax({
			type:"post",
			url:"menu.do",
			dateType:"json",
			async: false, 
			date:{"parent":parent},
			success:function(menuData)
			{
				alert("success");
				tNode = eval(menuData);
				alert(tNode);
			},
			error:function() 
			{
				alert("error");
			}
		});
		
		var setting = {
				view:{
					showLine:false
				}}
		alert(tNode);
		var zNodes =[
			{ id:1, pId:0, name:"���˵� 1", open:true},
			{ id:11, pId:1, name:"�Ӳ˵� 1-1"},
			{ id:111, pId:11, name:"Ҷ�ӽڵ� 1-1-1"},
			{ id:112, pId:11, name:"Ҷ�ӽڵ� 1-1-2"},
			{ id:113, pId:11, name:"Ҷ�ӽڵ� 1-1-3"},
			{ id:114, pId:11, name:"Ҷ�ӽڵ� 1-1-4"},
			{ id:12, pId:1, name:"�Ӳ˵� 1-2"},
			{ id:121, pId:12, name:"Ҷ�ӽڵ� 1-2-1"},
			{ id:122, pId:12, name:"Ҷ�ӽڵ� 1-2-2"},
			{ id:123, pId:12, name:"Ҷ�ӽڵ� 1-2-3"},
			{ id:124, pId:12, name:"Ҷ�ӽڵ� 1-2-4"},
			{ id:2, pId:0, name:"���˵� 2"},
			{ id:21, pId:2, name:"�Ӳ˵� 2-1"},
			{ id:211, pId:21, name:"Ҷ�ӽڵ� 2-1-1"},
			{ id:212, pId:21, name:"Ҷ�ӽڵ� 2-1-2"},
			{ id:213, pId:21, name:"Ҷ�ӽڵ� 2-1-3"},
			{ id:214, pId:21, name:"Ҷ�ӽڵ� 2-1-4"},
			{ id:22, pId:2, name:"�Ӳ˵� 2-2"},
			{ id:221, pId:22, name:"Ҷ�ӽڵ� 2-2-1"},
			{ id:222, pId:22, name:"Ҷ�ӽڵ� 2-2-2"},
			{ id:223, pId:22, name:"Ҷ�ӽڵ� 2-2-3"},
			{ id:224, pId:22, name:"Ҷ�ӽڵ� 2-2-4"},
			{ id:3, pId:0, name:"���˵� 3"},
			{ id:31, pId:3, name:"�Ӳ˵� 3-1"},
			{ id:311, pId:31, name:"Ҷ�ӽڵ� 3-1-1"},
			{ id:312, pId:31, name:"Ҷ�ӽڵ� 3-1-2"},
			{ id:313, pId:31, name:"Ҷ�ӽڵ� 3-1-3"},
			{ id:314, pId:31, name:"Ҷ�ӽڵ� 3-1-4"},
			{ id:32, pId:3, name:"�Ӳ˵� 3-2"},
			{ id:321, pId:32, name:"Ҷ�ӽڵ� 3-2-1"},
			{ id:322, pId:32, name:"Ҷ�ӽڵ� 3-2-2"},
			{ id:323, pId:32, name:"Ҷ�ӽڵ� 3-2-3"},
			{ id:324, pId:32, name:"Ҷ�ӽڵ� 3-2-4"}			
		];
		$.fn.zTree.init($("#menuTree"), setting, zNodes);
	});
</script>
</head>
<body>
<div id="menu" class="menuTree"> 
	<ul id="menuTree" class="ztree"></ul>
</div>
</body>
</html>
