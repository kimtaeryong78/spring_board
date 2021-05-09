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
			<!-- 여기다 attach -->
			<div class="panel-heading">Board Read</div>
			<div class="panel-body">
				<form action="/board/edit" method="post">
					<div class="form-group">
						<label>No.</label><input type="text" class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly>
					</div>
					<div class="form-group">
						<label>Title</label><input type="text" class="form-control" name="title" value='<c:out value="${board.title}"/>'>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input type="text" class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly>
					</div>
					<input type="hidden" name="pageNum" value="<c:out value='${criteria.pageNum}'/>">
					<input type="hidden" name="amount" value="<c:out value='${criteria.amount}'/>">
					<input type="hidden" name="type" value="<c:out value='${criteria.type}'/>">
					<input type="hidden" name="word" value="<c:out value='${criteria.word}'/>">
					
					<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="delete" class="btn btn-danger" <%-- onclick="location.href='/board/delete?bno=<c:out value="${board.bno}"/>'" --%> >Remove</button>
					<button data-oper="list" class="btn btn-info">List</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('button').on('click',function(e){
		e.preventDefault();
		var oper = $(this).data('oper');
		if(oper === 'remove')		$('form').attr('action','/board/delete');
		else if(oper === 'list')	{
			$('form').attr('action','/board/list').attr('method','get'); 
		}
		$('form').submit();
	});
});
</script>
<%@ include file="../includes/footer.jsp"%>