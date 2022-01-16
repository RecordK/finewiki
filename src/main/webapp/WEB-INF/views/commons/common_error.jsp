<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<!-- This is a starter template page. Use this page to start your new project from scratch. This page gets rid of all links and provides the needed markup only. -->
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
			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<section class="content container-fluid">
						<h3>
							<i class="fa fa-warning text-red"></i> ${exception.getMessage()}
						</h3>
						<ul>
							<c:forEach items="${exception.getStackTrace()}" var="stack">
								<li>${stack.toString()}</li>
							</c:forEach>
						</ul>
					</section>
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
</body>
</html>

