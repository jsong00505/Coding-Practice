package bj174x.bj1740;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 30/03/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Power of N
 */
public class Main {
  /**
   * Method Name: findNthNumbers
   *
   * @param n a 'n'th position
   * @return a number at 'n'th position
   */
  static long findNthNumbers(long n) {
    long result = 0;

    // the flag checking if the element is the last order
    boolean isLast = false;

    long t = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        result += t;
      }

      n = n >> 1;
      t *= 3;
    }

    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // get n
      long n = in.nextLong();

      // validation
      assert (n >= 1 && n <= (5 * Math.pow(10, 11)));

      out.println(findNthNumbers(n));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
