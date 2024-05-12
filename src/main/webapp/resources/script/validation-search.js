$(document).ready(() => {
	$('#search-date').submit(e => {
		e.preventDefault();
		
		const renDate = $('#ren-date').val();
		const renTime = $('#ren-time').val();
		const returnDate = $('#return-date').val();
		const returnTime = $('#return-time').val();
		
		let isValid = true;
		
		if(renDate === "" || returnDate === "" || renTime === "" || returnTime === "") {
			isValid = false;
			alert("대여 기간을 설정해주세요.");
		}
		
		if(isValid) {
			e.target.submit();
		}
	});
	
	$('#search-carModel').submit(e => {
		e.preventDefault();
		
		const carModel = $('#car-model').val();
		
		let isValid = true;
		if(carModel === "") {
			isValid = false;
			$('#error-msg-search').show();
			$('#car-model').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-search').hide();
			$('#car-model').css('border', 'solid 1px lightgrey');
		}
		
		if(isValid) {
			e.target.submit();
		}
	});
	
	$('input[type=radio][name=car-class]').change(function() {
		
		const carClass = $('input:radio[name=car-class]:checked').val();
		console.log(carClass);
		
		location.href = `/searchCarClass?car-class=${carClass}`;
	});
	
	$('input[type=radio][name=fuel]').change(function() {
		
		const fuel = $('input:radio[name=fuel]:checked').val();
		console.log(fuel);
		
		location.href = `/searchFuel?fuel=${fuel}`;
	});
});