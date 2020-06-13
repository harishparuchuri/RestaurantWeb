<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Abhiruchi</title>


<style>
@import url("https://fonts.googleapis.com/css?family=Nunito+Sans:200,400,700,800,900&display=swap");

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
    background: linear-gradient(90deg, #00C9FF 0%, #92FE9D 100%);
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
.addfood {
	margin-left: 1000px;
}
a {
	text-decoration: none;
	color: red;
}

img{
	width: 100%;
	height: 89.5vh;
	opacity:0.5;
}

.text{
position: relative;
margin-top:-400px;
font-weight:500;


}

p{
	font-size: 80px;
	text-align:center;
	color: #616C6F;
	cursor: pointer;
	
}

p:hover{
	color:#E1DA00;
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
		<div class="addfood">

			<li><a href="${pageContext.request.contextPath}/login">Log In</a></li>

		</div>
		<div class="logout">
			<li><a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
		</div>
	</nav>


<div class="logo">
	<img src="./assets/Pizza.jpg" alt="">
</div>

<div class="text">
	<p>You don't need</p>
	<p> a silver fork to</p>
	<p> eat good food</p>
</div>

</body>
</html>