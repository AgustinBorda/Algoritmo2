

public class Tupla{

	private int first;
	private int last;
public  Tupla(int n,int m){
	first=n;
	last=m;
}

public Tupla(){
	first=0;
	last=0;
}

public String toString(){
	return "("+this.getFirst()+","+this.getLast()+")";
}

public void setFirst(int n){
	first= n;
}
public int getFirst(){
	return first;
}
public int getLast (){
	return last;
}
public void setLast (int n){
	last=n;
}

}
