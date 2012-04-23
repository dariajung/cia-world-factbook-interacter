
/**
 * The Class Text.
 */
public class Text {

	/** The all info. */
	private String allInfo;
	
	/** The country name. */
	private String countryName;
	
	/**
	 * Instantiates a new text.
	 *
	 * @param c the c
	 * @param a the a
	 */
	public Text(String c, String a){
		countryName = c;
		allInfo = a;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return countryName;
	}
	
	/**
	 * Gets the all text.
	 *
	 * @return the all text
	 */
	public String getAllText(){
		return allInfo;
	}
}
