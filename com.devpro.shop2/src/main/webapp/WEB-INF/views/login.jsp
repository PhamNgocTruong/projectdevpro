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
	<link rel="stylesheet" href="${base}/user/style/dangnhap.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>
</head>
<body>
	<style type="text/css">
	
	.container{
	height: 500px;
	}
	.content_form{
	padding-left: 150px;
	}
	.content_form .form-group .quen{
	padding-left: 167px;
	}
	
	.container h2{
	padding-left: 470px;
	padding-bottom: 30px;
	}
	
	
	</style>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
		<div class="content">
			<hr width="100%">
			<div class="container">
				<h2>ĐĂNG NHẬP</h2>
				<div class="content_form">
					<form method="POST" action="/perform_login" id="login" >
							
							<input type="hidden" name="${_csrf.parameterName }" 
							value ="${_csrf.token }"/>
							
							<c:if test="${not empty param.login_error }">
								<div class="alert alert-danger" role="alert">Nỗ lực đăng nhập không thành công, hãy thử lại !!!</div>
							</c:if>
					
							<div class="form-group">
									
								<input type="text" class="input_username" name="username" 	placeholder="Username" >
								
							</div>
							<div class="form-group">	
								
								<input type="password" id="password" name="password" placeholder="Password">
							</div>	
							<div class="form-group">	
								<a href="#" class="quen">Quên mật khẩu?</a>
								
							</div>
							<div class="form-group">	
								<span>Bạn chưa có tài khoản .<a href="${base }/dki" class="dki"> Đăng ký tại đây.</a> </span>
							</div>
							
							<button class="btn_click" type="submit">Đăng Nhập</button>		
							
						
					</form>
				</div>
			</div>
			</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>
</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>

<script type="text/javascript" src="${base }/user/script/dn.js"></script>
</html>