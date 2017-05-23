package bj1346x.bj13460;

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
 * @challenge Escape Xhae
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

class Marvels {
  Point red;
  Point blue;
  Point hole;
  int minimumNumber;

  Marvels(int minimumNumber) {
    this.minimumNumber = minimumNumber;
  }

  public void setBlue(Point blue) {
    this.blue = blue;
  }

  public void setRed(Point red) {
    this.red = red;
  }

  public void setHole(Point hole) {
    this.hole = hole;
  }

  public Point getBlue() {
    return blue;
  }

  public Point getRed() {
    return red;
  }

  public Point getHole() {
    return hole;
  }
}
public class Main {
  static char EMPTY = '.';
  static char WALL = '#';
  static char HOLE = 'O';
  static char RED_MARBLE = 'R';
  static char BLUE_MARBLE = 'B';

  public static char[][] moveRight(char[][] board, Marvels marvels) {


    return board;
  }

  public static char[][] moveLeft(char[][] board, Marvels marvels) {

    return board;
  }

  public static char[][] moveUp(char[][] board, Marvels marvels) {

    return board;
  }

  public static char[][] moveDown(char[][] board, Marvels marvels) {

    return board;
  }

  public static int getMinimumNumberOfEscape(char[][] board, Marvels marvels) {
    int minimumNumber = 0;
    LinkedList<Marvels> queue = new LinkedList<>();

    queue.add(marvels);

    while(!queue.isEmpty()) {
      marvels = queue.removeFirst();


    }
    return minimumNumber;
  }

  public static void main(String[] args) {

    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out) ) {
      // get inputs
      int n = in.nextInt();
      int m = in.nextInt();

      assert (n >= 3 && n <= 10 && m >= 3 && m <= 10);

      // declare n x m array
      char[][] board = new char[n][m];
      Marvels marvels = new Marvels(0);

      // init board
      for(int i = 0; i < n; i++) {
        String line = in.nextLine();
        for(int j = 0; j < m; j++) {
          board[i][j] = line.charAt(j);

          if(board[i][j] == RED_MARBLE) {
            marvels.setRed(new Point(i, j));
          } else if (board[i][j] == BLUE_MARBLE) {
            marvels.setBlue(new Point(i, j));
          } else if (board[i][j] == HOLE) {
            marvels.setHole(new Point(i, j));
          }
        }
      }

      // validation
      assert(marvels.getRed() != null && marvels.getBlue() != null && marvels.getHole() != null);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
