<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<c:import url="/header" />
<script src="/resources/script/validation-login.js"></script>
<body>
	<section id="root">
		<h1>예약 취소</h1>
		<form method="POST" action="/deleteReservationAction">
			<div>
				예약자명<input type="text" id="id" name="id" value="${user.name}" disabled>
				<input type="password" id="password" name="password" placeholder="비밀번호 확인">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-id">아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password">비밀번호: 필수 정보입니다.</p>
			</div>
			<div>
				<h3>예약 취소 사유</h3>
				<input type="text" id="cancel" name="cancel">
				<input type="hidden" id="number" name="number" value="${reserve.number }">
			</div>
			
			<input type="submit" value="예약 취소">
		</form>
	</section>
</body>
</body>
<c:import url="/footer" />
</html>