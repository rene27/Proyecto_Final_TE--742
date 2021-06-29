package COM.VLXDY.DAO;
import COM.VLXDY.MODELO.Seguimiento;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface SeguimientoDAO {
    public void insert(Seguimiento seguimiento) throws Exception;
    public void update(Seguimiento seguimiento) throws Exception;
    public void update2(Seguimiento seguimiento) throws Exception;
    public void insertar(Seguimiento seguimiento) throws Exception;
    public void insertar2(Seguimiento seguimiento) throws Exception;
    public void delete(int id) throws Exception;
    public Seguimiento getById(int id) throws Exception;
    public List<Seguimiento> getByas(int id) throws Exception;
    public List<Seguimiento> getByad(int id) throws Exception;
    public List<Seguimiento> getAll() throws Exception;  
}
