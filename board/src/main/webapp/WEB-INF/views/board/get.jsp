<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>
<!-- board -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read</div>
			<div class="panel-body">
				<form action='/board/edit' method="get" id="operForm">
					<div class="form-group">													<!-- 보안을 위해 c:out를 애용 -->
						<label>No.</label><input type="text" class="form-control" name="bno" id="bno" value="<c:out value='${board.bno}'/>" readonly>
					</div>
					<div class="form-group">
						<label>Title</label><input type="text" class="form-control" name="title" value="<c:out value='${board.title}'/>" readonly>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content" readonly><c:out value="${board.content}"/></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input type="text" class="form-control" name="writer" value="<c:out value='${board.writer}'/>" readonly>
					</div>
					<input type="hidden" name="pageNum" value="<c:out value='${criteria.pageNum}'/>">
					<input type="hidden" name="amount" value="<c:out value='${criteria.amount}'/>">
					<input type="hidden" name="type" value="<c:out value='${criteria.type}'/>">
					<input type="hidden" name="word" value="<c:out value='${criteria.word}'/>">
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="list" class="btn btn-info"> <!-- onclick="location.href='/board/list'" --> List</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- reply -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				 <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
				 </div>
			<div class="panel-body">
				<ul class="chat" data-replypn="1">
				</ul>
				<div class="pull-right" id="replyPage">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 모달 Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
				<h4 class="modal-title" id="myModalLabel">Reply</h4>
			</div>
			<div class="modal-body">
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<input type="text" class="form-control ml-2" placeholder="replyer" id="replyer">
					</li>
					<li class="list-group-item">
						<textarea class="form-control" id="reply_content" placeholder="reply" rows="3"></textarea>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" data-dismiss="modal" id="modify">Modify</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal" id="remove">Remove</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
				<button type="button" class="btn btn-primary" id="replyInsertBtn">save</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- <!-- jquery reply -->

<!-- js module -->
<script type="text/javascript" src="/resources/js/replies.js"></script>

<!-- front -->
<script type="text/javascript">

$(document).ready(function() {
	var bno_val = <c:out value="${board.bno}"/>;
	var replyPageNum = $('.chat').data("replypn");
	viewList(replyPageNum);
	
	function viewList(pn){
		
		replyModule.getList({bno:bno_val,page:pn},function(list){
			var temp = list['list'];
			$('.chat').html("");
			temp.forEach(data => $('.chat').append(replyModule.replyForm(data)));
			$('#replyPage').html(function(){
				var page = list['page'];
				var str = '<nav aria-label="Page navigation example"><ul class="pagination">';
				if(page.prev){
					str += '<li class="page-item" hidden="hidden"><a class="page-link" data-page="1"><<</a></li>';
					str += '<li class="page-item" hidden="hidden"><a class="page-link" data-page="'+ (page.start-1) +'"><</a></li>'; 
				}
				for(var i=page.start; i<=page.end; i++){
					str += '<li class="page-item';
					if(i == pn)	str += ' active';
					str += '"><a class="page-link" data-page="'+ i +'">'+ i +'</a></li>'; 					
				}
				if(page.next){
					str += '<li class="page-item"><a class="page-link" data-page="'+ (page.end+1) +'">></a></li>';
					str += '<li class="page-item"><a class="page-link" data-page="'+ page.realEnd +'">>></a></li>';
				}	
				str += '</ul></nav>';
				return str;
			})
		});
	};
	//page nav click process
	$('#replyPage').on('click','li a',function(e){
		e.preventDefault();
		console.log("click");
		var temp = $(this).data("page");
		var replyPageNum = $('.chat').data("replypn",temp);
		viewList(temp);
	});
	//show add form
	$("#addReplyBtn").on('click',function(e){
		$('#replyer').val("");
		$('#reply_content').val("");
		$('#replyInsertBtn').show();
		$('#modify, #remove').hide();
		$('#myModal').modal("show");
	});
	//add processing
	$('#replyInsertBtn').on('click',function(e){
		var temp = {
			bno : bno_val,
			reply : $('#reply_content').val(),
			replyer : $('#replyer').val(),
		};
		
		replyModule.add(temp, function(answer){
			if(answer == 'success'){
				viewList(replyPageNum);
				alert("success");
				$('#myModal').modal("hide");
			} else {
				alert("error");
			}
		});
	});
	//get detail
	$(".chat").on('click','li',function(e){
		var rno = $(this).data('rno');
		replyModule.get(rno,function(data){
			$('#replyer').val(data.replyer);
			$('#reply_content').val(data.reply);
			$('#modify, #remove').show();
			$('#replyInsertBtn').hide();
			$('#myModal').data('rno',rno).modal("show");
		});
	});
	//update
	$('#modify').on('click',function(e){
		var temp = {
			rno : $('#myModal').data('rno'),
			reply : $('#reply_content').val(),
			replyer : $('#replyer').val(),
		};
		
		replyModule.update(temp,function(answer){
			if(answer.result == 'success'){
				viewList(replyPageNum);
				alert("success");
				$('#myModal').modal("hide");
			} else {
				alert("error");
			}
		});
	});
	//delete
	$('#remove').on('click',function(e){
		var rno = $('#myModal').data('rno');
		
		replyModule.remove(rno, function(answer) {
			if(answer.result == 'success'){
				viewList(replyPageNum);
				alert("success");
				$('#myModal').modal("hide");
			} else {
				alert("error");
			}	
		});
	});
	
	//submit processing
	$('button').on('click',	function(e) {
		e.preventDefault();

		var oper = $(this).data('oper');

		if (oper === 'modify') {
			$('form').attr('action', '/board/edit').submit();
		} else if (oper === 'list') {
			$('form').attr('action', '/board/list').find("#bno").remove();
			$('form').submit();
		}
	});
	 
});
</script>
	
<%@ include file="../includes/footer.jsp"%>