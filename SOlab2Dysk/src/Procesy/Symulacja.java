package Procesy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Symulacja {

	int [] procesy; //index tablicy oznacza index procesu w tablicy jest czas
	int czas;//symulacja zaczyna sie od 1!!
	int wskaznikAktualnegoProcesu;
	int wskaznikOstatniegoProcesu;
	
	Lista l;
	historia h;
	
	boolean noweprocesy;
	
	public Symulacja() 
	{
		// TODO Auto-generated constructor stub
		procesy=new int [10];
		
		l=new Lista();
		h=new historia();
	}
	
	
	
		
	
	void FCFS()
	{	
		procesy=new int [l.iloscprocesow()];
		h=new historia();
		czas=1;
		wskaznikAktualnegoProcesu=0;
		wskaznikOstatniegoProcesu=0;
		
		int[]ramka=l.procesyzczasu(czas);
		wskaznikOstatniegoProcesu=wskaznikOstatniegoProcesu+ramka[0];
		
		for(int i=1;i<ramka[0]+1;i++)
		{
			procesy[ramka[i]]=l.getczastrwania(ramka[i]);
		}
		
	
		while(wskaznikAktualnegoProcesu<wskaznikOstatniegoProcesu)
		{
			h.dodajproces(wskaznikAktualnegoProcesu, czas);
			while(procesy[wskaznikAktualnegoProcesu]>0)
			{
				wykonajproces(wskaznikAktualnegoProcesu);
			}
			h.zakonczproces(czas);
			wskaznikAktualnegoProcesu++;
			
		}
		
			h.podsumowanie(l);	
	}
	
	
	public void zwiekszczas()
	{
		czas++;
		int[]ramka=l.procesyzczasu(czas);
		wskaznikOstatniegoProcesu=wskaznikOstatniegoProcesu+ramka[0];
				
			for(int i=0;i<ramka[0];i++)
			{
				procesy[ramka[i+1]]=l.getczastrwania(ramka[i+1]);
			}
			
		if(ramka[0]>0)
		{
			noweprocesy=true; //wykorzystywane w sjf z wywłaszczeniem
		}
			podzialczas();
	}
	
	public void podzialczas()
	{
		System.out.println("czas "+czas);
		for(int i=0;i<wskaznikOstatniegoProcesu;i++)
		{
			System.out.print(procesy[i]+" ");
		}
		System.out.println();
	}
	
	public void wykonajproces(int nrprocesu)
	{
		zwiekszczas();
		procesy[nrprocesu]--;
		
		
	}
	
	
	public void wprowadzProcesyRecznie()
	{
		
		Scanner odczyt=new Scanner(System.in);
		
		System.out.println("ilosc procesow");
		int ilosc=odczyt.nextInt();
		
		procesy=new int [ilosc];
		
		int cza=0;
		int pom1=0,pom2=0;
		
		for(int i=0;i<ilosc;i++)
		{
			System.out.println("Podaj czas trwania procesu "+i);
			do{
				pom1=odczyt.nextInt();
				if(pom1<1)System.out.println("zla dana czas procesu musi byc wiekszy niz 0");
			}while(pom1<1);
			
			
			System.out.println("Podaj czas dodania procesu "+(i));
			do{
				pom2=odczyt.nextInt();
				if(pom2<1)System.out.println("zla dana czas dodania musi byc wiekszy niz 0");
				if(pom2<cza)
				{
					System.out.println("zla dana symulacja wymaga posorowanych czasow dodawania");
					pom2=-6;
				}
				if(pom2>cza)
				{cza=pom2;}
					
			}while(pom2<1);

			l.dodajproces(pom2, pom1);
			
		}	
		
	}
	
	public void wyswietl()
	{
		l.wyswietl();
	}
	
	public void zapis()
	{
	 l.zapisz();
	}
	
	public void wczytajplik()
	{
		l.odczyt();
	}
	
	public void SJFbezWywlaszczenia()
	{
		procesy=new int [l.iloscprocesow()];
		h=new historia();
		czas=1;
		wskaznikAktualnegoProcesu=0;
		wskaznikOstatniegoProcesu=0;
		
		int[]ramka=l.procesyzczasu(czas);
		wskaznikOstatniegoProcesu=wskaznikOstatniegoProcesu+ramka[0];
		
		for(int i=1;i<ramka[0]+1;i++)
		{
			procesy[ramka[i]]=l.getczastrwania(ramka[i]);
		}
		
		boolean lampka=true;
		int min=9999;//szukamy najkrutrzego procesu
		while(lampka)
		{
			lampka=false;
			min=9999;
			for(int i=0;i<wskaznikOstatniegoProcesu;i++)
			{
				if((min>procesy[i])&&(procesy[i]>0))
				{
					min=procesy[i];
					wskaznikAktualnegoProcesu=i;
				}
			}
			
			h.dodajproces(wskaznikAktualnegoProcesu, czas);
				while((procesy[wskaznikAktualnegoProcesu]>0))
					{
						lampka=true;
						wykonajproces(wskaznikAktualnegoProcesu);
					}
			h.zakonczproces(czas);
			
		}
		h.podsumowanie(l);
	}
	
	public void SJFzWywlaszczeniem()
	{
		procesy=new int [l.iloscprocesow()];
		h=new historia();
		czas=1;
		wskaznikAktualnegoProcesu=0;
		wskaznikOstatniegoProcesu=0;
		
		int[]ramka=l.procesyzczasu(czas);
		wskaznikOstatniegoProcesu=wskaznikOstatniegoProcesu+ramka[0];
		
		for(int i=1;i<ramka[0]+1;i++)
		{
			procesy[ramka[i]]=l.getczastrwania(ramka[i]);
		}
		
		boolean lampka=true;
		int min=9999;//szukamy najkrutrzego procesu
		while(lampka)
		{
			lampka=false;
			min=9999;
			for(int i=0;i<wskaznikOstatniegoProcesu;i++)
			{
				if((min>procesy[i])&&(procesy[i]>0))
				{
					min=procesy[i];
					wskaznikAktualnegoProcesu=i;
				}
			}
			
			h.dodajproces(wskaznikAktualnegoProcesu, czas);
				while((procesy[wskaznikAktualnegoProcesu]>0))
					{
						lampka=true;
						wykonajproces(wskaznikAktualnegoProcesu);
						if(noweprocesy)
						{
							min=9999;
							for(int i=0;i<wskaznikOstatniegoProcesu;i++)
							{
								if((min>procesy[i])&&(procesy[i]>0))
								{
									min=procesy[i];
									wskaznikAktualnegoProcesu=i;
								}
							}
							noweprocesy=false;
						}
					}
			h.zakonczproces(czas);
			
		}
		h.podsumowanie(l);
	}
	
	public void rotacyjny(int n) 
	{
		procesy=new int [l.iloscprocesow()];
		h=new historia();
		czas=1;
		wskaznikAktualnegoProcesu=0;
		wskaznikOstatniegoProcesu=0;
		
		int[]ramka=l.procesyzczasu(czas);
		wskaznikOstatniegoProcesu=wskaznikOstatniegoProcesu+ramka[0];
		
		for(int i=1;i<ramka[0]+1;i++)
		{
			procesy[ramka[i]]=l.getczastrwania(ramka[i]);
		}
		
		
		int kczasu=0;
		boolean lampka=true;
		while(lampka)
		{
			lampka=false;
			wskaznikAktualnegoProcesu=0;
			
			while(wskaznikAktualnegoProcesu<wskaznikOstatniegoProcesu)
			{
				h.dodajproces(wskaznikAktualnegoProcesu, czas);
				kczasu=0;
					while((kczasu<n)&&(procesy[wskaznikAktualnegoProcesu]>0))
						{
							lampka=true;
							wykonajproces(wskaznikAktualnegoProcesu);
							kczasu++;
						}
				h.zakonczproces(czas);
				wskaznikAktualnegoProcesu++;
			}
			
		}
		
			h.podsumowanie(l);
		
	}





	public void los() 
	{
		Random generator=new Random();
		Scanner odczyt=new Scanner(System.in);
		
		int ilosc;
		System.out.println("ilosc procesow max 50");
		do{
			
			ilosc=odczyt.nextInt();
		}while(!((ilosc>1)&&(ilosc<50)));
		
		
		procesy=new int [ilosc];
		
		int cza=0;
		int pom1=0,pom2=0;
		
		System.out.println(ilosc);
		for(int i=0;i<ilosc;i++)
		{
			
			do{
				pom1=generator.nextInt(50);
				
			}while(pom1<1);
			
			
			do{
				pom2=generator.nextInt(10)+cza;
				
				if(pom2<cza)
				{
					
					pom2=-6;
				}
				if(pom2>cza)
				{cza=pom2;}
					
			}while(pom2<1);

			l.dodajproces(pom2, pom1);
			
		}	
		
		System.out.println("wygenerowano");
	}
	
	
}
