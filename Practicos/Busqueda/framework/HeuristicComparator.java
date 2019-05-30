package framework;
import java.util.Comparator;
class HeuristicComparator<S extends StateWithParent> implements Comparator<S>{
  private AbstractInformedSearchProblem<State> problem;
  public HeuristicComparator(AbstractInformedSearchProblem<State> p){
    problem = p;
  }
  public int compare(S s1,S s2){
    return Integer.compare(problem.heuristicFunction(s2.getChild()),problem.heuristicFunction(s1.getChild()));
  }
}
