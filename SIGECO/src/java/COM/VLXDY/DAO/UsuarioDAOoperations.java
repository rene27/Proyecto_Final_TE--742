package COM.VLXDY.DAO;
import COM.VLXDY.UTILES.ConexionDB;
import COM.VLXDY.MODELO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class UsuarioDAOoperations extends ConexionDB implements UsuarioDAO{
    
    @Override
    public List<Usuario> verificar_usuario(String us, String pas) throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios where usuario=? and contraseña=?");
            ps.setString(1, us);
            ps.setString(2, pas);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_user"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidoPaterno(rs.getString("apellido_paterno"));
                user.setApellidoPaterno(rs.getString("apellido_materno"));
                user.setCi(rs.getInt("ci"));
                user.setEmail(rs.getString("email"));
                user.setCargo(rs.getInt("cargo"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contraseña"));
                lista.add(user);
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

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario user = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios where id_user=? ORDER By apellido_paterno, nombres");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id_user"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidoPaterno(rs.getString("apellido_paterno"));
                user.setApellidoMaterno(rs.getString("apellido_materno"));
                user.setCi(rs.getInt("ci"));
                user.setEmail(rs.getString("email"));
                user.setCargo(rs.getInt("cargo"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contraseña"));   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return user;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_user"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidoPaterno(rs.getString("apellido_paterno"));
                user.setApellidoMaterno(rs.getString("apellido_materno"));
                user.setCi(rs.getInt("ci"));
                user.setEmail(rs.getString("email"));
                user.setCargo(rs.getInt("cargo"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contraseña"));
                lista.add(user);
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

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios(nombres, apellido_paterno,apellido_materno,ci, email, cargo, usuario, contraseña) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidoPaterno());
            ps.setString(3, usuario.getApellidoMaterno());
            ps.setInt(4, usuario.getCi());
            ps.setString(5, usuario.getEmail());
            ps.setInt(6, usuario.getCargo());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getContrasena());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET nombres=?, apellido_paterno=?, apellido_materno=?, ci=?, email=?, cargo=?, usuario=?, contraseña=? WHERE id_user=?");
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidoPaterno());
            ps.setString(3, usuario.getApellidoMaterno());
            ps.setInt(4, usuario.getCi());
            ps.setString(5, usuario.getEmail());
            ps.setInt(6, usuario.getCargo());
            ps.setString(7, usuario.getUsuario());
            ps.setString(8, usuario.getContrasena());
            ps.setInt(9, usuario.getId());         
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
            PreparedStatement ps = this.conn.prepareStatement("delete from usuarios where id_user = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }


    @Override
    public boolean getByIdExist(int id) throws Exception {
        boolean res=false;
        Usuario user = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios where id_user=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res=true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return res;      
    }

}
