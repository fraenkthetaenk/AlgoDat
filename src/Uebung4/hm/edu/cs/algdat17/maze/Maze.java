package Uebung4.hm.edu.cs.algdat17.maze;

/**
 * Interface für Labyrinthe. 
 * 
 * @author katz.bastian
 *
 */
public interface Maze {

	/**
	 * @return Anzahl der Felder vertikal
	 */
	int getRows();

	/**
	 * @return Anzahl der Felder horizontal
	 */
	int getColumns();

	
	/**
	 * Entfernt eine Wand.
	 * @param wall zu entfernende Wand.
	 */
	void remove(Wall wall);

	/**
	 * Liefert alle Wände des Labyrinths zurück.
	 * @return
	 */
	Wall[] getWalls();

}