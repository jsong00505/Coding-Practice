package bj257x.bj2573;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 07/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Iceberg
 */
public class Main {
  /**
   * debugging method that print out all elements in 2d array
   *
   * @param n
   * @param m
   * @param map
   */
  static void printArray(int n, int m, int[][] map) {
    System.out.println("==============START==============");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("==============END==============");
  }

  /**
   * basic depth first search algorithm
   *
   * @param x
   * @param y
   * @param map
   * @param visited
   * @return the updated visited map
   */
  static boolean[][] depthFirstSearch(int x, int y, int[][] map, boolean[][] visited) {
    // make this point visited first
    visited[x][y] = true;

    // up
    if (map[x - 1][y] > 0 && !visited[x - 1][y]) {
      visited = depthFirstSearch(x - 1, y, map, visited);
    }

    // down
    if (map[x + 1][y] > 0 && !visited[x + 1][y]) {
      visited = depthFirstSearch(x + 1, y, map, visited);
    }

    // right
    if (map[x][y + 1] > 0 && !visited[x][y + 1]) {
      visited = depthFirstSearch(x, y + 1, map, visited);
    }

    // left
    if (map[x][y - 1] > 0 && !visited[x][y - 1]) {
      visited = depthFirstSearch(x, y - 1, map, visited);
    }

    // return visited map
    return visited;
  }

  /**
   * update iceberg map after melting
   *
   * @param n
   * @param m
   * @param map original map before melting
   * @return the updated iceberg map
   */
  static int[][] meltIceberg(int n, int m, int[][] map) {
    // update the original map to changed map
    int[][] changedMap = new int[n][m];

    // amount of melted
    int melted = 0;

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        if (map[i][j] > 0) {
          // up
          if (map[i - 1][j] <= 0) {
            melted++;
          }
          // down
          if (map[i + 1][j] <= 0) {
            melted++;
          }

          // right
          if (map[i][j + 1] <= 0) {
            melted++;
          }

          // left
          if (map[i][j - 1] <= 0) {
            melted++;
          }

          // abstract melted amount in map and update
          changedMap[i][j] = map[i][j] - melted;

          // init for next
          melted = 0;

          // just make the value to zero for displaying pretty
          if (changedMap[i][j] <= 0) {
            changedMap[i][j] = 0;
          }
        } else {
          changedMap[i][j] = map[i][j];
        } // if-else
      } // for
    } // for

    return changedMap;
  }

  /**
   * process check and update iceberg map here
   *
   * @param n
   * @param m
   * @param map
   * @return the year iceberg is separated with over two pieces
   */
  static int findShortestYearOfMeltingIcebergC(int n, int m, int[][] map) {
    int year = 0;
    int iceberg = 0;
    int zeroCount = 0;
    while (true) {
      // init visited map
      boolean[][] visited = new boolean[n][m];

      for (int i = 1; i < n - 1; i++) {
        for (int j = 1; j < m - 1; j++) {
          // if not visited and there is iceberg, try to depth-first search
          if (map[i][j] > 0 && !visited[i][j]) {
            iceberg++;

            // for optimization if iceberg is over 2, just return the year
            if (iceberg == 2) {
              return year;
            }
            visited = depthFirstSearch(i, j, map, visited);
          }

          if (map[i][j] <= 0) {
            zeroCount++;
          }
        }
      }

      // if pieces of iceberg are over 2 or whole iceberg was melted, just return the year
      if (iceberg >= 2 || zeroCount >= (n - 2) * (m - 2)) {
        return year;
      } else {
        // init
        iceberg = 0;
        zeroCount = 0;
      }

      // the method melt the iceberg
      map = meltIceberg(n, m, map);
      year++;
    } // while
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();
      int m = in.nextInt();

      // validation
      assert (n >= 3 && n <= 300 && m >= 3 && n <= 300);

      int[][] map = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          map[i][j] = in.nextInt();
        }
      }

      out.println(findShortestYearOfMeltingIcebergC(n, m, map));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
