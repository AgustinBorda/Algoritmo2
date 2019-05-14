import java.util.ArrayList;
public class permut{
  private static ArrayList<String> intercalar(String cadena, char elem){
    ArrayList<String> res = new ArrayList<String>();
    if(cadena.length() <= 0){
      res.add(elem+"");
    }
    else{
      for(int i = 0; i <= cadena.length();i++){
        res.add(cadena.substring(0,i)+elem+cadena.substring(i,cadena.length()));
      }
    }
    return res;
  }

  public static ArrayList<String> permutaciones(String cadena){
    ArrayList<String> res = new ArrayList<String>();
    ArrayList<String> aux = new ArrayList<String>();
    res = permut.intercalar("",cadena.charAt(0));
    for(int i =1; i<cadena.length();i++){
        aux.clear();
        for(int j=0; j<res.size();j++){
          aux.addAll(intercalar(res.get(j),cadena.charAt(i)));
        }
        res.clear();
        res.addAll(aux);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayList<String> aux = new ArrayList<String>();
    aux = permut.permutaciones(args[0]);
    for(int i = 0; i<aux.size();i++){
      System.out.println(/*Integer.parseInt*/(aux.get(i)));
    }
  }
}
