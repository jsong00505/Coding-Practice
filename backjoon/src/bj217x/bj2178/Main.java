package bj217x.bj2178;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jsong on 31/03/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   Maze
 */
class Maze {
  int x;
  int y;
  int length;

  Maze(int x, int y, int length) {
    this.x = x;
    this.y = y;
    this.length = length;
  }
}

public class Main {
  /**
   * Method Name: findShortestPath
   *
   * <p>find the shortest path by BFS algorithms
   *
   * @param n the number of rows
   * @param m the number of columns
   * @param maze the map of the maze
   * @param visited the flag checks if visited
   * @return the shortest length
   */
  static int findShortestPath(int n, int m, char[][] maze, boolean[][] visited) {
    ArrayList<Maze> queue = new ArrayList<>();
    int length = 0;
    // init
    if (maze[0][0] == '1') {
      queue.add(new Maze(0, 0, 1));
      visited[0][0] = true;
    }

    while (!queue.isEmpty()) {
      Maze temp = queue.remove(0);
      int x = temp.x;
      int y = temp.y;
      length = temp.length;

      // up
      if (x > 0 && x < n) {
        if (!visited[x - 1][y] && maze[x - 1][y] == '1') {
          visited[x - 1][y] = true;
          queue.add(new Maze(x - 1, y, length + 1));
        }
      }

      // down
      if (x >= 0 && x < n - 1) {
        if (!visited[x + 1][y] && maze[x + 1][y] == '1') {
          visited[x + 1][y] = true;
          queue.add(new Maze(x + 1, y, length + 1));
        }
      }

      // left
      if (y > 0 && y < m) {
        if (!visited[x][y - 1] && maze[x][y - 1] == '1') {
          visited[x][y - 1] = true;
          queue.add(new Maze(x, y - 1, length + 1));
        }
      }

      // right
      if (y >= 0 && y < m - 1) {
        if (!visited[x][y + 1] && maze[x][y + 1] == '1') {
          visited[x][y + 1] = true;
          queue.add(new Maze(x, y + 1, length + 1));
        }
      }
      if(x == n - 1 && y == m - 1) {
        break;
      }
    }
    return length;
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      int n = in.nextInt();
      int m = in.nextInt();

      assert (n >= 2 && n <= 100);
      assert (m >= 2 && n <= 100);

      char[][] maze = new char[n][m];
      boolean[][] visited = new boolean[n][m];

      in.nextLine();
      for (int i = 0; i < n; i++) {
        String temp = in.nextLine();
        for (int j = 0; j < m; j++) {
          maze[i][j] = temp.charAt(j);
          visited[i][j] = false;
        }
      }

      out.println(findShortestPath(n, m, maze, visited));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
