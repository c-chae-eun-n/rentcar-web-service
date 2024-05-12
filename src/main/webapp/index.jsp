<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header" />
<script src="/resources/script/validation-search.js"></script>
<body>
	<h1>Welcome ShinShincar</h1>
	
	<div id="search-container">
		<form action="/searchCar">
	        <select id="location" name="location">
	            <option selected value="all">지역</option>
	            <option value="서울">서울</option>
	            <option value="경기">경기</option>
	            <option value="부산">부산</option>
	            <option value="제주">제주</option>
	        </select>
	        <span>대여일</span><input type="date" name="ren-date" id="ren-date"> 
			<select name="ren-time" id="ren-time">
				<option disabled selected>대여시간</option>
				<option value="07:00:00">07:00</option>
				<option value="08:00:00">08:00</option>
				<option value="09:00:00">09:00</option>
				<option value="10:00:00">10:00</option>
				<option value="11:00:00">11:00</option>
				<option value="12:00:00">12:00</option>
				<option value="13:00:00">13:00</option>
				<option value="14:00:00">14:00</option>
				<option value="15:00:00">15:00</option>
				<option value="16:00:00">16:00</option>
				<option value="17:00:00">17:00</option>
				<option value="18:00:00">18:00</option>
				<option value="19:00:00">19:00</option>
				<option value="20:00:00">20:00</option>
				<option value="21:00:00">21:00</option>
				<option value="22:00:00">22:00</option>
			</select> 
			<span>반납일</span><input type="date" name="return-date" id="return-date"> 
			<select name="return-time" id="return-time">
				<option disabled selected>반납시간</option>
				<option value="07:00:00">07:00</option>
				<option value="08:00:00">08:00</option>
				<option value="09:00:00">09:00</option>
				<option value="10:00:00">10:00</option>
				<option value="11:00:00">11:00</option>
				<option value="12:00:00">12:00</option>
				<option value="13:00:00">13:00</option>
				<option value="14:00:00">14:00</option>
				<option value="15:00:00">15:00</option>
				<option value="16:00:00">16:00</option>
				<option value="17:00:00">17:00</option>
				<option value="18:00:00">18:00</option>
				<option value="19:00:00">19:00</option>
				<option value="20:00:00">20:00</option>
				<option value="21:00:00">21:00</option>
				<option value="22:00:00">22:00</option>
			</select>
	        <input type="submit" value="차량검색">
	    </form>
	</div>
</body>
<jsp:include page="/footer" />
</html>