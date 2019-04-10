public class StringMatching{
  /**
  *Comprueba si un String b es una subsecuencia de un String a
  *@param a El String de mayor longitud
  *@param b El String de menor longitud
  *@return Si b esta contenido en a
  */
  public static boolean matchingFuerzaBruta(String a, String b){
    int largoA = a.length();
    int largoB = b.length(); //guardamos las longitudes para evitar recalcularlas
    int i = 0;
    int j = 0;
    while(i-j <= (largoA-largoB) && j < largoB){ /*si i-j > la diferencia de las longitudes,ya no quedan caracteres suficientes en a para contener a b, si j > a la longitud de b, significa que ya encontramos b en a*/
      if(a.charAt(i)==b.charAt(j)){
        i++; //si a[i] y b[j] coinciden, avanzamos en ambas cadenas
        j++;
      }
      else{
        j = 0; //sino, avanzamos en a y reiniciamos en b
        i++;
      }
    }
    if (i-j > (largoA-largoB)){ //si ya no quedan caracteres suficientes, a no contiene a b
      return false;
    }
    else{ //sino, quiere decir que encontramos a b en a
      return true;
    }
  }

  public static void main (String[] args){
    System.out.print(StringMatching.matchingFuerzaBruta(args[0],args[1])+ "\n");
  }
}
