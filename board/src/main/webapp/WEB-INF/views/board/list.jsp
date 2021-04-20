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
				<div class="row">
					<div class="col-lg-12">
						<form action="/board/list" id="searchForm" method="get">
							<select name="amount" class="form-select" id="amount" aria-label="Default select example">
								<option value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
							</select>
							<select name="type" class="form-select" id="type" aria-label="Default select example">
								<option value="">검색 조건</option>
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="W">작성자</option>
								<option value="TC">제목 or 내용</option>
								<option value="TW">제목 or 작성자</option>
								<option value="TWC">제목 or 내용 or 작성자</option>
							</select>
							<input type="text" name="word" value="<c:out value='${pageValues.cri.word}'/>" >
							<input type="hidden" name="pageNum" value="${pageValues.cri.pageNum}">
							<button class="btn btn-default">Search</button>
						</form>
					</div>
				</div>
				
				<div class="pull-right">
					<nav aria-label="Page navigation example">
	  					<ul class="pagination">
	  						<c:if test="${pageValues.prev}">
	    						<li class="page-item" hidden="hidden"><a class="page-link" href="1"><<</a></li>
	    						<li class="page-item" hidden="hidden"><a class="page-link" href="${pageValues.start-1}"><</a></li>
	    					</c:if>
	    					<c:forEach var="num" begin="${pageValues.start}" end="${pageValues.end}">
	    						<li class="page-item ${pageValues.cri.pageNum == num ? 'active':''}"><a class="page-link" href="${num}">${num}</a></li>
	    					</c:forEach>
	    					<c:if test="${pageValues.next}">
	    						<li class="page-item"><a class="page-link" href="${pageValues.end + 1}">></a></li>
	    						<li class="page-item"><a class="page-link" href="${pageValues.realEnd}">>></a></li>
	    					</c:if>
	  					</ul>
					</nav>
				</div>
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
		/* modal 창 처리 */
		var result = '<c:out value="${result}"/>';
		
		checkModel(result);
		
		history.replaceState({},null,null);
		
		function checkModel(result){
			if(result === ''||history.state){return;}
			if(parseInt(result) > 0){$(".modal-body").html("${result}번 게시글이 등록되었습니다.");}
			if(result === 'delete'){$(".modal-body").html("${bno}번 게시글 삭제 처리 되었습니다.");}
			if(result === 'modify'){$(".modal-body").html("${bno}번 게시글 수정 처리 되었습니다.");}
			$("#myModal").modal("show");
		};	
		
		/* 조회 창 이동 */
		$(".getBoard").on("click",function(){
			var bno = $(this).children().eq(0).text();
			$("#searchForm").append('<input type="hidden" name="bno" value="'+bno+'">').attr("action","/board/get");
			$("#searchForm").submit();
		});
		
		/* 등록 창 이동 */
		$("#regBtn").on("click",function(){
			self.location = "/board/register";
		});
		
		/* 페이징 처리 */
		$(".page-item a").on("click",function(e){
			e.preventDefault();
			$("#searchForm").find('input[name="pageNum"]').val($(this).attr("href"));
			$("#searchForm").submit();
		});
		
		/* amount 값 고정 */
		var amount = '<c:out value="${pageValues.cri.amount}"/>';
		var type = '<c:out value="${pageValues.cri.type}"/>';
		$("#amount").val(amount).prop("selected", true);
		$("#type").val(type).prop("selected", true);
		
		/* search 버튼 처리 */
		$('#searchForm button').on('click',function(e){
			if(!$('#searchForm').find("option:selected").val()){ alert("검색 종류를 선택하세요."); return false; }
			
			if(!$('#searchForm').find("input[name='word']").val()){	alert("키워드를 입력하세요."); return false;	}
			
			$('#searchForm').find("input[name='pageNum']").val('1');
			
			e.preventDefault();
			
			$('#searchForm').submit();
		});
	});
</script>
<%@ include file="../includes/footer.jsp"%>