package no005.longest.palindrom.substring;

/**
 * Created by jsong on 28/03/2018.
 *
 * Longest Palindrome Substring
 */
public class Solution {

  /**
   * Validate if the substring of s is a palindrome string between supplied indexs.
   *
   * @param s A string
   * @param start A start index
   * @param end A end index
   * @return {@link true} If it is a palindrome string or {@link false} if not. If the length is 1 it
   *     treats as like a palindrome string.
   */
  public static boolean isPalindrome(String s, int start, int end) {
    int length = end - start + 1;
    if (length == 1) {
      return true;
    }
    if (s.charAt(start) == s.charAt(end)) {
      return length == 2 || isPalindrome(s, start + 1, end - 1);
    }
    return false;
  }

  public static String longestPalindrome(String s) {
    int length = s.length();
    for (int i = length - 1; i > 0; i--) {
      for (int j = 0; j <= length - i - 1; j++) {
        if (isPalindrome(s, j, j + i)) {
          return s.substring(j, j + i + 1);
        }
      }
    }
    return s.substring(0, 1);
  }

  public static void main(String[] args) {
    System.out.println("bab".equals(longestPalindrome("babad")));
    System.out.println("aba".equals(longestPalindrome("aba")));
    System.out.println("bb".equals(longestPalindrome("cbbd")));
    System.out.println("a".equals(longestPalindrome("abcde")));
  }
}
