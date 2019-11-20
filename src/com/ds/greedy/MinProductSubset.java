package com.ds.greedy;

public class MinProductSubset {

    public static void main(String[] args) {
        int[] arr = { -1, -1, -2, 4, 3 };
        int n = arr.length;

        System.out.println(findMinProduct(arr, n));
    }

    private static int findMinProduct(int[] arr, int n) {

        int positiveMin = Integer.MIN_VALUE;
        int negativeMax = Integer.MAX_VALUE;
        int product = 1;
        int countNegative = 0;
        int countZero = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                countZero++;
                continue;
            } else if (arr[i] < 0) {
                countNegative++;
                negativeMax = Math.max(negativeMax, arr[i]);
            } else if(arr[i] > 0) {
                if(arr[i] < positiveMin) {
                    positiveMin = arr[i];
                }
            }
            product = product * arr[i];
        }

        if(countZero == n || (countNegative == 0 && countZero>0)) {
            product = 0;
        }  else if (countNegative%2 == 0 && countNegative!=0) {
            product = product/negativeMax;
        }

        return product;
    }
}
