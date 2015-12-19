
import java.util.*;


public class ChiclesDeRegalo{


    public static void main(String args[]){

	Scanner in = new Scanner (System.in);

	while (true){
	    
	    int cambio = in.nextInt();  // numero minimo de chicles para oferta
	    int oferta = in.nextInt();  // numero de chicles por oferta
	    int totalInicial = in.nextInt();  // numero total de chicles

	    if ((cambio==0) && (oferta==0) && (totalInicial==0)){
		break;
	    }

	    
	    if (oferta >= cambio){
		System.out.println ("RUINA");
		System.exit(0);
	    }

	    boolean error = false;
	    
	    int paraCanjear = totalInicial;
	    int comidos = totalInicial;
	    //int resto = 0;
	    int anterior = 0;
       
	    while (paraCanjear >= cambio){

		anterior = paraCanjear;

		// Canjeo
		int regalo = ((int)(paraCanjear / cambio)) * oferta;
		paraCanjear = ((int)(paraCanjear % cambio));
		
		comidos = comidos + regalo;
		paraCanjear = paraCanjear + regalo;

		if (paraCanjear >= anterior ){
		    error=true;
		    break;
		}	
	    }

	    if (error){
		System.out.println ("RUINA");
	    }else{
		System.out.println (comidos+" "+paraCanjear);
	    }
	    
	}
    }
}
