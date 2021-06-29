<%-- 
    Document   : frmaviso
    Created on : 04-may-2021, 19:17:36
    Author     : Vlxdy Hishikawa
--%>
<%
    HttpSession ses = request.getSession();
    String usuario = "";
    String id = "";
    int cargo = 0;

    if (ses.getAttribute("usuario") != null && ses != null && ses.getAttribute("id") != null) {
        usuario = ses.getAttribute("usuario").toString();
        id = ses.getAttribute("id").toString();
        cargo = Integer.parseInt(ses.getAttribute("cargo").toString());
    } else {
        response.sendRedirect("Index.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logo.png">
        <title> TUTORIAL 14 </title>
    </head>
    <style>
        body {
  		background-image: linear-gradient(
     		rgba(0, 0, 0, 0.6),
     		rgba(0, 0, 0, 0.6)
   			), url("Fondo.png");
  			background-repeat: no-repeat;
 			background-attachment: fixed;
  			background-size: 100% 100%;
  			padding: 20px;
  			background-color:#dbffcc;
            }
        #heading { color: #fff; }
        a,h1,h2,h4,li{
		color: white;
                }
        form{
		width: 480px;
		padding: 16px;
		border-radius: 0px;
		margin: auto;
		background-color: #ccf;
	}
	form input[type="number"]{
		width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:#9f9;
		margin:8px 0;
		display: inline-block;
	}
        form input[type="text"]{
		width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:#9f9;
		margin:8px 0;
		display: inline-block;
	}
	form input[type="submit"]{
		width: 100%;
		padding: 8px 16px;
		margin-top: 32px;
		border:1px solid #1e3300;
		border-radius: 5px;
		display: block;
		color: #fff;
		background-color:#1e3300;
	}
	form input[type="submit"]:hover{
            
		cursor:pointer;
	}
        SELECT{ 
                width: 200px;
		padding: 3px 10px;
		border:1px solid #f6f6f6;
		border-radius: 3px;
		background-color:  #f6f6f6;
		margin:8px 0;
		display: inline-block;
            }
    </style>
    <body>
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
        
        <c:if test="${objeto.id == 0}">
            <h1 align="center">REGISTRAR USUARIO Y/O EMPLEADO</h1>
        </c:if>
        <c:if test="${objeto.id != 0}">
                <h1 align="center">MODIFICAR DATOS DEL USUARIO Y/O EMPLEADO  "${objeto.nombres} ${objeto.apellidoPaterno}"  </h1>
        </c:if>
            <form action="UsuarioControlador" method="post">
                <h3 align="center">
                <c:if test="${objeto.id == 0}">
                    INGRESE LOS DATOS DEL USUARIO Y/O EMPLEADO
                </c:if>
                <c:if test="${objeto.id != 0}">
                    MODIFIQUE LOS DATOS DEL USUARIO Y/O EMPLEADO
                </c:if> 
            </h3>
                <input type="hidden" name="id" value="${objeto.id}"/>
            <table>
                <tr>
                    <td>NOMBRE:</td>
                    <td><input type="text" id="nombres" name="nombres" placeholder="Nombre" onchange="user()" value="${objeto.nombres}" required=""></td>
                </tr>
                <tr>
                    <td>APELLIDO PATERNO:</td>
                    <td><input type="text" id="apellidoPaterno" name="apellidoPaterno" placeholder="Apellido Paterno" onchange="password()" value="${objeto.apellidoPaterno}" required=""></td>
                </tr>
                <tr>
                    <td>APELLIDO MATERNO:</td>
                    <td><input type="text" id="apellidoMaterno" name="apellidoMaterno" placeholder="Apellido Materno" value="${objeto.apellidoMaterno}" required=""></td>
                </tr>
                <tr>
                    <td>CI:</td>
                    <td><input type="number" id="ci" name="ci" placeholder="CI" onchange="password()" value="${objeto.ci}" required=""></td>
                </tr>
                <tr>
                    <td>EMAIL:</td>
                    <td><input type="email" id="email" name="email" placeholder="Correo Electronico" value="${objeto.email}" required=""></td>
                </tr>
                <tr>
                        <td>CARGO:</td>
                        <td>
                            <select name="cargo">
                                <c:forEach var="item" items="${UserTipo}"> 
                                    <option value= ${item.id}    
                                            <c:if test="${objeto.cargo == item.id}">
                                                selected
                                            </c:if>
                                            >${item.descripcion}</option>
                                </c:forEach>
                            </select>        
                        </td> 
                    </tr>
                <tr>
                    <td>USUARIO:</td>
                    <td><input type="text" id="usuario" name="usuario" placeholder="Usuario" value="${objeto.usuario}" required readonly="readonly"></td>
                </tr>
                <tr>
                    <td>CONTRASEÑA:</td>
                    <td><input type="text" id="contrasena" name="contrasena" placeholder="Contraseña" value="${objeto.contrasena}" required readonly="readonly"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="enviar"/></td>
                </tr>
            </table>
            </form>
    <footer>
        <p><br><br>
            <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
        </p>
    </footer>
    </body>
</html>

<input type="hidden" name="id" value="0">
                        
