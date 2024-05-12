$(document).ready(() => {
	$('form').submit(e => {
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