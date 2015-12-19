/*

  He utilizado el string alfabeto para poder utilizar la operación
  modular sin que me molesten los signos de puntuación, lo que
  ocurriria sin usamos los códigos char directamente. Hay que tener
  también cuidado con las mayúsculas pues hay que mantener su
  correlación en el mensaje en claro pero no podemos insertarlas en
  nuestro alfabeto tras las minúsculas. Tal como pone en el enunciado
  de forma indirecta, tras la 'z' va la 'a' y no la 'A'.

*/

import java.util.*;


public class EncriptacionMensajes{

    public static void main(String args[]){

	Scanner in=new Scanner(System.in);
	String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	int codigoP = alfabeto.indexOf("p");

	try{
	    while(true){
		String linea=in.nextLine();
		int des = codigoP - alfabeto.indexOf(linea.charAt(0));
		if (des<0){
		    des = alfabeto.length() - ((-1)*des);
		}

		int vocales=0;
		String mensaje="";

		for (int i=1;i<linea.length();i++){
		    
		    int codigoCar = alfabeto.indexOf(Character.toLowerCase(linea.charAt(i)));
		    char cur;
		    if (codigoCar<0){
			cur = linea.charAt(i);
		    }else{
			int codigoNuevo = (codigoCar + des) % alfabeto.length();
			cur = alfabeto.charAt(codigoNuevo);
		    }

		    if (Character.isUpperCase(linea.charAt(i))){
			mensaje += Character.toUpperCase(cur);
		    }else{
			mensaje += cur;
		    }

		    if ( (cur == 'a') || (cur == 'e')  || (cur == 'i')
			 || (cur == 'o') || (cur == 'u') || (cur == 'A')  
			 || (cur == 'E') || (cur == 'I') || (cur == 'O') 
			 || (cur == 'U')){
			vocales++;
		    }
		
		}
		
		if (mensaje.equals("FIN")==false){
		    System.out.println (vocales);
		}else{
		    break;
		}
		
	    

	    }
	}catch(Exception e){}
    }
}
