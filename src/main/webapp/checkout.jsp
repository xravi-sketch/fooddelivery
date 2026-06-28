<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.List,com.tap.model.cart,com.tap.model.User"%>

<%
User user = (User)session.getAttribute("user");



List<cart> cartList = (List<cart>)request.getAttribute("cartList");

Integer grandTotal = (Integer)request.getAttribute("grandtotal");
if(grandTotal == null){
    grandTotal = 0;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
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
font-size:35px;
font-weight:bold;
}

.container{
width:80%;
margin:30px auto;
}

.card{
background:white;
padding:25px;
border-radius:12px;
box-shadow:0 5px 15px rgba(0,0,0,.2);
margin-bottom:25px;
}

.card h2,h4{
color:#ff6b35;
margin-bottom:20px;
}

.info{
margin:12px 0;
font-size:18px;
}

table{
width:100%;
border-collapse:collapse;
margin-top:20px;
}

table th{
background:#ff6b35;
color:white;
padding:12px;
}

table td{
padding:12px;
text-align:center;
border-bottom:1px solid #ddd;
}

.total{
margin-top:20px;
text-align:right;
font-size:25px;
font-weight:bold;
color:green;
}

.payment{
margin-top:20px;
}

.payment label{
display:block;
font-size:18px;
margin:10px 0;
}

.btn{
width:100%;
padding:15px;
margin-top:25px;
border:none;
background:#ff6b35;
color:white;
font-size:20px;
border-radius:8px;
cursor:pointer;
}

.btn:hover{
background:#e85b25;
}

.input{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:6px;
    font-size:16px;
    margin-top:5px;
}

.btn{
    width:100%;
    padding:15px;
    background:#ff6b35;
    color:white;
    border:none;
    border-radius:8px;
    font-size:18px;
    cursor:pointer;
}

.btn:hover{
    background:#e85b25;
}
</style>

</head>

		<body>
		
			<header>
			
				<div class="logo">
				🍔 FoodExpress Order Checkout
				</div>
			
			</header>
		
		
			<div class="card">
			
				<form action="orderservlet" method="post">
				
				<div class="card">
				
				<h2>Delivery Details</h2>
				
				<label>Customer Name</label><br>
				<input type="text" name="customerName" required class="input"><br><br>
				
				<label>Phone Number</label><br>
				<input type="tel" name="phone" required class="input"><br><br>
				
				<label>Delivery Address</label><br>
				<textarea name="address" rows="4" required class="input"></textarea><br><br>
				
				<h2>Payment Method</h2>
				
				<label>
				<input type="radio" name="payment" value="Cash On Delivery" checked>
				Cash On Delivery
				</label><br>
				
				<label>
				<input type="radio" name="payment" value="UPI">
				UPI
				</label><br>
				
				<label>
				<input type="radio" name="payment" value="Card">
				Debit / Credit Card
				</label><br><br>
				
				<h2>Order Summary</h2>
				
				<table border="1" width="100%" cellpadding="10">
				
				<tr>
				
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>
				</tr>
				
				<%
				if(cartList != null){
				    for(cart c : cartList){
				%>
				
				<tr>
				
				
				
				<td><%= c.getQuantity() %></td>
				
				<td>₹ <%= c.getPrice() %></td>
				
				<td>₹ <%= c.getSubtotal() %></td>
				
				</tr>
				
				<%
				    }
				}
				%>
				
				</table>
				
				<br>
				<h4>Delivery Charges  = 30 </h4>
				<h4>Platform Fee = 5</h4>
				<h2>
				Grand Total : ₹ <%= grandTotal %>
				</h2>
				
				<input type="submit" value="Place Order" class="btn">
				
				</div>
				
				</form>
			</div>
			
			</div>
		
		</body>
</html>