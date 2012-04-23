// TODO: Auto-generated Javadoc
/**
 * The Class Capital.
 */
public class Capital implements Comparable<Capital> {

	/** The capital name. */
	private String capitalName;
	
	/** The longitude. */
	private double latitude, longitude;

	/**
	 * Instantiates a new capital.
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @param c the c
	 */
	public Capital(double lat, double lon, String c) {
		capitalName = c;
		latitude = lat;
		longitude = lon;
	}

	/**
	 * Gets the capital.
	 *
	 * @return the capital
	 */
	public String getCapital() {
		return capitalName;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Capital other) {

		if (other.getLatitude() < this.latitude)
			return 1;
		if (other.getLatitude() == this.latitude)
			return 0;
		if (other.getLatitude() > this.latitude)
			return -1;

		return 6;

	}

}
