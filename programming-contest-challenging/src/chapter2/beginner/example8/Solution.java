package chapter2.beginner.example8;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jsong on 11/04/2017.
 *
 * @hackerrank https://www.hackerrank.com/jsong00505
 * @backjoon https://www.acmicpc.net/user/jsong00505
 * @github https://github.com/jsong00505
 * @linkedin https://www.linkedin.com/in/junesongskorea/
 * @email jsong00505@gmail.com
 * @challenge Coins
 */
public class Solution {
  // total kind of coins
  static int COINS_KIND = 6;
  // values of coins
  static int[] COINS = {1, 5, 10, 50, 100, 500};

  /**
   * get a number of coins using greedy algorithm just grap a bigger value than others first
   *
   * @param coinWallet
   * @param targetAmount
   * @return a minimum number of coins to pay
   */
  static int getMinNumberOfCoinsToPay(int[] coinWallet, int targetAmount) {
    int numberOfCoins = 0;
    int amount = 0;

    for (int i = COINS_KIND - 1; i >= 0; i--) {
      for (int j = 0; j < coinWallet[i]; j++) {
        // check if the amount is over the target amount after addition of a coin
        if (amount + COINS[i] <= targetAmount) {
          amount += COINS[i];
          numberOfCoins++;
        } else {
          break;
        }
      }
    }

    return numberOfCoins;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out); ) {
      // declare variables
      int[] coinWallet = new int[COINS_KIND];
      int targetAmount;

      for (int i = 0; i < COINS_KIND; i++) {
        coinWallet[i] = in.nextInt();

        assert (coinWallet[i] >= 0 && coinWallet[i] <= 1000000000);
      }

      targetAmount = in.nextInt();
      assert (targetAmount >= 0 && targetAmount <= 1000000000 - 6565);

      out.println(getMinNumberOfCoinsToPay(coinWallet, targetAmount));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
