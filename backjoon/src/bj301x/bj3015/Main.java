package bj301x.bj3015;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 19/04/2017.
 *
 * Reunion Oasis
 */
public class Main {

  static int getNumberOfSets(int[] heights) {

    int count = 0;
    while (heights[count + 1] > heights[count]) {
      count++;
      if (count >= heights.length - 1) {
        break;
      }
    }

    int diff = heights.length - count - 1;
    if (diff < 1) {
      return count;
    } else if (diff == 1) {
      return count + 1;
    }

    int index = count;
    int prior = heights[index + 1];
    for (int i = count + 2; i < heights.length; i++) {
      int current = heights[i];
      if (current < prior) {
        count += i - index;
        count += getNumberOfSets(Arrays.copyOfRange(heights, index + 1, i - index + count + 1));
        index = i;
      }
      prior = current;
    }
    count += heights.length - 1 - index;
    return count;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      int n = in.nextInt();

      assert (n >= 1 && n <= 500000);

      int[] heights = new int[n];
      for (int i = 0; i < n; i++) {
        heights[i] = in.nextInt();
      }

      out.println(getNumberOfSets(heights));
    }
  }
}
