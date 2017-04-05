package bj200x.bj2004;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jsong on 30/03/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   The Number of Zeros in Combinations
 *
 * @reference   http://blog.janmr.com/2010/10/prime-factors-of-factorial-numbers.html
 */
public class Main {
  /** how to calculate n combinations of m C(n, m) = n! / (m! (n - m)!) */

  /**
   * Method Name: euclidFirstTheorem
   *
   * @param n
   * @param m
   * @return a number of zeros by result n combinations of m
   */
  static int euclidFirstTheorem(int n, int m) {
    int two = 0;
    int five = 0;

    for (int i = 1; (n / (int) Math.pow(2, i)) > 0; i++) {
      int powTwo = (int) Math.pow(2, i);
      int powFive = (int) Math.pow(5, i);
      // n!
      two += n / powTwo;
      five += n / powFive;

      // m!
      two -= m / powTwo;
      five -= m / powFive;

      //(n - m)!
      two -= (n - m) / powTwo;
      five -= (n - m) / powFive;
    }
    return two > five ? five : two;
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      int n = in.nextInt();
      int m = in.nextInt();

      assert (m >= 0 && m >= (2 * Math.pow(10, 9)));
      assert (n >= m && m >= (2 * Math.pow(10, 9)));

      out.println(euclidFirstTheorem(n, m));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method Name: bruteForce
   *
   * @param n
   * @param m
   * @return
   */
  static int bruteForce(int n, int m) {
    // init how many twos, fives are in prime factorization
    HashMap<Integer, Integer> zeroMap = new HashMap<>();

    zeroMap.put(2, 0);
    zeroMap.put(5, 0);

    for (int i = 2; i <= n; i += 2) {
      // if i is dividable by 2
      if (i % 2 == 0) {
        // declare temp for prime factorization
        int temp = i;

        // get the number of two in HashMap for update
        int two = zeroMap.get(2);

        // update the number of two in HashMap
        while (temp % 2 == 0) {
          temp /= 2;

          // if m is bigger than i, should plus one to the number of two
          if (i > m) {
            two++;
          }

          // if 'n - m' is less than or equal i, should minus one to the number of two
          if (i <= (n - m)) {
            two--;
          }
        } // while
        zeroMap.put(2, two);
      } // if
    } // for

    for (int i = 5; i <= n; i += 5) {
      // if i is dividable by 5
      if (i % 5 == 0) {
        // declare temp for prime factorization
        int temp = i;

        // get the number of two in HashMap for update
        int five = zeroMap.get(5);

        // update the number of two in HashMap
        while (temp % 5 == 0) {
          temp /= 5;

          // if m is bigger than i, should plus one to the number of five
          if (i > m) {
            five++;
          }

          // if 'n - m' is less than or equal i, should minus one to the number of five
          if (i <= (n - m)) {
            five--;
          }
        } // while
        zeroMap.put(5, five);
      } // if
    }

    return zeroMap.get(2) > zeroMap.get(5) ? zeroMap.get(5) : zeroMap.get(2);
  }
}
