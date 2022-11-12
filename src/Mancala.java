import java.util.ArrayList;

public class Mancala {

	private ArrayList<Integer> a = new ArrayList<Integer>();

	private int num;

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

	}
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public int getNum() {
		return num;
	}

}
