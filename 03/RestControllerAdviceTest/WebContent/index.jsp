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
    	   $("#search").click(function(){
    			  $.post("${pageContext.request.contextPath}/search",null,
    						function(data){ 
    				// 处理异常
    					if (data.message)
    					{
    						alert("与服务器交互出现异常：" + data.message);
    					}
    					else
    					{
    						// 获取服务器响应，显示所有订单信息
    						
    					}
    				},"json");
  				});
       })
	</script>
</head>
<body>
<br>
<button id="search">查询订单（返回JSON）</button>
</body>
</html>