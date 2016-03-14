import java.util.Scanner;

public class SumaDescendente {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int entrada = 0;
		int suma = 0;
		
		while(true){
			entrada = in.nextInt();
			if(entrada == 0){
				break;
			}else{
				suma = calcularSuma(entrada);
				System.out.println(suma);
			}
		}

	}
	private static int calcularSuma(int entrada){
		int suma = 0;
		int sumando = 0;
		int modulo = 10;
		String numero = String.valueOf(entrada);
		for(int i = 0; i<numero.length(); i++){
			sumando = Integer.parseInt(numero) % modulo;
			suma+= sumando;
			modulo*=10;
		}
		
		
		return suma;
	}

}
