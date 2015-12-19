/*

En este problema existe la posibilidad de que nos salte un TLE si nos
somos cuidadosos. Leyendo la entrada como un string, una primera forma
de evitar este TLE es calcular el código convirtiendo el código de
barras en un long.  Trabajar con un long de forma aritmética es menos
costoso que trabajar con un string de forma posicional.

Otro aspecto para evitar (y en el que yo mismo fallé) es a la hora de
rellenar por la izquierda con 0s en caso de que las cadenas sean
menores que 8 o de 13. Rellenar por la izquierda un string implica
desplazar todas sus posiciones en memoria resultando ser una operación
muy costosa en tiempo.

Podemos evitar esto simplemente ignorándolo. El único caso que puede
resultar preocupante es a la hora de calcular el pais, pues EEUU tiene
un código de 0 en la posición de más de la izquierda. Yo he
"parcheado" esta situación simplemente contemplando que si el código
es menor que 13, en lugar de rellenar con 0s, asumo que ya lo hice y
el pais resultante es por tanto EEUU.
  

 */

import java.util.*;


public class CodigosDeBarras{

    
    public static int codigoControl(String codigo){

	int control=0;
	long icod = Long.parseLong(codigo,10);
	int digito;

	int pos=1;
	icod = icod / 10;  // quito el digito de la derecha

	while (icod > 0){
	    digito = (int)(icod % 10);

	    if ((pos % 2) != 0){
		digito = digito * 3;
	    }
	    control += digito;

	    pos++;
	    icod = icod /10;
	}

	if ((control % 10) != 0){
	    return (10 - (control % 10));
	}else{
	    return 0;
	}
    }


    public static void main(String args[]){

	Scanner in = new Scanner(System.in);

	while(true){
	    String codigo = in.nextLine();
	    if (codigo.equals("0")){
		break;
	    }

	    String pais="";

	    if (codigo.length()>8){                 
		// EAN-13

		if (codigo.length()<13){
		    // En lugar de rellenar asumo que ya lo hice 
		    pais = "EEUU";
		}

		if (pais.equals("")){
		    String prefix1 = codigo.substring(0,1);
		    String prefix2 = codigo.substring(0,2);
		    String prefix3 = codigo.substring(0,3);

		    if (prefix1.equals("0")){
			pais="EEUU";

		    }else if (prefix3.equals("380")){
			pais="Bulgaria";

		    }else if (prefix2.equals("50")){
			pais="Inglaterra";

		    }else if (prefix3.equals("539")){
			pais="Irlanda";

		    }else if (prefix3.equals("560")){
			pais="Portugal";

		    }else if (prefix2.equals("70")){
			pais="Noruega";
		
		    }else if (prefix3.equals("759")){
			pais="Venezuela";

		    }else if (prefix3.equals("850")){
			pais="Cuba";

		    }else if (prefix3.equals("890")){
			pais="India";

		    }else{
			pais="Desconocido";
		    }
		}
	    }

	     
	    int control = Character.getNumericValue(codigo.charAt(codigo.length()-1));
	    int check = CodigosDeBarras.codigoControl(codigo);
	    
	    if (control == check){
		if (pais.equals("")){
		    System.out.println ("SI");
		}else{
		    System.out.println ("SI "+pais);
		}
	    }else{
		System.out.println ("NO");
	    }
	}
    }
}
