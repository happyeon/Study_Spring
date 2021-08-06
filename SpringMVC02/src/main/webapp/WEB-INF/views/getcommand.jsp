<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>GET</h1>
	
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>ADDRESS</th>
			<th>PHONE</th>
		</tr>
		<tr>
			<th>${dto.name }</th>
			<th>${dto.addr }</th>
			<th>${dto.phone }</th>
		</tr>
	</table>

</body>
</html>