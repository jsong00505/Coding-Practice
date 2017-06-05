package test.openbet.part2;

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
  static String numbers_mood(int number) {
    // define strings for return
    final String HAPPY = "happy";
    final String SAD = "sad";

    // init sum for begin
    int sum = -1;

    // iterate till sum is 1 or 4
    while (sum != 1 && sum != 4) {
      // set number to sum if sum is not -1
      if (sum != -1) {
        number = sum;
      }

      // init sum to zero
      sum = 0;

      // iterate till number is positive
      while (number > 0) {
        // get last digit
        int digit = number % 10;

        // power the digit with two
        int poweredDigit = digit * digit;

        // add the poweredDigit to sum
        sum += poweredDigit;

        // remove the last digit
        number /= 10;
      }
    }

    // check if sum is 1 or 4
    if (sum == 1) {
      return HAPPY;
    } else {
      return SAD;
    }
  }

  public static void main(String[] args) {
    System.out.println(numbers_mood(1));
    System.out.println(numbers_mood(12));
    System.out.println(numbers_mood(19));
  }
}
