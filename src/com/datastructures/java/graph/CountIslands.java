package com.datastructures.java.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };



        CountIslands countIslands = new CountIslands();
        int s = countIslands.numIslands(grid);
        System.out.println(s);
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        s = countIslands.numIslands(grid);
        System.out.println(s);

        grid = new char[][]{{'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};
        s = countIslands.numIslands(grid);
        System.out.println(s);
    }


    public int numIslands(char[][] grid) {

        HashSet<String> visit = new  HashSet<String>();
        int cols = grid[0].length;
        int rows = grid.length;
        int counter = 0;
        for(int v=0;v<rows;v++){
            for(int e=0;e<cols;e++){
                if (grid[v][e] == '1' && !visit.contains(v+""+e)) {
                    bfs(v, e, grid, visit, cols, rows);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void bfs(int v, int e, char[][] grid, HashSet<String> visit, int cols, int rows){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(v,e));
        visit.add(v+""+e);
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            int[][] fourD = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            for(int i=0;i<4;i++){
                int newRow = row+fourD[i][0];
                int newCol = col+fourD[i][1];
                if(newRow<rows && newCol<cols && newRow>=0 && newCol>=0 &&
                        !visit.contains(newRow+""+newCol) &&  grid[newRow][newCol] == '1'){
                    visit.add(newRow+""+newCol);
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
