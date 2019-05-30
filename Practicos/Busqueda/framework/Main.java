 package framework;
 public class Main{
   public static void main(String[] args) {
     BestFirstSearchEngine motor = new BestFirstSearchEngine(new InformedQueens());
     System.out.println(motor.performSearch());
     motor.report();
   }

 }
