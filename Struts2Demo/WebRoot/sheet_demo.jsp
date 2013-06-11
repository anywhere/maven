<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
     <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  		 <script type="text/javascript" src="http://www.google.com/jsapi"></script>
      	 <script src="js/jquery-1.6.1.js" type="text/javascript"></script>
   		 <script src="js/jquery.gvChart-1.0.1.min.js" type="text/javascript"></script>
   		 <script src="js/jquery.easyui.min.js" type="text/javascript"></script>
 
 <script type="text/javascript">
 		gvChartInit();
     jQuery(document).ready(function() {
      
     	$.ajax({
			type:"post",
			url:"jsonExcute.do",
			dateType:"json",
			success:function(data)
			{
				alert("success");
				var obj = jQuery.parseJSON(data);
				var monthString = "<caption>报表分析</caption><thead><tr><th></th>";
				var tbody1 = "<tbody><tr>td>实际完成</td>";
				var tbody2 = "<tr>计划任务</tr>";
				for(var i=0 ; i<obj.length; i++)
				{
				if(i ==  obj.length){
					monthString += "<th>"+obj[i].month+"</th></tr></thead>";
					tbody1 += "<td>"+obj[i].forecast+"</td></tr>";
					tbody2 += "<td>"+obj[i].income+"</td></tr></tbody>";
				}else{
					monthString += "<th>"+obj[i].month+"</th>";
					tbody1 += "<td>"+obj[i].forecast+"</td>";
					tbody2 += "<td>"+obj[i].income+"</td>";
				}
					
				}
				$("#myTable1").append(monthString+tbody1+tbody2);
				
				$("#myTable1").gvChart({
            	  chartType: 'AreaChart',//LineChart,BarChart,ColumnChart,PieChart,AreaChart
           		  gvSettings: {
                  vAxis: { title: '金额' },
                  hAxis: { title: '月份' },
                  width: 720,
                  height: 300
             }
         });
			},
			error:function() { alert("error")
			}
			});
     
       

     });
    
    </script>

    <style type ="text/css" >
        body
        {
            text-align: center;
            font-family: Arial, sans-serif;
            font-size: 12px;
        }
        a
        {
            text-decoration: none;
            font-weight: bold;
            color: #555;
        }
        a:hover
        {
            color: #000;
        }
        div.easyui-tabs 
        {
            margin: auto;
            text-align: left;
            width: 720px;
        }
        div.clean
        {
            border: 1px solid #850000;
        }
        .clean td, .clean th
        {
            border: 2px solid #bbb;
            background: #ddd;
            padding: 5px 10px;
            text-align: center;
            border-radius: 2px;
        }
        .clean table
        {
            margin: auto;
            margin-top: 15px;
            margin-bottom: 15px;
        }
        .clean caption
        {
            font-weight: bold;
        }
        .gvChart, .clean
        {
            border: 2px solid #850000;
            border-radius: 5px;
            -moz-border-radius: 10px;
            width: 720px;
            margin: auto;
            margin-top: 20px;
        }
        pre
        {
            background: #eee;
            padding: 10px;
            border-radius: 10px;
            -moz-border-radius: 10px;
        }
    </style>
</head>
<body>
  <div class="easyui-tabs" fit="true" plain="true" style="height:500px;width:800px;">
		<div title="Title1" style="padding:10px;">
			<h2 id="area">
                区域报表</h2>
            <table id='myTable1'>
                
            </table>
		</div>
	</div>
 <body>
  	
  </body>
</html>
