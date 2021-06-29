package COM.VLXDY.DAO;
import COM.VLXDY.MODELO.Seguimiento;
import COM.VLXDY.UTILES.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SeguimientoDAOoperations extends ConexionDB implements  SeguimientoDAO {
    @Override
    public void insert(Seguimiento seguimiento) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seguimiento(id_hoja, id_usuario, id_area, id_tramitador, id_tipo, observaciones, fecha, estado,documento) VALUES (?,?,?,?,?,?,?,?,?);");
            ps.setInt(1, seguimiento.getId_hoja());
            ps.setInt(2, seguimiento.getId_usuario());
            ps.setInt(3, seguimiento.getId_area());
            ps.setInt(4, seguimiento.getId_tramitador());
            ps.setInt(5, seguimiento.getId_tipo());
            ps.setString(6, seguimiento.getObservaciones());         
            ps.setString(7, seguimiento.getFecha());  
            ps.setString(8, seguimiento.getEstado());  
            ps.setBlob(9, seguimiento.getArchivopdf());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seguimiento seguimiento) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE seguimiento SET id_hoja=?, id_usuario=?, id_area=?, id_tramitador=?, id_tipo=?, observaciones=?, fecha=?, estado=?, documento=? WHERE id_seguimiento=?");
            ps.setInt(1, seguimiento.getId_hoja());
            ps.setInt(2, seguimiento.getId_usuario());
            ps.setInt(3, seguimiento.getId_area());
            ps.setInt(4, seguimiento.getId_tramitador());
            ps.setInt(5, seguimiento.getId_tipo());
            ps.setString(6, seguimiento.getObservaciones());         
            ps.setString(7, seguimiento.getFecha());  
            ps.setString(8, seguimiento.getEstado());  
            ps.setBlob(9, seguimiento.getArchivopdf());
            ps.setInt(10, seguimiento.getId_seguimiento());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public void update2(Seguimiento seguimiento) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE seguimiento SET id_hoja=?, id_usuario=?, id_area=?, id_tramitador=?, id_tipo=?, observaciones=?, fecha=?, estado=? WHERE id_seguimiento=?");
            ps.setInt(1, seguimiento.getId_hoja());
            ps.setInt(2, seguimiento.getId_usuario());
            ps.setInt(3, seguimiento.getId_area());
            ps.setInt(4, seguimiento.getId_tramitador());
            ps.setInt(5, seguimiento.getId_tipo());
            ps.setString(6, seguimiento.getObservaciones());         
            ps.setString(7, seguimiento.getFecha());  
            ps.setString(8, seguimiento.getEstado());  
            ps.setInt(9, seguimiento.getId_seguimiento());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM seguimiento WHERE id_seguimiento = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Seguimiento getById(int id) throws Exception {
        Seguimiento seguimiento = new Seguimiento();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seguimiento where id_seguimiento=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                seguimiento.setId_seguimiento(rs.getInt("id_seguimiento"));
                seguimiento.setId_hoja(rs.getInt("id_hoja"));
                seguimiento.setId_usuario(rs.getInt("id_usuario"));
                seguimiento.setId_area(rs.getInt("id_area"));
                seguimiento.setId_tramitador(rs.getInt("id_tramitador"));
                seguimiento.setId_tipo(rs.getInt("id_tipo"));
                seguimiento.setObservaciones(rs.getString("observaciones"));
                seguimiento.setFecha(rs.getString("fecha"));  
                seguimiento.setEstado(rs.getString("estado")); 
                seguimiento.setArchivopdf2(rs.getBytes("documento"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return seguimiento;
    }
    
    @Override
    public List<Seguimiento> getByas(int id) throws Exception {
        List<Seguimiento> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seguimiento WHERE id_tramitador =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seguimiento>();
            while (rs.next()) {
                Seguimiento seguimiento = new Seguimiento();
                seguimiento.setId_seguimiento(rs.getInt("id_seguimiento"));
                seguimiento.setId_hoja(rs.getInt("id_hoja"));
                seguimiento.setId_usuario(rs.getInt("id_usuario"));
                seguimiento.setId_area(rs.getInt("id_area"));
                seguimiento.setId_tramitador(rs.getInt("id_tramitador"));
                seguimiento.setId_tipo(rs.getInt("id_tipo"));
                seguimiento.setObservaciones(rs.getString("observaciones"));
                seguimiento.setFecha(rs.getString("fecha"));  
                seguimiento.setEstado(rs.getString("estado")); 
                seguimiento.setArchivopdf2(rs.getBytes("documento"));
                lista.add(seguimiento);
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
    public List<Seguimiento> getByad(int id) throws Exception {
        List<Seguimiento> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seguimiento WHERE id_usuario =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seguimiento>();
            while (rs.next()) {
                Seguimiento seguimiento = new Seguimiento();
                seguimiento.setId_seguimiento(rs.getInt("id_seguimiento"));
                seguimiento.setId_hoja(rs.getInt("id_hoja"));
                seguimiento.setId_usuario(rs.getInt("id_usuario"));
                seguimiento.setId_area(rs.getInt("id_area"));
                seguimiento.setId_tramitador(rs.getInt("id_tramitador"));
                seguimiento.setId_tipo(rs.getInt("id_tipo"));
                seguimiento.setObservaciones(rs.getString("observaciones"));
                seguimiento.setFecha(rs.getString("fecha"));  
                seguimiento.setEstado(rs.getString("estado")); 
                seguimiento.setArchivopdf2(rs.getBytes("documento"));
                lista.add(seguimiento);
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
    public List<Seguimiento> getAll() throws Exception {
        List<Seguimiento> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seguimiento");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Seguimiento>();
            while (rs.next()) {
                Seguimiento seguimiento = new Seguimiento();
                seguimiento.setId_seguimiento(rs.getInt("id_seguimiento"));
                seguimiento.setId_hoja(rs.getInt("id_hoja"));
                seguimiento.setId_usuario(rs.getInt("id_usuario"));
                seguimiento.setId_area(rs.getInt("id_area"));
                seguimiento.setId_tramitador(rs.getInt("id_tramitador"));
                seguimiento.setId_tipo(rs.getInt("id_tipo"));
                seguimiento.setObservaciones(rs.getString("observaciones"));
                seguimiento.setFecha(rs.getString("fecha"));  
                seguimiento.setEstado(rs.getString("estado")); 
                seguimiento.setArchivopdf2(rs.getBytes("documento"));
                lista.add(seguimiento);
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
    public void insertar(Seguimiento seguimiento) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seguimiento(id_hoja, id_usuario, id_area, id_tramitador, id_tipo, observaciones, fecha, estado,documento) VALUES (?,?,?,?,?,?,?,?,?);");
            ps.setInt(1, seguimiento.getId_hoja());
            ps.setInt(2, seguimiento.getId_usuario());
            ps.setInt(3, seguimiento.getId_area());
            ps.setInt(4, seguimiento.getId_tramitador());
            ps.setInt(5, seguimiento.getId_tipo());
            ps.setString(6, seguimiento.getObservaciones());         
            ps.setString(7, seguimiento.getFecha());  
            ps.setString(8, seguimiento.getEstado());  
            ps.setBlob(9, seguimiento.getArchivopdf());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public void insertar2(Seguimiento seguimiento) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seguimiento(id_hoja, id_usuario, id_area, id_tramitador, id_tipo, observaciones, fecha, estado) VALUES (?,?,?,?,?,?,?,?);");
            ps.setInt(1, seguimiento.getId_hoja());
            ps.setInt(2, seguimiento.getId_usuario());
            ps.setInt(3, seguimiento.getId_area());
            ps.setInt(4, seguimiento.getId_tramitador());
            ps.setInt(5, seguimiento.getId_tipo());
            ps.setString(6, seguimiento.getObservaciones());         
            ps.setString(7, seguimiento.getFecha());  
            ps.setString(8, seguimiento.getEstado());  
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
