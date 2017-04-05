package keineUebung;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Klasse zum Speichern von {@link PointOfInterest}. Beantwortet schnell
 * geographische Abfragen nach Punkten in einem Kartenausschnitt.
 * 
 */
public class PoiServer {

	ArrayList<PointOfInterest>[][] PoiList;

	/**
	 * Hinterlegt eine Menge von {@link PointOfInterest}. Bestehende
	 * {@link PointOfInterest} werden vorher entfernt.
	 * 
	 * @param pois
	 *            zu hinterlegende {@link PointOfInterest}s.
	 */
	public void init(Collection<PointOfInterest> pois) {

		PoiList = (ArrayList<PointOfInterest>[][]) new ArrayList[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				PoiList[i][j] = new ArrayList<PointOfInterest>();
			}
		}
		for (PointOfInterest poi : pois) {
			PoiList[(int) ((poi.getLength() - 5) * 10)][(int) ((poi.getLatitude() - 46) * 10)].add(poi);
		}

	}

	/**
	 * Liefert alle hinterlegten {@link PointOfInterest} in einem
	 * Kartenabschnitt.
	 * 
	 * @param fromLength
	 *            begrenzende Länge (untere Grenze)
	 * @param toLength
	 *            begrenzende Länge (obere Grenze)
	 * @param fromLatitude
	 *            begrenzende Breite (untere Grenze)
	 * @param toLatitude
	 *            begrenzende Breite (obere Grenze)
	 * @return {@link PointOfInterest} im Kartenausschnitt
	 */
	public Collection<PointOfInterest> get(double fromLength, double toLength, double fromLatitude, double toLatitude) {
		Collection<PointOfInterest> result = new ArrayList<PointOfInterest>();

		int startLen = (int) ((fromLength - 5) * 10);
		int endLen = (int) ((toLength - 5) * 10);

		int startWid = (int) ((fromLatitude - 46) * 10);
		int endWid = (int) ((toLatitude - 46) * 10);

		for (PointOfInterest pointOfInterest : PoiList[startLen][startWid]) {
			if(pointOfInterest.getLength()>= fromLength && pointOfInterest.getLength()<= toLength  && pointOfInterest.getLatitude()>= fromLatitude  && pointOfInterest.getLatitude()<= toLatitude )
			{
				result.add(pointOfInterest);
			}
		}

		if (endWid != startWid) {
			for (PointOfInterest pointOfInterest : PoiList[startLen][endWid]) {
				if(pointOfInterest.getLength()>= fromLength && pointOfInterest.getLength()<= toLength  && pointOfInterest.getLatitude()>= fromLatitude  && pointOfInterest.getLatitude()<= toLatitude )
				{
					result.add(pointOfInterest);
				}
			}
			if (startLen != endWid) {
				for (PointOfInterest pointOfInterest : PoiList[endLen][endWid]) {
					if(pointOfInterest.getLength()>= fromLength && pointOfInterest.getLength()<= toLength  && pointOfInterest.getLatitude()>= fromLatitude  && pointOfInterest.getLatitude()<= toLatitude )
					{
						result.add(pointOfInterest);
					}
				}
			}
		}

		if (startLen != endWid) {
			for (PointOfInterest pointOfInterest : PoiList[endLen][startWid]) {
				if(pointOfInterest.getLength()>= fromLength && pointOfInterest.getLength()<= toLength  && pointOfInterest.getLatitude()>= fromLatitude  && pointOfInterest.getLatitude()<= toLatitude )
				{
					result.add(pointOfInterest);
				}
			}
		}

		return result;
	}

}
