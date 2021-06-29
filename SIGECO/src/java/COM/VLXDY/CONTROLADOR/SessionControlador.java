package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.DAO.UsuarioDAO;
import COM.VLXDY.DAO.UsuarioDAOoperations;
import COM.VLXDY.MODELO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SessionControlador", urlPatterns = {"/SessionControlador"})
public class SessionControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String usuario = "";
            String contrasena = "";
            UsuarioDAO dao = new UsuarioDAOoperations();
            List<Usuario> datos = new ArrayList<Usuario>();
            if (request.getParameter("btnIniciar") != null) {
                try {
                    usuario = request.getParameter("usuario");
                    contrasena = request.getParameter("contrasena");
                    datos = dao.verificar_usuario(usuario, contrasena);
                    if (datos.size() > 0) {
                        request.setAttribute("datos", datos);
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    } else {
                        request.setAttribute("fail", "No hay acceso!");
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(SessionControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }     
    }
}