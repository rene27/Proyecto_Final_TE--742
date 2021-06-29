package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.AreaDAO;
import COM.VLXDY.DAO.AreaDAOoperations;
import COM.VLXDY.DAO.HojaRutaDAO;
import COM.VLXDY.DAO.HojaRutaDAOoperations;
import COM.VLXDY.DAO.TipoDocDAO;
import COM.VLXDY.DAO.TipoDocDAOoperations;
import COM.VLXDY.DAO.UsuarioDAO;
import COM.VLXDY.DAO.UsuarioDAOoperations;
import COM.VLXDY.MODELO.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.Date;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "HojaRutaControlador", urlPatterns = {"/HojaRutaControlador"})
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  
        maxFileSize         = 1024 * 1024 * 10, 
        maxRequestSize      = 1024 * 1024 * 15)
public class HojaRutaControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HojaRutaDAO dao = new HojaRutaDAOoperations();
            AreaDAO dao_area = new AreaDAOoperations();
            UsuarioDAO dao_us = new UsuarioDAOoperations();
            TipoDocDAO dao_doc = new TipoDocDAOoperations();
            

            int id;
            HojaRuta hoja = new HojaRuta();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            List<Usuario> lista_us;
            List<TipoDoc> lista_doc;
            List<Area> lista_ar;
            switch (action) {
                case "add":

                    lista_doc = dao_doc.getAll();
                    lista_us = dao_us.getAll();
                    lista_ar = dao_area.getAll();
                    request.setAttribute("lista_doc", lista_doc);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("lista_ar", lista_ar);
                    request.setAttribute("hoja", hoja);
                    request.getRequestDispatcher("FormHojaRuta.jsp").forward(request, response);

                    break;
                case "edit":
                    lista_doc = dao_doc.getAll();
                    lista_us = dao_us.getAll();
                    lista_ar = dao_area.getAll();
                    request.setAttribute("lista_doc", lista_doc);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("lista_ar", lista_ar);

                    id = Integer.parseInt(request.getParameter("id"));
                    hoja = dao.getById(id);

                    request.setAttribute("hoja", hoja);
                    request.getRequestDispatcher("FormHojaRuta.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/HojaRutaControlador");
                    break;
                    
                case "inver":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.in();
                    response.sendRedirect(request.getContextPath() + "/HojaRutaControlador");
                    break;

                case "view":
                    lista_doc = dao_doc.getAll();
                    lista_us = dao_us.getAll();
                    lista_ar = dao_area.getAll();
                    request.setAttribute("lista_doc", lista_doc);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("lista_ar", lista_ar);


                    List<HojaRuta> hoj = dao.getAll();

                    request.setAttribute("hoj", hoj);
                    request.getRequestDispatcher("HojaRuta.jsp").forward(request, response);
                    break;

            }

        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_hoja_ruta = Integer.parseInt(request.getParameter("id_hoja_ruta"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_area = Integer.parseInt(request.getParameter("id_area"));
        int id_tramitador = Integer.parseInt(request.getParameter("id_tramitador"));
        int id_tipo = Integer.parseInt(request.getParameter("id_tipo"));
        String descripcion = request.getParameter("descripcion");
        String fecha_recepcion = request.getParameter("fecha_recepcion");
        InputStream inputStream = null;
        Part filePart = request.getPart("archivopdf");
        if (filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }

        HojaRuta hoja = new HojaRuta();

        hoja.setId_hoja_ruta(id_hoja_ruta);
        hoja.setId_usuario(id_usuario);
        hoja.setId_area(id_area);
        hoja.setId_tramitador(id_tramitador);
        hoja.setId_tipo(id_tipo);
        hoja.setDescripcion(descripcion);
        hoja.setFecha_recepcion(fecha_recepcion);
        hoja.setArchivopdf(inputStream);
        if (id_hoja_ruta == 0) {
            try {
                HojaRutaDAO dao = new HojaRutaDAOoperations();
                dao.insert(hoja);
                response.sendRedirect(request.getContextPath() + "/HojaRutaControlador");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                HojaRutaDAO dao = new HojaRutaDAOoperations();
                if (inputStream != null) {
                    dao.update(hoja);
                } else {
                    dao.update2(hoja);
                }
                response.sendRedirect(request.getContextPath() + "/HojaRutaControlador");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

}