package com.ds.graph;

public class DFS {

    private static int r =8;
    private static int c =8;
    private static int[][] matrix = new int[r][c];
    private static int counter = 1;
    private static int[] dx = {0, 1 , 1, 1, 0, -1, -1, -1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) {

        int i=4;
        int j=4;
        doDfs(i, j);
        printMatrix();
    }

    private static void printMatrix() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void doDfs(int i, int j) {
        matrix[i][j] = counter++;

        for(int k=0; k<8; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];

            if(isValid(newI, newJ)) {
                doDfs(newI, newJ);
            }
        }
    }

    private static boolean isValid(int newI, int newJ) {
        return newI>=0 && newI< r && newJ>=0 && newJ<c  && matrix[newI][newJ] == 0;
    }
}
