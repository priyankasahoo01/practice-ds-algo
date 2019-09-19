package rakuten;

// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Hello {
	public static void main(String[] args) {
		Hello h = new Hello();
		h.solution("AABB");
				
	}
    
    

	public int solution(String S) {
        // write your code in Java SE 8
        Set<Character> vowels = new HashSet<>();
        Set<Character> consonants = new HashSet<>();
        int vCount = 0; int cCount = 0;
        for(int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if(isVowel(ch)){
                vCount++;
                vowels.add(ch);  
            }else{
                cCount++;
                consonants.add(ch);
            }
        }
        if(vCount > cCount){
            return 0;
        }
        if((vCount+1) < cCount){
            return 0;
        }
        
        return wordCount(vowels, consonants, vCount, cCount);
        
    }
    
    private int wordCount(Set<Character> vowels, Set<Character> consonants, int vCount, int cCount) {
        int modulo = 1000000007;
        if(vCount == vowels.size() && cCount == consonants.size()){
            return (factorial(vowels.size())*factorial(consonants.size()))%modulo;
        }
        int vDiff = vCount - vowels.size();
        int cDiff = cCount - consonants.size();
        
        int fact = (factorial(vowels.size())*factorial(consonants.size()))%modulo;
        int prod = ((int)(Math.pow(2, vDiff) * Math.pow(2, cDiff)))%modulo;
        
        return (fact/prod);
    }
    
    private int factorial (int n){
        int modulo = 1000000007;
        int ans = 1;
        while(n > 1){
            ans = (ans * n)%modulo;   
            n--;
        }
        return ans;
    }
    private boolean isVowel(char ch){
        char[] vowels = {'A', 'E','I','O','U'};
        for(char v : vowels){
            if(ch == v){
                return true;
            }   
        }
        return false;
    }
    
    
}