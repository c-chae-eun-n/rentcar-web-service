<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<c:import url="/header" />
<script src="/resources/script/validation-search.js"></script>
<body>
	<section id="root">
		<div class="filter-container">
			<div>
				<p>자동차모델</p>
				<div>
					<form action="/search/model">
						<div>
							<input type="text" id="car-model" name="car-model">
							<input type="submit" value="검색">
						</div>
						<div class="error-container">
							<p class="error-msg" id="error-msg-search">검색어를 입력해주세요.</p>
						</div>
					</form>
				</div>
			</div>
			<div>
				<p>차량등급</p>
				<div id="radio-container">
					<input type="radio" class="car-class" id="smaller" name="car-class" value="경형">경형
					<input type="radio" class="car-class" id="small" name="car-class" value="소형">소형
					<input type="radio" class="car-class" id="s-midium" name="car-class" value="준중형">준중형
					<input type="radio" class="car-class" id="midium" name="car-class" value="중형">중형
					<input type="radio" class="car-class" id="big" name="car-class" value="대형">대형
					<input type="radio" class="car-class" id="suv" name="car-class" value="suv">SUV
					<input type="radio" class="car-class" id="income" name="car-class" value="수입">수입
				</div>
			</div>
			<div>
				<p>연료</p>
				<div id="radio-container">
					<input type="radio" class="fuel" id="gasoline" name="fuel" value="휘발유">휘발유
					<input type="radio" class="fuel" id="diesel" name="fuel" value="경유">경유
					<input type="radio" class="fuel" id="lpg" name="fuel" value="LPG">LPG
					<input type="radio" class="fuel" id="elec" name="fuel" value="전기">전기
					<input type="radio" class="fuel" id="hybrid" name="fuel" value="하이브리드">하이브리드
				</div>
			</div>
			<div>
				<p>가격</p>
				<input type="range" min="0" max="500000" name="range">
			</div>
		</div>
		<div class="carList-container">
			<c:forEach var="car" items="${carList }">
				<div id="car-container">
					<a href="/read/car?code=${car.carCode }">
						<div>
							<div id="car-image"><img src="https://d1masd123hbmlx.cloudfront.net/20211025062033_753_CARMST/20211025062033_753_CARMST_804.png" width="250" height="110"></div>
							<div>${car.model}(${car.carClass})</div>
						</div>
						<div>
							<div>${car.price }</div>
							<div>${car.seater }</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
		
	</section>
</body>
<c:import url="/footer" />
</html>