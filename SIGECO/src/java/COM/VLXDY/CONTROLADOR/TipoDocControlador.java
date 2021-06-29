package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.TipoDocDAO;
import COM.VLXDY.DAO.TipoDocDAOoperations;
import COM.VLXDY.MODELO.TipoDoc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "TipoDocControlador", urlPatterns = {"/TipoDocControlador"})
public class TipoDocControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
              
            TipoDocDAO dao = new TipoDocDAOoperations();
            int id;
            TipoDoc objeto = new TipoDoc();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                
                case "add":
                    request.setAttribute("objeto", objeto);
                    request.getRequestDispatcher("FormTipoDoc.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    objeto = dao.getById(id);
                    System.out.println(objeto);
                    request.setAttribute("objeto", objeto);
                    request.getRequestDispatcher("FormTipoDoc.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/TipoDocControlador");
                    break;
                
                case "view":
                    List<TipoDoc> lista = dao.getAll();
                    request.setAttribute("list_obj", lista);
                    request.getRequestDispatcher("TipoDoc.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                int id = Integer.parseInt(request.getParameter("id_tipo"));
        String nombre = request.getParameter("nombre_doc");

        TipoDoc obj = new TipoDoc();

        obj.setId_tipo(id);
        obj.setNombre_doc(nombre);


        if (id == 0) {
            try {
                TipoDocDAO dao = new TipoDocDAOoperations();
                dao.insert(obj);
                response.sendRedirect(request.getContextPath() + "/TipoDocControlador");

            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        } else {
            try {
                TipoDocDAO dao = new TipoDocDAOoperations();
                dao.update(obj);
                response.sendRedirect(request.getContextPath() + "/TipoDocControlador");

            } catch (Exception e) {
                System.out.println("Error actualizar" + e.getMessage());
            }
        }
        
       
    }
}