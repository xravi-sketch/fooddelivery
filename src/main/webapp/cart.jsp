<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.List,com.tap.model.cart"%>

<%
List<cart> cartList = (List<cart>)request.getAttribute("cartList");

int grandTotal = 0;

if(cartList != null){
    for(cart c : cartList){
        grandTotal += c.getSubtotal();
    }
}
%>

<%@ page import="com.tap.daoimpl.fooditemdaoimpl"%>
<%@ page import="com.tap.model.fooditem"%>

<%
fooditemdaoimpl fooddao = new fooditemdaoimpl();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,Helvetica,sans-serif;
}

body{
background:#f5f5f5;
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
font-size:32px;
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
width:90%;
margin:40px auto;
}

h1{
margin-bottom:25px;
color:#333;
}

table{
width:100%;
border-collapse:collapse;
background:white;
border-radius:10px;
overflow:hidden;
box-shadow:0 3px 10px rgba(0,0,0,.15);
}

th{
background:#ff6b35;
color:white;
padding:15px;
font-size:18px;
}

td{
padding:15px;
text-align:center;
border-bottom:1px solid #ddd;
}

tr:hover{
background:#f9f9f9;
}

.total-box{
margin-top:25px;
background:white;
padding:20px;
border-radius:10px;
box-shadow:0 3px 10px rgba(0,0,0,.15);
text-align:right;
}

.total-box h2{
color:#2e7d32;
}

.btns{
margin-top:20px;
display:flex;
justify-content:flex-end;
gap:15px;
}

.btn{
padding:12px 25px;
text-decoration:none;
border-radius:6px;
color:white;
font-size:17px;
}

.shop{
background:#3498db;
}

.shop:hover{
background:#2980b9;
}

.checkout{
background:#27ae60;
}

.checkout:hover{
background:#219150;
}

.remove{
background:#e74c3c;
padding:8px 15px;
border-radius:5px;
text-decoration:none;
color:white;
}

.remove:hover{
background:#c0392b;
}

.empty{
background:white;
padding:50px;
text-align:center;
font-size:22px;
border-radius:10px;
box-shadow:0 3px 10px rgba(0,0,0,.15);
}

footer{
margin-top:50px;
background:#222;
color:white;
text-align:center;
padding:20px;
}

.quantity-box{
    display:flex;
    justify-content:center;
    align-items:center;
    gap:10px;
}

.qty-btn{
    width:35px;
    height:35px;
    background:#ff6b35;
    color:white;
    text-decoration:none;
    border-radius:50%;
    display:flex;
    justify-content:center;
    align-items:center;
    font-size:22px;
    font-weight:bold;
    transition:0.3s;
}

.qty-btn:hover{
    background:#e45a23;
    transform:scale(1.1);
}

.qty-value{
    min-width:35px;
    text-align:center;
    font-size:20px;
    font-weight:bold;
    color:#333;
}
</style>

</head>

<body>

<header>

<div class="logo">
🛒 FoodExpress
</div>
 <%@ page import =" com.tap.model.User" %>
    
    <% User user = (User)session.getAttribute("user"); %>
    
    <nav>
        <% if(user==null){ %>
        <a href="login.jsp">Login</a>
        <a href="<%= request.getContextPath() %>/index.jsp"> </a>Home</a>
        <a href="restaurantservlet">Restaurants</a>
        <a href="register.jsp">Register</a>
        <a href="cartservlet">Cart</a>
        
        <% } else { %> 

        <h4>welcome  👤 <a href ="profile.jsp"><%= user.getName() %> </a>  </h4> 
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>	
        <a href ="logoutservlet">Logout</a>
        <a href="cartservlet">Cart</a>
        <a href="restaurantservlet">Restaurants</a> 
         <a href="orders.jsp">Orders</a>
    	<% }%>  
    </nav>


</header>

<div class="container">

<h1>My Shopping Cart</h1>

<%
if(cartList==null || cartList.isEmpty()){
%>

<div class="empty">

<h2>Your Cart is Empty 🛒</h2>

<br>

<a href="restaurantservlet" class="btn shop">
Continue Shopping
</a>

</div>

<%
}
else{
%>

<table>

<tr>

<th>Cart no</th>
<th>Food </th>
<th>Food Item</th>
<th>Quantity</th>
<th>Price</th>
<th>Subtotal</th>
<th>Action</th>

</tr>

<%
 int Sno = 1 ;
for(cart c : cartList){
	fooditem food = fooddao.getfooditem(c.getF_id());
%>

<tr>

<td><%=  Sno++ %></td>

<td>
<img src="images/<%=food.getImage()%>" width="80" height="80">
</td>

<td><%=food.getFood_name() %></td>

<td>

<div class="quantity-box">

<a class="qty-btn" href="updatecartservlet?action=decrease&cart_id=<%=c.getCart_id()%>">➖</a>

&nbsp;

<span class="qty-value">

<%= c.getQuantity() %>


</span>

&nbsp;

<a class="qty-btn" href="updatecartservlet?action=increase&cart_id=<%=c.getCart_id()%>">➕</a></div></td>

<td>₹ <%=c.getPrice()%></td>

<td>₹ <%=c.getSubtotal()%></td>

<td>
<a href="deletecartservlet?cart_id=<%=c.getCart_id()%>" class="remove">
Remove
</a>
</td>

</tr>

<%
}
%>

</table>

<div class="total-box">

<h2>Grand Total : ₹ <%=grandTotal %></h2>

<div class="btns">

<a href="restaurantservlet" class="btn shop">
Continue Shopping
</a>

<a href="checkoutservlet" class="btn checkout">
Proceed To Checkout
</a>

</div>

</div>

<%
}
%>

</div>

<footer>

<p>© 2026 FoodExpress | All Rights Reserved</p>

</footer>

</body>
</html>