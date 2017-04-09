package bj1002x.bj10026;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 09/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Cow Arts
 */
public class Main {
  static char RED = 'R';
  static char GREEN = 'G';
  static char BLUE = 'B';

  static int numberOfColoredSection = 0;
  static int numberOfColoredSectionByBlind = 0;

  /**
   * debugging method that print out all elements in 2d array
   *
   * @param n
   * @param m
   * @param map
   */
  static void printArray(int n, int m, boolean[][] map) {
    System.out.println("==============START==============");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print((map[i][j] == true ? "t" : "f") + " ");
      }
      System.out.println();
    }

    System.out.println("==============END==============");
  }

  /**
   * check if both colors are same by red-green color blind
   *
   * @param firstColor
   * @param secondColor
   * @param colorBlind
   * @return true if the colors are same
   */
  static boolean isSameColor(char firstColor, char secondColor, boolean colorBlind) {
    boolean result = false;
    if (colorBlind) {
      if (firstColor != secondColor) {
        if ((firstColor == RED && secondColor == GREEN)
            || (firstColor == GREEN && secondColor == RED)) {
          result = true;
        }
      } else {
        result = true;
      }
    } else if (firstColor == secondColor) {
      result = true;
    }

    return result;
  }

  /**
   * basic depth-first search
   *
   * @param n
   * @param x
   * @param y
   * @param map
   * @param visited
   * @param color
   * @param colorBlind
   * @return
   */
  static boolean[][] depthFirstSearch(
      int n, int x, int y, char[][] map, boolean[][] visited, char color, boolean colorBlind) {
    visited[x][y] = true;

    // up
    if (x > 0) {
      if (isSameColor(map[x][y], map[x - 1][y], colorBlind) && !visited[x - 1][y]) {
        visited = depthFirstSearch(n, x - 1, y, map, visited, map[x - 1][y], colorBlind);
      }
    }

    // down
    if (x < n - 1) {
      if (isSameColor(map[x][y], map[x + 1][y], colorBlind) && !visited[x + 1][y]) {
        visited = depthFirstSearch(n, x + 1, y, map, visited, map[x + 1][y], colorBlind);
      }
    }
    // right
    if (y < n - 1) {
      if (isSameColor(map[x][y], map[x][y + 1], colorBlind) && !visited[x][y + 1]) {
        visited = depthFirstSearch(n, x, y + 1, map, visited, map[x][y + 1], colorBlind);
      }
    }
    // left
    if (y > 0) {
      if (isSameColor(map[x][y], map[x][y - 1], colorBlind) && !visited[x][y - 1]) {
        visited = depthFirstSearch(n, x, y - 1, map, visited, map[x][y - 1], colorBlind);
      }
    }
    return visited;
  }

  /**
   * init and call depth-first search here
   *
   * @param n
   * @param map
   */
  static void findNumberOfColoredSection(int n, char[][] map) {
    boolean[][] visited = new boolean[n][n];
    boolean[][] blindVisited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          visited = depthFirstSearch(n, i, j, map, visited, map[i][j], false);
          numberOfColoredSection++;
        }

        if (!blindVisited[i][j]) {
          blindVisited = depthFirstSearch(n, i, j, map, blindVisited, map[i][j], true);
          numberOfColoredSectionByBlind++;
        }
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();

      // validation
      assert (n >= 1 && n <= 100);

      // declare a n x n array
      char[][] map = new char[n][n];
      for (int i = 0; i < n; i++) {
        String line = in.next();
        for (int j = 0; j < n; j++) {
          map[i][j] = line.charAt(j);

          // validation
          assert (map[i][j] == RED || map[i][j] == GREEN || map[i][j] == BLUE);
        }
      } // for

      findNumberOfColoredSection(n, map);
      out.println(numberOfColoredSection);
      out.println(numberOfColoredSectionByBlind);
    }
  }
}
