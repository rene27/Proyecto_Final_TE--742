package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.TipoDoc;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TipoDocDAO {
    public void insert(TipoDoc tipoDoc) throws Exception;
    public void update(TipoDoc tipoDoc) throws Exception;
    public void delete(int id) throws Exception;
    public TipoDoc getById(int id) throws Exception;
    public List<TipoDoc> getAll() throws Exception;
}
