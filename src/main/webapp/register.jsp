<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Register</title>

    <!-- Bootstrap core CSS -->
    <link href="staticfiles/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="staticfiles/css/style_admin.css" rel="stylesheet">
</head>

<body>

<div id="register-page">
    <div class="container">

        <form class="form-login" action="your_registration_servlet_or_jsp" method="post">
            <h2 class="form-login-heading">Register</h2>
            <div class="login-wrap">
                <input type="text" class="form-control" name="username" placeholder="Username" autofocus required>
                <br>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                <br>
                <input type="text" class="form-control" name="fullname" placeholder="Full Name" required>
                <br>
                <input type="text" class="form-control" name="phone_number" placeholder="Phone Number" required>
                <br>

                <!-- Dropdown for seller registration -->
                <label for="sellerOption">Bạn muốn đăng kí là người bán hàng?</label>
                <select class="form-control" name="sellerOption" id="sellerOption" required>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <br>

                <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-user-plus"></i> Register</button>
                <hr>

                <div class="registration">
                    Already have an account?<br/>
                    <a class="" href="login.jsp">
                        Log in here
                    </a>
                </div>

            </div>
        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="staticfiles/js/jquery.js"></script>
<script src="staticfiles/js/bootstrap.min.js"></script>

</body>
</html>
