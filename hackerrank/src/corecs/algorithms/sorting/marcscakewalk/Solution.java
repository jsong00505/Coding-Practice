package corecs.algorithms.sorting.marcscakewalk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 03/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Marc's Cakewalk
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // number of cupcakes Marc ate
    int n = in.nextInt();

    // validation
    assert (1 <= n && n <= 40);

    // calories of each cupcakes
    int[] calories = new int[n];
    for(int calories_i=0; calories_i < n; calories_i++){
      calories[calories_i] = in.nextInt();

      // validation
      assert (1 <= calories[calories_i] && calories[calories_i] <= 1000);
    }

    // your code goes here

    // sort
    Arrays.sort(calories);

    // data type should be long because poweredTwo can be 2^39 as a maximum number
    long poweredTwo = 1;
    long sum = 0;

    for (int i = n - 1; i >= 0; i--) {
      // add calorie multiplied with number powered two
      sum += poweredTwo * calories[i];

      // multiply 2 at poweredTwo
      poweredTwo *= 2;
    }

    // print sum
    System.out.println(sum);
  }
}
