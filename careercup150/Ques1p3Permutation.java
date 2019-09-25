
//determine if two strings are permutation 
//anagram is special kind of permutation. Anagram are words. Permutation 
//is simply the combination of characters that not necessarily make sense
//
import java.util.*;
public class Ques1p3Permutation {
   //if case insensitive, then use s.toLowerCase() then s.toCharArray()
   //if space/non-alphanumeric doesn't count, use replaceAll() to replace all the
   //or more efficient way is to set counter at proper range of ascii table.
   // space : 32, A-Z:65-90, a-z: 97-122 
   // pay attention to the null case
   public static void main(String[] args){
      String s1 = "abc1";
      String s2 = "1cba";
      System.out.println("Are they permutation ? " + permutation1(s1,s2));
      System.out.println("Are they permutation ? " + permutation2(s1,s2));
      
   }

   //method 1: sort the string 
   public static boolean permutation1(String s1, String s2){
      if(s1 == null && s2 == null) return true;
      if((s1 == null && s2 != null) || (s2 == null && s1 != null)) return false;
      
      if(s1.length() != s2.length()) return false;   
      char[] ch1 = s1.toCharArray(); char[] ch2 = s2.toCharArray();
      Arrays.sort(ch1); Arrays.sort(ch2);
      return String.valueOf(ch1).equals(String.valueOf(ch2));
   }

   //method 2:count the characters 
   public static boolean permutation2(String s1, String s2){
      if(s1 == null && s2 == null) return true;
      if((s1 == null && s2 != null) || (s2 == null && s1 != null)) return false;
      

      if(s1.length() != s2.length()) return false;
      char[] ch1 = s1.toCharArray(); char[] ch2 = s2.toCharArray();
      int[] counter = new int[256];
      for(int i = 0; i < ch1.length; i++){
         counter[ch1[i]]++;
      }
      for(int i = 0; i < ch2.length; i++){
         counter[ch2[i]]--;
         //if ch2 has more char A than ch1,it should have less other char than ch1
         //since ch2 is of same length as ch1
         if(counter[ch2[i]] < 0) return false;
         
      }   
      return true;

   }
   
   //method 2, count the occurences of each character in two strings and store them
   //in two hashtable , then compare two hasthtable 


}