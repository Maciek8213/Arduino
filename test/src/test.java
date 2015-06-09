
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class test implements Serializable {

public static void main(String[] args ) throws IOException, ClassNotFoundException 
{
	
	Pracownik maciek=new Pracownik("Maciek","andrzej","kul@wp.pl" );
	
	ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\pracownik.dat"));
	
	wy.writeObject(maciek);
	wy.close();
   
	
	ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\pracownik.dat"));
    Pracownik p1 = (Pracownik)we.readObject();
    we.close();
 
    System.out.println(p1.imie + ", " + p1.nazwisko + ", " + p1.email);

}

	
}
