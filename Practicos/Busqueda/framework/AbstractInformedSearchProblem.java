package framework;
import java.util.List;
public interface AbstractInformedSearchProblem<S extends State> extends AbstractSearchProblem<S>{

  public abstract int heuristicFunction(S s);

}
