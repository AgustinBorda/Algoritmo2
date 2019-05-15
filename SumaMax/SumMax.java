import java.util.*; 
import javafx.util.Pair;

public class SumMax{
	public static int sumList(List<Integer> list, Tupla index){
		int suma=0;
		for (int i=index.getFirst();i<index.getLast();i++ ) {
			suma= suma + list.get(i);
		}
		return suma;
	}

	public static Tupla crossed(List<Integer> list){
		int mid= list.size()/2;
		int inicio=mid-1;
		int fin =mid+1;
		int acum=0;
		for (int i =inicio;i>=0 ;i-- ) {
			acum+=list.get(i);
			if (acum>0) {
				inicio=i;
				acum=0;
			}
		}
		acum=0;
		for (int j=fin;j<list.size() ;j++ ) {
			acum+=list.get(j);
			if (acum>0) {
				fin=j;
				acum=0;
			}
		}
		Tupla resul= new Tupla(inicio,fin);
		return resul;
	}
	public static Tupla sumaMax(List<Integer> list){
		Tupla izq = new Tupla();
		Tupla der = new Tupla();
		Tupla aux = new Tupla();
		Tupla cruz = new Tupla();
		if (list.size()==1) {
			return aux;
		}else{
			izq= sumaMax(list.subList(0,list.size()/2));
			der= sumaMax(list.subList(list.size()/2,list.size()));
			cruz= crossed(list);
			if (sumList(list,izq)>=sumList(list,der)) {
				aux=izq;
			}else{
				aux=der;
			}
			if (sumList(list,cruz)>=sumList(list,aux)) {
				return cruz;
			}else{
				return aux;
			}
		}

	}

	public static void main(String[] args) {
			 List<Integer> lista= new ArrayList<Integer>();
			 lista.add(1);
			 lista.add(2);
			 lista.add(-4);
			 lista.add(50);
			 lista.add(60);
			System.out.println(sumaMax(lista).toString());
	}
}