package rakuten;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 2+('7'-'0');
		System.out.println(num);
		
		Practice sol = new Practice();
		int[] A= {1, 3, 6, 4, 1, 2} ;
		int op = sol.solution(A);
		System.out.println("op -> "+op);
		
		
		sol.sqrt(64);
	}
	
	public int sqrt(int n) {
		System.out.println(Math.sqrt(n)%1 ==0);
		System.out.println(Math.sqrt(60)%1 == 0);
		
		return 0;
	}
	public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if(A[A.length-1] < 1){
            return 1;
        }
        int op = 1;
        for(int n : A){
            if(op < n){
                continue;
            }else if( op == n){
                op++;
            }else{
                return op;
            }
        }
        return op;
    }

}
