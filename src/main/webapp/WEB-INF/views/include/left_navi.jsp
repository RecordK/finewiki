<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="main-sidebar sidebar-light-primary elevation-4" style="background:#8cbaff">
	<!-- Brand Logo -->
	<a href="/finewiki" class="brand-link"> <img
		src="${path}/dist/img/finewiki.png" alt="Finewiki Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">Finewiki</span>
	</a>
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<c:if test="${empty login}">
				<div class="image">
					<img src="${path}/dist/img/profile.png"
						class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<%-- Status --%>
					<a href="#"><i class="fa fa-circle text-danger"></i> Guest</a>
				</div>
			</c:if>
			<c:if test="${not empty login}">
				<div class="image">
					<img src="${path}/dist/img/profile.png"
						class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<%-- Status --%>
					<a href="#"><i class="d-block"></i> ${login.mem_name}</a>
				</div>
			</c:if>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class with font-awesome or any other icon font library -->
				<li class="nav-item has-treeview menu-open"><a href="#"
					class="nav-link"><img src="${path}/dist/img/updateLogo.png"
						class="img" alt="User Image">
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;게시판 홈<i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="${path}/board/stock/list"
							class="nav-link"> <img src="${path}/dist/img/stock.png"
						class="img" alt="User Image">
								<p style="color:black">&nbsp;&nbsp;&nbsp;주식 게시판</p>
						</a></li>
						<li class="nav-item"><a href="${path}/board/estate/list"
							class="nav-link"><img src="${path}/dist/img/estate.png"
						class="img" alt="User Image">
								<p style="color:black">&nbsp;&nbsp;&nbsp;부동산 게시판</p>
						</a></li>
						<li class="nav-item"><a href="${path}/board/free/list"
							class="nav-link"> <img src="${path}/dist/img/free.png"
						class="img" alt="User Image">
								<p style="color:black">&nbsp;&nbsp;&nbsp;&nbsp;자유 게시판</p>
						</a></li>
					</ul></li>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
