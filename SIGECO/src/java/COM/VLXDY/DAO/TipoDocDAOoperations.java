package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.TipoDoc;
import COM.VLXDY.UTILES.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipoDocDAOoperations extends ConexionDB implements TipoDocDAO{

    @Override
    public void insert(TipoDoc tipoDoc) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO tipo_doc(nombre_doc) VALUES (?)");
            ps.setString(1, tipoDoc.getNombre_doc());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(TipoDoc tipoDoc) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE tipo_doc SET nombre_doc=? WHERE id_tipo=?");
            ps.setString(1, tipoDoc.getNombre_doc());
            ps.setInt(2, tipoDoc.getId_tipo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM tipo_doc WHERE id_tipo = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public TipoDoc getById(int id) throws Exception {
        TipoDoc objeto = new TipoDoc();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM tipo_doc where id_tipo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objeto.setId_tipo(rs.getInt("id_tipo"));
                objeto.setNombre_doc(rs.getString("nombre_doc"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return objeto;
    }

    @Override
    public List<TipoDoc> getAll() throws Exception {
        List<TipoDoc> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM tipo_doc");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<TipoDoc>();
            while (rs.next()) {
                TipoDoc objeto = new TipoDoc();
                objeto.setId_tipo(rs.getInt("id_tipo"));
                objeto.setNombre_doc(rs.getString("nombre_doc"));
                lista.add(objeto);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}

