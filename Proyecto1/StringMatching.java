import java.util.ArrayList;
public class StringMatching{
//
  public static int match(String text, String pattern){
    int largoTexto = text.length();
    int largoPalabra = pattern.length(); //guardamos las longitudes para evitar recalcularlas
    int contadorTexto = 0;
    while(largoTexto-contadorTexto >= largoPalabra){
      if(text.substring(contadorTexto,contadorTexto+largoPalabra).equals(pattern)){
        return contadorTexto;
      }
      else{
        contadorTexto++;
      }
    }
    return -1;
  }

//
/*  public static int matchKMP(String text, String pattern){
    int i = 0; //indice del texto
    int j = 0; // indice del patron
    int[] tabla = tablaKMP(pattern);
    while(i<text.length() && j<pattern.length()){
      if (text.charAt(i+j) == text.charAt(j)){
        if(j>=pattern.length()-1){
          return i;
        }
        i++;
      }
      else{
        j = j+i - tabla[i];
        if(i>0){
          i = tabla[i];
        }
      }
    }
    return -1;
  }

public static int[] tablaKMP(String pattern){
    int[] tabla = new int[pattern.length()+1];
    int posTabla = 1;
    int candidato = 0;
    tabla[0] = -1;
    while(posTabla< pattern.length()){
      if(pattern.charAt(posTabla-1) == pattern.charAt(candidato)){
        tabla[posTabla] = candidato;
        candidato++;
        posTabla++;
      }
      else{
        if(candidato>0){
          candidato = tabla[candidato];
        }
        else{
          tabla[posTabla] =0;
          posTabla++;
        }
      }
    }
    return tabla;
  }*/

  public static void main (String[] args){
    /*  int aux;
      Date tiempo = new Date();
      long t;
      t = tiempo.getTime();
      aux =StringMatching.match(args[0],args[1]);
      System.out.print("Tiempo fuerza bruta: "+(tiempo.getTime()-t)+ "\n");
      t = tiempo.getTime();
      aux =StringMatching.matchKMP(args[0],args[1]);*/
      //System.out.print(StringMatching.subList(args[0])+ "\n");
  }
}
