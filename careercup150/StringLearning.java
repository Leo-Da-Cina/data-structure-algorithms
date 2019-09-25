
import java.util.*;

public class StringLearning{
   public static void main(String[] args){
        String s = "aba";
        StringBuilder temp = new StringBuilder(s);
        String newS = s + "#" + temp.reverse().toString(); // temp.reverse().toString + s doesn't work. because we are finding the palindrome starts with first character of s.
        int[] table = getTable(newS);
        int maxLen = table[table.length - 1];
        StringBuilder prefix = new StringBuilder(s.substring(maxLen));
        
        
    }
    
   public static int[] getTable(String s){
       int i = 0, j = 1;
       int[] t = new int[s.length()];
       while( j < s.length()){
           if(s.charAt(i) == s.charAt(j)){
               t[j] = ++i;
               j++;
           } else {
               if(i == 0 ){
                   t[j] = 0;
                   j++;
               }

               while(i > 0 && s.charAt(i) != s.charAt(j)){
                   i = t[i-1];
               }
                              
           }
           
       }
       
       return t;
       
   }

}