package com.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderlogFiles {
	
	public static void main(String[] args) {
		ReorderlogFiles sol = new ReorderlogFiles();
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] op = sol.reorderLogFiles(logs);
		for(String s : op) {
			System.out.println(s);
		}
	}
	
	public String[] reorderLogFiles(String[] logs) {
        List<String> numberList = new ArrayList<>();
        PriorityQueue<String> letterList = new PriorityQueue<>(new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                if(o1 == o2){
                    return 0;
                }
                
                String[] arr1 = o1.split(" ");
                String[] arr2 = o2.split(" ");
                int i = 1, j =1;
                while(i < arr1.length && j < arr2.length){
                    String s1 = arr1[i];
                    String s2 = arr2[j];
                    
                    if(s1.equals(s2)){
                    	i++;j++;
                        continue;
                    }else{
                        return s1.compareTo(s2);
                    }
                    
                }
                
                String s1 = arr1[0];
                String s2 = arr2[0];
                return s1.compareTo(s2);
                
            }
        });
        for(int i = 0 ; i < logs.length ; i++){
            String log = logs[i];
            String[] arr = log.split(" ");
            if(Character.isLetter(arr[1].charAt(0))){
                letterList.add(log);
            }else{
                numberList.add(log);
            }
            
        }
        
        String[] op = new String[logs.length];
        int k = 0;
        int size = letterList.size();
		for(int i = 0 ; i < size; i++){
            op[k++] = letterList.remove();
        }
        for(int i = 0 ; i < numberList.size(); i++){
            op[k++] = numberList.get(i);
        }
        
        return op;
    }

}
