<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- directive SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- directive cua JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Product</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link rel="stylesheet" href="${base}/user/style/style.css">
    
    <!-- CSS -->
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
 
</head>

<body>
<%-- 	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
 --%>	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	<div class="top bg-primary" style="height: 10vh;">
		<%-- <div class="row">
				<div class="col-md-2">
					<a href="${base }/cart/view">
						<i class="fas fa-cart-plus"></i>
						<div class="bg-light text-dark" id="total">0</div>
					</a>
					
				</div>
		</div> --%>
	</div>

	<div class="container" >
		<div class="row">
		
		<c:forEach var="product" items="${product}">
			<div class="col-md-4 mb-3 mt-3">
				<div class="card" style="width: 18rem;">
				<a href="${base }/chitietsp/${product.id }"><img style="width: 300; height: 300px;" class="card-img-top" src="${base }/upload/${product.avatar }" alt="Card image cap"></a>
				  <div class="card-body">
				    <h5 class="card-title">${product.title }</h5>
				    <h3 class="card-title">${product.price_sale }</h3>
				    <p class="card-text">${product.short_description }</p>
				    <a href="#" class="btn btn-primary" onclick="addToCart(${product.id }, 1)" >Add to cart</a>
				  </div>
				</div>
			
			</div>
		
		</c:forEach>
		</div>
		
		
	
	</div>
	
	
    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    <div id="preloader"></div>
<!-- footer -->
<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

    <!-- Javascript -->
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
					$("#total").html(total);
				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 

				}
			});
			
		}	
	
	</script>
	
</body>

</html>