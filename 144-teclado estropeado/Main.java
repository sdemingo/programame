import java.util.*;
/**
 * Acepta el reto 144 Teclado estropeado
 * @version Dic/2017
 * @author victor
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    
    public static void caso() {
        String linea = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int index = 0; // posición de inserción
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            switch(c) {
                case '-' :
                    index = 0;
                    break;
                case '+' :
                    index = sb.length();
                    break;
                case '3':
                    if (index < sb.length()) {
                        sb.deleteCharAt(index);
                    }
                    break;
                case '*':
                    if (index < sb.length()) {
                        index++;
                    }
                    break;
                default:
                    sb.insert(index, c);
                    index++;
            }
        }
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        while (in.hasNextLine()) {
            caso();
        }
    }
    
}
