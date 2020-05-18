package com.test;


/**
 * @author Jhonnathan E. Cardona S.
 * @version 1.0
 */

public class Printer {
	public static void main(String[] args) {
		final int m = 1000; // 1eros m numeros primos
		final int rr = 50;//Numero de filas
		final int cc = 4;// Numero de columnas						
		
		int p[]=Prime.getNumberPrimes(m);
		
		Page page= new Page(m, rr, cc);
		page.printNumbers(p);
		
	}
}