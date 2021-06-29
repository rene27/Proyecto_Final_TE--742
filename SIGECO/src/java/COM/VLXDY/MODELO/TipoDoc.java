package COM.VLXDY.MODELO;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class TipoDoc {
    private int id_tipo;
    private String nombre_doc;

    public TipoDoc() {
        this.id_tipo = 0;
        this.nombre_doc = "";
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_doc() {
        return nombre_doc;
    }

    public void setNombre_doc(String nombre_doc) {
        this.nombre_doc = nombre_doc;
    }
    
    @Override
    public String toString() {
        return "Tipo_Doc{" + "id_tipo=" + id_tipo + ", nombre_doc=" + nombre_doc + '}';
    }
}
