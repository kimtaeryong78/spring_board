<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp" />

<script type="text/javascript">


</script>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">

				<!-- /.panel-heading -->
				<div class="panel-body">


				
					<!-- 답글 -->
					<div class='row'>

						<div class="col-lg-12">

							<!-- /.panel -->
							<div class="panel panel-default">

								<div class="panel-heading">
									<i class="fa fa-comments fa-fw"></i> Reply
									<button id='addReplyBtn'
										class='btn btn-primary btn-xs pull-right'>New Reply</button>
								</div>


								<!-- /.panel-heading -->
								<div class="panel-body">

									<ul class="chat">
										<!-- <li class='left clearfix' data-rno='"+list.rno+"'>
											<div>
												<div class='header'>
													<strong class='primary-font'>[1] 홍길동</strong> <small
														class='pull-right text-muted'>12:00:00</small>
												</div>
												<p>수고가 많으십니다!</p>
											</div>
										</li> -->
									</ul>
<label>bno</label><input type="text" id="bno" placeholder="bno" value="222"></input>
<label>rno</label><input type="text" id="rno" placeholder="rno" value="1"></input>
<label>pageNum</label><input type="text" id="pageNum" placeholder="pageNum" value="2"></input>


									<!-- ./ end ul -->
								</div>
								<!-- /.panel .chat-panel -->

								<div class="panel-footer"></div>


							</div>
						</div>
						<!-- ./ end row -->



					</div>


				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>

</div>
<!-- /#page-wrapper -->



<!-- 모달 Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Reply</h4>
			</div>
			<div class="modal-body">
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><input type="text"
						class="form-control ml-2" placeholder="replyer" id="replyer">
					</li>
					<li class="list-group-item"><textarea class="form-control"
							id="reply" placeholder="reply" rows="3"></textarea></li>
				</ul>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" data-dismiss="modal">Modify</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Remove</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
				<button type="button" id="replyInsert" class="btn btn-primary">save</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<script src="/resources/js/reply.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		getList();
		
		// addReply button 모달창
		$('#addReplyBtn').on('click',function(e){
			e.preventDefault();
			$('#reply').html("");
			$('#replyer').html("");
			$('#replyInsert').show();
			$('#myModal').modal('show');
		});
		
		//insert process
		$('#replyInsert').on('click',function(e){
			e.preventDefault();
			insertReply();
		});
		
		$('.chat').on('click',function(e){
			var rno = $(this).data('rno');
			getReply(rno);
			$('#replyInsert').hide();
			$('#myModal').modal('show');
		});
		
	});
	
	//
</script>

<jsp:include page="../includes/footer.jsp" />