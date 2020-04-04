// ENUM class to make sure all continents inserted
// matches the ones is the database.
public enum Continent {

	ASIA("Asia"), EUROPE("Europe"), NORTH_AMERICA("North America"), AFRICA("Africa"), OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"), SOUTH_AMERICA("South America");

	private String value;

	Continent(String value) {
		this.value = value;
	}

	public String getName() {
		return value;
	}
	
	public static Continent fromString(String text) {
        for (Continent continent : Continent.values()) {
            if (continent.getName().equalsIgnoreCase(text)) {
                return continent;
            }
        }
        return null;
    }

}
