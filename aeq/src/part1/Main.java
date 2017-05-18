package part1;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created by jsong on 17/05/2017.
 *
 * @email jsong00505@gmail.com
 * @name the castle company
 */
public class Main {
  private static String INC = "increase";
  private static String DEC = "decrease";

  private static int getNumberOfCastle(int[] points) {
    // init the number of castle for return
    int numberOfCastle = 0;

    // declare stack for counting the number
    LinkedList<String> stack = new LinkedList<>();

    // if one point in array, it should return 1
    // that's because there is the only one peak to build on a castle
    if (points.length == 1) {
      return 1;
    }

    // declare and init
    int firstPoint = points[0];
    int secondPoint;

    // iteration from the third point
    for (int i = 1; i < points.length; i++) {
      secondPoint = points[i];

      // the stack will be empty in only first time to check
      if (stack.isEmpty()) {
        // check it the second point is bigger or not
        if (secondPoint > firstPoint) {
          stack.add(INC);
        } else if (secondPoint < firstPoint) {
          stack.add(DEC);

          // if the first status is decrease, the first point should be a peak
          numberOfCastle++;
        } // if-else
      } else {
        String lastStatus = stack.getLast();

        // check it the second point is bigger or not
        if (secondPoint > firstPoint) {
          // if last status is increase and current status is decrease,
          // the first point should be a valley
          if (lastStatus.equals(DEC)) {
            numberOfCastle++;
            stack.removeLast();
            stack.addLast(INC);
          }
        } else if (secondPoint < firstPoint) {
          // if last status is decrease and current one is increase,
          // the first point should be a peak
          if (lastStatus.equals(INC)) {
            numberOfCastle++;
            stack.removeLast();
            stack.addLast(DEC);
          }
        } // if-else
      } // if-else

      if ((i == points.length - 1)) {
        if (stack.isEmpty()) {
          // if the point is the last one and the stack is empty, the series of integer have same values
          // so that could be a peak
          numberOfCastle++;
        } else if (stack.getLast().equals(INC)) {
          // if the point is the last one and the status is increase, it should be a peak
          numberOfCastle++;
        }
      } // if

      // set the first point to the second point for the next
      firstPoint = secondPoint;
      //System.out.println(numberOfCastle);
    } // for

    return numberOfCastle;
  }

  public static void main(String args[]) {
    try (PrintWriter out = new PrintWriter(System.out)) {
      // given array
      int[] points = {6, 6, 6, 5};

      // the array should not be empty, so check it first
      if (points.length < 1) {
        throw new Exception("An empty array is not acceptable");
      } else {
        // print out the number of castle
        out.println("the number of castle: " + getNumberOfCastle(points));
      }
    } catch (Exception e) {
      System.err.println(e.toString());
    } // try-catch
  }
}
