/*

 */

import java.util.Scanner;


public class ViajeEnElTiempo 
{
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		final int LIMIT = 1000000;  // aritmética modular...
		int casos = 0; 
		int cambios = -1;  // número de cambios
		int numActual, numSig, numSigImprimir = 0, difActual = -1, difSig;
		
		int maxCasos = in.nextInt();
		
		while (casos < maxCasos)	
		{
			numActual = in.nextInt();
			while ( (numSig = in.nextInt()) != -1) 
			{
			    // las diferencias siempre van a ser positivas
				if (numSig < numActual)  // pasamos por LIMIT
					difSig = LIMIT - numActual + numSig;
				else
					difSig = numSig - numActual;
								
				if (difSig != difActual)
					cambios++;
				
				numSigImprimir = (numSig + difSig)%LIMIT;  // siempre entre 0 y 999.999
				numActual = numSig;
				difActual = difSig;
			}
			System.out.println(cambios + " " + numSigImprimir);
			
			casos++;
			cambios = -1; 
			difActual = -1;
		}
	}
}
