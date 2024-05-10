<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<c:import url="/header" />
<script src="/resources/script/validation-post.js"></script>
<body>
	<section id="post">
		<c:if test="${empty sessionScope.user}">
			<c:redirect url="/login" />
		</c:if>
		<form method="POST" action="/updatePostAction">
			<div>
				<input type="text" id="title-new" name="title-new" value="${board.title }">
				<input type="text" id="content-new" name="content-new" value="${board.content }">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-title">제목을 작성해주세요.</p>
				<p class="error-msg" id="error-msg-content">내용을 작성해주세요.</p>
			</div>
			
			<input type="submit" value="수정완료">
		</form>
	</section>
</body>
<c:import url="/footer" />
</html>