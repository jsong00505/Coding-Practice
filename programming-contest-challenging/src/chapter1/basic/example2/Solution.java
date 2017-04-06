package chapter1.basic.example2;

import java.io.PrintWriter;
import java.util.Arrays;
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
 * @challenge   Triangle
 */
public class Solution {
  static int getMaxLength(int n, int[] a) {
    return 0;
  }
  /**
   * Method Name: getMaxLength
   *
   * <p>TODO optimize below time complexity
   *
   * @time-complexity n^3
   * @param n the number of edges
   * @param a the array of length of the edges
   * @return the maximum length of triangle's perimeter
   */
  static int getMaxLengthByBruteForce(int n, int[] a) {
    // sorting an array first
    Arrays.sort(a);

    // init return value
    int max = 0;

    // do for loop for finding the maximum length
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if ((a[k] < a[i] + a[j]) && (max < a[i] + a[j] + a[k])) {
            max = a[i] + a[j] + a[k];
          }
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      int n = in.nextInt();

      assert (n >= 3 && n <= 100);

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();

        assert (a[i] >= 1 && a[i] <= 1000000);
      }

      out.println(getMaxLengthByBruteForce(n, a));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
