<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file="../../include/head.jsp"%>
<body class="hold-transition sidebar-mini layout-boxed">
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="../../include/main_header.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../../include/left_navi.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
						<h1 class="m-0">자유 게시판</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">게시판</a></li>
								<li class="breadcrumb-item active">자유 게시판</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<form role="form" id="writeForm" method="post"
								action="${path}/board/free/write">
								<div class="card">
									<div class="card-header with-border">
										<h3 class="card-title">게시글 작성</h3>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label for="title">제목</label> <input class="form-control"
												id="title" name="title" placeholder="제목을 입력해주세요">
										</div>
										<div class="form-group">
											<label for="content">내용</label>
											<textarea class="form-control" id="content" name="content"
												rows="30" placeholder="내용을 입력해주세요" style="resize: none;"></textarea>
										</div>
										<div class="form-group" hidden>
											<label for="mem_nick">작성자</label> <input class="form-control"
												id="mem_nick" name="mem_nick" value="${login.mem_id}"
												readonly>
										</div>
									</div>
									<div class="card-footer">
										<button type="button" class="btn btn-primary lll">
											<i class="fa fa-list"></i> 목록
										</button>
										<div class="float-right">
											<button type="reset" class="btn btn-warning">
												<i class="fa fa-reply"></i> 초기화
											</button>
											<button type="submit" class="btn btn-success">
												<i class="fa fa-save"></i> 저장
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- /.col-md-6 -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
			<div class="p-3">
				<h5>Title</h5>
				<p>Sidebar content</p>
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<%@ include file="../../include/footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<%@ include file="../../include/plugin_js.jsp"%>
	<script type="text/javascript">
	$(document)
	.ready(
			function() {
				$(".lll")
				.on(
						"click",
						function(event){
							self.location = "${path}/board/free/list"
							
						});
			});
	</script>
</body>
</html>
