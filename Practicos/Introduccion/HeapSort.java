package Practico1;
import java.util.*;
public class HeapSort{
	public static ArrayList<Integer> sort(ArrayList<Integer> a){
		Heap heap = new Heap(a.size());
		while (!a.isEmpty()){ //sacamos todos los elementos de la secuencia
			heap.insert(a.get(0)); //cargamos el heap
			a.remove(0);
		}
		while(!heap.empty()){ //vaciamos el heap
			a.add((Integer)heap.get()); //cargamos la secuencia
			heap.remove();
		}
		return a;
	}

	public static void main(String[] args){
		ArrayList<Integer> sec = new ArrayList<Integer>();
		int i = 0;
		while(i<args.length){
			sec.add(Integer.parseInt(args[0]));
		}
		
	}
}