public class Country {

	private String code;
	private String name;
	private Continent continent;
	private Double surfaceArea;
	private String headOfState;

	/**
	 * @param code
	 * @param name
	 * @param continent
	 * @param surfaceArea
	 * @param headOfState
	 */
	public Country(String code, String name, Continent continent, Double surfaceArea, String headOfState) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the continent
	 */
	public Continent getContinent() {
		return continent;
	}

	/**
	 * @param continent the continent to set
	 */
	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	/**
	 * @return the surfaceArea
	 */
	public double getSurfaceArea() {
		return surfaceArea;
	}

	/**
	 * @param surfaceArea the surfaceArea to set
	 */
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	/**
	 * @return the headOfState
	 */
	public String getHeadOfState() {
		return headOfState;
	}

	/**
	 * @param headOfState the headOfState to set
	 */
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
	// this is to make sure i can print it
	// without problems.
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", surfaceArea=" + surfaceArea
				+ ", headOfState=" + headOfState + "]";
	}

	
}
