package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.UserTipoDAO;
import COM.VLXDY.DAO.UserTipoDAOoperations;
import COM.VLXDY.MODELO.UserTipo;
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
@WebServlet(name = "UserTipoControlador", urlPatterns = {"/UserTipoControlador"})
public class UserTipoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
              
            UserTipoDAO dao = new UserTipoDAOoperations();
            int id;
            UserTipo obj = new UserTipo();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                
                case "add":
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormUserTipo.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormUserTipo.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/UserTipoControlador");
                    break;
                
                case "view":
                    List<UserTipo> lista = dao.getAll();
                    request.setAttribute("list_obj", lista);
                    request.getRequestDispatcher("UserTipo.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");

        UserTipo obj = new UserTipo();

        obj.setId(id);
        obj.setDescripcion(descripcion);


        if (id == 0) {
            try {
                UserTipoDAO dao = new UserTipoDAOoperations();
                dao.insert(obj);
                response.sendRedirect(request.getContextPath() + "/UserTipoControlador");

            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        } else {
            try {
                UserTipoDAO dao = new UserTipoDAOoperations();
                dao.update(obj);
                response.sendRedirect(request.getContextPath() + "/UserTipoControlador");

            } catch (Exception e) {
                System.out.println("Error actualizar" + e.getMessage());
            }
        }
        
       
    }
}
