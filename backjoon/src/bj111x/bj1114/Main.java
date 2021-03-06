package bj111x.bj1114;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jsong on 20/02/2018.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Cut Log
 */
public class Main {

  // define as a global in the class since I don't want to use this repeatedly for API
  private static int l;
  private static int k;
  private static int c;
  private static List<Integer> POSITIONS;

  // final result
  private static int LONGEST_CUT;
  private static int FIRST_CUT_POSITION;

  /**
   * Validate if can cut.
   *
   * @param middle A middle of length
   * @return {@link true} if possible or {@link false} if not.
   */
  private static boolean canCut(int middle) {
    int cutLength = 0;
    int cutCount = 0;
    for (int i = 1; i <= k + 1; i++) {
      int diff = POSITIONS.get(i) - POSITIONS.get(i - 1);
      cutLength += diff;
      if (cutLength > middle) {
        cutCount++;
        cutLength = diff;
        if (cutLength > middle) {
          return false;
        }
      }
    }
    return cutCount <= c;
  }

  /**
   * Find the very first cut position and then set the value.
   */
  private static void setFirstCut() {
    int count = 0;
    int sum = 0;
    for (int i = k; i >= 0; i--) {
      int diff = POSITIONS.get(i + 1) - POSITIONS.get(i);
      sum += diff;
      if (sum > LONGEST_CUT) {
        count++;
        FIRST_CUT_POSITION = POSITIONS.get(i + 1);
        sum = diff;
      }
    }
    // if count is over c the very first cut position can be the first position in the POSITION
    if (count < c) {
      FIRST_CUT_POSITION = POSITIONS.get(1);
    }
  }

  /**
   * Validate if the supplied length is the less longest length and then set.
   *
   * @param cutLog the longest value from the {@code canCut} processing
   */
  private static void setLessLongestCut(int cutLog) {
    if (LONGEST_CUT == 0) {
      LONGEST_CUT = cutLog;
    }
    if (LONGEST_CUT > cutLog) {
      LONGEST_CUT = cutLog;
    }
  }

  private static void cutLog() {
    int left = 0;
    int right = POSITIONS.get(POSITIONS.size() - 1);
    while (left <= right) {
      int middle = (left + right) / 2;
      if (canCut(middle)) {
        right = middle - 1;
        setLessLongestCut(middle);
      } else {
        left = middle + 1;
      }
    }
    setFirstCut();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      l = in.nextInt();
      k = in.nextInt();
      c = in.nextInt();

      assert (l > 0 && l < 1000000000);
      assert (k > 0 && k < 10000);
      assert (c > 0 && c < 10000);

      // set the positions from 0 to l
      POSITIONS = new ArrayList<>();
      POSITIONS.add(0);
      for (int i = 1; i <= k; i++) {
        int position = in.nextInt();
        assert (position > l);
        POSITIONS.add(position);
      }
      POSITIONS.add(l);

      LONGEST_CUT = 0;
      FIRST_CUT_POSITION = l;
      // sort
      Collections.sort(POSITIONS);

      // call the API to retrieve the best answer
      cutLog();

      out.println(LONGEST_CUT + " " + FIRST_CUT_POSITION);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
