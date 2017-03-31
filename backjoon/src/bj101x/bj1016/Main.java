package bj101x.bj1016;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jsong on 30/03/2017.
 * <p>
 * hackerrank	: https://www.hackerrank.com/jsong00505
 * github		: https://github.com/jsong00505
 * linkedin		: https://www.linkedin.com/in/junesongskorea/
 * email		: jsong00505@gmail.com
 * <p>
 * challenge	: Squared nn Digit
 */
public class Main {
	/**
	 * Method Name: bruteForce
	 *
	 * over time limit(worst)
	 *
	 * bit calculation(?)
	 * array
	 *
	 * @param min
	 * @param max
	 * @return count
	 **/
	static long bruteForce(long min, long max) {
		// TODO : need to data type casting long to int
		long count = max - min + 1;

		HashMap<Long, Boolean> squaredMap = new HashMap<>();
		for(long i = min; i <= max; i++) {
			squaredMap.put(i, false);
		}

		for(long i = min; i <= max; i++) {
			if((Math.sqrt(i) == Math.round(Math.sqrt(i))) && i != 1 && !squaredMap.get(i)) {
				for(long j = 1; i * j <= max; j++) {
					squaredMap.put(i * j, true);
					count--;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		try(
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
		) {
			long min = in.nextLong();
			long max = in.nextLong();

			// constraints
			assert(min >= 1 && min <= Math.pow(10, 12));
			assert(max >= min && max <= (min + Math.pow(10, 6)));

			out.println(bruteForce(min, max));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
