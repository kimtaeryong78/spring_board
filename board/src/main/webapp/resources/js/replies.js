/**
 * 
 */
 
 console.log("Reply........");
 
 var replyModule = {
 	add : function(replyData, callback){
 		console.log("reply add.......");
 		
 		$.ajax({
 			url : '/replies/insert',
			method : 'post',
			dataType : 'json',
		
			data : JSON.stringify(replyData),
			contentType : 'application/json; charset=UTF-8',
			
			success : function(res,status){
				if(callback){
					callback(res.result);
				}
			}
 		});
 	},// add
 	
 	getList: function(param, callback){
 		console.log("get list...........");
 		
 		var bno = param.bno;
		var page = param.page || 1;

		$.ajax({
		
			url : "/replies/pages/" + bno + "/" + page,
			method : 'get',
			dataType : 'json',
			
			success : function(data){
				console.log(data);
				
				if(callback){
					callback(data);
				}
			}
		});
 	},// getList
 	
 	remove: function(rno, callback){
 		console.log("remove...........");
 		
 		$.ajax({
 			url : "/replies/delete/" + rno,
 			method : 'get',
 			dataType : 'json',	
 			
 			success : function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	},//remove
 	
 	update : function(reply, callback){
 		console.log("update...........");
 		
 		$.ajax({
 			url: '/replies/update/',
 			method: 'post',
 			dataType: 'json',

 			data: JSON.stringify(reply),
 			contentType: 'application/json; charset=utf-8',
 			
 			success: function(result,staus){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	},//update
 	
 	get : function(rno, callback){
 		console.log("get..............");
 		
 		$.ajax({
 			url: '/replies/get/'+rno,
 			method: 'get',
 			dataType: 'json',
 			
 			success : function(data){
 				if(callback){
 					callback(data);
 				}
 			}
 		});
 	},//get
 	
 	replyForm : function(list){
 		return '<li class="left clearfix" data-rno="'+ list.rno +'"><div><div class="header"><strong class="primary-font">['+list.rno+']&nbsp'+ list.replyer +'</strong><small class="pull-right text-muted">' + list.updatedate + '</small></div><p id="reply">'+ list.reply +'</p></div></li>';
 	}
};