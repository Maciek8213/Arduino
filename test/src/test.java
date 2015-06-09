
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class test implements Serializable {
	
	 public static String processor2Xml(Pracownik p) 
	 {
			XStream mapping = new XStream(new DomDriver());
			String xml = mapping.toXML(p);
			return xml;
	}
	 
	 public static Pracownik xml2Processor(String xml) {
			XStream mapping = new XStream(new DomDriver());
			return (Pracownik) mapping.fromXML(xml);
		}
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
    
 		
 		Pracownik p2 = new Pracownik("jasnek","wsujel"," 2as");
 		
 		System.out.println(p1 + "\n" + p2);
 	
 		String xmlP1 = ParserXML.processor2Xml(p1);
 		
 		System.out.println(xmlP1);
 		
 		Pracownik p3 = ParserXML.xml2Processor(xmlP1);
 		System.out.println(p3);
 		
 		if(p1 == p3)
 			System.out.println("p1 i p3 to dokladnie ten sam obiekt");
 		if(p1.equals(p3))
 			System.out.println("Obiekty maja te same parametry");
 		
 		ArrayList<Pracownik> aP = new ArrayList<Pracownik>();
 		aP.add(p1);
 		aP.add(p2);
 		aP.add(p3);
 		System.out.println(aP);
 		
 		ParserXML.arrayListProcessor2Xml(aP, "Dane.xml");
 	
 		aP.clear();
 		System.out.println(aP);
 
 		aP = ParserXML.xml2ArrayListProcessor("Dane.xml");
 		System.out.println(aP);
    

   
}

	
}
