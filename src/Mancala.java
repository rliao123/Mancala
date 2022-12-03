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
	private boolean playerATurn;
	private boolean playerBTurn;
	private int numUndosLeftA;
	private int numUndosLeftB;
	private ChangeListener playerChanged;
	private ChangeListener gameOver;
	private ArrayList<Integer> previousState;
	

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
		numUndosLeftA = 3;
		numUndosLeftB = 3;
		numOfStones = num;
		previousState = new ArrayList<Integer>();
		for(int i = 0; i < a.size(); i++) {
			previousState.add(a.get(i));
		}

	}
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public void setA(ArrayList<Integer> prevState){
		for(int i = 0; i < a.size(); i++) {
			a.set(i, prevState.get(i));
		}
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
		getPlayerChanged().stateChanged(new ChangeEvent(this));
	}

	public boolean isPlayerATurn() {
		return playerATurn;
	}

	public void setPlayerATurn(boolean playerATurn) {
		this.playerATurn = playerATurn;
	}

	public boolean isPlayerBTurn() {
		return playerBTurn;
	}

	public void setPlayerBTurn(boolean playerBTurn) {
		this.playerBTurn = playerBTurn;
	}

	public ChangeListener getPlayerChanged() {
		return playerChanged;
	}

	public void setPlayerChanged(ChangeListener playerChanged) {
		this.playerChanged = playerChanged;
	}

	public ChangeListener getGameOver() {
		return gameOver;
	}

	public void setGameOver(ChangeListener gameOver) {
		this.gameOver = gameOver;
	}

	public ArrayList<Integer> getPreviousState() {
		return previousState;
	}

	public void setPreviousState(ArrayList<Integer> previousState) {
		for(int i = 0; i < a.size(); i++) {
			this.previousState.set(i, a.get(i));
		}
	}

	public int getNumUndosLeftA() {
		return numUndosLeftA;
	}

	public void setNumUndosLeftA(int numUndosLeftA) {
		this.numUndosLeftA = numUndosLeftA;
	}

	public int getNumUndosLeftB() {
		return numUndosLeftB;
	}

	public void setNumUndosLeftB(int numUndosLeftB) {
		this.numUndosLeftB = numUndosLeftB;
	}

}