package bj539x.bj5397;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 02/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Key Logger
 */
public class Main {
  // commands
  static char RIGHT_MOVE = '>';
  static char LEFT_MOVE = '<';
  static char REMOVE = '-';

  /**
   * Method Name: findPassword
   *
   * @param l a invalid password including commands
   * @return a valid password
   */
  static String findPassword(String l) {
    LinkedList<Character> linkedList = new LinkedList<>();
    StringBuilder result = new StringBuilder();

    int position = 0;

    for (char c : l.toCharArray()) {
      if (c != RIGHT_MOVE && c != LEFT_MOVE && c != REMOVE) {
        linkedList.add(position, c);
        position++;
      } else if (c == RIGHT_MOVE && position < linkedList.size()) {
        position++;
      } else if (c == LEFT_MOVE && position > 0) {
        position--;
      } else if (c == REMOVE && linkedList.size() > 0 && position != 0) {
        linkedList.remove(position - 1);
        position--;
      }
    }

    // LinkedList to String
    for (char c : linkedList) {
      result.append(c);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();
      in.nextLine();
      for (int i = 0; i < n; i++) {
        String l = in.nextLine();

        assert (l.length() >= 1 && l.length() <= 1000000);

        out.println(findPassword(l));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
