package chapter2.beginner.example1;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 04/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Factorial
 */
public class Solution {
  static long getFactorialByForLoop(int n) {
    long result = 1;
    for (int i = n; i > 0; i--) {
      result *= i;
    }

    return result;
  }

  static long getFactorialByRecursive(int n) {
    if (n == 1) {
      return 1;
    }
    return n * getFactorialByRecursive(n - 1);
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      int n = in.nextInt();

      out.println(getFactorialByRecursive(n));
      out.println(getFactorialByForLoop(n));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
