
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - FoodExpress</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#ff6b35,#ff9f43);
    padding:20px;
}

.register-container{
    background:white;
    width:450px;
    padding:35px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

.register-container h2{
    text-align:center;
    color:#ff6b35;
    margin-bottom:25px;
}

.input-group{
    margin-bottom:15px;
}

.input-group label{
    display:block;
    margin-bottom:6px;
    font-weight:bold;
    color:#333;
}

.input-group input,
.input-group textarea,
.input-group select{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
}

.input-group textarea{
    resize:none;
    height:80px;
}

.input-group input:focus,
.input-group textarea:focus,
.input-group select:focus{
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

<div class="register-container">

    <h2>🍔 FoodExpress Register</h2>

    <form action="registerservlet" method="post">

        <div class="input-group">
            <label>Full Name</label>
            <input type="text" name="name" required>
        </div>

        <div class="input-group">
            <label>Username</label>
            <input type="text" name="username" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email" required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <div class="input-group">
            <label>Phone Number</label>
            <input type="tel" name="phone" required>
        </div>

        <div class="input-group">
            <label>Address</label>
            <textarea name="address" required></textarea>
        </div>

        <div class="input-group">
            <label>Role</label>
            <select name="role">
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select>
        </div>

        <button type="submit" class="btn">Create Account</button>

    </form>

    <div class="links">
        <p>Already have an account?
            <a href="login.jsp">Login</a>
        </p>
    </div>

</div>

</body>
</html>
