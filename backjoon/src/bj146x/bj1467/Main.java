package bj146x.bj1467;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 18/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Remove Numbers
 */
class Node {
  private String number;
  private int index;

  Node(String number, int index) {
    this.number = number;
    this.index = index;
  }

  public String getNumber() {
    return number;
  }

  public int getIndex() {
    return index;
  }
}

public class Main {
  /**
   * get the biggest number after removal numbers
   *
   * because of full searching, over time limit
   *
   * @way-of-solution full-search
   * @param n
   * @param remover
   * @return the biggest number
   */
  static long getBiggestNumberAfterRemoval(String n, String remover) {
    LinkedList<Node> queue = new LinkedList<>();
    LinkedList<String> visited = new LinkedList<>();

    long result = -1;

    queue.add(new Node(n, -1));
    visited.add(n);

    while (!queue.isEmpty()) {
      Node temp = queue.removeFirst();
      String number = temp.getNumber();
      int index = temp.getIndex() + 1;

      // if remove all numbers, check if this number is the biggest one
      if (index == remover.length()) {
        if (Long.parseLong(number) > result) {
          result = Long.parseLong(number);
        }

        continue;
      }

      for (int i = 0; i < number.length(); i++) {
        char r = remover.charAt(index);

        if (r == number.charAt(i)) {
          // concatenation sub strings
          StringBuilder sb = new StringBuilder();
          sb.append(number.substring(0, i)).append(number.substring(i + 1));

          // optimization
          if (!visited.contains(sb.toString())) {
            queue.add(new Node(sb.toString(), index));
            visited.add(sb.toString());
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      String n = in.nextLine();
      String remover = in.nextLine();

      // validation
      assert (Integer.parseInt(n) >= 1 && Integer.parseInt(n) <= 1000);
      assert (n.length() >= remover.length());

      // print
      out.print(getBiggestNumberAfterRemoval(n, remover));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
