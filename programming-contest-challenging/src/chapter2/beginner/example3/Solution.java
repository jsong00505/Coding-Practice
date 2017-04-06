package chapter2.beginner.example3;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jsong on 04/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Stack
 */
public class Solution {
  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      Stack<Integer> stack = new Stack<>(); // {}
      stack.push(1); // {1}
      stack.push(2); // {1, 2}
      stack.push(3); // {1, 2, 3}
      out.println(stack.peek());
      stack.pop(); // {1, 2}
      out.println(stack.peek());
      stack.pop(); // {1}
      out.println(stack.peek());
      stack.pop(); // {}
    } catch (Exception e) {

    }
  }
}
