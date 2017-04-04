package chapter1.basic.example3;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 01/04/2017.
 * <p>
 * hackerrank	: https://www.hackerrank.com/jsong00505
 * github		: https://github.com/jsong00505
 * linkedin		: https://www.linkedin.com/in/junesongskorea/
 * email		: jsong00505@gmail.com
 * <p>
 * challenge	: Ants
 */
public class Solution {
	/**
	 * Method Name: getMaxTime
	 *
	 * @param l total length
	 * @param n a number of ants
	 * @param x an array of ants' position
	 * @return maximum time
	 */
	static int getMaxTime(int l, int n, int[] x) {
		int result;

		int first = x[0];
		int last = x[x.length - 1];

		if(l - first > last) {
			result = l - first;
		} else {
			result = last;
		}
		return result;
	}

	/**
	 * Method Name: getMinTime
	 *
	 * @param l total length
	 * @param n a number of ants
	 * @param x an array of ants' position
	 * @return minimum time
	 **/
	static int getMinTime(int l, int n, int[] x) {
		int result;
		int halfLength = l / 2;
		int beforeHalf = x[0];
		int afterHalf = x[0];

		for(int i = 0; i < n; i++) {
			if(x[i] >= halfLength) {
				afterHalf = x[i];
				break;
			} else {
				beforeHalf = x[i];
			}
		}

		if(halfLength - beforeHalf <= afterHalf - halfLength) {
			result = beforeHalf;
		} else {
			result = l - afterHalf;
		}

		return result;
	}
	public static void main(String[] args) {
		try(
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
		) {
			int l = in.nextInt();
			int n = in.nextInt();

			assert(l >= 1 && l <= 106);
			assert(n >= 1 && n <= 106);

			int[] x = new int[n];

			for(int i = 0; i < n; i++) {
				x[i] = in.nextInt();

				assert(x[i] >= 1 && x[i] <= l);
			}

			Arrays.sort(x);

			out.println(getMinTime(l, n, x));
			out.println(getMaxTime(l, n, x));
		} catch(Exception e) {

		}
	}
}
