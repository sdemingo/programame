import java.util.Scanner;

public class PostesCercado {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double alto, ancho, separacion;
		int postes;
		
		while(true){
			alto = in.nextInt();
			if(alto == 0){
				break;
			}else{
				ancho = in.nextInt();
				separacion = in.nextInt();
				postes = (int) (Math.ceil(alto/separacion)*2 + Math.ceil( ancho/separacion)*2);
				
				System.out.println(postes);
			}
		}
	}

}
