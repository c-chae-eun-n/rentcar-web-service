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
});