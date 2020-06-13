<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
<style>
@import url("https://fonts.googleapis.com/css?family=Nunito+Sans:200,400,700,800,900&display=swap");

* {
	padding: 0px;
	margin: 0px;
  	box-sizing: border-box;
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


/* card style */


img {
  display: block;
  width: 100%;
  height: 100%;
  border-radius: 15px 50px;
}

.wrapper {
  width: 100%;
  margin: 20px auto;
}

.cards_wrap {
  display: flex;
  flex-wrap: wrap;
  

  
}

.cards_wrap .card_item {
  width: 25%;
  padding: 10px;
  
  
  
  
  
 
}

.cards_wrap .card_inner {
  background: rgb(255, 255, 255);
  border-radius: 15px 50px;
  box-shadow: 0 0 10px white;
  
}

.cards_wrap .card_img {
  width: 100%;
  height: auto;
  padding: 10px;
  padding-bottom: 0;
  
}

.cards_wrap .card_bottom {
  padding: 15px;
}




.cards_wrap .card_bottom .card_data .title {
  color: #fd0dc1;
  font-size: 20px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  margin-bottom: 5px;
  text-align: center;
}

.cards_wrap .card_bottom .add-cart  {
  text-align: center;
  
  
}

.btn button{
    padding: 0 20px;
    color: white;
    background-color: #4834DF;
    font-size: 20px;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	padding :5px;
	transform: 0.7;

    
}

.btn button:hover{
    box-shadow: 0 0 10px black;
    
    background-color:#EC4849;
    color:#EEC213;
  
}
.btn{
	text-align: center;
}


@media (max-width: 1024px) {
  .cards_wrap .card_item {
    width: 33.3%;
  }
}

@media (max-width: 768px) {
  .cards_wrap .card_item {
    width: 50%;
  }
}

@media (max-width: 528px) {
  .cards_wrap .card_item {
    width: 100%;
  }
}

.items{
	background-color: rgb(119, 113, 113);
  color: #555555;
  font-size: 14px;
  font-family: "Nunito", sans-serif; 
}



/* end card */


</style>
    <title>Admin Panel</title>
</head>
<body>
    

    <nav class="menu">
		<div class="logo">
			<h1>
				<a href="${pageContext.request.contextPath}/index.jsp">Abhiruchi</a>
			</h1>
		</div>
		<div class="addfood">

			<li><a href="${pageContext.request.contextPath}/addfood">Add Food</a></li>

		</div>
		<div class="logout">
			<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
		</div>
	</nav>
    
    

    <!-- display food items menu -->

    

        
		
		<div class="items">
			<div class="wrapper">
				<div class="cards_wrap">
					<c:forEach var="food" items="${foodlist}">
					<div class="card_item">
					<div class="card_inner"  >
					  <div class="card_img">
						<img src="./assets/<c:out value="${food.getFimage()}"/>" >
					  </div>
					  <div class="card_bottom">
						  <div class="card_data">
							<p class="title"><c:out value ="${food.getFname()}" /> <br> <span><c:out value ="${food.getFprice()}" /> $</span>
								
						  </div>                                                 
	
						  <div class="btn">
							<a href="edit?id=<c:out value='${food.getFid()}' />"> <button type="button" id="edit">EDIT</button></a>
							 
							<a href="delete?id=<c:out value='${food.getFid()}'/>">
							 <button id="delete">DELETE</button></a>
						   </div>
	
					  </div>
					</div>
				  </div>
				</c:forEach>
				</div>
			</div> 
		</div>
	
	





</body>
</html>