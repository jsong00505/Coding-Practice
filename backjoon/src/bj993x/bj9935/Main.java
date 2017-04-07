package bj993x.bj9935;

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
 * @challenge   String Explosion
 *
 */
public class Main {
  /**
   *
   * @param sentence
   * @param bomb
   * @return
   */
  static String launchBomb(String sentence, String bomb) {
    LinkedList<Character> stack = new LinkedList<>();
    StringBuilder result = new StringBuilder("");
    int bombLastIndex = bomb.length() - 1;
    boolean bombFlag = true;

    for (int i = 0; i < sentence.length(); i++) {
      // get the size of the stack
      int stackSize = stack.size();
      if (sentence.charAt(i) == bomb.charAt(bombLastIndex) && stackSize >= bomb.length() - 1) {
        for (int j = 0; j < bomb.length() - 1; j++) {
          // if it is not same between, just escape the loop
          if (stack.get(stackSize - bombLastIndex + j) != bomb.charAt(j)) {
            bombFlag = false;
            continue;
          }
        } // for

        // if found a bomb string, just pop out
        if (bombFlag) {
          for(int j = 0; j < bomb.length() - 1; j++) {
            stack.removeLast();
          }
        } else {
          stack.add(sentence.charAt(i));
        } // if-else

        bombFlag = true;
      } else {
        stack.add(sentence.charAt(i));
      } // if-else
    } // for

    // make a result string
    for(char c: stack) {
      result.append(c);
    }

    // if result is empty, result will be 'FRULA'
    if(result.toString().equals("")) {
      result.append("FRULA");
    }

    return result.toString();
  }


  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
     ) {
      String sentence = in.nextLine();
      String bomb = in.nextLine();

      assert (sentence.length() >= 1 && sentence.length() <= 1000000);
      assert (bomb.length() >= 1 && bomb.length() <= 36);

      //out.println(launchBombByReplace(sentence, bomb));
      out.println(launchBomb(sentence, bomb));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method Name: launchBombByStack
   *
   * <p>still not good and I am not sure what point is better than the method using 'replace'
   * function
   *
   * @param sentence
   * @param bomb
   * @return
   */
  static String launchBombByBruteForce(String sentence, String bomb) {
    LinkedList<Character> stack = new LinkedList<>();
    StringBuilder result;
    StringBuilder temp = new StringBuilder();

    int bombIndex = 0;
    int sentenceIndex = 0;
    while (true) {
      char s = sentence.charAt(sentenceIndex);
      char b = bomb.charAt(bombIndex);

      if (s == b) {
        stack.add(s);

        if (bombIndex == bomb.length() - 1) {
          stack = new LinkedList<>();
          bombIndex = 0;
        } else {
          bombIndex++;
        } // if-else
      } else {
        if (stack.isEmpty()) {
          temp.append(s);
        } else {
          for (char c : stack) {
            temp.append(c);
          }

          stack = new LinkedList<>();
          bombIndex = 0;

          if (s == bomb.charAt(bombIndex)) {
            stack.add(s);
            bombIndex++;
          } else {
            temp.append(s);
          }
        } // if-else
      } // if-else

      sentenceIndex++;

      if (sentenceIndex == sentence.length()) {
        sentenceIndex = 0;
        if (!temp.toString().contains(bomb)) {
          result = temp;
          break;
        } else {
          sentence = temp.toString();
          temp = new StringBuilder();
          stack = new LinkedList<>();
          bombIndex = 0;
        } // if-else
      } // if
    } // while

    if (result.toString().equals("")) {
      result.append("FRULA");
    }
    return result.toString();
  }
  /**
   * Method Name: launchBombByReplace
   *
   * <p>over time limit
   *
   * @param sentence
   * @param bomb
   * @return a sentence after explosion
   */
  static String launchBombByReplace(String sentence, String bomb) {
    while (sentence.contains(bomb)) {
      sentence = sentence.replace(bomb, "");
    }

    if (sentence.equals("")) {
      sentence = "FRULA";
    }
    return sentence;
  }

  /**
   * Method Name: launchBombByReplace2
   *
   * <p>over time limit too
   *
   * @param sentence
   * @param bomb
   * @return
   */
  static String launchBombByReplace2(String sentence, String bomb) {
    StringBuilder result = new StringBuilder();
    int start = 0;

    while (sentence.contains(bomb)) {
      start = sentence.indexOf(bomb);
      sentence = sentence.replace(bomb, "");
      result.append(sentence.substring(0, start));
      sentence = sentence.substring(start);
    }

    result.append(sentence);

    if (result.toString().equals("")) {
      result.append("FRULA");
    }
    return result.toString();
  }
}
