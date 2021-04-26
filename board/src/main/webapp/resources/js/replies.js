/**
 * 
 */
 
 console.log("Reply........");
 
 var reply = (function(){
 	
 	function add(replyData, callback){
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
			},
			
			error : function(errorThrown){
				if(error){
					error(errorThrown);
				}
			}
 		});
 	}//add
 	
 	function getList(param, callback, error){
		 
 		var bno = param.bno;
		var page = param.page || 1;

		$.ajax({
		
			url : "/replies/pages/" + bno + "/" + page + ".json",
			method : 'get',
			dataType : 'json',
			
			success : function(data){
				console.log(data);
				
				if(callback){
					callback(data);
				}
			},
			
			error : function(xhr,status,err){
				if(error){
					error();
				}
			}
		});
 	}//getList
 	
 	
 	
 	
 	return {
 		add : add,
		get : getList
 	};
 })();