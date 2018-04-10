package no015.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

  public static List<List<Integer>> threeSum(int[] nums) {

    int length = nums.length;
    Arrays.sort(nums);

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        List<Integer> twoNumbs;
        if(map.containsKey(nums[j])) {
          List<Integer> candidate =new ArrayList<>(map.get(nums[j]));
          candidate.add(nums[j]);
          Collections.sort(candidate);
          if (!result.contains(candidate)) {
            result.add(candidate);
          }
        } else {
          int complement = (-1) * (nums[i] + nums[j]);
          twoNumbs = new ArrayList<>();
          twoNumbs.add(nums[i]);
          twoNumbs.add(nums[j]);
          map.put(complement, twoNumbs);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    //System.out.println(threeSum(new int[]{1, 1, 1, 1, 0, -1})); // [[-1, 0, 1]]
    System.out.println(threeSum(new int[]{1, 2, -2, -1}));      // []
  }
}
