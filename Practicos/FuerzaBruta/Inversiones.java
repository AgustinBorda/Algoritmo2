public class Inversiones{
  private float[] arreglo;
  public Inversiones(int n){
    arreglo = new float[n];
  }
  public int split(int init, int end){
    return end/2;
  }



  public int solve(int init,int end){
      int res = 0;
      float[] = new float[end-init];
      if (init<end){
        res+=this.solve(init,this.split(init,end));
        res+=this.solve(this.split(init,end)+1,end);
      }
      else{
        
      }

      }
  }
