<%-- 
    Document   : Usuario
    Created on : 28-jun-2021, 15:08:54
    Author     : Usuario
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .btn {
        background: linear-gradient(to right, red, orange, yellow, green, blue);
        -webkit-border-radius: 12;
        -moz-border-radius: 12;
        border-radius: 12px;
        font-family: Arial;
        color: #ffffff;
        font-size: 18px;
        padding: 10px 20px 10px 20px;
        text-decoration: none;
        color: black;
      }
      .btn:hover {
        background: linear-gradient(to right, blue, green, yellow, orange, red);
        text-decoration: none;
        color: black;
      }
      .btn1 {
        background: linear-gradient(to right, red, orange, yellow, green, blue);
        -webkit-border-radius: 12;
        -moz-border-radius: 12;
        border-radius: 12px;
        font-family: Arial;
        color: #ffffff;
        font-size: 18px;
        padding: 10px 20px 10px 20px;
        text-decoration: none;
        color: black;
      }
      .btn1:hover {
        background: linear-gradient(to right, rgba(255,255,255,0), rgba(255,255,255,1)), url(http://foo.com/image.jpg);
        text-decoration: none;
        color: black;
      }
      .btn2 {
        background-image: linear-gradient(red, yellow);
        -webkit-border-radius: 12;
        -moz-border-radius: 12;
        border-radius: 12px;
        font-family: Arial;
        color: #ffffff;
        font-size: 18px;
        padding: 10px 20px 10px 20px;
        text-decoration: none;
      }
      .btn2:hover {
        background-image: linear-gradient(to right, red , yellow);
        text-decoration: none;
      }
      h1 {
            font-size: 30px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 300;
            text-align: center;
            margin-bottom: 15px;
          }
          table {
            width: 100%;
            table-layout: fixed;
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4)
          }
          .tbl-header {
            background-color: rgba(255, 255, 255, 0.3);
          }
          .tbl-content {
            height: 400px;
            overflow-x: auto;
            margin-top: 0px;
            border: 1px solid rgba(255, 255, 255, 0.3);
          }
          th {
            padding: 20px 15px;
            text-align: left;
            font-weight: 500;
            font-size: 12px;
            color: white;
            background-color: black;
          }
          td {
            padding: 15px;
            text-align: left;
            vertical-align: middle;
            font-weight: 300;
            font-size: 12px;
            color: #fff;
            border-bottom: solid 1px rgba(255, 255, 255, 0.1);
          }
          @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
          body {
                background-image: linear-gradient(
                            rgba(0, 0, 0, 0.6),
                            rgba(0, 0, 0, 0.6)
                                    ), url("Fondo.png");
                                    background-repeat: no-repeat;
                                    background-attachment: fixed;
                                    background-size: 100% 100%;
            }
          section {
            margin: 50px;
          }
          .made-with-love {
            margin-top: 40px;
            padding: 10px;
            clear: left;
            text-align: center;
            font-size: 10px;
            font-family: arial;
            color: #fff;
          }
          .made-with-love i {
            font-style: normal;
            color: #f50057;
            font-size: 14px;
            position: relative;
            top: 2px;
          }
          .made-with-love a {
            color: #fff;
            text-decoration: none;
          }
          .made-with-love a:hover {
            text-decoration: underline;
          }
          ::-webkit-scrollbar {
            width: 6px;
          }
          ::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
          }
          ::-webkit-scrollbar-thumb {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
          }
    </style>
    <body>
        <h1>LISTADO DE USUARIO</h1>
        <p><a href="UsuarioControlador?action=add" class="btn"><img src="2.png" title="Nuevo registro"/>NUEVO</a></p>
            <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRES</th>
                    <th>APE. PATERNO</th>
                    <th>APE. MATERNO</th>
                    <th>CI</th>
                    <th>EMAIL</th>
                    <th>CARGO</th>
                    <th>USUARIO</th>
                    <th>CONTRASEÑA</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
            </table>
            </div>
            <div class="tbl-content">
                <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <c:forEach var="item" items="${lista}">        
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombres}</td>
                        <td>${item.apellidoPaterno}</td>
                        <td>${item.apellidoMaterno}</td>
                        <td>${item.ci}</td>
                        <td>${item.email}</td>
                        <td>
                            <c:forEach var="item2" items="${listaUserTipo}">
                                <c:if test="${item.cargo == item2.id}">
                                    ${item2.descripcion} 
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${item.usuario}</td>
                        <td>${item.contrasena}</td>
                        <td><a  href="UsuarioControlador?action=edit&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE EDITAR EL DATO DE  ${item.nombres} ${item.apellidoPaterno} ${item.apellidoMaterno} ??'))" class="btn1"><img src="4.png" width="18" title="Modificar"/></a></td>
                        <td><a  href="UsuarioControlador?action=delete&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR LOS DATOS DE ${item.nombres} ${item.apellidoPaterno} ${item.apellidoMaterno}??'))" class="btn2"><img src="3.png" width="18" title="Eliminar"/></a></td>
                    </tr>
                </c:forEach>
               </tbody>
    </table>
  </div>
        <footer>
        <p>
            <h3 id="heading" align="center">DEVELOPED &#x1F497; by <a style="color:yellow;" ><strong>VLADIMIR HUANCA</strong></a></h3>
        </p>
        </footer>
        <script type="text/javascript">
                $(window)
                .on("load resize ", function () {
                  var scrollWidth =
                    $(".tbl-content").width() - $(".tbl-content table").width();
                  $(".tbl-header").css({ "padding-right": scrollWidth });
                })
                .resize();
        </script>
    </body>
</html>