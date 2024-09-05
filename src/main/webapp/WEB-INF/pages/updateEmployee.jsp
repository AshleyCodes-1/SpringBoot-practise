<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>update Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

	<h1>${message}</h1>
	<h2>Update Form</h2>
	<img src="images/login.jpg" alt="login page" style="height:100px,weidth:100px">
	<form action="updateEmployee" method="post">
	    <div class="form-group">
	      <label for="empId">Employee Id:</label>
	      <input type="hidden" class="form-control" value ="${employee.employeeId}" name="employeeId">
	    </div>
	    
	    <div class="form-group">
	      <label for="empName">Employee Name:</label>
	      <input type="text" class="form-control"  value ="${employee.employeeName}" name="employeeName">
	    </div>
	    
	    <div class="form-group">
	      <label for="salary">Salary:</label>
	      <input type="text" class="form-control" value ="${employee.salry}" name="salry">
	    </div>
	    
	    <div class="form-group">
	      <label for="emailId">Email Id:</label>
	      <input type="text" class="form-control" value ="${employee.emailId}" name="emailId">
	    </div>
	    
	    <div class="form-group">
	      <label for="pwd">Password:</label>
	      <input type="text" class="form-control" value ="${employee.password}" name="password">
	    </div>
	    
	    <button type="submit" class="btn btn-primary">Update</button>
	        
	  </form>
</div>

</body>
</html>