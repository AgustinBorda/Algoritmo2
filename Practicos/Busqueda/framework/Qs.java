package framework;
public class Qs implements State {
  private int[] tablero;

  public Qs(){
    tablero = new int[4];
  }

  public Qs(Qs s){
    tablero = new int[4];
    for(int i =0;i<4;i++){
      tablero[i] = s.getPosTablero(i);
    }
  }

  public void setTablero(int lugar,int contenido){
      tablero[lugar] = contenido;
  }

  public int getPosTablero(int pos){
    return tablero[pos];
  }


  public int[] getTablero(){
    return tablero;
  }

  public boolean equals(State other){
    Qs other1 = (Qs) other;
    boolean res = true;
    for(int i=0;i<4;i++){
      res = res && this.getTablero()[i] == other1.getTablero()[i];
    }
    return res;
  }

  public String toString(){
    String res = "[ ";
    for(int i=0;i<4;i++){
      res += this.tablero[i] + " ,";
    }
    res += "]";
    return res;
  }

}
