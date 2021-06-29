package COM.VLXDY.MODELO;
import java.io.InputStream;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class HojaRuta {
    private int id_hoja_ruta;	
    private int id_usuario;	
    private int id_area;
    private int id_tramitador;
    private int id_tipo;	
    private String descripcion;	
    private String fecha_recepcion;	
    InputStream archivopdf;
    private byte[] archivopdf2;

    public HojaRuta() {
        this.id_hoja_ruta = 0;
        this.id_usuario = 0;
        this.id_area = 0;
        this.id_tramitador = 0;
        this.id_tipo = 0;
        this.descripcion = descripcion;
    }

    public int getId_hoja_ruta() {
        return id_hoja_ruta;
    }

    public void setId_hoja_ruta(int id_hoja_ruta) {
        this.id_hoja_ruta = id_hoja_ruta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_tramitador() {
        return id_tramitador;
    }

    public void setId_tramitador(int id_tramitador) {
        this.id_tramitador = id_tramitador;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }    
}
