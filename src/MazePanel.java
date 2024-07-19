import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
	/*private final int[][] maze = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 },
			{ 1, 1, 1, 1, 1, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
	};*/
	private final int[][] maze = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
	};
	private final int TILE_SIZE = 25;
	private final int MAZE_SIZE = maze.length;
	private int playerX = 1;
	private int playerY = 1;

	public MazePanel() {
		setPreferredSize(new Dimension(MAZE_SIZE * TILE_SIZE, MAZE_SIZE * TILE_SIZE));
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				movePlayer(e.getKeyCode());
				repaint();
			}
		});
	}

	private void movePlayer(int keyCode) {
		int newX = playerX;
		int newY = playerY;
		switch (keyCode) {
		case KeyEvent.VK_UP -> newY--;
		case KeyEvent.VK_DOWN -> newY++;
		case KeyEvent.VK_LEFT -> newX--;
		case KeyEvent.VK_RIGHT -> newX++;
		}
		if (isMoveValid(newX, newY)) {
			playerX = newX;
			playerY = newY;
		}
	}

	private boolean isMoveValid(int x, int y) {
		return x >= 0 && x < MAZE_SIZE && y >= 0 && y < MAZE_SIZE && maze[y][x] == 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int y = 0; y < MAZE_SIZE; y++) {
			for (int x = 0; x < MAZE_SIZE; x++) {
				if (maze[y][x] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
					g.setColor(Color.LIGHT_GRAY);
					g.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}
		g.setColor(Color.RED);
		g.fillOval(playerX * TILE_SIZE, playerY * TILE_SIZE, TILE_SIZE, TILE_SIZE);
	}
}
