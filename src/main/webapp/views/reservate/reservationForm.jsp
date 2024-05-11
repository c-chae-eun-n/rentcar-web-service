<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="/resources/style/form.css"> -->
</head>
<c:import url="/header" />
<script src="/resources/script/validation-join.js"></script>
<script src="/resources/script/validation-id.js"></script>
<body>
	<c:if test="${empty sessionScope.user}">
		<c:redirect url="/login" />
	</c:if>
	<section id="root">
		<form method="POST" action="/">
			<div class="reserve-container">
				<h1>실시간 예약</h1>
				<div id="reservation-info">
					<h3>예약 내역</h3>
					<div>
						<span>차량/상품명 </span>
						<span> ${car.model }</span><br>
						<span>대여 기간 </span>
						<span> ${reserve.renDate } ~ ${reserve.returnDate }</span>
					</div>
				</div>
				<div id="insurance-info">
					<h3>보험 선택</h3>
					<div id="radio-container">
						<input type="radio" class="insurance" id="insurance-non" name="insurance" value="일반자차">
						<input type="radio" class="insurance" id="insurance-cover" name="insurance" value="완전자차">
						<input type="radio" class=insurance id="insurance-super" name="insurance" value="슈퍼자차">
						<div>
							<label for="insurance-non" id="insurance-non-label"><div>일반자차</div></label>
							<label for="insurance-cover" id="insurance-cover-label"><div>완전자차</div></label>
							<label for="insurance-super" id="insurance-super-label"><div>슈퍼자차</div></label>
						</div>
					</div>
				</div>
				<div id="person-info">
					<h3>예약자정보</h3>
					<div>
						예약자명<input type="text" id="name" name="name" value= "${user.name}">
						이메일<input type="text" id="email" name="email" placeholder="[선택] 이메일주소 (예약 정보 전송 및 본인 확인용)" value= "${not empty user.email ? user.email : ''}">
					</div>
					<div class="error-container">
						<p class="error-msg" id="error-msg-email">* 이메일: 이메일 주소가 정확한지 확인해 주세요.</p>
					</div>
					<div>
						생년월일<input type="text" id="birth" name="birth" value= "${user.birth}">
						휴대폰<select id="telecom" name="telecom">
							<option disabled>통신사 선택</option>
							<option value="skt" ${user.telecom eq 'skt' ? 'selected' : ''}>SKT</option>
							<option value="kt" ${user.telecom eq 'kt' ? 'selected' : ''}>KT</option>
							<option value="lgt" ${user.telecom eq 'lgt' ? 'selected' : ''}>LG U+</option>
							<option value="sktb" ${user.telecom eq 'sktb' ? 'selected' : ''}>SKT 알뜰폰</option>
							<option value="ktb" ${user.telecom eq 'ktb' ? 'selected' : ''}>KT 알뜰폰</option>
							<option value="lgtb" ${user.telecom eq 'lgtb' ? 'selected' : ''}>LG U+ 알뜰폰</option>
						</select>
						<input type="text" id="phone" name="phone" placeholder="휴대전화번호" value= "${user.phone}">
						<div id="radio-container">
							<input type="radio" class="gender" id="gender-man" name="gender" value="M" ${user.gender eq 'M' ? 'checked' : ''}>
							<input type="radio" class="gender" id="gender-woman" name="gender" value="F" ${user.gender eq 'F' ? 'checked' : ''}>
							<input type="radio" class=country id="country-local" name="country" value="local" ${user.country eq 'local' ? 'checked' : ''}>
							<input type="radio" class=country id="country-foreigner" name="country" value="foreigner" ${user.country eq 'foreigner' ? 'checked' : ''}>
							<div>
								<label for="gender-man" id="gender-man-label"><div>남자</div></label>
								<label for="gender-woman" id="gender-woman-label"><div>여자</div></label>
							</div>
							<div>
								<label for="country-local" id="country-local-label"><div>내국인</div></label>
								<label for="country-foreigner" id="country-foreigner-label"><div>외국인</div></label>
							</div>
						</div>
					</div>
					<div class="error-container">
						<p class="error-msg" id="error-msg-telecom">* 통신사: 이용하는 통신사를 선택해 주세요.</p>
						<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
						<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호: 휴대전화번호가 정확한지 확인해 주세요.</p>
					</div>
						탑승 인원
						<select id="person-num" name="person-num">
							<option disabled selected>성인</option>
							<option value="1">1명</option>
							<option value="1">2명</option>
							<option value="1">3명</option>
							<option value="1">4명</option>
							<option value="1">5명</option>
							<option value="1">6명</option>
							<option value="1">7명</option>
							<option value="1">8명</option>
							<option value="1">9명</option>
							<option value="1">10명</option>
						</select>
						<select id="person-num-kids" name="person-num-kids">
							<option disabled selected>소인</option>
							<option value="0">0명</option>
							<option value="1">1명</option>
							<option value="1">2명</option>
							<option value="1">3명</option>
							<option value="1">4명</option>
							<option value="1">5명</option>
							<option value="1">6명</option>
							<option value="1">7명</option>
							<option value="1">8명</option>
							<option value="1">9명</option>
							<option value="1">10명</option>
						</select>
				</div>
				
			</div>
			<div id="reserve-checklist">
				<p>
					예약전 필수 확인 사항<br>
					대여조건<br>
					운전면허증 필수지참<br><br>
					
					분실시 주민등록증과 운전경력증명서 또는 182조회<br>
					※182조회 평일(09~18시/본인명의 핸드폰만 조회가능)<br><br>
					
					만26세이상(생일 다음날부터 가능)/ 면허취득 1년 이상<br><br>
					
					11인승이상 승합차량은 1종면허이상가능<br>
					※대여불가: 만26세미만/ 면허취득1년미만/ 군인(직업군인제외)/ 휴대폰 미소지/ 애견동반/ 낚시대지참/ 사전고지없이 인수시간 1시간 이상 경과/ 초과인원 탑승시 대여불가(유아포함)/ 해당 조건으로 인해 대여 불가할 경우 당일취소로 간주되어 전액 환불 불가합니다.<br>
					
					환불규정 및 예약변경(차량과 유아용품 일괄적용)<br>
					대여일시 기준 48시간 이전 변경 또는 취소시 수수료 없음<br><br>
					
					대여일시 기준 25 ~ 47시간 이내 변경 또는 취소시 수수료 10% 발생<br><br>
					
					대여일시 기준 24시간 이내 취소시 전액 환불 불가(예약변경불가)<br>
					※예약 변경 및 취소 문의는 고객센터 영업시간 내에만 가능<br>
					※예약 변경 시 변경일 기준 조회되는 요금으로 적용<br><br>
					
					외국인 대여 시<br>
					한국면허증 소지 외국인(취득 1년 이상) : 한국면허증 지참<br><br>
					
					한국면허증 소지 외국인(취득 1년 미만) : 한국면허증, 1년 이상의 경력이 확인되는 로컬면허증 또는 사본지참<br><br>
					
					그 외 : 여권, 로컬면허증, 국제면허증 (3가지 서류 영문스펠링 일치 해야함) 및 본사와 연락가능한 휴대전화 지참 필수<br>
					※비엔나 협약국 또는 제네바 협약국에서 발급된 국제면허증만 인정됩니다.<br><br>
					
					INTERNATIONAL DRIVING LICENSE (X)<br><br>
					
					INTERNATIONAL DRIVING PERMIT (O)<br>
					※9인승 이하 : B등급, 11인승 이상 : D등급<br>
					※주한미군 자가용 운전면허증 소지자 여권 지참필수, 최대 9인승 이하 차량만 대여 가능<br><br>
				
					차량인수/반납시간<br>
					인수: 08시~22시(20~22시 인수시 야간배차료10,000원)<br><br>
					
					22시이후 배차불가(인수장소 도착시간 기준)<br><br>
					
					항공시간지연과 관련하여 22시이후 인수 필요시 고객센터(1644-7935) 영업시간내에 신청자에 한하여 배차가능 (단, 추가 비용 발생)<br>
					※항공 지연시에도 야간배차료는 동일 적용<br><br>
					
					반납: 08~20시까지(이후 반납불가)<br><br>
					
					08시 이전 반납시 셔틀버스없음 / 공항까지 개별이동(도보10분) / 완전면책이상 필수가입 / 새벽반납비 10,000원 추가<br><br>
					
					카시트 사전장착 안내<br>
					카시트는 홈페이지에서 선택하신 위치에 사전장착/ 위치변경은 1일전까지 고객센터로 요청시 변경 가능<br><br>
					
					현장에서 직원 통하여 카시트 위치 변경 요청시 추가 요금 발생<br><br>
					
					전차종금연<br>
					반납시 흡연(꽁초,재,냄새) 또는 실내악취(토사물/ 비린내/ 애견동반 등) 확인시에는 클리닝 비용(30만원이상)발생<br><br>
					
					내비게이션<br>
					내비게이션은 무상 제공하는 서비스 제품으로 품질, 기기오류 등 미작동으로 인해 발생되는 문제는 본사 책임이 없음을 알려드리며, 휴대폰 내비게이션 앱 사용을 권장합니다.<br>
					※휴대폰 충전 케이블은 별도 지참 부탁드립니다.<br>
				</p>
			</div>
			<div id="reserve-price">
				<h3>최종 결제 금액</h3>
				<div>
					<span> ${car.price }원</span><br>
				</div>
			</div>
			<div id="reserve-payment">
				<h3>결제 수단</h3>
				<div>
					<input type="radio" id="payment-card" name="payment"> 신용카드
					<input type="radio" id="payment-cash" name="payment"> 무통장입금
				</div>
			</div>
			
			<input type="submit" value="예약하기">
		</form>
	</section>
</body>
<c:import url="/footer" />
</html>