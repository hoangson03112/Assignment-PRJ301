<%-- 
    Document   : login
    Created on : Feb 29, 2024, 1:52:58 PM
    Author     : Hoàng Sơn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="view/login.css"/> 
        <style>
            .title {
                font-family: Adelaide, sans-serif;
                text-align: center;
                font-size: 1.5rem;
                line-height: 2rem;
                font-weight: 700;
                color: whitesmoke;
                text-shadow: 0 0 10px rgba(255, 255, 255, 0.6);
            }
            .input-group label  {
                font-size: 13px;
                display: block;
                color: white;
                margin-bottom: 4px;
            }
        </style>
    </head>
    <body>
        <div class="container-login">
            <form style="" action="login" method="post" >
                <div class="form-container">
                    <p class="title">Login</p>
                    <div class="form">
                        <div class="input-group">
                            <label for="username">Username</label>
                            <input type="text" name="username" id="username" >
                        </div>
                        <div class="input-group">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" >
                        </div>
                        <br/>
                        <label class="checkbox-btn">
                            <label for="checkbox"></label>
                            <input id="checkbox" name="remember" value="remember" type="checkbox">
                            <span class="checkmark"></span>
                        </label>
                        <span class="remember">Remember me!</span>
                        <br/>
                        <br/>

                        <button class="animated-button" type="submit">
                            <svg viewBox="0 0 24 24" class="arr-2" xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M16.1716 10.9999L10.8076 5.63589L12.2218 4.22168L20 11.9999L12.2218 19.778L10.8076 18.3638L16.1716 12.9999H4V10.9999H16.1716Z"
                                ></path>
                            </svg>
                            <span class="text">LogIn</span>
                            <span class="circle"></span>
                            <svg viewBox="0 0 24 24" class="arr-1" xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M16.1716 10.9999L10.8076 5.63589L12.2218 4.22168L20 11.9999L12.2218 19.778L10.8076 18.3638L16.1716 12.9999H4V10.9999H16.1716Z"
                                ></path>
                            </svg>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
