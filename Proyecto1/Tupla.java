import java.util.*

public class Tupla{

	private int nro_rep=0;
	private LinkedList<Integer> listIndex = new LinkedList<Integer>();

public  Tupla(int n){
	nro_rep=1;
	listIndex.add(n);
}

public Tupla(int rep, int lugar){
	nro_rep=rep;
	listIndex.add(lugar);
}

public String toString(){
	return "("+this.getNro()+","+this.getInd()+")";
}

public void setInd(int i){
	indice= i;
}
public int getInd(){
	return indice;
}
public int getNro (){
	return nro_rep;
}
public char getCaracter (){
	return caracter;
}
public void setNro(int n){
	nro_rep= n;
}
public void setCaracter(char c){
	caracter =c;
}


}