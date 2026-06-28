
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import ="java.util.List ,  com.tap.model.restaurant"%>
    
    



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants - FoodExpress</title>

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

.banner{
    background:linear-gradient(rgba(0,0,0,0.5),
    rgba(0,0,0,0.5)),
    url("https://images.unsplash.com/photo-1517248135467-4c7edcad34c4");
    height:200px;
    background-size:cover;
    background-position:center;
    display:flex;
    justify-content:center;
    align-items:center;
    color:white;
}

.banner h1{
    font-size:50px;
}

.container{
    width:90%;
    margin:40px auto;
}

.restaurant-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
    gap:25px;
}

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 4px 12px rgba(0,0,0,0.15);
    transition:0.3s;
}

.card:hover{
    transform:translateY(-8px);
}

.card img{
    width:100%;
    height:180px;
    object-fit:fill;
    background:white;
    border-bottom:1px solid #eee;
    padding:5px;
}

.card-body{
    padding:20px;
}

.card-body h3{
    color:#ff6b35;
    margin-bottom:10px;
}

.card-body p{
    margin-bottom:8px;
    color:#555;
}

.btn{
    display:inline-block;
    margin-top:10px;
    background:#ff6b35;
    color:white;
    text-decoration:none;
    padding:10px 18px;
    border-radius:5px;
}

.btn:hover{
    background:#e85a28;
}

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
    margin-top:40px;
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
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="register.jsp">Register</a>
        <a href="cartservlet">Cart</a>
        
        <% } else { %> 

        <h4>welcome <a href ="profile.jsp"> 👤 <%= user.getName() %> </a>  </h4> 
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>	
        <a href ="logoutservlet">Logout</a>
        <a href="viewcartservlet">Cart</a>
         <a href="vieworderservlet">Orders</a>
    	<% }%>  
    </nav>

</header>

<div class="banner">
    <h1>Explore Restaurants</h1>
</div>

<div class="container">

    <div class="restaurant-grid">
    
    <%    
       List<restaurant> restaurants = ( List<restaurant>) request.getAttribute("restaurants");
    
        for( restaurant r: restaurants ){
    %>
			      <%
			String image="";
			
			if(r.getR_id()==101){
			    image="images/pad.jpg";
			}
			else if(r.getR_id()==110){
			    image="images/baw.png";
			}
			else if(r.getR_id()==111){
			    image="images/gis.jpg";
			}
			else if(r.getR_id()==120){
			    image="images/manasa.jpg";
			}
			else if(r.getR_id()==231){
			    image="images/mer.jpg";
			    
			}
			
			%>
        <div class="card">
            <img src="<%= image %> " alt="<%= r.getR_name()%> " >
            <div class="card-body">
                <h3><%= r.getR_name() %></h3>
                <p>⭐ <%= r.getRating() %></p>
                <p>Owner: <%= r.getOwner_name() %></p>
                <p>Address: <%= r.getAddress() %></p>
                <p>⏱ 30 mins</p>
                <a href="menuservlet?r_id=<%= r.getR_id() %>" class="btn">View Menu</a>
            </div>
        </div>

      <% } %>
    </div>

</div>

<footer>
    <p>© 2026 FoodExpress | Delicious Food Delivered Fast</p>
</footer>

</body>
</html>

