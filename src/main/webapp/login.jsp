<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--	<meta charset="utf-8">--%>
<%--	<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--	<meta name="description" content="">--%>
<%--	<meta name="author" content="Dashboard">--%>
<%--	<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">--%>

<%--	<title>DASHGUM - Bootstrap Admin Template</title>--%>

<%--	<!-- Bootstrap core CSS -->--%>
<%--	<link href="staticfiles/css/bootstrap.min.css" rel="stylesheet">--%>
<%--	<!--external css-->--%>
<%--	<link href="staticfiles/css/font-awesome.css" rel="stylesheet" />--%>

<%--	<!-- Custom styles for this template -->--%>
<%--	<link href="staticfiles/css/style_admin.css" rel="stylesheet">--%>
<%--	<link href="staticfiles/css/style-responsive.css" rel="stylesheet">--%>

<%--	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
<%--	<!--[if lt IE 9]>--%>
<%--	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
<%--	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>--%>
<%--	<![endif]-->--%>
<%--</head>--%>

<%--<body>--%>

<%--<!-- **********************************************************************************************************************************************************--%>
<%--MAIN CONTENT--%>
<%--*********************************************************************************************************************************************************** -->--%>

<%--<div id="login-page">--%>
<%--	<div class="container">--%>
<%--		<form class="form-login" action="auth" method="post">--%>
<%--			<h2 class="form-login-heading">sign in now</h2>--%>
<%--			<div class="login-wrap">--%>
<%--				<input type="text" class="form-control" placeholder="Username" name="username" autofocus>--%>
<%--				<br>--%>
<%--				<input type="password" class="form-control" placeholder="Password" name = password>--%>
<%--				<label class="checkbox">--%>
<%--		                <span class="pull-right">--%>
<%--		                    <a data-toggle="modal" href="login.jsp#myModal"> Forgot Password?</a>--%>

<%--		                </span>--%>
<%--				</label>--%>
<%--				<button class="btn btn-theme btn-block"  type="submit"><i class="fa fa-lock"></i> SIGN IN</button>--%>
<%--				<hr>--%>

<%--				<div class="registration">--%>
<%--					Don't have an account yet?<br/>--%>
<%--					<a class="" href="#">--%>
<%--						Create an account--%>
<%--					</a>--%>
<%--				</div>--%>

<%--			</div>--%>

<%--			<!-- Modal -->--%>
<%--			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">--%>
<%--				<div class="modal-dialog">--%>
<%--					<div class="modal-content">--%>
<%--						<div class="modal-header">--%>
<%--							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
<%--							<h4 class="modal-title">Forgot Password ?</h4>--%>
<%--						</div>--%>
<%--						<div class="modal-body">--%>
<%--							<p>Enter your e-mail address below to reset your password.</p>--%>
<%--							<input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">--%>

<%--						</div>--%>
<%--						<div class="modal-footer">--%>
<%--							<button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>--%>
<%--							<button class="btn btn-theme" type="button">Submit</button>--%>
<%--						</div>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--			</div>--%>
<%--			<!-- modal -->--%>

<%--		</form>--%>

<%--	</div>--%>
<%--</div>--%>

<%--<!-- js placed at the end of the document so the pages load faster -->--%>
<%--<script src="staticfiles/js/jquery.js"></script>--%>
<%--<script src="staticfiles/js/bootstrap.min.js"></script>--%>

<%--<!--BACKSTRETCH-->--%>
<%--<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->--%>
<%--<script type="text/javascript" src="staticfiles/js/jquery.backstretch.min.js"></script>--%>
<%--<script>--%>
<%--	$.backstretch("staticfiles/img/login-bg.jpg", {speed: 500});--%>
<%--</script>--%>


<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<section class="bg-gray-50">
	<div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
		<%--        <a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900">Job?</a>--%>
		<div class="w-full bg-white rounded-lg shadow md:mt-0 sm:max-w-md xl:p-0">
			<div class="p-6 space-y-4 md:space-y-6 sm:p-8">
				<h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
					Sign in to your account
				</h1>
				<form class="space-y-4 md:space-y-6" action="auth" method="post">
					<div>
						<label for="username" class="block mb-2 text-sm font-medium text-gray-900">Username</label>
						<input type="text" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" placeholder="Type username"  required="">
					</div>
					<div>
						<label for="password" class="block mb-2 text-sm font-medium text-gray-900">Password</label>
						<input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" required="">
					</div>
<%--					<div class="flex items-center justify-between">--%>
<%--						<div class="flex items-start">--%>
<%--							<div class="flex items-center h-5">--%>
<%--								<input id="remember" aria-describedby="remember" type="checkbox" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300">--%>
<%--                            </div>--%>
<%--						</div>--%>
<%--					</div>--%>
					<% %>
					<input type="hidden" name="formType" value="login">
					<button type="submit" class="w-full text-white flex flex-row items-center justify-center w-full px-2 py-2 mb-4 text-sm font-bold bg-green-300 leading-6 capitalize duration-100 transform rounded-sm shadow cursor-pointer focus:ring-4 focus:ring-green-500 focus:ring-opacity-50 focus:outline-none sm:mb-0 sm:mr-4 md:pl-8 md:pr-6 xl:pl-12 xl:pr-10 hover:shadow-lg hover:-translate-y-1">Sign in</button>
<%--					<p class="text-sm font-light text-gray-500">--%>
<%--						Don’t have an account yet? <a href="signup.jsp" class="font-medium text-primary-600 hover:underline">Sign up</a>--%>
<%--					</p>--%>
				</form>
			</div>
		</div>
	</div>
</section>

</body>
</html>
