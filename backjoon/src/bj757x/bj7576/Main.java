package bj757x.bj7576;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 09/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Main
 */
class Point {
  private int x;
  private int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

public class Main {
  static int RIPED = 1;
  static int UNRIPED = 0;
  static int EMPTY = -1;

  static int ripedSpots = 0;

  static void print(int n, int m, int[][] box) {
    System.out.println("=========START=========");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(box[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("==========END=========");
  }

  static int[][] depthFirstSearch(int n, int m, int[][] box, LinkedList<Point> queue) {
    for (Point p : queue) {
      int x = p.getX();
      int y = p.getY();

      // up
      if (x > 0) {
        if (box[x - 1][y] == UNRIPED) {
          box[x - 1][y] = RIPED;
          ripedSpots++;
        }
      }
      // down
      if (x < n - 1) {
        if (box[x + 1][y] == UNRIPED) {
          box[x + 1][y] = RIPED;
          ripedSpots++;
        }
      }
      // right
      if (y < m - 1) {
        if (box[x][y + 1] == UNRIPED) {
          box[x][y + 1] = RIPED;
          ripedSpots++;
        }
      }
      // left
      if (y > 0) {
        if (box[x][y - 1] == UNRIPED) {
          box[x][y - 1] = RIPED;
          ripedSpots++;
        }
      }
    }

    //print(n, m, box);
    return box;
  }

  static int getMinDaysRipedAll(int n, int m, int[][] box, int emptySpots) {
    int days = 1;
    int beforeSpots = 0;
    while (true) {
      LinkedList<Point> queue = new LinkedList<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (box[i][j] == RIPED) {
            queue.add(new Point(i, j));
          }
        }
      }

      // update the box by depth-first search
      box = depthFirstSearch(n, m, box, queue);

      if (n * m == emptySpots + ripedSpots) {
        break;
      } else if (beforeSpots == ripedSpots) {
        days = -1;
        break;
      } else {
        days++;
        beforeSpots = ripedSpots;
      } // if-else
    } // while

    return days;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // horizontal
      int m = in.nextInt();
      // vertical
      int n = in.nextInt();

      int emptySpots = 0;
      assert (m >= 2 && m <= 1000 && n >= 2 && n <= 1000);

      int[][] box = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          box[i][j] = in.nextInt();

          if (box[i][j] == EMPTY) {
            emptySpots++;
          } else if(box[i][j] == RIPED) {
            ripedSpots++;
          }
        }
      }

      out.println(getMinDaysRipedAll(n, m, box, emptySpots));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
