<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		// javascript object
		var loginVal = {
				"memberid": memberid,   
				"memberpw": memberpw
		}
		
		if (memberid == null || memberid == "" || memberpw == null || memberpw == "") {
			alert("ID와 PW를 다시 확인해주세요!");
		} else {
			$.ajax({
				type: "post",
				url: "ajaxlogin.do",
				data: JSON.stringify(loginVal),			// data: controller로 전달하는 값, JSON.stringify(): json 형태의 문자열로 만듬
				contentType: "application/json",		// contentType은 request 헤더에 저장, 원래 request, response 객체는 기본적으로 문자열이다. 그런데 application/json은 넘어가는 request 객체가 json이라고 알려주고 있는 것이다.
				dataType: "json",
				success: function(msg){
					if (msg.check == true) {
						location.href="list.do";
					} else {
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW를 다시 확인해 주세요!");
					}
				},
				error: function(){
					alert("통신 실패");
				}
			});
		}
		
	}
	
	/*
	ajax는 비동기 통신
	@ResponseBody : 자바 객체를 response 객체에 바로 넣어서 받아줌
	이 때, jackson이 자동으로 response 객체에 담겨진 자바 객체를 json 형태로 만들어준다. 
	@RequestBody : requestbody에 json객체(문자열이 아닌 타입의 값)이 왔는데, 걔를 자바로 바꿔줌
	*/
	
</script>

</head>
<body>

	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login();" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>