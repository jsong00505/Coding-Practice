package corecs.algorithms.sorting.quicksort1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jsong on 03/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Quicksort 1 - Partition
 */
public class Solution {
  /**
   * partition of quicksort
   *
   * @param ar
   */
  static void partition(int[] ar) {
    // pivot is ar[0]
    int pivot = ar[0];

    // declare sorting arr
    ArrayList<Integer> partitionAr = new ArrayList<>();

    // insert pivot in the array first
    partitionAr.add(ar[0]);

    int pivotPosition = 0;

    for (int i = 1; i < ar.length; i++) {
      if (ar[i] <= pivot) {
        // left
        partitionAr.add(pivotPosition++, ar[i]);
      } else {
        // right
        partitionAr.add(ar[i]);
      }
    }

    // conversion
    for (int i = 0; i < partitionAr.size(); i++) {
      ar[i] = partitionAr.get(i);
    }
    // print
    printArray(ar);
  }

  /**
   * print arr out
   *
   * @param ar
   */
  static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    // validation
    assert (1 <= n && n <= 1000);

    // declare array having size n
    int[] ar = new int[n];

    // get elements
    for (int i = 0; i < n; i++) {
      ar[i] = in.nextInt();

      // validation
      assert (-1000 <= ar[i] && ar[i] <= 1000);
    }

    // partition and print
    partition(ar);
  }
}
