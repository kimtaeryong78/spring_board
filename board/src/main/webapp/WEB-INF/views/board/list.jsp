<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board
			<button id="regBtn" class="btn btn-xs pull-right">Regist board</button></div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table style="width: 100%" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="board">
						<tr class="getBoard">
							<td>${board.bno}</td>
							<td>${board.title}</td>
							<td>${board.writer}</td>
							<td>${board.regdate}</td>
							<td>${board.updatedate}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Info</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
								<!-- <button type="button" class="btn btn-primary  default">Save changes</button> -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel -->
	</div>
</div>
<!-- /.row -->
<script type="text/javascript">
	$(document).ready(function(){
		var result = '${result}';
		checkModel(result);
		
		history.replaceState({},null,null);
		
		function checkModel(result){
			if(result === ''||history.state){return;}
			if(parseInt(result) > 0){$(".modal-body").html("${result}번 게시글이 등록되었습니다.");}
			if(result === 'delete'){$(".modal-body").html("${bno}번 게시글 삭제 처리 되었습니다.");}
			if(result === 'modify'){$(".modal-body").html("${bno}번 게시글 수정 처리 되었습니다.");}
			$("#myModal").modal("show");
		};	
		
		$(".getBoard").on("click",function(){
			var td = $(this).children();
			var bno = td.eq(0).text();
			var loca = "/board/get?bno="+bno;
			self.location = loca;
		});
		
		$("#regBtn").on("click",function(){
			self.location = "/board/register";
		});
		
	});
</script>
<%@ include file="../includes/footer.jsp"%>