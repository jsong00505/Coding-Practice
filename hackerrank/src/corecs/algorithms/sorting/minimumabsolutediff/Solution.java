package corecs.algorithms.sorting.minimumabsolutediff;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 04/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Minimum Absolute Difference in an Array
 */
public class Solution {

  /**
   * greedy algorithm
   *
   * @param a
   * @return min
   */
  static int greedyAlgorithm(int[] a) {
    // init
    int min = Math.abs(a[1] - a[0]);
    int n = a.length;

    // sort
    Arrays.sort(a);

    // find minimum absolute difference
    for (int i = 1; i < n; i++) {
      if (min > Math.abs(a[i] - a[i - 1])) {
        min = Math.abs(a[i] - a[i - 1]);
      }
    }

    return min;
  }
  /**
   * brute-force(failed to pass the challenge)
   *
   * @param a
   * @return min
   */
  static int bruteForce(int[] a) {
    // init
    int min = Math.abs(a[1] - a[0]);
    int n = a.length;

    // find minimum absolute difference
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        // compare difference with min
        if (min > Math.abs(a[j] - a[i])) {
          min = Math.abs(a[j] - a[i]);
        }
      }
    }

    return min;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      // initialize and declare the number of integers
      int n = in.nextInt();

      // validation
      assert (1 < n && n <= 100000);

      // initialize an array of the integers
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        // set a integer
        a[i] = in.nextInt();

        // validation
        assert (-1000000000 <= n && n <= 1000000000);
      }

      // print
      out.println(greedyAlgorithm(a));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
