package no014.longest.common.prefix;

import java.util.Arrays;

public class Solution {

  public static String longestCommonPrefix(String[] strs) {

    // defensive code
    if (strs.length < 1) {
      return "";
    }

    // sort for optimization. O(nlogn)
    Arrays.sort(strs);

    // only compare the first string to last string since the array is sorted. O(length(first))
    StringBuilder result = new StringBuilder("");
    String first = strs[0];
    String last = strs[strs.length - 1];
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != last.charAt(i)) {
        break;
      } else {
        result.append(first.charAt(i));
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println("".equals(longestCommonPrefix(new String[]{})));
    System.out.println("".equals(longestCommonPrefix(new String[]{""})));
    System.out.println("".equals(longestCommonPrefix(new String[]{"a", "b"})));
    System.out.println("".equals(longestCommonPrefix(new String[]{"a", "bc", "ab"})));
    System.out
        .println("a".equals(longestCommonPrefix(new String[]{"acd", "abcdef", "acde", "acdef"})));
    System.out
        .println("he".equals(longestCommonPrefix(new String[]{"hello", "hel", "hella", "he"})));
  }
}
