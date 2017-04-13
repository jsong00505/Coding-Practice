package weekofcode31.medium.zeroonegame;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 12/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Zero-One Game
 */
public class Solution {
  static String ALICE = "Alice";
  static String BOB = "Bob";

  static void print(LinkedList<Integer> list, boolean turn) {
    for (int i : list) {
      System.out.print(i + " ");
    }
    System.out.print(turn);
    System.out.println();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int g = in.nextInt();

      // constraints
      //assert (g >= 1 && g <= 1000);

      for (int i = 0; i < g; i++) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = in.nextInt();

        // constraints
        //assert (n >= 1 && n <= 10000);

        // init
        boolean aliceTurn = true;

        if (n >= 2) {
          stack.add(in.nextInt());
          stack.add(in.nextInt());
        } else if (n == 1) {
          stack.add(in.nextInt());
        } // if-else

        for (int j = 2; j < n; j++) {
          int element = in.nextInt();

          if (element == 0) {
            while (stack.size() >= 2) {
              if (stack.get(stack.size() - 2) == 0) {
                stack.removeLast();
                aliceTurn = aliceTurn ? false : true;
              } else {
                break;
              } // if-else
            } // while
          } // if

          stack.add(element);
          //print(stack, aliceTurn);
        } // for
        out.println(aliceTurn ? BOB : ALICE);
      } //for

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
