<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="main-header navbar navbar-expand navbar-white navbar-light" style="background:#8cbaff">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
		<li class="nav-item d-none d-sm-inline-block"><a
			href="/finewiki" class="nav-link" style="color:black">Home</a></li>
			</ul>
	<!-- SEARCH FORM -->
	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<c:if test="${not empty login}">
			<li class="nav-item dropdown user user-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <img
					src="${path}/dist/img/profile.png" class="user-image"
					alt="User Image"> <span class="hidden-xs">${login.mem_name}</span>
			</a>
				<ul class="dropdown-menu">
					<li class="user-header"><img
						src="${path}/dist/img/profile.png" class="img-circle"
						alt="User Image">
						<p>
							<small> 가입일자 : <fmt:formatDate
									value="${login.mem_join_date}" pattern="yyyy-MM-dd" />
							</small> <small> 최근로그인일자 : <fmt:formatDate
									value="${login.mem_join_date}" pattern="yyyy-MM-dd" />
							</small>
						</p></li>
					<li class="user-footer">
						<div class="float-left">
							<a href="${path}/member/profile" class="btn btn-default btn-flat"><i
								class="fa fa-info-circle"></i><b> 내 프로필</b></a>
						</div>
						<div class="float-right">
							<a href="${path}/member/logout" class="btn btn-default btn-flat"><i
								class="glyphicon glyphicon-log-out"></i><b> 로그아웃</b></a>
						</div>
					</li>
				</ul></li>
		</c:if>
		<c:if test="${empty login}">
			<li class="nav-item dropdown user user-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <img
					src="${path}/dist/img/profile.png" class="user-image"
					alt="User Image"> <span class="hidden-xs" style="color:black">회원가입 또는 로그인</span>
			</a>
				<ul class="dropdown-menu">
					<li class="user-header"><img
						src="${path}/dist/img/profile.png" class="img-circle"
						alt="User Image">
						<p>
							<b>회원가입 또는 로그인해주세요</b> <small></small>
						</p></li>
					<li class="user-footer">
						<div class="float-left">
							<a href="${path}/member/register" class="btn btn-default btn-flat"><i
								class="fas fa-user-plus"></i><b> 회원가입</b></a>
						</div>
						<div class="float-right">
							<a href="${path}/member/login" class="btn btn-default btn-flat"><i
								class="glyphicon glyphicon-log-in"></i><b> 로그인</b></a>
						</div>
					</li>
				</ul></li>
		</c:if>
	</ul>
</nav>

