/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.Area;
import COM.VLXDY.UTILES.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AreaDAOoperations extends ConexionDB implements AreaDAO{

    @Override
    public void insert(Area area) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO areas(nombre_area) VALUES (?)");
            ps.setString(1, area.getNombre_area());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Area area) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE areas SET nombre_area=? WHERE id_area=?");
            ps.setString(1, area.getNombre_area());
            ps.setInt(2, area.getId_area());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM areas WHERE id_area= ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Area getById(int id) throws Exception {
        Area objeto = new Area();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM areas where id_area=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                objeto.setId_area(rs.getInt("id_area"));
                objeto.setNombre_area(rs.getString("nombre_area"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return objeto;
    }

    @Override
    public List<Area> getAll() throws Exception {
        List<Area> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM areas");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Area>();
            while (rs.next()) {
                Area objeto = new Area();
                objeto.setId_area(rs.getInt("id_area"));
                objeto.setNombre_area(rs.getString("nombre_area"));
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

