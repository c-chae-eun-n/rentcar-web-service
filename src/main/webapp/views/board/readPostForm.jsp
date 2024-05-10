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
	<section id="root-board">
		<div class="post-container">
			<table class="post-table">
				<c:if test="${not empty board }">
					<span>${board.userId}</span>
					<span><fmt:formatDate value="${board.write_date}" pattern="yy-MM-dd HH:mm" /></span>
					<c:if test="${board.write_date != board.mod_date}">
						<span><fmt:formatDate value="${board.mod_date}" pattern="yy-MM-dd HH:mm" /></span>
					</c:if>
					<tbody>
						<tr>
							<td>제목</td>
							<td>${board.title}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>${board.content}</td>
						</tr>
					</tbody>
				</c:if>
			</table>
		</div>
		<c:if test="${not empty user and user.id eq board.userId or 'Admin'}">
			<button id="update" onclick="location.href='/updatePost'">수정</button>
			<button id="delete" onclick="location.href='/deletePostAction'">삭제</button>
		</c:if>
		
	</section>
</body>
<c:import url="/footer" />
</html>