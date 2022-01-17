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
		<div class="content-wrapper" style="min-height: 2117.6875px;">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">주식 Dashboard</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
								<li class="breadcrumb-item active">주식 Dashboard</li>
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
						<div class="col-lg-6">
							<div class="card">
								<div class="card-header border-0">
									<div class="d-flex justify-content-between">
										<h3 class="card-title">증권 정보</h3>
										<a href="javascript:void(0);">자세한 분석 보기</a>
									</div>
								</div>
								<div class="card-body">
									<div class="d-flex">
										<p class="d-flex flex-column">
											<span class="text-bold text-lg">코스피</span> <span>2887.07</span>
										</p>
										<p class="ml-auto d-flex flex-column text-right">
											<span class="text-primary"> <i
												class="fas fa-arrow-down"></i> -2.19%
											</span> <span class="text-muted">전월 대비</span>
										</p>
									</div>
									<!-- /.d-flex -->

									<div class="position-relative mb-4">
										<div class="chartjs-size-monitor">
											<div class="chartjs-size-monitor-expand">
												<div class=""></div>
											</div>
											<div class="chartjs-size-monitor-shrink">
												<div class=""></div>
											</div>
										</div>
										<canvas id="myChart" height="400" width="620"
											class="chartjs-render-monitor"
											style="display: block; height: 200px; width: 310px;"></canvas>
									</div>

									<div class="d-flex flex-row justify-content-end">
										<span class="mr-2"> <i
											class="fas fa-square text-primary"></i>1 월
										</span> <span> <i class="fas fa-square text-danger"></i>12 월
										</span>
									</div>
								</div>
							</div>
							<!-- /.card -->

							<div class="card">
								<div class="card-header border-0">
									<h3 class="card-title">구성종목</h3>
									<div class="card-tools">
										<a href="#" class="btn btn-tool btn-sm"> <i
											class="fas fa-download"></i>
										</a> <a href="#" class="btn btn-tool btn-sm"> <i
											class="fas fa-bars"></i>
										</a>
									</div>
								</div>
								<div class="card-body table-responsive p-0">
									<table class="table table-striped table-valign-middle">
										<thead>
											<tr>
												<th>종목</th>
												<th>시세</th>
												<th>등락률</th>
												<th>더보기</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><img src="${path}/dist/img/samsung.png"
													alt="Product 1" class="img-circle img-size-32 mr-2">
													삼성전자</td>
												<td>₩ 77,000 KRW</td>
												<td><small class="text-danger mr-1"> <i
														class="fas fa-arrow-up"></i> +12%
												</small></td>
												<td><a href="#" class="text-muted"> <i
														class="fas fa-search"></i>
												</a></td>
											</tr>
											<tr>
												<td><img src="${path}/dist/img/skhynix.png"
													alt="Product 1" class="img-circle img-size-32 mr-2">
													SK하이닉스</td>
												<td>₩ 125,000 KRW</td>
												<td><small class="text-primary mr-1"> <i
														class="fas fa-arrow-down"></i> -0.5%
												</small></td>
												<td><a href="#" class="text-muted"> <i
														class="fas fa-search"></i>
												</a></td>
											</tr>
											<tr>
												<td><img src="${path}/dist/img/kakao.png"
													alt="Product 1" class="img-circle img-size-32 mr-2">
													카카오</td>
												<td>₩ 92,500 KRW</td>
												<td><small class="text-primary mr-1"> <i
														class="fas fa-arrow-down"></i> -1.49%
												</small></td>
												<td><a href="#" class="text-muted"> <i
														class="fas fa-search"></i>
												</a></td>
											</tr>
											<tr>

												<td><img src="${path}/dist/img/kakaoent.png"
													alt="Product 1" class="img-circle img-size-32 mr-2">
													카카오 Ent. <span class="badge bg-danger">NEW</span></td>
												<td>₩ 55,500 KRW</td>
												<td><small class="text-danger mr-1"> <i
														class="fas fa-arrow-up"></i> +30%
												</small></td>
												<td><a href="#" class="text-muted"> <i
														class="fas fa-search"></i>
												</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col-md-6 -->
						<div class="col-lg-6">
							<div class="card">
								<div class="card-header border-0">
									<div class="d-flex justify-content-between">
										<h3 class="card-title">주요 재무</h3>
										<a href="javascript:void(0);">자세한 분석 보기</a>
									</div>
								</div>
								<div class="card-body">
									<div class="d-flex">
										<p class="d-flex flex-column">
											<span class="text-bold text-lg">카카오</span> <span>035720<small>코스피</small></span>
										</p>
										<p class="ml-auto d-flex flex-column text-right">
											<span class="text-primary"> <i class="fas fa-arrow-down"></i>
												-21.0%
											</span> <span class="text-muted">전월 대비</span>
										</p>
									</div>
									<!-- /.d-flex -->

									<div class="position-relative mb-4">
										<div class="chartjs-size-monitor">
											<div class="chartjs-size-monitor-expand">
												<div class=""></div>
											</div>
											<div class="chartjs-size-monitor-shrink">
												<div class=""></div>
											</div>
										</div>
										<canvas id="myChart2" height="400" width="620"
											class="chartjs-render-monitor"
											style="display: block; height: 200px; width: 310px;"></canvas>
									</div>

									<div class="d-flex flex-row justify-content-end">
										<span class="mr-2">
										 <i	class="fas fa-square" style="color:#FF6384 "></i><small>매출액</small>
										</span>
										<span>
										  <i class="fas fa-square" style="color:#007BFF"></i><small>영업이익</small>
										</span>
										<span>
										  <i class="fas fa-square" style="color:#6CBDBF"></i><small>당기순이익</small>
										</span>
										<span>
										  <i class="fas fa-square" style="color:#8F63E8"></i><small>지배주주순이익</small>
										</span>
										<span>
										  <i class="fas fa-square" style="color:#647BCD"></i><small>비재배주주순이익</small>
										</span>
									</div>
								</div>
							</div>
							<!-- /.card -->

							<div class="card">
								<div class="card-header border-0">
									<h3 class="card-title">투자자별 매매동향</h3>
									<div class="card-tools">
										<a href="#" class="btn btn-sm btn-tool"> <i
											class="fas fa-download"></i>
										</a> <a href="#" class="btn btn-sm btn-tool"> <i
											class="fas fa-bars"></i>
										</a>
									</div>
								</div>
								<div class="card-body">
									<div
										class="d-flex justify-content-between align-items-center border-bottom mb-3">
										<p class="text-success text-xl">
											<i class="ion ion-ios-refresh-empty"></i>
										</p>
										<p class="d-flex flex-column text-right">
											<span class="font-weight-bold"> <i
												class="ion ion-android-arrow-up text-success"></i> 12%
											</span> <span class="text-muted">개인</span>
										</p>
									</div>
									<!-- /.d-flex -->
									<div
										class="d-flex justify-content-between align-items-center border-bottom mb-3">
										<p class="text-warning text-xl">
											<i class="ion ion-ios-cart-outline"></i>
										</p>
										<p class="d-flex flex-column text-right">
											<span class="font-weight-bold"> <i
												class="ion ion-android-arrow-up text-warning"></i> 0.8%
											</span> <span class="text-muted">외국인</span>
										</p>
									</div>
									<!-- /.d-flex -->
									<div
										class="d-flex justify-content-between align-items-center mb-0">
										<p class="text-danger text-xl">
											<i class="ion ion-ios-people-outline"></i>
										</p>
										<p class="d-flex flex-column text-right">
											<span class="font-weight-bold"> <i
												class="ion ion-android-arrow-down text-danger"></i> 1%
											</span> <span class="text-muted">기관</span>
										</p>
									</div>
									<!-- /.d-flex -->
								</div>
							</div>
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
		<%@ include file="../include/footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<%@ include file="../include/plugin_js.jsp"%>
	<%@ include file="../include/charts.jsp"%>
</body>
</html>
