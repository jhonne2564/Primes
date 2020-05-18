package com.test;

/**
 * 
 * @author Jhonnathan E. Cardona S.
 * @version 1.0
 */

public class Prime {

	/**
	 * Retorna los primeros numeros primos
	 * @param limit 
	 * @return  numeros primos
	 */
	public static int [] getNumberPrimes(int limit) {
		int p[] = new int[limit+1]; //Almacena los primeros  numeros primos hasta limit
		int j= 1;
		int k=1;
		boolean jprime;
		int ord=2;
		int square=9;
		int n = 0;
		final int ordmax = 30;
		int mult[] = new int[ordmax + 1];				
		p[1] = 2;
				
		while (k < limit) {
			do {
				j += 2;
				if (j == square) {
					ord++;
					square = p[ord] * p[ord];
					mult[ord - 1] = j;
				}
				n = 2;
				jprime = true;
				while (n < ord && jprime) {
					while (mult[n] < j)
						mult[n] += p[n] + p[n];
					if (mult[n] == j)
						jprime = false;
					n++;
				}
			} while (!jprime);
			k++;
			p[k] = j;
		}
		
		return p;
	}
}
