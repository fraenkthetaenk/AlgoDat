package Uebung4.hm.edu.cs.algdat17.maze;

/**
 * Interface f�r Labyrinthe. 
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
	 * Liefert alle W�nde des Labyrinths zur�ck.
	 * @return
	 */
	Wall[] getWalls();

}