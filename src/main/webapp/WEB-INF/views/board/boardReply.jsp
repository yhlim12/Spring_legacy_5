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
		<h2>${board} Reply Form</h2>
		<form action="./${board}Reply" method="POST">
			<input type="hidden" name ="num" value="${num}">
			<div class="form-group">
				<label for="TITLE">TITLE:</label> <input type="text" class="form-control"
					id="title" placeholder="Enter title" name="title">
			</div>

			<div class="form-group">
				<label for="writer">WRITER:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter writer"
					name="writer">
			</div>

			<div class="form-group">
				<label for="contents">CONTENTS:</label> <textarea class="form-control"
				row="10" id="contents" placeholder="Enter contents" name="contents"></textarea>
			</div>

		
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

	


</body>
</html>