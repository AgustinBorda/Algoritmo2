public class StringMatching{
  /**
  *Comprueba si un String b es una subsecuencia de un String a
  *@param texto El String de mayor longitud
  *@param palabra El String de menor longitud
  *@return Si b esta contenido en a
  */
  public static boolean matchingFuerzaBruta(String texto, String palabra){
    int largoTexto = texto.length();
    int largoPalabra = palabra.length(); //guardamos las longitudes para evitar recalcularlas
    int i = 0; //indicador del texto
    int j = 0; //indicador de la palabra
    while(i-j <= (largoTexto-largoPalabra) && j < largoPalabra){ /*si i-j > la diferencia de las longitudes,ya no quedan caracteres suficientes en el texto para contener a la palabra, si j > a la longitud de la palabra, significa que ya la encontramos en el texto*/
      if(texto.charAt(i)==palabra.charAt(j)){
        i++; //si texto[i] y palabra[j] coinciden, avanzamos en ambas cadenas
        j++;
      }
      else{
        if(j != 0){ //si no coinciden y la palabra esta a medio recorrer, reseteamos su indicador
          j=0;
        }
        else{ // si la palabra esta en su inicio, avanzamos el texto
          i++;
        }
      }
    }
    if (i-j > (largoTexto-largoPalabra)){ //si ya no quedan caracteres suficientes, el texto no contiene a la palabra
      return false;
    }
    else{ //sino, quiere decir que encontramos a la palabra en el texto
      return true;
    }
  }

  public static void main (String[] args){
    System.out.print(StringMatching.matchingFuerzaBruta(args[0],args[1])+ "\n");
  }
}
