package framework;
import java.util.List;
import java.util.LinkedList;
public class BreadthFirstEngine<S extends State, Problem extends AbstractSearchProblem<S>> extends AbstractSearchEngine<S,Problem> {
  private List<S> visited;
  private List<S> path;
  public BreadthFirstEngine(){
    super();
    visited = new LinkedList<S>();
    path = new LinkedList<S>();
  }

  public BreadthFirstEngine(Problem p){
    super(p);
    visited = new LinkedList<S>();
    path = new LinkedList<S>();
  }

  public boolean BFS(S s){
    LinkedList<StateWithParent<S>> succesors = new LinkedList();
    StateWithParent<S> aux = new StateWithParent(s);
    succesors.add(aux);
    while(!succesors.isEmpty()){
      aux = succesors.poll();
      if(problem.success(aux.getChild())){
        while(aux.getChild() != null){
          path.add((S)aux.getChild());
          aux = aux.getParent();
        }
        return true;
      }
      else{
        StateWithParent aux2 = new StateWithParent();
        for(S state: problem.getSuccessors(aux.getChild())){
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
