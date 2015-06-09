package cs;
/**
 * @author Maciej Kulikiewicz
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import bron.Bron;
import bron.Pistolety;
import bron.Snajperska;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CS {
	private static List<Gracz> CTlist = new ArrayList <Gracz> () ;
	private List<Gracz> TTlist = new ArrayList <Gracz> () ;
/**
 * Metoda dodaje CT do arraylisty
 * @param g przekazuje gracza
 *  @throws ExceptionMy
 */
	public void dodajCT(Gracz g)
	{
		try
		{
			if((TTlist.size()+2)>(CTlist.size()) && CTlist.size()<5 )
		CTlist.add(g);
			else
				throw new ExceptionMy();
		}
		catch (ExceptionMy e)
		{
			System.out.println("Zbyt wielu anty terrorystow bo : "+CTlist.size()+" i "+ TTlist.size());
		}
	}
	/**
	 * Metoda dodaje gracza Terroryst�w do arraylisty
	 * @param g przekazuje gracza
	 * @throws ExceptionMy
	 */
	public void dodajTT(Gracz g)throws ExceptionMy
	{
		try
		{
			if((CTlist.size()+2)>(TTlist.size()) && TTlist.size()<5 )
		TTlist.add(g);
			else
				throw new ExceptionMy();
		}
		catch (ExceptionMy e)
		{
			System.out.println("Zbyt wielu terroryst�w bo :"+CTlist.size()+" i "+ TTlist.size());
		}
	}
	/**
	 * Zwraca Gracza
	 * @param i gdy true to gracz terroryst�w
	 * @param tt gdy false to gracz antyterroryst�w
	 * @return gracza 
	 */
	public Gracz getGracz(int i,Boolean tt)
	{
		if(tt)
		return CTlist.get(i);
		else
		return TTlist.get(i);
	}
	public static void main(String[] args) throws ExceptionMy, IOException, ClassNotFoundException{
		
		
			CS cs = new CS();
		cs.dodajCT(new Gracz("Stefan","silver 2",100,100));
		cs.dodajCT( new Gracz("Andrzej","silver 4",100,100));
		cs.dodajCT (new Gracz("Zbyszek","zoloto 3",100,100));
		cs.dodajCT (new Gracz("Stefanek","szeryf",100,100));
		cs.dodajTT( new Gracz("Michal","zloto 1",100,100));
		cs.dodajCT(new Gracz("Marian","silver 2",100,100));
		cs.dodajCT( new Gracz("Mirek","silver 2",100,100));
		cs.dodajTT (new Gracz("Bartek","szeryf",100,100));
		cs.dodajTT( new Gracz("Piotr","zloto 1",100,100));
		cs.dodajCT(new Gracz("Maniek","silver 2",100,100));
		cs.dodajCT( new Gracz("Konrad","silver 2",100,100));
		cs.dodajCT (new Gracz("Gienio","szeryf",100,100));
		cs.dodajTT( new Gracz("Andrzej","zloto 1",100,100));
		cs.dodajTT(new Gracz("Michal","silver 2",100,100));
		cs.dodajTT( new Gracz("Michal12","silver 2",100,100));
		Bron bron= new Pistolety("beretta",20,10,30,30,30,10, false, "zielony");
		cs.getGracz(0, true).dodaj_do_gracza_Bron(bron);
		bron= new Pistolety("Glock", 13, 5,10, 33,30, 15, false, "brazowy");	
		cs.getGracz(0, true).dodaj_do_gracza_Bron(bron);
		bron = new Snajperska("AWP",10,50,10,100,30,40,100);
		cs.getGracz(0, true).dodaj_do_gracza_Bron(bron);
		
		Scanner znak=new Scanner(System.in);
		System.out.println("zapis Graczy do xml");
		System.out.println("1.Zapis");
		System.out.println("2.Odczyt");
		 ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\pracownik.dat"));
		 ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\pracownik.dat"));
		if (znak.nextInt() == 1)
		{	
			for(int i=0;i<CTlist.size() ; i++)
			{
				 wy.writeObject(CTlist.get(i));
			}
			wy.close();
			System.out.println("Zapisano");
		}
		if (znak.nextInt() == 2)
		{	
	
				Gracz p1 = (Gracz) we.readObject();
				Gracz p2 = (Gracz) we.readObject();
			System.out.println(p1 );
			System.out.println(p2 );
			System.out.println("Odczytuje" );
		}
	
	
		
	
		//Bronie bron1= new Pistolety("beretta",20,10,30,30,30,10, false, "zielony");
	}

}
