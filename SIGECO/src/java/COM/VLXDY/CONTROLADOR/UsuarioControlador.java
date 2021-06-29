package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.UserTipoDAO;
import COM.VLXDY.DAO.UserTipoDAOoperations;
import COM.VLXDY.DAO.UsuarioDAO;
import COM.VLXDY.DAO.UsuarioDAOoperations;
import COM.VLXDY.MODELO.UserTipo;
import COM.VLXDY.MODELO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            UsuarioDAO dao = new UsuarioDAOoperations();
            UserTipoDAO daoUserTipo = new UserTipoDAOoperations();
            int id;
            Usuario obj = new Usuario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            List<UserTipo> listaUserTipo;
            switch (action) {
                case "add":
                    listaUserTipo = daoUserTipo.getAll();
                    request.setAttribute("UserTipo", listaUserTipo);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormUsuario.jsp").forward(request, response);
                    break;
                case "edit":
                    listaUserTipo = daoUserTipo.getAll();
                    request.setAttribute("UserTipo", listaUserTipo);

                    id = Integer.parseInt(request.getParameter("id"));
                    obj = dao.getById(id);
                    System.out.println(obj);
                    request.setAttribute("objeto", obj);
                    request.getRequestDispatcher("FormUsuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/UsuarioControlador");
                    break;
                case "view":
                    listaUserTipo = daoUserTipo.getAll();
                    request.setAttribute("listaUserTipo", listaUserTipo);
                    
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Usuario.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error Get " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidop = request.getParameter("apellidoPaterno");
        String apellidom = request.getParameter("apellidoMaterno");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String email = request.getParameter("email");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        Usuario obj = new Usuario();
        obj.setId(id);
        obj.setNombres(nombres);
        obj.setApellidoPaterno(apellidop);
        obj.setApellidoMaterno(apellidom);
        obj.setCi(ci);
        obj.setEmail(email);
        obj.setCargo(cargo);
        obj.setUsuario(usuario);
        obj.setContrasena(contrasena);

        obj.toString();
        UsuarioDAO dao1 = new UsuarioDAOoperations();

        try {
            if (dao1.getByIdExist(id) == false) {
                try {
                    UsuarioDAO dao = new UsuarioDAOoperations();
                    dao.insert(obj);
                    response.sendRedirect(request.getContextPath() + "/UsuarioControlador");

                } catch (Exception e) {
                    System.out.println("Error insertar " + e.getMessage());
                }
            } else {
                try {
                    UsuarioDAO dao = new UsuarioDAOoperations();
                    dao.update(obj);
                    response.sendRedirect(request.getContextPath() + "/UsuarioControlador");

                } catch (Exception e) {
                    System.out.println("Error actualizar " + e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar existente " + ex.getMessage());
        }

    }

}
