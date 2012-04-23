import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Prompter Class. It has 10 methods for each of the 10 questions
 */
public class Prompter extends JFrame {

	/** The input. */
	private Scanner input;

	/** The full text. */
	private String fullText;

	/** The u. */
	private URLGetter u;

	/** The countries. */
	private ArrayList<Country> countries;

	/** The content. */
	private ArrayList<String> content;

	/** The country text. */
	private ArrayList<Text> countryText;

	private JTextArea answerText;

	/**
	 * Instantiates a new prompter.
	 */
	public Prompter() {
		fullText = "";
		countries = new ArrayList<Country>();
		content = new ArrayList<String>();
		countryText = new ArrayList<Text>();
		u = new URLGetter(
				"https://www.cia.gov/library/publications/the-world-factbook/print/textversion.html");
		countries = u.getCountries();
		input = new Scanner(System.in);
		initText();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(575, 500);
		setVisible(true);

	}

	public void initGUI() {
		JPanel mainPanel = (JPanel) getContentPane();
		mainPanel.setLayout(new GridLayout(0, 2));
		mainPanel.add(getButtonPanel());
		mainPanel.add(getAnswerSummaryPane());
		mainPanel.setSize(575, 500);
		pack();
		validate();
	}

	public JScrollPane getButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 1));

		JButton button1 = new JButton(
				"List all countries in South America that are prone to earthquakes");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question1();
				answerText.setText(question1());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button1);

		JButton button2 = new JButton(
				"Find the country with the lowest elevation point in Europe");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question2();
				answerText.setText(question2());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button2);

		JButton button3 = new JButton(
				"List all countries in the Southeastern (SE) hemisphere");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question3();
				answerText.setText(question3());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button3);

		JButton button4 = new JButton(
				"List all countries in Asia with more than 10 political parties");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question4();
				answerText.setText(question4());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button4);

		JButton button5 = new JButton(
				"List all countries with blue in their flag");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question5();
				answerText.setText(question5());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button5);

		JButton button6 = new JButton("<html>" + "Find the top 5 countries with the highest electricity consumption per capita - This question takes a few minutes" + "</html>");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question6();
				answerText.setText(question6());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button6);

		JButton button7 = new JButton(
				"Find all countries landlocked by only one country");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question7();
				answerText.setText(question7());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button7);

		JButton button8 = new JButton("<html>" +
				"Find the maximum number of capital cities Swap and his friend can visit in a 10 by 10 degree square" + "</html>");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question8();
				answerText.setText(question8());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button8);

		JButton button9 = new JButton(
				"List the countries that grant universal suffrage at 20");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question9();
				answerText.setText(question9());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button9);

		JButton button10 = new JButton(
				"List the countries whose unemployment rate is below 5%");
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//question10();
				answerText.setText(question10());
				// call repaint to redraw itself
				// need it for animation type programs, too
				repaint();
			}

		});

		buttonPanel.add(button10);

		JScrollPane buttonPane = new JScrollPane(buttonPanel);
		buttonPane.setBorder(BorderFactory.createTitledBorder("Questions!"));
		return buttonPane;

	}

	public JScrollPane getAnswerSummaryPane() {

		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new GridLayout(0, 1));
		answerText = new JTextArea();
		answerText.setLineWrap(true);
		answerText.setWrapStyleWord(true);
		answerText.setText("");
		answerText.setEditable(false);
		orderPanel.add(answerText);

		JScrollPane orderPane = new JScrollPane(orderPanel);
		orderPane.setBorder(BorderFactory
				.createTitledBorder("The answer to your query!"));
		return orderPane;

	}

	/**
	 * Question1.
	 */
	public String question1() {
		String answer = "";
		String continent = "South America";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: List all countries in ___________ that are prone to ___________");
		// System.out.println("Please enter a continent: ");
		// String continent = input.nextLine();
		String hazard = "earthquake";
		// System.out.println("The answers are...");
		for (Text a : countryText) {
			fullText = a.getAllText();
			Pattern contin = Pattern.compile("#FFFFFF;\">(.*)</a>"
					.toUpperCase());
			Matcher contMatcher = contin.matcher(fullText.toUpperCase());
			Pattern haz = Pattern.compile(hazard.toUpperCase());
			Matcher hazMatcher = haz.matcher(fullText.toUpperCase());
			if (contMatcher.find() && hazMatcher.find()) {
				String continentName = contMatcher.group(1);
				if (continentName.toUpperCase().equals(continent.toUpperCase())) {
					answer = answer + a.getName() + "\n";
					// System.out.println(a.getName());
				}
			}
		}
		// System.out.println(answer);
		return answer;
	}

	/**
	 * Question2.
	 */
	public String question2() {
		String answer = "";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: Find the country with the lowest elevation point in ______");
		// System.out.println("Please enter a continent: ");
		String continent = "europe".toUpperCase();
		// System.out.println("The answer is...");
		double lowest = 0;
		String lowestCountry = "";
		for (Text a : countryText) {
			fullText = a.getAllText();
			Pattern contin = Pattern.compile("#FFFFFF;\">(.*)</a>"
					.toUpperCase());
			Matcher contMatcher = contin.matcher(fullText.toUpperCase());
			Pattern elevation = Pattern
				.compile("lowest point: <span class=\"category_data\" style=\"font-weight:normal; vertical-align:bottom;\">(.*) (.*) m</span></div>"
						.toUpperCase());
			Matcher eleMatcher = elevation.matcher(fullText.toUpperCase());
			if (contMatcher.find() && eleMatcher.find()) {
				String continentName = contMatcher.group(1);
				String elev = eleMatcher.group(2);
				// System.out.println(a.getName());
				elev = elev.replaceAll("[^.^\\d^-]", "");
				double e = Double.parseDouble(elev);
				// System.out.println(e);
				if (continentName.toUpperCase().equals(continent.toUpperCase())
						&& (e < lowest)) {
					lowest = e;
					lowestCountry = a.getName();
					// System.out.println("As of now: " + lowestCountry);
					// System.out.println("As of now Elevation: " + lowest);
					answer = lowestCountry + ": " + lowest;
				}
			}
		}

		// System.out.println(lowestCountry + ": " + lowest);
		//answer = (lowestCountry + ": " + lowest);
		return answer;
	}

	/**
	 * Question3.
	 */
	public String question3() {
		String answer = "";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: List all countries in the __ hemisphere");
		// System.out.println("North or South? Type N or S");
		String ns = "S".toUpperCase();
		// System.out.println("East or West? Type E or W");
		String ew = "E".toUpperCase();
		System.out.println("The answer is...");
		for (Text a : countryText) {
			fullText = a.getAllText();
			Pattern hemisphere = Pattern
					.compile("<div class=\"category_data\">(\\d*)(\\s)(\\d*)(\\s)(\\w{1}), "
							+ "(\\d*)(\\s)(\\d*)(\\s)(\\w{1})</div>");
			Matcher hemiMatcher = hemisphere.matcher(fullText);
			if (hemiMatcher.find()) {
				boolean print = ns.equals(hemiMatcher.group(5))
						&& ew.equals(hemiMatcher.group(10));
				if (print == true) {
					answer = answer + a.getName() + "\n";
					// System.out.println(a.getName());
					print = false;
				}
			}
		}
		return answer;
	}

	/**
	 * Question4.
	 */
	public String question4() {
		String answer = "";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: List all countries in ____ with more than __ political parties");
		// System.out.println("Enter a continent: ");
		String continent = "Asia".toUpperCase();
		// System.out.println("Enter a positive integer: ");
		int poliCount = 10;
		System.out.println("The answer is...");
		for (Text a : countryText) {
			fullText = a.getAllText();
			Pattern contin = Pattern.compile("#FFFFFF;\">(.*)</a>"
					.toUpperCase());
			Matcher contMatcher = contin.matcher(fullText.toUpperCase());
			Pattern politics = Pattern
					.compile("<div class=\"category_data\">(.*) \\[(.*)\\]; (.*)</div>");
			Matcher poliMatcher = politics.matcher(fullText);
			if (poliMatcher.find() && contMatcher.find()) {
				String poli = poliMatcher.group(1) + " ["
						+ poliMatcher.group(2) + "]; " + poliMatcher.group(3);
				int count = poli.split(";", -1).length;
				// System.out.println(count);
				// This check accounts for the Middle East as being a part
				// of the
				// Asian continent for the purpose of answering this
				// question
				if (continent.equals("ASIA")) {
					if (count > poliCount
							&& (contMatcher.group(1).contains("ASIA") || contMatcher
									.group(1).contains("MIDDLE EAST"))) {
						// System.out.println(a.getName());
						answer = answer + a.getName() + "\n";
					}
				} else if (count > poliCount
						&& (contMatcher.group(1).contains(continent))) {
					// System.out.println(a.getName());
					answer = answer + a.getName() + "\n";
				}
			}
		}
		return answer;
	}

	/**
	 * Question5.
	 */
	public String question5() {
		String answer = "";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: List all countries with (color) in their flag");
		// System.out.println("Enter a color: ");
		String color = "blue";
		// System.out.println("The answer is...");
		for (Text a : countryText) {
			fullText = a.getAllText();

			String noSpaces = fullText.replaceAll("\\s+", " ");
			Pattern flag = Pattern
					.compile("Flag description</a>: </div></td> </tr> <tr height=\"22\"> <td colspan=\"2\" id=\"data\"> "
							+ "<div class=\"category_data\">(.*)\"Definitions and Notes: National symbol");
			Matcher flagMatcher = flag.matcher(noSpaces);
			if (flagMatcher.find()) {
				String flagDes = flagMatcher.group(1);
				if (flagDes.contains(" " + color + " ")) {
					// System.out.println(a.getName());
					answer = answer + a.getName() + "\n";
				}
			}
		}
		return answer;
	}

	/**
	 * Question6.
	 */
	public String question6() {
		String answer = "";
		// input = new Scanner(System.in);
		// System.out
		// .println("The question is: Find the top (#) countries with the highest electricity consumption per capita");
		// System.out.println("Please enter an integer");
		int number = 5;
		System.out.println("This will take about a minute.");
		ArrayList<String> eCountryName = new ArrayList<String>();
		ArrayList<Double> unsorted = new ArrayList<Double>();
		ArrayList<Double> sorted = new ArrayList<Double>();
		for (Text a : countryText) {
			fullText = a.getAllText();
			String noSpaces = fullText.replaceAll("\\s+", " ");
			Pattern elect = Pattern
					.compile("Electricity - consumption</a>: </div></td> </tr> <tr height=\"22\"> "
							+ "<td colspan=\"2\" id=\"data\"> <div class=\"category_data\">(.*) kWh(.*)</div>(.*)"
							+ "\"Definitions and Notes: "
							+ "Electricity - exports");
			Matcher electMatcher = elect.matcher(noSpaces);
			Pattern pop = Pattern
					.compile("Population</a>: </div></td> </tr> <tr height=\"22\"> <td colspan=\"2\" "
							+ "id=\"data\"> <div class=\"category_data\">(.*)\\((.*) est.\\)(.*)>country");
			Matcher popMatcher = pop.matcher(noSpaces);
			if (electMatcher.find() && popMatcher.find()) {
				String electricity = electMatcher.group(1);
				String[] elecTokens = electricity.split(" ");
				double consumption = 0;
				if (elecTokens[0].equals("NA")) {
					consumption = 0;
				} else
					consumption = Double.parseDouble(elecTokens[0]);
				if (elecTokens[1].toUpperCase().equals("TRILLION")) {
					consumption = consumption * (1000000000); // the number is
					// scaled down
					// by 1000
				}
				if (elecTokens[1].toUpperCase().equals("BILLION")) {
					consumption = consumption * (1000000); // the number is
					// scaled down by
					// 1000
				}
				if (elecTokens[1].toUpperCase().equals("MILLION")) {
					consumption = consumption * (1000); // the number is scaled
					// down by 1000
				}

				String population = popMatcher.group(1);
				String[] popTokens = population.split(" ");
				String p = popTokens[0];
				p = p.replaceAll("[^0-9]", "");
				double pp = Double.parseDouble(p);
				// System.out.println(consumption);
				// System.out.println(pp);

				// System.out
				// .println("electricity per capita (scaled down by 1000) "
				// + a.getName() + ": " + consumption / pp);
				sorted.add(consumption / pp);
				unsorted.add(consumption / pp);
				eCountryName.add(a.getName());
			}
		}

		System.out.println("The answer is...");
		Collections.sort(sorted);
		int i = sorted.size() - 1;
		while (i >= sorted.size() - number) {
			double toMatch = sorted.get(i);
			int index = unsorted.indexOf(toMatch);
			// System.out.println(index);
			System.out.println(eCountryName.get(index));
			answer = answer + eCountryName.get(index) + "\n";
			i--;
		}
		return answer;

	}

	/**
	 * Question7.
	 */
	public String question7() {
		String answer = "";
		// System.out
		// .println("The question is: Find all countries landlocked by only one country");
		// System.out.println("The answer is...." + "\n");
		for (Text a : countryText) {
			fullText = a.getAllText();
			String noSpaces = fullText.replaceAll("\\s+", " ");
			Pattern landlocked = Pattern.compile("landlocked");
			Matcher lockedMatcher = landlocked.matcher(noSpaces);
			Pattern borderCountries = Pattern
					.compile("border countries: <span class=\"category_data\" style=\"font-weight:normal; "
							+ "vertical-align:top;\">(.*)km</span></div>(.*)\"Definitions and Notes: Coastline\"");
			Matcher borderMatcher = borderCountries.matcher(noSpaces);
			if (lockedMatcher.find() && borderMatcher.find()) {
				String border = borderMatcher.group(1);
				int count = border.split(",", -1).length;
				System.out.println(count);
				if (count == 1) {
					// System.out.println(a.getName()
					// + " IS LANDLOCKED BY ONE COUNTRY. WHOOHOO!");
					answer = answer + a.getName() + "\n";
				}
			}
		}
		return answer;
	}

	/**
	 * Question8.
	 */
	public String question8() {
		String answer = "";
		ArrayList<Capital> capitals = new ArrayList<Capital>();
		// System.out
		// .println("\n"
		// +
		// "Find the maximum number of capital cities Swap and his friend can visit in a 10 by 10 degree square");
		// System.out.println("Finding coordinates and information for capitals."
		// + "\n");
		ArrayList<Text> noNauru = countryText;
		// Removing Nauru because it does not have an offical capital city.
		noNauru.remove(122); // Nauru is index 122.
		// System.out.println(noNauru.size());
		for (Text a : noNauru) {
			fullText = a.getAllText();

			Pattern capitalCoor = Pattern
					.compile("vertical-align:top;\">(\\d*)(\\s)(\\d*)(\\s)(\\w{1})(.*) "
							+ "(\\d*)(\\s)(\\d*)(\\s)(\\w{1})</span></div>");

			Pattern capitalName = Pattern
					.compile("<div class=\"category\">name: <span class=\"category_data\" style=\"font-weight:normal; "
							+ "vertical-align:bottom;\">(.*)</span></div>");

			Matcher capitalCoorMatcher = capitalCoor.matcher(fullText);
			Matcher capitalNameMatcher = capitalName.matcher(fullText);

			if (capitalNameMatcher.find() && capitalCoorMatcher.find()) {
				String capName = capitalNameMatcher.group(1);
				String lat = capitalCoorMatcher.group(1) + "."
						+ capitalCoorMatcher.group(3);
				String lon = capitalCoorMatcher.group(7) + "."
						+ capitalCoorMatcher.group(9);
				double latitude = Double.parseDouble(lat);
				double longitude = Double.parseDouble(lon);
				if (capitalCoorMatcher.group(5).equals("N")) {
					latitude = latitude + 90;
				}
				if (capitalCoorMatcher.group(11).equals("E")) {
					longitude = longitude + 180;
				}

				Capital yayCap = new Capital(latitude, longitude, capName
						+ ", " + a.getName());
				capitals.add(yayCap);
			}

		}

		Collections.sort(capitals);

		for (Capital c : capitals) {
			// System.out.println(c.getCountry());
			System.out.println(c.getCapital());
		}

		// System.out.println("Size of noNauru: " + noNauru.size());
		// System.out.println("Size of capitals: " + capitals.size());

		String[][] globe = new String[capitals.size() + 1][capitals.size() + 1];

		// System.out.println("globe length: " + globe.length);

		for (int i = 1; i < globe.length; i++) {
			globe[i][0] = capitals.get(i - 1).getLatitude() + ", "
					+ capitals.get(i - 1).getLongitude() + ": "
					+ capitals.get(i - 1).getCapital();
			// System.out.println(globe[i][0]);
		}

		for (int j = 1; j < globe.length; j++) {
			globe[0][j] = capitals.get(j - 1).getLatitude() + ", "
					+ capitals.get(j - 1).getLongitude() + ": "
					+ capitals.get(j - 1).getCapital();
			// System.out.println(globe[0][j]);
		}

		double latDiff = 0;
		double lonDiff = 0;
		for (int i = 1; i < globe.length; i++) {
			for (int j = 1; j < globe.length; j++) {
				latDiff = Math.abs(capitals.get(i - 1).getLatitude()
						- capitals.get(j - 1).getLatitude());
				lonDiff = Math.abs(capitals.get(i - 1).getLongitude()
						- capitals.get(j - 1).getLongitude());
				if (latDiff < 5 && lonDiff < 5) { // magic: do not touch
					globe[i][j] = "Yes";

				} else {
					globe[i][j] = "Nope";
				}
				// System.out.println(latDiff + " " + lonDiff);
			}
		}

		// for (int i = 1; i < globe.length; i++) {
		// for (int j = 1; j < 6; j++) {
		// System.out.print(globe[i][j] + " ");
		// }
		// System.out.print("\n");
		// }
		// System.out.print("\n");

		int count = 0;
		ArrayList<Integer> counts = new ArrayList<Integer>();
		for (int i = 1; i < globe.length; i++) {
			for (int j = 1; j < globe.length; j++) {
				if (globe[i][j] == "Yes") {
					count++;
				}
			}
			counts.add(count);
			// System.out.println(count);
			count = 0;
		}

		int maxValue = Collections.max(counts);
		// System.out.println("This is the max: " + Collections.max(counts));

		int maxRow = counts.indexOf(maxValue) + 1;
		// System.out.println("First index of max: " +
		// counts.indexOf(maxValue));

		for (int i = 1; i < globe.length; i++) {
			if (globe[maxRow][i] == "Yes") {
				answer = answer + globe[i][0] + "\n";
				System.out.println(globe[i][0]);
			}
		}
		return answer;
	}

	/**
	 * Question9.
	 */
	public String question9() {
		String answer = "";
		// System.out
		// .println("The question is: List the countries that grant universal suffrage at (age)");
		// input = new Scanner(System.in);
		// System.out.println("Please enter an integer to represent an age");
		int voteAge = 20;
		for (Text a : countryText) {
			fullText = a.getAllText();
			String noSpaces = fullText.replaceAll("\\s+", " ");
			Pattern suffrage = Pattern
					.compile("Suffrage</a>: </div></td> </tr> <tr height=\"22\"> <td colspan=\"2\" "
							+ "id=\"data\"> <div class=\"category_data\">(.*) years of age; universal</div>");
			Matcher suffrageMatcher = suffrage.matcher(noSpaces);

			if (suffrageMatcher.find()) {
				int age = Integer.parseInt(suffrageMatcher.group(1));
				if (voteAge == age) {
					// System.out.println("Yay");
					// System.out.println(a.getName());
					answer = answer + a.getName() + "\n";
				}
			}
		}
		return answer;
	}

	/**
	 * Question10.
	 */
	public String question10() {
		String answer = "";
		// System.out
		// .println("The question is: List the countries whose unemployment rate is below (percentage)");
		// input = new Scanner(System.in);
		// System.out.println("Please enter a percentage (ie: 5.0% or 5.0)");
		String p = "5%";
		p = p.replaceAll("[%]", " ");
		double inputPercent = Double.parseDouble(p);
		for (Text a : countryText) {
			fullText = a.getAllText();
			String noSpaces = fullText.replaceAll("\\s+", " ");
			Pattern unemployment = Pattern
					.compile("Unemployment rate</a>: </div></td> </tr> <tr height=\"22\"> <td colspan=\"2\" "
							+ "id=\"data\"> <div class=\"category_data\">(.*)%(.*)</div>");
			Matcher unemployMatcher = unemployment.matcher(noSpaces);
			if (unemployMatcher.find()) {
				String unempText = unemployMatcher.group(1);
				String[] unemploy = unempText.split(" ");
				String percent = unemploy[0];
				percent = percent.replaceAll("[%]", "");
				// This handles countries that do not have any sort of
				// unemployment listed (instead of 0%) by making the percent
				// exceed what is possible.
				if (percent.contains("NA")) {
					percent = "110";
				}
				double perc = Double.parseDouble(percent);
				if (perc < inputPercent) {
					// System.out.println(a.getName());
					answer = answer + a.getName() + "\n";
					// System.out.println(perc);
				}
			}
		}
		return answer;
	}

	/**
	 * Inits the text for each country by storing the String containing the HTML
	 * into a Text object.
	 */
	public void initText() {
		for (Country c : countries) {
		//for (int i = 0; i < 50; i++) {
			//content = HTMLtoText(countries.get(i).getURL());
		    content = HTMLtoText(c.getURL());
			for (String l : content) {
				fullText += l + "\n";
			}
			//Text t = new Text(countries.get(i).getName(), fullText);
			Text t = new Text(c.getName(), fullText);
			countryText.add(t);
			System.out.println("Gathering information from: " + t.getName());
			// System.out.println(t.getName());
			fullText = "";
		}
	}

	/**
	 * HTML to text.
	 * 
	 * @param u
	 *            us is the String that represents the URL of a country.
	 * 
	 * @return the array list content which is an arraylist of every line of
	 *         HTML for the country.
	 */
	public ArrayList<String> HTMLtoText(String u) {
		URLGetter getter = new URLGetter(u);
		ArrayList<String> content = getter.getContents();
		return content;
	}

}
