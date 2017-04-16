package bj152x.bj1525;

import java.io.PrintWriter;
import java.util.HashMap;
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
 * @challenge Puzzle
 */
class Puzzle {
  private String puzzle;
  private int movement;
  private int emptySpot;

  Puzzle(String puzzle, int movement) {
    this.puzzle = puzzle;
    this.movement = movement;
    this.emptySpot = puzzle.indexOf('0');
  }

  public String getPuzzle() {
    return puzzle;
  }

  public int getEmptySpot() {
    return emptySpot;
  }

  public int getMovement() {
    return movement;
  }
}

public class Main {
  static int THREE = 3;
  static String SUCCEED = "123456780";
  static String UP = "UP";
  static String DOWN = "DOWN";
  static String LEFT = "LEFT";
  static String RIGHT = "RIGHT";

  /**
   * debugging method
   *
   * @param puzzle
   */
  static void print(String puzzle) {
    System.out.println("puzzle >> ");
    for (int i = 0; i < puzzle.length(); i++) {
      System.out.print(puzzle.charAt(i) + " ");
      if ((i + 1) % 3 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }

  /**
   * update a puzzle form by moving some direction
   *
   * @param puzzle
   * @param direction
   * @param emptySpot
   * @return
   */
  static String updatePuzzle(String puzzle, String direction, int emptySpot) {
    StringBuilder result = new StringBuilder("");

    if (UP.equals(direction)) {
      result.append(puzzle.substring(0, emptySpot - 3));
      result.append('0');
      result.append(puzzle.substring(emptySpot - 2, emptySpot));
      result.append(puzzle.charAt(emptySpot - 3));
      result.append(puzzle.substring(emptySpot + 1));
    } else if (DOWN.equals(direction)) {
      result.append(puzzle.substring(0, emptySpot));
      result.append(puzzle.charAt(emptySpot + 3));
      result.append(puzzle.substring(emptySpot + 1, emptySpot + 3));
      result.append('0');
      result.append(puzzle.substring(emptySpot + 4));
    } else if (LEFT.equals(direction)) {
      result.append(puzzle.substring(0, emptySpot - 1));
      result.append('0');
      result.append(puzzle.charAt(emptySpot - 1));
      result.append(puzzle.substring(emptySpot + 1));
    } else if (RIGHT.equals(direction)) {
      result.append(puzzle.substring(0, emptySpot));
      result.append(puzzle.charAt(emptySpot + 1));
      result.append('0');
      result.append(puzzle.substring(emptySpot + 2));
    }

    return result.toString();
  }

  /**
   * get a minimum number of movement to make a initial puzzle form
   *
   * @param puzzle
   * @return a minimum number of movement
   */
  static int getMinNumberOfMovement(String puzzle) {
    int result = -1;
    LinkedList<Puzzle> queue = new LinkedList<>();
    HashMap<String, Boolean> visited = new HashMap<>();

    Puzzle p = new Puzzle(puzzle, 0);
    queue.add(p);
    visited.put(puzzle, true);

    while (!queue.isEmpty()) {
      //for(int i = 0; i < 10; i++) {
      p = queue.removeFirst();
      int emptySpot = p.getEmptySpot();
      visited.put(p.getPuzzle(), true);

      //print(p.getPuzzle());
      if (SUCCEED.equals(p.getPuzzle())) {
        result = p.getMovement();
        break;
      }

      // up
      if (emptySpot != 0 && emptySpot != 1 && emptySpot != 2) {
        String up = updatePuzzle(p.getPuzzle(), UP, emptySpot);
        if (!visited.containsKey(up)) {
          queue.add(new Puzzle(up, p.getMovement() + 1));
          visited.put(up, true);
        }
      }
      // down
      if (emptySpot != 6 && emptySpot != 7 && emptySpot != 8) {
        String down = updatePuzzle(p.getPuzzle(), DOWN, emptySpot);

        if (!visited.containsKey(down)) {
          queue.add(new Puzzle(down, p.getMovement() + 1));
          visited.put(down, true);
        }

        //print(puzzle);
      }
      // left
      if (emptySpot != 0 && emptySpot != 3 && emptySpot != 6) {
        String left = updatePuzzle(p.getPuzzle(), LEFT, emptySpot);

        if (!visited.containsKey(left)) {
          queue.add(new Puzzle(left, p.getMovement() + 1));
          visited.put(left, true);
        }

        // print(puzzle);
      }
      // right
      if (emptySpot != 2 && emptySpot != 5 && emptySpot != 8) {
        String right = updatePuzzle(p.getPuzzle(), RIGHT, emptySpot);

        if (!visited.containsKey(right)) {
          queue.add(new Puzzle(right, p.getMovement() + 1));
          visited.put(right, true);
        }

        //print(puzzle);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      StringBuilder puzzle = new StringBuilder();
      for (int i = 0; i < THREE * THREE; i++) {
        puzzle.append(in.nextInt());
      }

      out.println(getMinNumberOfMovement(puzzle.toString()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
