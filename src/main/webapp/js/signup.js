$(function () {

	// body...
	$('input[name=sex]').click(function() {
		/* Act on the event */
		$('#sex').val($(this).val());
		// alert($('#sex').val());
	});
	// var sex = $('input[name=sex][checked]').val();
	// $('#sex').val(sex);
	
})