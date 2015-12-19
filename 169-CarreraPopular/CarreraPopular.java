/*

  La idea general de esta solución es ir comparando cada apellido con
  el anterior, pues lo hermanos deben ir juntos en la lista. Cada vez
  que me encuentro un nuevo apellido actualizo la variable familia y
  el contador de hermanos de esa familia. Este contador avanza 2
  puestos la primera vez y luego se incrementa de uno en uno.

  Una vez me encuentro un apellido que no coincide con el de esa
  familia, seguro que ya no encontraré más hermanos, actualizo el
  string familia, añado los hermanos de esa familia a la variable
  corredoresConHermanos (corredores con al menos un hermano en la
  carrera) y reseteo el contador de hermanos para prepararme por si
  encuentro una nueva familia.

 */

import java.util.*;

public class CarreraPopular{


    public static void main(String args[]){
	
	Scanner in=new Scanner(System.in);
	int casos=Integer.parseInt(in.nextLine());


	try{
	    for (int i=0;i<casos;i++){
		boolean fin=true;

		String familia="";
		int hermanosFamilia=0;
		int corredoresConHermanos=0;
		String apellido;
		int corredores=0;

		while(true){
		    String linea=in.nextLine();
		    if (linea.equals("====")){
			break;
		    }

		    String []campos=linea.split(",");
		    apellido=campos[0].toLowerCase().trim();
		    
		    if (apellido.equals(familia)){
			// añado miembros a esa familia
			if (hermanosFamilia==0){
			    hermanosFamilia=2;
			}else{
			    hermanosFamilia++;
			}
		    }else{ // cambio de familia
			familia=apellido; 
			corredoresConHermanos = corredoresConHermanos + hermanosFamilia;
			hermanosFamilia=0;
		    }
		    corredores++;
		}

		corredoresConHermanos = corredoresConHermanos + hermanosFamilia;
		System.out.println (corredores+" "+corredoresConHermanos);
	    }

	}catch(Exception e){
	    e.printStackTrace();
	}	
    }
}
