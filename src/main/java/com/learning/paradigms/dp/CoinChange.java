package com.learning.paradigms.dp;

public class CoinChange {
	
	public static int calculateChange(int[] coins, int change) {
		int totalCoins = coins.length;
		int[] changeArr = new int[change+1];
		changeArr[0]=1;
		for(int i=0;i<totalCoins;i++) {
			for(int j=coins[i];j<=change;j++) {
				changeArr[j] += changeArr[j-coins[i]];
			}
		}
		return changeArr[change];
	}
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3};
		int change = 4;
		System.out.println(calculateChange(coins, change));
	}

}
