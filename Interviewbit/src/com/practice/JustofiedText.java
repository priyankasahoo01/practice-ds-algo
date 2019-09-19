package com.practice;

import java.util.ArrayList;
import java.util.List;

public class JustofiedText {

    public String[] fullJustify(String[] A, int B) {
        List<String> op = new ArrayList<>();
        String mystr = "";
        for( int i = 0 ; i < A.length ; i++ ){
            String wrd = A[i];
			int n1 = mystr.length() + wrd.length() + (("".equals(mystr)?0:1));
			if( B >= n1 ){
                mystr = mystr + ("".equals(mystr)?"":" ") + wrd;
                
            }else{
                mystr = addspaces(mystr, B);
                op.add(mystr);
                mystr = A[i];
            }
        }
        if(!"".equals(mystr)) {
        	op.add(addspaces(mystr, B));
        }
        return convertToArray(op);
    }
    
    private String addspaces(String str, int N){
        if(str.length() == N){
            return str;
        }
        String[] arr = str.split(" ");
        if(arr.length == 1){
            return str + getSpaces(N-str.length());
        }
        int spaces = arr.length - 1;
        int newspaces = N/spaces + 1;
        int extra = N%spaces;
        int remspaces = newspaces + (extra);
        String spaces1 = getSpaces(newspaces);
        String spaces2 = getSpaces(remspaces);
        //str.replacesAll(" ", spaces(1));
        
        String op = "";
        for( int i = 0 ; i < arr.length ; i++) {
            op = op + arr[i];
            if(i == arr.length-1){
                return op;
            }
            
            if( i >= arr.length-1-extra ){
                op = op = spaces2;
            }else{
                op = op + spaces1;
            }
        }
        return op;
    }
    
    private String getSpaces(int len){
        String op = "";
        while(len-- > 0){
            op = op + " ";
        }
        return op;
    }
    
    private String[] convertToArray(List<String> li){
        String[] op = new String[li.size()];
        int k = 0;
        for(String s : li) {
            op[k++] = s;
        }
        return op;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JustofiedText sol = new JustofiedText();
//		String[] arr = {"What", "must", "be", "shall", "be."};
		String[] arr = { "glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m" };

		String[] op = sol.fullJustify(arr, 144);
		for(String s : op) {
			System.out.println(s);
		}

	}

}
