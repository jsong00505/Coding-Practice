package bj901x.bj9019;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jsong on 14/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge DSLR
 */
class CommandList {
  private String commands;
  private int value;

  CommandList(String commands, int value) {
    this.commands = commands;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getCommands() {
    return commands;
  }
}

public class Main {
  // type of commands
  static char D = 'D';
  static char S = 'S';
  static char L = 'L';
  static char R = 'R';

  /**
   * update a value by command D : increase twice S : decrease one L : left shift R : right shift
   *
   * @param value
   * @param command
   * @return a updated value
   */
  static int updateValueByCommand(int value, char command) {
    int result;

    if (command == D) {
      result = (value * 2) % 10000;
    } else if (command == S) {
      result = value - 1;
    } else if (command == L) {
      int firstDigit = value / 1000;
      int secondDigit = (value % 1000) / 100;
      int thirdDigit = (value % 100) / 10;
      int lastDigit = value % 10;
      result = secondDigit * 1000 + thirdDigit * 100 + lastDigit * 10 + firstDigit;
    } else if (command == R) {
      int firstDigit = value / 1000;
      int secondDigit = (value % 1000) / 100;
      int thirdDigit = (value % 100) / 10;
      int lastDigit = value % 10;

      result = lastDigit * 1000 + firstDigit * 100 + secondDigit * 10 + thirdDigit;
    } else {
      result = -1;
    }

    if (result == -1) {
      result = 9999;
    }

    return result;
  }

  /**
   * get the minimum commands
   *
   * @param initValue
   * @param targetValue
   * @return commands
   */
  static String getMinCommands(int initValue, int targetValue) {
    String result;
    LinkedList<CommandList> queue = new LinkedList<>();
    HashMap<Integer, Boolean> visited = new HashMap<>();
    int temp;
    // init
    queue.add(new CommandList("", initValue));
    visited.put(initValue, true);

    while (true) {
      CommandList commandList = queue.removeFirst();
      //System.out.println(commandList.getCommands() + " >> " + commandList.getValue());
      if (targetValue == commandList.getValue()) {
        result = commandList.getCommands();
        break;
      }

      // D
      temp = updateValueByCommand(commandList.getValue(), D);
      if (!visited.containsKey(temp)) {
        visited.put(temp, true);
        String initString = commandList.getCommands();
        queue.add(new CommandList(initString + D, temp));
        //System.out.println("D >> " + temp);
      }
      // S
      temp = updateValueByCommand(commandList.getValue(), S);
      if (!visited.containsKey(temp)) {
        visited.put(temp, true);
        String initString = commandList.getCommands();
        queue.add(new CommandList(initString + S, temp));
        //System.out.println("S >> " + temp);
      }
      // L
      temp = updateValueByCommand(commandList.getValue(), L);
      if (!visited.containsKey(temp)) {
        visited.put(temp, true);
        String initString = commandList.getCommands();
        queue.add(new CommandList(initString + L, temp));
        //System.out.println("L >> " + temp);
      }
      // R
      temp = updateValueByCommand(commandList.getValue(), R);
      if (!visited.containsKey(temp)) {
        visited.put(temp, true);
        String initString = commandList.getCommands();
        queue.add(new CommandList(initString + R, temp));
        //System.out.println("R >> " +temp);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      int t = in.nextInt();

      for (int i = 0; i < t; i++) {
        int initValue = in.nextInt();
        int targetValue = in.nextInt();

        out.println(getMinCommands(initValue, targetValue));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
