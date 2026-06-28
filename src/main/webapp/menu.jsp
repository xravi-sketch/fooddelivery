<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.tap.model.fooditem"%>

<%
List<fooditem> foodList = (List<fooditem>)request.getAttribute("fooditems");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Menu | FoodExpress</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background:#f4f4f4;
}

/* Header */

header{
    background:#ff6b35;
    color:white;
    padding:18px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:50px;
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

/* Banner */

.banner{
    height:130px;
    background:linear-gradient(rgba(0,0,0,.45),rgba(0,0,0,.45)),
    url("images/banner.jpg");
    background-size:cover;
    background-position:center;
    display:flex;
    justify-content:center;
    align-items:center;
}

.banner h1{
    color:white;
    font-size:50px;
}

/* Cards */

.container{
    width:90%;
    margin:40px auto;
}

.grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(300px,1fr));
    gap:30px;
}

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 5px 15px rgba(0,0,0,.15);
    transition:.3s;
}

.card:hover{
    transform:translateY(-8px);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.card-body{
    padding:20px;
}

.card-body h2{
    color:#ff6b35;
    margin-bottom:10px;
}

.desc{
    color:#666;
    margin:12px 0;
}

.price{
    font-size:22px;
    color:green;
    font-weight:bold;
}

.rating{
    color:#ff9800;
    margin:10px 0;
}
.quantity{
    margin-top:8px;
    font-size:16px;
    font-weight:bold;
    color:#2e7d32;
    background:#e8f5e9;
    padding:8px 12px;
    border-radius:6px;
    display:inline-block;
}
.btn{
    display:inline-block;
    width:100%;
    text-align:center;
    margin-top:15px;
    padding:12px;
    background:#ff6b35;
    color:white;
    text-decoration:none;
    border-radius:8px;
    font-size:17px;
}

.btn:hover{
    background:#e45a23;
}

/* Footer */

footer{
    margin-top:50px;
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
}

</style>

</head>

<body>

<header>

<div class="logo">
🍔 FoodExpress
</div>

 <%@ page import =" com.tap.model.User" %>
    
    <% User user = (User)session.getAttribute("user"); %>
    
    <nav>
        <% if(user==null){ %>
        <a href="login.jsp">Login</a>
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href="register.jsp">Register</a>
        <a href="updatecartservlet">Cart</a>
        
        <% } else { %> 

        <h4>welcome  👤 <a href ="profile.jsp"><%= user.getName() %> </a>  </h4> 
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>	
        <a href ="logoutservlet">Logout</a>
        <a href="viewcartservlet">Cart</a>
        <a href="restaurantservlet">Restaurants</a> 
         <a href="orders.jsp">Orders</a>
    	<% }%>  
    </nav>

</header>

<div class="banner">
<h1>Today's Menu</h1>
</div>

<div class="container">

<div class="grid">

	<%
	for(fooditem food : foodList){
	
	
	%>
	
		<div class="card">
		
		   <img src="images/<%= food.getImage() %>" alt="<%= food.getFood_name() %>">
		
				<div class="card-body">
				
				<h2><%=food.getFood_name()%></h2>
				
				<p class="desc">
				<%=food.getDescription()%>
				</p>
				
				<p class="rating">
				⭐ <%= food.getAvailabilty()%>
				</p>
				
				<p class="price">
				₹ <%=food.getPrice()%>
				</p>
				<p class="quantity">
                Quantity Available: <%= food.getQuantity() %>
               </p>
				<a href="cartservlet?foodId=<%=food.getF_id()%>" class="btn">
				🛒 Add To Cart
				</a>
				
				</div>
				
		</div>
	
	<%
	}
	%>

</div>

</div>

<footer>

<p>© 2026 FoodExpress | Fresh Food Delivered Fast</p>

</footer>

</body>
</html>