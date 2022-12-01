import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class MancalaTester {

	private static ArrayList<Integer> a;
	static JButton[] allPits = new JButton[14];

	public static void main(String[] args) {

		System.out.println("Enter the number of stones per pit (3 or 4):");
		Scanner s = new Scanner(System.in);
		String numOfStones = s.nextLine();
		int num = Integer.parseInt(numOfStones);

		Mancala m = new Mancala(num);
		m.setNumOfStones(num);
		a = m.getA(); // a is array list of all pits
		
		StyleFormatter styleBoard = new BoardOne(); //when these two lines are outside of actionPerformed, it works
		m.style(styleBoard, m);

		//ERROR
//		JFrame styleFrame = new JFrame();
//		JButton one = new JButton("Board One");
//		one.setPreferredSize(new Dimension(100,100));
//		one.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				StyleFormatter styleBoard = new BoardOne();
//				m.style(styleBoard, m);
//			}
//		});
//		JButton two = new JButton("Board Two");
//		two.setPreferredSize(new Dimension(100,100));
//		two.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				StyleFormatter styleBoard = new BoardTwo();
//				m.style(styleBoard, m);
//			}
//		});
//		styleFrame.setLayout(new FlowLayout());
//		styleFrame.add(two);
//		styleFrame.add(one);
//		styleFrame.pack();
//		styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		styleFrame.setVisible(true);

		for (int i = 0; i < m.getaButtons().length; i++) {
			// m.getaButtons()[i].addActionListener(createButtonListener(i));
			allPits[i] = m.getaButtons()[i];
		}
		int index = 7;

		for (int i = m.getbButtons().length - 1; i >= 0; i--) {

			allPits[index] = m.getbButtons()[i];
			index++;
			// m.getbButtons()[i].addActionListener(createButtonListener(i));
		}

//		// for button action listeners and moving the stones
//		allPits[0] = a1;
//		allPits[1] = a2;
//		allPits[2] = a3;
//		allPits[3] = a4;
//		allPits[4] = a5;
//		allPits[5] = a6;
//		allPits[6] = mA;
//		allPits[7] = b1;
//		allPits[8] = b2;
//		allPits[9] = b3;
//		allPits[10] = b4;
//		allPits[11] = b5;
//		allPits[12] = b6;
//		allPits[13] = mB;

		allPits[0].addActionListener(createButtonListener(0));
		allPits[1].addActionListener(createButtonListener(1));
		allPits[2].addActionListener(createButtonListener(2));
		allPits[3].addActionListener(createButtonListener(3));
		allPits[4].addActionListener(createButtonListener(4));
		allPits[5].addActionListener(createButtonListener(5));
		allPits[6].addActionListener(createButtonListener(6));
		allPits[7].addActionListener(createButtonListener(7));
		allPits[8].addActionListener(createButtonListener(8));
		allPits[9].addActionListener(createButtonListener(9));
		allPits[10].addActionListener(createButtonListener(10));
		allPits[11].addActionListener(createButtonListener(11));
		allPits[12].addActionListener(createButtonListener(12));
		allPits[13].addActionListener(createButtonListener(13));

	}

	public static ActionListener createButtonListener(final int index) {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int stones = a.get(index);
				int counter = 0;

				if (a.get(index) != 0) {

					while (counter < stones) {

						a.set(index, 0);
						allPits[index].setText("0");

						for (int i = index + 1; i < allPits.length; i++) {

							int temp = a.get(i) + 1;
							a.set(i, temp);

							// update the value
							allPits[i].setText(String.valueOf(a.get(i)));
							counter++;

							if (counter == stones) {
								break;
							}

							// loop around
							if (i == allPits.length - 1) {
								i = -1;
							}

						}
					}
				}
			}
		};
	}
}
