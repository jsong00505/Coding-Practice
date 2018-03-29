package no011.container.with.most.water;

import java.util.HashMap;

public class Solution {

  private static class Range {

    int min;
    int max;

    Range(int dot) {
      min = dot;
      max = dot;
    }

    void setRange(int dot) {

      if (max < dot) {
        max = dot;
      }
      if (min > dot) {
        min = dot;
      }
    }
  }

  public static int maxArea(int[] height) {

    int longest = height.length;
    int highest = 0;
    int maxArea = 0;

    HashMap<Integer, Range> map = new HashMap<>();
    for (int i = 0; i < longest; i++) {
      if(highest < height[i]) {
        highest = height[i];
      }
      if (map.containsKey(height[i])) {
        Range range = map.get(height[i]);
        range.setRange(i);
      } else {
        Range range = new Range(i);
        map.put(height[i], range);
      }
    }

    for (int i = longest; i > 0; i--) {
      int min = 0;
      int max = 0;
      boolean flag = true;
      for(int j = highest; j > 0; j--) {
        if( i * j < maxArea ) {
          break;
        }
        if(map.containsKey(j)) {
          Range range = map.get(j);
          if(min == 0 && max == 0 && flag) {
            min = range.min;
            max = range.max;
            flag = false;
          } else {
            if(range.min < min) {
              min = range.min;
            }
            if(range.max > max) {
              max = range.max;
            }
          }

          int length = max - min;
          int area = j * length;
          if(area > maxArea) {
            maxArea = area;
          }
        }
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    //System.out.println(maxArea(new int[]{1,2,3,4,1}));
    System.out.println(maxArea(new int[]{2,1}));
    //System.out.println(maxArea(new int[]{1,2,3,4,1,5}));
  }
}
