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
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
</head>

<body>

	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
	
	<div class="top bg-primary" style="height: 10vh;">
		
	</div>
	
	
	

	<div class="container" >
		<div class="row bg-warning message"></div>
		<sf:form method="post" action="${base }/cart/finish">
			<c:choose>
            		<c:when test="${isLogined }">
            			<div class="form-group">
							<label for="customerName">Customer Name</label>
							<input type="text" class="form-control" name="customerName" id="customerName" 
							placeholder="${cart.user.username}" readonly="readonly" required="required"></input>
						</div>	
						<div class="form-group">
							<label for="customerAddress">Customer Address</label>
							<input type="text" class="form-control" name="customerAddress" id="customerAddress"
								placeholder="Customer Address" required="required"></input>
						</div>
						<div class="form-group">
							<label for="customerPhone">Customer Phone</label>
							<input type="text" class="form-control" name="customerPhone" id="customerPhone"
								placeholder="Customer Phone"  required="required"></input>
						</div>
						<div class="form-group">
							<label for="customerEmail">Customer Email</label>
							<input type="email" class="form-control" name="customerEmail" id="customerEmail"
								placeholder="${cart.user.email}" readonly="readonly" required="required"></input>
						</div>
            		</c:when>
            		<c:otherwise>
            			<div class="form-group">
							<label for="customerName">Customer Name</label>
							<input type="text" class="form-control" name="customerName" id="customerName"
								placeholder="Customer Name" required="required"></input>
						</div>
						
						<div class="form-group">
							<label for="customerAddress">Customer Address</label>
							<input type="text" class="form-control" name="customerAddress" id="customerAddress"
								placeholder="Customer Address" required="required"></input>
						</div>
						
						<div class="form-group">
							<label for="customerPhone">Customer Phone</label>
							<input type="text" class="form-control" name="customerPhone" id="customerPhone"
								placeholder="Customer Phone" required="required"></input>
						</div>
						
						
						<div class="form-group">
							<label for="customerEmail">Customer Email</label>
							<input type="email" class="form-control" name="customerEmail" id="customerEmail"
								placeholder="Customer Email" required="required"></input>
						</div>
            		</c:otherwise>
            </c:choose>
			
			
			<div class="col-md-2">
				<button type="submit"
					class="form-control bg-primary text-white buy" value="" onclick="alert('Chúc mừng bạn đã mua hàng thành công!')">Mua hàng</button>
			</div>
		
		</sf:form>
		<table class="table table-striped text-black">
		  <thead>
		    <tr>
		      <th scope="col">Product Name</th>
		      <th scope="col">Quanlity</th>
		      <th scope="col">Prince</th>
		      <th scope="col">Total</th>
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="cartItems" items="${cart.cartItems }">
			    <tr class="">
			      <td>${cartItems.productName }</td>
			      <td>${cartItems.quanlity }</td>
			      <td>${cartItems.priceUnit }</td>
			      <td>${cartItems.priceUnit*cartItems.quanlity }</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
		
		
	
	</div>
	
	
    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    <div id="preloader"></div>
	<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

    <!-- Javascript -->
    <jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
    
	<script type="text/javascript">
	$(function(){
		$('.buy').onclick(function(){
			alert(${message });
		});
	})
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
					$("#totalCartItem").html(total);
				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 

				}
			});
			
			/* function ConfirmOrder()
			{
			  alert("Chúc mừng bạn đã đặt hàng thành công!");
			} */
			
		}	
	
	</script>
	
</body>

</html>