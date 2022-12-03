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
		
		System.out.print("Enter the number of stones per pit (3 or 4):");
		Scanner s = new Scanner(System.in);
		
		
		String numOfStones = s.nextLine();
		int num = Integer.parseInt(numOfStones);
		
		m = new Mancala(num);
		m.setNumOfStones(num);
		a = m.getA(); // a is array list of all pits
		
		System.out.print("Which player wants to start, [a] or [b]?");
		char player = s.next().toLowerCase().charAt(0);
		
		if(player == 'a') {
			m.setPlayerATurn(true);
			m.setPlayerBTurn(false);
		} else if (player == 'b'){
			m.setPlayerATurn(false);
			m.setPlayerBTurn(true);
		}
		
		
		System.out.println("Select a board [1] or [2]: ");
		int boardChoice = s.nextInt();
		
		if(boardChoice == 1) {
			view = new BoardOne();
			
		} else if(boardChoice == 2) {
			view = new BoardTwo();
		}
		
		// concrete strategy attachment
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
		//keeping track of previous state 
		m.setPreviousState(m.getA());

		// empty the clicked pit first
		if(pitNumber >= 0 && pitNumber < 6) {
			m.getaPits()[pitNumber].removeAll();
			m.getaPits()[pitNumber].revalidate();
			m.getaPits()[pitNumber].repaint();
		} else if (pitNumber >= 7 && pitNumber < 13) {
			m.getbPits()[6 - (pitNumber - 7)].removeAll();
			m.getbPits()[6 - (pitNumber - 7)].revalidate();
			m.getbPits()[6 - (pitNumber - 7)].repaint();
		}
		
		if(pitNumber != 6 || pitNumber != 13) {
			if(m.isPlayerATurn()) {
				playerATurn(pitNumber);
				m.setPlayerATurn(false);
				m.setPlayerBTurn(true);
	
			} else if (m.isPlayerBTurn()) {
				
				playerBTurn(pitNumber);
				m.setPlayerBTurn(false);
				m.setPlayerATurn(true);
			}
			
			if(isGameOver()) {
				m.getGameOver().stateChanged(new ChangeEvent(this));
			}
			
			
			m.getPitsChanged().stateChanged(new ChangeEvent(this));
			m.getPlayerChanged().stateChanged(new ChangeEvent(this));
		}
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
	
	public void playerATurn(int pitNum) {
		int i = 0;
		
		int stones = m.getA().get(pitNum);
		int counter = 0;
		
		while (counter < stones) {
			m.getA().set(pitNum, 0);
			
			// if pit is A pit or B pit 
			
			for (i = pitNum + 1; i < allPits.length; i++) {
				
				// if it is not player B mancala, place stone
				if(i != 13) {
					// update pit value
					int temp = m.getA().get(i) + 1;
					m.getA().set(i, temp);
					
					counter++;

					if (counter == stones) {
						break;
					}

					// loop around
					if (i == allPits.length - 2) {
						i = -1;
					}
				}
			}
		}
		
		//free turn if it lands in Player A's mancala (pit# 6)
		if(i == 6) {
			playerATurn(0);
			return ;
		} else if(i >= 0 && i < 6) {
			// if it lands in player A's pits, grab the current pit and
			// player B pit opposite to it
			
			int oppositeBPit = i + ((6 - i)*2);
			
			int numA = m.getA().get(i);
			int numB = m.getA().get(oppositeBPit);
			
			
			m.getA().set(i, 0);
			m.getA().set(oppositeBPit, 0);
			
			int total = m.getA().get(6) + numA + numB;
			
			m.getA().set(6, total);
			
			m.getPitsChanged().stateChanged(new ChangeEvent(this));
			
		}
		
	}
	
	public void playerBTurn(int pitNum) {
		int i = 0;
		
		int stones = m.getA().get(pitNum);
		int counter = 0;
		
		while (counter < stones) {
			m.getA().set(pitNum, 0);
			
			// if pit is A pit or B pit 
			
			for (i = pitNum + 1; i < allPits.length; i++) {
				
				// if it is not player A mancala, place stone
				if(i != 6) {
					
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
			}
		}
		
		//free turn if it lands in Player B's mancala (pit# 13)
		if(i == 13) {
			playerBTurn(7);
			return ;
		} else if(i >= 7 && i < 13) {
			// if it lands in player 'Bs pits, grab the current pit and
			// player A pit opposite to it
			
			int oppositeAPit = i - ((i - 6)*2);
			
			int numA = m.getA().get(oppositeAPit);
			int numB = m.getA().get(i);
			
			m.getA().set(i, 0);
			m.getA().set(oppositeAPit, 0);
			
			int total = m.getA().get(13) + numA + numB;

			m.getA().set(13, total);
		
			m.getPitsChanged().stateChanged(new ChangeEvent(this));
			
		}
		
	}
	
	
	public boolean isGameOver() {
		if(playerAPitsEmpty() || playerBPitsEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public boolean playerAPitsEmpty() {
		for(int i = 0; i < 6; i++) {
			if(m.getA().get(i) != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean playerBPitsEmpty() {
		int index = 7;
		for(int i = m.getbPits().length - 1; i >= 0; i--) {
			if(m.getA().get(index) != 0) {
				return false;
			}
			index++;
		}
		
		return true;
	}
	
}