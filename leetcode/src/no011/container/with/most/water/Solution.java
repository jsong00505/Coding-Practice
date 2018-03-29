package no011.container.with.most.water;

public class Solution {

  /**
   * Retrieve max area by supplied integer array of height.
   *
   * Compare the very left point to the very right point at each moment and save the lower height to
   * retrieve area between left and right. Move the bigger side point to the middle point side of
   * both and set a bigger value as a current max area between the existed max area and the saved
   * area.
   *
   * @param height The array of height
   * @return A max area
   */
  public static int maxArea(int[] height) {

    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int lowerHeight;
      int length = right - left;
      if (height[left] < height[right]) {
        lowerHeight = height[left];
        left++;
      } else {
        lowerHeight = height[right];
        right--;
      }
      int area = lowerHeight * length;
      maxArea = maxArea < area ? area : maxArea;
    }

    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(4 == maxArea(new int[]{1, 2, 3, 4, 1}));
    System.out.println(1 == maxArea(new int[]{2, 1}));
    System.out.println(9 == maxArea(new int[]{1, 2, 3, 4, 1, 5}));
  }
}
