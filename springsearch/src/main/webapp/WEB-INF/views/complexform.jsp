<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device=wdth, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Complex Form</title>
</head>
<body class="" style="backgtoung: #e2e2e2;">

	<div class="container mt-4">


		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Complex Form</h3>
						<div class="alert alert-danger" role="alert">
						<form:errors path="student.*"/>
  
</div>

						<form action="handleform" method="Post">

							<div class="form-group">
								<label for="exampleInputEmail1">Your Name</label> <input
									name="name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Name"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									name with anyone else</small>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Your Id</label> <input name="id"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Id">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Your DOB</label> <input
									name="dob" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="dd/mm/yyyy">
							</div>

							<div class="form-group">
								<label for="exampleFormControlSelect1">Select Courses</label> <select
									name="courses" class="form-control" id="exampleFormControlSelect1"
									multiple>
									<option>Java</option>
									<option>C++</option>
									<option>Python</option>
									<option>Django</option>
									<option>Spring</option>

								</select>
							</div>

							<div class="form-group">
								<span class="mr-3">Select Gender</span>

								<div class="form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="inlineRadio1" value="male"><label
										class="form-check-label" for="inlineRadio1">Male</label>
								</div>

								<div class="form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="inlineRadio1" value="female"><label
										class="form-check-label" for="inlineRadio1">Female</label>
								</div>

							</div>

							<div class="form-group">

								<label for="">Select Type</label> <select class="form-control"
									name="type">
									<option value="oldstudent">Old Student</option>
									<option value="newstudent">New Student</option>
								</select>

							</div>
							
							<div class="card">
							<div class="card-body">
							<p>Your Address</p>
							
							<div class="form-group">
							<input name="address.street" type="text" class="form-control" placeholder="Enter Street"/>
							</div>
							
							<div class="form-group">
							<input name="address.city" type="text" class="form-control" placeholder="Enter City"/>
							</div>
							
							</div>
							
							
							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Submit</button>

							</div>



						</form>



					</div>


				</div>


			</div>



		</div>


	</div>



</body>
</html>