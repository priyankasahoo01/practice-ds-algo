package com.practice;

public class SpiralMatrix {
	static int[] spiralCopy(int[][] mat) {
	    // your code goes here
	    int[] op = new int[mat.length * mat[0].length];
	    int k = 0;
	    int rstart = 0, rend = mat.length-1;
	    int cstart = 0, cend = mat[0].length-1;
	    while( cstart <= cend && rstart<=rend ){
	        if(cend >= cstart) {
	        	for( int i = cstart ; i <= cend ; i++ ){
	  	          op[k++] = mat[rstart][i];
	  	        }
	  	        rstart++;
	        }
	        
	        if(rend >= rstart) {
		        for( int i = rstart ; i <= rend ; i++ ){
		          op[k++] = mat[i][cend];
		        }
		        cend--;
	        }
	        if(cend >= cstart) {
	        	for( int i = cend ; i >= cstart ; i-- ){
	  	          op[k++] = mat[rend][i];
	  	        }
	  	        rend--;
	        }
	        
	        if(rend >= rstart) {
	        	for( int i = rend ; i >= rstart ; i-- ){
	  	          op[k++] = mat[i][cstart];
	  	        }
	  	        cstart++;
	        }
	        
	      }
	    
	    return op;
	  }

	  public static void main(String[] args) {
		  int[][] mat = new int[][]{{1},{2}};
//		  test(mat);
//		  test(new int[][]{ {1,    2,   3,  4,    5},
//              {6,    7,   8,  9,   10},
//              {11,  12,  13,  14,  15},
//              {16,  17,  18,  19,  20} });
		  test(new int[][] {{1,2}});
	  }

	private static void test(int[][] mat) {
		System.out.println("print: -> \n");
		int[] op = spiralCopy(mat);
		  for(int i : op) {
			  System.out.print(i+" , ");
		  }
		  System.out.println();
	}

}
