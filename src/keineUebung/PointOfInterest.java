package keineUebung;

/**
 * Repr�sentation einer Sehensw�rdigkeit (Point of Interest).
 * 
 * @author katz.bastian
 */
public class PointOfInterest {
	
	/** Geographischer L�ngengrad (Dezimal) */
	private double length;
	
	/** Geographischer Breitengrad (Dezimal) */
	private double latitude;
	
	
	/** Name/Beschreibung des Punktes */
	private String name;

	/**
	 * Konstruktor.
	 * 
	 * @param latitude
	 *            geographische Breite des Punktes
	 * @param length
	 *            geographische L�nge des Punktes
	 * @param name
	 *            Beschreibung des Punktes
	 */
	public PointOfInterest(double length, double latitude, String name) {
		super();
		this.latitude = latitude;
		this.length = length;
		this.name = name;
	}

	/**
	 * Getter f�r den Breitengrad.
	 * 
	 * @return geographische Breite des Punktes.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Getter f�r den L�ngengrad.
	 * 
	 * @return geographische L�nge des Punktes.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Getter f�r die Beschreibung des Punktes.
	 * 
	 * @return Beschreibung des Punktes
	 */
	public String getName() {
		return name;
	}
}
