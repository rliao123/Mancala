import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardTwo implements StyleFormatter {
	
	

	@Override
	public void createBoard(Mancala m, int num) {

		JFrame frame = new JFrame("Mancala");
		frame.setSize(400, 400);
		frame.setLayout(new BorderLayout());

		JLabel playerB = new JLabel("<-- Player B");
		JLabel playerA = new JLabel("Player A -->");
		JButton undo = new JButton("Undo");
		
		Stone s = new Stone(7,7,num);
		StonesIcon icon = new StonesIcon(s,10,10);
		//JButton test = new JButton(icon);
		//test.setText(playerB);

		JLabel m1 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> B</br></html>");
		JLabel m2 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> A</br></html>");

		JPanel north = new JPanel();
		north.setBackground(Color.pink);
		north.add(playerB);
		north.add(undo);
		
		
		//north.add(test);
		
		
		frame.add(north, BorderLayout.NORTH); // playerB and undo button

		JPanel south = new JPanel();
		south.setBackground(Color.LIGHT_GRAY);
		south.add(playerA);
		frame.add(south, BorderLayout.SOUTH); // player A

		JLabel bLabel = new JLabel("      B6          B5          B4          B3          B2         B1");

		JButton mB = new JButton("mB"); // mancala B button
		mB.setPreferredSize(new Dimension(50, 100));

		JButton[] bButtons = m.getbButtons();

		bButtons[0] = mB;

		// creating B pit buttons
		for (int i = 1; i < m.getbButtons().length; i++) {
			JButton b = new JButton(icon);
			b.setPreferredSize(new Dimension(50, 50));
			b.setBackground(Color.pink);
			b.setOpaque(true);

			bButtons[i] = b;
		}
		m.setbButtons(bButtons);

		JPanel centerTop1 = new JPanel();
		centerTop1.setLayout(new BorderLayout());
		centerTop1.add(bLabel, BorderLayout.NORTH);

		JPanel centerTop2 = new JPanel();
		for (int i = 0; i < bButtons.length; i++) {
			centerTop2.add(bButtons[i]);
		}

		centerTop1.add(centerTop2, BorderLayout.SOUTH);

		JLabel aLabel = new JLabel("      A1         A2          A3         A4          A5         A6");

		JButton mA = new JButton("mA"); // mancala A button
		mA.setPreferredSize(new Dimension(50, 100));

		JButton[] aButtons = m.getaButtons();

		// creating A pit buttons
		for (int i = 0; i < m.getaButtons().length - 1; i++) {
			JButton a = new JButton(icon);
			a.setPreferredSize(new Dimension(50, 50));
			a.setBackground(Color.lightGray);
			a.setOpaque(true);

			aButtons[i] = a;
		}
		aButtons[m.getaButtons().length - 1] = mA; // last element in aButtons is mancala A
		m.setaButtons(aButtons);

		JPanel centerBottom1 = new JPanel();
		centerBottom1.setLayout(new BorderLayout());
		centerBottom1.add(aLabel, BorderLayout.SOUTH);

		JPanel centerBottom2 = new JPanel();
		for (int i = 0; i < aButtons.length; i++) {
			centerBottom2.add(aButtons[i]);
		}

		centerBottom1.add(centerBottom2, BorderLayout.NORTH);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(centerTop1, BorderLayout.NORTH); // B6,B5,B4,B3,B3,B1 and corresponding square button
		center.add(centerBottom1, BorderLayout.SOUTH); // A1,A2,A3,A4,A5,A6 and corresponding square button

		JPanel board = new JPanel(); // mancala board
		board.setLayout(new BorderLayout());
		board.add(center, BorderLayout.CENTER);
		board.add(mB, BorderLayout.WEST);
		board.add(mA, BorderLayout.EAST);
		board.setBorder(new LineBorder(Color.black, 4, true));
		board.setBackground(Color.black);

		JPanel centerAll = new JPanel(); // mancala board and labels
		centerAll.setLayout(new BorderLayout());
		centerAll.add(board, BorderLayout.CENTER);
		centerAll.add(m1, BorderLayout.WEST);
		centerAll.add(m2, BorderLayout.EAST);

		frame.add(centerAll, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
//	public static void main (String[] args) {
//		Mancala m = new Mancala(3);
//		BoardTwo b = new BoardTwo();
//		b.createBoard(m,m.getNumOfStones());
//		
//	}
}
