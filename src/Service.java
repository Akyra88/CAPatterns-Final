import java.util.List;
// The service class is my Singleton
public class Service {
	
	// private reference to itself
	private static CountryDaoImp countryDaoImp = new CountryDaoImp();
	
	/**
	 * @param code
	 * @return
	 */
	
	public static Country findByCode(String code) {
		return countryDaoImp.findByCode(code);
	}
	
	/**
	 * @param name
	 * @return
	 */
	public static Country findByName(String name) {
		return countryDaoImp.findByName(name);
	}
	
	/**
	 * @param country
	 */
	public static void createCountry(Country country) {
		countryDaoImp.create(country);
		
	}

	/**
	 * @return
	 */
	public static List<Country> findAll() {
		return countryDaoImp.findAll();
		
	}
}
