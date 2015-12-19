/*

  La idea de este problema es convertir todas las horas a minutos y
  trabajar en esta unidad. Solo he de tener cuidado de si las horas de
  acostarse y levantarse están en el mismo día (de diez a doce o bien
  de doce a 10 del siguiente) o están en ambos días (me acuesto antes
  de las doce de la noche y me levanto después de medianoche). Esto lo
  controlo entre las líneas 77 y 81. 

  Una vez acumulados todos los minutos de sueño lo paso a horas con la
  función minutosAhoras().

 */


import java.util.*;


public class SuenoConcursantes{


    private static int horaAminutos(int horas, int minutos){
	return (horas*+60)+minutos;
    }

    private static String minutosAhoras(int minutos){
	String hora="";
	int horas=(int)minutos / 60;
	int min=minutos % 60;

	if (horas<10){
	    hora=hora+"0"+horas;
	}else{
	    hora=hora+horas;
	}

	if (min<10){
	    hora=hora+":0"+min;
	}else{
	    hora=hora+":"+min;
	}

	return hora;
    }

    public static void main(String args[]){
	
	Scanner in=new Scanner(System.in);

	try{
	    while(true){
		String s=in.nextLine();
		int noches=Integer.parseInt(s);
		if (noches==0){
		    break;
		}

		int horaTotal=0;
		int minTotal=0;
	    
		for (int i=0;i<noches;i++){
		    String dormido=in.nextLine();

		    String []horas_s=dormido.split("-");

		    String []hora1_s=horas_s[0].split(":");
		    String []hora2_s=horas_s[1].split(":");

		    int hora1=Integer.parseInt(hora1_s[0]);
		    int hora2=Integer.parseInt(hora2_s[0]);
		    int min1=Integer.parseInt(hora1_s[1]);
		    int min2=Integer.parseInt(hora2_s[1]);

		    int minutos1=SuenoConcursantes.horaAminutos(hora1,min1);
		    int minutos2=SuenoConcursantes.horaAminutos(hora2,min2);

		    if (minutos1>minutos2){
			minTotal=minTotal+(((24*60)-minutos1) + minutos2);
		    }else{
			minTotal=minTotal+(minutos2-minutos1);
		    }
		}
		
		System.out.println (SuenoConcursantes.minutosAhoras(minTotal)); 
	    }
	}catch(Exception e){}
    }
}
