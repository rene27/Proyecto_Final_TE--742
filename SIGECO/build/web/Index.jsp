<%-- 
    Document   : Index
    Created on : 10-may-2021, 20:53:56
    Author     : Vlxdy Hishikawa
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="COM.VLXDY.MODELO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        text-decoration: none;
        font-family: 'Roboto', sans-serif;
        }
        body{
        background-image: url(Fondo.png);
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        background-attachment: fixed;
        }
        main{
            width: 100%;
            padding: 20px;
            margin: auto;
            margin-top: 100px;
        }
        .contenedor__todo{
            width: 100%;
            max-width: 800px;
            margin: auto;
            position: relative;
        }
        .caja__trasera{
            width: 100%;
            padding: 10px 20px;
            display: flex;
            justify-content: center;
            -webkit-backdrop-filter: blur(10px);
            backdrop-filter: blur(10px);
            background-color: rgba(0, 128, 255, 0.5);
        }
        .caja__trasera div{
            margin: 100px 40px;
            color: white;
            transition: all 500ms;
        }
        .caja__trasera div p,
        .caja__trasera button{
            margin-top: 30px;
        }
        .caja__trasera div h3{
            font-weight: 400;
            font-size: 26px;
        }
        .caja__trasera div p{
            font-size: 16px;
            font-weight: 300;
        }
        .caja__trasera button{
            padding: 10px 40px;
            border: 2px solid #fff;
            font-size: 14px;
            background: transparent;
            font-weight: 600;
            cursor: pointer;
            color: white;
            outline: none;
            transition: all 300ms;
        }
        .caja__trasera button:hover{
            background: #fff;
            color: #46A2FD;
        }
        /*Formularios*/
        .contenedor__login-register{
            display: flex;
            align-items: center;
            width: 100%;
            max-width: 380px;
            position: relative;
            top: -185px;
            left: 10px;
            /*La transicion va despues del codigo JS*/
            transition: left 500ms cubic-bezier(0.175, 0.885, 0.320, 1.275);
        }
        .contenedor__login-register form{
            width: 100%;
            padding: 80px 20px;
            background: white;
            position: absolute;
            border-radius: 20px;
        }
        .contenedor__login-register form h2{
            font-size: 30px;
            text-align: center;
            margin-bottom: 20px;
            color: #46A2FD;
        }
        .contenedor__login-register form input{
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            border: none;
            background: #F2F2F2;
            font-size: 16px;
            outline: none;
        }
        .contenedor__login-register form button{
            padding: 10px 40px;
            margin-top: 40px;
            border: none;
            font-size: 14px;
            background: #46A2FD;
            font-weight: 600;
            cursor: pointer;
            color: white;
            outline: none;
        }
        .formulario__login{
            opacity: 1;
            display: block;
        }
        .formulario__register{
            display: none;
        }
        @media screen and (max-width: 850px){

            main{
                margin-top: 50px;
            }
            .caja__trasera{
                max-width: 350px;
                height: 300px;
                flex-direction: column;
                margin: auto;
            }
            .caja__trasera div{
                margin: 0px;
                position: absolute;
            }
            /*Formularios*/
            .contenedor__login-register{
                top: -10px;
                left: -5px;
                margin: auto;
            }
            .contenedor__login-register form{
                position: relative;
            }
    }
