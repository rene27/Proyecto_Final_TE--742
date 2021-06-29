package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.HojaRuta;
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
public class HojaRutaDAOoperations extends ConexionDB implements  HojaRutaDAO {
    @Override
    public void insert(HojaRuta hojaRuta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO hoja_ruta(id_usuario, id_area, id_tramitador, id_tipo, descripcion, fecha_recepcion, documentos_adj) VALUES (?,?,?,?,?,?,?);");
            ps.setInt(1, hojaRuta.getId_usuario());
            ps.setInt(2, hojaRuta.getId_area());
            ps.setInt(3, hojaRuta.getId_tramitador());
            ps.setInt(4, hojaRuta.getId_tipo());
            ps.setString(5, hojaRuta.getDescripcion());         
            ps.setString(6, hojaRuta.getFecha_recepcion());           
            ps.setBlob(7, hojaRuta.getArchivopdf());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    public void in() throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seguimiento (id_hoja,id_usuario,id_area,id_tramitador,id_tipo,fecha,documento) SELECT id_hoja_ruta,id_usuario,id_area,id_tramitador,id_tipo,fecha_recepcion,documentos_adj FROM hoja_ruta WHERE id_hoja_ruta=(SELECT max(id_hoja_ruta) from hoja_ruta);");
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(HojaRuta hojaRuta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE hoja_ruta SET id_usuario=?, id_area=?, id_tramitador=?, id_tipo=?, descripcion=?, fecha_recepcion=?, documentos_adj=? WHERE id_hoja_ruta=?");
            ps.setInt(1, hojaRuta.getId_usuario());
            ps.setInt(2, hojaRuta.getId_area());
            ps.setInt(3, hojaRuta.getId_tramitador());
            ps.setInt(4, hojaRuta.getId_tipo());
            ps.setString(5, hojaRuta.getDescripcion());         
            ps.setString(6, hojaRuta.getFecha_recepcion());           
            ps.setBlob(7, hojaRuta.getArchivopdf());
            ps.setInt(8, hojaRuta.getId_hoja_ruta());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    @Override
    public void update2(HojaRuta hojaRuta) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE hoja_ruta SET id_usuario=?, id_area=?, id_tramitador=?, id_tipo=?, descripcion=?, fecha_recepcion=? WHERE id_hoja_ruta=?");
            ps.setInt(1, hojaRuta.getId_usuario());
            ps.setInt(2, hojaRuta.getId_area());
            ps.setInt(3, hojaRuta.getId_tramitador());
            ps.setInt(4, hojaRuta.getId_tipo());
            ps.setString(5, hojaRuta.getDescripcion());         
            ps.setString(6, hojaRuta.getFecha_recepcion());           
            ps.setInt(7, hojaRuta.getId_hoja_ruta());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM hoja_ruta WHERE id_hoja_ruta = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public HojaRuta getById(int id) throws Exception {
        HojaRuta hojaRuta = new HojaRuta();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM hoja_ruta where id_hoja_ruta=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hojaRuta.setId_hoja_ruta(rs.getInt("id_hoja_ruta"));
                hojaRuta.setId_usuario(rs.getInt("id_usuario"));
                hojaRuta.setId_area(rs.getInt("id_area"));
                hojaRuta.setId_tramitador(rs.getInt("id_tramitador"));
                hojaRuta.setId_tipo(rs.getInt("id_tipo"));
                hojaRuta.setDescripcion(rs.getString("descripcion"));
                hojaRuta.setFecha_recepcion(rs.getString("fecha_recepcion"));               
                hojaRuta.setArchivopdf2(rs.getBytes("documentos_adj"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return hojaRuta;
    }

    @Override
    public List<HojaRuta> getAll() throws Exception {
        List<HojaRuta> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM hoja_ruta");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<HojaRuta>();
            while (rs.next()) {
                HojaRuta hojaRuta = new HojaRuta();
                hojaRuta.setId_hoja_ruta(rs.getInt("id_hoja_ruta"));
                hojaRuta.setId_usuario(rs.getInt("id_usuario"));
                hojaRuta.setId_area(rs.getInt("id_area"));
                hojaRuta.setId_tramitador(rs.getInt("id_tramitador"));
                hojaRuta.setId_tipo(rs.getInt("id_tipo"));
                hojaRuta.setDescripcion(rs.getString("descripcion"));
                hojaRuta.setFecha_recepcion(rs.getString("fecha_recepcion"));               
                hojaRuta.setArchivopdf2(rs.getBytes("documentos_adj"));
                lista.add(hojaRuta);
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
    public List<HojaRuta> getByus(int id) throws Exception {
        List<HojaRuta> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM hoja_ruta where id_tramitador=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<HojaRuta>();
            while (rs.next()) {
                HojaRuta hojaRuta = new HojaRuta();
                hojaRuta.setId_hoja_ruta(rs.getInt("id_hoja_ruta"));
                hojaRuta.setId_usuario(rs.getInt("id_usuario"));
                hojaRuta.setId_area(rs.getInt("id_area"));
                hojaRuta.setId_tramitador(rs.getInt("id_tramitador"));
                hojaRuta.setId_tipo(rs.getInt("id_tipo"));
                hojaRuta.setDescripcion(rs.getString("descripcion"));
                hojaRuta.setFecha_recepcion(rs.getString("fecha_recepcion"));               
                hojaRuta.setArchivopdf2(rs.getBytes("documentos_adj"));
                lista.add(hojaRuta);
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
    public List<HojaRuta> getByad(int id) throws Exception {
        List<HojaRuta> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM hoja_ruta where id_usuario=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<HojaRuta>();
            while (rs.next()) {
                HojaRuta hojaRuta = new HojaRuta();
                hojaRuta.setId_hoja_ruta(rs.getInt("id_hoja_ruta"));
                hojaRuta.setId_usuario(rs.getInt("id_usuario"));
                hojaRuta.setId_area(rs.getInt("id_area"));
                hojaRuta.setId_tramitador(rs.getInt("id_tramitador"));
                hojaRuta.setId_tipo(rs.getInt("id_tipo"));
                hojaRuta.setDescripcion(rs.getString("descripcion"));
                hojaRuta.setFecha_recepcion(rs.getString("fecha_recepcion"));               
                hojaRuta.setArchivopdf2(rs.getBytes("documentos_adj"));
                lista.add(hojaRuta);
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
