package com.problem;

public class CombinationNCK {
    
    public static void main(String[] args) {
        int n=20, k=10;
        int prod = multiplyRange(n-k+1,n);
        System.out.println(prod);
        int f = fact(k);
        System.out.println(f);
        int result = (prod/f);
        System.out.println(result);
    }
    
    private static int fact(int k){
        if(k <=1 ){return 1;}
        return k * fact(k-1);
    }
    
    private static int multiplyRange(int n, int k){
        int prod =1;
        for(int i =n; i<=k;i++){
            prod=prod*i;
        }
        return prod;
    }

}
