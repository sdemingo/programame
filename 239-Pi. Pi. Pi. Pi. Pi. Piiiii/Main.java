/**
 * Acepta el reto 239: Pi. Pi. Pi. Pi. Piiii
 * 
 * Sin misterios. Es muy sencillo.
 * @author Victor
 * @version 2016-03-15
 */
import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static boolean  casoPrueba() {
        String expr = in.nextLine();
        Scanner tok = new Scanner(expr);
        
        long numDias = tok.nextInt();
        long numEmisoras = tok.nextInt();
        if (numDias == 0 && numEmisoras ==0)  {
            return false;
        }
        long segundos = numDias * numEmisoras * 24 * 6;
        
        long d = segundos / (3600*24);
        segundos = segundos % (3600*24);
        long h = segundos / 3600;
        segundos = segundos % 3600;
        long m = segundos / 60;
        segundos = segundos % 60;
        System.out.format("%d:%02d:%02d:%02d%n", d, h, m, segundos);
        return true;
    }

    public static void main(String[] args) {
        while (casoPrueba()) {
        }
    }
}