</style>
<body>
    <main>

            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Inicia sesión para entrar en la página</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Regístrarse</button>
                    </div>
                </div>

                <!--Formulario de Login y registro-->
                <div class="contenedor__login-register">
                    <!--Login-->
                    <form action="SessionControlador" method="post" class="formulario__login">
                        <h2>INICIAR SESSION</h2>
                        <input type="text" name="usuario" placeholder="Usuario" required="">
                        <input type="password" name="contrasena" placeholder="Contraseña" required="">
                        <button type="submit" name="btnIniciar" >INGRESAR</button>
                    </form>
                    <%
            HttpSession sesion = request.getSession();

            List<Usuario> datos = new ArrayList<Usuario>();
            if (request.getAttribute("fail") != null) {
                out.print("<script>alert('Ususario o Password erroneos!!!');</script>   ");
            }
            if (request.getAttribute("datos") != null) {
                datos = (List<Usuario>) request.getAttribute("datos");
                int id = 0;
                String usuario = "";
                String password = "";
                int cargo = 0;
                for (Usuario u : datos) {
                    id = u.getId();
                    usuario = u.getUsuario();
                    password = u.getContrasena();
                    cargo = u.getCargo();
                }
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("id", id);
                sesion.setAttribute("cargo", cargo);
                /*sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("id", id);*/
                response.sendRedirect("inicio.jsp");
            }
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("Index.jsp");
            }
        %>

                    <!--Register-->
                    <script>
                        function user()
                        {
                            var nombre = document.getElementById("nombres").value;
                            document.getElementById("usuario").value = nombre;
                        }
                        function password()
                        {
                            var ciaux = document.getElementById("ci").value;
                            var apellidoaux = document.getElementById("apellidoPaterno").value;
                            document.getElementById("contrasena").value = ciaux + "_"+ apellidoaux;
                        }
                    </script>
                    <form action="UsuarioControlador" method="post" class="formulario__register">
                        <h2>REGISTRARSE</h2>
                        <input type="hidden" name="id" value="0">
                        <input type="text" id="nombres" name="nombres" placeholder="Nombre" onchange="user()" required="">
                        <input type="text" id="apellidoPaterno" name="apellidoPaterno" placeholder="Apellido Paterno" onchange="password()" required="">
                        <input type="text" id="apellidoMaterno" name="apellidoMaterno" placeholder="Apellido Materno" required="">
                        <input type="number" id="ci" name="ci" placeholder="CI" onchange="password()" required="">
                        <input type="email" id="email" name="email" placeholder="Correo Electronico" required="">
                        <input type="text" id="usuario" name="usuario" placeholder="Usuario" required readonly="readonly">
                        <input type="text" id="contrasena" name="contrasena" placeholder="Contraseña" required readonly="readonly">
                        <input type="hidden" name="cargo" value="2">
                        <button name="REGISTRARSE" >REGISTRARSE</button>
                    </form>
                </div>
            </div>
        <br><br><br><br><br><br>
        <footer>
            <p>
                <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
            </p>
        </footer>
        </main>
     
        <script type="text/javascript">
                document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
                document.getElementById("btn__registrarse").addEventListener("click", register);
                window.addEventListener("resize", anchoPage);
                var formulario_login = document.querySelector(".formulario__login");
                var formulario_register = document.querySelector(".formulario__register");
                var contenedor_login_register = document.querySelector(".contenedor__login-register");
                var caja_trasera_login = document.querySelector(".caja__trasera-login");
                var caja_trasera_register = document.querySelector(".caja__trasera-register");
                function anchoPage(){

                    if (window.innerWidth > 850){
                        caja_trasera_register.style.display = "block";
                        caja_trasera_login.style.display = "block";
                    }else{
                        caja_trasera_register.style.display = "block";
                        caja_trasera_register.style.opacity = "1";
                        caja_trasera_login.style.display = "none";
                        formulario_login.style.display = "block";
                        contenedor_login_register.style.left = "0px";
                        formulario_register.style.display = "none";   
                    }
                }

                anchoPage();


                    function iniciarSesion(){
                        if (window.innerWidth > 850){
                            formulario_login.style.display = "block";
                            contenedor_login_register.style.left = "10px";
                            formulario_register.style.display = "none";
                            caja_trasera_register.style.opacity = "1";
                            caja_trasera_login.style.opacity = "0";
                        }else{
                            formulario_login.style.display = "block";
                            contenedor_login_register.style.left = "0px";
                            formulario_register.style.display = "none";
                            caja_trasera_register.style.display = "block";
                            caja_trasera_login.style.display = "none";
                        }
                    }

                    function register(){
                        if (window.innerWidth > 850){
                            formulario_register.style.display = "block";
                            contenedor_login_register.style.left = "410px";
                            formulario_login.style.display = "none";
                            caja_trasera_register.style.opacity = "0";
                            caja_trasera_login.style.opacity = "1";
                        }else{
                            formulario_register.style.display = "block";
                            contenedor_login_register.style.left = "0px";
                            formulario_login.style.display = "none";
                            caja_trasera_register.style.display = "none";
                            caja_trasera_login.style.display = "block";
                            caja_trasera_login.style.opacity = "1";
                        }
                }
        </script>
</body>
</html>
