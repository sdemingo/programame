import java.util.Scanner;
/*
 * Para resolver este problema usaremos dos arrays cómo contadores para las
 * letras del alfabeto, y los arrays resultantes son iguales, entonces las dos
 * frases son anagramas
 * 
 */
public class AlanSmithee {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		int numCasos = 0;
		int frase1[] = new int[26];
		int frase2[] = new int[26];
		String linea1, linea2;
		boolean sonAnagramas = true;

		try{
			numCasos = Integer.parseInt(in.nextLine());
			for(int i = 0; i< numCasos; i++){
				linea1 = in.nextLine().toLowerCase();
				linea2 = in.nextLine().toLowerCase();
				sonAnagramas = true;
				frase1 = new int[26];
				frase2 = new int[26];
				for(int j = 0; j<=linea1.length()-1; j++){
					if(alfabeto.indexOf(linea1.charAt(j)) >-1){
						frase1[alfabeto.indexOf(linea1.charAt(j))] += 1;
					}
				}
				for(int k = 0; k<=linea2.length()-1; k++){
					if(alfabeto.indexOf(linea2.charAt(k)) >-1){
						frase2[alfabeto.indexOf(linea2.charAt(k))] += 1;
					}
				}
				
				for(int l = 0; l<=frase1.length-1; l++){
					if(frase1[l] != frase2[l]){
						sonAnagramas = false;
						break;
					}

				}
				if(sonAnagramas){
					System.out.println("SI");
				}else{
					System.out.println("NO");		
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
