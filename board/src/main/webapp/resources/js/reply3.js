/**
 *  reply ajax
 */
function getList(){
    $.ajax({
        url: '/replies/pages/'+ $("#bno").val() + '/' + $('#pageNum').val(),
        type  : 'get',
        dataType : 'json',
        
        success : function(data, textStatus, jqXHR){
            $('.chat').html("");
            var str = "";
            
            $.each(data, function(i,list){
                str += "<li id='"+list.rno+"' class='left clearfix' data-rno='"+list.rno+"'><div><div class='header'><strong class='primary-font'>[" + list.rno + "] " + list.replyer +"</strong><small class='pull-right text-muted'>"+list.updatedate +"</small></div><p>"+ list.reply+"</p></div></li>"
            });
            $('.chat').append(str);
        },
        
        error : function(jqXHR, textStatus, errorThrown){
            alert(textStatus);
            console.log("textStatus", textStatus);
        }

    });
}// get list

function insertReply(){
	
	var replyData = {
		bno : $("#bno").val(),
		reply :  $('#reply').val(),
		replyer : $('#replyer').val()
	};
	
	$.ajax({
        url: '/replies/insert',
        
        type : 'post',
        dataType : 'json',
        
        data : JSON.stringify(replyData),
        contentType : 'application/json; charset=UTF-8',
        
        success : function(data, textStatus, jqXHR){
        	console.log(data);
        	
        	if(data.result = "success"){
        		// close modal
        		alert('success');
        		
        		$('#myModal').modal('hide');	//front에 만들면 기다려주지않고 넘어감
        		
        		//refresh
        		getList();
        		
        	} else {
        		alert('입력 중 오류가 발생했습니다.');
        	}
        },
        
        error : function(jqXHR, textStatus, errorThrown){
            alert(textStatus);
            console.log("textStatus", textStatus);
        }

    });
}//insert

function getReply(rno){
    $.ajax({
        url: '/replies/get/'+ rno,
        type  : 'get',
        dataType : 'json',
        
        success : function(data, textStatus, jqXHR){
        	console.log(data);
        	$('#reply').val(data.reply);
        	$('#replyer').val(data.replyer);
        },
        
        error : function(jqXHR, textStatus, errorThrown){
        	console.log(errorThrown);
        }

    });
}// get by rno

























/*
function commAjax(url,method,data,callBack,error){
	$.ajax({
        url: url,
        
        type : method,
        dataType : 'json',
        
        data : JSON.stringify(data),
        contentType : 'application/json; charset=UTF-8',
        
        success : function(data, textStatus, jqXHR){
        	console.log(data);
        	if(callBack){
        		callBack(data);
        	}
        },
        
        error : function(jqXHR, textStatus, errorThrown){
        	console.log(error);
        	if(error){
        		error(errorThrown);
        	}
        }

    });
}
*/