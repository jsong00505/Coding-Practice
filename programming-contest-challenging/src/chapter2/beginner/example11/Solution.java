package chapter2.beginner.example11;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 12/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Saruman's Army
 */
public class Solution {
  /**
   * get a minimum spots where Saruman's army is
   *
   * @return a minimum spots
   */
  static int getMinSpotsSarumansArmy(int n, int r, int[] x) {
    int spots = 0;

    int startSpot = x[0];
    int markedSpot = x[0];
    for (int i = 0; i < x.length; i++) {
      if (spots == 0) {
        if (x[i] - startSpot <= r) {
          markedSpot = x[i];
        } else {
          startSpot = markedSpot;
          spots++;
        } // if-else
      } else {
        if (x[i] - startSpot <= 2 * r) {
          markedSpot = x[i];
          if (i == x.length - 1) {
            spots++;
          }
        } else {
          startSpot = markedSpot;
          spots++;
        } // if-else
      }
    }
    return spots;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();
      int r = in.nextInt();

      // constraints
      assert (n >= 1 && n <= 1000 && r >= 0 && r <= 1000);

      int[] x = new int[n];

      for (int i = 0; i < n; i++) {
        x[i] = in.nextInt();

        // constraints
        assert (x[i] >= 0 && x[i] <= 1000);
      }

      // sort an array using Arrays class
      Arrays.sort(x);

      out.println(getMinSpotsSarumansArmy(n, r, x));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
