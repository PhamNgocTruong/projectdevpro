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
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>${projectTitle}</title>
	<link rel="stylesheet" href="${base}/user/style/style.css">
	<jsp:include page="/WEB-INF/views/user/layouts/css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/WEB-INF/views/user/layouts/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/views/user/layouts/menu.jsp"></jsp:include>
	

	
	<div class="add_category">
	
		<h1>Add Category</h1>
		<sf:form method="post" action="${base }/admin/addcategories" modelAttribute="categories" >
		<sf:hidden path="id"/> 
		
		<div class="form-group">
			<label for="name">Name(required)</label>
			<sf:input path="name" autocomplete="off" type="text" class="form-control" id="name" placeholder="Name" required="required"></sf:input>
		</div>
		
		<div class="form-group">
			<label for="description">Description(required)</label>
			<sf:input path="description" autocomplete="off" type="text" class="form-control" id="description" placeholder="Description" required="required"></sf:input>
		</div>
		
		<div class="form-group">
			<label for="seo">Seo(required)</label>
			<sf:input path="seo" autocomplete="off" type="text" class="form-control" id="seo" placeholder="Seo" ></sf:input>
		</div>
				
		</br>
		<a href="${base }/admin/category" class="btn btn-back" role="button" style="background-color:black;color:white">Back to list</a>
		<button type="submit" class="btn btn-primary">Save Category </button>
		</sf:form>
	</div>
<!-- footer -->
<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
</html>