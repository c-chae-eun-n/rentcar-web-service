<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<section id="root-boardMain">
		<h1>게시판</h1>

		<c:if test="${not empty sessionScope.user}">
			<button id="write" onclick="location.href='/'">글쓰기</button>
		</c:if>
		
		<div class="board-container">
			
		</div>
		
	</section>
</body>
<c:import url="/footer" />
</html>