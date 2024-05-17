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
			<table border="1">
	            <tr>
	                <td>
	                    <span>예약번호</span>
	                </td>
	                <td>
	                    <span>대여기간</span>
	                </td>
	                <td>
	                    <span>대여지역</span>
	                </td>
	                <td>
	                    <span>차량명</span>
	                </td>
	                <td>
	                    <span>대여금액</span>
	                </td>
	                <td>
	                    <span>예약 취소/수정</span>
	                </td>
	            </tr>
				<c:forEach var="reserve" items="${reserveList }">
		            <tr>
		                <td>
							<a href="/read/car?code=${reserve.carCode }">
								<div>${reserve.number}</div>
							</a>
		                </td>
		                <td>
							<a href="/read/car?code=${reserve.carCode }">
								<div>${reserve.renDate}</div>
								<div>${reserve.returnDate}</div>
							</a>
		                </td>
		                <td>
							<a href="/read/car?code=${reserve.carCode }">
								<div>${reserve.location}</div>
							</a>
		                </td>
		                <td>
							<a href="/read/car?code=${reserve.carCode }">
								<div>${reserve.carModel}</div>
							</a>
		                </td>
		                <td>
							<a href="/read/car?code=${reserve.carCode }">
								<div>${reserve.price}원</div>
							</a>
		                </td>
		                <td>
							<button onclick="location.href='/searchUpdateAction?number=${reserve.number}&button=수정'" id="update-reservation">수정</button>
							<button onclick="location.href='/searchUpdateAction?number=${reserve.number}&button=삭제'" id="delete-reservation">취소</button>
		                </td>
		            </tr>
				</c:forEach>
	        </table>
		</div>
		<button id="deleteUser" onclick="location.href='/delete'">회원 탈퇴</button>
	</section>
</body>
<c:import url="/footer" />
</html>