
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// The implementation of my DAO (data access object) class.
public class CountryDaoImp implements countryDao {

	// connection to database
	/* I have created two connections because i noticed that some people
	 * were messing up the database provided
	 * and it were causing me trouble when accessing it. 
	*/
	// String HOST = "52.50.23.197";
	String dbServer = "jdbc:mysql://52.50.23.197/world?useTimezone=true&serverTimezone=UTC";
	private final String user = "cctstudent";
	private final String password = "Pass1234!";
	Connection connection;

	public CountryDaoImp() {

		// every time we instantiate this class it will create a new connection to the
		// database
		try {
			// Remote connection which is the database provided.
			// create a connection with teh database
			connection = DriverManager.getConnection(dbServer, user, password);

			// Local which is used in my local machine 
			// for the sake of the project.
			// connection = DriverManager.getConnection(dbServer, "root", "");
		} catch (SQLException e) {
			// if try and catch finds any error print message.
			System.out.println("connection error");
			e.printStackTrace();
		}
	}

	// this is a simple method to search country
	// by code using a QUERY VARIABLE
	@Override
	public Country findByCode(String code) {

		Country country = null;
		try {
			
			// SQL select query + code, to search by code
			String query = "select * from country where Code = '" + code +"'";
			// create a statement
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				Continent continent = Continent.fromString(rs.getString("continent"));
				Double surfaceArea = rs.getDouble("surfaceArea");
				String headOfState = rs.getString("headOfState");

				country = new Country(code, name, continent, surfaceArea, headOfState);
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return country;
	}
	
	// this is a simple method to search country
	// by name using a QUERY VARIABLE
	@Override
	public Country findByName(String name) {
		Country country = null;

		try {
			// SQL select query + name, to search by name
			String query = "select * from country where name ='" + name + "'";
			// create a statement.
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String code = rs.getString("Code");
				Continent continent = Continent.fromString(rs.getString("continent"));
				Double surfaceArea = rs.getDouble("surfaceArea");
				String headOfState = rs.getString("headOfState");

				country = new Country(code, name, continent, surfaceArea, headOfState);
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return country;
	}

	// this is a simple method to printout 
	// all countries using a QUERY VARIABLE.
	@Override
	public List<Country> findAll() {
		
		List<Country> countries = new ArrayList<Country>();

		try {
			// SQL select all from table country
			String query = "select * from country";
			Statement stmt = connection.createStatement();
			// create a statement.
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String continentString = rs.getString("continent");
				
				if (continentString.trim() == "" || continentString.isEmpty()) {
					// I have a validation for some of fields continent are empty 
					// and were giving me errors
					System.out.println("Unknow Continent: " + rs.getString("continent"));
					continue;
				}

				String code = rs.getString("Code");
				String name = rs.getString("name");
				Continent continent = Continent.fromString(rs.getString("continent"));
				Double surfaceArea = rs.getDouble("surfaceArea");
				String headOfState = rs.getString("headOfState");


				Country country = new Country(code, name, continent, surfaceArea, headOfState);

				countries.add(country);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return countries;
	}

	// simple method to save a new country
	// using a QUERY VARIABLE	
	@Override
	public void create(Country country) {
		// SQL query insert into table country, to add a new country.
		String query = "insert INTO country (code, name, continent, surfaceArea, headOfState)"
				+ "values (?, ?, ?, ?, ? )";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, country.getCode());
			preparedStmt.setString(2, country.getName());
			preparedStmt.setString(3, country.getContinent().getName());
			preparedStmt.setDouble(4, country.getSurfaceArea());
			preparedStmt.setString(5, country.getHeadOfState());

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
