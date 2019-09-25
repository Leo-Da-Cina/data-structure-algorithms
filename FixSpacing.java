// ling zheng
// Oct 23rd, 2015
// FixSpacing
// practice file input and output by rebuild the code in the text book
// read a file of awefully spaced characters and output spacing fixed version
// to both the console and computer directory

import java.io.*;
import java.util.*;

public class FixSpacing {
   public static void main(String[] args) throws FileNotFoundException {
      //read the file content via Scanner
      Scanner input = new Scanner(new File("word1.txt"));
      PrintStream output = new PrintStream(new File("fixedword.txt"));
      
      while(input.hasNextLine()) {
         String text = input.nextLine();
         fixAndOut(text,output);
         fixAndOut(text,System.out);
      
      
      }
   
   
   }

   // get a line of text and print out a fixed one to either console or a file
   public static void fixAndOut(String text, PrintStream output) {
      Scanner input = new Scanner(text);
      if (input.hasNext()) {
         output.print(input.next());
         while(input.hasNext()){
            output.print(" "+input.next());
         
         }
      
      output.print("\n");     
      }
      
   
   }

}
