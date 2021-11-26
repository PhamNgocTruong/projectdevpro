<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <!-- directive JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.menu .logo{
padding-right: 70px;
}
.menu .main-menu{
padding-right: 30px;
}
.menu .icon-menu {
padding-left: 0px;
width: 300px;
padding-top: 15px;
}
.menu .icon-menu input{
border-radius: 10px;
width: 200px;
}
.menu .icon-menu button{
border-radius: 10px;
}
</style>
<body>
<div class="menu">
		<div class="logo">
			<a href="${base }/index"><img src="${base}/user/images/logo.png"></a>
		</div>
		<ul class="main-menu">    
            <li>
              <a href="${base }/product">Danh Mục</a><i class="fas fa-chevron-down"></i>
              <ul class="sub-menu">
                <li><a href="${base }/producthot">Sản Phẩm Hot</a></li>
                <li><a href="${base }/productnew">Sản Phẩm Mới</a></li>
                <li><a href="${base }/productacc">Phụ kiện Thời Trang</a></li>
              </ul>
            </li>
            <!-- <li><a href="#">Về chúng tôi</a></li> -->
            <li><a href="#">Dịch vụ</a></li>
            <!-- <li><a href="#">Dự án</a></li> -->
            <li><a href="#">Tin tức</a></li>
            <li><a href="${base }/contact">Liên hệ</a></li>
   		</ul>
          <div class="icon-menu">
          <span>
	          <form action="${base }/search-product" method="get">
	          <span>
	          	<input type="text" name="keyword"/>
	          	<button type="submit" class="search"><i class="fas fa-search"></i></button><!-- <a href=""><i class="fas fa-search"></i></a> -->
	          	<a href="${base }/cart/view"><i class="fas fa-shopping-cart"></i><span id="totalCartItemId" class="badge-bg-dark text-gray ms-1 rounded-pill">${totalItems }</span></a>
	          </span>
	          </form>
          </span>
          </div>
          <div class="username">
          		
	          <c:if test ="${isLogined }"> 
				${userLogined.username }
			  </c:if>
		  </div>
</div>
</body>
</html>