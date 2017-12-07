import java.util.*;
/**
 * Acepta el reto 143 Tortitas
 * @author victor
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    
    public static boolean caso() {
        Deque<Integer> tortitas = new ArrayDeque<>();  // La pila de tortitas
        List<Integer> temp = new ArrayList<>(); // Una lista auxiliar para hacer el voltero
        int tamanno; // lectura de la pila de tortitas
        do {
            tamanno = in.nextInt(); // leer tamaño
            if (tamanno >= 0) { // Si no es el centinela -1
                tortitas.push(tamanno); // a la pila
            }
        } while (tamanno >= 0); // mientras no es el centinela -1
      
        if (tortitas.size() == 0) { // Si no hay tortitas, es el caso especial de fin
            return false;
        }

        int numCambios = in.nextInt(); // leer numero de cambios cambios
        for (int i = 1; i <= numCambios; i++) {
            int cambios = in.nextInt(); // leer cambio
            for (int j = 1; j <= cambios; j++) { // sacar tortita de la pila y meterla en la lista
                temp.add(tortitas.pop());
            }
            for (int j = 0; j < temp.size(); j++) { 
                tortitas.push(temp.get(j)); // Sacar tortita de la lista y meterla en la pila
            }
            temp.clear(); // limpiar lista
        }
        System.out.println(tortitas.peek()); // imprimir el tamaño de la tortita de arriba.
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (caso());
    }
    
}
