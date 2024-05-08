<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<c:if test="${empty sessionScope.user}">
		<c:redirect url="/login" />
	</c:if>

	<section id="root-mypage">
		<h3>${user.name}님</h3>
		<button id="updateUser" onclick="location.href='/update'">회원정보 수정</button>
		<div class="reservation-container">
		</div>
		<button id="deleteUser" onclick="location.href='/delete'">회원 탈퇴</button>
	</section>
</body>
<c:import url="/footer" />
</html>