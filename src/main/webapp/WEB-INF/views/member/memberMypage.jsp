<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1>Id : ${sessionScope.member.id}</h1>
	<h1>Name : ${sessionScope.member.name}</h1>
	<h1>Email : ${sessionScope.member.email}</h1>
	<h1>Phone : ${sessionScope.member.phone}</h1>
	<h1>Age : ${sessionScope.member.age}</h1>
	<h1>
		<div><a href="./fileDelete">File Delete</a></div>
		<img alt="" src="../resources/memberUpload/${member.memberFileVO.filename}">
	
	</h1>
	
	<button class="btn btn-primary" id="update">Update</button>
	<button class="btn btn-danger" id="del">Delete</button>
	

<script type="text/javascript">
	$("#del").click(function(){
		var check = confirm("삭제 하시겠습니까?");
		
		if(check){
			//location.href="./memberDelete?id=${sessionScope.member.id}";
			location.href="./memberDelete?id=${member.id}";
		}
	})	
	$("#update").click(function() {
		location.href="./memberUpdate";
	
	});
		
</script>
</body>
</html>