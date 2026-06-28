
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - FoodExpress</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#ff6b35,#ff9f43);
}

.login-container{
    background:white;
    width:400px;
    padding:40px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

.login-container h2{
    text-align:center;
    color:#ff6b35;
    margin-bottom:25px;
}

.input-group{
    margin-bottom:18px;
}

.input-group label{
    display:block;
    margin-bottom:6px;
    font-weight:bold;
    color:#333;
}

.input-group input{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
}

.input-group input:focus{
    outline:none;
    border-color:#ff6b35;
}

.btn{
    width:100%;
    padding:12px;
    background:#ff6b35;
    color:white;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
}

.btn:hover{
    background:#e85a28;
}

.links{
    text-align:center;
    margin-top:15px;
}

.links a{
    text-decoration:none;
    color:#ff6b35;
    font-weight:bold;
}

.links a:hover{
    text-decoration:underline;
}
</style>

</head>
<body>

<div class="login-container">

    <h2>🍔 FoodExpress Login</h2>

    <form action="loginservlet" method="post">

        <div class="input-group">
            <label>Username</label>
            <input type="text" name="username" required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <button type="submit" class="btn">Login</button>

    </form>

    <div class="links">
        <p>Don't have an account?
            <a href="register.jsp">Register</a>
        </p>
    </div>

</div>

</body>
</html>
