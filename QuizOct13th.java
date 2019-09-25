//Oct 13th TA quiz section problems

import java.util.*;

public class QuizOct13th {

   public static void main(String[] args){
      showTwos(48);
      
      showHailstone(120);
      rollSix(6);
      randomWalk(0);
   }
   
   // a method to print input positive integers as a product of 2 and an odd number
   public static void showTwos(int x) {
      
      if (x < 0) {
         System.out.println("positive integer required !");
         return;
         }      
      System.out.print(x+" = ");
      while(x % 2 == 0) {
      System.out.print("2*");
      x = x/2;
      }
      System.out.print(x);
      System.out.println();
      System.out.println();
   
   }
   
   // a method to produce Hailstone sequence for given input
   public static void showHailstone(int x) {
      System.out.print("sequence for "+x+" : ");
      System.out.print(x+",");
      while( x != 1){
         
         if (x % 2 != 0 ) {
            x = 3*x+1;
         }
         
         if (x % 2 == 0 ) {
         
            x /= 2;
         }
         System.out.print(x+",");
      }
      System.out.print(1);
      System.out.println();
      System.out.println();
   }
   
   // a method to simulate the repeated rolling of one six-sided die utill six is rolled
   public static void rollSix(int rollmax){
      
      int cnt = 0;
      Random rand  = new Random();
      int rolled  = 0;
      
      while(rolled != 6) {
         rolled  = rand.nextInt(rollmax)+1;
         cnt ++ ;
         System.out.println("Rolled: " + rolled);
      }
      
      System.out.println("You got a six in "+cnt+" turns !");
      
   }
   
   // start from pos = 0  decreas or increase by 1 with equal probablility until it hits [-3 3]
   public static void randomWalk(int pos){
   
      System.out.println("position = "+pos);
      int flip  = 0;
      int maxpos = pos;
      Random rand = new Random();
      while( pos < 3 && pos > -3 ) {
         flip = rand.nextInt(2);
         if (flip == 0) {
         pos+=1;
         }
         else{
         pos-=1;
         }
         System.out.println("position = "+pos);
         maxpos = Math.max(pos,maxpos);
      } 
      System.out.println("max position = "+maxpos);
      System.out.println();
      System.out.println();
   }
   
   
}