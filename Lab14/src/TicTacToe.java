import javax.swing.JFrame;

public class TicTacToe {

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make sure program ends, instead of just disappearing when you click the "close" button
		frame.setVisible(true);
	}
}
