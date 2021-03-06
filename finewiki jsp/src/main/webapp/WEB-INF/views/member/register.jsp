<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
				<a href="${path}/"><b>Finewiki</b></a>
		</div>

		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">회원 가입!!</p>

				<form action="${path}/member/register" method="post">
					<div class="input-group mb-3">
						<input type="text" name="mem_id" class="form-control"
							placeholder="아이디">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-exclamation"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" name="mem_name" class="form-control"
							placeholder="이름">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" name="mem_birth" class="form-control"
							placeholder="생년월일">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-birth"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" name="nick" class="form-control"
							placeholder="닉네임">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-nick"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="email" name="mem_email" class="form-control"
							placeholder="이메일">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" name="mem_pw" class="form-control"
							placeholder="비밀번호">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="비밀번호 확인">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="agreeTerms" name="terms"
									value="agree"> <label for="agreeTerms"> 동의 하기
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">가입</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<a href="${path}/member/login" class="text-center">이미 회원일 경우</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->

	<%@ include file="../include/plugin_js.jsp"%>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>