package chapter2.beginner.example5;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 05/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   DFS - SUBSET SUM Problem
 */
public class Solution {
  /**
   *
   * @param n a number of elements in an array
   * @param a an array to store data
   * @param k the sum should be matched with the one of the subsets in the array
   * @return 'Yes' if there is the one of the subset's sums matched with 'k'
   */
  static String getSubsetSumByDFS(int n, int[] a, int k) {
    long count = 1;

    // get the total number of combinations of the array 'a'
    for(int i = 0; i < n; i++) {
      count *= 2;
    }

    // search that there is the one matched with k
    for(int i = 0; i < count; i++) {
      long temp = i;
      int tempResult = 0;
      for(int j = 0; j < n; j++) {
        if(temp % 2 == 1) {
          tempResult += a[j];
        }

        temp /= 2;
      }

      if(tempResult == k) {
        return "Yes";
      }
    }
    return "No";
  }

  public static void main(String[] args) {
    try(
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
    ) {
      int n;    // a number of elements in an array
      int[] a;  // an array to store data
      int k;    // the sum should be matched with the one of the subsets in the array

      // user input
      n = in.nextInt();

      // validation
      assert(n >= 1 && n <= 20);

      // init an array 'a'
      a = new int[n];

      for(int i = 0; i < n; i++) {
        // user input
        a[i] = in.nextInt();

        // validation
        assert(a[i] >= -100000000 && a[i] <= 100000000);
      }

      // user input
      k = in.nextInt();

      // validation
      assert(k >= -100000000 && k <= 100000000);

      // get the result and print
      out.println(getSubsetSumByDFS(n, a, k));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
