import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.*;

public class MancalaTester {

	private static ArrayList<Integer> a;
	private static StyleFormatter view;
	static JPanel[] allPits = new JPanel[14];
	private static Mancala m;

	public static void main(String[] args) {
		
		System.out.println("Enter the number of stones per pit (3 or 4):");
		Scanner s = new Scanner(System.in);
		String numOfStones = s.nextLine();
		int num = Integer.parseInt(numOfStones);
		
		m = new Mancala(num);
		m.setNumOfStones(num);
		a = m.getA(); // a is array list of all pits
		
		view = new BoardOne(); //when these two lines are outside of actionPerformed, it works
		m.style(view, m);


		for (int i = 0; i < m.getaPits().length; i++) {
			allPits[i] = m.getaPits()[i];
		}
		
		allPits[7] = m.getMancalaA();
		int index = 7;
		
		for (int i = m.getbPits().length - 1; i >= 0; i--) {
			allPits[index] = m.getbPits()[i];
			index++;
		}
		
		for(int i = 0; i < allPits.length; i++) {
			PitMouseListener p = new PitMouseListener();
			p.setMancala(m);
			p.setPitNumber(i);
			p.setPit(allPits[i], allPits);
			allPits[i].addMouseListener(p);
		}
		
		m.startProgram();
		
		
		// for undo buttons, have an array list that preserves a before change

	}
	
//	public static ActionListener createButtonListener(final int index) {
//
//		return new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				int stones = a.get(index);
//				int counter = 0;
//
//			
//			}
//		};
//	}
	
	
	
}


class PitMouseListener implements MouseListener{
	
	static JLabel stoneComponent;
	private JPanel[] allPits;
	private int pitNumber;
	private Mancala m;
	private JPanel pit;
	
	public void setPit(JPanel pit, JPanel[] allPits) {
		this.allPits = allPits;
		this.pit = pit;
	}
	
	public void setMancala(Mancala m) {
		this.m = m;
	}
	
	public void setPitNumber(int pitNumber) {
		this.pitNumber = pitNumber;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(pitNumber >= 0 && pitNumber < 6) {
			m.getaPits()[pitNumber].removeAll();
			m.getaPits()[pitNumber].revalidate();
			m.getaPits()[pitNumber].repaint();
		} else if (pitNumber >= 7 && pitNumber < 13) {
			m.getbPits()[6 - (pitNumber - 7)].removeAll();
			m.getbPits()[6 - (pitNumber - 7)].revalidate();
			m.getbPits()[6 - (pitNumber - 7)].repaint();
		}
		
		
		
		// add stone
		// call the other mouselistener
		
		// while pits are not mancalas and the number of stones in the current pit isnt 0
		
		int i = 0;
		
		while((pitNumber != 6 || pitNumber != 13) && (m.getA().get(pitNumber) > 0)) {
			int stones = m.getA().get(pitNumber);
			int counter = 0;
			
			while (counter < stones) {
				m.getA().set(pitNumber, 0);
				
				// if pit is A pit or B pit 
				
				for (i = pitNumber + 1; i < allPits.length; i++) {

					// update pit value
					int temp = m.getA().get(i) + 1;
					m.getA().set(i, temp);
					
					counter++;

					if (counter == stones) {
						break;
					}

					// loop around
					if (i == allPits.length - 1) {
						i = -1;
					}

				}
				
				if (i == 13) {
					pitNumber = 0;
				} else if(i == 6) {
					pitNumber = 7;
				} else pitNumber = i;
				
			}
			
		}
		
		m.getPitsChanged().stateChanged(new ChangeEvent(this));
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}