package Uebung4.hm.edu.cs.algdat17.maze;

import java.util.Random;

import Uebung4.hm.edu.cs.algdat17.disjointset.DisjointSet;
import Uebung4.hm.edu.cs.algdat17.maze.Direction;

;

public class MazeCreator {

	private Random r = new Random();
	private Maze maze;
	private Wall[] walls;
	private int wallsDone = 0;
private DisjointSet checkIfUseful;
	/**
	 * Konstruktor
	 * 
	 * @param maze
	 */
	public MazeCreator(Maze maze) {
		this.maze = maze;
		walls = maze.getWalls();
		checkIfUseful = new DisjointSet(maze.getColumns()
					* maze.getRows());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.creation.Steppable#step()
	 */
	public void step() {
		

		if (!hasMoreSteps()) {
			Wall wallToRemove = pickNextWallAtRandom();
			boolean shouldRemove = false;

			switch (wallToRemove.getDirection()) {
//			case DOWN:
//				shouldRemove = !(checkIfUseful.find(wallToRemove.getColumn()
//						+ (wallToRemove.getRow() * maze.getRows())) == checkIfUseful
//						.find(wallToRemove.getColumn()
//								+ ((wallToRemove.getRow() + 1) * maze.getRows())));
//				if (shouldRemove) {
//					checkIfUseful.union(
//							wallToRemove.getColumn()
//									+ (wallToRemove.getRow() * maze.getRows()),
//							wallToRemove.getColumn()
//									+ ((wallToRemove.getRow() + 1) * maze
//											.getRows()));
//				}
//				break;
			case LEFT:
//				shouldRemove = !( checkIfUseful.find(wallToRemove.getColumn() + (wallToRemove.getRow() * maze.getRows())) == checkIfUseful.find(wallToRemove.getColumn() - 1 + (wallToRemove.getRow()) * maze.getRows()));
//				System.out.println(checkIfUseful.find(wallToRemove.getColumn() + (wallToRemove.getRow() * maze.getRows()))+ "|"+ checkIfUseful.find(wallToRemove.getColumn() - 1 + (wallToRemove.getRow()) * maze.getRows()));
//				if (shouldRemove) {
//					checkIfUseful.union(wallToRemove.getColumn()+ (wallToRemove.getRow() * maze.getRows()),	wallToRemove.getColumn()- 1	+ ((wallToRemove.getRow()) * maze.getRows()));
//				}
				shouldRemove = !(checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn())) == checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn()-1)));
				if(shouldRemove)
				{
					checkIfUseful.union(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn()), checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn()-1)));
					System.out.println(checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn())) +"|"+ checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn()-1)));
				}
				break;
//			case RIGHT:
//				shouldRemove = !(checkIfUseful.find(wallToRemove.getColumn()
//						+ (wallToRemove.getRow() * maze.getRows())) == checkIfUseful
//						.find(wallToRemove.getColumn() - 1
//								+ ((wallToRemove.getRow()) * maze.getRows())));
//				if (shouldRemove) {
//					checkIfUseful
//							.union(wallToRemove.getColumn()
//									+ (wallToRemove.getRow() * maze.getRows()),
//									wallToRemove.getColumn()
//											+ 1
//											+ ((wallToRemove.getRow()) * maze
//													.getRows()));
//				}
//				break;
			case UP:
				shouldRemove = !(checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn())) == checkIfUseful.find(cellNumber(wallToRemove.getRow()-1, wallToRemove.getColumn())));
				if(shouldRemove)
				{
					checkIfUseful.union(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn()), checkIfUseful.find(cellNumber(wallToRemove.getRow()-1, wallToRemove.getColumn())));
					System.out.println(checkIfUseful.find(cellNumber(wallToRemove.getRow(), wallToRemove.getColumn())) +"|"+ checkIfUseful.find(cellNumber(wallToRemove.getRow()-1, wallToRemove.getColumn())));
				}
				
//				shouldRemove = !(checkIfUseful.find(wallToRemove.getColumn()+ (wallToRemove.getRow() * maze.getRows())) == checkIfUseful.find(wallToRemove.getColumn()+ ((wallToRemove.getRow() - 1) * maze.getRows())));
//				System.out.println(checkIfUseful.find(wallToRemove.getColumn()+ (wallToRemove.getRow() * maze.getRows())) +"|"+checkIfUseful.find(wallToRemove.getColumn()+ ((wallToRemove.getRow() - 1) * maze.getRows())));
//				if (shouldRemove) {
//					checkIfUseful.union(
//							wallToRemove.getColumn()
//									+ (wallToRemove.getRow() * maze.getRows()),
//							wallToRemove.getColumn()
//									+ ((wallToRemove.getRow()- 1) * maze
//											.getRows()));
//				}
				break;
				default:
			}

			// TODO: Remove wall only if the two cells separated by the wall
			// aren't connected yet
			if (shouldRemove) {
				maze.remove(wallToRemove);
			}
		}
	}

	/**
	 * Wählt unter den noch nicht betrachteten Wänden eine zufällig aus.
	 * Sortiert sie dann auf den Index wallsDone und zählt den Index hoch.
	 * 
	 * @return
	 */
	private Wall pickNextWallAtRandom() {
		int randomIndex = wallsDone + r.nextInt(walls.length - wallsDone);
		Wall wallToRemove = walls[randomIndex];
		walls[randomIndex] = walls[wallsDone];
		walls[wallsDone] = wallToRemove;
		wallsDone++;
		return wallToRemove;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hm.edu.cs.algdat17.maze.creation.Steppable#hasMoreSteps()
	 */
	public boolean hasMoreSteps() {
		return wallsDone == walls.length;
	}

	/**
	 * Hilfsmethode. Berechnet einen eindeutigen Index für die Felder.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private int cellNumber(int row, int column) {
		return row * maze.getColumns() + column;
	}
}
