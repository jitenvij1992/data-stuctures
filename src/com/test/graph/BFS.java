package com.test.graph;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    private static int[] dx = {0, 1 , 1, 1, 0, -1, -1, -1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int r =8;
    private static int c =8;
    private static int[][] mat = new int[r][c];
    public static void main(String[] args) {

        doBFS(mat, 4, 4, r, c);
        printMat(mat);

    }

    private static void printMat(int[][] mat) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c ; j++) {
                System.out.printf("%3d", mat[i][j]);
            }
            System.out.println();
        }
    }

    private static void doBFS(int[][] mat, int i, int j, int r, int c) {

        Queue<Point> queue = new LinkedList<>();
        int counter = 1;
        queue.add(new Point(i, j));
        mat[i][j] = counter++;

        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            int x = (int) poll.getX();
            int y = (int) poll.getY();
            for(int k=0; k<8; k++) {
                int newI = x + dx[k];
                int newJ = y + dy[k];
                if(isValid(newI, newJ, r, c)) {
                    queue.add(new Point(newI, newJ));
                    mat[newI][newJ] = counter++;
                }
            }
        }
    }

    private static boolean isValid(int newI, int newJ, int r, int c) {
        return newI>=0 && newI<r && newJ>=0 && newJ<c && mat[newI][newJ] == 0;
    }
}
