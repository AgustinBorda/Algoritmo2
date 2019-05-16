import java.util.*;

public class SumMax{
	public static Double sumList(List<Double> list, Tupla index){
		Double suma=0.0;
		for (int i=index.getFirst();i<index.getLast();i++ ) {
			suma= suma + list.get(i);
		}
		return suma;
	}

	private static Tupla crossed(List<Double> list,int inic, int end){
		int mid= (inic+end)/2;
		int inicio=mid-1;
		int fin =mid+1;
		Double acum=0.0;
		for (int i =inicio;i>=inic ;i-- ) {
			acum+=list.get(i);
			if (acum>0) {
				inicio=i;
				acum=0.0;
			}
		}
		acum=0.0;
		for (int j=fin;j<end ;j++ ) {
			acum+=list.get(j);
			if (acum>0) {
				fin=j;
				acum=0.0;
			}
		}
		Tupla resul= new Tupla(inicio,fin);
		return resul;
	}
	private static Tupla sumaMax(List<Double> list, int inic, int fin){
		Tupla izq = new Tupla();
		Tupla der = new Tupla();
		Tupla aux = new Tupla();
		Tupla cruz = new Tupla();
		if (fin-inic==1) {
			return new Tupla(inic,fin);
		}else{
			izq= sumaMax(list,inic,(inic+fin)/2);
			der= sumaMax(list,(inic+fin)/2,fin);
			cruz= crossed(list,inic,fin);
			if (sumList(list,izq)>=sumList(list,der)) {
				aux=izq;
			}else{
				aux=der;
				aux.setFirst(aux.getFirst()+list.size()/2);
			}
			if (sumList(list,cruz)>=sumList(list,aux)) {
				return cruz;
			}else{
				return aux;
			}
		}
	}

		public static Tupla sumaMaxima(List<Double> list){
			return SumMax.sumaMax(list,0,list.size());
		}

	public static void main(String[] args) {
			 List<Double> lista= new ArrayList<Double>();
			 lista.add(-1.0);
			 lista.add(2.0);
			 lista.add(-4.0);
			 lista.add(50.0);
			System.out.println(sumaMaxima(lista).toString());
	}
}
