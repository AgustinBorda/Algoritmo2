import java.util.ArrayList;
public class Tupla{
  private int rep;
  private ArrayList<Integer> lugares;

  public Tupla(int lugar){
    rep = 1;
    lugares = new ArrayList<Integer>();
    lugares.add(lugar);
  }

  public Tupla(int lugar, int repetition){
    rep = repetition;
    lugares = new ArrayList<Integer>();
    lugares.add(lugar);
  }

  /*public void addRep(int lugar){
    repetition++;
    lugares.add(lugar);
  }*/

  public static void main(String[] args) {
    int j=1;
    if(j>0){
      System.out.print("hola, putos!\n");
    }
  }
}
