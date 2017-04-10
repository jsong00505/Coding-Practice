package bj756x.bj7569;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 10/04/2017.
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
  private int z;
  private int day;

  Point(int x, int y, int z, int day) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.day = day;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
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

  static void print(int n, int m, int h, int[][][] box) {
    System.out.println("=========START==========");
    for (int z = 0; z < h; z++) {
      for (int x = 0; x < n; x++) {
        for (int y = 0; y < m; y++) {
          System.out.print(box[z][x][y] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
    System.out.println("==========END==========");
  }

  static int depthFirstSearch(int n, int m, int h, int[][][] box) {
    int day = CANNOT_RIPED;

    while (queue.size() > 0) {
      Point p = queue.removeFirst();
      int x = p.getX();
      int y = p.getY();
      int z = p.getZ();
      day = p.getDay();

      // forward
      if (x > 0) {
        if (box[z][x - 1][y] == UNRIPED) {
          box[z][x - 1][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x - 1, y, z, day + 1));
        }
      }
      // backward
      if (x < n - 1) {
        if (box[z][x + 1][y] == UNRIPED) {
          box[z][x + 1][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x + 1, y, z, day + 1));
        }
      }
      // right
      if (y < m - 1) {
        if (box[z][x][y + 1] == UNRIPED) {
          box[z][x][y + 1] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y + 1, z, day + 1));
        }
      }
      // left
      if (y > 0) {
        if (box[z][x][y - 1] == UNRIPED) {
          box[z][x][y - 1] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y - 1, z, day + 1));
        }
      }
      // up
      if (z > 0) {
        if (box[z - 1][x][y] == UNRIPED) {
          box[z - 1][x][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y, z - 1, day + 1));
        }
      }
      // down
      if (z < h - 1) {
        if (box[z + 1][x][y] == UNRIPED) {
          box[z + 1][x][y] = RIPED;
          totalSpots++;
          queue.add(new Point(x, y, z + 1, day + 1));
        }
      }
    }

    if (totalSpots != n * m * h) {
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
      // height
      int h = in.nextInt();

      assert (m >= 2 && m <= 1000 && n >= 2 && n <= 1000);

      int[][][] box = new int[h][n][m];

      for (int z = 0; z < h; z++) {
        for (int x = 0; x < n; x++) {
          for (int y = 0; y < m; y++) {
            box[z][x][y] = in.nextInt();

            if (box[z][x][y] == EMPTY) {
              totalSpots++;
            } else if (box[z][x][y] == RIPED) {
              totalSpots++;
              queue.add(new Point(x, y, z, 0));
            }
          }
        }
      }

      out.println(depthFirstSearch(n, m, h, box));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
