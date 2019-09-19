package com.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosestPointToOrigin {
	
	public static void main(String[] args) {
		KclosestPointToOrigin sol = new KclosestPointToOrigin();
		int[][] points = {{1,3},{-2,2}};
		int[][] op = sol.kClosest(points , 1);
		for(int i = 0 ; i < 1 ; i++) {
			System.out.println(op[i][0]+" "+op[i][1]);
		}
	}
	
	class Point{
        int x, y;
        Integer sum ;//= x+y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.sum = x+y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                if(o1 == o2){
                    return 0;
                }
                return o1.sum.compareTo(o2.sum);
            }
        });
        
        for( int i = 0 ; i < points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];
            q.add(new Point(x, y));
        }
        int[][] op = new int[K][2];
        for(int i = 0 ; i < K; i++){
            Point point = q.remove();
            op[i][0] = point.x;
            op[i][1] = point.y;
        }
        return op;
    }

}
