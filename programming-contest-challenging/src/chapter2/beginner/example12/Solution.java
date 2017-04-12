package chapter2.beginner.example12;

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
 * @challenge Fence Repair(POJ 3253)
 */
public class Solution {
  static void print(int[] array) {
    for(int a: array) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  /**
   * find a minimum cost to repair fence using greedy algorithm
   *
   * @param n
   * @param l
   * @return a minimum cost to repair fence
   */
  static int getMinCostToRepairFence(int n, int[] l) {
    int cost = 0;
    int sum;
    for(int i = n - 1; i > 0; i--) {
      int minPosition1 = 0;
      int minPosition2 = 1;

      // find minimum two values
      for(int j = 1; j <= i; j++) {
        if (l[j] < l[minPosition1]) {
          minPosition2 = minPosition1;
          minPosition1 = j;
        } else if (l[j] < l[minPosition2]) {
          minPosition2 = j;
        }
      }

      // sum and add the sum to cost
      sum = l[minPosition1] + l[minPosition2];
      cost += sum;

      // swap
      if(minPosition1 == i) {
        int temp = minPosition1;
        minPosition1 = minPosition2;
        minPosition2 = temp;
      }

      // update
      l[minPosition1] = sum;
      l[minPosition2] = l[i];

      // marking this spot is not used
      l[i] = -1;
    }
    return cost;
  }
  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);) {
      int n = in.nextInt();

      // constraints
      assert (n >= 1 && n <= 20000);

      int[] l = new int[n];
      for(int i = 0; i < l.length; i++) {
        l[i] = in.nextInt();

        // constraints
        assert (l[i] >= 1 && l[i] <= 50000);
      }

      out.println(getMinCostToRepairFence(n, l));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
