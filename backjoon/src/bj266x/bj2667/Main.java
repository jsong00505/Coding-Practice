package bj266x.bj2667;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 06/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge House Number
 */
public class Main {
  static char EMPTY = '0';
  static char NOT_EMPTY = '1';
  static LinkedList<Integer> stack = new LinkedList<>();

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
   * basic depth-first search algorithm
   *
   * @param n size of matrix
   * @param x x position
   * @param y y position
   * @param map a map of house
   * @param visited a map of visited
   * @param numberOfHouse counted a number of house
   * @return the updated visited map
   */
  static boolean[][] depthFirstSearch(
      int n, int x, int y, char[][] map, boolean[][] visited, int numberOfHouse) {
    visited[x][y] = true;
    stack.set(numberOfHouse, stack.get(numberOfHouse) + 1);
    // up
    if (x > 0) {
      if (map[x - 1][y] == NOT_EMPTY && !visited[x - 1][y]) {
        visited = depthFirstSearch(n, x - 1, y, map, visited, numberOfHouse);
      }
    }

    // down
    if (x < n - 1) {
      if (map[x + 1][y] == NOT_EMPTY && !visited[x + 1][y]) {
        visited = depthFirstSearch(n, x + 1, y, map, visited, numberOfHouse);
      }
    }

    // right
    if (y < n - 1) {
      if (map[x][y + 1] == NOT_EMPTY && !visited[x][y + 1]) {
        visited = depthFirstSearch(n, x, y + 1, map, visited, numberOfHouse);
      }
    }

    // left
    if (y > 0) {
      if (map[x][y - 1] == NOT_EMPTY && !visited[x][y - 1]) {
        visited = depthFirstSearch(n, x, y - 1, map, visited, numberOfHouse);
      }
    }

    return visited;
  }

  static void getNumbersOfHouse(int n, char[][] map) {
    boolean[][] visited = new boolean[n][n];
    int numberOfHouse = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
        if (map[i][j] == NOT_EMPTY && !visited[i][j]) {
          stack.add(0);
          visited = depthFirstSearch(n, i, j, map, visited, numberOfHouse++);
        }
      }
    }

    Collections.sort(stack);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int n = in.nextInt();

    assert (n >= 5 && n <= 25);

    char[][] map = new char[n][n];

    in.nextLine();
    for (int i = 0; i < n; i++) {
      String line = in.nextLine();
      for (int j = 0; j < n; j++) {

        map[i][j] = line.charAt(j);
        assert (map[i][j] == EMPTY || map[i][j] == NOT_EMPTY);
      }
    }

    getNumbersOfHouse(n, map);

    // print
    out.println(stack.size());
    for (int numb : stack) {
      out.println(numb);
    }
    in.close();
    out.close();
  }
}
