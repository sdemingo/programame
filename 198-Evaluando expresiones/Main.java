/**
 * Acepta el reto 198: Evaluando expresiones.
 * 
 * Solución Quick & Dirty: he programado la evaluación con la pila, que es un
 * problema bien conocido (notación polaca inversa) y he hecho un copypasta para
 * la cola.
 * Los métodos devuelven null si hay error.
 * 
 * @author Victor
 * @version 2015-03-13
 */
import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static Integer pruebaPila(String expr) {
        Deque <Integer> d = new ArrayDeque<>();
        boolean error = false;
        for (char c: expr.toCharArray()) {
            if (Character.isDigit(c)) {
                int n = Integer.parseInt(""+c);
                d.addFirst(n);
            } else {
                if (d.size()<2) {
                    return null;
                }
                int n2 = d.removeFirst();
                int n1 = d.removeFirst();
                int n3 = 0;
                switch(c) {
                    case '+': n3 = n1 + n2; break;
                    case '-': n3 = n1 - n2; break;
                    case '*': n3 = n1 * n2; break;
                    case '/': if (n2 == 0) {return null;}
                    n3 = n1 / n2; break;
                }
                d.addFirst(n3);
            }
        }
        return d.size() == 1?d.removeFirst():null;
    }

    public static Integer pruebaCola(String expr) {
        Deque <Integer> d = new ArrayDeque<>();
        boolean error = false;
        for (char c: expr.toCharArray()) {
            if (Character.isDigit(c)) {
                int n = Integer.parseInt(""+c);
                d.addFirst(n);
            } else {
                if (d.size()<2) {
                    return null;
                }
                int n2 = d.removeLast();
                int n1 = d.removeLast();

                int n3 = 0;
                switch (c) {
                    case '+': n3 = n1 + n2; break;
                    case '-': n3 = n1 - n2; break;
                    case '*': n3 = n1 * n2; break;
                    case '/': if (n2 == 0) {return null;}
                    n3 = n1 / n2; break;
                }
                d.addFirst(n3);
            }
        }
        return d.size() == 1?d.removeFirst():null;
    }

    public static void casoPrueba() {
        String expr = in.nextLine();
        Integer i1 = pruebaPila(expr);
        Integer i2 = pruebaCola(expr);

        System.out.print(i1==null?"ERROR":i1);
        System.out.print(i1==i2?" = ": " != ");
        System.out.print(i2==null?"ERROR":i2);        
        System.out.println();
    }

    public static void main(String[] args) {
        while (in.hasNextLine()) {
            casoPrueba();
        }
    }
}