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
	

	
	<div class="add_product">
	
		<h1>Add Product</h1>
		<sf:form method="post" action="${base }/admin/addproduct" modelAttribute="product" enctype="multipart/form-data">
		<sf:hidden path="id"/> 
		
		<div class="form-group">
			<label for="category">Category(required)</label>
			<sf:select path="categories.id" class="form-control" id="category">
				<sf:options items="${categories}" itemValue="id" itemLabel="name"/>		
			</sf:select>	
		</div>
		
		<div class="form-group">
			<label for="title">Title(required)</label>
			<sf:input path="title" autocomplete="off" type="text" class="form-control" id="title" placeholder="Title" required="required"></sf:input>
		</div>
		
		<div class="form-group">
			<label for="price">Price(required)</label>
			<sf:input path="price" autocomplete="off" type="number" class="form-control" id="price" placeholder="Price" required="required"></sf:input>
		</div>
		
		<div class="form-group">
			<label for="price_sale">Price Sale(required)</label>
			<sf:input path="price_sale" autocomplete="off" type="number" class="form-control" id="price_sale" placeholder="Price Sale" required="required"></sf:input>
		</div>
		
		<div class="form-group">
			<label for="short_description">Description(required)</label>
			<sf:textarea path="short_description" autocomplete="off" id="short_description" class="form-control" placeholder="short Description" />
		</div>
		
		<div class="form-group">
			<label for="details">Detail (required)</label>
			<sf:textarea path="details" id="summernote" name="editordata" required="required"></sf:textarea>
		</div>
		
		<div class="form-group">
			<label for="seo">Seo(required)</label>
			<sf:input path="seo" autocomplete="off" type="text" class="form-control" id="seo" placeholder="Seo" ></sf:input>
		</div>
		
		<div class="form-group form-check">
			<sf:checkbox path="is_hot" class="form-check-input" id="is_hot"/>
			<label class="form-check-label" for="is_hot">Is Hot Product?</label>
		</div> 
		
		<div class="form-group">
			<label for="fileProductAvatar">Avatar</label>
			<input id="fileProductAvatar" name="ProductAvatar" type="file">
		</div>
		
	
		<div class="form-group">
				<label for="inputFileProduct">Picture(Multiple)</label>
				<input id="inputFileProduct" name="productPictures" type="file" class="form-control-file" multiple="multiple">
		</div>
		
		</br>
		<a href="${base }/admin/product" class="btn btn-back" role="button" style="background-color:black;color:white">Back to list</a>
		<button type="submit" class="btn btn-primary">Save Product </button>
		</sf:form>
	</div>
<!-- footer -->
<jsp:include page="/WEB-INF/views/user/layouts/footer.jsp"></jsp:include>

</body>
<jsp:include page="/WEB-INF/views/user/layouts/js.jsp"></jsp:include>
<script>
$(document).ready(function(){
	$('#summernote').summernote({
		placeholder: 'Enter detail .....',
		height: 200,
		minHeight: 100,
		maxHeight: 300,
		tabsize: 2,
		forcus:true
	});
	/* $('#summernote2').summernote({
		placeholder: 'Enter shortdes .....',
		height: 200,
		minHeight: 100,
		maxHeight: 300,
		tabsize: 2,
		forcus:true
	}); */
});
</script>
</html>