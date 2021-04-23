/**
 *  reply ajax
 */
function getList(){
    $.ajax({
        url: '../replies/pages/222/1',
        type  : 'get',
        dataType : 'json',
        
        success : function(data, textStatus, jqXHR){
            $('.chat').html("");
            var str = "";
            
            $.each(data, function(i,list){
            	str = $("<li />",{class:left,clearfix}).append(
            			$("<td />").text(list.rno)
            			);
            	
                    str += "<li class='left clearfix' data-rno='"+list.rno+"'><div><div class='header'><strong class='primary-font'>[" + list.rno + "] " + list.replyer +"</strong><small class='pull-right text-muted'>"+list.updatedate +"</small></div><p>"+ list.reply+"</p></div></li>"
                    
                    
                    
            });
            $('.chat').append(str);
        },
        
        error : function(jqXHR, textStatus, errorThrown){
            alert(textStatus);
            console.log("textStatus", textStatus);
        }

    });
}/* get list */