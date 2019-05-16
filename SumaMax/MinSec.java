import java.util.List;
import java.util.ArrayList;
public class MinSec{
  private static List<Integer> crossed(List<Integer> sec){
    int  med = sec.size()/2;
    int  inic = med;
    int  fin = med;
    int acum = 0;
    for(int i = med-1;i>=0;i--){
      acum += sec.get(i);
      if(acum < 0){
        acum = 0;
        inic = i;
      }
    }
    acum = 0;
    for(int j=med+1;j<sec.size();j++){
      acum += sec.get(j);
      if(acum < 0){
        acum = 0;
        fin = j;
      }
    }
    return sec.subList(inic,fin+1);
  }

  private static int suma(List<Integer> sec){
    int acum = 0;
    for(int i = 0; i<sec.size();i++){
      acum+=sec.get(i);
    }
    return acum;
  }

  public static List<Integer> minSec(List<Integer> sec){
    if(sec.size()<=1){
      return sec.subList(0,1);
    }
    else{
      List<Integer> izq = minSec(sec.subList(0,sec.size()/2));
      List<Integer> der = minSec(sec.subList(sec.size()/2,sec.size()));
      List<Integer> cruz = crossed(sec);
      int sumaIzq = suma(izq);
      int sumaDer = suma(der);
      int sumaCruz = suma(cruz);
      int minSum;
      List<Integer> min;
      if(sumaIzq <= sumaDer){
        minSum = sumaIzq;
        min = izq;
      }
      else{
        minSum = sumaDer;
        min = der;
      }
      if(minSum <= sumaCruz){
        return min;
      }
      else{
        return cruz;
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> test = new ArrayList();
    for(int j = 0; j<args.length;j++){
      test.add(Integer.parseInt(args[j]));
    }
    List<Integer> res = minSec(test);
    System.out.print("[");
    for(int i = 0;i<res.size();i++){
      System.out.print(res.get(i)+", ");
    }
    System.out.print("]");
    System.out.println("");
  }
}
