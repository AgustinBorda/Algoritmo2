package framework;
public class StateWithParent<S extends State>{
  private S actual;
  private StateWithParent parent;

  public StateWithParent (S s){
    this.actual = s;
    this.parent = null;
  }
  public StateWithParent (){
    this.actual = null;
    this.parent = null;
  }

  public void setParent(StateWithParent parent){
    this.parent = parent;
  }

  public StateWithParent getParent(){
    return parent;
  }

  public S getChild(){
    return actual;
  }

  public void SetChild(S s){
    this.actual = s;
  }
}
