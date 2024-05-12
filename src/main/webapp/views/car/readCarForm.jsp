<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<script src="/resources/script/validation-date.js"></script>
<body>
	<section id="root">
		<div>
			<div>
				<div id="car-image"><img src="https://d1masd123hbmlx.cloudfront.net/20211025062033_753_CARMST/20211025062033_753_CARMST_804.png" width="250" height="110"></div>
				<div>${car.model}(${car.carClass})</div>
			</div>
			<div>
				<div>${car.price }</div>
				<div>${car.fuel }</div>
				<div>${car.seater }</div>
			</div>
			<button id="reservation" onclick="location.href='/reservation'">예약하기</button>
		</div>
	</section>
</body>
<c:import url="/footer" />
</html>