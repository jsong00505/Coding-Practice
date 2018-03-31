package no012.integer.to.roman;

import java.util.ArrayList;

public class Solution {
  /**
   * Roman Numerals
   * --|------|------|------|------|
   * 1 |    M |    C |    X |    I |
   * --|------|------|------|------|
   * 2 |   MM |   CC |   XX |   II |
   * --|------|------|------|------|
   * 3 |  MMM |  CCC |  XXX |  III |
   * --|------|------|------|------|
   * 4 |      |   CD |   XL |   IV |
   * --|------|------|------|------|
   * 5 |      |    D |    L |    V |
   * --|------|------|------|------|
   * 6 |      |   DC |   LX |   VI |
   * --|------|------|------|------|
   * 7 |      |  DCC |  LXX |  VII |
   * --|------|------|------|------|
   * 8 |      | DCCC | LXXX | VIII |
   * --|------|------|------|------|
   * 9 |      |   CM |   XC |   IX |
   * --|------|------|------|------|
   */
  public static String intToRoman(int num) {
    ArrayList<String> thousands = new ArrayList<>();
    thousands.add("");
    thousands.add("M");
    thousands.add("MM");
    thousands.add("MMM");
    ArrayList<String> hundreds = new ArrayList<>();
    hundreds.add("");
    hundreds.add("C");
    hundreds.add("CC");
    hundreds.add("CCC");
    hundreds.add("CD");
    hundreds.add("D");
    hundreds.add("DC");
    hundreds.add("DCC");
    hundreds.add("DCCC");
    hundreds.add("CM");
    ArrayList<String> tens = new ArrayList<>();
    tens.add("");
    tens.add("X");
    tens.add("XX");
    tens.add("XXX");
    tens.add("XL");
    tens.add("L");
    tens.add("LX");
    tens.add("LXX");
    tens.add("LXXX");
    tens.add("XC");
    ArrayList<String> ones = new ArrayList<>();
    ones.add("");
    ones.add("I");
    ones.add("II");
    ones.add("III");
    ones.add("IV");
    ones.add("V");
    ones.add("VI");
    ones.add("VII");
    ones.add("VIII");
    ones.add("IX");

    StringBuilder result = new StringBuilder();
    int index = 0;
    while(num > 0) {
      String roman = "";
      int digit = num % 10;
      switch (index++) {
        case 0:
          roman = ones.get(digit);
          break;
        case 1:
          roman = tens.get(digit);
          break;
        case 2:
          roman = hundreds.get(digit);
          break;
        case 3:
          roman = thousands.get(digit);
          break;
      }
      result.insert(0, roman);
      num /= 10;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println("X".equals(intToRoman(10)));
    System.out.println("DLV".equals(intToRoman(555)));
  }
}
