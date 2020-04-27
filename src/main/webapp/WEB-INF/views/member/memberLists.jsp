<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
					<td><input type="checkbox" name="all" id=checkall><button class = "btn btn-danger" id="del">Delete</button></td>
				</tr>
				<c:forEach items="${list}" var="vo" varStatus="i">
					<tr>
						<td id="id${i.index}">${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
						<td><input type="checkbox" name="del" title="id${i.index}" id="${vo.id}" class=check> </td>
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