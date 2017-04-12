package chapter2.beginner.example9;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jsong on 11/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Lectures
 */
public class Solution {
  static int START = 0;
  static int END = 1;

  /**
   * debugging method
   *
   * @param array
   */
  static void print(int[][] array) {
    System.out.println("==========START==========");
    for(int i = 0; i < array.length; i++) {
      System.out.println(array[i][START] + " " + array[i][END]);
    }
    System.out.println("==========END==========");
  }

  /**
   * find maximum number of lectures to take
   *
   * @param lectures
   * @return a maximum number of lectures to take
   */
  static int findMaxNumberOfLecturesToTake(int[][] lectures) {
    int numberOfLectures = 0;
    int lastEndOfLectures;

    // init
    lastEndOfLectures = lectures[0][END];
    numberOfLectures++;

    for(int i = 1; i < lectures.length; i++) {
      // check if the last end time is smaller than the start time of an current lecture
      if(lastEndOfLectures <= lectures[i][START]) {
        numberOfLectures++;
        lastEndOfLectures = lectures[i][END];
      }
    }

    return numberOfLectures;
  }

  /**
   * basic selection sort
   *
   * @param lectures
   * @return a 2d sorted array
   */
  static int[][] selectionSort(int[][] lectures) {
    int[] min = new int[2];
    int minPosition;

    for(int i = 0; i < lectures.length; i++) {
      // init min
      min[START] = lectures[i][START];
      min[END] = lectures[i][END];
      minPosition = i;

      for(int j = i; j < lectures.length; j++) {
        // change min
        if(min[END] > lectures[j][END]) {
          min[START] = lectures[j][START];
          min[END] = lectures[j][END];
          minPosition = j;
        }
      }

      // swap
      lectures[minPosition][START] = lectures[i][START];
      lectures[minPosition][END] = lectures[i][END];

      lectures[i][START] = min[START];
      lectures[i][END] = min[END];
    }

    return lectures;
  }

  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);) {
      int n  = in.nextInt();

      // validation
      assert (n >= 0 && n <= 100000);

      int[][] lectures = new int[n][2];
      for(int i = 0; i < n; i++) {
        lectures[i][START] = in.nextInt();

        // validation
        assert (lectures[i][START] >= 0 && lectures[i][START] <= 1000000000);
      }

      for(int i = 0; i < n; i++) {
        lectures[i][END] = in.nextInt();

        // validation
        assert(lectures[i][END] >= lectures[i][START] && lectures[i][END] <= 1000000000);
      }

      // sort
      lectures = selectionSort(lectures);

      // print
      out.println(findMaxNumberOfLecturesToTake(lectures));

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
