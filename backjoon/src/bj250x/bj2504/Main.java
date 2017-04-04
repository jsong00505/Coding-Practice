package bj250x.bj2504;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 01/04/2017.
 * <p>
 * hackerrank	: https://www.hackerrank.com/jsong00505
 * github		: https://github.com/jsong00505
 * linkedin		: https://www.linkedin.com/in/junesongskorea/
 * email		: jsong00505@gmail.com
 * <p>
 * challenge	: The Price of Brackets
 */
public class Main {
	// brackets
	static char OPEN_ROUND = '(';
	static char OPEN_SQUARE = '[';
	static char CLOSE_ROUND = ')';
	static char CLOSE_SQUARE = ']';

	static long calculatePrice(String line) {
		LinkedList<Character> stack = new LinkedList<>();
		int round = 0;
		int square = 0;
		char firstChar;
		long result = 0;

		if (line.length() <= 0) {
			result = 0;
		} else {
			firstChar = line.charAt(0);
			if(firstChar != OPEN_ROUND && firstChar != OPEN_SQUARE) {
				result = 0;
			} else {
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if(c == OPEN_ROUND) {
						round++;
					} else if(c == OPEN_SQUARE) {
						square++;
					} else if(c == CLOSE_ROUND) {
						round--;
					} else if(c == CLOSE_SQUARE) {
						square--;
					} else {
						result = 0;
						break;
					}

					if(round == 0 && c == CLOSE_ROUND && firstChar == OPEN_ROUND) {
						if(i == 1) {
							result = 2 + calculatePrice(line.substring(2));
						} else {
							result = 2 * calculatePrice(line.substring(1, i)) + calculatePrice(line.substring(i + 1));
						}
						break;
					} else if(square == 0 && c == CLOSE_SQUARE && firstChar == OPEN_SQUARE) {
						if(i == 1) {
							result = 3 + calculatePrice(line.substring(2));
						} else {
							result = 3 * calculatePrice(line.substring(1, i)) + calculatePrice(line.substring(i + 1));
						}
						break;
					}
				}
			}
		}

		return result;
	}
	public static void main(String[] args) {
		try(
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
		) {
			String line = in.nextLine();

			// validation
			assert(line.length() >= 1 && line.length() <= 30);

			out.println(calculatePrice(line));

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
