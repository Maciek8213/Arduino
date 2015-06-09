import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ParserXML {
	/**
	 * Metoda przedstawia obiekt w postaci xml
	 * 
	 * @param p
	 *            obiekt klasy Processor
	 * @return odwzorowanie obiektu w postaci danych xml
	 */
	public static String processor2Xml(Pracownik p) {
		XStream mapping = new XStream(new DomDriver());
		String xml = mapping.toXML(p);
		return xml;
	}

	/**
	 * Metoda zamienia dane xml na obiekt klasy Processor
	 * 
	 * @param xml
	 *            dane obiektu
	 * @return obiekt klasy Processor
	 */
	public static Pracownik xml2Processor(String xml) {
		XStream mapping = new XStream(new DomDriver());
		return (Pracownik) mapping.fromXML(xml);
	}

	/**
	 * Metoda zamienia obiekty klasy Processor zgrupowane w kontenerze ArrayList
	 * na postaæ xml i zapisuje dane w pliku
	 * 
	 * @param p
	 *            kontener z obiektami klasy Processor
	 * @param filename
	 *            nazwa pliku do zapisu obiektów
	 */
	public static void arrayListProcessor2Xml(ArrayList<Pracownik> p,
			String filename) {
		if (filename != null) {
			try {
				FileWriter f = new FileWriter(filename);
				BufferedWriter out = new BufferedWriter(f);
				XStream mapping = new XStream(new DomDriver());
				String xml = mapping.toXML(p);
				out.write(xml);
				out.close();
				System.out.println("Procesory: " + p
						+ " s¹ zapisane w pliku -> " + filename);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	/**
	 * Metoda odczytuje dane z pliku xml i zamienia je na obiekty klasy
	 * Processor zapisane w kontenerze ArrayList
	 * 
	 * @param filename
	 *            nazwa pliku z danymi
	 * @return kontener z obiektami
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Pracownik> xml2ArrayListProcessor(String filename) {
		String xml = "";
		String strLine = "";
		if (filename != null) {
			try {
				FileInputStream f = new FileInputStream(filename);
				DataInputStream in = new DataInputStream(f);
				BufferedReader r = new BufferedReader(new InputStreamReader(in));
				while ((strLine = r.readLine()) != null)
					xml += strLine;
				in.close();
				XStream mapping = new XStream(new DomDriver());
				return (ArrayList<Pracownik>) mapping.fromXML(xml);
			} catch (Exception e) {
				System.out.println(e);
				System.exit(0);
			}
		}
		return null;
	}

	
}