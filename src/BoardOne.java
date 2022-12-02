import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BoardOne implements StyleFormatter {
	
	ChangeListener pitsChanged;

	@Override
	public void createBoard(Mancala m, int num) {
		
		Stone stone = new Stone(0,0);
		StonesIcon icon = new StonesIcon(stone,10,10);
		JLabel stoneLabel = new JLabel(icon);

		JFrame frame = new JFrame("Mancala");
		frame.setLayout(new BorderLayout());

		JLabel playerB = new JLabel("<-- Player B");
		JLabel playerA = new JLabel("Player A -->");
		JButton undoA = new JButton("Undo");
		JButton undoB = new JButton("Undo");
		

		JLabel m1 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> B</br></html>");
		JLabel m2 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> A</br></html>");

		JPanel north = new JPanel();
		north.setBackground(Color.orange);
		north.add(playerB);
		north.add(undoB);
		frame.add(north, BorderLayout.NORTH); // playerB and undo button

		JPanel south = new JPanel();
		south.setBackground(Color.yellow);
		south.add(playerA);
		south.add(undoA);
		frame.add(south, BorderLayout.SOUTH); // player A

		JLabel bLabel = new JLabel("      B6          B5          B4          B3          B2         B1");

		JPanel mB = new JPanel(); // mancala B button
		mB.setPreferredSize(new Dimension(50, 100));
		mB.setBackground(Color.ORANGE);
		mB.setBorder(BorderFactory.createLoweredBevelBorder());

		// creating B pit buttons
		JPanel[] bPits = m.getbPits();

		bPits[0] = mB; //first element will be mancala B

		for (int i = 1; i < m.getbPits().length; i++) {
			JPanel b = new JPanel();
			b.setPreferredSize(new Dimension(50, 50));
			b.setBackground(Color.orange);
			b.setOpaque(true);
			b.setLayout(new FlowLayout());

			bPits[i] = b;
		}
		m.setbPits(bPits);

		JPanel centerTop1 = new JPanel();
		centerTop1.setLayout(new BorderLayout());
		centerTop1.add(bLabel, BorderLayout.NORTH);

		JPanel centerTop2 = new JPanel();
		for (int i = 0; i < bPits.length; i++) {
			centerTop2.add(bPits[i]);
		}

		centerTop1.add(centerTop2, BorderLayout.SOUTH);

		JLabel aLabel = new JLabel("      A1         A2          A3         A4          A5         A6");

		JPanel mA = new JPanel(); // mancala A button
		mA.setPreferredSize(new Dimension(50, 100));
		mA.setBackground(Color.yellow);
		mA.setBorder(BorderFactory.createLoweredBevelBorder());
		

		JPanel[] aPits = m.getaPits();

		// creating A pit buttons
		for (int i = 0; i < m.getaPits().length - 1; i++) {
			JPanel a = new JPanel();
			a.setPreferredSize(new Dimension(50, 50));
			a.setBackground(Color.yellow);
			a.setOpaque(true);
			a.setLayout(new FlowLayout());

			aPits[i] = a;
		}
		aPits[m.getaPits().length - 1] = mA; // last element in aButtons is mancala A
		m.setaPits(aPits);
		
		pitsChanged = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				for (int i = 0; i <= m.getaPits().length - 1; i++) {
					
					System.out.println(i + ": " + m.getA().get(i));
					
					if(m.getA().get(i) > 0) {
						aPits[i].removeAll();
						
						for(int j = 0; j < m.getA().get(i); j++) {
							aPits[i].add(new JLabel(icon));
							bPits[i].revalidate();
							aPits[i].repaint();
						}
					} 
				}
				
				int index = 7;
				
				for (int i = m.getbPits().length - 1; i >= 0; i--) {
					
					System.out.println(index + ": " + m.getA().get(index));
					
					if(m.getA().get(index) > 0) {
						bPits[i].removeAll();
						for(int j = 0; j < m.getA().get(index); j++) {
							bPits[i].add(new JLabel(icon));
							bPits[i].revalidate();
							bPits[i].repaint();
						}
						
					} 
					index++;
					
				}
				
				
			}
			
		};
		
		m.setPitsChanged(pitsChanged);

		JPanel centerBottom1 = new JPanel();
		centerBottom1.setLayout(new BorderLayout());
		centerBottom1.add(aLabel, BorderLayout.SOUTH);

		JPanel centerBottom2 = new JPanel();
		for (int i = 0; i < aPits.length; i++) {
			centerBottom2.add(aPits[i]);
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
		board.setBorder(new LineBorder(Color.PINK, 3, true));
		board.setBackground(Color.PINK);

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
}