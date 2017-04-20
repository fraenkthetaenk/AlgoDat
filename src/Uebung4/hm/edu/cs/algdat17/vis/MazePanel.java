package Uebung4.hm.edu.cs.algdat17.vis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Uebung4.hm.edu.cs.algdat17.maze.Maze;
import Uebung4.hm.edu.cs.algdat17.maze.Wall;

public class MazePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Maze maze;

	public MazePanel(Maze maze) {
		super();
		this.maze = maze;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		g2d.setColor(Color.GREEN);
		double cellWidth = size.getWidth() / maze.getColumns();
		double cellHeight = size.getHeight() / maze.getRows();
		g2d.fillRect(0, 0, (int)cellWidth, (int)cellWidth);
		g2d.setColor(Color.RED);
		g2d.fillRect((int)(size.getWidth()-cellWidth), (int)(size.getHeight()-cellHeight), (int)size.getWidth(), (int)size.getHeight());
		
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(4f));
		g2d.drawRect(0, 0, size.width, size.height);
		g2d.setColor(Color.DARK_GRAY);
		g2d.setStroke(new BasicStroke(1f));
		for (Wall wall : maze.getWalls()) {
			int leftX = (int) (wall.getColumn() * cellWidth);
			int upperY = (int) (wall.getRow() * cellHeight);
			int rightX = (int) (leftX + cellWidth);
			int lowerY = (int) (upperY + cellHeight);
			switch (wall.getDirection()) {
			case UP:
				g2d.drawLine(leftX, upperY, rightX, upperY);
				break;
			case DOWN:
				g2d.drawLine(leftX, lowerY, rightX, lowerY);
				break;
			case LEFT:
				g2d.drawLine(leftX, upperY, leftX, lowerY);
				break;
			case RIGHT:
				g2d.drawLine(rightX, upperY, rightX, lowerY);
				break;
			default:
				break;
			}
		}

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	public void setMaze(Maze maze2) {
		this.maze = maze2;
		
	}
}
