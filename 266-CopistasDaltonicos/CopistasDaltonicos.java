import java.util.Scanner;

public class CopistasDaltonicos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char matriz[][];
		int alto = 0, ancho = 0;
		String linea = "";
		int numDaltonicos = 0;
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String codigo;
		
		while(true){
			codigo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			linea = "";
			
			alto = in.nextInt();
			ancho =in.nextInt();
			in.nextLine();
			
			if(alto == 0 && ancho == 0){
				break;
			}else{
				
				matriz = new char[alto][ancho];
				//rellenamos matriz
				for(int i = 0; i < alto; i++){
					linea = in.nextLine();
					for(int j = 0; j < ancho; j++){
						matriz[i][j] = linea.charAt(j);
					}
				}
				//obtenemos el código de cifrado
				numDaltonicos = Integer.parseInt(in.nextLine());
				for(int k = 0; k < numDaltonicos; k++){
					linea = in.nextLine();
					codigo = codigo.replace(linea.charAt(0), linea.charAt(2));
				}
				//Recorremos la matriz e imprimimos los caracteres cifrados
				for(int l = 0; l < alto; l++){
					
					for(int m = 0; m < ancho; m++){
						System.out.print(""+codigo.charAt(alfabeto.indexOf(matriz[l][m])));							
					}
					System.out.print("\n");
				}
				
			}
			
		}

	}

}