package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ValidTreePath {

	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        if(solve(0,0,A,B, C, E, F, new ArrayList<String>())){
            return "YES";
        }
        return "NO";
    }
    public boolean solve(int istart, int jstart, int iend, int jend, int rad, int[] xarr, 
    int[] yarr, List<String> visited){
        if(istart < 0 || istart>iend || jstart < 0 || jstart > jend){
            return false;
        }
        if(istart == iend && jstart==jend){
            return true;
        }
        if(isinvalid(istart, iend, rad, xarr, yarr)){
            return false;
        }
        if(visited.contains(istart+","+jstart)){
            return false;
        }
        visited.add(istart+","+jstart);
        return solve(istart+1,jstart,iend,jend, rad, xarr, yarr, visited) ||
        solve(istart-1,jstart,iend,jend, rad, xarr, yarr, visited) ||
        solve(istart+1,jstart+1,iend,jend, rad, xarr, yarr, visited) ||
        solve(istart+1,jstart-1,iend,jend, rad, xarr, yarr, visited) ||
        
        solve(istart-1,jstart-1,iend,jend, rad, xarr, yarr, visited) ||
         solve(istart-1,jstart+1,iend,jend, rad, xarr, yarr, visited) ||
         solve(istart,jstart+1,iend,jend, rad, xarr, yarr, visited) ||
        solve(istart,jstart-1,iend,jend, rad, xarr, yarr, visited) ;
    }
    
    private boolean isinvalid(int x, int y , int rad, int[] xarr, int[] yarr){
        for(int i = 0 ; i < xarr.length; i++){
            for(int j = xarr[i]-rad; j <= xarr[i]+rad ; j++){
                for(int k = yarr[i]-rad; k <= yarr[i]+rad ; k++){
                    if(x==j && y==k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidTreePath sol = new ValidTreePath();
		String s = sol.solve(2, 3, 1, 1, new int[]{1,2}, new int[]{1,3});
		System.out.println(s);

	}

}
