package chapter1.basic.example1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 01/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Draw Lots
 */
public class Solution {
  /**
   * Method Name: isPossibleByBruteForce
   *
   * <p>TODO optimize below time complexity
   *
   * @time-complexty n^4
   * @param n
   * @param m
   * @param k
   * @return
   */
  static String isPossibleByBruteForce(int n, int m, int[] k) {
    // init result
    String result = "No";

    // quadruple loop
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int x = 0; x < n; x++) {
          for (int y = 0; y < n; y++) {
            int temp = k[i] + k[j] + k[x] + k[y];
            if (temp == m) {
              result = "Yes";
            }
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      int n = in.nextInt();
      int m = in.nextInt();

      // validation
      assert (n >= 1 && n <= 50);
      assert (m >= 1 && m <= 100000000);

      int[] k = new int[n];
      for (int i = 0; i < n; i++) {
        k[i] = in.nextInt();

        // validation
        assert (k[i] >= 1 && k[i] <= 100000000);
      }

      // print
      out.println(isPossibleByBruteForce(n, m, k));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
