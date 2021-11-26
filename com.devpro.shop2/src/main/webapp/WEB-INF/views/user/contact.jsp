<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- directive JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>${projectTitle}</title>
	<link rel="stylesheet" href="${base}/user/style/style.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>

</head>
<style>
.section form{
margin-left: 700px;
margin-top: 50px;
}
</style>
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
	<div class="section">
		<c:if test="${not empty thongbao }">
	            	<div class="alert alert-primary" role="alert">
					 	${thongbao }
					</div>
        </c:if>
		
		
		<sf:form action="${base }/contact" method="post" modelAttribute="contact" enctype="multipart/form-data">
			<h3>Đội ngũ chăm sóc khách hàng xin chào</h3>
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <sf:input path="txtEmail" type="email" class="form-control" id="txtEmail" name="txtEmail" aria-describedby="emailHelp" />
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Content</label>
			    <sf:input path="txtContent" type="text" class="form-control" id="txtContent" name="txtContent" />
			  </div>
			  <div class="form-check">
			    <sf:checkbox path="ckbCheckbox" class="form-check-input" id="exampleCheck1"/>
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  <div class="form-group">
				<label for="inputFile">Picture(Multiple)</label>
				<input id="inputFile" name="inputFile" type="file" class="form-control-file" multiple="multiple">
			  </div>
			  <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
			  <button type="button" class="btn btn-primary" onclick="saveContact()">Gửi Liên Hệ</button>
		</sf:form>
	</div>
	
	
	<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

</body>	
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
<!-- custom javascipt -->
 <script type="text/javascript">
        	function saveContact() {
        		// javascript object.
        		// data la du lieu ma day len action cua controller
				let data = {
					txtEmail: $("#txtEmail").val(), // lay theo id
					txtContent: $("#txtContent").val(), // lay theo id
        		};
        		
        		
				// $ === jQuery
				// json == javascript object
				$.ajax({
					url : "/contact-ajax",
					type : "post",
					contentType : "application/json",
					data : JSON.stringify(data),
		
					dataType : "json", // kieu du lieu tra ve tu controller la json
					success : function(jsonResult) {
						alert("Chuc mung! da luu thanh cong dia chi email " + jsonResult.message.txtEmail);
					},
					error : function(jqXhr, textStatus, errorMessage) { // error callback 
						
					}
				});
        	}
</script>
</html>
