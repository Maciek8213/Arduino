package cs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bron.*;
/**
 * @author Maciej Kulikiewicz
 */
public class Gracz extends Postac implements Serializable{
	
	/**
	 * @param kewlar
	 * @param Ranga ranga gracza
	 */
	private List<Bron> bronie = new ArrayList <Bron> () ;
	protected int kewlar;
	protected String Ranga;
	protected String nazwa_postaci;
	/**
	 * konstruktor 4 parametrowy przkazujacy
	 * @param nazwe
	 * @param Randa
	 * @param zycie
	 * @param kewlar
	 */
	protected Gracz(String nazwa_postaci, String Ranga, int zycie , int kewlar )
	{
		super.zycie=zycie;
		this.kewlar=kewlar;
		this.nazwa_postaci=nazwa_postaci;
		this.Ranga=Ranga;
	}
	/**
	 * Kosntruktor domyslny
	 */
	public Gracz()
	{
		this("Nieznana" , "Silver 1 " , 100 , 100);
	}
	public String toString()
	{
		return(" Gracz : " +nazwa_postaci + " O randze : " +Ranga+ " zostalo mu : " + kewlar);
	}
	public void dodaj_do_gracza_Bron(Bron b)
	{
		try
		{
			if((bronie.size()<2 ))
				bronie.add(b);
			else
				throw new ExceptionMy();
		}
		
		catch (Exception ExceptionMy)
		{
			System.out.println("Posta� nie mo�e mie� wi�cej broni ni� :"+ bronie.size()+" ");
		}
		
	}
	
}

