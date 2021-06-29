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
        <script type="text/javascript">
        function validate() {
            var fileName = document.getElementById("btn_file").value;
            var idxDot = fileName.lastIndexOf(".") + 1;
            var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
            if (extFile == "pdf") {
            } else {
                alert("¡Solo se permiten archivos PDF!");
                document.getElementById("btn_file").value = "";
            }
        }
    </script>
        <c:if test="${hoja.id_hoja_ruta == 0}">
            <h1 align="center">REGISTRAR DATOS DEL DOCUMENTO</h1>
        </c:if>
        <c:if test="${hoja.id_hoja_ruta != 0}">
                <h1 align="center">MODIFICAR DATOS DEL DOCUMENTO  "${objeto.nombre_area}"  </h1>
        </c:if>
            <form action="HojaRutaControlador" method="post" enctype="multipart/form-data">
                <h3 align="center">
                <c:if test="${hoja.id_hoja_ruta == 0}">
                    INGRESE LOS DATOS DEL DOCUMENTO
                </c:if>
                <c:if test="${hoja.id_hoja_ruta != 0}">
                    MODIFIQUE LOS DATOS DEL DOCUMENTO
                </c:if> 
            </h3>
                <input type="hidden" name="id_hoja_ruta" value="${hoja.id_hoja_ruta}"/>
            <table>
                <tr>
                    <td>ENCARGADO</td>
                        <td>
                            <select name="id_usuario">
                                <c:forEach var="item" items="${lista_us}"> 
                                    <option value= ${item.id}    
                                            <c:if test="${hoja.id_usuario == item.id}">
                                                selected
                                            </c:if>
                                            >${item.nombres}${" "}${item.apellidoPaterno}${" "}${item.apellidoMaterno} </option>
                                </c:forEach>
                            </select>        

                    </td>
                </tr>
                <tr>
                    <td>AREA</td>
                        <td>
                            <select name="id_area">
                                <c:forEach var="item" items="${lista_ar}"> 
                                    <option value= ${item.id_area}    
                                            <c:if test="${hoja.id_area == item.id_area}">
                                                selected
                                            </c:if>
                                            >${item.nombre_area} </option>
                                </c:forEach>
                            </select>        

                    </td>
                </tr>
                <tr>
                    <td>TRAMITADOR</td>
                        <td>
                            <select name="id_tramitador">
                                <c:forEach var="item" items="${lista_us}"> 
                                    <option value= ${item.id}    
                                            <c:if test="${hoja.	id_tramitador == item.id}">
                                                selected
                                            </c:if>
                                            >${item.nombres}${" "}${item.apellidoPaterno}${" "}${item.apellidoMaterno} </option>
                                </c:forEach>
                            </select>        

                    </td>
                </tr>
                <tr>
                    <td>TIPO DOCUMENTO</td>
                        <td>
                            <select name="id_tipo">
                                <c:forEach var="item" items="${lista_doc}"> 
                                    <option value= ${item.id_tipo}    
                                            <c:if test="${hoja.id_tipo == item.id_tipo}">
                                                selected
                                            </c:if>
                                            >${item.nombre_doc} </option>
                                </c:forEach>
                            </select>        
                    </td>
                </tr>
                <tr>
                    <td>DESCRIPCION:</td>
                    <td><input type="text" id="descripcion" name="descripcion" value="${hoja.descripcion}" required=""></td>
                </tr>
                <tr>
                    <td>FECHA RECEPCION:</td>
                    <td><input type="date" id="fecha_recepcion" name="fecha_recepcion" value="${hoja.fecha_recepcion}" required=""></td>
                </tr>
                <tr>
                    <td>DOCUMENTO ADJUNTO: <br>
                            <c:if test="${hoja.id_hoja_ruta > 0}"><a href="PdfControlador?id=${hoja.id_hoja_ruta}" target="_blank"></a></c:if>
                            </td>
                            <td>
                                <input name="archivopdf" type="file" id="btn_file" onchange="validate()">
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
