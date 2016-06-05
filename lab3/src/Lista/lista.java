package Lista;

public class lista {

	private Node head = new Node(null); //wartownik
	private int size; //rozmiar listy
	
	//Konstruktor domylny, tworzy pustš listę
	public lista()
	{
		clear();
	}
	
	//Metoda "czyszczšca" listę, ustawia pierwszy element listy, czyli pole next wartownika na null
	public void clear()
	{
		head.setNext(null);
		size=0;
	}
	
	
	// Metoda dodajšca nowy element do listy 
	public void dodaj(Object value)
	{
		if (head.getNext()==null) head.setNext(new Node(value)); //jeli lista jest pusta ustawiamy następnik wartownika
		
		Node last = head.getNext();
		while(last.getNext() != null) //szukamy ostatniego elementu
			last=last.getNext();
		++size;
		last.setNext(new Node(value)); //i ustawiamy jego następnik na nowy węzeł z podanš wartociš value
	}
	
	/*
	 * Metoda usuwajšca obiekt podany jako parametr
	 * zwraca true, gdy usunięto element, false w innym wypadku
	 */
	public boolean delete(Object o)
	{
		if(head.getNext() == null) return false;
		if(head.getNext().getValue().equals(o))
		{
			head.setNext(head.getNext().getNext());
			size--;
			return true;
			
		}
	
		Node delete = head.getNext();
		while(delete != null && delete.getNext() != null)
		{
			if(delete.getNext().getValue().equals(o)){
				delete.setNext(delete.getNext().getNext());
	                            size--;
				return true;
			}
			delete = delete.getNext();
		}
		return false;
	}
	
	//wyswietla ilosc elementow
	public void wielkosc()
	{
		System.out.println("lista zawiera "+size+" elementow");
		
	}
	
	//wyswietla cala liste 
	public void wyswietl()
	{
		if (head.getNext()==null) System.out.println("Lista jest pusta"); //jeli lista jest pusta 
		else
		{
			Node last = head.getNext();
		
		while(last.getNext() != null) //wypisanie koleinych obiektow
			{
			last=last.getNext();
			System.out.print(last.getValue()+" ");
			
			}
		System.out.println();
		}
	}
}