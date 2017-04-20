package Uebung4.hm.edu.cs.algdat17.maze;

import java.util.Collection;
import java.util.HashSet;

public class MyMaze implements Maze {

	private int rows;
	private int columns;
	private Collection<Wall> walls;

	/**
	 * Erzeugt ein neues Labyrinth mit allen möglichen Wänden.
	 * 
	 * @param rows
	 *            Anzahl der Felder vertikal
	 * @param columns
	 *            Anzahl der Felder horizontal
	 */
	public MyMaze(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.walls = new HashSet<Wall>();
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				// Create only left and up walls
				if (row > 0) {
					walls.add(new Wall(row, col, Direction.LEFT));
				}
				if (col > 0) {
					walls.add(new Wall(row, col, Direction.UP));
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.Maze#getRows()
	 */
	public int getRows() {
		return rows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.Maze#getColumns()
	 */
	public int getColumns() {
		return columns;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.Maze#remove(hm.edu.cs.algdat17.maze.Wall)
	 */
	public void remove(Wall wall) {
		walls.remove(wall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.Maze#getWalls()
	 */
	public Wall[] getWalls() {
		return walls.toArray(new Wall[0]);
	}
}
