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

   public static int matchKMP(String text, String pattern) {
   int[] tablaKMP = tablaKMP(pattern);

    int j = 0; 
    int i = 0; 

    while (i < text.length()) { 
          
      if (text.charAt(i) == pattern.charAt(j)) { // case 1
        
        j++;
        if (j == pattern.length()) { 
          return i - j+1; 
        }
        i++; 
      } else if (j > 0) { // case 2
        
         j = tablaKMP[j];
      } else { // case 3
        
        i++;
      }
    }
    return -1;
  }

   public static int[] tablaKMP(String pattern) {
    int[] table = new int[pattern.length() + 1];
    
    table[0] = -1;
    table[1] = 0;

  
    int izq = 0;
    int der = 2;

    while (der < table.length ){ 
      if (pattern.charAt(der - 1) == pattern.charAt(izq)) { 
        izq++;
        table[der] = izq;
        der++;
      }  else if (izq > 0) { 
                              
        izq = table[izq];
      } else { 
          table[der] = izq;
          der++;
      }
    
    }
  return table;
   } 

  public static void main (String[] args){
    /*  int aux;
      Date tiempo = new Date();
      long t;
      t = tiempo.getTime();
      aux =StringMatching.match(args[0],args[1]);
      System.out.print("Tiempo fuerza bruta: "+(tiempo.getTime()-t)+ "\n");
      t = tiempo.getTime();*/
      System.out.println(StringMatching.match(args[0],args[1]));
      System.out.print(StringMatching.matchKMP(args[0],args[1])+ "\n");
  }
}

