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
	<title>${projectTitle }</title>
	<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
	
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
	<link rel="stylesheet" href="${base}/user/style/giaodienadmin.css">
</head>
<body>
	<div class="main">
		<div class="sidebar d-none d-lg-block">
			<div class="logo">
				<a href="${base }/index">
				<img src="${base}/user/images/logo.png"></a>
			</div>

			<div class="menu_sidebar">
				<ul>
					<li>
						<a href="#"><span><i class="fas fa-tachometer-alt"></i> Dashboard</span></a>
					</li>
					<li>
						<a href="${base }/admin/category"><span><i class="fas fa-tasks"></i> Categories Manager</span></a>
					</li>
					<li>
						<a href="${base }/admin/search-product?page=1"><span><i class="fas fa-chart-line"></i> Product Manager</span></a>
					</li>
					<li>
						<a href="${base }/admin/contact"><span><i class="fab fa-wpforms"></i> Contact</span></a>
					</li>
					<li>
						<a href="${base }/admin/saleorder"><span><i class="far fa-file"></i> SaleOrders Manager</span></a>
					</li>
					<!-- <li>
						<a href="#"><span><i class="fas fa-table"></i> Table</span></a>
					</li>
					<li>
						<a href="#"><span><i class="fas fa-project-diagram"></i> Menu Levels</span></a>
					</li>
					<li>
						<a href="#"><span><i class="fab fa-themeisle"></i> Theme Docs</span></a>
					</li> -->

				</ul>
			</div>
		</div>
		<div class="content">
			<div class="header">
				<div class="form_search">
					
					<form method="GET" action="">
					<label class="sr-only" for="input_search">Tìm Kiếm...</label>
				      <div class="input-group">
				        <input type="text" class="form-control" id="input_search" placeholder="Tìm Kiếm...">
				        <div class="input-group-prepend">
				          <button class="input-group-text">
				          	<i class="fas fa-search"></i>
				          </button>
				        </div>
				    </div>
					</form>
				</div>
				
				<div class="account_manage">
					<button class="btn_account">
						 <img src="../images/ban-1.png"/>
						 <div class="username">
					          <c:if test ="${isLogined }"> 
								${userLogined.username }
							  </c:if>
		  				</div>
						 <i class="fas fa-angle-down"></i>
						 <div class="sub_menu" id="submenu_account">
						 	<ul>
						 		<li>
						 			<a href="#">Profile <i class="fas fa-user"></i></a>
						 		</li>
						 		<li>
						 			<a href="#">Reset Password <i class="fas fa-key"></i></a>
						 		</li>
						 		<li>
						 			<a href="#">Setting <i class="fas fa-cog"></i></a>
						 			
						 			
						 		</li>
						 		
							 	<c:if test="${isLogined }">
							 		<li>
							 			<a href="${base }/logout">Log out <i class="fas fa-sign-out-alt"></i></a>
							 		</li>
							 	</c:if>
 					 			</ul>
						 	</div>
						 </button>
				</div>
					
			</div>
			<div class="ds">
		<p style="font-size: 24px; background-color: #1d4d83; color: white"><b>Danh Sách Product</b></p>
		<p>
		<form action="${base }/admin/search-product" method="get">
			<span>
				<input type="text" name="keyword"/>
				<button type="submit" value="Search" >Search</button>
				<a href="${base }/admin/addproduct" class="btn btn-back" role="button" style="background-color:black;color:white">Add Products</a>
				
			</span>
			</br>
			<table border="1" >
			 <tr>
			 	<th>ID</th>
				<th>Title</th>
				<th>Price</th>
				<th>Price Sale</th>
				<th>Short Description</th>
				<th>Detail Description</th>
				<th>Avatar</th>
				<!-- <th>Category ID</th> -->
				<!-- <th>Created Date</th>
				<th>Update Date</th>
				<th>Created By</th>
				<th>Update By</th> -->
				<th>Status</th>
				<th>Seo</th>
				<th>Is Hot</th>
				<th>Action</th>
			</tr> 
				
			<c:forEach var="product" items="${product}">
				<tr>
					<td>${product.id}</td>
					<td>${product.title}</td>
					<td>${product.price}</td>
					<td>${product.price_sale}</td>
					<td>${product.short_description}</td>
					<td>${product.details}</td>
					<td><img src="${base }/upload/${product.avatar }"></td>
					<%-- <td>${categories.category_id}</td> --%>
					<%-- <td>${product.createdDate}</td>
					<td>${product.updatedDate}</td>
					<td>${product.createdBy}</td>
					<td>${product.updatedBy}</td> --%>
					<td>${product.status}</td>
					<td>${product.seo }</td>
					<td>${product.is_hot }</td>
					<td>
					<a href="${base }/admin/del-product/${product.id}"  style="color:black;text-decoration: none"><span><i class="fas fa-trash-alt"></i>Xóa</span></a>
					<br>
					<a href="${base }/admin/edit-product/${product.seo}" style="color:black;text-decoration: none"><span><i class="fas fa-edit"></i>Chỉnh sửa</span></a> 
					</td>
					
				</tr>
				</c:forEach>
			</table>
			</br>
			<div class="page">
				<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item"><a class="page-link" id="btn_pre" href="${base}/admin/search-product?page=${pagePrev}" >Previous</a></li>
					    <li class="page-item"><a class="page-link" id="btn_pre" href="${base}/admin/search-product?page=1" >1</a></li>
					    <li class="page-item"><a class="page-link" id="btn_pre" href="${base}/admin/search-product?page=2" >2</a></li>
					    <li class="page-item"><a class="page-link" id="btn_pre" href="${base}/admin/search-product?page=3" >3</a></li>
					    <li class="page-item"><a class="page-link" id="btn_next" href="${base}/admin/search-product?page=${pageNext}" >Next</a></li>
					  </ul>
				</nav>
			</div>
		</form>
		</p>
		
		<%-- <div class="button-back">
				<a href="${base }/admin/giaodienadmin" class="btn btn-back" role="button" 
				style="background-color:black;color:white">Back to Dashboard</a></span>
		</div> --%>
	</div>	
		</div>
			
			
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>


<script type="text/javascript" src="${base }/user/script/giaodienadmin.js"></script>
<script type="text/javascript">
function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if(x){
      return true;
  }  
  else{
    return false;
  }
}
 
</script>
</html>