/*

Este problema, como otros que aparecen a veces, parece lioso. Pero los
cálculos pueden simplificarse mucho y no hay que andar recorriendo la
matriz.

La idea es calcular la constante mágica a partir de los números que se
ponen. Por ejemplo, en el típico de matriz de 3x3, los números podrían
ser: 1 2 3 4 5 6 7 8 9, y observando, cada fila, columna... suma 5 x
3.

Esa es la idea aplicada en el programa.

 */

import java.util.Scanner;


public class ConstanteMagica {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lado = 0;
		do {
			lado = in.nextInt();
			if (lado != 0) {
				int inicial = in.nextInt();
				//  Cte. mágica -> [(valor inicial - valor final)/2 ]* dimension matriz
				int cMagica = ( ( lado*lado + inicial -1 + inicial )/2 )*lado;
				System.out.println(cMagica);
			}
		} while (lado != 0);
	}
}
