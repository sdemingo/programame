import java.util.*;
/**
 * 142 ¿quién empieza?
 * @author victor
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    
    public static boolean caso() {
        // uso un esquema simple para leer datos porque la validez de la
        // entrada está garantizada
        int numNinnos = in.nextInt(); 
        int salto = in.nextInt();
        if (numNinnos == 0 && salto ==0) { // si es el caso especial
            return false; // rompe el bucle
        }
        List<Integer> ninnos = new LinkedList<>(); // lista de niños.
        // LinkedList porque las eliminaciones son más eficientes que en ArrayList
        for (int i = 1; i <= numNinnos; i++) { // añadir niños
            ninnos.add(i);
        }
        int i = -1; // inicializar cuenta
        while (ninnos.size()>1) { // mientras queden niños
            i = (i + salto + 1) % ninnos.size(); // decidir cual es el siguietne salvado
            ninnos.remove(i); // quitarlo de la lista
            i--; // ajustar el indice porque he quitado a un niño
        }
        System.out.println(ninnos.get(0)); // Imprimir el numeral del niño que queda
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean esCasoNormal;
        do {
            esCasoNormal = caso();
        } while (esCasoNormal);
    }
    
}
