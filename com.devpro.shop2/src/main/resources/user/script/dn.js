$('#submenu_account').hide();
$('input[type="text"]');

// var show_menu = true;
// $(".btn_account").on('click', function(){
// 	if(show_menu == true){
// 		$('#submenu_account').show('slow');
// 		show_menu = false;
// 	}else{
// 		$('#submenu_account').hide('slow');
// 		show_menu = true;
// 	}

	
// });


$('#btn_save').on('click', function(){
	
	$('#form_insert').submit();
});

$('#form_insert').validate({
	rules : {
		
		username: {
			required: true,
			email: true
		},
		password: {
			required:true,
			minlength:8

		},
		
	},
	messages:{
		
		username: {
			required: 'Vui lòng nhập tài khoản',
			email: 'Vui lòng nhập đúng định dạng email'
		},
		password: {
			required:'Vui lòng nhập mật khẩu',
			minlength:'Độ dài tối thiểu 8 kí tự'
		},
		
	}
});
