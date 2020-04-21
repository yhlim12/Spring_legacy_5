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
	  <div class="panel panel-primary">
      <div class="panel-heading">Title</div>
      <div class="panel-body"><h2>${vo.title}</h2></div>
    </div>
	
	  <div class="panel panel-primary">
      <div class="panel-heading">Writer</div>
      <div class="panel-body"><h2>${vo.writer}</h2></div>
    </div>
	
	  <div class="panel panel-primary">
      <div class="panel-heading">Contents</div>
      <div class="panel-body"><h2>${vo.contents}</h2></div>
    </div>
	
		
	</div>
	
	
	
	<div class="container">
		<a href="./${board}Update?num=${vo.num}" class="btn btn-primary">Update</a>
		<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger">Delete</a>
		<c:if test="${board ne 'notice'}">
			<a href="./${board}Reply?num=${vo.num}" class="btn btn-info">Reply</a>
		</c:if>
	</div>
	
</body>
</html>