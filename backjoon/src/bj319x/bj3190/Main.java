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
  private static int x;
  private static int y;
  private static int length;

  Snake(int x, int y, int length) {
    this.x = x;
    this.y = y;
    this.length = length;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getLength() {
    return length;
  }
}
public class Main {
  static char APPLE = 'A';
  static char SNAKE = 'S';
  static char EMPTY = '0';

  // commands
  static int COMMAND = -1;
  static char LEFT_COMMAND = 'L';
  static char RIGHT_COMMAND = 'D';

  // directions
  static char LEFT_DIRECTION = 'L';
  static char RIGHT_DIRECTION = 'R';
  static char UP_DIRECTION = 'U';
  static char DOWN_DIRECTION = 'D';

  static char changeDirection(char original, char command) {
    char changed = original;

    if(command == LEFT_COMMAND) {
      // up
      if(original == UP_DIRECTION) {
        changed = LEFT_DIRECTION;
      }
      // down
      if(original == DOWN_DIRECTION) {
        changed = RIGHT_DIRECTION;
      }
      // left
      if(original == LEFT_DIRECTION) {
        changed = DOWN_DIRECTION;
      }
      // right
      if(original == RIGHT_DIRECTION) {
        changed = UP_DIRECTION;
      }
    } else if(command == RIGHT_COMMAND) {
      // up
      if(original == UP_DIRECTION) {
        changed = RIGHT_DIRECTION;
      }
      // down
      if(original == DOWN_DIRECTION) {
        changed = LEFT_DIRECTION;
      }
      // left
      if(original == LEFT_DIRECTION) {
        changed = UP_DIRECTION;
      }
      // right
      if(original == RIGHT_DIRECTION) {
        changed = DOWN_DIRECTION;
      }
    }

    return changed;
  }

  static int getTimeSnakeDies(int n, int apples, char[][] board, LinkedList<SnakeCommand> queue) {
    int seconds = 0;

    // init
    int x = 0;
    int y = 0;
    int length = 1;
    char direction = RIGHT_DIRECTION;

    SnakeCommand snakeCommand = new SnakeCommand(-1, ' ');

    LinkedList<Snake> snake = new LinkedList<>();
    snake.add(new Snake(x, y, length));
    board[x][y] = SNAKE;

    while(apples != 0) {
      if(snakeCommand.getSeconds() < seconds) {
        snakeCommand = queue.removeFirst();
      }

      if(snakeCommand.getSeconds() == seconds) {
        direction = changeDirection(direction, snakeCommand.getDirection());
      }

      seconds++;

      // snake moves to ...
      // up
      if(direction == UP_DIRECTION) {
        if(x > 0) {
          if(board[x - 1][y] == APPLE) {
            // if the snake get an apple, the snake extends its length
            length++;
          } else {
            // moved snake's body to upper side
            Snake movedSnake = snake.removeFirst();
            board[movedSnake.getX()][movedSnake.getY()] = EMPTY;
          }

          if(board[x - 1][y] == SNAKE) {
            // crush the snake to its body
            break;
          } else {
            snake.add(new Snake(x - 1, y, length));
            board[x - 1][y] = SNAKE;
          }

          // update position
          x--;
        } else {
          // crush the snake to wall
          break;
        }
      } else if(direction == DOWN_DIRECTION) {
        if(x < n - 1) {

          if(board[x + 1][y] == APPLE) {
            // if the snake get an apple, the snake extends its length
            length++;
          } else {
            // moved snake's body to upper side
            Snake movedSnake = snake.removeFirst();
            board[movedSnake.getX()][movedSnake.getY()] = EMPTY;
          }

          if(board[x + 1][y] == SNAKE) {
            // crush the snake to its body
            break;
          } else {
            snake.add(new Snake(x + 1, y, length));
            board[x + 1][y] = SNAKE;
          }

          // update position
          x++;
        } else {
          // crush the snake to wall
          break;
        }
      } else if(direction == LEFT_DIRECTION) {
        if(y > 0) {
          if(board[x][y - 1] == APPLE) {
            // if the snake get an apple, the snake extends its length
            length++;
          } else {
            // moved snake's body to upper side
            Snake movedSnake = snake.removeFirst();
            board[movedSnake.getX()][movedSnake.getY()] = EMPTY;
          }

          if(board[x][y - 1] == SNAKE) {
            // crush the snake to its body
            break;
          } else {
            snake.add(new Snake(x, y - 1, length));
            board[x][y - 1] = SNAKE;
          }
        } else {
          // crush the snake to wall
          break;
        }

        // update position
        y--;
      } else if(direction == RIGHT_DIRECTION) {
        if(y < n - 1) {
          if(board[x][y + 1] == APPLE) {
            // if the snake get an apple, the snake extends its length
            length++;
          } else {
            // moved snake's body to upper side
            Snake movedSnake = snake.removeFirst();
            board[movedSnake.getX()][movedSnake.getY()] = EMPTY;
          }

          if(board[x][y + 1] == SNAKE) {
            // crush the snake to its body
            break;
          } else {
            snake.add(new Snake(x, y + 1, length));
            board[x][y + 1] = SNAKE;
          }
        } else {
          // crush the snake to wall
          break;
        }

        // update position
        y++;
      } // if
    } // while


    return seconds;
  }
  public static void main(String[] args) {
    try(Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);) {
      int n;
      int k;
      char[][] board;
      int l;
      LinkedList<SnakeCommand> queue = new LinkedList<>();

      n = in.nextInt();
      k = in.nextInt();

      // validation
      assert (n >= 2 && n <= 100 && k >= 0 && k <= 100);

      board = new char[n][n];

      for(int i = 0; i < k; i++) {
        int x = in.nextInt();
        int y = in.nextInt();

        // validation
        assert (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1);

        board[x - 1][y - 1] = APPLE;
      }

      l = in.nextInt();

      // validation
      assert (l >= 1 && l <= 100);

      for(int i = 0; i < l; i++) {
        int seconds = in.nextInt();
        String command = in.next();

        assert (seconds >= 0 && seconds <= 10000);

        // add this information in queue
        queue.add(new SnakeCommand(seconds, command.charAt(0)));
      }

      out.println(getTimeSnakeDies(n, k, board, queue));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
