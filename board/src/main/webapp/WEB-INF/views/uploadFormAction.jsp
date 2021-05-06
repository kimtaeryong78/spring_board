<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
</style>
</head>
<body>
	<form action="uploadFormAction" method="post"
		enctype="multipart/form-data" name="fileUploadForm">
		<input type="text" id="attachNo" name="attachNo" value="68" hidden="hidden">
		<input type='file' name='uploadFile' multiple>
		<!-- <button>Submit</button> -->
		<button type="button" id="uploadBtn">ajax</button>
	</form>
	<div class="uploadResult">
		<ul id="fileList">
		</ul>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
function getList(attachNo){
	var str_fileListContent = "";
	
	$.ajax({
    	url: '/getList/'+attachNo,
    	method: 'get',
      	dataType:'json',
      	
      	success: function(result){	//result : list<attachfilevo>
      		$.each(result, function (index, vo){
      			var savePath = encodeURIComponent(vo.savePath);
      			if(vo.fileType =='Y'){
	      			var s_savePath= encodeURIComponent(vo.s_savePath);
	      			
	      			str_fileListContent +="<li><img src='/display?fileName=" + s_savePath +"'><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";		
      			} else {
	      			str_fileListContent += "<li><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";
      			}
      		});
		$("#fileList").html(str_fileListContent);
      	}
	}); 
}//getList

$(document).ready(function(){
	var attachNo = $("#attachNo").val();
	var str_fileListContent = "";
	
	getList(attachNo);

	$("#uploadBtn").on("click", function(e){
		
		var formData = new FormData(document.fileUploadForm);
		$.ajax({
	    	url: '/ajaxFileUpload',
	    	method: 'post',
	    	
	    	processData: false,
	      	contentType: false,
	      	data: formData,
	      	dataType:'json',
	      	
	      	success: function(result){	//result : list<attachfilevo>
	      		$.each(result, function (index, vo){
	      			var attachNo = vo.attachNo;
	      			console.log(vo.attachNo);
	      			var savePath= encodeURIComponent(vo.savePath);
	      			if(vo.fileType =='Y'){
	      			str_fileListContent +="<li><img src='/display?fileName=" + s_savePath +"'><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";		
	      			} else {
		      			str_fileListContent += "<li><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";
	      			}
				$("#attachNo").val(attachNo);
	      		});
			$("#fileList").html(str_fileListContent);
	      	}
		}); //upload
	});//onclick
});//jquery

function attachDelete(uuid,attachNo){
	$.ajax({
		url : '/attachDelete/'+uuid+"/"+attachNo,
		type : 'get',
		
		success : function(str){
			alert(str);
			getList(attachNo);
		},
		error : function(error){
			console.log(error);
		}
	});
	
}
</script>
</html>