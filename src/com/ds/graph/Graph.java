package com.ds.graph;

public class Graph {

    public static void main(String[] args) {

        int[][] input = {{1,0},{1,1}};
        getCountOfPath(input, input.length);
        
    }

    private static int getCountOfPath(int[][] input, int m, int n) {

        int ai=0, aj=0;
        if(input[0][0] == 0 || input[m-1][n-1] == 0){
            return 0;
        }
        for (int i = 1; i < m-1; i++){
            
        }
    }

}
