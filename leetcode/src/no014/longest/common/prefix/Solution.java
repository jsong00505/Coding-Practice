package no014.longest.common.prefix;

import java.util.Arrays;

public class Solution {
  public static String longestCommonPrefix(String[] strs) {
    if(strs.length < 1) {
      return "";
    }

    Arrays.sort(strs, (o1, o2) -> {
      if(o1.length() > o2.length()) {
        return 1;
      } else if(o1.length() < o2.length()){
        return -1;
      } else {
        return o1.compareTo(o2);
      }
    });

    StringBuilder result = new StringBuilder(strs[0]);
    while(!"".equals(result.toString())) {
      boolean flag = true;
      for(String str: strs) {
        if(!str.startsWith(result.toString())) {
          result.delete(result.length() - 1, result.length());
          flag = false;
          break;
        }
      }
      if(flag) {
        break;
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[] {}));
    System.out.println(longestCommonPrefix(new String[] {""}));
    System.out.println(longestCommonPrefix(new String[] {"a", "b"}));
    System.out.println(longestCommonPrefix(new String[] {"a", "bc", "ab"}));
    System.out.println(longestCommonPrefix(new String[] {"hello", "hel", "hella", "he"}));
  }
}
