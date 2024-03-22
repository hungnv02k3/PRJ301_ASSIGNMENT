<%-- 
    Document   : login
    Created on : Oct 16, 2023, 12:07:52 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            .centered {
                margin: auto;
                width: 50%;
                text-align: center;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="centered">
          
            <form action="login" method="POST">           
                Username: <input type="text" name="username" /> <br/>
                Password: <input type="password" name="password" /> <br/>            
                <input type="submit" value="Login" />
            </form>
        </div>
    </body>
</html>
