<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadFormAction" enctype="multipart/form-data" method="post" name="uploadForm">
		<input type="file" name="uploadFile" multiple>
		<button>Submit</button>
		<button type="button" id="uploadBtn">ajax</button>
	</form>
</body>
<script type="text/javascript" src="/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#uploadBtn').on("click",function(){
		var datas = new FormData(document.uploadForm);
		console.log(datas.get("uploadFile"));
		
		$.ajax({
			url : '/fileUploadAjax',
			method : 'post',
			data : datas,
			
			contentType : false,
			processData : false,
			
			success: function(){
				console.log("success");
			},
			error: function(){
				console.log("error")
			}
			
		});//ajax
		
	});//onclick
	
});//jquery
</script>
</html>