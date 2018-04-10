package no001.two.sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numsMap.containsKey(complement)) {
        return new int[]{i, numsMap.get(complement)};
      }
      numsMap.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
