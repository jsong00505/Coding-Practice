package bj301x.bj3015;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 19/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Reunion Oasis
 */
public class Main {
  /**
   * debugging method
   *
   * @param array
   */
  static void printArray(int[] array) {
    System.out.println("==========START=========");

    for (int ele : array) {
      System.out.print(ele + " ");
    }
    System.out.println();
    System.out.println("===========END==========");
  }

  /**
   * @param n
   * @param heights
   * @return a number of sets
   * @way-of-solve full-search
   */
  static int getNumberOfSets(int n, int[] heights) {
    // count a number of sets
    int count = 0;

    // temporary value for highest number in the given sub array
    int highest;

    // iterating
    for (int i = 0; i < n - 1; i++) {
      // set the highest number the next of current number
      highest = heights[i + 1];

      // the current number and next one can always see each
      count++;

      for (int j = i + 2; j < n; j++) {
        // if a current number is not higher than highest, just continue to count
        // but if the original one is not, just stop the iteration
        if (highest > heights[i]) {
          break;
        }

        if (highest > heights[j]) {
          continue;
        }

        // reset the highest value
        if (highest < heights[j]) {
          highest = heights[j];
        }

        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
         PrintWriter out = new PrintWriter(System.out);) {
      int n = in.nextInt();

      assert (n >= 1 && n <= 500000);

      int[] heights = new int[n];
      for (int i = 0; i < n; i++) {
        heights[i] = in.nextInt();
      }

      out.println(getNumberOfSets(n, heights));
    }
  }
}
