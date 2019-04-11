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
  public static int matchKMP(String text, String pattern){

    return-1;
  }

  public static int[] tablaKMP(String pattern){
    int[] tabla = new int[pattern.length()];
    int posTabla = 1;
    int lugarPatron = 0;
    tabla[0] = -1;
    return tabla;
  }

  public static void main (String[] args){
    System.out.print(StringMatching.match(args[0],args[1])+ "\n");
  }
}
