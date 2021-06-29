package COM.VLXDY.CONTROLADOR;

import COM.VLXDY.UTILES.ConexionDB;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "PdfControlador", urlPatterns = {"/PdfControlador"})
public class PdfControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");

        ConexionDB con = new ConexionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            ps = con.conectar().prepareStatement("SELECT documentos_adj FROM hoja_ruta WHERE id_hoja_ruta = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datospdf = new byte[tamanoInput];
            bos.read(datospdf, 0, tamanoInput);

            response.getOutputStream().write(datospdf);
            bos.close();
            ps.close();
            rs.close();
            con.desconectar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}