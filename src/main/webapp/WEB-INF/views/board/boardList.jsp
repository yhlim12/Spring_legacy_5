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
		<div class="row">
			<h1>${board}List</h1>
			<form class="col-xs-6" action="./${board}List">
					<select class="form-control" id="sel1" name="kind">
						<option value="bt">Title</option>
						<option value="bc">Contents</option>
						<option value="bw">Writer</option>
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
					<td>NUM</td>
					<td>TITLE</td>
					<td>WRITER</td>
					<td>DATE</td>
					<td>HIT</td>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.num}</td>
						<td>
						
						<c:catch>
						<!-- for(int i=0; i<1 i++ -->
							<c:forEach begin="1" end="${vo.depth}" >
								--
							</c:forEach>
						</c:catch>
						<a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.regDate}</td>
						<td>${vo.hit}</td>
					</tr>
				</c:forEach>

			</table>

			<div>
				<ul class="pagination">
					<c:if test="${pager.curBlock gt 1}">
						<li><a
							href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li><a
							href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					<c:if test="${pager.curBlock lt pager.totalBlock}">
						<li><a
							href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
					</c:if>
				</ul>
			</div>

			<div>
				<a href="./${board}Write" class="btn btn-danger">WRITE</a>
				
				<c:catch>
				<c:choose>
					<c:when test="${board eq 'notice'}">
						<c:if test="${member.id eq 'admin'}">
							<div>
								<a href="./${board}Write" class="btn btn-danger">WRITE</a>
							</div>
						</c:if>
						</c:when>
					<c:otherwise>
						<c:if test="${not empty member}">
							<div>
								<a href="./${board}Write" class="btn btn-danger">WRITE</a>
							</div>
						</c:if>
					</c:otherwise>
				</c:choose>
				</c:catch>
			</div>

		</div>
	</div>

</body>
</html>