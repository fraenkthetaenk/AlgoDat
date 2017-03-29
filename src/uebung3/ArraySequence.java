package uebung3;

/**
 * Implementierung einer Sequenz, bei der die Werte in einem Array abgelegt
 * werden, das bei Bedarf dynamisch vergrößert wird.
 *
 */
public class ArraySequence implements Sequence {

	/** Das unterliegende Array zum Abspeichern der Werte */
	private Object[] array = new Object[2];

	/**
	 * Anzahl der enthaltenen Werte. Nur für die Indizes {@code i<size}
	 * enthält das zugrundliegende Array relevante Werte. Die Felder des Arrays
	 * mit größeren Indizes sind "frei".
	 */
	private int size = 0;

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Sequenz hat kein Element " + index + ".");
		}
		return array[index];
	}

	/**
	 * Stellt sicher, dass das Array groß genug ist, um {@code needeSize}
	 * Elemente zu fassen. Wenn das bestehende Array dafür zu klein ist, wird
	 * es durch ein neues Array der Größe {@code size*2} ersetzt und die
	 * bestehenden Werte umkopiert.
	 * 
	 * @param capacity
	 *            Mindestgröße, die das Array für eine bevorstehende
	 *            (Einfüge-)Operation haben muss
	 */
	private void assertCapacity(int capacity) {

		// Wenn das Array groß genug ist, ist nichts zu tun.
		if (array.length >= capacity) {
			return;
		} else {

			// Erstelle neues Array doppelter Größe
			Object[] newArray = new Object[capacity * 2];

			// Kopiere Werte aus dem alten Array in das neue
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}

			// Ersetze das zugrundeliegende Array durch das neue
			array = newArray;
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("ArraySequence[");
		for (int i = 0; i < size; i++) {
			sb.append(array[i]);
			sb.append(",");
		}
		if (size > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

	/* Hier beginnen die Operationen aus dem Praktikum */

	@Override
	public void addLast(Object val) {
		if (size == array.length) {
			copyArrayToNewLarger();
		}
		array[size] = val;
		size++;

	}

	@Override
	public void insert(int index, Object val) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == array.length) {
			copyArrayToNewLarger();
		}
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = val;
		size++;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < size-1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		array[size] = null;

	}

	private void copyArrayToNewLarger() {
		Object[] arrayNew = new Object[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			arrayNew[i] = array[i];

		}

		array = arrayNew;
	}

}
