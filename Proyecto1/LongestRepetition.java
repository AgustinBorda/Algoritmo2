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
    ArrayList<String> sub = subList(text);//generamos todas las sublistas
    String max = "";
    String aux = "";
    for(int i=0;i<sub.size();i++){
      aux = sub.get(i);
      if (aux.length() % 2 == 0 && aux.length() != 0){//solo las no vacias y con longitud par nos interesan
        if((aux.substring(0,aux.length()/2)).equals(aux.substring(aux.length()/2,aux.length()))){/*si su primera parte es igual a su segunda parte,la comparamos con el string maximo hasta ahora*/
            if(aux.length() / 2 > max.length()){//si supera en tamaño a max (el string es la mitad del aux), reemplazamos en max
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
    }//si nuestro texto tiene un solo caracter, no hay repeticion
    else{
      p1 = LongestRepetition.repetitionDc(text.substring(0,text.length()/2));
      p2 = LongestRepetition.repetitionDc(text.substring(text.length()/2,text.length()));// llamadas recursivas
      if (p1.length() >= p2.length()){
        maxMitades = p1;
      }
      else{
        maxMitades = p2;
      }//nos quedamos con la llamada que devuelva el patron mas largo
      c1 = LongestRepetition.leftCrossed(text);
      c2 = LongestRepetition.rightCrossed(text); //calculamos los patrones cruzados
      if(c1.length() >= c2.length()){
        maxCruzados = c1;
      }
      else{
        maxCruzados = c2;
      }// nos quedamos con el mas largo
      if(maxMitades.length() >= maxCruzados.length()){
        return maxMitades;
      }
      else{
        return maxCruzados;
      }//devolvemos el mas largo entre el mas largo de las llamadas y los patrones cruzados
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
        inicioPatron++; //cuando salgamos del ciclo, el inicio del patron esta en la siguiente de la que estamos parados
        finPatron = i+1;
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++; //si coinciden, el patron empieza despues
        }
        if(finPatron>=inicioPatron+longPatron){
          foundPattern = true; //por la forma de buscar, el primer patron que encontramos es el mas largo
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;/*si tenemos algo mas largo que el largo del patron, quiere decir que hay repeticiones dentro del propio patron, por lo que los ultimos caracteres no nos interesan*/
          }
          candidato = text.substring(inicioPatron,finPatron);//guardamos el candidato
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
        longPatron = i-centro; //distancia entre elementos/largo del patron
        inicioPatron = centro -1;//inicializamos asi para no volver a ver el elemento del centro
        while(inicioPatron >= 0 && text.charAt(inicioPatron) == text.charAt(inicioPatron+longPatron)){
          inicioPatron--; //si coinciden quiere decir que el patron empieza antes
        }
        inicioPatron++; //cuando salgamos del ciclo, el inicio del patron esta en la siguiente de la que estamos parados
        finPatron = centro+1;
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++;//si coinciden quiere decir que el patron termina despues
        }
        if(finPatron>=inicioPatron+longPatron){
          foundPattern = true; //por la forma de buscar, el patron que primero encontramos es el mas largo
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;/*en caso de encontrar algo mas largo que el patron(cuando se repiten las ocurrencias dentro del propio patron)
                                              solo nos quedamos con las primeros n lugares, siendo n el largo del patron*/
          }
          candidato = text.substring(inicioPatron,finPatron);//guardamos el patron
        }
      }
      i--;
    }
    return candidato; //devolvemos
  }
  public static void main(String[] args) {
    System.out.println("Resultado Divide and Conquer: " + LongestRepetition.repetitionDc(args[0]));
    System.out.println("Resultado Fuerza Bruta: " + LongestRepetition.repetition(args[0]));

  }
}
