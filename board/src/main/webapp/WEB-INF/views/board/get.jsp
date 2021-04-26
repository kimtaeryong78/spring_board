<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg 12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read</div>
			<div class="panel-body">
				<form action='/board/edit' method="get" id="operForm">
					<div class="form-group">														<!-- 보안을 위해 c:out를 애용 -->
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
	<script type="text/javascript" src="/resources/js/replies.js"></script>
	<script type="text/javascript">
		var bno_val = '<c:out value="${board.bno}"/>';
		
		var param = {
			bno : bno_val,
			page : 1
		};
		
		reply.getList(param, function(list){
			for(var i=0, len = list.length||0;i<len;i++){
				console.log(list[i]);
			}
			/* list.forEach(data => console.log(data)); */
		});
		
		$(document).ready(function() {
			/* console.log(reply); */
			console.log("======");
			console.log("test");
			
			
			/* $("#add").on("click",
				reply.add(
					{reply:"TEST", replyer:"tester", bno:bno_val},
					function(result){
						alert("RESULT : " + result);
					}
				)
			);
			 */
			 
			
			
			
			
			
			
			
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