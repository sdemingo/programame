/**
 * Acepta el reto 141: Paréntesis balanceados
 * 
 * Una solución más compacta.
 */
import java.util.*;

public class Main2 {
    
    public static boolean bienParentizado(String s) {
        Deque <Character> pila = new ArrayDeque<Character>();
        String abre   = "{[(";
        String cierra = "}])"; 
        int i = 0;
        boolean estaBien = true; // Suponemos que la expresión está bien e intentaremos demostrar que no es así
        while (estaBien && i < s.length()) {
            char c = s.charAt(i);
            if (abre.indexOf(c)>=0) { // Si es un simbolo de apertura
                pila.addFirst(c);     // va a la pila directo.
            } else if (cierra.indexOf(c)>=0) { // Si es de cierre
                int pos = cierra.indexOf(c);
                if (pila.isEmpty()) {  // Si la pila está vacía la expresión no está bien
                    estaBien = false;
                } else {
                    estaBien = (pila.removeFirst() == abre.charAt(pos)); // si no, esperamos encontrar la pareja
                }
            }
            i++;
        }
        return estaBien && pila.isEmpty(); // La expresión está bien si la pila está vacía al final.
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