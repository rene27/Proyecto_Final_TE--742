package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.UserTipo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UserTipoDAO {
    public void insert(UserTipo userTipo) throws Exception;
    public void update(UserTipo userTipo) throws Exception;
    public void delete(int id) throws Exception;
    public UserTipo getById(int id) throws Exception;
    public List<UserTipo> getAll() throws Exception;
}
