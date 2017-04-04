package chapter2.beginner.example2;

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
 * @challenge   Fibonacci
 */
public class Solution {
  static int[] memo;

  /**
   * Method Name: getFibonacciByArray
   *
   * @param n
   * @return
   */
  static long getFibonacciByArray(int n) {
    long result;
    if (n <= 1) {
      result = n;
    } else if (memo[n] != 0) {
      result = memo[n];
    } else {
      result = getFibonacciByArray(n - 1) + getFibonacciByArray(n - 2);
    }

    return result;
  }

  /**
   * Method Name: getFibonacciByForLoop
   *
   * @param n
   * @return
   */
  static long getFibonacciByForLoop(int n) {
    long a0 = 0;
    long a1 = 1;
    long result = -1;

    if (n == 0) {
      result = a0;
    } else if (n == 1) {
      result = a1;
    } else {
      for (int i = 2; i <= n; i++) {
        result = a0 + a1;

        a0 = a1;
        a1 = result;
      }
    }

    return result;
  }

  /**
   * Method Name: getFibonacciByRecursive
   *
   * @param n
   * @return
   */
  static long getFibonacciByRecursive(int n) {
    long result;
    if (n == 1) {
      result = 1;
    } else if (n == 0) {
      result = 0;
    } else {
      result = getFibonacciByRecursive(n - 1) + getFibonacciByRecursive(n - 2);
    }

    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();

      out.println(getFibonacciByRecursive(n));
      out.println(getFibonacciByForLoop(n));

      memo = new int[n + 1];
      out.println(getFibonacciByArray(n));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
