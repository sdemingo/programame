/*

La única dificultad de este ejercicio es darse cuenta de que la
velocidad máxima viene expresada en km/h, mientras que el tiempo está
en segundos y la distancia del tramo en metros. Por eso se necesita
convertir unidades.

Mucho cuidado también con los casos incorrectos. Distancias,
velocidades y tiempos negativos son ERROR pero hemos de contemplar
también que si son iguales a cero hemos de mostrar esa salida.

 */ 

import java.util.*;


public class RadaresTramo{

    public static void main(String args[]){

	Scanner in = new Scanner(System.in);

	while(true){
	    
	    int distanciaMetros = in.nextInt();
	    int vMax = in.nextInt();
	    int tSegundos = in.nextInt();

	    if ( (distanciaMetros == 0) && (vMax == 0) && (tSegundos == 0)){
		break;
	    }

	    if ( (distanciaMetros <= 0) || (vMax <= 0) || (tSegundos <= 0)){
		System.out.println ("ERROR");
		continue;
	    }
	    
	    double distancia = distanciaMetros / 1000.0;
	    double t = tSegundos / 3600.0;

	    double vMedia = distancia / t ;  

	    if (vMedia > vMax){

		double vPuntos = (vMax * 0.2) + vMax;

		if (vMedia >= vPuntos){
		    System.out.println ("PUNTOS");
		}else{
		    System.out.println ("MULTA");
		}

	    }else{
		System.out.println ("OK");
	    }


	}
    }
}
