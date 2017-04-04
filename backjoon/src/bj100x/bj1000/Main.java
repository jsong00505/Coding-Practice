package bj100x.bj1000;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 29/03/2017.
 *
 * @hackerrank  https://www.hackerrank.com/jsong00505
 * @backjoon    https://www.acmicpc.net/user/jsong00505
 * @github      https://github.com/jsong00505
 * @linkedin    https://www.linkedin.com/in/junesongskorea/
 * @email       jsong00505@gmail.com
 *
 * @challenge   A+B
 */
public class Main {
  public static void main(String[] args) {
    // declare Scanner and PrintWriter
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // declare a and b
    int a = in.nextInt();
    int b = in.nextInt();

    // constraints
    assert (a > 0 && a < 10 && b > 0 && b < 10);

    // print a + b
    out.println(a + b);

    // close
    in.close();
    out.close();
  }
}
