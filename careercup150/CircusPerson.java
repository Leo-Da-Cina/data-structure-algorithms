import java.util.*;

public class CircusPerson implements Comparable<CircusPerson> {
   private double height; // Double and Integer are objects, double and int are primitative types
   private double weight;
   public CircusPerson(double height, double weight){
      this.height = height;
      this.weight = weight;
   }
   
   public int compareTo(CircusPerson other){
      
      if(this.height != other.height){
         return (int) (this.height - other.height);
      } else {
         return (int) (this.weight - other.weight);
      }
   }
   


}