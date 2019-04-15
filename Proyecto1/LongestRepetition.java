import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class LongestRepetition{
  private static ArrayList<String> subList(String text){
    ArrayList<String> sub = new ArrayList<String>();
    for(int i=0;i<=text.length();i++){
      for(int j=i;j<=text.length();j++){
          sub.add(text.substring(i,j));
      }
    }
    return sub;
  }

  public static String repetition(String text){
    ArrayList<String> sub = subList(text);
    String max = "";
    String aux = "";
    for(int i=0;i<sub.size();i++){
      aux = sub.get(i);
      if (aux.length() % 2 == 0 && aux.length() != 0){
        if((aux.substring(0,aux.length()/2)).equals(aux.substring(aux.length()/2,aux.length()))){
            if(aux.length() / 2 > max.length()){
            max = aux.substring(0,aux.length()/2);
          }
        }
      }
    }
    
    return max;
  }

private static int partition(String Text){
  boolean iguales = true;
  Map<Character, Integer> hash = new HashMap<Character, Integer>();//hacer con una tupla
  Character elem = new Character();
  Integer rep = new Integer();

}

  public static String repetitionDc(String text){
    return "";
  }


  public static void main(String[] args) {
    System.out.println(args[0].substring(0,2));
    //System.out.print("Resultado: "+LongestRepetition.repetition(args[0])+"\n");
  }
}
