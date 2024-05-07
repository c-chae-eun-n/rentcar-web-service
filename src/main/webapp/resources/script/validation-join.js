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
		
	$('#password').focusout(e => {
		if($('#password').val() === ""){
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
		
			const password = $('#password').val();
			
			if(password.match(/(?=.*[a-z])(?=.*[!@#$%])[a-z0-9!@#$%]{8,12}/) === null) {
				$('#error-msg-password-pattern').show();
				$('#password').css('border', 'solid 1px #ff3f3f');
			}else {
				$('#error-msg-password-pattern').hide();
			}
		}
	});
	
	$('#email').focusout(e => {
		if($('#email').val() !== "" && !$('#email').val().match(/[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}/)){
			isValid = false;
			$('#error-msg-email').show();
			$('#email').css('border', 'solid 1px #ff3f3f');
		}else {
			$('#error-msg-email').hide();
			$('#email').css('border', 'solid 1px lightgrey');
		}
	});
		
	$('#name').focusout(e => {
		if($('#name').val() === ""){
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px lightgrey');
			$('#name').css('border-bottom', 'none');
		}
	});
		
	$('#birth').focusout(e => {
		if($('#birth').val() === ""){
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-birth').hide();
			$('#birth').css('border', 'solid 1px lightgrey');
			$('#birth').css('border-bottom', 'none');
			
			// 생년월일은 8자리
			const birth = $('#birth').val();
			
			if(birth.match(/\d{8}/) === null) {
				$('#error-msg-birth-pattern').show();
				$('#birth').css('border', 'solid 1px #ff3f3f');
			}else {
				$('#error-msg-birth-pattern').hide();
			}
			
		}
	});
		
	$('#telecom').focusout(e => {
		if($('#telecom').val() === null){
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-telecom').hide();
			$('#telecom').css('border', 'solid 1px lightgrey');
			$('#telecom').css('border-bottom', 'none');
		}
	});
		
	$('#phone').focusout(e => {
		if($('#phone').val() === ""){
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
			
			const phone = $('#phone').val();
			
			if(phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
				$('#error-msg-phone-pattern').show();
				$('#phone').css('border', 'solid 1px #ff3f3f');
			} else {
				if(phone.length === 11) {
					const update = `${phone.substr(0,3)}-${phone.substr(3,4)}-${phone.substr(7,4)}`;
					$('#phone').val(update);
				}
			}
		}
	});
	
	$('form').submit(e => {
		e.preventDefault();
		
		const id = $('#id').val();
		const password = $('#password').val();
		
		const name = $('#name').val();
		const birth = $('#birth').val();
		const telecom = $('#telecom').val();
		
		const gender = e.target.gender.value;
		const country = e.target.country.value;
		
		const phone = $('#phone').val();	 
		
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
		if(name === ""){
			isValid = false;
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px #ff3f3f');
		}
		if(birth === ""){
			isValid = false;
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px #ff3f3f');
		}
		if(telecom === null){
			isValid = false;
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px #ff3f3f');
		}
		if(gender === ""){
			isValid = false;
			$('#error-msg-gender').show();
			$('#radio-container').css('border', 'solid 1px #ff3f3f');
			$('#gender-man-label').css('border', 'solid 1px #ff3f3f');
			$('#gender-woman-label').css('border', 'solid 1px #ff3f3f');
		}
		if(country === ""){
			isValid = false;
			$('#error-msg-country').show();
			$('#radio-container').css('border', 'solid 1px #ff3f3f');
			$('#country-local-label').css('border', 'solid 1px #ff3f3f');
			$('#country-foreigner-label').css('border', 'solid 1px #ff3f3f');
		}
		if(phone === ""){
			isValid = false;
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px #ff3f3f');
		}
		
		if(isValid) {
			e.target.submit();
		}
		
	});
});