package bj1079x.bj10799;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 04/04/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   A Steel Rod
 */
public class Main {
  static char OPEN_BRACKET = '(';
  static char CLOSE_BRACKET = ')';
  static char INIT_CHAR = '0';

  /**
   *
   * Method Name: getNumberOfPiecesRuntimeError
   *
   * <p>this method occurs runtime error in the site. so have to figure it out in soon.
   *
   * @param subQuery
   * @return a number of pieces in subQuery
   */
  static int getNumberOfPiecesRuntimeError(String subQuery) {
    char prior = INIT_CHAR;
    int count = 1;
    int start = 1;
    int open = 0;

    if (!subQuery.equals("()")) {
      for (int i = 1; i < subQuery.length() - 1; i++) {
        char c = subQuery.charAt(i);

        if (prior == OPEN_BRACKET && c == CLOSE_BRACKET) {
          count++;
        }

        if (c == OPEN_BRACKET) {
          open++;
        } else {
          open--;
        }

        if (open == 0) {
          count += getNumberOfPiecesRuntimeError(subQuery.substring(start, i + 1));
          start = i + 1;
        }
        prior = c;
      } // for
    } else {
      count = 0;
    } // if-else

    return count;
  }

  /**
   *
   * Method Name: getNumberOfPiecesController
   *
   * <p>before calculate the number, pass the substrings to processing method in main query
   *
   * @param query
   * @return a number of pieces
   */
  static int getNumberOfPiecesController(String query) {
    int start = 0;
    int open = 0;
    int result = 0;

    for (int i = 0; i < query.length(); i++) {
      char c = query.charAt(i);

      if (c == OPEN_BRACKET) {
        open++;
      } else {
        open--;
      }

      if (open == 0){
        result += getNumberOfPiecesRuntimeError(query.substring(start, i + 1));
        start = i + 1;
      }
    }
    return result;
  }
  /**
   * Method Name: getNumberOfPiecesByBruteForce
   *
   * <p>over time limit
   *
   * @param query
   * @return a number of pieces
   */
  static int getNumberOfPiecesByBruteForce(String query) {
    LinkedList<Integer> stack = new LinkedList<>();
    char temp = INIT_CHAR;
    int result = 0;
    for (char c : query.toCharArray()) {
      if (c == OPEN_BRACKET) {
        if (temp == OPEN_BRACKET) {
          stack.add(1);
        }
      } else {
        // this is laser
        if (temp == OPEN_BRACKET) {
          for (int i = 0; i < stack.size(); i++) {
            stack.set(i, stack.get(i) + 1);
          }
        } else if(!stack.isEmpty()){
          result += stack.pop();
        }
      }
      temp = c;
    }
    return result;
  }

  /**
   *
   * Method Name: getNumberOfPiece
   *
   * <p>best practice
   *
   * @time-comflexity n
   * @param query
   * @return a number of pieces
   */
  static int getNumberOfPieces(String query) {
    int result = 0;
    int rod = 0;
    int open = 0;
    char priorChar = query.charAt(0);

    for(int i = 1; i < query.length(); i++) {
      char currChar = query.charAt(i);
      // check if it is laser
      if (priorChar == OPEN_BRACKET && currChar == CLOSE_BRACKET) {
        result += rod;
      } else if (priorChar == OPEN_BRACKET && currChar == OPEN_BRACKET) {
        rod++;
        result++;
      } if(priorChar == CLOSE_BRACKET && currChar == CLOSE_BRACKET) {
        rod--;
      }
      priorChar = currChar;
    }

    return result;
  }

  public static void main(String[] args) {
    try (
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
    ) {
      String query = in.nextLine();

      // validation
      assert (query.length() <= 100000 && query.length() > 0);

      out.println(getNumberOfPiecesByBruteForce(query));
      out.println(getNumberOfPiecesController(query));
      out.println(getNumberOfPieces(query));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
