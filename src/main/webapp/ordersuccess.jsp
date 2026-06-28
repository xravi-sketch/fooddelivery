<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

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
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    background:white;
    width:500px;
    padding:40px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 5px 15px rgba(0,0,0,.2);
}

.success{
    font-size:80px;
}

h1{
    color:#2e7d32;
    margin:20px 0;
}

p{
    color:#555;
    font-size:18px;
    margin-bottom:30px;
}

.btn{
    display:inline-block;
    text-decoration:none;
    background:#ff6b35;
    color:white;
    padding:15px 30px;
    border-radius:8px;
    margin:10px;
    font-size:18px;
    transition:.3s;
}

.btn:hover{
    background:#e65a28;
}



</style>

</head>

<body>

<div class="container">

<div class="success">
✅
</div>

<h1>Order Placed Successfully!</h1>

<p>
Thank you for ordering with <b>FoodExpress</b>.<br>
Your delicious food is being prepared.
</p>

<a href="restaurantservlet" class="btn">
🍔 Continue Shopping
</a>

<a href="vieworderservlet" class="btn">
📦 View Orders
</a>

</div>

</body>
</html>