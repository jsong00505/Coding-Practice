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
		long count = 0;

		HashMap<Long, Boolean> squaredMap = new HashMap<>();
		for(long i = min; i <= max; i++) {
			squaredMap.put(i, true);
		}

		// start from squared of 2 until squared number is not over max
		for(long i = 2; i * i <= max; i++) {
			long powerI = i * i;
			long start = 0;

			if(min % powerI == 0) {
				start = (min / powerI) * powerI;
			} else if(((min / powerI) + 1) * powerI <= max){
				start = ((min / powerI) + 1) * powerI;
			} else {
				continue;
			}

			if(squaredMap.get(start)) {
				for(long j = start; j <= max; j += powerI) {
					squaredMap.put(j, false);
				}
			}
		}

		for(long index: squaredMap.keySet()) {

			if(squaredMap.get(index)) {
				count++;
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
			assert(min >= 1 && min <= Math.pow(10, 12) && max >= min && max <= (min + Math.pow(10, 6)));

			out.println(bruteForce(min, max));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}