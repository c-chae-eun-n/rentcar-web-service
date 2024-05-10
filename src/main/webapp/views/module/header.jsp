<%@page import="rentcarServer.user.model.UserResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="https://em-content.zobj.net/source/microsoft-teams/363/automobile_1f697.png">
<link rel="stylesheet" href="/resources/style/grid.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>씬씬카 ShinShincar</title>
</head>
<body>
	<header>
		<div id="logo"><a href="/">씬씬카</a></div>
		<nav id="nav-main">
			<ul>
				<li><a href="/readAllCarFormAction"><span>렌트카</span></a></li>
				<li><a href="/readAllFormAction"><span>게시판</span></a></li>
				<li><a href="/mypage"><span>마이페이지</span></a></li>
			</ul>
		</nav>
		<nav id="nav-sub">
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<li><a href="/logout"><span>로그아웃</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/login"><span>로그인</span></a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/join"><span>회원가입</span></a></li>
			</ul>
		</nav>
	</header>
</body>
</html>