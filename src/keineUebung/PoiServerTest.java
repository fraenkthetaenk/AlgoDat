package keineUebung;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PoiServerTest {

	/** Subject under test */
	private PoiServer sut;

	@Before
	public void init() {
		sut = new PoiServer();
	}

	/**
	 * Testet eine Abfrage anhand eines hinterlegten Punktes und einem passenden
	 * Ausschnitt.
	 */
	@Test
	public void testSinglePoiHit() {
		Collection<PointOfInterest> pois = Arrays.asList(new PointOfInterest(9.479, 51.312, "Kassel"));
		sut.init(pois);
		Collection<PointOfInterest> result = sut.get(9.47, 9.54, 51.25, 51.38);
		assertEquals(1, result.size());
	}

	/**
	 * Testet eine Abfrage anhand eines hinterlegten Punktes und einem nicht
	 * passenden Ausschnitt.
	 */
	@Test
	public void testSinglePoiMiss() {
		Collection<PointOfInterest> pois = Arrays.asList(new PointOfInterest(9.479, 51.312, "Kassel"));
		sut.init(pois);
		Collection<PointOfInterest> result = sut.get(9.4, 9.45, 51.25, 51.38);
		assertEquals(0, result.size());
	}

	/**
	 * Testet eine Abfrage auf einem Gitter mit insgesamt 4 Millionen Punkten
	 * und einem Ausschnitt unter 0,1� Kantenl�nge.
	 */
	@Test
	public void testManyPoi() {
		Collection<PointOfInterest> pois = createGrid(0.005);
		sut.init(pois);
		Collection<PointOfInterest> result = sut.get(8.219, 8.321, 48.429, 48.511);
		assertEquals(357, result.size());
	}

	/**
	 * Hilfsmethode, um im relevanten Bereich ein Gitter von
	 * {@link PointOfInterest} zu erzeugen.
	 * 
	 * @param step
	 *            Gitterweite in Grad
	 * @return Erzeugte Menge von {@link PointOfInterest}
	 */
	private Collection<PointOfInterest> createGrid(double step) {
		Collection<PointOfInterest> result = new ArrayList<PointOfInterest>();
		for (double length = 5.0; length <= 15.0; length += step) {
			for (double latitude = 46.0; latitude <= 56.0; latitude += step) {
				result.add(new PointOfInterest(length, latitude, "POI@" + length + "/" + latitude));
			}
		}
		return result;
	}
}
