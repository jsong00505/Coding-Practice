package test.openbet.part1;

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
  static int egocentricNumbers(int input) {
    int original = input;
    int sum = 0;

    // convert integer to string for getting how many times multiply
    String inputString = Integer.toString(input);
    int power = inputString.length();

    //
    while (input > 0) {
      // get last digit of input
      int temp = input % 10;
      int poweredTemp = 1;

      // multiply the power times
      for (int i = 0; i < power; i++) {
        poweredTemp *= temp;
      }

      // add the powered number
      sum += poweredTemp;

      // remove last digit
      input /= 10;
    }

    // return 1 if the input is same as sum
    if (sum == original) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(egocentricNumbers(100));
    System.out.println(egocentricNumbers(5));
    System.out.println(egocentricNumbers(153));
    System.out.println(egocentricNumbers(9982));
  }
}
