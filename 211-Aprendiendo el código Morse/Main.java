/**
 * Acepta el reto 211: Aprendiendo el código Morse.
 */
import java.util.*;

public class Main {
    static java.util.Scanner in;
    static String[] morse={
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."};
    

    public static boolean caso(){
        if(!in.hasNext()) return false;
        String palabra = in.next();
        String inicialMorse = morse[Character.toUpperCase(palabra.charAt(0))-'A'];
        String resul = "";
        for (int i = 0; i < palabra.length(); i++) {
            char c = Character.toUpperCase(palabra.charAt(i));
            if (c == 'O') {
                resul+='-';
            } else if ("AEIU".indexOf(c)>=0) {
                resul+='.';
            }
        }
        System.out.format("%s %s%n", palabra, inicialMorse.equals(resul) ? "OK" : "X");
        return true;
    }

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while(caso());
    }
}