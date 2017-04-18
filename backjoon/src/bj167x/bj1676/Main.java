package bj167x.bj1676;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jsong on 30/03/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge The Number of Factorial 0
 */
public class Main {
  /**
   * Method Name: bruteForce
   *
   * @param n
   * @return a number of zeros of n!
   */
  static int bruteForce(int n) {
    // init how many twos and fives are in prime factorization
    HashMap<Integer, Integer> zeroMap = new HashMap<>();

    zeroMap.put(2, 0);
    zeroMap.put(5, 0);

    for (int i = 1; i <= n; i++) {
      // if i is dividable by 2
      if (i % 2 == 0) {
        // declare temp for prime factorization
        int temp = i;

        // get the number of two in HashMap for update
        int two = zeroMap.get(2);

        // update the number of two in HashMap
        while (temp % 2 == 0) {
          temp /= 2;
          two++;
        }
        zeroMap.put(2, two);
      }

      // if i is dividable by 5
      if (i % 5 == 0) {
        // declare temp for prime factorization
        int temp = i;

        // get the number of two in HashMap for update
        int five = zeroMap.get(5);

        // update the number of two in HashMap
        while (temp % 5 == 0) {
          temp /= 5;
          five++;
        }
        zeroMap.put(5, five);
      }
    }

    return zeroMap.get(2) > zeroMap.get(5) ? zeroMap.get(5) : zeroMap.get(2);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // get 'n' of 'n!'
      int n = in.nextInt();

      // constraints
      assert (n >= 0 && n <= 500);

      // print
      out.println(bruteForce(n));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
