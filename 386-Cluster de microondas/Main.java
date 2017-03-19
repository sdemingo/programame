/**
 * Acepta el reto 386: Cluster de microondas.
 * 
 * Solución propuesta: explorar posibles soluciones en una búsqueda dicotómica.
 * 
 * Sabiendo que el peor caso es que se se necesiten 50000 microondas, uno para cada posible alumno,
 * para cada caso se exploran las soluciones entre 1 microondas y 50000 microondas, buscando el
 * menor número de microondas para un caso.
 * 
 * Se tienen importantes restricciones de tiempo, así que para acelerar, se propone una búsqueda
 * dicotómica de la solución del caso en el espacio de soluciones.
 * 
 */
import java.util.*;

public class Main {
    static java.util.Scanner in;
    // Una cola de prioridad, para saber cuál es el siguiente microondas a 
    // utilizar. En cada microondas se almacena el instante de tiempo en el que se terminó
    // de calentar la última comida.
    static Queue<Integer> cluster= new PriorityQueue<>();

    /**
     * 
     */
    public static boolean prueba(int numMic, int maxTiempo, int[][] cola) {
        cluster.clear();
        for (int i = 0 ; i< numMic; i++) {
            cluster.add(0);
        }
        for (int i = 0; i < cola.length; i++) { // Para cada alumno
            int instante = cola[i][0];
            int tiempo = cola[i][1];

            int micro = cluster.poll(); // Sacar el microondas con menor tiempo

            if (micro - instante > maxTiempo ) { // Si el alumno tiene que esperarlo más que el máximo
                return false;                    // necesitamos más microondas.
            }
            if (micro < instante) {        // si el microondas ya ha terminado
                micro = instante + tiempo; // calcular cuándo terminará tras calentar la comida del alumno ahora
            } else {                       // si no
                micro += tiempo;           // calcular cuándo terminará si el alumno calienta la comida tras 
            }                              // terminar el que está ahora.
            cluster.add(micro);            // volver a meter este micro en la cola de prioridad
        }
        return true;
    }

    public static boolean caso(){
        int n = in.nextInt();
        int t = in.nextInt();

        if(n + t ==0) return false;

        int[][] cola = new int[n][2];   // leer y almacenar datos de alumnos
        for (int i = 0; i < n; i++) {
            cola[i][0] = in.nextInt();
            cola[i][1] = in.nextInt();
        }

        int min=0;   // búsqueda dicotómica en el espacio entre 0 y 50001 ambos excluídos.
        int max=50001;
        while (max-min>1) {
            int med = min + (max - min) /2;
            boolean pMed = prueba(med, t, cola);
            if (pMed) {
                max = med;
            } else {
                min = med;
            }         
        }
        System.out.println(max);
        return true;
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while(caso());
    }
}