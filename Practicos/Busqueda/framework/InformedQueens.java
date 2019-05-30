package framework;
public class InformedQueens extends EightQueens implements AbstractInformedSearchProblem{
  public int heuristicFunction(State s){
    Qs st = (Qs) s;
    int res = 0;
    for(int i=0;i<4;i++){
      for (int j=i+1;j<4;j++){
        if(st.getPosTablero(i) != st.getPosTablero(j)){
          res += i;
        }
      }
    }

    return res;
  }
}
