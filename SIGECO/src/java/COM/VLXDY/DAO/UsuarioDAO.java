package COM.VLXDY.DAO;
import COM.VLXDY.MODELO.Usuario;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface UsuarioDAO {
    public void insert(Usuario usuario) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public void delete(int id) throws Exception;
    public List<Usuario> verificar_usuario(String us, String pas) throws Exception;
    public Usuario getById(int id) throws Exception;
    public boolean getByIdExist(int id) throws Exception;
    public List<Usuario> getAll() throws Exception;  
}
