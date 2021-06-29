<%-- 
    Document   : LogueoAdmin
    Created on : 28-jun-2021, 8:09:08
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="COM.VLXDY.MODELO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logo.png">
        <title> SIGECO </title>
    </head>
<style type="text/css">
	*{
	padding: 0;
	margin: 0;
	box-sizing: border-box;
        }

        body{
            font-family: 'Poppins', sans-serif;
            overflow: hidden;
        }

        .wave{
                position: fixed;
                bottom: 0;
                left: 0;
                height: 100%;
                z-index: -1;
        }

        .container{
            width: 100vw;
            height: 100vh;
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            grid-gap :7rem;
            padding: 0 2rem;
        }

        .img{
                display: flex;
                justify-content: flex-end;
                align-items: center;
        }

        .login-content{
                display: flex;
                justify-content: flex-start;
                align-items: center;
                text-align: center;
        }

        .img img{
                width: 500px;
        }

        form{
                width: 360px;
        }

        .login-content img{
            height: 200px;
        }

        .login-content h2{
                margin: 15px 0;
                color: #333;
                text-transform: uppercase;
                font-size: 2.9rem;
        }

        .login-content .input-div{
                position: relative;
            display: grid;
            grid-template-columns: 7% 93%;
            margin: 25px 0;
            padding: 5px 0;
            border-bottom: 2px solid #d9d9d9;
        }

        .login-content .input-div.one{
                margin-top: 0;
        }

        .i{
                color: #d9d9d9;
                display: flex;
                justify-content: center;
                align-items: center;
        }

        .i i{
                transition: .3s;
        }

        .input-div > div{
            position: relative;
                height: 45px;
        }

        .input-div > div > h5{
                position: absolute;
                left: 10px;
                top: 50%;
                transform: translateY(-50%);
                color: #999;
                font-size: 18px;
                transition: .3s;
        }

        .input-div:before, .input-div:after{
                content: '';
                position: absolute;
                bottom: -2px;
                width: 0%;
                height: 2px;
                background-color: #38d39f;
                transition: .4s;
        }

        .input-div:before{
                right: 50%;
        }

        .input-div:after{
                left: 50%;
        }

        .input-div.focus:before, .input-div.focus:after{
                width: 50%;
        }

        .input-div.focus > div > h5{
                top: -5px;
                font-size: 15px;
        }

        .input-div.focus > .i > i{
                color: #38d39f;
        }

        .input-div > div > input{
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                border: none;
                outline: none;
                background: none;
                padding: 0.5rem 0.7rem;
                font-size: 1.2rem;
                color: #555;
                font-family: 'poppins', sans-serif;
        }

        .input-div.pass{
                margin-bottom: 4px;
        }

        a{
                display: block;
                text-align: right;
                text-decoration: none;
                color: #999;
                font-size: 0.9rem;
                transition: .3s;
        }

        a:hover{
                color: #38d39f;
        }

        .btn{
                display: block;
                width: 100%;
                height: 50px;
                border-radius: 25px;
                outline: none;
                border: none;
                background-image: linear-gradient(to right, #32be8f, #38d39f, #32be8f);
                background-size: 200%;
                font-size: 1.2rem;
                color: #fff;
                font-family: 'Poppins', sans-serif;
                text-transform: uppercase;
                margin: 1rem 0;
                cursor: pointer;
                transition: .5s;
        }
        .btn:hover{
                background-position: right;
        }


        @media screen and (max-width: 1050px){
                .container{
                        grid-gap: 5rem;
                }
        }

        @media screen and (max-width: 1000px){
                form{
                        width: 290px;
                }

                .login-content h2{
                font-size: 2.4rem;
                margin: 8px 0;
                }

                .img img{
                        width: 400px;
                }
        }

        @media screen and (max-width: 900px){
            body {
                background-image: linear-gradient(
                            rgba(0, 0, 0, 0.6),
                            rgba(0, 0, 0, 0.6)
                                    ), url("Fondo.png");
                                    background-repeat: no-repeat;
                                    background-attachment: fixed;
                                    background-size: 100% 100%;

                    display: flex;
                    justify-content: center;
                    align-items: center;
                    flex-direction: column;
                    font-family: "Montserrat", sans-serif;
                    height: 100vh;
                    margin: -20px 0 50px;
            }
                .container{
                        grid-template-columns: 1fr;
                }

                .img{
                        display: none;
                }

                .wave{
                        display: none;
                }

                .login-content{
                        justify-content: center;
                }
        }
</style>
<body>
    <img class="wave" src="wave.png">
	<div class="container">
		<div class="img">
                    <img src="bg.svg">
		</div>
		<div class="login-content">
			<form action="index.html">
                            <br><br><br>
				<img src="avatar.svg">
				<h2 style="color:black;" class="title">BIENVENIDO</h2>
                                <br>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Username</h5>
           		   		<input type="text" class="input">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input type="password" class="input">
            	   </div>
            	</div>
                <br>
            	<input type="submit" class="btn" value="Login">
            </form>
                    <%
            HttpSession sesion = request.getSession();

            List<Administrador> datos = new ArrayList<Administrador>();
            if (request.getAttribute("sip") != null) {
                out.print("<script>alert('Ususario o Password erroneos!!!');</script>   ");
            }
            if (request.getAttribute("fail") != null) {
                out.print("<script>alert('asdddddddddddddddddddddddddddddddddddddddddddddd!!!');</script>   ");
            }
            if (request.getAttribute("datos") != null) {
                datos = (List<Administrador>) request.getAttribute("datos");
                int id = 0;
                String usuario = "";
                String password = "";
                for (Administrador u : datos) {
                    id = u.getId_admin();
                    usuario = u.getNombres();
                    password = u.getApellidos();
                }
                /*sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("id", id);*/
                response.sendRedirect("index.html");
            }
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("login.jsp");
            }
        %>
        </div>          
    </div>
    
     
        
     
        <script type="text/javascript">
                const inputs = document.querySelectorAll(".input");


                function addcl(){
                        let parent = this.parentNode.parentNode;
                        parent.classList.add("focus");
                }

                function remcl(){
                        let parent = this.parentNode.parentNode;
                        if(this.value == ""){
                                parent.classList.remove("focus");
                        }
                }


                inputs.forEach(input => {
                        input.addEventListener("focus", addcl);
                        input.addEventListener("blur", remcl);
                });
        </script>
</body>
</html>