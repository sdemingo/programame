/**
 * Acepta el reto 141: Par�ntesis balanceados
 * 
 * Una soluci�n m�s compacta.
 */
import java.util.*;

public class Main2 {
    
    public static boolean bienParentizado(String s) {
        Deque <Character> pila = new ArrayDeque<Character>();
        String abre   = "{[(";
        String cierra = "}])"; 
        int i = 0;
        boolean estaBien = true; // Suponemos que la expresi�n est� bien e intentaremos demostrar que no es as�
        while (estaBien && i < s.length()) {
            char c = s.charAt(i);
            if (abre.indexOf(c)>=0) { // Si es un simbolo de apertura
                pila.addFirst(c);     // va a la pila directo.
            } else if (cierra.indexOf(c)>=0) { // Si es de cierre
                int pos = cierra.indexOf(c);
                if (pila.isEmpty()) {  // Si la pila est� vac�a la expresi�n no est� bien
                    estaBien = false;
                } else {
                    estaBien = (pila.removeFirst() == abre.charAt(pos)); // si no, esperamos encontrar la pareja
                }
            }
            i++;
        }
        return estaBien && pila.isEmpty(); // La expresi�n est� bien si la pila est� vac�a al final.
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            boolean bien = bienParentizado(s);
            System.out.println(bien?"YES":"NO");
        }
    }
}