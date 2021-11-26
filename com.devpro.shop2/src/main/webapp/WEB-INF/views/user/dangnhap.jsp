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
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	
		<div class="content">
			<hr width="100%">
			<div class="container">
				<h2>ĐĂNG NHẬP</h2>
				<div class="content_form">
					<form method="POST" action="/perform/login" id="form_insert" novalidate="novalidate">
						<fieldset>
							
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
							<c:if test="${not empty param.login_error }">
								<div class="alert alert-danger" role="alert">Login attempt was not successful, try again.</div>
							</c:if>
							<table>
								<tr>
									<!-- <td>Email:</td> -->
									<td><input type="email" class="input_username" name="username" placeholder="Email" ></td>
								</tr>
								<tr>
									<!-- <td>Máº­t kháº©u</td> -->
									<td><input type="password" id="password" name="password" placeholder="Mật Khẩu"></td>
								</tr>
								<tr>
									<td class="s1" colspan="2">
											<a href="#" class="quenmk"><p>Quên mật khẩu?</p></a>
									</td>
								</tr>
								<tr>
									<td class="s1" colspan="2">
										<a href="dki.html" class="quenmk"><p>Đăng Ký</p></a>
									</td>	
								</tr>
								<tr>
									<td colspan="2">
										<button type="submit" id="btn_save">Đăng Nhập</button>
								</tr>
								
									
							</table>
						</fieldset>
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

<script type="text/javascript" src="../script/dn.js"></script>
</html>