package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FrogJump {
		
    class Input{
        int i , step;
        Input(int i, int step){
            this.i = i;
            this.step = step;
        }
    }
    
    
    public boolean canCross(int[] stones) {
        Map<Input, Boolean> map = new HashMap<>();
        //
        
        int start = 0;
        int step = 1;
        
        Set<Integer> set = new HashSet<>();
        for(int stone : stones) {
        	set.add(stone);
        }
        for( int i = stones[start]+step-1 ; i <= stones[start]+step+1; i++) {
        	if(step == 0 ) {
        		continue;
        	}
        	if( i == stones[stones.length-1] ) {
        		return true;
        	}
        	if(set.contains(i)) {
        		start = 
        	}
        	
        }
        
        
        //
        
        return func(stones, 0, 1, map);
    }
    
    
    private boolean func(int[] stones, int i, int step, Map<Input, Boolean> map){//arr, 0, 1
        if ( i == stones.length-1){
            return true;
        }
        if(step <= 0 || i < 0){
            return false;
        }
        //int k = i+1;
        Input ip = new Input(i, step);
        if(map.get(ip) != null){
            return map.get(ip);
        }
        
        int k = search(stones, i+1, stones[i]+step);
        if(k != -1){
            boolean valid =  (step >1 ? func( stones, k, step-1, map) : false) ||
                    func( stones, k, step, map) || 
                    func( stones, k, step+1, map);
                map.put(ip, valid);
            return valid;
        }
        
        map.put(ip, false);
        return false;
    }
    
    private int search( int[] arr, int start, int val){
        int l = start, r = arr.length-1;
        while( l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == val){
                return mid;
            }else if( arr[mid] > val ){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        Arrays.bin
        return -1;
    }
    
    
    
    ///
//    class Solution {
//        class Input{
//            int i , step;
//            Input(int i, int step){
//                this.i = i;
//                this.step = step;
//            }
//        }
//        public boolean canCross(int[] stones) {
//            //Map<Input, Boolean> map = new HashMap<>();
//            return func(stones, 0, 1);
//            // return func(stones, 0, 1, map);
//        }
//        
//        private boolean func(int[] stones, int i, int step){//arr, 0, 1
//            if ( i == stones.length-1){
//                return true;
//            }
//            if(step <= 0 || i < 0){
//                return false;
//            }
//            //int k = i+1;
//            // Input ip = new Input(i, step);
//            // if(map.get(ip) != null){
//            //     return map.get(ip);
//            // }
//            
//            int k = search(stones,i+1, stones[i]+step);
//            if(k != -1){
//                // boolean valid =  (step >1 ? func( stones, k, step-1) : false) ||
//                boolean valid = func( stones , k, step-1) ||
//                        func( stones, k, step) || 
//                        func( stones, k, step+1);
//                    //map.put(ip, valid);
//                return valid;
//            }
//            
//            //map.put(ip, false);
//            return false;
//        }
//        
//        
//     /*   private boolean func1(int[] stones, int i, int step, Map<Input, Boolean> map){//arr, 0, 1
//            if ( i == stones.length-1){
//                return true;
//            }
//            if(step <= 0 || i < 0){
//                return false;
//            }
//            //int k = i+1;
//            Input ip = new Input(i, step);
//            if(map.get(ip) != null){
//                return map.get(ip);
//            }
//            
//            int k = search(stones, i+1, stones[i]+step);
//            if(k != -1){
//                boolean valid =  (step >1 ? func( stones, k, step-1, map) : false) ||
//                        func( stones, k, step, map) || 
//                        func( stones, k, step+1, map);
//                    map.put(ip, valid);
//                return valid;
//            }
//            
//            map.put(ip, false);
//            return false;
//        }*/
//        
//        private int search( int[] arr, int start, int val){
//            int l = start, r = arr.length-1;
//            
//            while( l <= r){
//                int mid = l+(r-l)/2;
//                if(arr[mid] == val){
//                    return mid;
//                }else if( arr[mid] > val ){
//                    r = mid-1;
//                }else{
//                    l = mid+1;
//                }
//            }
//            return -1;
//        }
//        
//    }
    
}