package bj286x.bj2860;

import java.io.PrintWriter;
import java.util.HashMap;
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
 * @challenge Write Numbers
 */
class Numbers {
  private int one;
  private int two;
  private int three;
  private int four;
  private int five;
  private double average;

  Numbers(int one, int two, int three, int four, int five) {
    this.one = one;
    this.two = two;
    this.three = three;
    this.four = four;
    this.five = five;

    calculateAverage();
  }

  private void calculateAverage() {
    average = (one * 1 + two * 2 + three * 3 + four * 4 + five * 5);
    average = average / (one + two + three + four + five);
  }

  public int getOne() {
    return one;
  }

  public int getTwo() {
    return two;
  }

  public int getThree() {
    return three;
  }

  public int getFour() {
    return four;
  }

  public int getFive() {
    return five;
  }

  public double getAverage() {
    return average;
  }
}

public class Main {
  static int ONE = 0;
  static int TWO = 1;
  static int THREE = 2;
  static int FOUR = 3;
  static int FIVE = 4;

  /**
   * @way-of-solution full-search
   * @param p
   * @return
   */
  static int[] getNumbersOnPapersByFullSearch(double p) {
    LinkedList<Numbers> queue = new LinkedList<>();
    HashMap<Double, Boolean> visited = new HashMap<>();

    int[] result = {0, 0, 0, 0, 0};
    queue.add(new Numbers(result[ONE], result[TWO], result[THREE], result[FOUR], result[FIVE]));

    while (!queue.isEmpty()) {
      Numbers numbers = queue.removeFirst();
      result[ONE] = numbers.getOne();
      result[TWO] = numbers.getTwo();
      result[THREE] = numbers.getThree();
      result[FOUR] = numbers.getFour();
      result[FIVE] = numbers.getFive();
      double average = numbers.getAverage();

      if (average == p) {
        break;
      }

      // one
      Numbers temp =
          new Numbers(result[ONE] + 1, result[TWO], result[THREE], result[FOUR], result[FIVE]);
      if (temp.getAverage() <= 5 && !visited.containsKey(temp.getAverage())) {
        queue.add(temp);
        visited.put(temp.getAverage(), true);
      }

      // two
      temp = new Numbers(result[ONE], result[TWO] + 1, result[THREE], result[FOUR], result[FIVE]);
      if (temp.getAverage() <= 5 && !visited.containsKey(temp.getAverage())) {
        queue.add(temp);
        visited.put(temp.getAverage(), true);
      }
      // three
      temp = new Numbers(result[ONE], result[TWO], result[THREE] + 1, result[FOUR], result[FIVE]);
      if (temp.getAverage() <= 5 && !visited.containsKey(temp.getAverage())) {
        queue.add(temp);
        visited.put(temp.getAverage(), true);
      }
      // four
      temp = new Numbers(result[ONE], result[TWO], result[THREE], result[FOUR] + 1, result[FIVE]);
      if (temp.getAverage() <= 5 && !visited.containsKey(temp.getAverage())) {
        queue.add(temp);
        visited.put(temp.getAverage(), true);
      }
      // five
      temp = new Numbers(result[ONE], result[TWO], result[THREE], result[FOUR], result[FIVE] + 1);
      if (temp.getAverage() <= 5 && !visited.containsKey(temp.getAverage())) {
        queue.add(temp);
        visited.put(temp.getAverage(), true);
      }
    }

    return result;
  }

  /**
   * the solution Goo9 thought
   *
   * @param p
   * @return
   */
  static long[] getNumbersOnPapers(String p) {
    long[] result = {0, 0, 0, 0, 0};

    String[] parts = p.split("\\.");

    int integerPart = Integer.parseInt(parts[0]);
    long fractionalPart = Integer.parseInt(parts[1]);

    long firstNumber = fractionalPart;
    long secondNumber = 1L;
    for (int i = 0; i < parts[1].length(); i++) {
      secondNumber *= 10L;
    }

    while ((firstNumber % 2 == 0 && secondNumber % 2 == 0)
        || (firstNumber % 5 == 0 && secondNumber % 5 == 0)) {
      if (firstNumber % 2 == 0 && secondNumber % 2 == 0) {
        firstNumber /= 2;
        secondNumber /= 2;
      }

      if (firstNumber % 5 == 0 && secondNumber % 5 == 0) {
        firstNumber /= 5;
        secondNumber /= 5;
      }
    }

    if (integerPart < 5) {
      result[integerPart] = firstNumber;
    }

    if (integerPart > 0) {
      result[integerPart - 1] = secondNumber - firstNumber;
    }

    return result;
  }

  /**
   * TODO
   * (n1 + 2 * n2 + 3 * n3 + 4 * n4 + 5 * n5) / n = P
   * (n1 + 2 * n2 + 3 * n3 + 4 * n4 + 5 * n5) = n * P
   * (n1 + 2 * n2 + 3 * n3 + 4 * n4 + 5 * n5) = n * (a / b)
   */
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // double p = in.nextDouble();
      String p = in.nextLine();

      long[] result = getNumbersOnPapers(p);

      for (int i = 0; i < result.length; i++) {
        out.print(result[i] + " ");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
