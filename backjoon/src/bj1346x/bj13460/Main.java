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
  private Point red;
  private Point blue;
  private Point hole;
  private int minimumNumber;

  Marvels(int minimumNumber) {
    this.minimumNumber = minimumNumber;

    // set those to null for validation
    setRed(null);
    setBlue(null);
    setHole(null);
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

  public int getMinimumNumber() {
    return minimumNumber;
  }
}

public class Main {
  static char EMPTY = '.';
  static char WALL = '#';
  static char HOLE = 'O';
  static char RED_MARBLE = 'R';
  static char BLUE_MARBLE = 'B';

  static char RIGHT = 'R';
  static char LEFT = 'L';
  static char UP = 'U';
  static char DOWN = 'D';

  static char SUCCEED = 'S';
  static char FAILED = 'F';
  static char CONTINUED = 'C';

  public static void print(char[][] array) {
    System.out.println("==========");
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("==========");
  }

  public static String hashed(Marvels marvels) {
    StringBuilder hashString = new StringBuilder();
    hashString.append(marvels.getRed().getX());
    hashString.append(marvels.getRed().getY());
    hashString.append(marvels.getBlue().getX());
    hashString.append(marvels.getBlue().getY());

    return hashString.toString();
  }

  public static char checkEscapeXae(Marvels marvels) {
    char result = CONTINUED;

    if (marvels.getBlue() == null && marvels.getRed() == null) {
      result = FAILED;
    } else if (marvels.getRed() == null) {
      result = SUCCEED;
    }
    return result;
  }

  public static Marvels setPosition(char[][] board, Marvels marvels) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == RED_MARBLE) {
          marvels.setRed(new Point(i, j));
        } else if (board[i][j] == BLUE_MARBLE) {
          marvels.setBlue(new Point(i, j));
        } else if (board[i][j] == HOLE) {
          marvels.setHole(new Point(i, j));
        }
      }
    }

    return marvels;
  }

  public static char[][] move(char direction, char[][] board, Point marvelPoint, char color) {
    int startX = marvelPoint.getX();
    int startY = marvelPoint.getY();

    boolean blueFlag = true;

    // validation or initialization by the color on the board
    if (color != board[startX][startY]) {
      return board;
    } else {
      board[startX][startY] = EMPTY;
    }

    while (board[startX][startY] != WALL) {
      // moves to the direction
      if (direction == LEFT) {
        startY--;
      } else if (direction == RIGHT) {
        startY++;
      } else if (direction == UP) {
        startX--;
      } else if (direction == DOWN) {
        startX++;
      }

      // if it meets the blue marvel during the move, it makes to move blue marvel or stop the iteration
      if (color == RED_MARBLE && board[startX][startY] == BLUE_MARBLE) {
        if (blueFlag) {
          // call this method by blue marvel
          move(direction, board, new Point(startX, startY), BLUE_MARBLE);
          blueFlag = false;
        } else {
          // here is the last spot can move
          break;
        } // if-else
      } else if (color == BLUE_MARBLE && board[startX][startY] == RED_MARBLE) {
        break;
      } else if (board[startX][startY] == HOLE) {
        return board;
      }
    }

    // set the color
    if (direction == LEFT) {
      board[startX][startY + 1] = color;
    } else if (direction == RIGHT) {
      board[startX][startY - 1] = color;
    } else if (direction == UP) {
      board[startX + 1][startY] = color;
    } else if (direction == DOWN) {
      board[startX - 1][startY] = color;
    }

    return board;
  }

  public static int getMinimumNumberOfEscape(char[][] board, Marvels marvels) {
    int minimumNumber = 0;
    LinkedList<Marvels> queue = new LinkedList<>();
    LinkedList<String> visited = new LinkedList<>();

    queue.add(marvels);

    while (!queue.isEmpty()) {
      marvels = queue.removeFirst();
      Marvels temp;

      char[][] original = board;

      minimumNumber = marvels.getMinimumNumber();

      System.out.println("QSIZE: " + queue.size());
      System.out.println("MIN: " + minimumNumber);
      print(original);

      if (minimumNumber > 10) {
        continue;
      }

      char resultFlag = checkEscapeXae(marvels);

      if (resultFlag == SUCCEED) {
        break;
      } else if (resultFlag == FAILED) {
        continue;
      }

      if (visited.contains(hashed(marvels))) {
        continue;
      } else {
        visited.add(hashed(marvels));
      }

      minimumNumber++;

      // left
      board = move(LEFT, original, marvels.getRed(), RED_MARBLE);
      board = move(LEFT, board, marvels.getBlue(), BLUE_MARBLE);

      temp = new Marvels(minimumNumber);

      queue.add(setPosition(board, temp));

      // right
      board = move(RIGHT, original, marvels.getRed(), RED_MARBLE);
      board = move(RIGHT, board, marvels.getBlue(), BLUE_MARBLE);

      temp = new Marvels(minimumNumber);

      queue.add(setPosition(board, temp));

      // up
      board = move(UP, original, marvels.getRed(), RED_MARBLE);
      board = move(UP, board, marvels.getBlue(), BLUE_MARBLE);

      temp = new Marvels(minimumNumber);

      queue.add(setPosition(board, temp));

      // down
      board = move(DOWN, original, marvels.getRed(), RED_MARBLE);
      board = move(DOWN, board, marvels.getBlue(), BLUE_MARBLE);

      temp = new Marvels(minimumNumber);

      queue.add(setPosition(board, temp));
    }

    return minimumNumber;
  }

  public static void main(String[] args) {

    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      // get inputs
      int n = in.nextInt();
      int m = in.nextInt();

      assert (n >= 3 && n <= 10 && m >= 3 && m <= 10);

      // declare n x m array
      char[][] board = new char[n][m];
      Marvels marvels = new Marvels(0);

      in.nextLine();
      // init board
      for (int i = 0; i < n; i++) {
        String line = in.nextLine();
        for (int j = 0; j < m; j++) {
          board[i][j] = line.charAt(j);
        }
      }

      marvels = setPosition(board, marvels);

      // validation
      assert (marvels.getRed() != null && marvels.getBlue() != null && marvels.getHole() != null);

      out.println(getMinimumNumberOfEscape(board, marvels));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
