<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.tap.model.User"%>

<%
User user = (User)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background:#f4f4f4;
    display:flex;
    flex-direction:column;
    min-height:100vh;
}

header{
    background:#ff6b35;
    color:white;
    padding:20px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:35px;
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

.container{
    flex:1;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:40px;
}

.profile-card{
    width:450px;
    background:white;
    border-radius:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.2);
    padding:35px;
    text-align:center;
}

.profile-img{
    width:120px;
    height:120px;
    border-radius:50%;
    margin-bottom:20px;
}

h2{
    color:#ff6b35;
    margin-bottom:25px;
}

.info{
    text-align:left;
    margin:12px 0;
    font-size:18px;
}

.info b{
    display:inline-block;
    width:130px;
}

.btn{
    display:inline-block;
    margin-top:25px;
    padding:12px 25px;
    background:#ff6b35;
    color:white;
    text-decoration:none;
    border-radius:8px;
}

.btn:hover{
    background:#e65a28;
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

<div class="logo">
🍔 FoodExpress
</div>

<nav>
<h4>welcome 👤 <a href ="profile.jsp"> <%= user.getName() %> </a>   </h4> 	
<a href="index.jsp">Home</a>

<a href="restaurantservlet">Restaurants</a>

<a href="viewcartservlet">Cart</a>

<a href="vieworderservlet">Orders</a>

<a href="logoutservlet">Logout</a>

</nav>

</header>

<div class="container">

<div class="profile-card">

<img src="images/pro.jpg" class="profile-img">

<h2>My Profile</h2>

<p class="info">
<b>User ID :</b>
<%= user.getUserid() %>
</p>

<p class="info">
<b>Name :</b>
<%= user.getName() %>
</p>

<p class="info">
<b>Email :</b>
<%= user.getEmail() %>
</p>

<p class="info">
<b>Phone :</b>
<%= user.getPhoneno() %>
</p>

<p class="info">
<b>Address :</b>
<%= user.getAddress() %>
</p>

<a href="editprofile.jsp" class="btn">
✏ Edit Profile
</a>

</div>

</div>

<footer>

<p>© 2026 FoodExpress | User Profile</p>

</footer>

</body>
</html>