import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


public class GameFrame extends JFrame{
	JButton topLeft;
	JButton topMid;
	JButton topRight;
	JButton midLeft;
	JButton center;
	JButton midRight;
	JButton bottomLeft;
	JButton bottomMid;
	JButton bottomRight;

	public String[] played = new String[10];


	public GameFrame() {
		setTitle("Tic Tac Toe"); // Sets the title of the window


		setSize(300, 300);

		topLeft = new JButton();
		topLeft.setBackground(Color.yellow);
		// pass to the listener all the needed references:
		topLeft.addActionListener(new ClickListener(1, topLeft));
		topLeft.setSize(100, 100);

		topMid = new JButton();
		topMid.setBackground(Color.red);
		// pass to the listener all the needed references:
		topMid.addActionListener(new ClickListener(2, topMid));
		topMid.setSize(100, 100);

		topRight = new JButton();
		topRight.setBackground(Color.yellow);
		// pass to the listener all the needed references:
		topRight.addActionListener(new ClickListener(3, topRight));
		topRight.setSize(100, 100);

		midLeft = new JButton();
		midLeft.setBackground(Color.red);
		// pass to the listener all the needed references:
		midLeft.addActionListener(new ClickListener(4, midLeft));
		midLeft.setSize(100, 100);

		center = new JButton();
		center.setBackground(Color.yellow);
		// pass to the listener all the needed references:
		center.addActionListener(new ClickListener(5, center));
		center.setSize(100, 100);

		midRight = new JButton();
		midRight.setBackground(Color.red);
		// pass to the listener all the needed references:
		midRight.addActionListener(new ClickListener(6, midRight));
		midRight.setSize(100, 100);

		bottomLeft = new JButton();
		bottomLeft.setBackground(Color.yellow);
		// pass to the listener all the needed references:
		bottomLeft.addActionListener(new ClickListener(7, bottomLeft));
		bottomLeft.setSize(100, 100);

		bottomMid = new JButton();
		bottomMid.setBackground(Color.red);
		// pass to the listener all the needed references:
		bottomMid.addActionListener(new ClickListener(8, bottomMid));
		bottomMid.setSize(100, 100);

		bottomRight = new JButton();
		bottomRight.setBackground(Color.yellow);
		// pass to the listener all the needed references:
		bottomRight.addActionListener(new ClickListener(9, bottomRight));
		bottomRight.setSize(100, 100);

		GridLayout grid = new GridLayout(3,3);
		// setting the layout for the panel:
		setLayout(grid);
		add(topLeft); 
		add(topMid); 
		add(topRight);
		add(midLeft);
		add(center);
		add(midRight);
		add(bottomLeft);
		add(bottomMid);
		add(bottomRight);
		JButton topLeft;
		//pack();  // removes excess space (makes the frame as small as possible for its contents)
	}
	public void computerTurn(){
		Random rand = new Random();
		int compSpace = rand.nextInt(9) + 1;
		if(compSpace == 1){
			if(played[1] == null){ //play here
				topLeft.setText("O");
				played[1] = "O";
				topLeft.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 2){
			if(played[2] == null){ //play here
				topMid.setText("O");
				played[2] = "O";
				topMid.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 3){
			if(played[3] == null){ //play here
				topRight.setText("O");
				played[3] = "O";
				topRight.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 4){
			if(played[4] == null){ //play here
				midLeft.setText("O");
				played[4] = "O";
				midLeft.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 5){
			if(played[5] == null){ //play here
				center.setText("O");
				played[5] = "O";
				center.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 6){
			if(played[6] == null){ //play here
				midRight.setText("O");
				played[6] = "O";
				midRight.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 7){
			if(played[7] == null){ //play here
				bottomLeft.setText("O");
				played[7] = "O";
				bottomLeft.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 8){
			if(played[8] == null){ //play here
				bottomMid.setText("O");
				played[8] = "O";
				bottomMid.setEnabled(false);
			}else{
				computerTurn();
			}
		}

		if(compSpace == 9){
			if(played[9] == null){ //play here
				bottomRight.setText("O");
				played[9] = "O";
				bottomRight.setEnabled(false);
			}else{
				computerTurn();
			}
		}
	}

	public class ClickListener implements ActionListener {
		private int spaceOnBoard;
		private JButton button;
		private boolean won = false;

		public ClickListener(int space, JButton buttonPressed) {
			spaceOnBoard = space;
			button = buttonPressed;
		}

		public void actionPerformed(ActionEvent event) {
			played[spaceOnBoard] = "x"; 
			button.setText("X");
			button.setEnabled(false);

			if(played[1] == "x" && played[2] == "x" && played[3] == "x"){
				won = true;
			}
			if(played[4] == "x" && played[5] == "x" && played[6] == "x"){
				won = true;
			}
			if(played[7] == "x" && played[8] == "x" && played[9] == "x"){
				won = true;
			}
			if(played[1] == "x" && played[4] == "x" && played[7] == "x"){
				won = true;
			}
			if(played[2] == "x" && played[5] == "x" && played[8] == "x"){
				won = true;
			}
			if(played[3] == "x" && played[6] == "x" && played[9] == "x"){
				won = true;
			}
			if(played[1] == "x" && played[5] == "x" && played[9] == "x"){
				won = true;
			}
			if(played[3] == "x" && played[5] == "x" && played[7] == "x"){
				won = true;
			}

			if(won == true){
				JOptionPane.showMessageDialog(null, "You won!");
			}
			computerTurn();
			boolean cwon = false;

			if(played[1] == "O" && played[2] == "O" && played[3] == "O"){
				cwon = true;
			}
			if(played[4] == "O" && played[5] == "O" && played[6] == "O"){
				cwon = true;
			}
			if(played[7] == "O" && played[8] == "O" && played[9] == "O"){
				cwon = true;
			}
			if(played[1] == "O" && played[4] == "O" && played[7] == "O"){
				cwon = true;
			}
			if(played[2] == "O" && played[5] == "O" && played[8] == "O"){
				cwon = true;
			}
			if(played[3] == "O" && played[6] == "O" && played[9] == "O"){
				cwon = true;
			}
			if(played[1] == "O" && played[5] == "O" && played[9] == "O"){
				cwon = true;
			}
			if(played[3] == "O" && played[5] == "O" && played[7] == "O"){
				cwon = true;
			}
			if(cwon == true){
				JOptionPane.showMessageDialog(null, "The computer won :(");
			}
		}

	}

}

