

public class BitMan {

   public static void main(String[] args){
      double num = 0.25/2 + 0.75;
      System.out.println(printBinary1(num));
      System.out.println(printBinary2(num));
   }
   
   //print binary representation of a double num , 0.0 < num < 1.0
   public static String printBinary1(double num){
      if(num >= 1 || num <= 0 ) return "ERROR";
      StringBuilder binary = new StringBuilder();
      binary.append(".");
      
      while(num > 0){ //exit condition, when num == 0, all digits checked
         if(binary.length() >= 32) return "ERROR";
         double r = num * 2; // in base 2, mulitplying by 2^n results in ". "shift, just like in decimal multiply by 10^n
         
         if(r >= 1){
            binary.append("1");
            num = r - 1;
         } else {
            binary.append("0");
            num = r;
         }
      }
      return binary.toString();
   
   }

   public static String printBinary2(double num){
      if(num >= 1 || num <= 0) return "ERROR";
      StringBuilder binary = new StringBuilder();
      binary.append(".");
      double fac = 0.5;
      while(num > 0) {
         if(binary.length() >= 32) return "ERROR";
         
         if(num >= fac){
            binary.append("1");
            num -= fac; // update only when >= 0.1 (=0.5 in base 10)
         } else {
            binary.append("0");
         }
         fac /= 2;   
      
      }
      
      return binary.toString();
      
   }


}