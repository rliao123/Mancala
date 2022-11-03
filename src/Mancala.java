import java.util.ArrayList;

public class Mancala {

	private ArrayList<Integer> a = new ArrayList<Integer>();
	private  ArrayList<Integer> b = new ArrayList<Integer>();

	private int mancalaA;
	private int mancalaB;
	private int num;

	public Mancala(int num) {
		this.num = num;
		
		for(int i = 0;i<7;i++) {
			
			
			a.add(num);
		}

		for(int i = 0;i<7;i++) {
			b.add(num);
		}

		mancalaA = 0;
		mancalaB = 0;
	}
	
	public ArrayList<Integer> getA() {
		return a;
	}
	
	public ArrayList<Integer> getB() {
		return b;
	}

//	public int getA1() {
//		return a1;
//	}
//	
//
//
//	public void addA1() {
//		a1++;
//	}
//
//	public int getA2() {
//		return a2;
//	}
//
//	public void addA2() {
//		a2++;
//	}
//
//	public int getA3() {
//		return a3;
//	}
//
//	public void addA3() {
//		a3++;
//	}
//
//	public int getA4() {
//		return a4;
//	}
//
//	public void addA4() {
//		a4++;
//	}
//
//	public int getA5() {
//		return a5;
//	}
//
//	public void addA5() {
//		a5++;
//	}
//
//	public int getA6() {
//		return a6;
//	}
//
//	public void addA6() {
//		a6++;
//	}
//
//	public int getB1() {
//		return b1;
//	}
//
//	public void addB1() {
//		b1++;
//	}
//
//	public int getB2() {
//		return b2;
//	}
//
//	public void addB2() {
//		b2++;
//	}
//
//	public int getB3() {
//		return b3;
//	}
//
//	public void addB3() {
//		b3++;
//	}
//
//	public int getB4() {
//		return b4;
//	}
//
//	public void addB4() {
//		b4++;
//	}
//
//	public int getB5() {
//		return b5;
//	}
//
//	public void addB5() {
//		b5++;
//	}
//
//	public int getB6() {
//		return b6;
//	}
//
//	public void addB6() {
//		b6++;
//	}

	public int getMancalaA() {
		return mancalaA;
	}

	public void addMancalaA() {
		mancalaA++;
	}

	public int getMancalaB() {
		return mancalaB;
	}

	public void addMancalB() {
		mancalaB++;
	}

	public int getNum() {
		return num;
	}
//
//	public void setA1(int a1) {
//		this.a1 = a1;
//	}
//	
//	public void setA2(int a2) {
//		this.a2 = a2;
//	}
//	
//	public void setA3(int a3) {
//		this.a3 = a3;
//	}
//	
//	public void setA4(int a4) {
//		this.a4 = a4;
//	}
//	
//	public void setA5(int a5) {
//		this.a5 = a5;
//	}
//	
//	public void setA6(int a6) {
//		this.a6 = a6;
//	}
}
