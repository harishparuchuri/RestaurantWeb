<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Sign Up</title>

<style>
@import url("https://fonts.googleapis.com/css?family=Nunito+Sans:200,400,700,800,900&display=swap");

*{
    padding: 0px;
    margin: 0px;

}


li a{
    text-decoration:none;
    color:white;
}
li{
    list-style-type: none;
    font-size: 20px;
    padding: 5px;
    font-weight: 900;
    font-family: "Nunito Sans", sans-serif;
    background-color: black;
    color: white;
    margin-right: 1px ;
    border-radius: 5px;
    
}
li:hover{
    color:#A4B0BD;
}


.menu{
    background-color: #EAF0F1;
    display: flex;
    flex-direction: row;
    padding: 10px;
    /* margin-left: 10px; */
    box-shadow: 0 0 10px black;
    

}
.menu h1{
    color: #E44236;
    font-size: 30px;
    font-weight: bold;
    font-family: "Nunito Sans", sans-serif;
    
    

}
.login{
    margin-left:1000px;
}

.text{
    text-align: center;
    
}
.text p{
    position: relative;
    color:#2B2B52;
    font-size: 60px;
    font-weight: 600;
    font-family: "Nunito Sans", sans-serif;
    margin-top: -220px;
}
.text p:hover{
    color:#FFF222;
    cursor: pointer;
}



body{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background-color: #FFE53B;
background-image: linear-gradient(147deg, #FFE53B 0%, #FF2525 74%);

}

 a{
    text-decoration:none;
    color:red;
}



.container{

    background: url(../../assets/coffee.jpg);
    background-size: cover;
    background-position: center;
    height: 92.5vh;
    

   


}
.loginbox{
     width: 400px;
    height: 480px;
    background: #99AAAB;
    color:black;
    left: 50%;
    top: 55%;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 70px 30px;
    


    
    

}

.usericon{

    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: absolute;
    top: -40px;
   left: 150px;

    background:#E83350;

}
h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
     
}

.loginbox p{
    margin: 0;
    padding: 0;
     font-weight: bold;

}
.loginbox input{
    border: none;
    border-bottom: 1px solid #fff;
    height: 40px;
    width: 100%;
    outline: none;
    background: transparent;
    color: #fff;
    font-size:16px;
   margin-bottom: 10px;
}

.dropdown {
    position: relative;
    display:block;
    margin-top:0.5em;
    overflow:hidden;
    width:100%;
    max-width:100%;
  }
  .dropdown:hover {
    border:1px solid #888;
  }


  .button {
    border: 1px solid #bbb;
    height: 30px;
    width: 100%;
    outline: none;
    background: transparent;
    color: #fff;
    font-size:16px;
    
   
   
    
  }
  .button option{
      background-color:black;
      text-align: center;
      
  }

  .btn{
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
        
        <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
        
    </div>
    <div class="signup">
        <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
    </div>
</nav>


<div class="container">
       <div class="loginbox">
           <img src="user.png" alt="" class="usericon">

           <h1>SignUp here</h1>
           <form action="${pageContext.request.contextPath}/login" method="post">
           <p>User Name</p>
           <input type="text" placeholder="username" name="name"  class="input"  required>
           <p>Email</p>
           <input type="email" name="email" id="" placeholder="Enter Email" name="email" class="input" required>
           <p>Password</p>
           <input type="password" placeholder="Enter Password" name="password" class="input" required>
            <p>Role</p>
            <select id="role" name="usertype" class="dropdown button" name="role" required>
                <option value="Select Role">Select Role</option>
                <option value="Admin">Admin</option>
                <option value="Employee">Employee</option>
            </select>
            <br>
            ${message}
            <br><br>
            <button class="btn" type="submit">Sign UP</button>
        </form>

       </div>




    </div>

</body>
</html>