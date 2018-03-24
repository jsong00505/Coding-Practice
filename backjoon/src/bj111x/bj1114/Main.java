package bj111x.bj1114;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by jsong on 20/02/2018.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Slice Logs
 */
public class Main {
  // define as a global in the class since I don't want to use this repeatedly for API
  private static int l;
  private static int k;
  private static int c;
  private static List<Integer> POSITIONS;

  // final result
  private static int LONGEST_STICK = 0;
  private static int FIRST_CUT_POSITION = 0;

  public static void getBest(LinkedList<Integer> sticks) {

    int veryFirst;
    int first;
    int second;
    int stick;
    int longest;

    veryFirst = sticks.remove();
    first = veryFirst;
    second = veryFirst;
    longest = veryFirst;

    while (!sticks.isEmpty()) {
      second = sticks.remove();
      stick = second - first;
      if (stick > LONGEST_STICK && LONGEST_STICK != 0) {
        return;
      }
      if (longest < stick) {
        longest = stick;
      }
      first = second;
    }
    stick = l - second;
    if (longest < stick) {
      longest = stick;
    }

    if (longest < LONGEST_STICK || LONGEST_STICK == 0) {
      LONGEST_STICK = longest;
      FIRST_CUT_POSITION = veryFirst;
    }
    System.out.println(longest + " " + veryFirst);
  }

  public static void cutLog(LinkedList<Integer> sticks, int index) {

    // check if the number of cut is over
    if (sticks.size() == c) {
      getBest(sticks);
      return;
    }

    while (index < k) {
      LinkedList<Integer> copy = (LinkedList<Integer>) sticks.clone();
      copy.add(POSITIONS.get(index));
      if (copy.size() > 1 && index != k) {
        if (copy.getLast() - copy.get(copy.size() - 2) > LONGEST_STICK && LONGEST_STICK != 0) {
          return;
        }
      } else if (copy.size() == 1 && LONGEST_STICK != 0) {
        if (copy.getFirst() >= LONGEST_STICK) {
          return;
        }
      } else if (k - index < c - sticks.size()) {
        return;
      }

      cutLog(copy, ++index);
    }
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      l = in.nextInt();
      k = in.nextInt();
      c = in.nextInt();

      assert (l > 0 && l < 1000000000);
      assert (k > 0 && k < 10000);
      assert (c > 0 && c < 10000);

      POSITIONS = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        int position = in.nextInt();
        assert (position > l);
        POSITIONS.add(position);
      }

      // sort
      Collections.sort(POSITIONS);

      // create an empty sticks
      LinkedList<Integer> sticks = new LinkedList<>();

      // call the API to retrieve the best answer
      cutLog(sticks, 0);

      out.println(LONGEST_STICK + " " + FIRST_CUT_POSITION);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
