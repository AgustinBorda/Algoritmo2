package Practico1;
public class Heap<E extends Comparable>{
	private Object[] heap;
	private int cant;

	public Heap(){
		heap =  new Object [100];
		cant = 0;
	}

	public Heap(int a){
		heap = new Object [a];
		cant = 0;
	}



	public E min(E a, E b){
		if (a.compareTo(b) == -1){
			return a;
		}
		else{
			return b;
		}
	}

	public String toString(){
		String aux ="";
		int i = 0;
		while(i<cant){
			aux = aux + heap[i] +" ";
			i++;
		}
		return aux;
	}
 
	public void insert(E elem){
		this.heap[cant] = elem;
		cant++; // insertamos al final
		int i = cant-1; 
		while (i >0){ // si algun hijo es menor que su padre, intercambiamos sus lugares
			if (((E)this.heap[i]).compareTo((E)this.heap[(i-1)/2]) == -1){
				E aux = (E)this.heap[i];
				this.heap[i] = this.heap[(i-1)/2];
				this.heap[(i-1)/2] = aux;
			}
			i = i-1;

		}
	}

	public E get(){
		return (E)this.heap[0];
	}

	public void remove(){
		E aux = (E)this.heap[0];
		this.heap[0] = this.heap[cant-1];
		this.heap[cant-1] = aux; //intercambiamos el elemento a borrar con el ultimo
		cant --; // borramos el ultimo elemento
		int i = 0;
		while(2*(i+1)<cant){ /*si el nuevo primer elemento es mayor que el minimo de sus hijos, intercambiamos sus lugares, sino asumimos que el heap ya esta restaurado*/
			if(((E)this.heap[i]).compareTo(min(((E)this.heap[(2*i)+1]),((E)this.heap[2*(i+1)])))==1){
				if (min((E)this.heap[(2*i)+1],(E)this.heap[2*(i+1)]) == (E)this.heap[(2*i)+1]){
					aux = (E)this.heap[i];
					this.heap[i] = this.heap[(2*i)+1];
					this.heap[(2*i)+1] = aux;
					i = (2*i)+1;
				}
				else{
					aux = (E)this.heap[i];
					this.heap[i] = this.heap[2*(i+1)];
					this.heap[2*(i+1)] = aux;
					i = 2*(i+1);
				}
			}
			else{
				i = cant;
			}
		}
	}

	public void vaciar(){
		this.cant = 0;
	}

	public boolean empty(){
		return this.cant == 0;
	}

	public boolean repOK(){
		int i = 0;
		boolean ok = true;
		while(2*(i+1)< this.cant && ok){
			ok = ((E)this.heap[i]).compareTo(min(((E)this.heap[(i+1)*2]),((E)this.heap[(i*2)+1]))) == -1;
			i++;
		}
		return ok;
	}

}