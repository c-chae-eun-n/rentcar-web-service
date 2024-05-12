$(document).ready(() => {
	$('#reservaion').click(e => {
		if($(renDate) === ""){
			alert("대여일자를 선택하여 검색하진 후 예약을 진행하실 수 있습니다.");
		}
	});
});