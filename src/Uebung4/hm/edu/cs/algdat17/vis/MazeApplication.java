package Uebung4.hm.edu.cs.algdat17.vis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Uebung4.hm.edu.cs.algdat17.maze.Maze;
import Uebung4.hm.edu.cs.algdat17.maze.MazeCreator;
import Uebung4.hm.edu.cs.algdat17.maze.MyMaze;

public class MazeApplication extends JFrame {

	MazeCreator creator;
	MazePanel comp;

	void reset(int rows, int col) {
		Maze maze = new MyMaze(rows, col);
		creator = new MazeCreator(maze);
		comp.setMaze(maze);
	}

	public MazeApplication(String string) {
		super(string);
		JPanel panel = new JPanel();
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comp = new MazePanel(new MyMaze(1, 1));
		reset(20, 20);

		panel.add(comp);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// Erzeuge Kodier-Button, binde Action, füge zum Panel hinzu
		JButton step = new JButton("Step");
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creator.step();
				repaint();
			}
		});
		panel.add(step);
		JButton step2 = new JButton("Complete");
		step2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				while (!creator.hasMoreSteps()) {
					creator.step();
				}
				repaint();

			}
		});
		panel.add(step2);

		JButton reset10 = new JButton("Reset 10x10");
		reset10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset(10,10);
				repaint();

			}
		});
		panel.add(reset10);

		JButton reset20 = new JButton("Reset 20x20");
		reset20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset(20,20);
				repaint();

			}
		});
		panel.add(reset20);

		// Layout
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createSequentialGroup().addComponent(comp).addGroup(layout.createParallelGroup(Alignment.CENTER)
						.addComponent(step).addComponent(step2).addComponent(reset10).addComponent(reset20)));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.CENTER).addComponent(comp).addGroup(layout.createSequentialGroup()
						.addComponent(step).addComponent(step2).addComponent(reset10).addComponent(reset20)));

		// Optimiere Frame und mache sichtbar
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Main-Methode.
	 * 
	 * @param args
	 *            Parameter. Werden ignoriert.
	 */
	public static void main(String[] args) {
		// Erzeuge Fenster
		new MazeApplication("A-maze-ing");
	}
}
