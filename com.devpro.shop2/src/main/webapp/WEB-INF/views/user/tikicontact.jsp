<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- directive JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- directive SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>${projectTitle}</title>
	<link rel="stylesheet" href="${base}user/style/style.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
	
	<div class="section">
		<c:if test="${not empty thongbao }">
	            	<div class="alert alert-primary" role="alert">
					 	${thongbao }
					</div>
        </c:if>
		
		
		<sf:form action="${base }/tikicontact" method="post" modelAttribute="tikicontact">
			  	<p>Đội ngũ chăm sóc khách hàng TIKI</p>
			  	<div class="form-group">
			  	<sf:input path="txtmainsp" type="text" name="txtmainsp" id="txtmainsp" list="mainList" placeholder="Vấn đề hỗ trợ chính" style="width:300px ; height:20px"/>
					<datalist id="mainList">
					  <option value="Bảo hành">  
					  <option value="Bảo hiểm">
					  <option value="Bookcare">
					  <option value="Chat với nhà bán">
					  <option value="Chat với tiki">
					  <option value="Đặt hàng">	
					</datalist>
				</div>
				<div class="form-group">
				<sf:input path="txtdetailsp" type="text" name="txtdetailsp" id="txtdetailsp" list="detailsList" placeholder="Vấn đề hỗ trợ chính" style="width:300px ; height:20px"/>
					<datalist id="detailsList">
					  <option value="Tư vấn chính sách bảo hành"/>  
					  <option value="Yêu cầu bảo hành sản phẩm">
					  <option value="Kích hoạt bảo hành">
					  <option value="Kiểm tra tình trạng bảo hành">
					  <option value="Các vấn đề sau bảo hành">
					</datalist>	
				</div>	
				<div class="form-group">
			    <label for="exampleInputEmail1">Địa chỉ email của bạn</label>
			    <sf:input path="txtEmail" type="email" class="form-control" id="txtEmail" name="txtEmail" aria-describedby="emailHelp" placeholder="Nhập địa chỉ email" />
			    
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Số điện thoại</label>
			    <sf:input path="txtPhone" type="text" class="form-control" id="txtPhone" name="txtPhone" placeholder="Nhập số điện thoại"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Mã đơn hàng</label>
			    <sf:input path="txtID" type="text" class="form-control" id="txtID" name="txtID" placeholder="Nhập mã đơn hàng"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Tiêu đề</label>
			    <sf:input path="txtTitle" type="text" class="form-control" id="txtTitle" name="txtTitle" placeholder="Nhập tiêu đề"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Nội dung</label>
			    <sf:input path="txtContent" type="text" class="form-control" id="txtContent" name="txtContent" placeholder="Mô tả chi tiết vấn đề của bạn" style="width:300px ; height:40px"/>
			  </div>
			  
			  <button type="button" class="btn btn-primary" onclick="saveTikiContact()">Gửi</button>
		</sf:form>
	</div>


	
<!-- footer -->
<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>

</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
<!-- custom javascipt -->
 <script type="text/javascript">
        	function saveTikiContact() {
        		// javascript object.
        		// data la du lieu ma day len action cua controller
				let data = {
					txtmainsp: $("#txtmainsp").val(),
					txtdetailsp: $("#txtdetailsp").val(),
					txtEmail: $("#txtEmail").val(),
					txtPhone: $("#txtPhone").val(),
					txtID: $("#txtID").val(),
					txtTitle: $("#txtTitle").val(),
					txtContent: $("#txtContent").val(), 
        		};
        		
				
				$.ajax({
					url : "/tikicontact-ajax",
					type : "post",
					contentType : "application/json",
					data : JSON.stringify(data),
		
					dataType : "json", 
					success : function(jsonResult) {
						alert("Cam on ban! " + jsonResult.message.txtEmail+" da gui lien he");
					},
					error : function(jqXhr, textStatus, errorMessage) { 
						
					}
				});
        	}
</script>
</html>