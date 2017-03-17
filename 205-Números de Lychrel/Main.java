/**
 * Acepta el reto 205: Numeros de Lychrel
 * @author Victor
 * @version 2017-02-23
 */
import java.util.*;
public class Main {

    /**
     * Devuelve un entero con los dígitos de n en posiciones inversas
     */
    public int reverse(int n) {
        int r=0;
        int n1 = n;
        while (n1 > 0) {
            r = r * 10 + (n1 % 10);
            n1 = n1 / 10;
        }
        return r;
    }

    /**
     * Comprueba si un número es capicúa
     */
    public boolean esCapicua(int n) {
        return n == reverse(n);
    }

    public void lychrel(int num) {
        int cuenta = 1;
        int n = num;
        int rn = reverse(n); // reverse n
        boolean encontrado = false;

        // un bucle de búsqueda lineal
        while (!encontrado && (n + rn) <= 1000000000) {
            if (esCapicua(n + rn)) {
                encontrado = true;
            } else {
                n = n+rn;
                rn = reverse(n); 
                cuenta++;
            }
        }
        if (encontrado) {
            System.out.format("%d %d%n", cuenta, n + rn);
        } else {
            System.out.format("Lychrel?%n");
        }
    }

    public void run() {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n; i++) {
            int num=Integer.parseInt(in.nextLine().trim());
            lychrel(num);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}