package proyecto1;
import java.util.ArrayList;
public class StringMatching{
/**
*Calcula String Matching utilizando fuerza bruta.
*@param text El texto a analizar
*@param pattern El patron a buscar
*@return el indice donde inicia la primmera ocurrencia del patron, o -1 en caso de que no exista
*/
  public static int match(String text, String pattern){
    int largoTexto = text.length();
    int largoPalabra = pattern.length(); //guardamos las longitudes para evitar recalcularlas
    int contadorTexto = 0;
    while(largoTexto-contadorTexto >= largoPalabra){
      if(text.substring(contadorTexto,contadorTexto+largoPalabra).equals(pattern)){
        return contadorTexto;/*Si las primeras k(contando desde el contador) letras del texto son iguales a las k primeras del patron(siendo k la longitud del mismo), retornamos el contador*/
      }
      else{
        contadorTexto++;
      }/*Sino, aumentamos el contador*/
    }
    return -1;/*En caso de no encontrar nada, devolvemos -1*/
  }

  /**
  *Calcula String Matching utilizando el algoritmo Knuth−Morris−Pratt.
  *@param text El texto a analizar
  *@param pattern El patron a buscar
  *@return el indice donde inicia la primmera ocurrencia del patron, o -1 en caso de que no exista
  */
   public static int matchKmp(String text, String pattern) {
   int[] tablaKMP = tablaKMP(pattern);
    int j = 0;
    int i = 0;

    while (i < text.length()) { //inicio while

      if (text.charAt(i) == pattern.charAt(j)) { // caso 1
       // Se encontró un char actual en j en la cadena de text
        j++;
        if (j == pattern.length()) {  //Se encontro la palabra

          return i - j+1; //Devolvemos el indice de text de la palabra buscada
        }
        i++; //Avanza si no encuentra la palabra

      } else if (j > 0) { // caso 2
        //use failureTable para usar el puntero apuntado a la ubicación más cercana del prefijo de cadena utilizable
         j = tablaKMP[j];
      } else { // caso 3
        // j esta en la posicion 0, así que reiniciamos la búsqueda con el índice i
        i++;
      }
    }//fin while
    return -1; //retornamos -1 si no encontramos la palabra
  }

  /**
   **Calcula la tabla de fallo del algoritmo Knuth−Morris−Pratt
   *@param pattern el patron con el que construira la tabla de fallo
   *@return La tabla de fallo, que contiene el indice del ultimo prefico de cadena valido
   */
   public static int[] tablaKMP(String pattern) {
    int[] table = new int[pattern.length() + 1];
    // Los estados 0 y 1 están garantizados por el anterior.
    table[0] = -1;
    table[1] = 0;

    //los punteros apuntando a la última falla y la satte actual

    int izq = 0;
    int der = 2;

    while (der < table.length ){ // EL DERECHO NUNCA SE MUEVE EL DERECHO HASTA ASIGNAR UN PUNTERO VALIDO
      if (pattern.charAt(der - 1) == pattern.charAt(izq)) { // cuando los dos caracteres anteriores a la izquierda y la derecha son iguales, vincula ambos y avanza ambos
        izq++;
        table[der] = izq;
        der++;
      }  else if (izq > 0) { //si la izquierda no está al principio, entonces envíe la izquierda hacia atrás
                             //siguiendo el puntero ya establecido hacia donde apunta
        izq = table[izq];
      } else { // la izquierda ha caído desde el principio
          table[der] = izq;
          der++;
      }

    }
  return table;
   }
}
