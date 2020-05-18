package com.test;

/**
 * 
 * @author Jhonnathan E. Cardona S.
 * @version 1.0
 */
public class Page {

	private int m;
	private int rr;
	private int cc;

	public Page(int m, int rr, int cc) {
		this.m = m;
		this.rr = rr;
		this.cc = cc;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getRr() {
		return rr;
	}

	public void setRr(int rr) {
		this.rr = rr;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	/**
	 * Muestra los numeros primos por consola
	 * 
	 * @param primes
	 */
	public void printNumbers(int[] primes) {

		int pagenumber = 1;
		int pageoffset = 1;
		int rowoffset;
		int c;
		pagenumber = 1;
		pageoffset = 1;
		while (pageoffset <= m) {
			System.out.print("the first ");
			System.out.print(Integer.toString(m));
			System.out.print(" prime numbers === page ");
			System.out.print(Integer.toString(pagenumber));
			System.out.println("\n");
			for (rowoffset = pageoffset; rowoffset <= pageoffset + rr - 1; rowoffset++) {
				for (c = 0; c <= cc - 1; c++)
					if (rowoffset + c * rr <= m)
						System.out.printf("%10d", primes[rowoffset + c * rr]);
				System.out.println();
			}
			System.out.println("\f");
			pagenumber++;
			pageoffset += rr * cc;
		}
	}

}
