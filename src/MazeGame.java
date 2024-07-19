import javax.swing.JFrame;

public class MazeGame extends JFrame {
	 public MazeGame() {
	        add(new MazePanel());
	        setTitle("Maze Game");
	        setSize(400, 400);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {
	        MazeGame mazeGame = new MazeGame();
	        mazeGame.setVisible(true);
	    }
}
