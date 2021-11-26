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
.container{
margin-top: 30px;
/* margin-left: 30px; */
}
.row{
margin-left: 30px;
}
.container h2{
text-transform: uppercase;
text-align: center;
font-size: 34px;
/* background-color: #4471f1;
color:white; */
height: 40px;
padding-top: 7px;
margin-bottom: 30px;
border-radius: 10px;
}
.container .card:hover img{
transform:scale(1.2);

}
/* .container .card img{
transision:2s;
} */
</style>
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	

	<div class="section">
		<div class="section-nd">
			<span>ultimate collection</span>
			<h1>Complete Woman Fashion Here</h1>
			<a href="#" class="btn-shop">Shop now</a>
		</div>
		<div class="img1">
			<img src="${base}/user/images/ban-1.png" alt="">
		</div>
	</div>

	<div class="container">
		<h2>sản phẩm mới</h2>
		<div class="row">
		<c:forEach var="productnew" items="${productnew }">
			<div class="col-md-4 mb-3 mt-3">
				<div class="card" style="width: 18rem;height: 570px;">
				<a href="${base }/chitietsp/${productnew.id }"><img style="width: 300; height: 300px;" class="card-img-top" src="${base }/upload/${productnew.avatar }" alt="Card image cap"></a>
				  <div class="card-body">
				    <h4 class="card-title">${productnew.title }</h4>
				    <h3 class="card-price">${productnew.price_sale } VND</h3>
				    <p class="card-text">${productnew.short_description }</p>
				    <a href="#" class="btn btn-primary" id="btn-click" onclick="addToCart(${productnew.id }, 1)" >Thêm vào giỏ hàng</a>
				  </div>
				</div>
			
			</div>
		
		</c:forEach>
		</div>
	</div>
	
	
	<div class="section_2">
		<div class="section-nd2">
			<span>50% OFF</span>
			<h4>ALL WOMEN'S COLLECTION</h4>
			<a href="#" class="btn-shop">Shop now</a>
		</div>
		<div class="img1">
				<img src="${base}user/images/ban-2.png" alt="">
			</div>
		</div>
	<div class="container" >
		<h2>sản phẩm hot</h2>
		<div class="row">
		
		<c:forEach var="producthot" items="${producthot }">
			<div class="col-md-4 mb-3 mt-3">
				<div class="card" style="width: 18rem;height: 570px;">
				<a href="${base }/chitietsp/${producthot.id }"><img style="width: 300; height: 300px;" class="card-img-top" src="${base }/upload/${producthot.avatar }" alt="Card image cap"></a>
				  <div class="card-body">
				    <h4 class="card-title">${producthot.title }</h4>
				    <h3 class="card-price">${producthot.price_sale } VND</h3>
				    <p class="card-text">${producthot.short_description }</p>
				    <a href="#" class="btn btn-primary" id="btn-click" onclick="addToCart(${producthot.id }, 1)" >Thêm vào giỏ hàng</a>
				  </div>
				</div>
			
			</div>
		
		</c:forEach>
		</div>
		
	</div>

	

<hr width="100%" >
<!-- trending product -->
	<div class="container">
		<h2>phụ kiện thời trang</h2>
		<div class="row">
		<c:forEach var="productacc" items="${productacc }">
			<div class="col-md-4 mb-3 mt-3">
				<div class="card" style="width: 18rem;height: 570px;">
				<a href="${base }/chitietsp/${productacc.id }"><img style="width: 300; height: 300px;" class="card-img-top" src="${base }/upload/${productacc.avatar }" alt="Card image cap"></a>
				  <div class="card-body">
				    <h4 class="card-title">${productacc.title }</h4>
				    <h3 class="card-price">${productacc.price_sale } VND</h3>
				    <p class="card-text">${productacc.short_description }</p>
				    <a href="#" class="btn btn-primary" id="btn-click" onclick="addToCart(${productacc.id }, 1)" >Thêm vào giỏ hàng</a>
				  </div>
				</div>
			
			</div>
		
		</c:forEach>
		</div>
	</div>
	
	<hr width="100%">		
<!-- silon journal -->
<!-- <div class="new">
	
</div> -->
<!-- footer -->
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