package uebung3;



/**
 * Datentyp zum Speichern einer geordneten Folge von Objekten.
 */
public interface Sequence {

	/**
	 * @return Anzahl der enthaltenen Elemente
	 */
	int size();

	/**
	 * Liefert ein durch einen Index bestimmtes Folgenglied (0-basiert).
	 * 
	 * @param index
	 * @return Element an der index-ten Stelle
	 * @throws IndexOutOfBoundsException
	 *             wenn {@code index<0} oder {@code index>=size()}
	 */
	Object get(int index) throws IndexOutOfBoundsException;

	/**
	 * Erweitert die Folge um einen zusätzlichen Wert (am Ende).
	 * 
	 * @param val
	 *            zu ergänzendes {@link Object}
	 */
	void addLast(Object val);

	/**
	 * Fügt ein Element an der durch {@code index} beschriebenen Stelle in die
	 * Sequenz ein. Das bedeutet, dass sich die Indizes des bisher an dieser
	 * Stelle befindlichen ELements und aller folgenden Elemente um jeweils 1
	 * erhöht.
	 * 
	 * @param index
	 *            Stelle, an der ein Objekt eingefügt werden soll.
	 * @param val
	 *            einzufügendes {@link Object}
	 * @throws IndexOutOfBoundsException
	 *             wenn {@code index<0} oder {@code index>=size()}
	 */
	void insert(int index, Object val) throws IndexOutOfBoundsException;

	/**
	 * Löscht das Element an der durch {@code index} beschriebenen Stelle. Das
	 * bedeutet, dass sich die Indizes aller folgenden Elemente um jeweils 1
	 * verringert.
	 * 
	 * @param index
	 *            Stelle, an der ein Objekt gelöscht werden soll.
	 * @throws IndexOutOfBoundsException
	 *             wenn {@code index<0} oder {@code index>=size()}
	 */
	void delete(int index) throws IndexOutOfBoundsException;
}
