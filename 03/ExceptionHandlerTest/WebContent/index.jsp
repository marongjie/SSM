<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常处理示例</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
       $(function(){
    	   $("#btn").click(function(){
    			  $.post("${pageContext.request.contextPath}/search",null,
    						function(data){ 
    				// 处理异常
    					if (data.message)
    					{
    						alert("与服务器交互出现异常：" + data.message);
    					}
    					else
    					{
    						// 获取服务器响应，将所有图书显示在页面
    						
    					}
    				},"json");
  				});
       })
	</script>
</head>
<body>
<a href="test">@ExceptionHandler处理异常</a><br><br>
<hr>
<a href="login">UserController：父级Controller异常处理</a><br><br>
<a href="find">BookController：父级Controller异常处理</a><br><br>
</body>
</html>