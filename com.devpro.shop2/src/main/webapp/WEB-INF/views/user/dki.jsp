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
	<title>${projectTitle}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
	<link rel="stylesheet" href="${base}user/style/dki.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
		<div class="content">
			<hr width="100%">
			<div class="container">
				<h2>ĐĂNG KÝ TÀI KHOẢN</h2>
				<div class="content_form">
					<sf:form method="post"  action="${base }/dki" modelAttribute="users" >
						<sf:hidden path="id"/> 
						<div class="form-group">
							<sf:input path="username" autocomplete="off" type="text" class="form-control" id="username" placeholder="UserName" required="required"></sf:input>
						</div>
		
						<div class="form-group">
							<sf:input path="password" autocomplete="off" type="password" class="form-control" id="password" placeholder="Password" required="required"></sf:input>
						</div>
						
						
						<div class="form-group">
							<sf:input path="email" autocomplete="off" type="text" class="form-control" id="email" placeholder="Email" required="required" ></sf:input>
						</div>
						
						</br>
<%-- 						<a href="${base }/admin/category" class="btn btn-back" role="button" style="background-color:black;color:white">Back to list</a>
 --%>						<button type="submit" class="btn btn-primary">Đăng Ký </button>
					</sf:form>
				</div>
			</div>
	</div>

	<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>
</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>

<script type="text/javascript" src="${base }user/script/dki.js"></script>
</html>