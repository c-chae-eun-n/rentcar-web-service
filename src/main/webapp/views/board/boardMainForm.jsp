<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<section id="root-boardMain">
		<h1>게시판</h1>
		
		<div class="boardList-container">
			
			<table class="boardList-table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="board" items="${boardList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a href="/read/board?code=${board.code}">${board.title}</a></td>
							<td>${board.userId}</td>
							<td><fmt:formatDate value="${board.writeDate}" pattern="yy-MM-dd HH:mm" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<c:if test="${not empty sessionScope.user}">
			<button id="write" onclick="location.href='/post'">글쓰기</button>
		</c:if>
		
	</section>
</body>
<c:import url="/footer" />
</html>