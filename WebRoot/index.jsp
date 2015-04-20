<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <label for="name">name:</label>
    <input type="text" id="data" />
    <button id="xionglulu">publish</button>
    <script>
    $("#xionglulu").on("click",function(){
    	$.ajax({
	    	url:'push/push',
	    	data:{data:$("#data").val()},
	    	type:"get",
	    	success:function(data){
	    		alert(data.msg);
	    	},
	    	error:function(data){
	    	}
	    });
    });
    
    </script>
  </body>
</html>
