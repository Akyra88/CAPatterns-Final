import java.util.List;
// this is my data access object.
public interface countryDao {
	// parameters returning code and name
	Country findByCode(String code);
	Country findByName(String name);
	// simple returning the array list 
	List <Country> findAll();	
	void create (Country country);
}
