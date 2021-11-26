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
	<title>Product</title>
	<link rel="stylesheet" href="${base}user/style/product.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
</head>
<style>
.card-title{
text-transform: uppercase;
text-align: center;
height: 56px;
}
.card-price{
text-align: center;
color:red;
}
.card-text{
font-size: 16px;
font-weight: 400;
with:246px;
height: 72px;
text-align: center;
}
#btn-click{
padding-bottom:10px; 
margin-left: 50px;
border-radius: 10px;
background-color: red;
}
.container .card:hover img{
transform:scale(1.2);

}
</style>
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
 
	<!-- SP -->
	 <%-- div class="top bg-primary" style="height: 10vh;">
		<div class="row">
				<div class="col-md-2">
					<a href="${base }/cart/view">
						<i class="fas fa-cart-plus"></i>
						<div class="bg-light text-dark" id="total">0</div>
					</a>
					
				</div>
		</div>
	</div> --%>

	<div class="container" >
		<div class="row">
		
		<c:forEach var="product" items="${product }">
			<div class="col-md-4 mb-3 mt-3">
				<div class="card" style="width: 18rem;height: 570px;">
				<a href="${base }/chitietsp/${product.id }"><img style="width: 300; height: 300px;" class="card-img-top" src="${base }/upload/${product.avatar }" alt="Card image cap"></a>
				  <div class="card-body">
				    <h4 class="card-title">${product.title }</h4>
				    <h3 class="card-price">${product.price_sale } VND</h3>
				    <p class="card-text">${product.short_description }</p>
				    <a href="#" class="btn btn-primary" id="btn-click" onclick="addToCart(${product.id }, 1)" >Thêm vào giỏ hàng</a>
				  </div>
				</div>
			
			</div>
		
		</c:forEach>
		</div>
	
	</div>
	
	
    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    <div id="preloader"></div> 
	
	</div>
	
			
<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>
	
</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
<script type="text/javascript">
	addToCart = function(productId, quanlity){
			// javascript object.
			// data la du lieu ma day len action cua controller
			let data = {
				productId : productId, // lay theo id
				quanlity : quanlity
			};

			// $ === jQuery
			// json == javascript object
			$.ajax({
				url : "/cart/add",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(data),

				dataType : "json", // kieu du lieu tra ve tu controller la json
				success : function(jsonResult) {
					total = jsonResult.totalItems;
					$("#totalCartItemId").html(total);
				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 

				}
			});
			
		}	
	
	</script>
</html>