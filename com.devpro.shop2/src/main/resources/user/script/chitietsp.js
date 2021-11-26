$('#btn_tru').on('click',function(){
	var soluong = $('#slsp').val();
	console.log(soluong);
	var soluongs = soluong - 1;
	$('#slsp').val(parseInt(soluongs));
	var text =$('#slsp').val(); 
	
});
$('#btn_cong').on('click',function(){
	var soluong = $('#slsp').val();
	console.log(soluong);
	var soluongs = parseInt(soluong) + 1;
	console.log(soluongs);
	$('#slsp').val(parseInt(soluongs));
	var text =$('#slsp').val(); 
	
});