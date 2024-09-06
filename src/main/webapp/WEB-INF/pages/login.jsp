<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  	.center {
	  	display: block;
	  	margin-left: 25%;
	  	margin-right: auto;
	  	width: 100%;
	}
	.head{
		display: block;
	  	margin-left: 42%;
	  	margin-right: auto;
	  	width: 100%;
	}
	.alert {
	  padding: 20px;
	  background-color: #f44336;
	  color: white;
	}

	.closebtn {
	  margin-left: 50px;
	  color: white;
	  font-weight: bold;
	  float: right;
	  font-size: 15px;
	  line-height: 14px;
	  cursor: pointer;
	  transition: 0.3s;
	}

	.closebtn:hover {
	  color: black;
	}
  </style>
</head>
<body>

<div class="container">
  <div class="head">
  	<h2>Login Form</h2>
  </div>
  <div class="center">
  	<img src="images/login-pic.jpg" width=40% height=40% alt="login logo">
  </div>
	<div class="alert">
  		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
		<strong>${msg}</strong>
	</div>
  <form action="loginValidate" method="post">
  
    <div class="form-group">
      <label for="emailId">Email-Id:</label>
      <input type="text" class="form-control"  placeholder="Enter Email id" name="emailId">
    </div>
 
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" placeholder="Enter password" name="password">
    </div>
    
    
    
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-danger">Reset</button>
    <a href="registration"><button type="button" class="btn btn-warning">Sign Up</button></a>
  </form>
</div>

</body>
</html>