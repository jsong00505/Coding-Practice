package bj1081x.bj10815;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jsong on 19/02/2018.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Cards With Numbers
 */
public class Main {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
         PrintWriter out = new PrintWriter(System.out) ) {

      int n = in.nextInt();
      assert ( n >= 1 && n <= 500000 );

      Set<Integer> nNumbers = new HashSet<>();

      for( int i = 0; i < n; i++ ) {
        int number = in.nextInt();
        assert ( number > -10000000 && number < 10000000 );

        nNumbers.add( number );
      }

      int m = in.nextInt();
      assert ( m >= 1 && m <= 500000 );

      for( int i = 0; i < m; i++ ) {
        int number = in.nextInt();
        assert ( number > -10000000 && number < 10000000 );

        if( nNumbers.contains( number ) ) {
          out.print( "1 " );
        } else {
          out.print( "0 " );
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
