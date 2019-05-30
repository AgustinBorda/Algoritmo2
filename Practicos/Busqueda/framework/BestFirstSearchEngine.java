package framework;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class BestFirstSearchEngine<S extends State, Problem extends AbstractInformedSearchProblem<S>> extends AbstractSearchEngine<S,Problem> {
  private List<S> visited;
  private List<S> path;
  public BestFirstSearchEngine(){
    super();
    visited = new LinkedList<S>();
    path = new LinkedList<S>();
  }

  public BestFirstSearchEngine(Problem p){
    super(p);
    visited = new LinkedList<S>();
    path = new LinkedList<S>();
  }

  public boolean BFS(S s){
    PriorityQueue<StateWithParent<S>> succesors = new PriorityQueue(new HeuristicComparator(problem));
    StateWithParent<S> aux = new StateWithParent(s);
    succesors.add(aux);
    int i = 15;
    while(!succesors.isEmpty()&& i>0){
      i--;
      aux = succesors.poll();
      if(problem.success(aux.getChild())){
        while(aux.getChild() != null){
          path.add((S)aux.getChild());
          if(aux.getParent() != null){
            aux = aux.getParent();
          }
          else{
            aux = new StateWithParent();
          }
        }
        return true;
      }
      else{
        for(S state: problem.getSuccessors(aux.getChild())){
          StateWithParent aux2 = new StateWithParent();
          aux2.SetChild(state);
          aux2.setParent(aux);
          succesors.add(aux2);
        }
      }
    }
    return false;
  }

  public boolean performSearch(){
    S inic = problem.initialState();
    return this.BFS(inic);
  }

  public List<S> getPath() {
    return path;
  }

  public void report() {
    for(int i = path.size()-1; i >=0;i--){
      System.out.println(path.get(i));
    }

  }

}
