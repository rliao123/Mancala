import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Mancala {

	private ArrayList<Integer> a = new ArrayList<Integer>();
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

	private int num;
	private int numOfStones;
	private JButton[] bButtons;
	private JButton[] aButtons;
	

	public Mancala(int num) {
		this.num = num;
		
		for(int i = 0;i<6;i++) {
			a.add(num);
		}
		a.add(0);
		
		for(int i = 0;i<6;i++) {
			a.add(num);
		}
		a.add(0);
		
		bButtons = new JButton[7];
		aButtons = new JButton[7];
		numOfStones = num;

	}
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public int getNum() {
		return num;
	}

	public int getNumOfStones() {
		return numOfStones;
	}

	public void setNumOfStones(int numOfStones) {
		this.numOfStones = numOfStones;
	}

	public JButton[] getbButtons() {
		return bButtons;
	}

	public void setbButtons(JButton[] bButtons) {
		this.bButtons = bButtons;
	}

	public JButton[] getaButtons() {
		return aButtons;
	}

	public void setaButtons(JButton[] aButtons) {
		this.aButtons = aButtons;
	}
	
	public void style(StyleFormatter s, Mancala m) {
		s.createBoard(m,numOfStones);
	}

}
