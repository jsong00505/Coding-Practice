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

    HashMap<List<Integer>, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < length - 1; i++) {
      for (int j = i; j < length; j++) {
        List<Integer> twoNumbs = new ArrayList<>();
        twoNumbs.add(nums[i]);
        twoNumbs.add(nums[j]);
        List<Integer> indices = new ArrayList<>();
        indices.add(i);
        indices.add(j);
        map.put(twoNumbs, indices);
      }
    }

    List<List<Integer>> result = new ArrayList<>();
    for (List<Integer> key : map.keySet()) {
      List<Integer> indices = map.get(key);
      int sum = key.get(0) + key.get(1);
      for (int i = 0; i < length; i++) {
        if (i == indices.get(0) || i == indices.get(1)) {
          continue;
        }
        if (sum + nums[i] == 0) {
          List<Integer> candidate = new ArrayList<>(key);
          candidate.add(nums[i]);
          Collections.sort(candidate);
          if (!result.contains(candidate)) {
            result.add(candidate);
          }
          break;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    threeSum(new int[]{1, 1, 1, 1, 0, -1});
  }
}
