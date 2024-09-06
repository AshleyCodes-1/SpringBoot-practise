<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Detail page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="p-3 mb-2 bg-light text-dark">
			<img src="images/congratulations.jpeg" class="rounded"
				alt="login logo" style="width: 900px; height: 150px;"><br>
			<marquee>
				<h4>Congratulations!!!-${employeeDTO.employeeName}-You have
					successfully logged-in</h4>
			</marquee>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Employee ID</th>
						<th scope="col">Employee Name</th>
						<th scope="col">Salary</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<th scope="row">${employeeDTO.employeeId}</th>
						<td>${employeeDTO.employeeName}</td>
						<td>${employeeDTO.salary}</td>
						<td>${employeeDTO.emailId}</td>
						<td>${employeeDTO.password}</td>
					</tr>


				</tbody>
			</table>
			<a href="showEmployee" class="btn btn-secondary mt-3">All Records</a> 
		</div>
	</div>
</body>
</html>