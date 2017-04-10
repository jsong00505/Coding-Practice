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
 * @challenge Tomato
 */
class Point {
  private int x;
  private int y;
  private int day;

  Point(int x, int y, int day) {
    this.x = x;
    this.y = y;
    this.day = day;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getDay() {
    return day;
  }
}

public class Main {
  static int RIPED = 1;
  static int UNRIPED = 0;
  static int EMPTY = -1;
  static int CANNOT_RIPED = -1;
  static int totalSpots = 0;
  static LinkedList<Point> queue = new LinkedList<>();

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

  static int depthFirstSearch(int n, int m, int[][] box) {
    int day = CANNOT_RIPED;

    while (queue.size() > 0) {
      Point p = queue.removeFirst();
      int x = p.getX();
      int y = p.getY();
      day = p.getDay();

      // up
      if (x > 0) {
        if (box[x - 1][y] == UNRIPED) {
          box[x - 1][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x - 1, y, day + 1));
        }
      }
      // down
      if (x < n - 1) {
        if (box[x + 1][y] == UNRIPED) {
          box[x + 1][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x + 1, y, day + 1));
        }
      }
      // right
      if (y < m - 1) {
        if (box[x][y + 1] == UNRIPED) {
          box[x][y + 1] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y + 1, day + 1));
        }
      }
      // left
      if (y > 0) {
        if (box[x][y - 1] == UNRIPED) {
          box[x][y - 1] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y - 1, day + 1));
        }
      }
    }

    if (totalSpots != n * m) {
      day = -1;
    }

    //print(n, m, box);
    return day;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // horizontal
      int m = in.nextInt();
      // vertical
      int n = in.nextInt();

      assert (m >= 2 && m <= 1000 && n >= 2 && n <= 1000);

      int[][] box = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          box[i][j] = in.nextInt();

          if (box[i][j] == EMPTY) {
            totalSpots++;
          } else if (box[i][j] == RIPED) {
            totalSpots++;
            queue.add(new Point(i, j, 0));
          }
        }
      }

      out.println(depthFirstSearch(n, m, box));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
