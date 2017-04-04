package bj249x.bj2493;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 01/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Tower
 */
public class Main {
  /**
   * Method Name: bruteForce
   *
   * <p>implemented by brute-force. so need to optimize later even if it passed.
   *
   * @param n the number of towers
   * @param heightOfTowers an array of the height of towers
   * @param received an array of the information about towers received light from other towers
   * @return the updated array of 'received'
   */
  static int[] bruteForce(int n, int[] heightOfTowers, int[] received) {
    for (int i = n - 1; i >= 0; i--) {
      int height = heightOfTowers[i];

      for (int j = i - 1; j >= 0; j--) {
        if (height <= heightOfTowers[j]) {
          received[i] = j + 1;
          break;
        }
      }
    }
    return received;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();

      //validation
      assert (n >= 1 && n <= 500000);

      int[] heightOfTowers = new int[n];
      int[] recevied = new int[n];

      for (int i = 0; i < n; i++) {
        heightOfTowers[i] = in.nextInt();
        recevied[i] = 0;
        // validation
        assert (n >= 1 && n <= 100000000);
      }

      // print
      recevied = bruteForce(n, heightOfTowers, recevied);

      for (int i : recevied) {
        out.print(i + " ");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
