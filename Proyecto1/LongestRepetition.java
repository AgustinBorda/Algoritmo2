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

  public static String repetitionDc(String text){
    String p1;
    String p2;
    String c1;
    String c2;
    String maxMitades;
    String maxCruzados;
    if(text.length() == 1){
      return "";
    }
    else{
      p1 = LongestRepetition.repetitionDc(text.substring(0,text.length()/2));
      p2 = LongestRepetition.repetitionDc(text.substring(text.length()/2,text.length()));
      if (p1.length() >= p2.length()){
        maxMitades = p1;
      }
      else{
        maxMitades = p2;
      }
      c1 = LongestRepetition.leftCrossed(text);
      c2 = LongestRepetition.rightCrossed(text);
      if(c1.length() >= c2.length()){
        maxCruzados = c1;
      }
      else{
        maxCruzados = c2;
      }
      if(maxMitades.length() >= maxCruzados.length()){
        return maxMitades;
      }
      else{
        return maxCruzados;
      }
    }
  }

  private static String leftCrossed(String text){
    int centro = text.length()/2;//centro del lado izquierdo
    int i = 0;
    int inicioPatron;
    int finPatron;
    boolean foundPattern = false;//bandera que utilizaremos para dejar de calcular cuando encontremos un patron
    String candidato = "";//candidato a patron mas largo de la izquierda
    int longPatron;
    while(i<centro && !foundPattern){
      if(text.charAt(i)==text.charAt(centro)){ //Si encontramos un elemento igual al centro, verificamos si existe un patron
        longPatron = centro-i; //distancia entre elementos
        inicioPatron = i -1;//inicializamos asi para no volver a ver el elemento del centro
        while(inicioPatron >= 0 && text.charAt(inicioPatron) == text.charAt(inicioPatron+longPatron)){
          inicioPatron--; //si coinciden quiere decir que el patron empieza antes
        }
        inicioPatron++;
        finPatron = i+1;
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++;
        }
        if(finPatron>=inicioPatron+longPatron){
          foundPattern = true;
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;
          }
          candidato = text.substring(inicioPatron,finPatron);
        }
      }
      i++;
    }
    return candidato;
  }

  private static String rightCrossed(String text){
    int centro = text.length()/2-1;//centro del lado izquierdo
    int i = text.length()-1;
    int inicioPatron;
    int finPatron;
    boolean foundPattern = false;//bandera que utilizaremos para dejar de calcular cuando encontremos un patron
    String candidato = "";//candidato a patron mas largo de la izquierda
    int longPatron;
    while(i>centro && !foundPattern){
      if(text.charAt(i)==text.charAt(centro)){ //Si encontramos un elemento igual al centro, verificamos si existe un patron
        longPatron = i-centro; //distancia entre elementos
        inicioPatron = centro -1;//inicializamos asi para no volver a ver el elemento del centro
        while(inicioPatron >= 0 && text.charAt(inicioPatron) == text.charAt(inicioPatron+longPatron)){
          inicioPatron--; //si coinciden quiere decir que el patron empieza antes
        }
        inicioPatron++;
        finPatron = centro+1;
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++;
        }
        if(finPatron>=inicioPatron+longPatron){
          foundPattern = true;
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;
          }
          candidato = text.substring(inicioPatron,finPatron);
        }
      }
      i--;
    }
    return candidato;
  }
  public static void main(String[] args) {
    System.out.println("Resultado Divide and Conquer: " + LongestRepetition.repetitionDc(args[0]));
    System.out.println("Resultado Fuerza Bruta: " + LongestRepetition.repetition(args[0]));

  }
}
