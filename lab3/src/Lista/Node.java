package Lista;


public final class Node {
	
	protected Object dane; //pole danych
	protected Node next; //referencja na obiekt kolejny
	
	//konstruktor z referecja na nastepny obiekt
	public Node(Object val, Node next) 
	{
		this.dane = val;
		this.next = next;
	}
	
	//konstruktor bez referencji na nastepny element
	public Node(Object val) 
	{
		this(val, null);
	}
	
	
	//zwraca aktualny obiekt 
	public Object getValue(){
		return dane;
	}
	
	//zwraca kolejny element
	public Node getNext(){
		return next;
	}
	
	//ustawia referencje na kolejny element 
	public void setNext(Node n){
		next = n;
	}
	
	//ustawia nowa wartosc danych
	public void setValue(Object val)
	{
		dane = val;
	}

}
