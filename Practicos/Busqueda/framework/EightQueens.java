package framework;
import java.util.ArrayList;
import java.util.List;
public class EightQueens<S extends State> implements AbstractSearchProblem {

  public S initialState(){
    Qs queens = new Qs();
    for(int i = 0;i<4;i++){
      queens.setTablero(i,0);
    }
    return (S) queens;
  }

  public List<S> getSuccessors(State st){
    Qs s = (Qs) st;
    Qs state;
    ArrayList<Qs> succ = new ArrayList();
    for(int i=0;i<4;i++){
      state = new Qs(s);
      state.setTablero(i,state.getPosTablero(i)+1);
      if(state.getPosTablero(i) < 4){
        succ.add(state);
      }
    }
    return (ArrayList<S>)succ;
  }

  public boolean success(State st){
    Qs s = (Qs) st;
    for(int i=0;i<4;i++){
      for (int j=i+1;j<4;j++){
        if(s.getPosTablero(i) == s.getPosTablero(j)){
          return false;
        }
      }
    }
  /*  for(int k = 0;k<8;k++){
      for(int l=1;l<8;l++){
        if(k-l >= 0 && k-l <=7){
          if(s.getPosTablero(k-l)+l == s.getPosTablero(k) || s.getPosTablero(k-l)-l == s.getPosTablero(k)){
            return false;
          }
        }
        if(k+l >= 0 && k+l <=7){
          if(s.getPosTablero(k+l)+l == s.getPosTablero(k) || s.getPosTablero(k+l)-l == s.getPosTablero(k)){
            return false;
          }
        }
      }
    }*/
    return true;
  }
}
