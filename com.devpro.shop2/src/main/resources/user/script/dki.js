$('#submenu_account').hide();
$('input[type="text"]');

var show_menu = true;
$(".btn_account").on('click', function(){
	if(show_menu == true){
		$('#submenu_account').show('slow');
		show_menu = false;
	}else{
		$('#submenu_account').hide('slow');
		show_menu = true;
	}

	
});


$('#btn_save').on('click', function(){
	
	$('#form_insert').submit();
});

$('#form_insert').validate({
	rules : {
		/*fullname: 'required',*/
		username: {
			required: true,
			
		},
		password: {
			required:true,
			minlength:8

		},
		password_confirm: {
			required:true,
			equalTo:'#password'
		},
		email: {
			required: true,
			email : true
		}
		
	},
	messages:{
		/*fullname: 'Vui lòng nhập họ tên',*/
		username: {
			required: 'Vui lòng nhập tài khoản',
			email: 'Vui lòng nhập đúng định dạng email'
		},
		password: {
			required:'Vui lòng nhập mật khẩu',
			minlength:'Độ dài tối thiểu 8 kí tự'
		},
		password_confirm:{
			required:'Vui lòng xác nhận lại mật khẩu',
			equalTo:'Mật khẩu xác nhận không đúng'
		},
		email: {
			email: 'Vui lòng nhập đúng định dạng email'
		}
	}
});
