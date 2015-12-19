

import java.util.*;


public class QuintoMilenio{


    public static void main(String args[]){

	
	Scanner in=new Scanner(System.in);
	String s;

	s=in.nextLine();
	int casos=Integer.parseInt(s);
       

	for (int i=0;i<casos;i++){
	    String fuente=in.nextLine().toLowerCase();
	    String objetivo=in.nextLine().toLowerCase();

	    fuente = fuente.replaceAll(" ","");
	    objetivo = objetivo.replaceAll(" ","");

	    if (objetivo.length()==0){
		System.out.println ("NO");
		continue;
	    }

	    boolean encontradas=true;
	    int ultima=0;

	    for (int c=0;c<objetivo.length();c++){
		char cur=objetivo.charAt(c);

		ultima=fuente.indexOf(cur,ultima);
		if (ultima<0){
		    encontradas=false;
		    break;
		}
	    }

	    if (encontradas){
		System.out.println ("SI");
	    }else{
		System.out.println ("NO");
	    }
	}
    }
}
