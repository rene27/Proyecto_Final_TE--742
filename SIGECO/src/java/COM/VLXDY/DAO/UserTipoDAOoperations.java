package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.UserTipo;
import COM.VLXDY.UTILES.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserTipoDAOoperations extends ConexionDB implements UserTipoDAO {
    @Override
    public void insert(UserTipo  userTipo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO user_tipo(descripcion) VALUES (?)");
            ps.setString(1, userTipo.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(UserTipo userTipo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE user_tipo SET descripcion=? WHERE id=?");
            ps.setString(1, userTipo.getDescripcion());
            ps.setInt(2, userTipo.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM user_tipo WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public UserTipo getById(int id) throws Exception {
        UserTipo objeto = new UserTipo();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM user_tipo where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return objeto;
    }

    @Override
    public List<UserTipo> getAll() throws Exception {
        List<UserTipo> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM user_tipo");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<UserTipo>();
            while (rs.next()) {
                UserTipo objeto = new UserTipo();
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));
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
