<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <button id="getListBtn">리스트</button>
    <br>
    <table border="1" id="repleTbl">
        <tr>
            <td>rno</td>
            <td>bno</td>
            <td>reply</td>
            <td>replyer</td>
            <td>replydate</td>
            <td>updatedate</td>
        </tr>
    </table>
</body>
<script type="text/javascript">
$(document).ready(function(){
	/* btn event control */
    getAjaxList();
	$("#getListBtn").on("click", function(){
        console.log("test");
    });
	
	function getAjaxList(){
		$.ajax({
			url: '../replies/pages/222/1',
			method  : 'get',
			dataType : 'json',
			
			success : function(data, textStatus, jqXHR){
				console.log(data[0].bno);
				/* var str = $('#repleTbl').html(); */
				/* console.log($('#repleTbl').html()); */
				var str = null;
				
				$.each(data, function(i,item){
					str += '<tr><td>'+ item.rno + '</td><td>'+ item.bno + '</td><td>'+ item.reply+ '</td><td>'+ item.replyer+ '</td><td>'+ item.replydate+ '</td><td>'+ item.updatedate + '</td></tr>';
				});
				
				$('#repleTbl').append(str);
			},
			
			error : function(jqXHR, textStatus, errorThrown){
				alert(textStatus);
				console.log("textStatus", textStatus);
			}

		});
	}
	
	
	
});
</script>
</html>