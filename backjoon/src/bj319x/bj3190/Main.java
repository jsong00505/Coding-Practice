package bj319x.bj3190;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 18/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Snake
 */
class SnakeCommand {
  private int seconds;
  private char command;

  SnakeCommand(int seconds, char command) {
    this.seconds = seconds;
    this.command = command;
  }

  public int getSeconds() {
    return seconds;
  }

  public char getDirection() {
    return command;
  }
}

class Snake {
  private int x;
  private int y;

  Snake(int x, int y) {
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
  // elements in board
  static char APPLE = 'A';
  static char SNAKE = 'S';
  static char EMPTY = '0';

  // commands
  static char LEFT_COMMAND = 'L';
  static char RIGHT_COMMAND = 'D';

  // directions
  static char LEFT_DIRECTION = 'L';
  static char RIGHT_DIRECTION = 'R';
  static char UP_DIRECTION = 'U';
  static char DOWN_DIRECTION = 'D';

  /**
   * debugging method
   *
   * @param board
   */
  static void print(char[][] board) {
    System.out.println("=========START=========");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("=========END=========");
  }

  /**
   * get a changed direction by command
   *
   * @param original
   * @param command
   * @return a changed direction
   */
  static char changeDirection(char original, char command) {
    char changed = original;

    if (command == LEFT_COMMAND) {
      // up
      if (original == UP_DIRECTION) {
        changed = LEFT_DIRECTION;
      }
      // down
      if (original == DOWN_DIRECTION) {
        changed = RIGHT_DIRECTION;
      }
      // left
      if (original == LEFT_DIRECTION) {
        changed = DOWN_DIRECTION;
      }
      // right
      if (original == RIGHT_DIRECTION) {
        changed = UP_DIRECTION;
      }
    } else if (command == RIGHT_COMMAND) {
      // up
      if (original == UP_DIRECTION) {
        changed = RIGHT_DIRECTION;
      }
      // down
      if (original == DOWN_DIRECTION) {
        changed = LEFT_DIRECTION;
      }
      // left
      if (original == LEFT_DIRECTION) {
        changed = UP_DIRECTION;
      }
      // right
      if (original == RIGHT_DIRECTION) {
        changed = DOWN_DIRECTION;
      }
    }

    return changed;
  }

  /**
   * get time that the snake dies by crushing to wall or its own body
   *
   * @param n
   * @param board
   * @param queue
   * @return time that the sanke dies
   */
  static int getTimeSnakeDies(int n, char[][] board, LinkedList<SnakeCommand> queue) {
    int seconds = 0;

    // init
    int x = 0;
    int y = 0;
    char direction = RIGHT_DIRECTION;

    SnakeCommand snakeCommand = new SnakeCommand(-1, ' ');

    LinkedList<Snake> snake = new LinkedList<>();
    snake.add(new Snake(x, y));
    board[x][y] = SNAKE;

    while (true) {

      //print(board);
      if (snakeCommand.getSeconds() < seconds && !queue.isEmpty()) {
        snakeCommand = queue.removeFirst();
      }

      // change direction by command
      if (snakeCommand.getSeconds() == seconds) {
        direction = changeDirection(direction, snakeCommand.getDirection());
      }

      // counting time
      seconds++;

      // snake moves to ...
      // up
      if (direction == UP_DIRECTION) {
        if (x > 0) {
          // update head's position
          x--;
        } else {
          // crush the snake to wall
          break;
        }
      } else if (direction == DOWN_DIRECTION) {
        if (x < n - 1) {
          // update head's position
          x++;
        } else {
          // crush the snake to wall
          break;
        }
      } else if (direction == LEFT_DIRECTION) {
        if (y > 0) {
          // update head's position
          y--;
        } else {
          // crush the snake to wall
          break;
        }
      } else if (direction == RIGHT_DIRECTION) {
        if (y < n - 1) {
          // update head's position
          y++;
        } else {
          // crush the snake to wall
          break;
        }
      } // if-else

      if (board[x][y] == SNAKE) {
        // crush the snake to its body
        break;
      } else {
        // if not an apple, moved snake's body to upper side
        if (board[x][y] != APPLE) {
          Snake movedSnake = snake.removeFirst();
          board[movedSnake.getX()][movedSnake.getY()] = EMPTY;
        }

        snake.add(new Snake(x, y));
        board[x][y] = SNAKE;
      }
      /*for(Snake s: snake) {
        System.out.println(s.getX() + ", " + s.getY());
      }*/
    } // while

    return seconds;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int n;
      int k;
      char[][] board;
      int l;
      LinkedList<SnakeCommand> queue = new LinkedList<>();

      // get n and k
      n = in.nextInt();
      k = in.nextInt();

      // validation
      assert (n >= 2 && n <= 100 && k >= 0 && k <= 100);

      // init board
      board = new char[n][n];

      // set apples in the board
      for (int i = 0; i < k; i++) {
        int x = in.nextInt();
        int y = in.nextInt();

        // validation
        assert (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1);

        board[x - 1][y - 1] = APPLE;
      }

      // a number of command
      l = in.nextInt();

      // validation
      assert (l >= 1 && l <= 100);

      // get command information
      for (int i = 0; i < l; i++) {
        int seconds = in.nextInt();
        String command = in.next();

        assert (seconds >= 0 && seconds <= 10000);

        // add this information in queue
        queue.add(new SnakeCommand(seconds, command.charAt(0)));
      }

      out.println(getTimeSnakeDies(n, board, queue));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
