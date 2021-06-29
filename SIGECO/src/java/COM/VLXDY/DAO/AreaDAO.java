package COM.VLXDY.DAO;

import COM.VLXDY.MODELO.Area;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface AreaDAO {
    public void insert(Area area) throws Exception;
    public void update(Area area) throws Exception;
    public void delete(int id) throws Exception;
    public Area getById(int id) throws Exception;
    public List<Area> getAll() throws Exception;
}
