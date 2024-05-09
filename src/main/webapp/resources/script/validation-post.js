$(document).ready(() => {
	$('form').submit(e => {
		e.preventDefault();
		
		const title = $('#title').val();
		const content = $('#content').val();
		
		let isValid = true;
		
		if(title === "") {
			isValid = false;
			$('#error-msg-title').show();
			$('#title').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-title').hide();
			$('#title').css('border', 'solid 1px lightgrey');
		}
		if(content === "") {
			isValid = false;
			$('#error-msg-content').show();
			$('#content').css('border', 'solid 1px #ff3f3f');
		} else {
			$('#error-msg-content').hide();
			$('#content').css('border', 'solid 1px lightgrey');
		}
		
		if(isValid) {
			e.target.submit();
		}
	});
});