<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.List,com.tap.model.orders"%>

<%
List<orders> orderList = (List<orders>)request.getAttribute("orderList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
    background:#f5f5f5;
    display:flex;
    flex-direction:column;
    min-height:100vh;
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
font-size:35px;
font-weight:bold;
}

.container{
    width:90%;
    margin:40px auto;
    flex:1;
}

h1{
margin-bottom:25px;
color:#333;
}

table{
width:100%;
border-collapse:collapse;
background:white;
box-shadow:0 4px 12px rgba(0,0,0,.15);
border-radius:10px;
overflow:hidden;
}

th{
background:#ff6b35;
color:white;
padding:15px;
}

td{
padding:15px;
text-align:center;
border-bottom:1px solid #ddd;
}

tr:hover{
background:#f9f9f9;
}

.status{
color:green;
font-weight:bold;
}

.empty{
background:white;
padding:40px;
text-align:center;
border-radius:10px;
box-shadow:0 4px 12px rgba(0,0,0,.15);
font-size:22px;
}

.btn{
display:inline-block;
margin-top:20px;
padding:12px 25px;
background:#ff6b35;
color:white;
text-decoration:none;
border-radius:6px;
}

.btn:hover{
background:#e65a28;
}

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
    margin-top:auto;
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

</style>

</head>

<body>

<header>

<div class="logo">
📦 My Orders
</div>

<%@ page import =" com.tap.model.User" %>
    
    <% User user = (User)session.getAttribute("user"); %>
 
    <nav>
        <% if(user==null){ %>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href="login.jsp">cart</a>
        <a href="vieworderservlet">Orders</a>
        
        <% } else { %> 

        <h4>welcome 👤 <a href ="profile.jsp"> <%= user.getName() %> </a>  </h4> 	
        <a href ="logoutservlet">Logout</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href ="viewcartservlet">cart</a>
        
    	<% }%>  
    </nav>

</header>

<div class="container">

<h1>Order History</h1>

<%
if(orderList==null || orderList.isEmpty()){
%>

<div class="empty">

No Orders Found

<br>

<a href="restaurantservlet" class="btn">
Order Food
</a>

</div>

<%
}
else{
%>

<table>

<tr>

<th>S.No</th>

<th>Customer</th>
<th>Phone</th>
<th>Delivery Address</th>
<th>Order Date</th>
<th>Total Amount</th>
<th>Status</th>

</tr>

<%
int sno=1;

for(orders o:orderList){
%>

<tr>

<td><%=sno++%></td>



<td><%=o.getCustomer_name()%></td>

<td><%=o.getPhone()%></td>

<td><%=o.getDelivery_address()%></td>

<td><%=o.getOrder_date()%></td>

<td>₹ <%=o.getT_amt()%></td>

<td class="status">
<%=o.getStatus()%>
</td>

</tr>

<%
}
%>

</table>

<%
}
%>

</div>

<footer>

<p>© 2026 FoodExpress | My Orders</p>

</footer>

</body>
</html>