import java.util.*;
/**
 * Acepta el reto <strong>343: Siete de un golpe</strong><br>
 * https://www.aceptaelreto.com/problem/statement.php?id=343<br>
 * <br>
 * El problema tiene restricciones de tiempo y memoria.<br>
 * Solución utilizando <a href="https://en.wikipedia.org/wiki/Dynamic_programming">programación dinámica</a> (DP).<br>
 * <br>
 * Inicializacion:
 * <ul>
 *   <li>En memoria sólo hay my filas, recogidas en el array t</li>
 *   <li>Tras leer las primeras my filas se suman las moscas en las columnas de t y se almacenan en suma</li>
 * </ul>
 * <br>
 * Lectura de filas a partir de la número my:<br>
 * Nota: Se utilizan las filas de t como una cola circular de filas de tamaño fijo a my.
 *       siguienteY indica el índice del primero (y la siguiente posición a insertar) de la cola
 * <ul>
 *   <li>Se lee la fila, y se va actualizando suma, restando las moscas de la fila que se va, y sumando
 *   las de la fila que entra. Este el punto principal de DP, junto con la eliminación de datos innecesarios al
 *   utilizar la cola circular.</li>
 * 
 *   <li>Aprovechando el recorrido horizontal, se calcula el número de moscas que atraparía el matamoscas
 *   También se usa DP para esto, restando el componente de la suma que sale del ambito del matamoscas y sumando
 *   el nuevo componente en el que entra el matamoscas.</li>
 * </ul>
 * 
 * @author Victor
 * @version 2016-03-17
 */
public class Main {
    
    static Scanner in = new Scanner(System.in);

    public static boolean  casoPrueba() {
        Scanner tok = new Scanner(in.nextLine());
        int tx = tok.nextInt();
        int ty = tok.nextInt();
        int mx = tok.nextInt();
        int my = tok.nextInt();
        if ((mx | my | tx | ty) == 0) return false;

        int moscasMuertas[]=new int[8]; 
        int t[][]=new int[tx][my]; // El trozo de mesa necesario para ir calculando
        int suma[] = new int[tx]; // La suma de las columnas de t
        int siguienteY = 0; // Siguiente fila a meter en t

        for(int y = 0; y < ty; y++) { 
            String fila = in.nextLine();
            int moscas = 0; 
            for (int x = 0; x < tx; x++) {
                if (y >= my) {
                    suma[x] -= t[x][siguienteY]; // restar a la suma la fila que va a ser sustituida
                }
                int hayMosca = fila.charAt(x) == 'X' ? 1 : 0; // 1 si hay mosca; 0 si no hay
                t[x][siguienteY] = hayMosca; // Sustituir valor
                suma[x] += hayMosca; // añadir a la suma el valor recién leido

                if (y >= my -1 ) { // A partir de la fila my-1 empezar a contar moscas cubiertas por matamoscas
                    moscas += suma[x];  // sumar la nueva columna cubierta por matamoscas
                    if (x >= mx) {  // restar el valor de suma que abandona la zona cubierta por matamoscas
                        moscas -= suma[x - mx];
                    }
                    if (x >= mx - 1) { // Solo contamos cuando el bucle alcanza mx-1, que es lo que cubre el matamoscas
                        if (moscas <= 7) {
                            moscasMuertas[moscas]++;
                        };             
                    }
                }
            }
            siguienteY = (siguienteY + 1) % my; // Siguiente fila en cola circular
        }
        for (int i = 0; i < 8; i++) { // Imprimir resultados
            System.out.format("%d%s", moscasMuertas[i], i < 7 ? " " : "\n");
        }
        return true;
    }

    public static void main(String[] args) {
        while (casoPrueba()) {
        }
    }
}
