
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Delivery App</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#f5f5f5;
}

header{
    background:#ff6b35;
    color:white;
    padding:20px 50px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:28px;
    font-weight:bold;
}

nav a{
    color:white;
    text-decoration:none;
    margin-left:20px;
    font-size:18px;
}

nav a:hover{
    text-decoration:underline;
}

.hero{
    height:80vh;
    background:linear-gradient(rgba(0,0,0,0.5),
            rgba(0,0,0,0.5)),
            url("https://images.unsplash.com/photo-1504674900247-0877df9cc836");
    background-size:cover;
    background-position:center;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color:white;
    text-align:center;
}

.hero h1{
    font-size:55px;
    margin-bottom:15px;
}

.hero p{
    font-size:22px;
    margin-bottom:25px;
}

.btn{
    background:#ff6b35;
    color:white;
    padding:12px 25px;
    text-decoration:none;
    border-radius:5px;
    font-size:18px;
}

.btn:hover{
    background:#e85a28;
}

.features{
    padding:60px 40px;
    display:flex;
    justify-content:center;
    gap:30px;
    flex-wrap:wrap;
}

.card{
    background:white;
    width:300px;
    padding:25px;
    border-radius:10px;
    text-align:center;
    box-shadow:0 2px 10px rgba(0,0,0,0.15);
}

.card h3{
    color:#ff6b35;
    margin-bottom:10px;
}

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
}
</style>
</head>

<body>

<header>
    <div class="logo">🍔 FoodExpress</div>
    
    <%@ page import =" com.tap.model.User" %>
    
    <% User user = (User)session.getAttribute("user"); %>
 
    <nav>
        <% if(user==null){ %>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href="login.jsp">cart</a>
        <a href ="login.jsp">Orders</a>
        
        <% } else { %> 

        <h4>welcome 👤 <a href ="profile.jsp"> <%= user.getName() %> </a>   </h4> 	
        <a href ="logoutservlet">Logout</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href ="viewcartservlet">cart</a>
        <a href ="vieworderservlet">Orders</a>
       
    	<% }%>  
    </nav>
</header>

<section class="hero">
    <h1>Delicious Food Delivered Fast</h1>
    <p>Order from your favorite restaurants anytime</p>
    <a href="restaurantservlet" class="btn">Order Now</a>
</section>



<footer>
    <p>&copy; 2026 FoodExpress | All Rights Reserved</p>
</footer>

</body>
</html>

