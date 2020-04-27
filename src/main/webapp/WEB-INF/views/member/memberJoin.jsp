<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
		<h2>member Join Form</h2>
		<form action="./memberJoin" method="POST" enctype="multipart/form-data">

			<div class="form-group">
				<label for="id">ID:</label> <input type="text" class="form-control"
					id="id" placeholder="Enter title" name="id">
			</div>

			<div class="form-group">
				<label for="password">PASSWORD:</label> <input type="text"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>

			<div class="form-group">
				<label for="name">name:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name"
					name="name">
			</div>
			
			<div class="form-group">
				<label for="phone">phone:</label> <input type="text"
					class="form-control" id="phone" placeholder="Enter phone"
					name="phone">
			</div>
			
				<div class="form-group">
				<label for="email">email:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			
			<div class="form-group">
				<label for="age:">age:</label> <input type="text"
					class="form-control" id="age" placeholder="Enter age:"
					name="age">
			</div>
			
			<div class="form-group">
				<label for="pic:">Avatar:</label> <input type="file"
					class="form-control" id="avatar" placeholder="Enter age:"
					name="avatar">
			</div>
			

			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

<script type="text/javascript">
	$("#id").blur(function() {
		var id = $("#id").val();
	/* 	$.post("./memberIdCheck",{id:id}, function(result) {
			result = result.trim();
			if(result==0){
				alert("이미 존재하는 아이디입니다.");
			}else{
				alert("사용가능한 아이디입니다.")
			}
		}); */
		
		$.ajax({
			type: "post",	//method 형식
			url: "./memberIdCheck" ,//URL 주소
			data : {
				id:id
			}, //parameter 
			success : function(data){
				alert(data);
			},
			error : function () {
				alert("error 발생");
			}
		});
		
	});
	
	
</script>


</body>
</html>