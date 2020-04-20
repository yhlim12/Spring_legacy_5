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

<div class="container">
		<div class="row">
			<h1>memberList</h1>
			
			<form class="col-xs-6" action="./memberList">
					<select class="form-control" id="sel1" name="kind">
						<option value="id">ID</option>
						<option value="na">NAME</option>
						<option value="ph">PHONE</option>
						<option value="em">EMAIL</option>
				
					</select>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>

			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
					</tr>
				</c:forEach>

			</table>
			<div>
				<ul class="pagination">
					<c:if test="${memberPager.curBlock gt 1}">
						<li><a
							href="./memberList?curPage=${memberPager.startNum-1}&kind=${memberPager.kind}&search=${memberPager.search}">이전</a></li>
					</c:if>
					<c:forEach begin="${memberPager.startNum}" end="${memberPager.lastNum}" var="i">
						<li><a
							href="./memberList?curPage=${i}&kind=${memberPager.kind}&search=${memberPager.search}">${i}</a></li>
					</c:forEach>
					<c:if test="${memberPager.curBlock lt memberPager.totalBlock}">
						<li><a
							href="./memberList?curPage=${memberPager.lastNum+1}&kind=${memberPager.kind}&search=${memberPager.search}">다음</a></li>
					</c:if>
				</ul>
			</div>
			
	</div>


</body>
</html>