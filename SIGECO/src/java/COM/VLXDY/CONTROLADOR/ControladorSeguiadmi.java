package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.AreaDAO;
import COM.VLXDY.DAO.AreaDAOoperations;
import COM.VLXDY.DAO.HojaRutaDAO;
import COM.VLXDY.DAO.HojaRutaDAOoperations;
import COM.VLXDY.DAO.SeguimientoDAO;
import COM.VLXDY.DAO.SeguimientoDAOoperations;
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
@WebServlet(name = "ControladorSeguiadmi", urlPatterns = {"/ControladorSeguiadmi"})
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  
        maxFileSize         = 1024 * 1024 * 10, 
        maxRequestSize      = 1024 * 1024 * 15)
public class ControladorSeguiadmi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SeguimientoDAO dao = new SeguimientoDAOoperations();
            HojaRutaDAO dao_ru = new HojaRutaDAOoperations();
            AreaDAO dao_area = new AreaDAOoperations();
            UsuarioDAO dao_us = new UsuarioDAOoperations();
            TipoDocDAO dao_doc = new TipoDocDAOoperations();
            int aux = Integer.parseInt(request.getParameter("id"));
            int aux1 = aux;
            
           int id;
           
            Seguimiento hoja = new Seguimiento();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            List<HojaRuta> lista_ru;
            List<Usuario> lista_us;
            List<TipoDoc> lista_doc;
            List<Area> lista_ar;
            switch (action) {
                case "edit":
                    lista_doc = dao_doc.getAll();
                    lista_us = dao_us.getAll();
                    lista_ar = dao_area.getAll();
                    lista_ru = dao_ru.getAll();
                    request.setAttribute("lista_doc", lista_doc);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("lista_ar", lista_ar);
                    request.setAttribute("lista_ru", lista_ru);

                    hoja = dao.getById(aux1);
                    request.setAttribute("aux", aux);
                    request.setAttribute("hoja", hoja);
                    request.getRequestDispatcher("FormSeguiAdmi.jsp").forward(request, response);

                    break;
                case "view":
                    lista_doc = dao_doc.getAll();
                    lista_us = dao_us.getAll();
                    lista_ar = dao_area.getAll();
                    lista_ru = dao_ru.getAll();
                    request.setAttribute("lista_doc", lista_doc);
                    request.setAttribute("lista_us", lista_us);
                    request.setAttribute("lista_ar", lista_ar);
                    request.setAttribute("lista_ru", lista_ru);
                    id = Integer.parseInt(request.getParameter("id"));
                    List<Seguimiento> hoj = dao.getByad(id);

                    request.setAttribute("hoj", hoj);
                    request.getRequestDispatcher("SeguiAdmi.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int aux = Integer.parseInt(request.getParameter("aux"));
        int id_seguimiento = Integer.parseInt(request.getParameter("id_seguimiento"));
        int id_hoja = Integer.parseInt(request.getParameter("id_hoja"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_area = Integer.parseInt(request.getParameter("id_area"));
        int id_tramitador = Integer.parseInt(request.getParameter("id_tramitador"));
        int id_tipo = Integer.parseInt(request.getParameter("id_tipo"));
        String observaciones = request.getParameter("observaciones");
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");
        InputStream inputStream = null;
        Part filePart = request.getPart("archivopdf2");
        if (filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }

        Seguimiento hoja = new Seguimiento();

        hoja.setId_seguimiento(id_seguimiento);
        hoja.setId_hoja(id_hoja);
        hoja.setId_usuario(id_usuario);
        hoja.setId_area(id_area);
        hoja.setId_tramitador(id_tramitador);
        hoja.setId_tipo(id_tipo);
        hoja.setObservaciones(observaciones);
        hoja.setFecha(fecha);
        hoja.setEstado(estado);
        hoja.setArchivopdf(inputStream);

        if (id_seguimiento == 0) {
            try {
                SeguimientoDAO dao = new SeguimientoDAOoperations();
                dao.insert(hoja);
                response.sendRedirect(request.getContextPath() + "/ControladorSeguiadmi");

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else {
            try {
                SeguimientoDAO dao = new SeguimientoDAOoperations();
                if (inputStream != null) {
                    dao.insertar(hoja);
                } else {
                    dao.insertar2(hoja);
                }
                response.sendRedirect(request.getContextPath() + "/ControladorSeguiadmi?action=view&id="+aux);

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }

}