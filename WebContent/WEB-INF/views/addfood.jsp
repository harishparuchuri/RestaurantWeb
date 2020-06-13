<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food</title>
</head>
<body>



	<style>
@import
	url("https://fonts.googleapis.com/css?family=Nunito+Sans:200,400,700,800,900&display=swap");

* {
	padding: 0px;
	margin: 0px;
}

li a {
	text-decoration: none;
	color: white;
}

li {
	list-style-type: none;
	font-size: 20px;
	padding: 5px;
	font-weight: 900;
	font-family: "Nunito Sans", sans-serif;
	background-color: black;
	color: white;
	margin-right: 1px;
	border-radius: 5px;
}

li:hover {
	color: #A4B0BD;
}

.menu {
	background-color: #EAF0F1;
	display: flex;
	flex-direction: row;
	padding: 10px;
	/* margin-left: 10px; */
	box-shadow: 0 0 10px black;
}

.menu h1 {
	color: #E44236;
	font-size: 30px;
	font-weight: bold;
	font-family: "Nunito Sans", sans-serif;
}

.login {
	margin-left: 1000px;
}

body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%);
}

a {
	text-decoration: none;
	color: red;
}

.container {
	background: url(../../assets/coffee.jpg);
	background-size: cover;
	background-position: center;
	height: 92.5vh;
}

.loginbox {
	width: 400px;
	height: 480px;
	background: linear-gradient(90deg, #f8ff00 0%, #3ad59f 100%);
	color: #FF3E4D;
	left: 50%;
	top: 55%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 70px 30px;
}

.usericon {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	position: absolute;
	top: -40px;
	left: 150px;
	background: #E83350;
}

h1 {
	margin: 0;
	padding: 0 0 20px;
	text-align: center;
	font-size: 22px;
}

.loginbox p {
	margin: 0;
	padding: 0;
	font-weight: bold;
	font-size: 25px;
}

.loginbox input {
	border: none;
	border-bottom: 1px solid #fff;
	height: 40px;
	width: 100%;
	outline: none;
	background: transparent;
	color: #2C3335;
	font-size: 25px;
	margin-bottom: 10px;
}

.dropdown {
	position: relative;
	display: block;
	margin-top: 0.5em;
	overflow: hidden;
	width: 100%;
	max-width: 100%;
}

.dropdown:hover {
	border: 1px solid #888;
}

.button {
	border: 1px solid #bbb;
	height: 30px;
	width: 100%;
	outline: none;
	background: transparent;
	color: #fff;
	font-size: 16px;
}

.button option {
	background-color: black;
	text-align: center;
}

.btn {
	margin-top: -5px;
	cursor: pointer;
	width: 100%;
	border: none;
	outline: none;
	height: 40px;
	background: #fb2525;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
}
</style>
</head>
<body>

	<nav class="menu">
		<div class="logo">
			<h1>
				<a href="${pageContext.request.contextPath}/index.jsp">Abhiruchi</a>
			</h1>
		</div>
		<div class="login">

			<li><a href="${pageContext.request.contextPath}/login">Login</a></li>

		</div>
		<div class="signup">
			<li><a href="${pageContext.request.contextPath}/signup">Sign
					Up</a></li>
		</div>
	</nav>


	<div class="container">
		<div class="loginbox">


			<h1>Add Food Item</h1>
			<form action="${pageContext.request.contextPath}/addfood"
				method="post">

				<p>Food Item Id</p>
				<input type="text" placeholder="Enter food Item Id" name="id"
					class="input" required>

				<p>Food Item Name</p>
				<input type="text" placeholder="Enter food Item Name" name="name"
					class="input" required>

				<p>Food Item Price</p>
				<input type="text" placeholder="Enter Food Item Price" name="price"
					class="input" required> <br> ${message} <br>
				<button class="btn" type="submit">Add Food</button>
			</form>

		</div>




	</div>

</body>



</body>
</html>