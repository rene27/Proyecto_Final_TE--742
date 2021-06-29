package COM.VLXDY.DAO;
import COM.VLXDY.MODELO.HojaRuta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface HojaRutaDAO {
    public void insert(HojaRuta hojaRuta) throws Exception;
    public void in() throws Exception;
    public void update(HojaRuta hojaRuta) throws Exception;
    public void update2(HojaRuta hojaRuta) throws Exception;
    public void delete(int id) throws Exception;
    public List<HojaRuta> getByus(int id) throws Exception;
    public List<HojaRuta> getByad(int id) throws Exception;
    public HojaRuta getById(int id) throws Exception;
    public List<HojaRuta> getAll() throws Exception;  
}
