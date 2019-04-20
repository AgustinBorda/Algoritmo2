package proyecto1;
import java.util.ArrayList;
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
/**
*Calcula Longest Repetition utilizando fuerza bruta
*@param text el texto a analizar
*@return el substring de mayor longitud que se repite
*/
  public static String repetition(String text){
    ArrayList<String> sub = subList(text); //generamos todas las sublistas y las guardamos en un arraylist
    String max = "";//maxima repetition parcial
    String aux = "";
    for(int i=0;i<sub.size();i++){
      aux = sub.get(i);//nos guardamos el elemento del arraylist
      if (aux.length() % 2 == 0 && aux.length() != 0){ /* si tiene longitud impar o longitud 0 (es nulo) no tiene sentido buscar el patron ahi*/
        if((aux.substring(0,aux.length()/2)).equals(aux.substring(aux.length()/2,aux.length()))){/*si sus 2 mitades son iguales, el patron es la primera de ellas*/
            if(aux.length() / 2 > max.length()){
            max = aux.substring(0,aux.length()/2);/*si nuestro patron es mas largo que el maximo, reemplazamos el maximo*/
          }
        }
      }
    }

    return max;//retornamos el maximo
  }
  /**
  *Calcula Longest Repetition utilizando divide & conquer
  *@param text el texto a analizar
  *@return el substring de mayor longitud que se repite
  */
  public static String repetitionDc(String text){
    String p1;
    String p2;
    String c1;
    String c2;
    String maxMitades;
    String maxCruzados;
    if(text.length() == 1){
      return "";
    }//caso base
    else{
      p1 = LongestRepetition.repetitionDc(text.substring(0,text.length()/2));
      p2 = LongestRepetition.repetitionDc(text.substring(text.length()/2,text.length()));//llamadas recursivas
      if (p1.length() >= p2.length()){
        maxMitades = p1;
      }
      else{
        maxMitades = p2;//nos quedamos el resultado mas largo de las llamadas recursivas
      }
      c1 = LongestRepetition.leftCrossed(text);
      c2 = LongestRepetition.rightCrossed(text);//calculamos los patrones cruzados
      if(c1.length() >= c2.length()){
        maxCruzados = c1;
      }
      else{
        maxCruzados = c2;
      }//nos quedamos con el mas largo
      if(maxMitades.length() >= maxCruzados.length()){
        return maxMitades;/*si el resultado de la llamada que guardamos es mayor a la del patron cruzado, devolvemos el valor de la llamada*/
      }
      else{
        return maxCruzados;/*sino, retornamos el patron cruzado que guardamos*/
      }
    }
  }
/**
*Calcula el patron cruzado izquierdo mas largo
*@param text El texto a analizar
*@return El patron izquierdo cruzado de mayor longitud
*/
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
        inicioPatron++;//Una vez que salimos del ciclo, el inicio del patron esta un lugar despues de donde nos quedamos
        finPatron = i+1;//Inicializamos de esta forma para no volver a comparar el centro
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++;//si coinciden quiere decir que el patron termina despues
        }
        if(finPatron>=inicioPatron+longPatron){/*Si el patron obtenido mas largo que nuestro candidato*/
          foundPattern = true;/*Por la forma de computar, el primer patron que encontremos sera el mas largo, luego no tiene sentido seguir buscando patrones*/
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;/*Si nuestro patron queda mas largo que la longitud que deberia tener(dada por longPatron),le asignamos ese largo*/
          }
          candidato = text.substring(inicioPatron,finPatron);/*Guardamos nuestro patron*/
        }
      }
      i++;
    }
    return candidato;
  }
  /**
  *Calcula el patron cruzado derecho mas largo
  *@param text El texto a analizar
  *@return El patron derecho cruzado de mayor longitud
  */
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
        inicioPatron++;//Una vez que salimos del ciclo, el inicio del patron esta un lugar despues de donde nos quedamos
        finPatron = centro+1;/*Inicializando de esta forma, no volvemos a comparar el elemento del centro con el elemento i*/
        while(finPatron+longPatron < text.length() && text.charAt(finPatron) == text.charAt(finPatron+longPatron)){
          finPatron++;/*Si coinciden, quiere decir que el patron termina despues*/
        }
        if(finPatron>=inicioPatron+longPatron){
          foundPattern = true;/*Por la forma de computar, el primer patron que encontremos sera el mas largo, luego no tiene sentido seguir buscando patrones*/
          if(finPatron>inicioPatron+longPatron){
            finPatron=inicioPatron+longPatron;/*Si nuestro patron queda mas largo que la longitud que deberia tener(dada por longPatron),le asignamos ese largo*/
          }
          candidato = text.substring(inicioPatron,finPatron);/*guardamos nuestro patron*/
        }
      }
      i--;
    }
    return candidato;
  }
}
