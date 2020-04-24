<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
		<h2>${board} Update Form</h2>
		<form action="./${board}Update" method="POST">
		
			<div class="form-group">
				<label for="num">NUM:</label> <input type="hidden" class="form-control"
					id="num" readonly="readonly" value="${vo.num}" name="num">
			</div>

			
			<div class="form-group">
				<label for="TITLE">TITLE:</label> <input type="text" class="form-control"
					id="title" placeholder="Enter title" value="${vo.title}" name="title">
			</div>
			
				<div class="form-group">
				<label for="writer">writer:</label> <input type="text" class="form-control"
					id="writer" placeholder="Enter writer" disabled="disabled"" value="${vo.writer}" name="writer">
			</div>

			<div class="form-group">
				<label for="contents">CONTENTS:</label> <textarea class="form-control"
				 id="contents" placeholder="Enter contents" name="contents">${vo.contents}</textarea>
			</div>

		
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		
	</div>
		<script type="text/javascript">
			// $("선택자 ").action();
		  $('#contents').summernote({
			  lang: 'ko-KR'
		 });
		</script>

</body>
</html>