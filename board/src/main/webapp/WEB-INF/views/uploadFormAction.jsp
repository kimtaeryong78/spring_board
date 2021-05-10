<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/upload.css">
</head>
<body>
	<!-- method="post" -->
	<form action="uploadFormAction" enctype="multipart/form-data" name="fileUploadForm">
		<input type="text" id="attachNo" name="attachNo" value="0" hidden="hidden">
		<input type='file' name='uploadFile' multiple>
		<!-- <button>Submit</button> -->
		<button type="button" id="uploadBtn">ajax</button>
	</form>
	<div class="uploadResult">
		<ul id="fileList">
		
		</ul>
	</div>
</body>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- script module -->
<script type="text/javascript">
function attachGetList(attachNo){
	var str_fileListContent = "";
	
	$.ajax({
    	url: '/getList/'+attachNo,
    	method: 'get',
      	dataType:'json',
      	
      	success: function(result){	//result : list<attachfilevo>
      		$.each(result, function (index, vo){
      			var savePath = encodeURIComponent(vo.savePath);
	      		var s_savePath= encodeURIComponent(vo.s_savePath);
	      		
      			if(vo.fileType =='Y'){
	      			
	      			str_fileListContent +="<li><img src='/display?fileName=" + s_savePath +"'><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>X</span></li>";		
      			} else {
	      			str_fileListContent += "<li><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";
      			}
      		});
		$("#fileList").html(str_fileListContent);
      	}
	}); 
}//getList

function attachDelete(uuid,attachNo){
		
	$.ajax({
		url : '/attachDelete/'+uuid+"/"+attachNo,
		method : 'get',
		
		success : function(str){
			console.log(str);
			attachGetList(attachNo);
		},
		error : function(error){
			console.log("error");
		}
	});
}//delete
</script>

<script type="text/javascript">
$(document).ready(function(){
	if('{board.attachNo}' != ''){
		$("input[name=attachNo]").val(0);
	} else {
		$("input[name=attachNo]").val('{board.attachNo}');
	}
	var attachNo = $("#attachNo").val();
	var str_fileListContent = "";
	
	attachGetList(attachNo);

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
	      			var s_savePath= encodeURIComponent(vo.s_savePath);
	      			var savePath= encodeURIComponent(vo.savePath);
	      			if(vo.fileType =='Y'){
	      				str_fileListContent +="<li><img src='/display?fileName=" + s_savePath +"'><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";		
	      			} else {
		      			str_fileListContent += "<li><a href='/download?fileName="+ savePath + "'>" + vo.fileName + "</a><span onclick=attachDelete('"+ vo.uuid +"','"+ vo.attachNo +"')>삭제</span></li>";
	      			}
	      		//#으로 접근시 중복 선택불가, tag로 접근해야 중복접근가능
				//$("#attachNo").val(attachNo);
	      		$("input[name=attachNo]").val(attachNo);
				attachGetList(attachNo);
				$("#uploadFile").val("");
	      		});
			$("#fileList").html(str_fileListContent);
	      	}
		}); //upload
	});//onclick
});//jquery

</script>
</html>