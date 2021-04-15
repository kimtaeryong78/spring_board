<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				<form action="/board/edit?bno=${board.bno}" method="get">
					<div class="form-group">
						<label>No.</label><input type="text" class="form-control" name="bno" value="${board.bno}" readonly>
					</div>
					<div class="form-group">
						<label>Title</label><input type="text" class="form-control" name="title" value="${board.title}" readonly>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content" readonly>${board.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
					</div>
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button type="button" data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">List</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>