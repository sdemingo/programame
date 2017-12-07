
/* 
   Un hombre solo se puede emparejar con la primera mujer que encuentre
   y que corresponda a su talla. Cuando se hace una pareja abandona el tren,
   permitiendo que otros hombres avancen.
*/

/**
 * 
 * Acepta el reto 145 El tren del amor
 * @author victor
 * @version dic/2017
 */
import java.util.*;
public class Main {
    static Scanner in;
    public static void caso() {
        String tren = in.nextLine();
        Deque<Character> pilaHombres = new ArrayDeque<>();
        // Sinceramente, he hecho trampas: he consultado la solución de ALFONSO++
        // porque no había entendido bien la dinámica del avance de los hombres.
        // Gracias, Alfonso. https://github.com/alfonsoelmas/AceptaElReto/blob/master/145.cpp
        int parejas = 0;
        for (int i = 0; i < tren.length(); i++) {
            char c = tren.charAt(i);
            switch(c) {
                case 'H':
                case 'h':
                    pilaHombres.push(c); // Los hombres van a una pila. Solo se puede emparejar el último
                    break;
                case '@':
                    pilaHombres.clear(); // Los hombres no pueden pasar.
                    break;
                case 'M':
                    if (!pilaHombres.isEmpty()) {
                        if (pilaHombres.pop().equals('H')) { //Si ha llegado un hombre alto
                            parejas++; // se empareja y los otros hombres siguen avanzando
                        } else {
                            pilaHombres.clear(); // Ningun hombre puede avanzar. La pareja los bloquea
                        }
                    }
                    break;
                case 'm': // idem para mujer baja
                    if (!pilaHombres.isEmpty()) {
                        if (pilaHombres.pop().equals('h')) {
                            parejas++;
                        } else {
                            pilaHombres.clear();
                        }
                    }       
            }
        }
        System.out.println(parejas);
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        while (in.hasNextLine()) {
            caso();
        }
    }
    
}
