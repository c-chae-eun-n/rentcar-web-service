$(document).ready(() => {
	
	let isValid = false;
	let isConfirm = false;
    console.log('isValid : '+isValid);
    console.log('isConfirm : '+isConfirm);
	
	$('#reservation-confirmed').on('click', e => { 
		e.preventDefault();
	    console.log('e.target : '+e.target);
		
		const location = $('#location').val();
		const renDate = $('#renDate').val();
		const renTime = $('#renTime').val();
		const returnDate = $('#returnDate').val();
		const returnTime = $('#returnTime').val();
		
		const carCode = $('#carCode').val();
		
	    console.log(location);
	    console.log(renDate);
	    console.log(renTime);
	    console.log(returnDate);
	    console.log(returnTime);
		
		if(location === "" || renDate === "" || returnDate === "" || renTime === null || returnTime === null) {
			alert("대여 기간을 설정해주세요.");
			isValid = false;
			isConfirm = false;
		} else {
			isValid = true;
			isConfirm = true;
		}
		
		if(isValid) {
			console.log('ajax');
			$.ajax({
				"method": "POST",
				"url": `/search/Reservation?carCode=${carCode}&renDate=${renDate}&renTime=${renTime}&returnDate=${returnDate}&returnTime=${returnTime}`
			}).done(response => {
				if(response.isValid) {
					alert("대여 할 수 없는 기간입니다.");
					isConfirm = false;
					isValid = false;
				} else {
					isValid = true;
					alert("대여 기간이 확정되었습니다.");
				}
			})
		}
	
	});
	
	$('#email').focusout(e => {
		if($('#email').val() !== "" && !$('#email').val().match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}/)){
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
	
	$('#create-reserve').on("submit", e => {
		e.preventDefault();
		
		const insurance = e.target.insurance.value;
		const name = $('#name').val();
		const birth = $('#birth').val();
		const telecom = $('#telecom').val();
		
		const gender = e.target.gender.value;
		const country = e.target.country.value;
		
		const phone = $('#phone').val();	 
		
		// 유효성 검사
		let isValid = true;
		
		if(insurance === ""){
			isValid = false;
			$('#error-msg-insurance').show();
			$('#insurance').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-insurance').hide();
			$('#insurance').css('border', 'solid 1px lightgrey');
		}
		
		if(name === ""){
			isValid = false;
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px lightgrey');
		}
		
		if(birth === ""){
			isValid = false;
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-birth').hide();
			$('#birth').css('border', 'solid 1px lightgrey');
		}
		
		if(telecom === null){
			isValid = false;
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-telecom').hide();
			$('#telecom').css('border', 'solid 1px lightgrey');
		}
		
		if(gender === ""){
			isValid = false;
			$('#error-msg-gender').show();
			$('#radio-container').css('border', 'solid 1px #ff3f3f');
			$('#gender-man-label').css('border', 'solid 1px #ff3f3f');
			$('#gender-woman-label').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-gender').hide();
			$('#gender').css('border', 'solid 1px lightgrey');
		}
		
		if(country === ""){
			isValid = false;
			$('#error-msg-country').show();
			$('#radio-container').css('border', 'solid 1px #ff3f3f');
			$('#country-local-label').css('border', 'solid 1px #ff3f3f');
			$('#country-foreigner-label').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-country').hide();
			$('#country').css('border', 'solid 1px lightgrey');
		}
		
		if(phone === ""){
			isValid = false;
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
		}
		
		
		if(!isConfirm) {
			alert("대여기간 확정을 눌러주세요.");
		} else if(isConfirm && isValid) {
			console.log('submit');
			e.target.submit();
		}
	})
	
});
