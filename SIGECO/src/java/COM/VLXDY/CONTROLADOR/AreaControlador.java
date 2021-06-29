package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.AreaDAO;
import COM.VLXDY.DAO.AreaDAOoperations;
import COM.VLXDY.MODELO.Area;
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
@WebServlet(name = "AreaControlador", urlPatterns = {"/AreaControlador"})
public class AreaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
              
            AreaDAO dao = new AreaDAOoperations();
            int id;
            Area obj = new Area();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                
                case "add":
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormArea.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormArea.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/AreaControlador");
                    break;
                
                case "view":
                    List<Area> lista = dao.getAll();
                    request.setAttribute("list_obj", lista);
                    request.getRequestDispatcher("Area.jsp").forward(request, response);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                int id = Integer.parseInt(request.getParameter("id_area"));
        String nombre = request.getParameter("nombre_area");

        Area obj = new Area();

        obj.setId_area(id);
        obj.setNombre_area(nombre);


        if (id == 0) {
            try {
                AreaDAO dao = new AreaDAOoperations();
                dao.insert(obj);
                response.sendRedirect(request.getContextPath() + "/AreaControlador");

            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        } else {
            try {
                AreaDAO dao = new AreaDAOoperations();
                dao.update(obj);
                response.sendRedirect(request.getContextPath() + "/AreaControlador");

            } catch (Exception e) {
                System.out.println("Error actualizar" + e.getMessage());
            }
        }
        
       
    }
}
