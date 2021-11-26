<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!-- directive JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
	<p><b>Chi tiết Hóa Đơn</b></p>
	<p>
	
	<table border="1" >
	 <tr>
		<th>Customer Name</th>
		<th>Customer Address</th>
		<th>Customer Phone</th>
		<th>Customer Email</th>
		<th>Product Name</th>
		<th>Quanlity</th>
		<th>Prince</th>
		<th>Total</th>
		
	</tr> 
		
	<c:forEach var="saleorder" items="${saleorder}">
		<tr>
			
			<td>${saleorder.customerName}</td>
			<td>${saleorder.customerAddress}</td>
			<td>${saleorder.customerPhone}</td>
			<td>${saleorder.cutomerEmail}</td>			
		</tr>
	</c:forEach> 
	<c:forEach var="cartItems" items="${cart.cartItems }">
			    <tr class="">
			      <td>${cartItems.productName }</td>
			      <td>${cartItems.quanlity }</td>
			      <td>${cartItems.priceUnit }</td>
			      <td>${cartItems.priceUnit*cartItems.quanlity }</td>
			    </tr>
	</c:forEach>
 	</table>
	</p>
<!-- footer -->
<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
</html>