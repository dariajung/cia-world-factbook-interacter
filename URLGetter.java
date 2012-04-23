import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;

/**
 * A class to get the contents of any webpage
 * 
 * @author Daria Jung (modified from Swap's example code)
 * 
 */
public class URLGetter {

	private Scanner reader;
	private URL url;
	private HttpURLConnection httpConnection;
	private Country country;
	private ArrayList<Country> allCountries, blacklist;
	private ArrayList<String> contents;

	/**
	 * The constructor - it will create the URL and HttpURLConnection objects
	 * and open the connection to the main CIA World Factbook page.
	 * 
	 * @param url
	 *            The URL of the webpage
	 */
	public URLGetter(String url) {
		contents = new ArrayList<String>();
		allCountries = new ArrayList<Country>();

		try {
			this.url = new URL(url);

			URLConnection connection = this.url.openConnection();
			httpConnection = (HttpURLConnection) connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getBlacklist();
		getContents();
		getInfo();
	}

	/**
	 * This method will get the contents of the page. It will create an
	 * arraylist of each line as a String object.
	 * 
	 * @return the arraylist of each line
	 */
	public ArrayList<String> getContents() {
		if (!contents.isEmpty())
			return contents;
		contents = new ArrayList<String>();
		try {
			Scanner in = new Scanner(httpConnection.getInputStream());
			while (in.hasNextLine()) {
				String line = in.nextLine();
				contents.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}

	/**
	 * Gets the URL of each country by using a regex as well as the country's
	 * name.
	 * 
	 * @return the info containing the URL and name of each country in an
	 *         ArrayList of type Country.
	 */
	public ArrayList<Country> getInfo() {
		String url, countryName;
		Pattern name = Pattern
				.compile("<li><a href=\"(\\w{2}.html)\">(.*)</a></li>");
		for (String line : contents) {
			Matcher nameMatcher = name.matcher(line);
			if (nameMatcher.find()) {
				url = nameMatcher.group(1);
				url = "https://www.cia.gov/library/publications/the-world-factbook/geos/countrytemplate_"
						+ url;
				countryName = nameMatcher.group(2);
				country = new Country(countryName, url);
				allCountries.add(country);
			}
		}
		return allCountries;
	}

	// removes non-real countries
	/**
	 * Removes blacklisted entries (territories, dependencies, etc.) from the
	 * ArrayList of countries.
	 * 
	 * @return the countries
	 */
	public ArrayList<Country> getCountries() {
		for (Country country : blacklist) {
			allCountries.remove(country);
		}

		return allCountries;
	}

	// This is a blacklist of territories and non-country entries in the
	// Factbook
	public ArrayList<Country> getBlacklist() {
		String[] notCountries = { "Akrotiri", "American Samoa", "Anguilla",
				"Antarctica", "Arctic Ocean", "Aruba",
				"Ashmore and Cartier Islands", "Atlantic Ocean",
				"Baker Island", "Bermuda", "Bouvet Island",
				"British Indian Ocean Territory", "British Virgin Islands",
				"Cayman Islands", "Christmas Island", "Clipperton Island",
				"Cocos (Keeling) Islands", "Cook Islands", "Coral Sea Islands",
				"Curacao", "Dhekelia", "European Union",
				"Falkland Islands (Islas Malvinas)", "Faroe Islands",
				"French Polynesia", "French Southern and Antarctic Lands",
				"Gaza Strip", "Gibraltar", "Greenland", "Guam", "Guernsey",
				"Heard Island and McDonald Islands", "Holy See (Vatican City)",
				"Hong Kong", "Howland Island", "Indian Ocean", "Isle of Man",
				"Jan Mayen", "Jarvis Island", "Jersey", "Johnston Atoll",
				"Kingman Reef", "Macau", "Midway Islands", "Montserrat",
				"Navassa Island", "New Caledonia", "Niue", "Norfolk Island",
				"Northern Mariana Islands", "Pacific Ocean", "Palmyra Atoll",
				"Paracel Islands", "Pitcairn Islands", "Puerto Rico",
				"Saint Barthelemy",
				"Saint Helena, Ascension, and Tristan da Cunha",
				"Saint Martin", "Saint Pierre and Miquelon", "Sint Maarten",
				"South Georgia and South Sandwich Islands", "Southern Ocean",
				"Spratly Islands", "Svalbard", "Tokelau",
				"Turks and Caicos Islands",
				"United States Pacific Island Wildlife Refuges",
				"Virgin Islands", "Wake Island", "Wallis and Futuna",
				"West Bank", "Western Sahara", "World" };

		blacklist = new ArrayList<Country>();
		for (String notCountry : notCountries) {
			blacklist.add(new Country(notCountry, null));
		}
		return blacklist;
	}

}
