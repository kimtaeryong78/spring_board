/**
 * 리플 Ajax 
 */
function getAjaxList(){
	
	$.ajax({
		url : '/replies/pages/' + $("#bno").val() + "/1",
		method : 'get',
		dataType : 'json',
		
		success :function(data, status, xhr){
			console.log("data", data);
			debugger;
			var htmlContent="";

			$.each(data,function(index, item){
				htmlContent += 
					"<li onclick=replyDetail('" + item.rno + "') class='left clearfix' data-rno='" + item.rno + "'>"
					+"<div>"
					+	"<div class='header'><strong class='primary-font'>["+ item.rno +"] "+ item.replyer +"</strong>" 
					+		"<small class='pull-right text-muted'>"+ item.updatedate +"</small>"
					+	"</div>"
					+		"<p>"+ item.reply +"</p>"
					+	"</div>"
					+	"</li>";
				
			});
			$(".chat").html(htmlContent);
		}, 
		error : function(xhr, status, error){
			console.log("error", error);	
		}
	});
}

/*
 * Reply Insert
 */
function ajaxInsert(){
	
	// 입력할 파라메터를 javascript Object로 만들어 줍니다 
	var replyData = {
			bno : $("#bno").val(),
			reply : $("#reply").val(),
			replyer : $("#replyer").val()
	};
	
	console.log("obj", replyData);
	console.log("json", JSON.stringify(replyData));
	
	$.ajax({
		url : '/replies/insert',
		method : 'post',
		dataType : 'json',
		
		// JSON 형식으로 변환
		data : JSON.stringify(replyData),
		contentType : 'application/json; charset=UTF-8',
		
		success: function(data, status){
			
			console.log(data);
			
			if(data.result == "success"){
				// 모달창을 닫기
				$("#myModal").modal("hide");
				// 리스트 조회하기
				getAjaxList();				
			} else {
				alert("입력중 오류가 발생했습니다.");	
			}
		},
		error : function(xhr, status, error){
			console.log(error);
		}
	});
}

/**
 * 1건의 리플을 조회 
 * @returns
 */
function getAjax(){
	
	$.ajax({
		url : '/replies/get/' + $("#rno").val(),
		method : 'get',
		dataType : 'json',
		
		success : function(data, status){
			console.log(data);

			$("#reply").val(data.reply);
			$("#replyer").val(data.replyer);
			
		},
		error : function(xhr, status, error){
			console.log(data);
		}
		
		
	});
}

/**
 * 1건 삭제 
 * @returns
 */
function deleteAjax(){
	console.log("deleteAjax start....");
	$.ajax({
		url : '/replies/delete/' + $("#rno").val(),
		method : 'get',
		dataType : 'json',
		
		success : function(data, status){
			console.log(data);
			getAjaxList();
		},
		error : function(xhr, status, error){
			alert("fail");
			console.log(error);
		}
		
		
	});
}

/*
 *	update reply 
*/
function updateAjax(){
	console.log("updateAjax..........")

	var replyData = {
		rno : $("#rno").val(),
		reply : $("#reply").val(),
		replyer : $("#replyer").val()
	};

	$.ajax({
		url: '/replies/update/',
		method: 'post',
		dataType: 'json',

		data: JSON.stringify(replyData),
		contentType: 'application/json; charset=utf-8',

		success: function(data,staus){
			if(data.result === "success"){
				$("#myModal").modal("hide");
				getAjaxList();
			} else {
				alert("입력중 오류가 발생했습니다.");
			}
		},
		error : function(error){
			console.log(error);
			alert("error");
		}
	});

}



/* function commAjax(url, method, data, callback, error){
	
	$.ajax({
			
			url : url,
			method : method,
			dataType : 'json',
			
			// JSON 형식으로 변환
			data : JSON.stringify(data),
			contentType : 'application/json; charset=UTF-8',
			
			success: function(data, status){
				console.log(data);
				if(callback){
					callback(data);
				}
			},
			error : function(xhr, status, error){
				console.log(error);
				if(error){
					error(errorThrown);
				}
			}
				
		});
} */