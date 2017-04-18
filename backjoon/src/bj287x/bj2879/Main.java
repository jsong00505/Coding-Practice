package bj287x.bj2879;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 02/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Pretty Coding
 */
public class Main {
  static boolean hasSameSign(int x, int y) {
    if ((x > 0 && y > 0) || (x < 0 && y < 0) || (x == 0 && y == 0)) {
      return true;
    }

    return false;
  }

  /**
   * This method suppose that all elements in an array of difference has a same sign
   *
   * @param min
   * @param difference
   * @return
   */
  static int getMinNumberOfEditing(int n, LinkedList<Integer> difference, int min) {
    LinkedList<Integer> list = new LinkedList<>();
    int result = 0;
    int subMin = difference.get(0);

    if (n == 1) {
      return difference.get(0);
    }

    for (int i = 0; i < n; i++) {
      if (min == difference.get(i)) {
        if (list.size() > 0) {
          result += getMinNumberOfEditing(list.size(), list, subMin);
          list = new LinkedList<>();
        }
      } else {
        list.add(difference.get(i) - min);
        if (subMin > difference.get(i) - min) {
          subMin = difference.get(i) - min;
        }
      }

      if (i == n - 1 && list.size() > 0) {
        result += getMinNumberOfEditing(list.size(), list, subMin);
      }
    }

    result += min;

    return result;
  }

  static int resultController(int n, LinkedList<Integer> difference) {
    LinkedList<Integer> list = new LinkedList<>();
    int result = 0;
    int min = Math.abs(difference.get(0));
    list.add(Math.abs(difference.get(0)));

    for (int i = 1; i < n; i++) {

      if (hasSameSign(difference.get(i), difference.get(i - 1))) {
        if (min > Math.abs(difference.get(i))) {
          min = Math.abs(difference.get(i));
        }
      } else {
        result += getMinNumberOfEditing(list.size(), list, min);
        list = new LinkedList<>();
      }
      list.add(Math.abs(difference.get(i)));

      if (i == n - 1 && list.size() > 0) {
        result += getMinNumberOfEditing(list.size(), list, min);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();

      assert (n >= 1 && n <= 1000);

      int[] wrongIndent = new int[n];
      int[] rightIndent = new int[n];
      LinkedList<Integer> difference = new LinkedList<>();

      for (int i = 0; i < n; i++) {
        wrongIndent[i] = in.nextInt();

        assert (wrongIndent[i] >= 0 && wrongIndent[i] <= 80);
      }

      for (int i = 0; i < n; i++) {
        rightIndent[i] = in.nextInt();

        assert (rightIndent[i] >= 0 && rightIndent[i] <= 80);

        // calculate and save differences between right and wrong one
        difference.push(rightIndent[i] - wrongIndent[i]);
      }

      out.println(resultController(n, difference));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
