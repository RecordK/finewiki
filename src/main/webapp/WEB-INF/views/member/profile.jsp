<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file="../include/head.jsp"%>
<body class="hold-transition sidebar-mini layout-boxed">
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="../include/main_header.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../include/left_navi.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
						<h1 class="m-0">내 정보</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
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
						<div class="col-md-5">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle"
											src="${path}/dist/img/profile/${login.mem_img}"
											alt="User profile picture">
									</div>
									<h3 class="profile-username text-center">${login.mem_name}</h3>

									<div class="text-center">
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
											data-target="#userPhotoModal"> <i class="fa fa-photo">
												프로필사진 수정</i>
										</a>
									</div>
									<ul class="list-group list-group-unbordered mb-5">
										<li class="list-group-item"><b>아이디</b> <a
											class="float-right">${login.mem_id}</a></li>
										<li class="list-group-item"><b>이메일</b> <a
											class="float-right">${login.mem_email}</a></li>
										<li class="list-group-item"><b>가입일자</b> <a
											class="float-right"> <fmt:formatDate
													value="${login.mem_join_date}" pattern="yyyy-MM-dd" />
										</a></li>
										<li class="list-group-item"><b>최근 로그인 일자</b> <a
											class="float-right"> <fmt:formatDate
													value="${login.mem_login_date}" pattern="yyyy-MM-dd" />

										</a></li>
									</ul>
								</div>
								<div class="card-footer text-center">
									<a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
										data-target="#userInfoModal"> <i class="fa fa-info-circle">
											회원정보 수정</i>
									</a> <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
										data-target="#userPwModal"> <i
										class="fa fa-question-circle"> 비밀번호 수정</i>
									</a> <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
										data-target="#userOutModal"> <i class="fa fa-user-times">
											회원 탈퇴</i>
									</a>
								</div>
							</div>
						</div>
						<div class="col-md-7">
							<div class="card">
								<div class="nav-tabs-custom">
									<div class="card-header p-2">
										<ul class="nav nav-pills">
											<li class="nav-item"><a class="nav-link active"
												href="#myPosts" data-toggle="tab"> <i
													class="fas fa-pencil-square-o"></i> 나의 게시물
											</a></li>
											<li class="nav-item"><a class="nav-link"
												href="#myReplies" data-toggle="tab"> <i
													class="fas fa-comment-o"></i> 나의 댓글
											</a></li>
										</ul>
									</div>
									<div class="card-body">
										<div class="tab-content">
											<div class="active tab-pane" id="myPosts">
												<table id="myPostsTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 10%">번호</th>
															<th style="width: 70%">제목</th>
															<th style="width: 20%">작성일자</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="boardVo" varStatus="i"
															items="${memberBoardList}">
															<tr>
																<td>${i.index + 1}</td>
																<td><a
																	href="${path}/board/paging/search/read?data_no=${boardVo.data_no}">
																		<c:choose>
																			<c:when test="${fn:length(boardVo.title) > 30}">
																				<c:out value="${fn:substring(boardVo.title, 0, 29)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${boardVo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><fmt:formatDate pattern="yyyy-MM-dd-hh-mm-ss"
																		value="${boardVo.regdate}" /></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<div class="tab-pane" id="myReplies">
												<table id="myRepliesTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 10px">번호</th>
															<th style="width: 250px">게시글 제목</th>
															<th style="width: 250px">내용</th>
															<th style="width: 150px">작성일자</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="memberReply" varStatus="i"
															items="${memberReplies}">
															<tr>
																<td>${i.index + 1}</td>
																<td><a
																	href="${path}/board/paging/search/read?data_no=${memberReply.boardVo.data_no}">
																		<c:choose>
																			<c:when
																				test="${fn:length(memberReply.boardVo.title) > 10}">
																				<c:out
																					value="${fn:substring(memberReply.boardVo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${memberReply.boardVo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when
																			test="${fn:length(memberReply.reply_text) > 10}">
																			<c:out
																				value="${fn:substring(memberReply.reply_text, 0, 9)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${memberReply.reply_text}" />
																		</c:otherwise>
																	</c:choose></td>
																<td><fmt:formatDate pattern="yyyy-MM-dd-hh-mm-ss"
																		value="${memberReply.reg_date}" /></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>
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

		</div>
		<!-- ./wrapper -->
		<%@ include file="../include/footer.jsp"%>
		<!-- REQUIRED SCRIPTS -->
		<%@ include file="../include/plugin_js.jsp"%>
		<script type="text/javascript">
			<script src="${path}/plugins/datatables/js/jquery.dataTables.min.js">
		</script>
		<script
			src="${path}/plugin/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
		<script>
			$(document).ready(function() {

				var msg = "${msg}";
				if (msg == "FAILURE") {
					alert("비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요");
				} else if (msg == "FAIL") {
					alert("이미지가 존재하지 않습니다.");
				} else if (msg == "SUCCESS") {
					alert("수정되었습니다.");
				}
				// 회원정보 수정
				$(".infoModBtn").on("click", function() {
					$("#userInfoForm").submit();
				});
				// 회원비밀번호 수정
				$(".pwModBtn").on("click", function() {
					$("#userPwForm").submit();
				});
				// 회원 프로필 이미지 수정
				$(".imgModBtn").on("click", function() {
					var file = $("#file").val();
					if (file == "") {
						alert("파일을 선택해주세요.");
						return;
					}
					$("#userImageForm").submit();
				});
				var param = {
					"language" : {
						"lengthMenu" : "_MENU_ 개씩 보기",
						"zeroRecords" : "내용이 없습니다.",
						"info" : "현재 _PAGE_ 페이지 / 전체 _PAGES_ 페이지",
						"infoEmpty" : "내용이 없습니다.",
						"infoFiltered" : "( _MAX_개의 전체 목록 중에서 검색된 결과)",
						"search" : "검색:",
						"paging" : {
							"first" : "처음",
							"last" : "마지막",
							"next" : "다음",
							"previous" : "이전"
						}
					}
				};
				$("#myPostsTable").DataTable(param);
				$("#myRepliesTable").DataTable(param);
				$("#myBookmarksTable").DataTable(param);
			});
		</script>
</body>
</html>
