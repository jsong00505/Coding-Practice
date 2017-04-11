package chapter2.beginner.example7;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 11/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge The Shortest Path Of Maze
 */
class Point {
  private int x;
  private int y;
  private int distance;

  Point() {
    this.x = 0;
    this.y = 0;
    this.distance = -1;
  }

  Point (int x, int y, int distance) {
    this.x = x;
    this.y = y;
    this.distance = distance;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getDistance() {
    return distance;
  }
}
public class Solution {
  static char WALL = '#';
  static char PATH = '.';
  static char START = 'S';
  static char GOAL = 'G';

  static void print(int n, int m, char[][] map) {
    System.out.println("==========START==========");
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("=========END=========");
  }

  /**
   * find the shortest path by breadth-first search using queue
   *
   * @param n
   * @param m
   * @param start
   * @param map
   * @return a distance of the shortest path
   */
  static int findShortestDistance(int n, int m, Point start, char[][] map) {
    int distance = 0;
    boolean[][] visited = new boolean[n][m];
    LinkedList<Point> queue = new LinkedList<>();

    if(start.getDistance() == -1) {
      return -1;
    } else {
      queue.add(start);
      visited[start.getX()][start.getY()] = true;
    }

    while (!queue.isEmpty()) {
      Point p = queue.removeFirst();
      int x = p.getX();
      int y = p.getY();
      distance = p.getDistance();

      // up
      if(x > 0) {
        if(map[x - 1][y] == PATH && !visited[x - 1][y]) {
          queue.add(new Point(x - 1, y, distance + 1));
          visited[x - 1][y] = true;
        } else if(map[x - 1][y] == GOAL) {
          distance++;
          break;
        }
      }

      // down
      if(x < n - 1) {
        if(map[x + 1][y] == PATH && !visited[x + 1][y]) {
          queue.add(new Point(x + 1, y, distance + 1));
          visited[x + 1][y] = true;
        } else if(map[x + 1][y] == GOAL) {
          distance++;
          break;
        }
      }

      // left
      if(y > 0) {
        if(map[x][y - 1] == PATH && !visited[x][y - 1]) {
          queue.add(new Point(x, y - 1, distance + 1));
          visited[x][y - 1] = true;
        } else if(map[x][y - 1] == GOAL) {
          distance++;
          break;
        }
      }

      // right
      if(y < m - 1) {
        if(map[x][y + 1] == PATH && !visited[x][y + 1]) {
          queue.add(new Point(x, y + 1, distance + 1));
          visited[x][y + 1] = true;
        } else if(map[x][y + 1] == GOAL) {
          distance++;
          break;
        }
      }
    }

    return distance;
  }
  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n = in.nextInt();
      int m = in.nextInt();

      assert (n >= 1 && n <= 100 && m >= 1 && m <= 100);

      Point startPoint = new Point();

      int countingStartPoint = 0;
      char[][] map = new char[n][m];
      for (int i = 0; i < n; i++) {
        String line = in.next();

        assert (line.length() == m);
        for (int j = 0; j < m; j++) {
          map[i][j] = line.charAt(j);

          if(map[i][j] == START) {
            // check if there are two starting points
            if(countingStartPoint == 0) {
              startPoint.setX(i);
              startPoint.setY(j);
              startPoint.setDistance(0);
              countingStartPoint++;
            } else {
              assert (false);
            } // if-else
          } // if

          assert (map[i][j] == WALL || map[i][j] == PATH || map[i][j] == START || map[i][j] == GOAL);
        } // for
      } // for
      out.println(findShortestDistance(n, m, startPoint, map));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
