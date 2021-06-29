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
@WebServlet(name = "ControladorSegui", urlPatterns = {"/ControladorSegui"})
public class ControladorSegui extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SeguimientoDAO dao = new SeguimientoDAOoperations();
            HojaRutaDAO dao_ru = new HojaRutaDAOoperations();
            AreaDAO dao_area = new AreaDAOoperations();
            UsuarioDAO dao_us = new UsuarioDAOoperations();
            TipoDocDAO dao_doc = new TipoDocDAOoperations();
            
           int id;
           
            Seguimiento hoja = new Seguimiento();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            List<HojaRuta> lista_ru;
            List<Usuario> lista_us;
            List<TipoDoc> lista_doc;
            List<Area> lista_ar;
            switch (action) {
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
                    List<Seguimiento> hoj = dao.getByas(id);

                    request.setAttribute("hoj", hoj);
                    request.getRequestDispatcher("seguir.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error en : " + e.getMessage());
        }
    }
}