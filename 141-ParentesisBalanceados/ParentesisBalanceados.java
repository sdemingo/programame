/*

Utilizo la clase Stack para ir apilando caracteres de apertura.  Para
este ejercicio funcionan perfectamente, la idea es ir "apilando"
paréntesis, corchetes o llaves abiertas. Cada vez que encuentro una de
sus parejas, compruebo que en la cima de la pila está su contrario. En
caso negativo, se han solapado y es un error. 

 */


import java.util.Scanner;
import java.util.Stack;


public class ParentesisBalanceados{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	Stack<Integer> pila = new Stack<Integer>(); 
	boolean error=false;       
	boolean mostradoYES=false;   
	int c;        // Caracter actual
	int cont=0;   // Contador de caracteres desde el último salto del línea

	try{
	    while ((c = System.in.read())!=-1){
		/*
		  Cada salto de línea me indica una nueva línea. Reseteo las variables
		  de control (error, mostradoYES y contador) y decido si la anterior
		  era correcta o incorrecta
		 */
		if (c=='\n'){ 

		    if (!error && cont>0){
			if (pila.empty()){
			    System.out.println ("YES");
			    mostradoYES=true;
			}else{
			    System.out.println ("NO");
			}
		    }
		    
		    pila = new Stack<Integer>(); 
		    error=false;
		    mostradoYES=false;
		    cont=0;
		}else{
		    cont++;
		}
		

		/* 
		   Si se ha detectado un error sigo pidiendo caracteres hasta
		   encontrar un salto de línea o el fin de fichero
		*/
		
		if (error){
		    continue;
		}



		if ( (c=='(') || (c=='{')  ||(c=='[') ){
		    pila.push(c);
		}
	
	
		if (c==')'){
		    if ((!pila.empty()) && (pila.peek()=='(')){
			pila.pop();
		    }else{
			error=true;
			System.out.println ("NO");
			continue;
		    }
		}


		if (c==']'){
		    if ((!pila.empty()) && (pila.peek()=='[')){
			pila.pop();
		    }else{
			error=true;
			System.out.println ("NO");
			continue;
		    }
		}


		if (c=='}'){
		    if ((!pila.empty()) && (pila.peek()=='{')){
			pila.pop();
		    }else{
			error=true;
			System.out.println ("NO");
			continue;
		    }
		}	

	    }


	    if ((error==false) && (mostradoYES==false) && cont>0){
		System.out.println ("YES");
	    }
	    
	    


	}catch(Exception ex) {
	    ex.printStackTrace();
	}
	
    }
}
