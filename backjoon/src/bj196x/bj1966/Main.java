package bj196x.bj1966;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 09/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Printer Queue
 */
class Job {
  private int position;
  private int priority;

  Job(int position, int priority) {
    this.position = position;
    this.priority = priority;
  }

  public int getPosition() {
    return position;
  }

  public int getPriority() {
    return priority;
  }
}
public class Main {
  /**
   * debugging method that print out all elements in Linked List
   *
   * @param queue
   */
  static void print(LinkedList<Job> queue) {
    System.out.println("==============START==============");
    for(Job j: queue) {
      System.out.print("(" + j.getPosition() + ", " + j.getPriority() + ",) ");
    }
    System.out.println();
    System.out.println("==============END==============");
  }

  /**
   *
   * @param n
   * @param m
   * @param queue
   * @return the number of minutes until the job is completely printed
   */
  static int printerQueue(int n, int m, LinkedList<Job> queue) {
    int minutes = 1;
    boolean canPrint;

    while(true) {
      // job might be printed this time
      Job target = queue.get(0);

      // true if the job can be printed
      canPrint = true;


      for(int i = 1; i < queue.size(); i++) {
        // job compared with the target job
        Job curr = queue.get(i);

        // if a priority of the current job is higher than target's, the target cannot be printed this time
        if(target.getPriority() < curr.getPriority()) {
          queue.removeFirst();
          queue.add(target);
          canPrint = false;
          break;
        }
      }

      if(canPrint) {
        Job printedJob = queue.removeFirst();

        // if a position of the job is the one which we find, just get out of this loop
        if(printedJob.getPosition() == m) {
          break;
        } else {
          minutes++;
        }
      }
    }

    return minutes;
  }
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int testCase = in.nextInt();

      for(int i = 0; i < testCase; i++) {
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList<Job> queue = new LinkedList<>();

        assert(n >= 1 && n <= 100 && m >= 0 && m < n);

        for(int j = 0; j < n; j++) {
          queue.add(new Job(j, in.nextInt()));
        }
        out.println(printerQueue(n, m, queue));
      }

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
