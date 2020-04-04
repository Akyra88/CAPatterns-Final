import java.util.List;
// this is my data access object.
public interface countryDao {
	
	Country findByCode(String code);
	Country findByName(String name);
	List <Country> findAll();	
	void create (Country country);
}
