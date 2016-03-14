import java.util.Scanner;
public class AdaBabbageYBernouilli {

	private static final int MODULO = 46337;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=0, p=0;
		boolean finEntrada = false;
		int suma = 0;
		
		while(!finEntrada){
			
			n = in.nextInt();
			p = in.nextInt();
			
			if((n == 0) && (p == 0) ){
				finEntrada = true;
			}else{
				suma = calcularNumero(n, p);
				System.out.println(suma);
			}
		}

	}
	private static int calcularNumero(int n, int p){
		int suma = 0;
		int potencia = 1;
		for(int i = 1; i<=n; i++){
			potencia = 1;
			for(int j = 1; j <=p; j++){
				potencia = (potencia%MODULO * i%MODULO)%MODULO;
			}
			suma = (suma%MODULO + potencia%MODULO)%MODULO;
		}
		
		return suma;
	}

}
