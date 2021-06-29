package COM.VLXDY.MODELO;
import java.io.InputStream;

/**
 *
 * @author Vlxdy Hishikawa
 */
public class Seguimiento {
    private int id_seguimiento;
    private int id_hoja;	
    private int id_usuario;	
    private int id_area;
    private int id_tramitador;
    private int id_tipo;	
    private String observaciones;	
    private String fecha;
    private String estado;
    InputStream archivopdf;
    private byte[] archivopdf2;

    public Seguimiento() {
        this.id_seguimiento = 0;
        this.id_hoja = 0;
        this.id_usuario = 0;
        this.id_area = 0;
        this.id_tramitador = 0;
        this.id_tipo = 0;
        this.observaciones = "";
        this.fecha = "";
        this.estado = "";
    }

    public int getId_seguimiento() {
        return id_seguimiento;
    }

    public void setId_seguimiento(int id_seguimiento) {
        this.id_seguimiento = id_seguimiento;
    }

    public int getId_hoja() {
        return id_hoja;
    }

    public void setId_hoja(int id_hoja) {
        this.id_hoja = id_hoja;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
