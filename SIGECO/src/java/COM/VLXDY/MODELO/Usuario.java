package COM.VLXDY.MODELO;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class Usuario {
    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ci;
    private String email;
    private int cargo;
    private String usuario;
    private String contrasena;

    public Usuario() {
        this.nombres = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.ci = 0;
        this.cargo = 0;
        this.email = "";
        this.usuario = "";
        this.contrasena = "";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", ci=" + ci + ", email=" + email + ", usuario=" + usuario + ", contrasena=" + contrasena + ", cargo=" + cargo + '}';
    }
    
}
