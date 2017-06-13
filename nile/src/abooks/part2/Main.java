package abooks.part2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jsong on 12/06/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge
 */
public class Main {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  // RETURN AN EMPTY MATRIX IF PREFERRED LUNCH IS NOT FOUND
  public String[][] matchLunches(String[][] lunchMenuPairs,
                                 String[][] teamCuisinePreference)
  {
    // WRITE YOUR CODE HERE

    // MAPPER FOR OPTIMIZATION
    HashMap<String, ArrayList<String>> lunchMenuMapper = new HashMap<>();

    for (int i = 0; i < lunchMenuPairs.length; i++) {
      String country = lunchMenuPairs[i][1];
      String menu = lunchMenuPairs[i][0];

      // CHECK IF THE COUNTRY IS CONTAINED OR NOT IN MAPPER
      if (lunchMenuMapper.containsKey(country)) {
        ArrayList<String> list = lunchMenuMapper.get(country);
        list.add(menu);
        lunchMenuMapper.put(country, list);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(menu);
        lunchMenuMapper.put(country, list);
      } // IF-ELSE ENDS
    } // FOR ENDS

    // GET TOTAL NUMBER OF ORDERS
    int totalOrders = 0;
    for (int i = 0; i < teamCuisinePreference.length; i++) {
      String country = teamCuisinePreference[i][1];

      if (country.equals("*")) {
        totalOrders += lunchMenuPairs.length;
      } else {
        ArrayList<String> food = lunchMenuMapper.get(country);
        if (food != null) {
          totalOrders += food.size();
        }

      } // IF-ELSE ENDS
    } // FOR ENDS

    // DECLARE RETURN ARRAY
    String[][] result = new String[totalOrders][2];

    // ITEM INDEX
    int cumOrders = 0;

    for (int i = 0; i < teamCuisinePreference.length; i++) {
      String country = teamCuisinePreference[i][1];
      String name = teamCuisinePreference[i][0];

      if (country.equals("*")) {
        for (int j = 0; j < lunchMenuPairs.length; j++) {
          result[cumOrders][0] = name;
          result[cumOrders][1] = lunchMenuPairs[j][0];

          cumOrders++;
        } // FOR ENDS
      } else {
        ArrayList<String> food = lunchMenuMapper.get(country);

        // CAN ADD ORDER WHEN THE FOOD IS NOT NULL
        if (food != null) {
          for (String f: food) {
            result[cumOrders][0] = name;
            result[cumOrders][1] = f;

            cumOrders++;
          } // FOR ENDS
        } // IF ENDS
      } // IF-ELSE ENDS
    } // FOR ENDS

    return result;
  }
  public static void main(String[] args) {

  }
}
