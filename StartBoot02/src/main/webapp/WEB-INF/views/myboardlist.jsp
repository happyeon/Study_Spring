<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>List</h1>
	
	<table border="1">
		<col width="50" />
		<col width="100" />
		<col width="500" />
		<col width="100" />
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">-------작성된 글 없어요---------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<!-- /myboard/select?myno=${dto.myno } -->
						<td><a href="select?myno=${dto.myno }">${dto.mytitle }</a></td>
						<td>${dto.mydate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right"><input type="button" value="글작성" onclick="location.href='/myboard/insertform'" /></td>
		</tr>
	</table>
	
	<!-- 
	[경로 설정]
	1. select?
		: 앞 부분에 사실 ./(현재위치) 가 포함되어 있음
		-> myboard/select?
		
	2. myboard/select?
		: 앞 부분에 사실 ./(현재위치) 가 포함되어 있음
		-> myboard/myboard/select
	
	3. /myboard/select?  (쌤 추천 방법)
		: / (최상위) 루트
		-> myboard/select
		
	/   : 최상위 루트
	./  : 현재 폴더, 나와 같은 위치
	../ : 상위 폴더, 부모 디렉터리
	
	 -->

</body>
</html>