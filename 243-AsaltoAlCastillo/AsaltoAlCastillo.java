import java.util.Scanner;
/*
    Utilizaremos la fórmula para obtener la cantidad de divisores de los soldados que obtenemos como entrada.
    Esta fórmula consiste en obtener los divisores hasta la raíz cuadrada del número de soldados, multiplicar el número de soldados por 2, y
    si la raíz cuadrada es exacta, restaremos uno al total.
*/
public class AsaltoAlCastillo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int soldados = 0;
		int contBatallones = 0;
		
		while(true){
			soldados = Integer.parseInt(in.nextLine());
			if(soldados == 0){
				break;
			}else{
				contBatallones = 0;
				for(int i = 1; i<= Math.sqrt(soldados); i++){
					if( (soldados%i) == 0 ){
						contBatallones++;
					}
				}
				contBatallones = contBatallones*2;
				if(Math.sqrt(soldados) == (int)Math.sqrt(soldados))
					contBatallones--;
				System.out.println(contBatallones);
				
			}
			
		}

	}

}
