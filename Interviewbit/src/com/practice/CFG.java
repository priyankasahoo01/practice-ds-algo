package com.practice;

import java.util.ArrayDeque;
import java.util.Deque;
//Java implementation of the approach 
import java.util.Stack; 

public class CFG 
{ 
	
	public static int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> s = new ArrayDeque<>();
        s.push(0);
        int[] op = new int[A.length - B +1];
        for(int i = 1 ; i < B; i++){
            while(!s.isEmpty() && A[i] >= A[s.peekLast()]){
                s.pollLast();
            }
            s.addLast(i);
        }
        int k = 0;
        op[k++] = A[s.peekFirst()];
        
        for(int i = B ; i < A.length; i++){
            if(s.peekFirst() < k){
                s.pop();
            }
            while(!s.isEmpty() && A[i] >= A[s.peekLast()]){
                s.pollLast();
            }
            s.addLast(i);
            System.out.println("k is : "+k);
            op[k++] = A[s.peekFirst()];
            
        }
        
        return op;
        
    }

	// Function to print the maximum for 
	// every k size sub-array 
	static void print_max(int a[], int n, int k) 
	{ 
		// max_upto array stores the index 
		// upto which the maximum element is a[i] 
		// i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i] 

		int[] max_upto = new int[n]; 

		// Update max_upto array similar to 
		// finding next greater element 
		Stack<Integer> s = new Stack<>(); 
		s.push(0); 
		for (int i = 1; i < n; i++) 
		{ 
			while (!s.empty() && a[s.peek()] < a[i]) 
			{ 
				max_upto[s.peek()] = i - 1; 
				s.pop(); 
			} 
			s.push(i); 
		} 
		while (!s.empty()) 
		{ 
			max_upto[s.peek()] = n - 1; 
			s.pop(); 
		} 
		int j = 0; 
		for (int i = 0; i <= n - k; i++) 
		{ 

			// j < i is to check whether the 
			// jth element is outside the window 
			while (j < i || max_upto[j] < i + k - 1) 
			{ 
				j++; 
			} 
			System.out.print(a[j] + " "); 
		} 
		System.out.println(); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5}; 
		int n = a.length; 
		int k = 3; 
		//print_max(a, n, k); 
		int A[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; 
		
		int[] op = slidingMaximum(A, 2);
		System.out.println("result -> ");
		for(int i : op) {
			System.out.println(i);
		}
		
		System.out.println(op);

	} 
} 

//This code has been contributed by 29AjayKumar 
