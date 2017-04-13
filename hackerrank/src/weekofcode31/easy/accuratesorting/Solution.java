package weekofcode31.easy.accuratesorting;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 12/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Accurate Sorting
 */
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int q = in.nextInt();

      // constraints
      assert (q >= 1 && q <= 10);

      for (int i = 0; i < q; i++) {
        int n = in.nextInt();

        // constraints
        assert (n >= 1 && n <= 100000);

        // init
        int prior = in.nextInt();
        String result = "Yes";

        for (int j = 1; j < n; j++) {
          int curr = in.nextInt();

          // if not sorted
          if (prior > curr) {
            // only one difference will be accepted
            if (prior - curr == 1) {
              int temp = prior;
              prior = curr;
              curr = temp;
            } else {
              result = "No";
            } // if-else
          } // if
          prior = curr;
        } //for
        out.println(result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
