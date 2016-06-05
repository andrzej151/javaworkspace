package Lista;


public class Main {

	public static void Main(String[] args) {
		// TODO Auto-generated method stub
		Scanner odczyt = new Scanner(System.in);
		lista l=new lista();
		int menu=0;
		Object val;
		
		
		do{
			System.out.println("1. Dodaj element");
			System.out.println("2. Wyswietl");
			System.out.println("3. Usun element ...");
			System.out.println("4. Usun wszystko");
			System.out.println("5. Wielkosc");
			System.out.println("0. Koniec");
			
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
			{
				System.out.println("Podaj wartosc");
				val= odczyt.next();
				l.dodaj(val);
				
			}
				break;
			
			case 2:
			{
				l.wyswietl();	
			}
				break;
				
			case 3:
			{
				System.out.println("Podaj wartosc do usuiecia");
				val= odczyt.next();
				l.delete(val);	
			}
				break;
				
			case 4:
			{
				l.clear();
				
			}
				break;
				
			case 5:
			{
				l.wielkosc();
			}
				break;
			default:
				break;
			}
			
		}while (menu!=0);
	}

}