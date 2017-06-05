package test.openbet.part3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jsong on 04/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge
 */
public class Solution {
  static String acronym(String[] input) {
    // result
    StringBuilder result = new StringBuilder();
    boolean wasCapital = true;
    boolean appended = false;
    for (int i = 0; i < input.length; i++) {
      // get word from input array
      String word = input[i];

      if (wasCapital || Character.isUpperCase(word.charAt(0))) {
        // this one is for adding dot(.)
        if (i != 0) {
          result.append(".");
          // append first letter to result
          result.append(Character.toUpperCase(word.charAt(0)));
        } else {
          // append first letter to result
          result.append(Character.toUpperCase(word.charAt(0)));
        }

        appended = true;
      }

      if(Character.isUpperCase(word.charAt(0))) {
        wasCapital = true;
      } else {
        wasCapital = false;
      }

      for (int j = 1; j < word.length(); j++) {
        if(appended && j == 1) {
          continue;
        }
        if(Character.isUpperCase(word.charAt(j))) {
          result.append(".").append(word.charAt(j));
        }
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String[] input = {"Zone", "Improvement", "Plan"};
    System.out.println(acronym(input));
  }
}
