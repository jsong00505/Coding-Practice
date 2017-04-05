package chapter2.beginner.example4;

import java.io.PrintWriter;
import java.util.LinkedList;
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
 * @challenge   Queue
 */
public class Solution {
  public static void main(String[] args) {
    try(
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      LinkedList<Integer> queue = new LinkedList<>();	// {}
      queue.push(1);									// {1}
      queue.push(2);									// {1, 2}
      queue.push(3);									// {1, 2, 3}
      out.println(queue.getFirst());
      queue.removeFirst();								// remove the first data in the queue {1, 2, 3} -> {2, 3}
      out.println(queue.getFirst());
      queue.removeFirst();								// {3}
      out.println(queue.getFirst());
      queue.removeFirst();								// {}
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
