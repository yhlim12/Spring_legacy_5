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
		<h2>${board} Write Form</h2>
		<form action="./${board}Write" id="frm"  method="POST" enctype = multipart/form-data>

			<div class="form-group">
				<label for="TITLE">TITLE:</label> <input type="text" class="form-control"
					id="title" placeholder="Enter title" name="title">
			</div>

			<div class="form-group">
				<label for="writer">WRITER:</label> <input type="text"
					class="form-control" id="writer"  placeholder="Enter writer"
					name="writer">
			</div>	

			<div class="form-group">
				<label for="contents">CONTENTS:</label> <textarea class="form-control"
				row="20" id="contents" name="contents"></textarea>
			</div>
			
			<input type="button" id="add" class="btn btn-info" value="AddFile">
			
			<div id="file">
				
			</div>
			
			 
			<!-- contents Server null이 될때 -->
			<!-- <input type ="hidden" name="contents" id="con"> -->
			
			<button type="button" id="btn" class="btn btn-default">Submit</button>
		</form>
	</div>

<!-- <script type="text/javascript" src="../resources/js/boardForm.js">

</script>	
 -->
 <script type="text/javascript">
	 $('#contents').summernote({
	 height : 400,
	callbacks:{
		  onImageUpload : function(files){
			 $.ajax({
				 type:"post",
				 url:"../boardFile/fileInsert",
				 enctype:"multipart/form-data",
				 cache:false,
				 contentType:false,
				 processData:false,
				 success: function(imageName){
					 
				 }
			 });
		  }
	 }
	});
 </script>
 


</body>
</html>