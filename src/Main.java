import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choose;


		while (true) {

			// Main menu of the application
			System.out.println("\nMAIN SYSTEM\n");
			System.out.printf("%-5s%s\n", "1", "List all countries");
			System.out.printf("%-5s%s\n", "2", "Find country by country code");
			System.out.printf("%-5s%s\n", "3", "Find country by name");
			System.out.printf("%-5s%s\n", "4", "Save a new country");
			System.out.printf("\n%-5s%s\n", "e", "Exit");

			System.out.print("\nEnter selection: ");

			System.out.println();
			choose = sc.nextLine();

			if (choose.equals("1")) {
				
				System.out.println("All countries...");
				List<Country> countries = Service.findAll();
				
				for (Country country : countries) {
					//TODO BL: fazer os prints como quiser
					System.out.println(country);
				}
				
			}
			 	
			else if (choose.equals("2")) {
				
				System.out.println("Enter country code:");
				String code = sc.nextLine();
				Country country = Service.findByCode(code);
				System.out.println(country);
			} 
			
			else if(choose.equals("3")) {

				CountryDaoImp countryDaoImp = new CountryDaoImp();
				
				System.out.println("Enter country name:");
				String name = sc.nextLine();
				
				Country country = countryDaoImp.findByName(name);
				System.out.println(country);
				
			}
			else if (choose.equals("4")) {
				Country country = inputCountry(sc, true);
				Service.createCountry(country);
			} 
			else if (choose.equals("e")) {
				System.out.println("Exiting...");
				sc.close();
				break;
			} else {
				System.out.println("Unknown command");
			}

		}
	}

	private static Country inputCountry(Scanner sc, boolean b) {
		String code;
		String name;
		Continent continent;
		Double surfaceArea;
		String headOfState;

		System.out.print("Add code: ");
		code = String.valueOf(sc.nextLine());

		System.out.print("Name: ");
		name = sc.nextLine();

		System.out.print("Continent:");
		// TODO Validation case sensitivity!
		continent = Continent.valueOf(sc.nextLine().toUpperCase());

		System.out.print("Surface area: ");
		surfaceArea = Double.valueOf(sc.nextLine());

		System.out.print("Head of state: ");
		headOfState = sc.nextLine();

		Country country = new Country(code, name, continent, surfaceArea, headOfState);

		return country;
	}

}
