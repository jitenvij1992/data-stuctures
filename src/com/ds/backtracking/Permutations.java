package com.ds.backtracking;

/**
 * Find all the permutations of a string
 */

public class Permutations {

    public static void main(String[] args) {
        String s = "ABC";
        permutate(s, 0, s.length()-1);
    }

    private static void permutate(String s, int l, int r) {
        if(l == r) {
            System.out.println(s);
        } else {
            for(int i=l; i<=r; i++) {
                s = swap(s, l, i);
                permutate(s, l+1, r);
                s = swap(s, l, i);
            }
        }
    }

    private static String swap(String s, int l, int r) {
        char temp;
        char[] chars = s.toCharArray();
        temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        return String.valueOf(chars);
    }
}
