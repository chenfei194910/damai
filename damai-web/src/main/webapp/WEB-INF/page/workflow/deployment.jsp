<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>layui</title>
<link rel="stylesheet" href="../static/layui/css/layui.css">

</head>
<body>

<script src="../static/layui/layui.js"></script>
<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.msg('Hello World');
});
</script> 

	<div>
		<table>
			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>部署时间</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="data" items="${dataList}">
					<tr>
						<td>${data.id}</td>
						<td>${data.name}</td>
						<td>${data.deploymentTime}</td>
						<td>${data.category}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>