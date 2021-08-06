<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Html 폼에 데이터를 바인딩하거나 또는 에러메세지 처리 등을 간편하게 해준다. -->
	<!-- method: 전송방식, action: 전송목적지, enctype: 전송되는 데이터 형식(multipart/form-data : 파일이나 이미지를 서버로 전송할 경우 이 방식 사용), modelAttribute: 폼에 있는 요소들의 값을 채우기 위해서 사용될 객체를 request로부터 찾을 때 사용할 이름 지정 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h1>UPLOAD FORM</h1>
		file<br/>
		<input type="file" name="mpfile" /><br/>
		<p style="color: red; font-weight: bold;">
			<form:errors path="mpfile" />     <!-- 생성한 validator를 통해 입력값의 유효성 체크 후 에러메세지 출력 -->
		</p>
		<br>
		description<br/>
		<textarea rows="10" cols="60" name="desc"></textarea>
		<input type="submit" value="send" />
	</form:form>
	
	<!-- 
	form tag의 enctype의 속성
		1. application/www-form-urlencoded: 문자들이 encoding 됨 (default)
		2. multipart/form-data : file upload 가능 (post)
		3. text/plain : encoding하지 않음
		
	spring form tag
		form:errors -> Errors, BindingResult를 사용할 때, command 객체의 특정 field에서 발생하는 에러메시지 출력 가능
	 -->
	
</body>
</html>