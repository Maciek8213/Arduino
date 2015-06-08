package bron;
/**
 * 
 * @author Maciej Kulikiewcz
 *
 */
public abstract class Bron {
	public String nazwa;
	public int dmg;
	public int rozrzut;
	public int ciezar;
	public int zasieg;
	protected int Stan_naboi;
	protected boolean celownik;
	/**
	 * Konstruktor 7 argumentowy
	 * @param nazwa nazwa broni
	 * @param zasieg zasieg broni
	 * @param ciezar ciezar broni
	 * @param dmg	obrazenia
	 * @param ilosc_naboi ilosc wszystkich dostepnych kul
	 * @param rozrzut rozrzut broni
	 */
	public Bron(String nazwa , int zasieg , int ciezar ,int dmg, int ilosc_naboi, int rozrzut)
	{	this.nazwa= nazwa;
		this.ciezar=ciezar;
		this.dmg=dmg;
		Stan_naboi=ilosc_naboi;
		this.rozrzut=rozrzut;
	}
	/**
	 * Konstruktor jedno argumentowy
	 * @param celownik celownik broni
	 */
	public Bron(boolean celownik)
	{
		if (celownik == false)
		{
			this.celownik= false;
		}
		
	}
	/**
	 * Konstruktor Domyslny

	 */
	public Bron()
	{
		this("USP-S", 100, 10 , 33 ,54 , 3);
	}
	/**
	 * przyslonieta metoda toString
	 */
	public abstract int obrazenia();
	public abstract int ciazar();

	public String toString() 
	{
		return("Nazwa broni" + nazwa + "Zasieg broni"+ zasieg + "Obrazenia zadawane " + dmg);
	}
	

}
