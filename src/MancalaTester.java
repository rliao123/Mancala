import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class MancalaTester {

	public static void main(String[] args) {

		System.out.println("Enter the number of stones per pit (3 or 4):");
		Scanner s = new Scanner(System.in);
		String numOfStones = s.nextLine();
		int num = Integer.parseInt(numOfStones);
		Mancala m = new Mancala(num);
		ArrayList<Integer> a = m.getA();
		ArrayList<Integer> b = m.getB();

		JFrame frame = new JFrame("Mancala");
		frame.setSize(400, 400);
		frame.setLayout(new BorderLayout());

		JLabel playerB = new JLabel("<-- Player B");
		JLabel playerA = new JLabel("Player A -->");
		JButton undo = new JButton("Undo");

		JLabel m1 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> B</br></html>");
		JLabel m2 = new JLabel("<html>M<br>A</br><br>N</br><br>C</br><br>A</br><br>L</br><br>A<br><br> A</br></html>");

		JPanel north = new JPanel();
		north.add(playerB);
		north.add(undo);
		frame.add(north, BorderLayout.NORTH); // playerB and undo button

		JPanel south = new JPanel();
		south.add(playerA);
		frame.add(south, BorderLayout.SOUTH); // player A
		
		JButton mB = new JButton(String.valueOf(m.getMancalaA())); // mancala B button
		JButton mA = new JButton(String.valueOf(m.getMancalaB())); // mancala A button
		mB.setPreferredSize(new Dimension(50, 100));
		mA.setPreferredSize(new Dimension(50, 100));

		JLabel bLabel = new JLabel("      B6          B5          B4          B3          B2         B1");

		JButton[] bButtons = new JButton[6];

		JButton b6 = new JButton(String.valueOf(b.get(5)));
		b6.setPreferredSize(new Dimension(50, 50));
		JButton b5 = new JButton(String.valueOf(b.get(4)));
		b5.setPreferredSize(new Dimension(50, 50));
		JButton b4 = new JButton(String.valueOf(b.get(3)));
		b4.setPreferredSize(new Dimension(50, 50));
		JButton b3 = new JButton(String.valueOf(b.get(2)));
		b3.setPreferredSize(new Dimension(50, 50));
		JButton b2 = new JButton(String.valueOf(b.get(1)));
		b2.setPreferredSize(new Dimension(50, 50));
		JButton b1 = new JButton(String.valueOf(b.get(0)));
		b1.setPreferredSize(new Dimension(50, 50));

		bButtons[0] = b1;
		bButtons[1] = b2;
		bButtons[2] = b3;
		bButtons[3] = b4;
		bButtons[4] = b5;
		bButtons[5] = b6;

		JPanel centerTop1 = new JPanel();
		centerTop1.setLayout(new BorderLayout());
		centerTop1.add(bLabel, BorderLayout.NORTH);

		JPanel centerTop2 = new JPanel();
		for (int i = 0; i < bButtons.length; i++) {
			centerTop2.add(bButtons[i]);
		}

		centerTop1.add(centerTop2, BorderLayout.SOUTH);

		JLabel aLabel = new JLabel("      A1         A2          A3         A4          A5         A6");

		JButton[] aButtons = new JButton[6];
		JButton a6 = new JButton(String.valueOf(a.get(5)));
		a6.setPreferredSize(new Dimension(50, 50));
		JButton a5 = new JButton(String.valueOf(a.get(4)));
		a5.setPreferredSize(new Dimension(50, 50));
		JButton a4 = new JButton(String.valueOf(a.get(3)));
		a4.setPreferredSize(new Dimension(50, 50));
		JButton a3 = new JButton(String.valueOf(a.get(2)));
		a3.setPreferredSize(new Dimension(50, 50));
		JButton a2 = new JButton(String.valueOf(a.get(1)));
		a2.setPreferredSize(new Dimension(50, 50));
		JButton a1 = new JButton(String.valueOf(a.get(0)));
		a1.setPreferredSize(new Dimension(50, 50));

		aButtons[0] = a1;
		aButtons[1] = a2;
		aButtons[2] = a3;
		aButtons[3] = a4;
		aButtons[4] = a5;
		aButtons[5] = a6;

		aButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (m.getA().get(0) != 0) {

					for (int i = 0; i <= a.get(0); i++) {
						int temp = a.get(i) + 1;
						a.set(i, temp);
						System.out.println(a.get(i));
					}
					a.set(0, 0);
					aButtons[0].setText("0");
					aButtons[1].setText(String.valueOf(a.get(1)));
					aButtons[2].setText(String.valueOf(a.get(2)));
					aButtons[3].setText(String.valueOf(a.get(3)));

					if (m.getNum() == 4) {
						aButtons[4].setText(String.valueOf(a.get(4)));
					}

				}
			}
		});
		
		aButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (m.getA().get(1) != 0) {

					for (int i = 1; i <= a.get(1); i++) {
						int temp = a.get(i) + 1;
						a.set(i, temp);
						System.out.println(a.get(i));
					}
					a.set(1, 0);
					aButtons[1].setText("0");
					aButtons[2].setText(String.valueOf(a.get(2)));
					aButtons[3].setText(String.valueOf(a.get(3)));
					aButtons[4].setText(String.valueOf(a.get(4)));

					if (m.getNum() == 4) {
						aButtons[5].setText(String.valueOf(a.get(5)));
					}

				}
			}
		});

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
		board.setBorder(new LineBorder(Color.RED, 1, true));

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
