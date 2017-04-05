package keineUebung;

/**
 * Repräsentation einer Sehenswürdigkeit (Point of Interest).
 * 
 * @author katz.bastian
 */
public class PointOfInterest {
	
	/** Geographischer Längengrad (Dezimal) */
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
	 *            geographische Länge des Punktes
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
	 * Getter für den Breitengrad.
	 * 
	 * @return geographische Breite des Punktes.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Getter für den Längengrad.
	 * 
	 * @return geographische Länge des Punktes.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Getter für die Beschreibung des Punktes.
	 * 
	 * @return Beschreibung des Punktes
	 */
	public String getName() {
		return name;
	}
}
