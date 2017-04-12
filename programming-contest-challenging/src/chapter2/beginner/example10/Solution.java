package chapter2.beginner.example10;

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
 * @challenge Best Cow Line(POJ 3617)
 */
public class Solution {
  /**
   * get a best cow line
   *
   * @param s
   * @return a best cow line
   */
  static char[] getBestCowLine(String s) {
    char[] t = new char[s.length()];
    int start = 0;
    int end = s.length() - 1;

    for (int i = 0; i < t.length; i++) {
      if(s.charAt(start) < s.charAt(end)) {
        t[i] = s.charAt(start++);
      } else {
        t[i] = s.charAt(end--);
      }
    }

    return t;
  }

  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);) {
      int n = in.nextInt();

      // constraints
      assert(n >= 1 && n <= 2000);

      String s = in.next();

      // constraints
      assert(n == s.length());

      // print
      out.println(getBestCowLine(s));
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
