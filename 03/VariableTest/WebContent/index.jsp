<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理请求URL注解测试</title>
</head>
<body>
<h2>处理请求URL注解测试</h2>
<a href="pathVariableTest/1">测试@PathVariable注解</a><br><br>
<a href="matrixVariableTest/1;name=jack;age=23">测试@MatrixVariable注解</a><br><br>
<a href="productTest/computer;brand=apple,acer;low=2000;height=10000">商品条件查询（品牌，价格区间）</a><br><br>
<a href="http://localhost:8080/CrossOriginTest/welcome">测试@CrossOrigin注解</a><br><br>
</body>
</html>