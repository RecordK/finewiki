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
											src="${path}/dist/img/profile.png" alt="User profile picture">
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
									<a href="#" class="btn btn-primary btn-xs infoModBtn" data-toggle="modal"
										data-target="#userInfoModal"> <i class="fa fa-info-circle">
											회원정보 수정</i>
									</a> <a href="#" class="btn btn-primary btn-xs pwModBtn" data-toggle="modal"
										data-target="#userPwModal"> <i
										class="fa fa-question-circle"> 비밀번호 수정</i>
									</a> <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
										data-target="#userOutModal"> <i class="fa fa-user-times">
											회원 탈퇴</i>
									</a>
								</div>
							</div>
						</div>

						<!-- 게시판내가 쓴 글 관련 -->
						<div class="col-md-7">
							<div class="card">
								<div class="nav-tabs-custom">
									<div class="card-header p-2">
										<ul class="nav nav-pills">
											<li class="nav-item"><a class="nav-link active"
												href="#myStockPosts" data-toggle="tab"> <i
													class="fas fa-pencil-square-o"></i> 주식게시판
											</a></li>

											<li class="nav-item"><a class="nav-link"
												href="#myEstatePosts" data-toggle="tab"> <i
													class="fas fa-pencil-square-o"></i> 부동산게시판
											</a></li>

											<li class="nav-item"><a class="nav-link"
												href="#myFreePosts" data-toggle="tab"> <i
													class="fas fa-pencil-square-o"></i> 자유게시판
											</a></li>
										</ul>
									</div>
									<div class="card-body">
										<div class="tab-content">

											<!-- 주식게시판 글 -->
											<div class="active tab-pane" id="myStockPosts">
												<table id="myStockPostsTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 15%">번호</th>
															<th style="width: 25%">제목</th>
															<th style="width: 65%">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="stockvo" varStatus="s"
															items="${memberStockList}">
															<tr>
																<td>${s.index + 1}</td>
																<td><a
																	href="${path}/board/stock/read?data_no=${stockvo.data_no}">
																		<c:choose>
																			<c:when test="${fn:length(stockvo.title) > 10}">
																				<c:out value="${fn:substring(stockvo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${stockvo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when test="${fn:length(stockvo.content) > 30}">
																			<c:out
																				value="${fn:substring(stockvo.content, 0, 29)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${stockvo.content}" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>

											<!-- 부동산게시판 글 -->
											<div class="tab-pane" id="myEstatePosts">
												<table id="myEstatePostsTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 15%">번호</th>
															<th style="width: 25%">제목</th>
															<th style="width: 65%">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="estatevo" varStatus="e"
															items="${memberEstateList}">
															<tr>
																<td>${e.index + 1}</td>
																<td><a
																	href="${path}/board/estate/read?data_no=${estatevo.data_no}">
																		<c:choose>
																			<c:when test="${fn:length(estatevo.title) > 10}">
																				<c:out value="${fn:substring(estatevo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${estatevo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when test="${fn:length(estatevo.content) > 30}">
																			<c:out
																				value="${fn:substring(estatevo.content, 0, 29)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${freeestatevovo.content}" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>

											<!-- 자유게시판 글 -->
											<div class="tab-pane" id="myFreePosts">
												<table id="myFreePostsTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 15%">번호</th>
															<th style="width: 25%">제목</th>
															<th style="width: 65%">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="freevo" varStatus="f"
															items="${memberFreeList}">
															<tr>
																<td>${f.index + 1}</td>
																<td><a
																	href="${path}/board/free/read?data_no=${freevo.data_no}">
																		<c:choose>
																			<c:when test="${fn:length(freevo.title) > 10}">
																				<c:out value="${fn:substring(freevo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${freevo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when test="${fn:length(freevo.content) > 30}">
																			<c:out value="${fn:substring(freevo.content, 0, 29)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${freevo.content}" />
																		</c:otherwise>
																	</c:choose></td>
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

						<!-- 게시판내가 쓴 댓글 관련 -->
						<div class="col-md-5">
							<div class="card">
								<div class="nav-tabs-custom">
									<div class="card-header p-2">
										<ul class="nav nav-pills">
											<li class="nav-item"><a class="nav-link active"
												href="#myStockReplies" data-toggle="tab"> <i
													class="fas fa-comment-o"></i> 주식 게시판 댓글
											</a></li>

											<li class="nav-item"><a class="nav-link"
												href="#myEstateReplies" data-toggle="tab"> <i
													class="fas fa-comment-o"></i> 부동산 게시판 댓글
											</a></li>

											<li class="nav-item"><a class="nav-link"
												href="#myFreeReplies" data-toggle="tab"> <i
													class="fas fa-comment-o"></i> 자유 게시판 댓글
											</a></li>
										</ul>
									</div>
									<div class="card-body">
										<div class="tab-content">

											<!-- 주식게시판 댓글 -->
											<div class="tab-pane active" id="myStockReplies">
												<table id="myStockRepliesTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 100px">번호</th>
															<th style="width: 250px">게시글 제목</th>
															<th style="width: 250px">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="memberStockReply" varStatus="i"
															items="${memberStockReplies}">
															<tr>
																<td>${i.index + 1}</td>
																<td><a
																	href="${path}/board/stock/read?data_no=${memberStockReply.stockvo.data_no}">
																		<c:choose>
																			<c:when
																				test="${fn:length(memberStockReply.stockvo.title) > 10}">
																				<c:out
																					value="${fn:substring(memberStockReply.stockvo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${memberStockReply.stockvo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when
																			test="${fn:length(memberStockReply.reply_text) > 10}">
																			<c:out
																				value="${fn:substring(memberStockReply.reply_text, 0, 9)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${memberStockReply.reply_text}" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>

											<!-- 부동산게시판 댓글 -->
											<div class="tab-pane" id="myEstateReplies">
												<table id="myEstateRepliesTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 100px">번호</th>
															<th style="width: 250px">게시글 제목</th>
															<th style="width: 250px">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="memberEstateReply" varStatus="i"
															items="${memberEstateReplies}">
															<tr>
																<td>${i.index + 1}</td>
																<td><a
																	href="${path}/board/estate/read?data_no=${memberEstateReply.estatevo.data_no}">
																		<c:choose>
																			<c:when
																				test="${fn:length(memberEstateReply.estatevo.title) > 10}">
																				<c:out
																					value="${fn:substring(memberEstateReply.estatevo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${memberEstateReply.estatevo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when
																			test="${fn:length(memberEstateReply.reply_text) > 10}">
																			<c:out
																				value="${fn:substring(memberEstateReply.reply_text, 0, 9)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${memberEstateReply.reply_text}" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>

											<!-- 자유게시판 댓글 -->
											<div class="tab-pane" id="myFreeReplies">
												<table id="myFreeRepliesTable"
													class="table table-bordered table-striped">
													<thead>
														<tr>
															<th style="width: 100px">번호</th>
															<th style="width: 250px">게시글 제목</th>
															<th style="width: 250px">내용</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="memberFreeReply" varStatus="i"
															items="${memberFreeReplies}">
															<tr>
																<td>${i.index + 1}</td>
																<td><a
																	href="${path}/board/free/read?data_no=${memberFreeReply.freevo.data_no}">
																		<c:choose>
																			<c:when
																				test="${fn:length(memberFreeReply.freevo.title) > 10}">
																				<c:out
																					value="${fn:substring(memberFreeReply.freevo.title, 0, 9)}" />
																			</c:when>
																			<c:otherwise>
																				<c:out value="${memberFreeReply.freevo.title}" />
																			</c:otherwise>
																		</c:choose>
																</a></td>
																<td><c:choose>
																		<c:when
																			test="${fn:length(memberFreeReply.reply_text) > 10}">
																			<c:out
																				value="${fn:substring(memberFreeReply.reply_text, 0, 9)}" />
																		</c:when>
																		<c:otherwise>
																			<c:out value="${memberFreeReply.reply_text}" />
																		</c:otherwise>
																	</c:choose></td>
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
		<script src="${path}/plugins/datatables/js/jquery.dataTables.min.js"></script>
		<script
			src="${path}/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

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
				$("#myStockPostsTable").DataTable(param);
				$("#myEstatePostsTable").DataTable(param);
				$("#myFreePostsTable").DataTable(param);

				$("#myStockRepliesTable").DataTable(param);
				$("#myEstateRepliesTable").DataTable(param);
				$("#myFreeRepliesTable").DataTable(param);

				$("#myBookmarksTable").DataTable(param);
			});
		</script>
</body>
</html>
