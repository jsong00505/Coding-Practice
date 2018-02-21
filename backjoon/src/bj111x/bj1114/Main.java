package bj111x.bj1114;

import java.io.PrintWriter;
import java.util.Scanner;

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
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
         PrintWriter out = new PrintWriter(System.out); ) {
      int l = in.nextInt();
      int k = in.nextInt();
      int c = in.nextInt();

      assert( l > 0 && l < 1000000000 );
      assert( k > 0 && k < 10000 );
      assert( c > 0 && c < 10000 );

      int middle = l / 2;

      int min = l;
      int max = -1;
      int sum = 0;
      boolean maxFLag = false;

      for( int i = 0; i < k; i++ ) {
        int position = in.nextInt();

        if( position > middle ) {
          if( max < position ) {
            max = position;
          }
          maxFLag = true;
        } else {
          if( min > position ) {
            min = position;
          }
          if( max < position ) {
            max = position;
          }
          if( !maxFLag ) {
            sum += position;
          }
        }
      }

      if( maxFLag ) {

      } else {

      }



    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
