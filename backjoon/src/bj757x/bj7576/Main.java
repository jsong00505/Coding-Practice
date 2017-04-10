package bj757x.bj7576;

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

class Queue {
  int front;
  int rear;
  Point[] queue;
  int size;
  int maxSize;

  Queue(int maxSize) {
    this.queue = new Point[maxSize];
    this.maxSize = maxSize;
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  boolean isEmpty() {
    if(size == 0) {
      return true;
    }

    return false;
  }

  void push(Point element) {
    if(rear < maxSize) {
      queue[rear] = element;
      rear++;
      size++;
    } else {
      System.out.println("Cannot push an elements any more in this queue because over max size[" + maxSize + "].");
    }
  }

  Point pop() {
    Point element;
    if(front != rear || size == 0) {
      element = queue[front];
      front++;
      size--;
    } else {
      element = new Point(-1, -1);
      System.out.println("This queue is empty.");
    }

    if(size == 0) {
      front = 0;
      rear = 0;
    }

    return element;
  }

}
public class Main {
  static int RIPED = 1;
  static int UNRIPED = 0;
  static int EMPTY = -1;

  static int totalSpots = 0;
  static boolean[][] visited;

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

  static int[][] depthFirstSearch(int n, int m, int[][] box, Queue queue) {
    while (queue.size > 0) {
      Point p = queue.pop();

      int x = p.getX();
      int y = p.getY();

      visited[x][y] = true;

      // up
      if (x > 0) {
        if (box[x - 1][y] == UNRIPED) {
          box[x - 1][y] = RIPED;
          totalSpots++;
        }
      }
      // down
      if (x < n - 1) {
        if (box[x + 1][y] == UNRIPED) {
          box[x + 1][y] = RIPED;
          totalSpots++;
        }
      }
      // right
      if (y < m - 1) {
        if (box[x][y + 1] == UNRIPED) {
          box[x][y + 1] = RIPED;
          totalSpots++;
        }
      }
      // left
      if (y > 0) {
        if (box[x][y - 1] == UNRIPED) {
          box[x][y - 1] = RIPED;
          totalSpots++;
        }
      }
    }

    //print(n, m, box);
    return box;
  }

  static int getMinDaysRipedAll(int n, int m, int[][] box) {
    int days = 1;
    int beforeSpots = 0;
    visited = new boolean[n][m];

    while (true) {
      Queue queue = new Queue(n * m);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (box[i][j] == RIPED && !visited[i][j]) {
            queue.push(new Point(i, j));
          }
        }
      }

      // update the box by depth-first search
      box = depthFirstSearch(n, m, box, queue);

      if (n * m == totalSpots) {
        break;
      } else if (beforeSpots == totalSpots) {
        days = -1;
        break;
      } else {
        days++;
        beforeSpots = totalSpots;
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

      assert (m >= 2 && m <= 1000 && n >= 2 && n <= 1000);

      int[][] box = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          box[i][j] = in.nextInt();

          if (box[i][j] == EMPTY || box[i][j] == RIPED) {
            totalSpots++;
          }
        }
      }

      out.println(getMinDaysRipedAll(n, m, box));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
