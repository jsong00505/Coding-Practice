package abooks.part1;

import java.util.LinkedList;

/**
 * Created by jsong on 12/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge
 */
public class Main {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int totalScore(String[] blocks, int n)
  {
    // WRITE YOUR CODE HERE

    // DEFINE VARIABLES
    String Z = "Z";
    String X = "X";
    String PLUS = "+";

    // RETURN VALUE
    int result = 0;

    // DECLARE STACK
    LinkedList<Integer> stack = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      // DECLARE TEMP VARIABLES
      String tempStr = blocks[i];
      int tempInt1;
      int tempInt2;
      int intSum;

      if (tempStr.equals(Z)) {
        // CAN REMOVE LAST WHEN THE STACK'S SIZE IS OVER 0
        if (stack.size() > 0) {
          tempInt1 = stack.removeLast();

          result -= tempInt1;
        } // IF ENDS
      } else if (tempStr.equals(X)) {
        // CAN REMOVE LAST WHEN THE STACK'S SIZE IS OVER 0
        if (stack.size() > 0) {
          tempInt1 = stack.removeLast() * 2;

          result += tempInt1;

          stack.add(tempInt1);
        } // IF ENDS

      } else if (tempStr.equals(PLUS)) {
        // CAN ADD LAST TWO NUMBERS WHEN THE STACK'S SIZE IS OVER 1
        if (stack.size() > 1) {
          tempInt1 = stack.get(stack.size() - 1);
          tempInt2 = stack.get(stack.size() - 2);

          intSum = tempInt1 + tempInt2;
          result += intSum;

          stack.add(intSum);
        } // IF ENDS
      } else {
        stack.add(Integer.parseInt(tempStr));

        result += Integer.parseInt(tempStr);
      } // IF-ELSE ENDS
    } // FOR ENDS

    return result;
  }
  public static void main(String[] args) {
    String[] arr = {"1", "2", "+", "Z"};

    System.out.println(totalScore(arr, 4));
  }
}
