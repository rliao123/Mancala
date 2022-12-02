import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Mancala {

	private ArrayList<Integer> a = new ArrayList<Integer>();
	private ChangeListener pitsChanged;
	private ArrayList<MouseListener> listeners = new ArrayList<MouseListener>();

	private int num;
	private int numOfStones;
	private JPanel mancalaA;
	private JPanel mancalaB;
	private JPanel[] bPits;
	private JPanel[] aPits;
	

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
		
		bPits = new JPanel[7];
		aPits = new JPanel[7];
		mancalaA = new JPanel();
		mancalaB = new JPanel();
		numOfStones = num;

	}
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public void setPitNum(int pitNum, int index) {
		a.set(index, pitNum);
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

	public JPanel[] getbPits() {
		return bPits;
	}

	public void setbPits(JPanel[] bPits) {
		this.bPits = bPits;
	}

	public JPanel[] getaPits() {
		return aPits;
	}

	public void setaPits(JPanel[] aPits) {
		this.aPits = aPits;
	}
	
	public void style(StyleFormatter s, Mancala m) {
		s.createBoard(m,numOfStones);
	}

	public JPanel getMancalaA() {
		return mancalaA;
	}

	public void setMancalaA(JPanel mancalaA) {
		this.mancalaA = mancalaA;
	}

	public JPanel getMancalaB() {
		return mancalaB;
	}

	public void setMancalaB(JPanel mancalaB) {
		this.mancalaB = mancalaB;
	}

	public ChangeListener getPitsChanged() {
		return pitsChanged;
	}

	public void setPitsChanged(ChangeListener pitsChanged) {
		this.pitsChanged = pitsChanged;
	}
	
	public void startProgram() {
		getPitsChanged().stateChanged(new ChangeEvent(this));
	}

}