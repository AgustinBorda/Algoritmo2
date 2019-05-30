 package framework;
 public class Main{
   public static void main(String[] args) {
     BreadthFirstEngine motor = new BreadthFirstEngine(new EightQueens());
     System.out.println(motor.performSearch());
   }

 }
