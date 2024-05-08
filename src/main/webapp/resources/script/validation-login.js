$(document).ready(() => {
	$('#id').focusout(e => {
		if($('#id').val() === ""){
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-id').hide();
			$('#id').css('border', 'solid 1px lightgrey');
		}
	});
		
	$('#password').on('change', e => {
		console.log('change');
		if($('#password').val() === ""){
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
		}
	});
	
	$('form').submit(e => {
		e.preventDefault();
		
		const id = $('#id').val();
		const password = $('#password').val();	 
		
		// 유효성 검사
		let isValid = true;
		
		if(id === "") {
			isValid = false;
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px #ff3f3f');
		}
		if(password === ""){
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px #ff3f3f');
		}
		
		if(isValid) {
			e.target.submit();
		}
		
	});
});