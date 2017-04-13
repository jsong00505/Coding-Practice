package weekofcode31.easy.beautifulword;

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
 * @challenge Beautiful Word
 */
public class Solution {
  static char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

  static boolean isVowel(char c) {
    for (char v : vowels) {
      if (v == c) {
        return true;
      }
    }

    return false;
  }

  static String isBeautifulWord(String w) {
    String result = "Yes";

    // init
    char priorChar = w.charAt(0);

    for (int i = 1; i < w.length(); i++) {
      char currChar = w.charAt(i);
      if (priorChar == currChar) {
        result = "No";
        break;
      } else if (isVowel(priorChar) && isVowel(currChar)) {
        result = "No";
        break;
      }
      priorChar = currChar;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      String w = in.nextLine();

      //constraints
      assert (w.length() >= 1 && w.length() <= 100);

      out.println(isBeautifulWord(w.toLowerCase()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
