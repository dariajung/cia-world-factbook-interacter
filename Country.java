
/**
 * The Class Country.
 */
public class Country {

	/** The URL and the country's name. */
	private String countryName, URL;

	/**
	 * Instantiates a new country.
	 *
	 * @param n the n
	 * @param u the u
	 */
	public Country(String n, String u) {
		countryName = n;
		URL = u;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return countryName;
	}

	/**
	 * Gets the URL.
	 *
	 * @return the URL
	 */
	public String getURL() {
		return URL;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (other instanceof Country) {
			Country that = (Country) other;
			return this.countryName.equals(that.countryName);
		} else {
			return false;
		}
	}
}
