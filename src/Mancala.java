
public class Mancala {

	private int a1;
	private int a2;
	private int a3;
	private int a4;
	private int a5;
	private int a6;
	private int b1;
	private int b2;
	private int b3;
	private int b4;
	private int b5;
	private int b6;
	private int mancalaA;
	private int mancalaB;
	private int num;

	public Mancala(int num) {
		this.num = num;
		a1 = num;
		a2 = num;
		a3 = num;
		a4 = num;
		a5 = num;
		a6 = num;

		b1 = num;
		b2 = num;
		b3 = num;
		b4 = num;
		b5 = num;
		b6 = num;

		mancalaA = 0;
		mancalaB = 0;
	}

	public int getA1() {
		return a1;
	}

	public void addA1() {
		a1++;
	}

	public int getA2() {
		return a2;
	}

	public void addA2() {
		a2++;
	}

	public int getA3() {
		return a3;
	}

	public void addA3() {
		a3++;
	}

	public int getA4() {
		return a4;
	}

	public void addA4() {
		a4++;
	}

	public int getA5() {
		return a5;
	}

	public void addA5() {
		a5++;
	}

	public int getA6() {
		return a6;
	}

	public void addA6() {
		a6++;
	}

	public int getB1() {
		return b1;
	}

	public void addB1() {
		b1++;
	}

	public int getB2() {
		return b2;
	}

	public void addB2() {
		b2++;
	}

	public int getB3() {
		return b3;
	}

	public void addB3() {
		b3++;
	}

	public int getB4() {
		return b4;
	}

	public void addB4() {
		b4++;
	}

	public int getB5() {
		return b5;
	}

	public void addB5() {
		b5++;
	}

	public int getB6() {
		return b6;
	}

	public void addB6() {
		b6++;
	}

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
}
