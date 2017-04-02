package bj993x.bj9935;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 02/04/2017.
 * <p>
 * hackerrank	: https://www.hackerrank.com/jsong00505
 * github		: https://github.com/jsong00505
 * linkedin		: https://www.linkedin.com/in/junesongskorea/
 * email		: jsong00505@gmail.com
 * <p>
 * challenge	: String Explosion
 */
public class Main {
	/**
	 * TODO optimize this function
	 * Method Name: launchBombByBruteForce
	 *
	 * over time limit
	 *
	 * @param sentence
	 * @param bomb
	 * @return a sentence after explosion
	 */
	static String launchBombByBruteForce(String sentence, String bomb) {
		while(sentence.contains(bomb)) {
			sentence = sentence.replace(bomb, "");
		}

		if(sentence.equals("")) {
			sentence = "FRULA";
		}
		return sentence;
	}

	public static void main(String[] args) {
		try(
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
		) {
			String sentence = in.nextLine();
			String bomb = in.nextLine();

			assert(sentence.length() >= 1 && sentence.length() <= 1000000);
			assert(bomb.length() >= 1 && bomb.length() <= 36);

			out.println(launchBombByBruteForce(sentence, bomb));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
