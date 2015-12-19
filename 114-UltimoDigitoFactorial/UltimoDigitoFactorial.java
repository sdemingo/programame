/*

  Este problema tiene un truco nada obvio y que yo mismo
  desconocía. Para calcular la última cifra de cualquier factorial no
  necesitas calcular dicho factorial, si el número es mayor que 5 esta
  cifra siempre es 0. 

  A partir de cinco, el factorial siempre acaba multiplicando un 5 por
  un 2, lo que mete un diez en la fórmula que añade ese cero al final.

  Tremendo eh? ;-)  

 */

import java.util.*;


public class UltimoDigitoFactorial{


    public static void main(String args[]){

	Scanner in = new Scanner(System.in);
	int casos = in.nextInt();

	for (int i=0; i<casos; i++){
	    
	    int n = in.nextInt();
	    int fac=1;
	    if (n<5){
		for (int j=1;j<=n;j++){
		    fac *= j;
		}
		System.out.println (fac % 10);
	    }else{

		System.out.println (0);
	    }
	}
    }
}
