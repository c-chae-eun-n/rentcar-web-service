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
		<div id="search-container">
			<form id="search-date" action="/searchCar">
		        <select id="location" name="location">
		            <option selected value="all">지역</option>
		            <option value="서울">서울</option>
		            <option value="경기">경기</option>
		            <option value="부산">부산</option>
		            <option value="제주">제주</option>
		        </select>
		        <span>대여일</span><input type="date" name="ren-date" id="ren-date" value="${renDate }"> 
				<select name="ren-time" id="ren-time">
					<option disabled selected>대여시간</option>
					<option value="07:00:00" ${renTime eq '07:00:00' ? 'selected':''}>07:00</option>
					<option value="08:00:00" ${renTime eq '08:00:00' ? 'selected':''}>08:00</option>
					<option value="09:00:00" ${renTime eq '09:00:00' ? 'selected':''}>09:00</option>
					<option value="10:00:00" ${renTime eq '10:00:00' ? 'selected':''}>10:00</option>
					<option value="11:00:00" ${renTime eq '11:00:00' ? 'selected':''}>11:00</option>
					<option value="12:00:00" ${renTime eq '12:00:00' ? 'selected':''}>12:00</option>
					<option value="13:00:00" ${renTime eq '13:00:00' ? 'selected':''}>13:00</option>
					<option value="14:00:00" ${renTime eq '14:00:00' ? 'selected':''}>14:00</option>
					<option value="15:00:00" ${renTime eq '15:00:00' ? 'selected':''}>15:00</option>
					<option value="16:00:00" ${renTime eq '16:00:00' ? 'selected':''}>16:00</option>
					<option value="17:00:00" ${renTime eq '17:00:00' ? 'selected':''}>17:00</option>
					<option value="18:00:00" ${renTime eq '18:00:00' ? 'selected':''}>18:00</option>
					<option value="19:00:00" ${renTime eq '19:00:00' ? 'selected':''}>19:00</option>
					<option value="20:00:00" ${renTime eq '20:00:00' ? 'selected':''}>20:00</option>
					<option value="21:00:00" ${renTime eq '21:00:00' ? 'selected':''}>21:00</option>
					<option value="22:00:00" ${renTime eq '22:00:00' ? 'selected':''}>22:00</option>
				</select> 
				<span>반납일</span><input type="date" name="return-date" id="return-date" value="${returnDate }"> 
				<select name="return-time" id="return-time">
					<option disabled selected>반납시간</option>
					<option value="07:00:00" ${returnTime eq '07:00:00' ? 'selected':''}>07:00</option>
					<option value="08:00:00" ${returnTime eq '08:00:00' ? 'selected':''}>08:00</option>
					<option value="09:00:00" ${returnTime eq '09:00:00' ? 'selected':''}>09:00</option>
					<option value="10:00:00" ${returnTime eq '10:00:00' ? 'selected':''}>10:00</option>
					<option value="11:00:00" ${returnTime eq '11:00:00' ? 'selected':''}>11:00</option>
					<option value="12:00:00" ${returnTime eq '12:00:00' ? 'selected':''}>12:00</option>
					<option value="13:00:00" ${returnTime eq '13:00:00' ? 'selected':''}>13:00</option>
					<option value="14:00:00" ${returnTime eq '14:00:00' ? 'selected':''}>14:00</option>
					<option value="15:00:00" ${returnTime eq '15:00:00' ? 'selected':''}>15:00</option>
					<option value="16:00:00" ${returnTime eq '16:00:00' ? 'selected':''}>16:00</option>
					<option value="17:00:00" ${returnTime eq '17:00:00' ? 'selected':''}>17:00</option>
					<option value="18:00:00" ${returnTime eq '18:00:00' ? 'selected':''}>18:00</option>
					<option value="19:00:00" ${returnTime eq '19:00:00' ? 'selected':''}>19:00</option>
					<option value="20:00:00" ${returnTime eq '20:00:00' ? 'selected':''}>20:00</option>
					<option value="21:00:00" ${returnTime eq '21:00:00' ? 'selected':''}>21:00</option>
					<option value="22:00:00" ${returnTime eq '22:00:00' ? 'selected':''}>22:00</option>
				</select>
		        <input type="submit" value="차량검색">
		    </form>
		</div>
		<div class="filter-container">
			<div>
				<p>자동차모델</p>
				<div>
					<form id="search-carModel" action="/searchModel">
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
			<c:if test="${empty carList }">
				<span>검색 결과가 존재하지 않습니다.</span>
			</c:if>
			<c:forEach var="car" items="${carList }">
				<div id="car-container">
					<c:choose>
						<c:when test="${car.reservation }">
							<div>
								<div id="car-image"><img src="https://d1masd123hbmlx.cloudfront.net/20211025062033_753_CARMST/20211025062033_753_CARMST_804.png" width="250" height="110"></div>
								<div>${car.model}(${car.carClass}) 예약불가</div>
							</div>
							<div>
								<div>${car.price }</div>
								<div>${car.seater }</div>
							</div>
						</c:when>
						<c:otherwise>
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
						</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>
		</div>
		
	</section>
</body>
<c:import url="/footer" />
</html>